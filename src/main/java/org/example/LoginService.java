package org.example;

@FunctionalInterface
public interface LoginService {
    String doLogin(String username);

    default void printer() {
        System.out.println("### Hello ###");
    }
}
