package com.java.base.stream.java8LamdaOrStream.apple;

/**
 * mjt 梅锦涛
 * 2023/5/8
 *
 * @author mjt
 */
public class ApplesHeavyWeightPridicate implements ApplePredicate{

    @Override
    public boolean test(Apples apples) {
        return apples.getWeight()>150;
    }
}
