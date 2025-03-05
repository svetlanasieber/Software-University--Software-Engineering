package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T value) {
        this.values.add(value);
    }

    public void swap(int index1, int index2) {



        T firstValue = values.get(index1);
        T secondValue = values.get(index2);

        this.values.set(index1, secondValue);
        this.values.set(index2, firstValue);
    }

    public int countGreaterValues(T valueToCompare) {

        int count = 0;
        for (T value : this.values) {

            int comparingResult = value.compareTo(valueToCompare);
            if (comparingResult > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            //"{class full name}: {value}"
            String formattedValue = String.format("%s: %s", value.getClass().getName(), value);
            sb.append(formattedValue).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
