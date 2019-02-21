import java.util.Arrays;

public class TripleSum {
//Adapted from https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
    static int tripleSum(int arr[], int sum) {
        Arrays.sort(arr);
        int num_trip = 0;
        int second, third;
        for (int first = 0; first < arr.length; first++) {
            second = first + 1;
            third = arr.length - 1;
            while (second < third) {
                if (arr[first] + arr[second] + arr[third] == sum) {
                    num_trip++;
                    second++;
                }
                if (arr[first] + arr[second] + arr[third] < sum) {
                    second++;
                }
                if (arr[first] + arr[second] + arr[third] > sum) {
                    third--;
                }
            }
        }
        return num_trip;
    }

}

