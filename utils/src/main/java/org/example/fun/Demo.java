package org.example.fun;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.LongStream;

public class Demo {

    // 给定一个List<Integer>，比如{1, 4,9}，构造一个List<List<Integer>>，
    // 要求该列表的成员都是初始列表{1, 4, 9}的子集，此外暂时不考虑元素的顺序。
    // {1, 4, 9}的子集分别是{1, 4, 9}、{1, 4}、{1, 9}、{4, 9}、{1}、{4}、{9}以及{}
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 4, 9);
        List<List<Integer>> result = subsets(list);
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));

    }

    // 考虑编程问题时，采用函数式的方法，关注函数的输入参数以及输出结果（即你希望做什么），通常比设计阶段的早期就考虑如何做、修改哪些东西要卓有成效得多
    static List<List<Integer>> subsets(List<Integer> list) {
        if (list.isEmpty()) {
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(Collections.emptyList());
            return ans;
        }
        // 取出一个元素first，找出剩余部分的所有子集。并将其赋予subans。subans构成了结果的另一半
        Integer first = list.get(0);
        List<Integer> rest = list.subList(1, list.size());
        List<List<Integer>> subans = subsets(rest);
        // 答案的另一半是subans2，包含了subans中的所有列表。但经过调整后，每个列表的第一个元素前添加了first
        List<List<Integer>> subans2 = insertAll(first, subans);
        return concat(subans, subans2);
    }

    // 函数式方法。不对入参进行修改
    private static List<List<Integer>> concat(List<List<Integer>> subans, List<List<Integer>> subans2) {
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(subans);
        result.addAll(subans2);
        return result;
    }

    // 函数式方法。不对入参进行修改
    private static List<List<Integer>> insertAll(Integer first, List<List<Integer>> subans) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : subans) {
            List<Integer> copyList = new ArrayList<>();
            copyList.add(first);
            copyList.addAll(list);
            result.add(copyList);
        }
        return result;
    }

    static long factorialIterative(long n) {
        long r = 1;
        for (int i = 1; i < n; i++) {
            r *= i;
        }
        return r;
    }

    static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
    }


    static double converter(double x, double f, double b) {
        return x * f + b;
    }
    // 只需要向其传递转换因子和基准值b。其便会返回一个方法(参数为x)
    // 并且DoubleUnaryOperator定义了applyAsDouble方法
    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    static void testCurr() {
        DoubleUnaryOperator convertCtoF = curriedConverter(9.0 / 5, 32);
        double v = convertCtoF.applyAsDouble(10);
        DoubleUnaryOperator convertUSDtoGBP = curriedConverter(0.6, 0);
        DoubleUnaryOperator convertKmtoMi = curriedConverter(0.624, 0);

    }

}
