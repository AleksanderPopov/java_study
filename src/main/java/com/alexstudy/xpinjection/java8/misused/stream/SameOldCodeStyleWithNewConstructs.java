package com.alexstudy.xpinjection.java8.misused.stream;

import com.alexstudy.xpinjection.java8.misused.User;

import static com.alexstudy.xpinjection.java8.misused.Annotations.Ugly;
import static com.alexstudy.xpinjection.java8.misused.Annotations.Good;
import static com.alexstudy.xpinjection.java8.misused.Annotations.Bad;
import java.util.Collection;
import java.util.Objects;

import static java.util.Optional.ofNullable;

public class SameOldCodeStyleWithNewConstructs {
    @Ugly
    class NoMoreThanSameOldLoopWithIf {
        public void registerUsers(Collection<User> users) {
            users.stream().forEach(user ->
                    ofNullable(user).ifPresent(u -> {
                        //register user
                    })
            );
        }
    }

    @Good
    class NewStreamStyleWithMethodReference {
        public void registerUsers(Collection<User> users) {
            users.stream()
                    .filter(Objects::nonNull)
                    .forEach(this::registerUser);
        }

        private void registerUser(User user){
            //register user
        }
    }
}
