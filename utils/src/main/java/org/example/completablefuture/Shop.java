package org.example.completablefuture;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static org.example.completablefuture.Demo.delay;

public class Shop {

    private String name;

    public static List<Shop> shops = List.of(new Shop("BestPrice"),
                                                new Shop("LetsSaveBig"),
                                                new Shop("MyFavoriteShop"),
                                                new Shop("BuyItAll"));


    public Shop(String name) {
        this.name = name;
    }


    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name,price,code);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
//        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                double price = calculatePrice(product);
//                completableFuture.complete(price);
//            } catch (Exception e) {
//                completableFuture.completeExceptionally(e);
//            }
//        }).start();
//        return completableFuture;
    }

    private double calculatePrice(String product) {
        Demo.randomDelay();
        return new Random().nextDouble() * product.charAt(0) + product.charAt(1);
    }


}
