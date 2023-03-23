public class PersonDetails {
    final Person person;
    final String path;

    public Person getPerson() {
        return person;
    }

    public String getPath() {
        return path;
    }

    public PersonDetails(Person person, String path) {
        this.person = person;
        this.path = path;
    }
}
