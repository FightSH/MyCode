package org.example.honer;

import java.util.HashMap;
import java.util.Map;

public class RedEnvelope21 {

    public static void main(String[] args) {

        int arr[] = {1,1, 3, 3, 2, 2};

        int a = getRes(arr, 6);
        System.out.print(a);
    }

    private static int getRes(int[] arr, int num) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= num / 2) {
                return entry.getKey();
            }
        }

        return 0;
    }


}
