public class AmbigiousPersonException extends Exception{

    PersonDetails og, copy;

    public AmbigiousPersonException(PersonDetails og, PersonDetails copy){
        this.og = og;
        this.copy = copy;
    }

    @Override
    public String toString() {
        return "AmbigiousPersonException{ og="+og.getPerson()+"path= "+og.getPath()+", copy="+copy.getPerson()+"path="+copy.getPath()+" }";
    }
}
