public class Main {
    public static void main(String[] args) {
        Chicken chicken = new Chicken();
        Lettuce lettuce = new Lettuce();
        Oven oven = new Oven();

        Person alice = new Person("Alice");
        alice.eat(chicken);

        //Chicken chicken2 = (Chicken) chicken.clone();
        Chicken chicken2 = chicken;
        oven.cook(chicken);
        //Chicken chicken2 = (Chicken) chicken.clone();
        alice.eat(chicken);

        alice.eat(lettuce);

        VeganPerson bob = new VeganPerson("Bob");
        bob.eat(lettuce);
        bob.eat(chicken);
        //alice.eat((Food) oven);



        Person charlie = new Person("Charlie");
        charlie.eat(chicken2);
        charlie = null;

        Cake cake = new Cake.Builder()
                .flour(20)
                .berry()
                .sugar(5)
                .build();

        alice.eat(cake);

    }
}