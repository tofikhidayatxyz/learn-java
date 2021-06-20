import matrix.Opration;
import matrix.hillchiper.Decrypt;
import matrix.hillchiper.Encrypt;


public class Main {

    static void printMatrix(double[][] matrix) {
        for (double[] d1 : matrix) {
            for (double d2 : d1) {
                System.out.print(d2 + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Opration opration = new Opration();
        Integer[] matrixA = {5, 9};
        Integer[][] matrixB = {{1, 2}, {3, 2}};

        opration.setMatrixA(matrixA);
        opration.setMatrixB(matrixB);

        System.out.println("----- Kalkulasi Matrix ----- ");
        opration.calculate();
        printMatrix(opration.getOprationResult());
        System.out.println("----- Invers Matrix ----- ");
        opration.inverse(opration.getOprationResult());
        printMatrix(opration.getInversResult());


        System.out.println("----- Hill Chipper ----- ");


        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();
        String masterText = "Tofik hidayat";
        System.out.println("Text before encrypt : " + masterText);
        String encryptedResult = encrypt.encrypt(masterText);
        System.out.println("Text after encrypt : " + encryptedResult);
        String decryptedResult = decrypt.decrypt(encryptedResult);
        System.out.println("Text after decrypt : " + decryptedResult);
    }
}
