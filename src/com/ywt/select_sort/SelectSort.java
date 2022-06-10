package com.ywt.select_sort;

import com.ywt.SortTemplate;

import java.util.Arrays;

/**
 * <p>它的基本思想是: 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕</p>
 *
 * <p>选择排序的时间复杂度是O(N2)。</p>
 *
 * <p>常认为选择排序是不稳定的</p>
 *
 * @author yiwt
 */
public class SelectSort extends SortTemplate {
    public static void main(String[] args) {
        new SelectSort().run();
    }

    @Override
    public void sort(int[] array) {
        int i;    // 有序区的末尾
        int j;    // 无序区的起始
        int min;  // 无序区的最小元素下标

        for (i = 0; i < array.length; i++) {
            min = i;
            // 在array[i+1]...array[n-1]中找到最小值
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
    }
}
