package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_17.lambda_challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by apop on 11/18/2016.
 */
public class Challenge {
    // Consumer
    private static Runnable runnable2 = () -> {
        String myString = "Let's split this up into an array";
        String[] parts = myString.split(" ");
        Arrays.stream(parts).forEach(System.out::println);
    };
    //Supplier
    private static Supplier<String> iLoveJava = () -> "I Love Java.";
    //Function
    private static Function<String, String> f = (src) -> {
        String result = "";
        for (int i = 0; i < src.length(); i++) if (i % 2 == 1) result += src.charAt(i);
        return result;
    };
    // Predicate
    private static Predicate<String> isContainsAletter = (s) -> s.contains("A");

    private static Callable<String> callable = () -> "this is callable";
    private Comparator<String> comparable = String::compareTo;

    private static void challenge1() {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) System.out.println(part);
            }
        };
        new Thread(runnable2).start();
    }

    private static String challenge2(String source) {
//        String result = "";
//        for (int i = 0; i < source.length(); i++) if (i % 2 != 1) result += source.charAt(i);
//        return result;
        return f.apply(source);
    }

    private static String challenge4(Function<String, String> func, String value) {
        return func.apply(value);
    }

    private static void challenge10() {
        List<String> names = Arrays.asList("Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "Jacob");
        names
                .stream()
                .map((name) -> name.substring(0, 1).toUpperCase().concat(name.substring(1)))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count();
    }

    public static void main(String[] args) throws Exception {
        challenge10();
    }
}
