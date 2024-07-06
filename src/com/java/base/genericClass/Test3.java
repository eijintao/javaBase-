package com.java.base.genericClass;

import com.java.base.entity.Employee;

/**
 * mjt 梅锦涛
 * 2024/7/6
 *
 * @author mjt
 */
public class Test3 {

    public static void main(String[] args) {

        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);
        Pair<Manager> managerPair = new Pair<>(ceo, cfo);


    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee second = p.getSecond();
        Employee first = p.getFirst();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxSalary(Manager[] a, Pair<? super Manager> result) {
        if (a == null || a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getSalary() > a[i].getSalary()) min = a[i];
            if (max.getSalary() < a[i].getSalary()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }


    public static void maxminSalary(Manager[] a, Pair<? super Manager> result) {
        minmaxSalary(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard
    }


}
class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) { swapHelper(p); }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}