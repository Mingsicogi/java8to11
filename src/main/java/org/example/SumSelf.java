package org.example;

import java.util.function.Function;

/**
 * function implements class
 *
 * @author minssogi
 */
public class SumSelf implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer integer) {
        return integer + integer;
    }
}
