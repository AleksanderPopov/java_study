package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_18;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 11/19/2016.
 */
public class Challenge {
    public static void main(String[] args) {
        System.out.println("I want a bike.".matches(".*"));

        System.out.println("I want a bike.".matches(".*b\\D{4}"));
        System.out.println("I want a ball.".matches(".*b\\D{4}"));

        Pattern pattern = Pattern.compile(".*b(ike|all).");
        System.out.println(pattern.matcher("I want a bike.").matches());
        System.out.println(pattern.matcher("I want a ball.").matches());

        System.out.println("==============================");
        System.out.println("Replace all spaces with underscores.".replaceAll(" ", "_"));
        System.out.println("==============================");
        System.out.println("aaaabcccdddefffg".matches("a+b*c+d+e*f+g"));
        System.out.println("==============================");
        System.out.println("abcde.1234".matches("\\D+\\.\\d+"));
        System.out.println("==============================");

        Pattern pattern1 = Pattern.compile("\t?\\D+\\.(\\d+)\n?");
        Matcher matcher = pattern1.matcher("abcd.12345\tasdasdasd.123\ta.1\n");
//        System.out.println(matcher.matches());
//        System.out.println(matcher.groupCount());
        while (matcher.find()) {
//            System.out.println(matcher.group(1));
            System.out.println("Start - " + matcher.start(1) + " end is " + matcher.end(1));
        }
        System.out.println("==============================");

        String challenge11 = "{2,3}, {0,76}, {11,1}, {5,2}, {0,8}, {1,2}";
        Pattern pattern11 = Pattern.compile("\\{(\\d*),(\\d*)\\},? ?");
        Matcher matcher11 = pattern11.matcher(challenge11);
//        System.out.println(matcher11.matches());
        while (matcher11.find()) {
            System.out.println(matcher11.group(1) + " " + matcher11.group(2));
        }
        System.out.println("==============================");

//        String challenge12 = "12345";
        String challenge12 = "12345-0000";
//        String challenge12 = "12345-1";
        Pattern pattern12 = Pattern.compile("^\\d{5}(-\\d{4})?$");
        Matcher matcher12 = pattern12.matcher(challenge12);
        System.out.println(matcher12.matches());

    }


}
