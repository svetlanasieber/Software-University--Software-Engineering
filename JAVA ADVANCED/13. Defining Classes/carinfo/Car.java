package carinfo;


public class Car {

   
    private String brand;
    private String model; 
    private int hp; 

    public Car() {

    }


    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

   
    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }


    public void printCarInfo() {
        System.out.printf("The car is: %s %s - %d HP.%n", this.brand, this.model, this.hp);
    }
}
