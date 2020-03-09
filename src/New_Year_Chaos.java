import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class New_Year_Chaos {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int result = 0;
        int q_len = q.length;
        int[] origin = new int[q_len];
        for (int i = 0 ; i < q_len ; i++)
            origin[i] = i+1;

//        for (int xx = 0 ; xx < q_len ; xx++)
//            System.out.print(origin[xx] + " ");
//        System.out.println();
        for (int i = 0 ; i < q_len ; i++){
            if (origin[i] != q[i]){
                int j = i;
                while(j < q_len - 1 && origin[++j] != q[i]);
                if (j - i > 2 ) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    int found = origin[j];
                    int temp = origin[i];
                    int temp2 = origin[i+1];
                    for (int k = i + 1 ; k <= j ; k++){
                        result++;
                        origin[k] = temp;
                        temp = temp2;
                        if (k+1 < q_len)
                            temp2 = origin[k+1];
                    }
                    origin[i] = found;
                }
            }
//            for (int xx = 0 ; xx < q_len ; xx++)
//                System.out.print(origin[xx] + " ");
//            System.out.println();

        }

        System.out.println(result);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
