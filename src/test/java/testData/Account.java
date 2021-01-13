package testData;

public class Account {
    private String type;
    private int number;

    public Account(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getStringValueOfNumber() {
        return String.valueOf(number);
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
