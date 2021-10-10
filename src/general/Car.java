package general;

public class Car {
    private String Name;
    private String Model;
    private int Number;
    private String color;

    public Car(String carName, String carModel, int carNumber, String color) {
        this.Name = carName;
        this.Model = carModel;
        this.Number = carNumber;
        this.color = color;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        this.Number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
