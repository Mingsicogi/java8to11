package org.example;

import java.util.function.Function;

public class Example01 {
    protected final static String a = "a";

    public static void main(String[] args) {

        String username = "minssogi";

        // using service implements class
        LoginService naverLogin = new NaverLoginServiceImpl();
        System.out.println(naverLogin.doLogin(username));

        // Using anonymous class
        LoginService googleLogin = new LoginService() {
            @Override
            public String doLogin(String username) {
                return "### Google Login Success : " + username;
            }
        };
        System.out.println(googleLogin.doLogin(username));

        // Lambda expression
        Function<String, String> facebookLogin = (id) -> "### Facebook Login Success : " + id;
        System.out.println(facebookLogin.apply(username));
        Function<String, String> twitterLogin = s -> "### Twitter Login Success : " + s;
        System.out.println(twitterLogin.apply(username));

        System.out.println("=========================================================");
        System.out.println(facebookLogin.andThen(twitterLogin).apply(username));

        System.out.println("=========================================================");
        Function<Integer, Integer> plus10 = value -> value + 10;
        Function<Integer, Integer> multiply2 = value -> value * 2;

        System.out.println(plus10.andThen(multiply2).apply(10));
        System.out.println(plus10.compose(multiply2).apply(10));

        System.out.println("=========================================================");
        Person person1 = new Person("a", 50);
        Person person2 = new Person("b", 39);


        TriFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a+b+c;
        System.out.println(sum.apply(1,2,3));
    }

    public static class Person {
        public String name;
        public Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
