package com.java.base.basenum;

/**
 * mjt 梅锦涛
 * 2024/2/1
 *
 * @author mjt
 */
public class MainTest {

    /**
     * Java 语言中的参数传递可以理解为值传递。这意味着当你向方法传递参数时，
     * 实际上传递的是变量的副本，而不是变量本身。不过，这个概念在涉及对象时可能会导致一些混淆，
     * 因为对象的引用（即内存地址）也是通过值传递的方式传递的
     *
     * 基本类型（Primitive Types）：
     *
     *         对于基本数据类型（如 int, float, char 等），传递的是数据值的副本。方法内对参数的修改不会影响到原始数据。
     *
     * 对象引用（Reference Types）：
     *
     *          对于对象，传递的是对象引用（内存地址）的副本。这意味着你可以通过这个引用来访问和修改对象，
     *          因为两个引用指向同一个对象。但如果你尝试在方法中重新指定引用本身，比如让它指向一个新的对象，那么原始引用并不会改变。
     * @param args
     */
        public static void main(String[] args) {
            int num = 10;
            modifyPrimitive(num);
            System.out.println("num : " + num); // 输出 10, num 未改变

            MyObject myObj = new MyObject();
            myObj.value = 10;
            modifyObject(myObj);
            System.out.println(myObj.value); // 输出 20, 对象的内容被改变了
        }

        public static void modifyPrimitive(int number) {
            number = 20; // number 是 num 的一个副本，修改不会影响 num
            System.out.println("number : " + number);
        }

        public static void modifyObject(MyObject obj) {
            obj.value = 20; // obj 是 myObj 的一个副本，但指向同一个对象
        }

        static class MyObject {
            public int value;
        }


}

class MyObject {


    public static void main(String[] args) {
Person person = new Person();
        if (1 == person.getId()) {
            System.out.println("1 == null");
        } else {
            System.out.println("1 != null");
        }

    }
}
