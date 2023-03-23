import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person implements Serializable {
    private String name;
    private LocalDate birth, death;
    private Person parents[] = new Person[2];

    public static ArrayList<PersonDetails> personDetails = new ArrayList();

    public Person(String name, LocalDate birth) {
        this(name, birth, null);
    }

    public Person(String name, LocalDate birth, LocalDate death) {
        this.name = name;
        this.birth = birth;
        this.death = death;
        try {
            if (birth.isAfter(death)) {
                throw new NegativeLifespanException(birth, death, "Possible time-space loophole.");
            }
        } catch (NullPointerException e) {
        }
    }

    public Person(String name, LocalDate birth, LocalDate death, Person parent1, Person parent2) throws IncestException {
        this(name, birth, death);
        parents[0] = parent1;
        parents[1] = parent2;

        checkForIncest();
    }

    public Person(String name, LocalDate birth, Person parent1, Person parent2) throws IncestException {
        this(name, birth, null, parent1, parent2);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", death=" + death +
                ", parents=" + Arrays.toString(parents) +
                '}';
    }

    void checkForIncest() throws IncestException {
        if (parents[0] == null || parents[1] == null)
            return;
        for (var leftSideParent : parents[0].parents) {
            if (leftSideParent == null) continue;
            for (var rightSideParent : parents[1].parents) {
                if (rightSideParent == null) continue;
                if (leftSideParent == rightSideParent)
                    throw new IncestException(leftSideParent, this);
            }
        }
    }

    public static ArrayList<Person> relativeCheckList(ArrayList<String> paths) throws Exception{
        ArrayList<Person> result = new ArrayList<>();
        for(String path : paths){
            Scanner scanner = new Scanner(new File(path));
            ArrayList<String> lines = new ArrayList<>();
            while(scanner.hasNext()){
                String read = scanner.nextLine();
                lines.add(read);
            }
            ArrayList<String> names = new ArrayList<>();
            names.add(lines.get(0));
            for(int i = 2;i<4;++i){
                if(lines.size()<=i){
                    break;
                }
                if(lines.get(i).compareTo("Rodzice:")==0){
                    for(int j = 0;j<2;++j){
                        if(lines.size()>i+j){
                            names.add(lines.get(i+j));
                        }
                    }
                }
            }
            for(PersonDetails personDetails : personDetails){
                Person person = personDetails.person;
                if(names.contains(personDetails.person.name)){
                    result.add(person);
                }

            }
        }
        return result;
    }

    public Person createPerson(String filePath) throws Exception {
        Scanner scanner = new Scanner(new File(filePath));
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNext()) {
            String read = scanner.nextLine();
            lines.add(read);
        }
        Person person = null;
        String name = lines.get(0);
        LocalDate birthDate = LocalDate.parse(lines.get(1), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        if (lines.size() > 2) {
            if(lines.get(2).compareTo("Rodzice:")==0){
                //person.parents

            }
            else{
                LocalDate deathDate = LocalDate.parse(lines.get(2), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                person = new Person(name, birthDate, deathDate);
            }
        }
        else {
            person = new Person(name, birthDate);

        }
        for(PersonDetails details : personDetails){
            if(person.name.compareTo(details.getPerson().name)==0){
                throw new AmbigiousPersonException(new PersonDetails(person,filePath),details);
            }
        }
        personDetails.add(new PersonDetails(person,filePath));
        return person;
    }
}
