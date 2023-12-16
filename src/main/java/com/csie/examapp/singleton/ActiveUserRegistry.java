package com.csie.examapp.singleton;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ActiveUserRegistry {

    private final Set<String> activeUsers = new HashSet<>();

    private ActiveUserRegistry() {
    }

    public static ActiveUserRegistry getInstance() {
        return ActiveUserRegistryHolder.INSTANCE;
    }

    public void registerUser(String eMail) {
        activeUsers.add(eMail);
    }

    public void unregisterUser(String eMail) {
        activeUsers.remove(eMail);
    }

    public int getActiveUserCount() {
        return activeUsers.size();
    }

    public Set<String> getActiveUsers() {
        return new HashSet<>(activeUsers);
    }

    private static class ActiveUserRegistryHolder {
        private static final ActiveUserRegistry INSTANCE = new ActiveUserRegistry();
    }
}
