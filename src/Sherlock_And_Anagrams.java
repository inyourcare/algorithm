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
        int sum = 0;
        for (int i = 0; i<size ; i++){
            for (int j = i+1 ; j <= size ; j++){
                String part = s.substring(i , j);
                char[] partCharArr = part.toCharArray();
                Arrays.sort(partCharArr);
                for(int k = 0 ; k<size ; k++){
                    if(i==k)
                        continue;
                    String anagram = s.substring(k , Math.min(k+part.length() , size));
                    char[] anagramCharArr = anagram.toCharArray();
                    Arrays.sort(anagramCharArr);
                    if(Arrays.equals(partCharArr, anagramCharArr))
                        sum++;
                }
            }
        }
        return sum/2;
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
