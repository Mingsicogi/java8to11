package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
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


        /**
         * CHAPTER 3 : start
         *  - lambda expression feature
         *  - https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html#shadowing
         *
         */

        // effective final
        int number = 100;
        IntConsumer intConsumer = value -> System.out.println(number + value);
        intConsumer.accept(number);
        // number++; // value that use in lambda must be final or effectively final.


        // shadowing (inner class, anonymous class)
        // inner class
        class LocalClass { // shadowing variable
          public String apply(Integer number) {
              return String.valueOf(number + number);
          }
        }

        // anonymous class
        Function<Integer, String> anonymousClass = new Function<Integer, String>() {
            @Override
            public String apply(Integer number) { // shadowing variable
                return String.valueOf(number + number);
            }
        };

        // lambda expression
        Function<Integer, String> lambdaExpression = value -> String.valueOf(value + number); // same scope with local variable in main method

        System.out.println(new LocalClass().apply(10));
        System.out.println(anonymousClass.apply(10));
        System.out.println(lambdaExpression.apply(10));

        /*** CHAPTER 3 : end ***/

        /**
         * CHAPTER 4 : start
         *  - method reference
         *  - https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
         *
         */
        // reference static method
        // 1 param no result => Consumer
        Consumer<String> game = Game::play;
        game.accept("EH");

        // method of object of method reference
        CommonLogVO log = new CommonLogVO("minssogi", LocalDateTime.now());
        Supplier<String> regEmpId = log::getRegEmpId;
        System.out.println(regEmpId.get());

        // constructor method reference
        Supplier<CommonLogVO> defaultGenerator = CommonLogVO::new;
        Function<String, CommonLogVO> generate1Param = CommonLogVO::new;
        System.out.println(defaultGenerator.get().toString());
        System.out.println(generate1Param.apply("minssogi2").toString());

        // etc
        String[] fruits = {"Banana", "Pineapple", "appe"};
        Arrays.sort(fruits, String::compareToIgnoreCase);
        for (String fruit : fruits) {
            System.out.print(fruit + ",");
        }
        System.out.println();

        /*** CHAPTER 3 : end ***/
    }
}
