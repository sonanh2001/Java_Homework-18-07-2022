import binary_string.BinaryString;
import matrix.Matrix;
import prime.FiveDigitPrime;
import prime.PrimeFactorization;

public class MainApplication {
    public static void main(String[] args) {
        PrimeFactorization primeFactorization = new PrimeFactorization();
        primeFactorization.solve(100);

        BinaryString binaryString = new BinaryString(5);
        binaryString.solve(0);

        FiveDigitPrime fiveDigitPrime = new FiveDigitPrime();
        fiveDigitPrime.solve(14);

        Matrix matrix = new Matrix(3, 3);
        matrix.enterMatrix();
        matrix.findMaxNumberOfMatrix();
        matrix.printPrimeValue();
        matrix.printSortColumn();
    }
}
