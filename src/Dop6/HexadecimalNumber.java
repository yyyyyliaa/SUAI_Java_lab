package Dop6;

public class HexadecimalNumber {
    private String number = "0x";

    public HexadecimalNumber(String number){
        this.number += number;
    }

    @Override
    public String toString(){
        return number;
    }


}
