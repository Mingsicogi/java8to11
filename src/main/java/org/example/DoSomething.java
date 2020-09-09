package org.example;

/**
 * Functional interface
 *  - condition
 *      1. must have to only one abstract method
 *
 * @author minssogi
 */
public interface DoSomething {

    // abstract method(abstract keyword can be omitted)
    void doIt();

    // new grammar from java8
    static void printHello() {
        System.out.println("Hello~!");
    }
    default void printBye() {
        System.out.println("Bye Bye~");
    }
}
