public class Person {
    private final String name;

    protected String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    void eat(Food food) {
        if(food.isCookable())
            if(!((Cookable)food).isCooked()) {
                System.out.println(name + " refuses to eat uncooked " + food + ".");
                return;
            }
        System.out.println(name+" eats "+food+".");
    }
}
