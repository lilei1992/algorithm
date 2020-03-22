package com.tb.algorithm;

import java.util.Arrays;

/**
 * 排序算法
 *
 * @author: lilei
 * @time: 2020/3/21 16:14
 */
public class SortAlgorithm {


    /**
     * @param array
     * @description: 冒泡排序
     * @return:
     * @author: lilei
     * @time: 2020/3/21 21:00
     */
    public int[] bubbleSort(int[] array) {

        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }

        }
        return array;

    }


    /**
     * 将数据根据第一个位置处理,小于的在左边,大于在右边,并返回当前下标.
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] arr, int start, int end) {
        int tmp = arr[start];
        while (start < end) {

            while (start < end && arr[end] >= tmp) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= tmp) {
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = tmp;
        return start;
    }

    public void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int partition = partition(array, start, end);
            quickSort(array, start, partition - 1);
            quickSort(array, partition+1 , end);
        }

    }


    public static void main(String[] args) {
        SortAlgorithm sortAlgorithm = new SortAlgorithm();
        int arr[] = new int[]{6, 7, 2, 4, 9, 0, 1, 3, 5, 8};
        System.out.println(Arrays.toString(arr));
        sortAlgorithm.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


}
