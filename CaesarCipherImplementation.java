import java.io.FileNotFoundException;
public class CaesarCipherImplementation {
    public static void main(String[] args) throws FileNotFoundException {
        int key = 1;

        // encryption
        String pt = CaesarCipher.readFile("/Users/aidarkhan/Desktop/words.txt");
        System.out.println(pt);
        String ct = CaesarCipher.encrypt(pt, key);
        System.out.println(ct);
        CaesarCipher.writeFile(ct, "/Users/aidarkhan/Desktop/output.txt");
        //decryption
        String ctt = CaesarCipher.readFile("/Users/aidarkhan/Desktop/output.txt");
        String ptt = CaesarCipher.decrypt(ctt, key);
        CaesarCipher.writeFile(ptt, "/Users/aidarkhan/Desktop/newwords.txt");
    }
}