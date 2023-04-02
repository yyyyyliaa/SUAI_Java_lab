package Lab8;

public class Main {
    public static void main(String[] args) {

        UsualMatrix source1 = new UsualMatrix(1000);
        UsualMatrix source2 = new UsualMatrix(1000);

        UsualMatrix[] results = new UsualMatrix[2];

        for(int i = 0; i < 2; i++){
            results[i] = new UsualMatrix(1000);;
        }

        source1.randomize();
        source2.randomize();


        MeasureTime.measureTime("Standard multiplication", () -> {
            results[0] = source1.product(source2);
        }, 10);


        ParallelMatrixProduct p = new ParallelMatrixProduct();

        MeasureTime.measureTime("Parallel multiplication", () -> {
            results[1] = p.product(source1, source2);
        }, 10);

        System.out.println("Matrices are equal: " + results[0].equals(results[1]));
    }

}
