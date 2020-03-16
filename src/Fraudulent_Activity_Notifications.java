import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Fraudulent_Activity_Notifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        if (expenditure.length <= d)
            return 0;

        int[] trailingDaysExpenditure = new int[d];
        int[] medianArr = new int[d];
        int notiCnt = 0;
        int trailIdx;
        for (int i = 0; i < d; i++) {
            trailingDaysExpenditure[i] = expenditure[i];
            medianArr[i] = expenditure[i];
        }
        Arrays.sort(medianArr);

        if (d % 2 == 0) {
            for (int i = d; i < expenditure.length; i++) {
                if (expenditure[i] >= (medianArr[d / 2] + medianArr[d / 2 - 1]))
                    notiCnt++;
                trailIdx = i % d;
                removeAndAdd(medianArr, trailingDaysExpenditure[trailIdx], expenditure[i]);
                trailingDaysExpenditure[trailIdx] = expenditure[i];
            }
        } else {
            for (int i = d; i < expenditure.length; i++) {
                if (expenditure[i] >= medianArr[d / 2] * 2)
                    notiCnt++;
                trailIdx = i % d;
                removeAndAdd(medianArr, trailingDaysExpenditure[trailIdx], expenditure[i]);
                trailingDaysExpenditure[trailIdx] = expenditure[i];
            }
        }

        return notiCnt;
    }

    private static void removeAndAdd(int[] medianArr, int remove, int add) {
        int removeInflection = 0;
        for (; removeInflection < medianArr.length; removeInflection++)
            if (medianArr[removeInflection] == remove)
                break;

        int addInflection = 0;
        for (; addInflection < medianArr.length; addInflection++)
            if (add < medianArr[addInflection])
                break;

        if (addInflection <= removeInflection) {
            for (int i = removeInflection; i > addInflection; i--) {
                medianArr[i] = medianArr[i - 1];
            }
            medianArr[addInflection] = add;
        } else {
            for (int i = removeInflection; i < addInflection - 1; i++) {
                medianArr[i] = medianArr[i + 1];
            }
            medianArr[addInflection - 1] = add;
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("activityNotifications"));

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
