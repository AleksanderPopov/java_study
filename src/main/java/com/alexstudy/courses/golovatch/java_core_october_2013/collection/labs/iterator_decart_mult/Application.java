package golovatch.courses.collection.labs.iterator_decart_mult;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Alex on 12/13/2016.
 */
public class Application {

    public static void main(String[] args) {
        List<String> first = new LinkedList<>();
        List<String> second = new LinkedList<>();

        first.add("1");
        first.add("2");
        first.add("3");
        first.add("4");
        second.add("5");
        second.add("6");

        List<List<String>> def = prod(first, second);
        System.out.println(Arrays.deepToString(def.toArray()));
        Iterator<List<String>> iter = prod1(first, second);
        while (iter.hasNext()) System.out.print(Arrays.deepToString(iter.next().toArray()));

    }

    private static Iterator<List<String>> prod1(final List<String> first, final List<String> second) {

        return new Iterator<List<String>>() {
            Iterator<String> ifirst = first.iterator();
            Iterator<String> isecond = second.iterator();
            String ifirstValue = ifirst.next();
            @Override
            public List<String> next() {
                if (isecond.hasNext()) return Arrays.asList(ifirstValue, isecond.next());
                else {
                    isecond = second.iterator();
                    if (ifirst.hasNext()) ifirstValue = ifirst.next();
                    else throw new UnsupportedOperationException();
                    return Arrays.asList(ifirstValue, isecond.next());
                }
            }

            @Override
            public boolean hasNext() {
                return ifirst.hasNext() || isecond.hasNext();
            }
        };
    }
    
    private static List<List<String>> prod(List<String> first, List<String> second) {
        List<List<String>> result = new LinkedList<>();
        
        for (String x : first) {
            for (String y : second) {
                result.add(asList(x, y));
            }
        }
        return result;
    }
}
