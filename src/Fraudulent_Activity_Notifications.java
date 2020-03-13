import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Fraudulent_Activity_Notifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        if (expenditure.length <= d)
            return 0;

        int[] trailingDaysExpenditure = new int[d];
        int notiCnt = 0;
        int trailIdx;
        for (int i = 0 ; i < d ; i++) {
            trailingDaysExpenditure[i] = expenditure[i];
        }

        if (d % 2 == 0){
            for (int i = d ; i<expenditure.length ; i++){
                int[] medianArr = trailingDaysExpenditure.clone();
                Arrays.sort(medianArr);
                if (expenditure[i] >= (medianArr[d/2] + medianArr[d/2-1]))
                    notiCnt++;
                trailIdx = i%d;
                trailingDaysExpenditure[trailIdx] = expenditure[i];
            }
        }else {
            for (int i = d ; i<expenditure.length ; i++){
                int[] medianArr = trailingDaysExpenditure.clone();
                Arrays.sort(medianArr);
                if (expenditure[i] >= medianArr[d/2]*2)
                    notiCnt++;
                trailIdx = i%d;
                trailingDaysExpenditure[trailIdx] = expenditure[i];
            }
        }

        return notiCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
