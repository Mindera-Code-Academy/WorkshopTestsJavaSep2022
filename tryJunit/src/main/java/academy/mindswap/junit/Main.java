package academy.mindswap.junit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new OtherClass());
        System.out.println(String.format("%d + %d = %d", 5, 7, calculator.sum(5, 7)));
        System.out.println(String.format("Multiply even numbers result: %d",
                calculator.multiplyEvenNumbers(List.of(1, 2, 3, 4, 5, 6))));
        System.out.println(String.format("Random number - %s", calculator.getRandomReference()));
    }
}
