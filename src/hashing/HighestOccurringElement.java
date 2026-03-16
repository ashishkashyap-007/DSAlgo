package hashing;

public class HighestOccurringElement {

    private static int findHighestOccurringElementNaive(int[] arr) {
        int res = -1;
        int maxCount = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int currCount = 1;
            int currElement = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == currElement) {
                    currCount++;
                }
            }
            if (currCount > maxCount) {
                maxCount = currCount;
                res = currElement;
            } else if (currCount == maxCount) {
                res = Math.min(res, currElement);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 3, 3, 2};
        System.out.println(findHighestOccurringElementNaive(arr));
    }
}
