import value.ExpValue;

import java.util.HashMap;
import java.util.Map;

public class Conf {
    private final Map<String, ExpValue<?>> map = new HashMap<>();

    private static final Map<String, FunValue> fun = new HashMap<>();

    public boolean containsVariable(String id) { return map.containsKey(id); }

    public ExpValue<?> getVariable(String id) {
        return map.get(id);
    }

    public void updateVariable(String id, ExpValue<?> v) {
        map.put(id, v);
    }

    public Boolean containsFun(String id) { return fun.containsKey(id);}

    public FunValue getFun(String id) {
        return fun.get(id);
    }

    public void updateFun(String id, FunValue f){ fun.put(f.name, f); }
}
