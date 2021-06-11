import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Person {
    private int age;
    private String name;
    private String country;

    //Constructor
    public Person(int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }
    //Getter and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person(20, "John", "USA"),
                new Person(35, "Sam", "Italy"),
                new Person(15, "Jamie", "England"),
                new Person(30, "Robert", "Italy"),
                new Person(20, "James", "Ireland"),
                new Person(25, "Peter", "USA"),
                new Person(5, "Jessica", "Norway"),
                new Person(40, "Roger", "Netherlands"),
                new Person(50, "Jim", "USA")
        );

//        Q1. Print the avg age of all the people
        avgAgeOfPeople(people);
        System.out.println(" ");
//        Q2. Create a list of all the people who are either greater than 20 or contain any vowel in their name (uppercase or lowercase)
        vowelFilterPeople(people);
        System.out.println(" ");
//        Q3. Create a list of people, sorted in ascending order on the basis of age, if age is the same then sort in descending order of name
        ascendingOrder(people);
        System.out.println(" ");
//        Q4. Create a map from this people list where the key is country name and value is count which means a map will tell how many people live in a particular country
        System.out.println("Q4. List of countries and people in country");
        System.out.println(findCountryMap(people));
        System.out.println(" ");
//        Q5. Create a map which stores avg age of people per country (key should be country and value should be average age i.e, double)
        findAvgAgeCountryMap(people);
        System.out.println(" ");
//        Q6. Print the oldest person in every country
        findOldestInCountry(people);
        System.out.println(" ");
//        Q7. Print the country with most people
        System.out.println("Q7. Country with most people:");
        findCountryWithMostPeople(findCountryMap(people));
        System.out.println(" ");
//        Q8. Create a list of 20 random integers in the range 0 - 1000 using Java 8 streams
        randomInt();

    }

    private static void randomInt() {
        Random random = new Random();
        List<Integer> randomInt = (List<Integer>) random.ints(20,0,1000)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Q8. A list of 20 random integer ranging from 0 - 1000");
        System.out.println(randomInt);

    }

    private static void findCountryWithMostPeople(Map<String, Long> countryMap) {
        System.out.println(
                "Country = " +
                Collections.max(countryMap.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey());

    }

    private static void findOldestInCountry(List<Person> people) {
        System.out.println("Q6. Oldest person in every country");

       // function is incomplete

    }

    private static void findAvgAgeCountryMap(List<Person> people) {
        Map<String, Double> avgAgeCountryMap = new HashMap<>();
        avgAgeCountryMap = people.stream()
                .collect(groupingBy(Person::getCountry,averagingDouble(Person::getAge)));
        System.out.println("Q4.Average age of people in country:");
        System.out.println(avgAgeCountryMap);
    }

    private static Map<String, Long> findCountryMap(List<Person> people) {
        Map<String, Long> countryMap = new HashMap<>();
        countryMap = people
                .stream()
                .collect(groupingBy(Person::getCountry, counting()));
        return countryMap;
    }

    private static void vowelFilterPeople(List<Person> people) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O', 'U'));
        List<Person> p = people.stream()
                .filter(i -> i.getAge()>20 || vowels.contains(i.getName())) // this logic in incorrect since you are checking the complete name in the vowels arraylist which would never be found no matter whether the name contains vowel or not
                .collect(toList());
        System.out.println("Q2.list of all the people who are either greater than 20 or contain any vowel in their name");
        p.forEach(System.out::println);
    }

    private static void ascendingOrder(List<Person> people) {
        people.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName, Comparator.reverseOrder()));
        System.out.println("Q3.list of people, sorted in ascending order on the basis of age, if age is the same then sort in descending order of name");
        people.forEach(System.out::println);
    }

    private static void avgAgeOfPeople(List<Person> people) {
        double avgAge = people.stream()
                .collect(averagingInt(Person::getAge));
        System.out.println("Q1. Average age of people: "+ avgAge);
    }


}
