package Dop6;

public class BinaryNumber {
    private String number = "0b";

    public BinaryNumber(String number){
        this.number += number;
    }

    @Override
    public String toString(){
        return number;
    }

}
