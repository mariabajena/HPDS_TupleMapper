import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Functions {

    public static void main(String[] args) {
        Predicate<Integer> even = v -> v % 2 == 0;

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream()
                .filter(even)
                .collect(toList());


        for (Integer evenNumber : evenNumbers) {
            System.out.println(evenNumber);
        }
    }
}
