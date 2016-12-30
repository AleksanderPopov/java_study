package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_19;

/**
 * Created by apop on 12/6/2016.
 */
public class Utilities {

    public char[] everyNthChar(char[] source, int n) {
        if (source == null || source.length < n) return source;

        int size = source.length / n;
        char[] result = new char[size];
        for (int i = n-1, resultCount = 0; i < source.length || resultCount < result.length; i+=n, resultCount++) {
            result[resultCount] = source[i];
        }
        return result;
    }


    public String removePairs(String source) {
        if (source == null || source.isEmpty()) return source;
        if (source.length() < 2) return source;

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length; i++) {
            if (i == string.length - 1) {
                sb.append(string[i]);
                break;
            }
            if (string[i] != string[i + 1]) sb.append(string[i]);
        }
        return sb.toString();
    }

    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source == null) return source;
        if (source.length() % 2 == 0) return source;
        return null;
    }
}
