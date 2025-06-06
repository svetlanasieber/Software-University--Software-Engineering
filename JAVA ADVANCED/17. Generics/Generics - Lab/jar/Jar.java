package jar;

import java.util.ArrayDeque;

// Generic parameter - очаква да бъде заменен с някакъв тип данни
public class Jar<T> {

    //При създаване на обект от този клас, полетата се инициализират със стойност null
    private ArrayDeque<T> elements;


    //конструктор
    public Jar() {
        //създавам един празен стек срещу това поле
        this.elements = new ArrayDeque<>();

    }


    public void add(T element){
        this.elements.push(element);
    }

    public T remove(){
        return this.elements.pop();

    }


}
