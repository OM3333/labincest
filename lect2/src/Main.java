public class Main {

    public static class A {
        public Integer field = 5;
    }
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        a.field = 10;
        System.out.print(b.field);
    }
}