public class VeganPerson extends Person {
    public VeganPerson(String name) {
        super(name);
    }

    @Override
    void eat(Food food) {
        if(food instanceof VeganFood)
            super.eat(food);
        else
            System.out.println(getName() + " refuses to eat "+food);
    }

    //    public void eat(VeganFood food) {
//        System.out.println(getName()+" eats "+food+" (as vegan).");
//    }
}
