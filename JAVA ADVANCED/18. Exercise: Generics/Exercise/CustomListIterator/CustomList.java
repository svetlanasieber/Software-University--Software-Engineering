package CustomListIterator_09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

    private List<T> elements;

    public CustomList() {
        elements = new ArrayList<>();
    }

 
    public void add(T element) {
        this.elements.add(element);
    }

  
    public T remove(int index) {
        return this.elements.remove(index);
    }

   
    public boolean contains(T element) {
        return this.elements.contains(element);
    }


    public void swap(int index1, int index2) {
        Collections.swap(this.elements, index1, index2);
    }


    public int countGreaterValues(T elementToCompare) {
        int count = 0;
        for (T element : this.elements) {

            int comparingResult = element.compareTo(elementToCompare);
            if (comparingResult > 0) {
                count++;
            }
        }
        return count;
    }


    public T getMax() {
        return Collections.max(this.elements);
    }


    public T getMin() {
        return Collections.min(this.elements);
    }

    public void sort() {
        Collections.sort(this.elements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(element.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }
}
