package calculator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    private Queue<Integer> numbers;
    private Queue<String> operations;
    private static final Set<String> OPERATION_VALUES = Stream.of(Operation.values())
            .map(Operation::getValue)
            .collect(Collectors.toSet());

    public StringCalculator() {
        numbers = new ArrayDeque<>();
        operations = new ArrayDeque<>();
    }

    public void execute() {
        setUp();
        int result = calculate();
        System.out.print(result);
    }

    private int calculate() {
        int result = 0;
        int a = numbers.poll();
        while (!numbers.isEmpty() && !operations.isEmpty()) {
            Operation op = Operation.get(operations.poll());
            int b = numbers.poll();
            result = op.apply(a, b);
            a = result;
        }
        return result;
    }

    private void setUp() {
        String[] values = getUserInput();
        validateInput(values);
        organizeNumbersAndOperations(values);
    }

    private void validateInput(String[] values) {
        if (values.length < 3) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }

    private String[] getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.split(" ");
    }

    private void organizeNumbersAndOperations(String[] values) {
        for (String value : values) {
            if (OPERATION_VALUES.contains(value)) {
                operations.add(value);
            } else {
                numbers.add(Integer.parseInt(value));
            }
        }
    }

}
