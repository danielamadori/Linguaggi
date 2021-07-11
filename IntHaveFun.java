import value.*;

import java.util.*;


public class IntHaveFun extends HaveFunBaseVisitor<Value>{
    private final Conf conf;

    public IntHaveFun(Conf conf) {
        this.conf = conf;
    }

    private ComValue visitCom(HaveFunParser.ComContext ctx) {
        return (ComValue) visit(ctx);
    }

    private void visitFun(List<HaveFunParser.FunContext> ctx) {
        for(HaveFunParser.FunContext context : ctx)
            visit(context);
    }

    private ExpValue<?> visitExp(HaveFunParser.ExpContext ctx) {
        return (ExpValue<?>) visit(ctx);
    }

    private int visitNatExp(HaveFunParser.ExpContext ctx) {
        try {
            return ((NatValue) visitExp(ctx)).toJavaValue();
        } catch (ClassCastException e) {
            System.err.println("Type mismatch exception!");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.err.println(ctx.getText());
            System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<");
            System.err.println("> Natural expression expected.");
            System.exit(1);
        }

        return 0; // unreachable code
    }

    private boolean visitBoolExp(HaveFunParser.ExpContext ctx) {
        try {
            return ((BoolValue) visitExp(ctx)).toJavaValue();
        } catch (ClassCastException e) {
            System.err.println("Type mismatch exception!");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());
            System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>");
            System.err.println(ctx.getText());
            System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<");
            System.err.println("> Boolean expression expected.");
            System.exit(1);
        }

