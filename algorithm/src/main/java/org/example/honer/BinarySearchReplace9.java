package org.example.honer;

public class BinarySearchReplace9 {
    public static void main(String[] args) {


        int arr[] = {1, 2, 4, 4, 5};
        int target = 4;
        System.out.println(binarySearchReplace(arr, target));

    }

    public static int binarySearchReplace(int arr[], int target) {
        if (arr.length == 0) {
            return arr.length + 1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                while (mid > 0 && arr[mid] == arr[mid - 1]) {
                    mid--;
                }
                return mid + 1;
            }
            if (arr[mid] > target) {
                low = mid + 1;
            }
            if (arr[mid] < target) {
                high = mid - 1;
            }
        }

        return arr.length + 1;
    }

}
