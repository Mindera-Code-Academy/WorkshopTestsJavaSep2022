package academy.mindswap.junit;

import java.util.List;
import java.util.Objects;

public class Calculator {

    private OtherClass otherClass;

    public Calculator(OtherClass otherClass) {
        this.otherClass = otherClass;
    }

    public int sum(Integer num1, Integer num2) {
        System.out.println("sum(" + num1 + ", " + num2 + ")");
        return num1 + num2;
    }

    public Integer multiplyEvenNumbers(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new ThisIsNotRightMateException();
        }
        Integer result = numbers.stream()
                .filter(number -> Objects.nonNull(number) && number % 2 == 0)
                .reduce(1, (acc, number) -> acc * number);

        return result == 1 ? 0 : result;
    }

    public String getRandomReference() {
        StringBuilder reference = new StringBuilder();
        for (Integer n : otherClass.getRandomNumbers(6)) {
            reference.append(n);
        }
        return reference.toString();
    }
}
