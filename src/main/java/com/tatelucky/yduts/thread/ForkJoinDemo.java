package com.tatelucky.yduts.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoinDemo 思想类似递归，打一个大人物
 *
 * @author tangsheng
 * @since 2019-11-27
 */
public class ForkJoinDemo {


    //RecursiveTask：用于有返回值的任务。
    //RecursiveAction：用于没有返回值的任务。
    private static class TaskCount extends RecursiveTask<Integer> {
        private static final int MIN_THRESHOLD = 5;
        private int start;
        private int end;

        public TaskCount(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            //业务逻辑
            int result = 0;
            boolean shouldCompute = (end - start) <= MIN_THRESHOLD;
            if (shouldCompute) {
                for (int i = start; i <= end; ++i) {
                    result += i;
                }
            } else {
                int middle = (start + end) >>> 1;
                TaskCount taskA = new TaskCount(start, middle);
                TaskCount taskB = new TaskCount(middle + 1, end);

                taskA.fork();
                taskB.fork();

                Integer resultA = taskA.join();
                Integer resultB = taskB.join();

                result = resultA + resultB;
            }


            return result;
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //1 + .... + 100
        TaskCount taskCount = new TaskCount(1, 100000000);

        long start = System.currentTimeMillis();
        Future<Integer> future = forkJoinPool.submit(taskCount);


        try {
            System.out.println(future.get());
            long end = System.currentTimeMillis();
            System.out.println("fork join time: " + (end - start));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (taskCount.isCompletedAbnormally()) {
            System.out.println(taskCount.getException().getMessage());
        }

        int result = 0;
        long start1 = System.currentTimeMillis();
        for (int i = 1; i <= 100000000; i++) {
            result += i;
        }
        System.out.println(result);
        long end1 = System.currentTimeMillis();
        System.out.println("for: " + (end1 - start1));

    }
}