        return false; // unreachable code
    }

    @Override
    public ComValue visitProg(HaveFunParser.ProgContext ctx) {
        visitFun(ctx.fun());
        return visitCom(ctx.com());
    }

    @Override
    public ComValue visitIf(HaveFunParser.IfContext ctx) {
        return visitBoolExp(ctx.exp())
                ? visitCom(ctx.com(0))
                : visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitAssign(HaveFunParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        ExpValue<?> v = visitExp(ctx.exp());

        conf.updateVariable(id, v);

        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSkip(HaveFunParser.SkipContext ctx) {
        return ComValue.INSTANCE;
    }

    @Override
    public ComValue visitSeq(HaveFunParser.SeqContext ctx) {
        visitCom(ctx.com(0));
        return visitCom(ctx.com(1));
    }

    @Override
    public ComValue visitWhile(HaveFunParser.WhileContext ctx) {
        if (!visitBoolExp(ctx.exp()))
            return ComValue.INSTANCE;

        visitCom(ctx.com());

        return visitWhile(ctx);
    }

    @Override
    public ComValue visitOut(HaveFunParser.OutContext ctx) {
        System.out.println(visitExp(ctx.exp()));
        return ComValue.INSTANCE;
    }

    @Override
    public NatValue visitNat(HaveFunParser.NatContext ctx) {
        return new NatValue(Integer.parseInt(ctx.NAT().getText()));
    }

    @Override
    public BoolValue visitBool(HaveFunParser.BoolContext ctx) {
        return new BoolValue(Boolean.parseBoolean(ctx.BOOL().getText()));
    }

    @Override
    public ExpValue<?> visitParExp(HaveFunParser.ParExpContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public NatValue visitPow(HaveFunParser.PowContext ctx) {
        int base = visitNatExp(ctx.exp(0));
        int exp = visitNatExp(ctx.exp(1));

        return new NatValue((int) Math.pow(base, exp));
    }

    @Override
    public BoolValue visitNot(HaveFunParser.NotContext ctx) {
        return new BoolValue(!visitBoolExp(ctx.exp()));
    }

    @Override
    public NatValue visitDivMulMod(HaveFunParser.DivMulModContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        switch (ctx.op.getType()) {
            case HaveFunParser.DIV :  return new NatValue(left / right);
            case HaveFunParser.MUL : return new NatValue(left * right);
            case HaveFunParser.MOD : return new NatValue(left % right);
            default : return null;
        }
    }

    @Override
    public NatValue visitPlusMinus(HaveFunParser.PlusMinusContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        switch (ctx.op.getType()) {
            case HaveFunParser.PLUS : return new NatValue(left + right);
            case HaveFunParser.MINUS : return new NatValue(Math.max(left - right, 0));
            default : return null;
        }
    }

    @Override
    public BoolValue visitEqExp(HaveFunParser.EqExpContext ctx) {
        ExpValue<?> left = visitExp(ctx.exp(0));
        ExpValue<?> right = visitExp(ctx.exp(1));
        switch (ctx.op.getType()) {
            case HaveFunParser.EQQ : return new BoolValue(left.equals(right));
            case HaveFunParser.NEQ : return new BoolValue(!left.equals(right));
            default : return null; // unreachable code
        }
    }

    @Override
    public ExpValue<?> visitId(HaveFunParser.IdContext ctx) {
        String id = ctx.ID().getText();

        if (!conf.containsVariable(id)) {
            System.err.println("Variable " + id + " used but never instantiated");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());

            System.exit(1);
        }

        return conf.getVariable(id);
    }

    @Override
    public BoolValue visitCmpExp(HaveFunParser.CmpExpContext ctx) {
        int left = visitNatExp(ctx.exp(0));
        int right = visitNatExp(ctx.exp(1));

        switch (ctx.op.getType()) {
            case HaveFunParser.GEQ : return new BoolValue(left >= right);
            case HaveFunParser.LEQ : return new BoolValue(left <= right);
            case HaveFunParser.LT  : return new BoolValue(left < right);
            case HaveFunParser.GT  : return new BoolValue(left > right);
            default : return null;
        }
    }

    @Override
    public BoolValue visitLogicExp(HaveFunParser.LogicExpContext ctx) {
        boolean left = visitBoolExp(ctx.exp(0));
        boolean right = visitBoolExp(ctx.exp(1));

        switch (ctx.op.getType()) {
            case HaveFunParser.AND : return new BoolValue(left && right);
            case HaveFunParser.OR : return new BoolValue(left || right);
            default : return null;
        }
    }

    @Override
    public Value visitDeclaration(HaveFunParser.DeclarationContext ctx) {
        String name = ctx.ID(0).getText();

        Set<String> parameters = new LinkedHashSet<>();
        for(int i = 1; i < ctx.ID().size(); i++)
            if(!parameters.add(ctx.ID(i).getText())){
                System.err.println("Parameter name '" + ctx.ID(i).getText() + "' clashes with previous parameters");
                System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());

                System.exit(1);
            }

        FunValue f = new FunValue(name, parameters.toArray(new String[parameters.size()]), ctx.com(), ctx.exp());

        if(!conf.containsFun(f.name))
            conf.updateFun(f.name, f);
       else {
           System.err.println("The function " + f.name + " was already declared!");
           System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());

           System.exit(1);
        }

        return null;
    }

    @Override
    public ExpValue<?> visitCall(HaveFunParser.CallContext ctx) {
        String name = ctx.ID().getText();

        if(!conf.containsFun(name)){
            System.err.println("Function '" + name + "' used but never declared");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());

            System.exit(1);
        }

        FunValue callingFunction = conf.getFun(name);
        if(callingFunction.parameters.length != ctx.exp().size()) {
            System.err.println("Function '" + callingFunction.name + "' called with the wrong number of arguments");
            System.err.println("@" + ctx.start.getLine() + ":" + ctx.start.getCharPositionInLine());

            System.exit(1);
        }

        Conf newConf = new Conf();
        for(int i = 0; i < callingFunction.parameters.length; i++)
            newConf.updateVariable(callingFunction.parameters[i], visitExp(ctx.exp(i)));

        IntHaveFun newIntHaveFun = new IntHaveFun(newConf);
        if(callingFunction.body != null)
            newIntHaveFun.visitCom(callingFunction.body);

        return newIntHaveFun.visitExp(callingFunction.expReturn);
    }
}
