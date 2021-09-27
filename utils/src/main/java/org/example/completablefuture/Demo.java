package org.example.completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

public class Demo {


    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void randomDelay() {
        int delay = new Random().nextInt(2000) + 500;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        sort();
//        exceptionHandle();
//        oneOf();
        compose();
    }

    public static void instantiation() {
        //实例化
        CompletableFuture<String> cf = new CompletableFuture<>();
        cf.complete("coding");
        //静态方法
//        CompletableFuture<Void> future = CompletableFuture.runAsync();
//        CompletableFuture.runAsync(Runnable runnable, Executor executor);
//        CompletableFuture.supplyAsync(Supplier<U> supplier);
//        CompletableFuture.supplyAsync(Supplier<U> supplier, Executor executor)


    }

    /**
     * 任务有序处理
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void sort() throws ExecutionException, InterruptedException {
//        首先执行任务A，然后将任务A的结果传递给任务B
        CompletableFuture.runAsync(() -> {
        }).thenRun(() -> {
        });

        CompletableFuture.runAsync(() -> {
        }).thenAccept(resultA -> {
        });

        CompletableFuture.runAsync(() -> {
        }).thenApply(resultA ->
                "resultB");
        //上面演示的是任务A无返回值，所以，resultA为null


        //任务A执行完执行B，B中不需要A的结果
        CompletableFuture.supplyAsync(() -> "resultA").thenRun(() -> {
        });
        //任务A执行完执行B，B需要A的结果，但是任务B不返回任何值
        CompletableFuture.supplyAsync(() -> "resultA").thenAccept(resultA -> {
        });
        //任务A执行完执行B，B需要A的结果，任务B有返回值
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "resultA").thenApply(resultA -> resultA + " resultB");
//        System.out.println(future.isDone());
//        String s = future.get();
//        System.out.println(s);

    }

    /**
     * 异常处理
     */
    public static void exceptionHandle() {
//        public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> fn);
//        public <U> CompletionStage<U> handle(BiFunction<? super T, Throwable, ? extends U> fn);

        //使用exceptionally方法处理异常
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
                    throw new RuntimeException();
                })
                .exceptionally(ex -> "errorResultA")
                .thenApply(resultA -> resultA + " resultB")
                .thenApply(resultB -> resultB + " resultC")
                .thenApply(resultC -> resultC + " resultD");
        System.out.println(future.join());


        //handle(BiFunction fn)处理异常
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "resultA")
                .thenApply(resultA -> resultA + " resultB")
                // 任务 C 抛出异常
                .thenApply(resultB -> {
                    throw new RuntimeException();
//                    return resultB;
                })
                // 处理任务 C 的返回值或异常
                .handle(new BiFunction<Object, Throwable, Object>() {
                    @Override
                    public Object apply(Object re, Throwable throwable) {
                        if (throwable != null) {
                            return "errorResultC";
                        }
                        return re;
                    }
                })
                .thenApply(resultC -> resultC + " resultD");

        System.out.println(completableFuture.join());

    }

    /**
     * 取任务的结果
     */
    public static void oneOf() {
        //任务AB并行工作，取结果
        CompletableFuture<String> cfA = CompletableFuture.supplyAsync(() -> "resultA");
        CompletableFuture<String> cfB = CompletableFuture.supplyAsync(() -> "resultB");

        //thenAcceptBoth表示后续处理不需要返回值
        cfA.thenAcceptBoth(cfB, (resultA, resultB) -> {
        });
        //thenCombine 表示需要返回值
        cfA.thenCombine(cfB, (resultA, resultB) -> "result A + B");
        cfA.runAfterBoth(cfB, () -> {
        });

    }

    public static void allAndAny() {
        CompletableFuture cfA = CompletableFuture.supplyAsync(() -> "resultA");
        CompletableFuture cfB = CompletableFuture.supplyAsync(() -> 123);
        CompletableFuture cfC = CompletableFuture.supplyAsync(() -> "resultC");

        CompletableFuture<Void> future = CompletableFuture.allOf(cfA, cfB, cfC);
        // 所以这里的 join() 将阻塞，直到所有的任务执行结束
        // 由于 allOf 聚合了多个 CompletableFuture 实例，所以它是没有返回值的。这也是它的一个缺点。
        future.join();

        //anyOf 也非常容易理解，就是只要有任意一个 CompletableFuture 实例执行完成就可以了
        CompletableFuture cFA = CompletableFuture.supplyAsync(() -> "resultA");
        CompletableFuture cFB = CompletableFuture.supplyAsync(() -> 123);
        CompletableFuture cFC = CompletableFuture.supplyAsync(() -> "resultC");

        CompletableFuture<Object> completableFuture = CompletableFuture.anyOf(cFA, cFB, cFC);
        // join() 方法会返回最先完成的任务的结果，所以它的泛型用的是 Object，因为每个任务可能返回的类型不同。
        Object result = completableFuture.join();
    }

    /**
     * anyOf(...) 只需要处理两个 CompletableFuture 实例，那么也可以使用 xxxEither() 来处理.
     */
    public static void either() {
//        cfA.acceptEither(cfB, result -> {});
//        cfA.acceptEitherAsync(cfB, result -> {});
//        cfA.acceptEitherAsync(cfB, result -> {}, executorService);
//
//        cfA.applyToEither(cfB, result -> {return result;});
//        cfA.applyToEitherAsync(cfB, result -> {return result;});
//        cfA.applyToEitherAsync(cfB, result -> {return result;}, executorService);
//
//        cfA.runAfterEither(cfA, () -> {});
//        cfA.runAfterEitherAsync(cfB, () -> {});
//        cfA.runAfterEitherAsync(cfB, () -> {}, executorService);

        //各个带either的方法，表达的都是一个意思，指的是两个任务中的其中一个执行完成，就执行指定的操作。它们几组的区别也很明显，分别用于表达是否需要任务 A 和任务 B 的执行结果，是否需要返回值。
//        1、cfA.acceptEither(cfB, result -> {}); 和 cfB.acceptEither(cfA, result -> {}); 是一个意思；
//
//        2、第二个变种，加了 Async 后缀的方法，代表将需要执行的任务放到 ForkJoinPool.commonPool() 中执行(非完全严谨)；第三个变种很好理解，将任务放到指定线程池中执行；
//
//        3、难道第一个变种是同步的？不是的，而是说，它由任务 A 或任务 B 所在的执行线程来执行，取决于哪个任务先结束。

    }

    /**
     * thenAcceptBoth 和 thenCombine 用于聚合两个任务，其实 compose 也是一样的功能，它们本质上都是为了让多个 CompletableFuture 实例形成一个链。
     */
    public static void compose() {

        CompletableFuture<String> cfA = CompletableFuture.supplyAsync(() -> {
            System.out.println("processing a...");
            return "hello";
        });

        CompletableFuture<String> cfB = CompletableFuture.supplyAsync(() -> {
            System.out.println("processing b...");
            return " world";
        });

        CompletableFuture<String> cfC = CompletableFuture.supplyAsync(() -> {
            System.out.println("processing c...");
            return ", I'm robot!";
        });


        cfA.thenCombine(cfB, (resultA, resultB) -> {
            System.out.println(resultA + resultB);  // hello world
            return resultA + resultB;
        }).thenCombine(cfC, (resultAB, resultC) -> {
            System.out.println(resultAB + resultC); // hello world, I'm robot!
            return resultAB + resultC;
        });
        // 先有 cfA，然后和 cfB 组成一个链：cfA -> cfB，然后又组合了 cfC，形成链：cfA -> cfB -> cfC。
        // cfA、cfB、cfC 它们完全没有数据依赖关系，我们只不过是聚合了它们的结果.


        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            // 第一个实例的结果
            return "hello";
        }).thenCompose(resultA -> CompletableFuture.supplyAsync(() -> {
            // 把上一个实例的结果传递到这里
            return resultA + " world";
        })).thenCompose(resultAB -> CompletableFuture.supplyAsync(() -> {
            // 到这里大家应该很清楚了
            return resultAB + ", I'm robot";
        }));

        System.out.println(result.join()); // hello world, I'm robot
        //前面一个 CompletableFuture 实例的结果可以传递到下一个实例中，这就是 compose 和 combine 的主要区别。
        //combine 是把结果进行聚合，但是 compose 更像是把多个已有的 cf 实例组合成一个整体的实例。


    }

    public static void composeAndApply() {
        //
        //     public <U> CompletableFuture<U> thenApply(
        //         Function<? super T,? extends U> fn) {
        //         return uniApplyStage(null, fn);
        //     }
        //     public <U> CompletableFuture<U> thenCompose(
        //         Function<? super T, ? extends CompletionStage<U>> fn) {
        //         return uniComposeStage(null, fn);
        //     }
        //
        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync(() -> "hello")
                .thenApply(cfA -> cfA + " world");

        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync(() -> "hello")
                .thenCompose(cfA -> CompletableFuture.supplyAsync(() -> cfA + " world"));
        //它们都需要接收一个 Function，这个函数的主要的区别在于 thenApply 中返回一个具体的值，而 thenCompose 返回一个新的 cf 实例。
        //thenApply 类似于 map 操作，把 cf 实例的结果加工成另一个值，像 Stream 里面的 map() 方法。它还有一个很重要的特征，这里是同步的操作。
        //如果你希望执行一个异步的 map 操作，那么就应该使用 thenCompose 了，比如上面的第二个例子。
    }

}
