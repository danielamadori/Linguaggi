import value.Value;

public class FunValue extends Value {
    public String name;
    public String[] parameters;
    public HaveFunParser.ComContext body;
    public HaveFunParser.ExpContext expReturn;

    public FunValue(String name, String[] parameters, HaveFunParser.ComContext body, HaveFunParser.ExpContext expReturn) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
        this.expReturn = expReturn;
    }

    @Override
    public boolean equals(Object other) { return (other instanceof FunValue && ((FunValue) other).parameters.equals(this.parameters)); }

    @Override
    public int hashCode() { return  name.hashCode() * parameters.hashCode(); }
}
