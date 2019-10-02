import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Examples {
    public static void main(String[] args) {
        new Examples().execute();
    }

    private void execute() {
        List<String> names = Arrays.asList("Juan", "Luis", "Maria", "Janet", "Carlos");
        Optional<String> name = names.stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.startsWith("j"))
                .findFirst();
        System.out.println(name.orElse("No existe"));

    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

}
