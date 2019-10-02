import java.util.stream.Stream;

import static java.lang.Integer.parseInt;
import static java.util.stream.IntStream.iterate;

public class NumberBreaker {
    private static final int MIN = 0;
    private static final int MAX = 4000;
    private final int number;

    public NumberBreaker(int number) {
        this.number = number;
    }

    public int[][] breakdown(){
        return isOutOfRange() ? null : stream()
                .map(this::tuple)
                .filter(this::isNotZero)
                .toArray(int[][]::new);
    }

    private boolean isOutOfRange() {
        return number <= MIN || number >= MAX;
    }

    private String number() {
        return String.valueOf(number);
    }

    private boolean isNotZero(int[] tuple) {
        return tuple[0] != 0;
    }

    private int[] tuple(Integer i) {
        return new int[] {
                parseInt(number().substring(i,i+1)),
                number().length() - 1 - i
        };
    }

    private Stream<Integer> stream() {
        return iterate(0, l -> l + 1)
                .limit(number().length())
                .boxed();
    }



}
