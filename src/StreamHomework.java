import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHomework {

    // завдання 1
    public static String oddIndexedNames(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> i + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    // завдання 2
    public static List<String> upperCaseSortedDesc(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    // завдання 3
    public static String sortedNumbers(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    // завдання 4
    public static Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, x -> Math.floorMod(a * x + c, m));
    }

    // завдання 5
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> it1 = first.iterator();
        Iterator<T> it2 = second.iterator();
        List<T> result = new ArrayList<>();

        while (it1.hasNext() && it2.hasNext()) {
            result.add(it1.next());
            result.add(it2.next());
        }

        return result.stream();
    }

    public static void main(String[] args) {
        List<String> names = List.of("Anna", "Ivan", "Olga", "Peter", "Maria", "John");

        System.out.println("Завдання 1: " + oddIndexedNames(names));

        System.out.println("Завдання 2: " + upperCaseSortedDesc(names));

        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println("Завдання 3: " + sortedNumbers(array));

        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        System.out.println("Завдання 4: " + randomStream(42, a, c, m)
                .limit(10)
                .collect(Collectors.toList()));

        System.out.println("Завдання 5: " + zip(
                Stream.of("A1", "A2", "A3", "A4"),
                Stream.of("B1", "B2", "B3"))
                .collect(Collectors.toList()));
    }
}
