import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new Person("Leana", "Popescu", 45, "Bucuresti"),
                new Person("Costel", "Popescu", 54, "Oradea"),
                new Person("Georgel", "Alexandrescu", 5, "Craiova"),
                new Person("Esmeralda", "Florentiu", 10, "Iasi"),
                new Person("Dumitru", "Popovici", 60, "Constanta"),
                new Person("Dumitru", "Pop", 61, "Braila")
        );

        persons.stream()
                .map(Person::getFirstName)
                .sorted()
                .forEach(System.out::println);

        persons.stream()
                .map(Person::getLastName)
                .sorted()
                .forEach(System.out::println);

        persons.stream()
                .filter(person -> person.getAge() > 17)

                .forEach(System.out::println);

        List<Person> city = persons.stream()
                .filter(person -> person.getCity().equalsIgnoreCase("Oradea") || person.getCity().equalsIgnoreCase("Bucuresti"))
                .collect(Collectors.toList());
        System.out.println(city);

        List<String> firstName = persons.stream()
                .map(person -> person.getFirstName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println(firstName);

        List<String> firstN = persons.stream()
                .map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ". ")
                .collect(Collectors.toList());
        System.out.println(firstN);

        List<Person> betweenAge = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .collect(Collectors.toList());

        System.out.println(betweenAge);

        List<Person> letterA = persons.stream()
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(Collectors.toList());

        System.out.print(letterA);

        List<String> uniqueName = persons.stream()
                .map(person -> person.getFirstName())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueName);

        List<Person> sortFistName = persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(Collectors.toList());

        System.out.print(sortFistName);

        List<Person> sortLastName = persons.stream()
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());

        System.out.print(sortLastName);

        List<Person> sortNameAge = persons.stream()
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName).thenComparing(Person::getAge))
                .collect(Collectors.toList());

        System.out.print(sortNameAge);

    }
}

class Person {
    private final String firstName;
    private final String lastName;
    private int age;
    private String city;


    Person(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}