package org.example;

import java.util.function.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        /**
         * CHAPTER 1 : start
         *  - functional interface and lambda expression
         *
         */
        // before java8
        DoSomething doSomething = new DoSomething() {
            @Override
            public void doIt() {
                System.out.println("Do something~~~~~~");
            }
        };
        doSomething.doIt();

        // after java8 => lambda
        // can return as a function = first class object
        DoSomething lambdaDoSomething = () -> System.out.println("Do something by lambda~~~~~~");
        lambdaDoSomething.doIt();

        // pure function(To local variable status changing avoid is better)
        int i = 0;
//        DoSomethingCount doSomethingCount = (value) -> i++; // bad case
        DoSomethingCount doSomethingCount = value -> ++value;
        System.out.println(doSomethingCount.counting(i));
        /*** CHAPTER 1 : end ***/


        /**
         *  CHAPTER 2 : start
         *   - functional interface
         *   - https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
         */
        // Function interface - old
        SumSelf sumSelf = new SumSelf();
        System.out.println(sumSelf.apply(10));

        // Function interface - new after java8
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        Function<Integer, Integer> divide2 = value -> value / 5;
        System.out.println(divide2.apply(10));

        // Function compose ((10 + 10) / 2)
        System.out.println(divide2.compose(sumSelf).apply(10));

        // Function andThen (10 / 2) + 5
        System.out.println(divide2.andThen(sumSelf).apply(10));


        // BiFunction
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
        BiFunction<String, Integer, String> concatAsString = (str, number) -> str + number;
        System.out.println(concatAsString.apply("input number : ", 10));


        // Consumer interface
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
        Consumer<String> printer = value -> System.out.println(value);
        printer.accept("Consumer test~");


        // Supplier interface
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier<String> echoHello = () -> "Hello~!";
        System.out.println(echoHello.get());


        // Predicate interface
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
        Predicate<String> isMyName = name -> "minssogi".equals(name);
        Predicate<String> nameLengthUp3 = name -> name.length() > 3;
        System.out.println(isMyName.and(nameLengthUp3).test("minssogi"));
        System.out.println(isMyName.and(nameLengthUp3).test("minssogi"));
        System.out.println(Predicate.isEqual("minssogi").test("minsso"));

        // UnaryOperator interface - parameter, return type same case
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/UnaryOperator.html
        UnaryOperator<Integer> sum = value -> value + 10;
        System.out.println(sum.apply(100));

        // BinaryOperator interface
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
        BinaryOperator<Integer> divide = (value1, value2) -> value1 / value2;
        System.out.println(divide.apply(10, 2));
        /*** CHAPTER 2 : end ***/



    }
}
