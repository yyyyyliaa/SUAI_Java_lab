package Lab1;

public class Int {

    private int value;
  
    public Int() {
      this.value = 0;
    }
  
    public Int(int value) {
      this.value = value;
    }


    public void increment() {
      this.value += 1;
    }
  
    public void decrement() {
      this.value -= 1;
    }

  
    public void add(Int tmp) {
      this.value += tmp.value;
    }
  
    public void subtract(Int tmp) {
      this.value -= tmp.value;
    }


    @Override
    public String toString() {
      return String.valueOf(this.value);
    }
  }