import java.util.List;

public class Application {
    public static void main(String[] args) {
        List.of(1,2,3)
                .stream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
