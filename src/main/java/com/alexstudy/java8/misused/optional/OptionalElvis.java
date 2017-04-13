package com.alexstudy.java8.misused.optional;


import com.alexstudy.java8.misused.User;

import static com.alexstudy.java8.misused.Annotations.Ugly;
import static com.alexstudy.java8.misused.Annotations.Good;
import static com.alexstudy.java8.misused.Annotations.Bad;
import static java.util.Optional.ofNullable;

public class OptionalElvis {
    @Ugly
    class BeforeJava8 {
        public String getUserName(User user) {
            return (user != null && user.getName() != null) ? user.getName() : "default";
        }
    }

    @Ugly
    class UsingOptionalIsPresent {
        public String getUserName(User user) {
            if (ofNullable(user).isPresent()) {
                if (ofNullable(user.getName()).isPresent()) {
                    return user.getName();
                }
            }
            return "default";
        }
    }

    @Good
    class UsingOrElse {
        public String getUserName(User user) {
            return ofNullable(user)
                    .map(User::getName)
                    .orElse("default");
        }
    }
}
