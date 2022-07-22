package Homework5;



public class Main {
    public static void main(String[] args) {
        testGarbageCollector();
    }

    public static void testGarbageCollector(){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            Human hmn = new Human();
        }
    }
}
