import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CaesarCipher {
    public static String readFile(String path) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream(path));
        String bigSlovo = "";
        while(reader.hasNextLine()){
            String slovo = reader.nextLine();
            slovo = slovo.toLowerCase();
            bigSlovo = bigSlovo  + slovo + "\n";

        }
        reader.close();
        return  bigSlovo;


    }


    public static void writeFile(String text, String path) throws FileNotFoundException {
//     writes text to a file accessible via path
//     your code
        PrintWriter writer = new PrintWriter(new FileOutputStream(path));
        writer.println(text);
        writer.close();

    }


    public static String encrypt(String pt, int k) {
//     encrypts a given plaintext pt with a key k
//     your code
        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        String bigWord = "";
        for( String word : pt.split("\n") ){
            String littleWord = "";

            for (int i = 0; i < word.length(); i++) {
                int newInt = find(word.charAt(i)) + k % 26;
                if (newInt > 25) {
                    newInt = newInt - 26;
                }
                littleWord = littleWord + alphabet.get(newInt);
            }
            bigWord = bigWord + littleWord +"\n";
        }
        return bigWord;
    }


    public static String decrypt(String ct, int k) {
        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        String bigWord = "";
        for( String word : ct.split("\n") ){
            String littleWord = "";

            for (int i = 0; i < word.length(); i++) {
                int newInt = find(word.charAt(i)) - k % 26;
                if (newInt < 0) {
                    newInt = newInt + 26;
                }
                littleWord = littleWord + alphabet.get(newInt);
            }
            bigWord = bigWord + littleWord +"\n";
        }
        return bigWord;

    }
    public static int find(char x){
        List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        int ans = 99;
        for (int i = 0; i < alphabet.size() ; i++) {
            if (alphabet.get(i)==x){
                ans = i;
                break;
            }
        }
        return ans;

    }
}