package golovatch.courses.io;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by Alex on 8/28/2016.
 */
public class CharsetDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        char c1 = 65;
        System.out.println("was char " + c1);
        byte[] bytes = Character.toString(c1).getBytes("UTF-8");
        System.out.println("this char was divided to byte array: " + Arrays.toString(bytes));
        char[] chars = Charset.forName("UTF-8").decode(ByteBuffer.wrap(bytes)).array();
        char c2 = chars[0];
        System.out.println("byte array was decoded to char " + c2);
    }
}
