package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_18;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 11/19/2016.
 */
public class PatternMatcherDemo {
    public static void main(String[] args) throws IOException {
        // find div tag occurrences

        URL google = new URL("https://google.com");
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        InputStream in = google.openStream();
        byte[] buff = new byte[255];

        while (in.read(buff) != -1) {
            bout.write(buff);
        }
        bout.flush();
        in.close();
        String html = new String(bout.toByteArray(), Charset.forName("UTF-8"));
        bout.close();
        System.out.println(html);

        Pattern pattern = Pattern.compile("</?div");
        Matcher matcher = pattern.matcher(html);

        int occurrence = 0;
        while (matcher.find()) {
            System.out.format("\nFound occurrence N='%d', start='%d', end='%d'", occurrence++, matcher.start(), matcher.end());
        }

        occurrence = 0;
        Pattern groupPattern = Pattern.compile("(<span.*?</span>)");
        Matcher groupMatcher = groupPattern.matcher(html);

        while (groupMatcher.find()) {
            System.out.printf("\nFound occurrence N='%d', text is '%s'", occurrence++, groupMatcher.group(1));
        }


        occurrence = 0;
        Pattern textGroupsPattern = Pattern.compile("(<span.*?>)(.+?)(</span>)");
        Matcher textGroupsMatcher = textGroupsPattern.matcher(html);

        while (textGroupsMatcher.find()) System.out.printf("\nFound occurrence N='%d'," +
                "\n group1='%s'," +
                "\n group2='%s'," +
                "\n group3='%s'\n",
                occurrence++, textGroupsMatcher.group(1), textGroupsMatcher.group(2), textGroupsMatcher.group(3));

        // "abc" regex = "a" AND "b" AND "c"
        // "[Hh]" regex = "H" OR "h"
        // "[^abc]" regex = NOT "a" OR NOT "b" OR NOT "c" (any character except these)
        // "t(?!v)" regex = "t" AND NOT "v" (any character or no character except "v" )

        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
    }
}
