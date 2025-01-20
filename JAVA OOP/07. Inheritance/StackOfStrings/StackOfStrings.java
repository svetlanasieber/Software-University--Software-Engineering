package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public StackOfStrings() {
        this.data = data;
    }
    public void push(String element){
        data.add(element);
    }
    public String pop(){
        return data.remove(data.size()-1);
    }

    public String peek(){
        return data.get(data.size()-1);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
