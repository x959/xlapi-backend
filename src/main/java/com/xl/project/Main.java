package com.xl.project;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 9, 3, 7, 2, 8, 6, 4, 10, 15, 12, 11, 13, 14};

        int[] topNumbers = findTop10Numbers(numbers);
        System.out.println("最大的10个数为：");
        for (int num : topNumbers) {
            System.out.println(num);
        }
    }

    private static int[] findTop10Numbers(int[] numbers) {
        //初始化一个容量为10的堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10);
        for (int num : numbers) {
            if (minHeap.size() < 10) { // 堆未满，直接插入
                minHeap.offer(num);
            } else if (num > minHeap.peek()) { // 当前数字比堆顶元素大，替换堆顶元素
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        int[] result = new int[10];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i] = minHeap.poll();
            i++;
        }

        return result;
    }
}
