package golovatch.courses.collection;

import java.util.*;

/**
 * Created by Alex on 12/18/2016.
 */
public class GenericsDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(10);
//        for (int i = 0; i <= 20; i++) list.add("" + i);
//        printCollection(list);

//        List<Parent> listP = new ArrayList<>();
//        listP.add(new Parent());
//        List<Child> listC = new ArrayList<>();
//        listC.add(new Child());
//        List<GrandChild> listG = new ArrayList<>();
//        listG.add(new GrandChild());
//        printParents(listG);

//        Parent[] strs = new Parent[]{new Parent(), new Parent(), new Parent()};
//        Collection<Parent> strc = new ArrayList<>();
//        arrToColl(strs, strc);
//        System.out.println(strc);

        List<Parent> listP = new ArrayList<>();
        listP.add(new Parent());
        List<Child> listC = new ArrayList<>();
        listC.add(new Child());
        copy(listC, listP);

    }

    private static void copyRaw(Collection from, Collection dest) { for (Object e : from) dest.add(e); }
    private static <T> void copy(Collection<? extends T> from, Collection<T> dest) {
        for (T e : from) dest.add(e); }

    private static void printParents(Collection<? extends Parent> c) {
        for (Parent p : c) System.out.println(p);
    }

    private static <T> void arrToColl(T[] arr, Collection<T> col) {
        for (T e : arr) col.add(e);
    }

}

class Parent {
    @Override
    public String toString() {
        return "Parent";
    }
}

class Child extends Parent {
    @Override
    public String toString() {
        return "Child";
    }
}

class GrandChild extends Child {
    @Override
    public String toString() {
        return "GrandChild";
    }
}


