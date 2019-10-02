import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class TuppleMapper_ {
    private final String roman;
    private final int[][] breakdown;

    public TuppleMapper_(int[][] breakdown, String roman) {
        this.breakdown = breakdown;
        this.roman = roman;
    }

    private final static String[][] Table = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}};

    public String MapTuple (int[][] tuple){
       return Arrays.stream(tuple).map(this::Function).collect(Collectors.joining(""));
    }

    private String Function(int[] t) {
        return Table[t[1]][t[0]];
    }

    @Parameterized.Parameters
    public static Object[][] cases() {
        return new Object[][]{
                {new int[][]{{1, 0}}, "I"},
                {new int[][]{{2, 0}}, "II"},
                {new int[][]{{1, 1}}, "X"},
                {new int[][]{{1, 1}, {1, 0}}, "XI"},
                {new int[][]{{2, 1}}, "XX"},
                {new int[][]{{8, 2}, {4, 1}, {4, 0}}, "DCCCXLIV"},
                {new int[][]{{3, 2}, {2, 0}}, "CCCII"}
        };
    }

    @Test
    public void execute() {
        assertThat(MapTuple(breakdown)).isEqualTo(roman);
    }


}