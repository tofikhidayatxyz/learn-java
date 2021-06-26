import Hillchipper.Decrypt;
import Hillchipper.Encrypt;
import IO.Reader;
import IO.Writter;

public class Main {

    public static void main(String[] args) {
        // read file
        String readedFile = Reader.readFile("src/data/source.txt");
        System.out.println("Source File : " + readedFile);
        // encrypt file
        String encryptedText = Encrypt.encrypt(readedFile);
        System.out.println("Encrypted File : " + encryptedText);
        // write encrypted file
        Writter.writeFile("src/data/encrypted.txt", encryptedText);
        // read encrypted file
        String encryptedFile = Reader.readFile("src/data/encrypted.txt");
        // decrupt file
        String decryptedFile = Decrypt.decrypt(encryptedFile);
        System.out.println("Decrypted File : " + decryptedFile);
        // write decrypted file
        Writter.writeFile("src/data/decrypted.txt", decryptedFile);
    }
}
