public class Main {
    public static class A {
        public Integer getField() {
            return field;
        }
        protected Integer field = 5;
    }
    public static class B extends A {
        public Integer getChildField() {
            return childField;
        }
        public B() {
            this.childField = 100;
            this.field = 200;
        }
        private Integer childField = 100;
    }
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.field);
        System.out.println(b.getChildField());
    }
}