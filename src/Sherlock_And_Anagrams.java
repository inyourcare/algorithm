import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Sherlock_And_Anagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int size = s.length();
        for (int i = 1; i<size ; i++){
            String part = s.substring(0 , i);
            char[] partCharArr = part.toCharArray();
            char[] anagramCharArr = new char[partCharArr.length];
            for (int j = 0 ; j < partCharArr.length ; j++){
                anagramCharArr[j] = partCharArr[partCharArr.length - j - 1];
            }
            String anagram = new String(anagramCharArr);
            System.out.println(part + ":" + anagram);
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("sherlockAndAnagrams"));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
