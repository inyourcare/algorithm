import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Making_Anagrams {

    static void countCharacter(char[] charArr , Map<Character , Integer> charLenMap){
        char prev ='#';
        int len = 0;
        for (char c = 'a'; c <= 'z' ; c++){
            charLenMap.put(c , 0);
        }
        for (char c : charArr){
            if (prev != c) {
                charLenMap.put(prev , len);
                prev = c;
                len = 0;
            }
            len += 1;
        }
        charLenMap.put(prev , len);
    }

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);

        Map<Character , Integer> charLenMap1 = new HashMap<>();
        Map<Character , Integer> charLenMap2 = new HashMap<>();

        countCharacter(s1Arr , charLenMap1);
        countCharacter(s2Arr , charLenMap2);

        int sum = 0;
        for (char c = 'a'; c <= 'z' ; c++){
            sum += Math.max(charLenMap1.get(c) , charLenMap2.get(c)) - Math.min(charLenMap1.get(c) , charLenMap2.get(c));
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("makingAnagrams"));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
