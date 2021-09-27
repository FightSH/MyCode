package org.example.completablefuture;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.completablefuture.Shop.*;


public class ShopDemo {


    public static void main(String[] args) {
        long start = System.nanoTime();
//        List<String> iphone = findPrices("iphone");
//        List<String> iphone = findPricesAsync("iphone");

        CompletableFuture[] futures = findPricesStream("iphone").map(f -> f.thenAccept(
                        s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1000000) + "msecs)")))
                .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1000000) + "msecs)");

//        System.out.println("Done in " + (System.nanoTime() - start) / 1000000 + " msecs");

    }

    public static List<String> findPrices(String product) {
        return shops.stream()
                .map(shop -> shop.getPrice(product))
                .map(Quote::parse)
                .map(Discount::applyDiscount)
                .collect(Collectors.toList());
    }

    public static List<String> findPricesAsync(String product) { // 此写法最大优点在于可自定义线程池。
        List<CompletableFuture<String>> futureList = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote))))
                .collect(Collectors.toList());

        return futureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }


    public static Stream<CompletableFuture<String>> findPricesStream(String product) {
       return shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(
                        () -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote ->
                        CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote))));
    }

    public static Future<String> timeOut(Shop shop, String product) {
        return CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                        CompletableFuture.supplyAsync(
                                () -> getRate("USD", "EUR")),
                        (price, rate) -> price + rate)
//                .completeOnTimeout("default_rate",1,TimeUnit.SECONDS) 两种处理超时方式
                .orTimeout(3, TimeUnit.SECONDS);
    }

    public static double getRate(String usd, String eur) {
        return 8;
    }
}
