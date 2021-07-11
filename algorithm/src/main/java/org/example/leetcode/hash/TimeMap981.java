package org.example.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap981 {

    class Pair {
        String k, v;
        int t;

        public Pair(String k, String v, int t) {
            this.k = k;
            this.v = v;
            this.t = t;
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap981() {
        map = new HashMap();

    }

    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new Pair(key, value, timestamp));
        map.put(key, list);

    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        if (pairs.isEmpty()) {
            return "";
        }

        int n = pairs.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (pairs.get(mid).t <= timestamp) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }

        return pairs.get(r).t <= timestamp ? pairs.get(r).v : "";
    }

    public static void main(String[] args) {
        System.out.print(5 + 2 + 1 >> 1);
    }

}
