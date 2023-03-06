import java.sql.SQLOutput;

public class Main {
    abstract public static class Base {
        protected int field;

        public Base(int field) {
            this.field = field;
        }

        public void say() {
            System.out.println("BASE "+this.field);
        }

        abstract void connect();



        protected void printX() {
            System.out.println("X");
        }
    }

    public static class ChildA extends Base {
        private int childAField;
        public ChildA(int field, int childAField) {
            super(field);
            this.childAField = childAField;
        }

        @Override
        public String toString() {
            return "ChildA{" +
                    "childAField=" + childAField +
                    ", field=" + field +
                    '}';
        }

        public void say() {
            System.out.println("CHILD_A" + this.childAField);
            super.say();
        }

        @Override
        void connect() {
            System.out.println("connect as child A");
        }
    }

//    public static class ChildB extends Base {
//        public void say() {
//            System.out.println("CHILD_B");
//        }
//    }
//
//    public static class Orphan extends Base{
//        public void say() {
//            System.out.println("ORPHAN");
//        }
//    }

    public static void main(String[] args) {
//        Base b = new Base(100);
//        b.say();

        ChildA ca = new ChildA(100, 200);
        System.out.println(ca);

        //ca.say();
//        ChildB cb = new ChildB();
//
//        Base arr[] = new Base[4];
//        arr[0] = b;
//        arr[1] = ca;
//        arr[2] = cb;
//        arr[3] = new Orphan();
//
//        for(int i=0; i<arr.length; ++i)
//            arr[i].say();

    }
}