package comparingObjects;


public class Person implements Comparable<Person> {

    private String name;
    private String town;
    private Integer age;

    public Person(String name, String town, Integer age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }

   
    @Override
    public int compareTo(Person otherPerson) {


        int nameComparingResult = this.name.compareTo(otherPerson.name);
      
        int ageComparingResult = this.age.compareTo(otherPerson.age);
       
        int townComparingResult = this.town.compareTo(otherPerson.town);

        if (nameComparingResult != 0) {
            return nameComparingResult;
        } else if (ageComparingResult != 0) {
            return ageComparingResult;
        } else {
            return townComparingResult;
        }
    }
}
