package com.alexstudy.java8.misused.optional;

import com.alexstudy.java8.misused.User;

import static com.alexstudy.java8.misused.Annotations.Ugly;
import static com.alexstudy.java8.misused.Annotations.Good;
import static com.alexstudy.java8.misused.Annotations.Bad;
import java.util.Optional;

public class StrictCheckOfValuePresence {
    @Ugly
    class ManualCheckForPresenceToThrowException {
        public String getUserName(Long userId) {
            Optional<User> user = findById(userId);
            if (user.isPresent()) {
                return user.get().getName();
            }
            throw new IllegalStateException("User not found");
        }
    }

    @Good
    class OrElseThrowUsage {
        public String getUserName(Long userId) {
            return findById(userId)
                    .orElseThrow(() -> new IllegalStateException("User not found"))
                    .getName();
        }
    }

    private Optional<User> findById(Long userId) {
        //search in DB
        return Optional.of(new User(5L, "Mikalai"));
    }
}
