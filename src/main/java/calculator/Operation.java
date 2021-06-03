package calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    private final String value;
    private static final Map<String, Operation> lookup = new HashMap<>();

    static {
        for (Operation o : Operation.values()) {
            lookup.put(o.getValue(), o);
        }
    }

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation get(String value) {
        return lookup.get(value);
    }

    public int apply(int a, int b) {
        switch (this) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
        }
        throw new AssertionError("Invalid operation: " + this);
    }

    @Override
    public String toString() {
        return value;
    }
}