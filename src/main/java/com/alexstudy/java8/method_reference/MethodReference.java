package com.alexstudy.java8.method_reference;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Supplier;

/**
 * Created by apop on 4/13/2017.
 */
public class MethodReference {
    public static void main(String[] args) {
        User[] users = {};

        // sort with non static method reference
        UserComparator userComparator = new UserComparator();
        Arrays.sort(users, userComparator::compare);

        // sort with static method reference
        Arrays.sort(users, UserComparator::compareByName);

        // constructor reference
//        HashSet<User> userHashSet = transferElements(Arrays.asList(users), () -> new HashSet<User>());
        HashSet<User> userHashSet = transferElements(Arrays.asList(users), HashSet::new);
    }

    private static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(SOURCE source, Supplier<DEST> destination) {
        DEST result = destination.get();
        result.addAll(source);
        return result;
    }
}

class UserComparator implements Comparator<User> {

    public static int compareByName(User u1, User u2) {
        return u1.name.compareTo(u2.name);
    }

    @Override
    public int compare(User o1, User o2) {
        return o1.name.compareTo(o2.name);
    }

}

class User {
    public String name;
    public LocalDate birthdate;
}
