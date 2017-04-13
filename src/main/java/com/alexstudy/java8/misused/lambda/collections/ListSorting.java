package com.alexstudy.java8.misused.lambda.collections;

import com.alexstudy.java8.misused.Annotations;
import com.alexstudy.java8.misused.User;

import java.util.List;

import static java.util.Comparator.comparing;

public class ListSorting {
    @Annotations.Ugly
    class UsingCustomComparator {
        public void sortUsersById(List<User> users) {
            users.sort((x, y) -> Long.compare(x.getId(), y.getId()));
        }
    }

    @Annotations.Good
    class UsingExistingPredefinedComparator {
        public void sortUsersById(List<User> users) {
            users.sort(comparing(User::getId, Long::compareTo));
        }
    }
}
