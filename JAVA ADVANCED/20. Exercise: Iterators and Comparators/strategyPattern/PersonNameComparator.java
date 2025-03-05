package strategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {


    @Override
    public int compare(Person firstPerson, Person secondPerson) {


        int nameLengthComparingResult = Integer.compare(firstPerson.getName().length(), secondPerson.getName().length());

        if (nameLengthComparingResult == 0) {
            char firstNameSymbol = firstPerson.getName().toUpperCase().charAt(0);
            char secondNameSymbol = secondPerson.getName().toUpperCase().charAt(0);
            return Character.compare(firstNameSymbol, secondNameSymbol);
        }
        return nameLengthComparingResult;
    }
}
