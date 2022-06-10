package com.ywt.quick_sort;

import com.ywt.SortTemplate;

import java.util.Arrays;

/**
 * <p>基本思想是: 选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；其中一部分的所有数据都比另外一部分的所有数据都要小。
 * 然后，再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。</p>
 *
 * 实现方式：
 * 从数列中挑出一个基准值。
 * 将所有比基准值小的摆放在基准前面，所有比基准值大的摆在基准的后面(相同的数可以到任一边)；
 * 在这个分区退出之后，该基准就处于数列的中间位置。
 * 递归地把"基准值前面的子数列"和"基准值后面的子数列"进行排序。
 *
 * <p>快速排序是不稳定的算法，它不满足稳定算法的定义。</p>
 *
 * <p>快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。</p>
 *
 * @author yiwt
 */
public class QuickSort extends SortTemplate {
    public static void main(String[] args) {
        new QuickSort().run();
    }

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快排
     * @param array 待排序数组
     * @param left  数组左边界，从 0开始
     * @param right 数组右边界，从 length - 1 开始
     */
    private void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i = left, j = right, x = array[i];
            while (i < j) {
                while (i < j && array[i] < x) {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }
                while (i < j && array[j] > x) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }
            }
            array[i] = x;
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
    }

}
