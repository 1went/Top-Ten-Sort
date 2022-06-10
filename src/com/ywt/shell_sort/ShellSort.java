package com.ywt.shell_sort;

import com.ywt.SortTemplate;

import java.util.Arrays;

/**
 * <p>
 * 希尔排序实质上是一种分组插入方法。它的基本思想是:
 * 对于 n个待排序的数列，取一个小于 n的整数 gap(gap被称为步长)将待排序元素分成若干个组子序列，所有距离为 gap的倍数的记录放在同一个组中；
 * 然后，对各组内的元素进行直接插入排序。 这一趟排序完成之后，每一个组的元素都是有序的。然后减小 gap的值，并重复执行上述的分组和排序。
 * 重复这样的操作，当 gap=1时，整个数列就是有序的。</p>
 *
 * <p>希尔排序的时间复杂度与增量(步长 gap)的选取有关。例如，当增量为1时，希尔排序退化成了直接插入排序，此时的时间复杂度为O(N²)</p>
 *
 * <p>
 * 希尔排序是按照不同步长对元素进行插入排序，当刚开始元素很无序的时候，步长最大，所以插入排序的元素个数很少，速度很快；
 * 当元素基本有序了，步长很小， 插入排序对于有序的序列效率很高。所以，希尔排序的时间复杂度会比O(n^2)好一些。
 * 由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，
 * 但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以shell排序是不稳定的。</p>
 *
 * @author yiwt
 */
public class ShellSort extends SortTemplate {

    public static void main(String[] args) {
        new ShellSort().run();
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;
        // gap为步长，每次减为原来的一半
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 共 gap个组，对每一组都执行直接插入排序
            for (int i = 0; i < gap; i++) {
                groupSort(array, n, i, gap);
            }
        }
    }

    /**
     * 对希尔排序中的单个组进行排序
     * @param array 待排序的数组
     * @param n     数组总的长度
     * @param i     组的起始位置
     * @param gap   组的步长
     */
    private static void groupSort(int[] array, int n, int i, int gap) {
        for (int j = i + gap; j < n; j += gap) {
            // 如果 a[j] < a[j-gap]，则寻找 a[j]位置，并将后面数据的位置都后移。
            if (array[j] < array[j - gap]) {
                int tmp = array[j];
                int k = j - gap;
                while (k >= 0 && array[k] > tmp) {
                    array[k + gap] = array[k];
                    k -= gap;
                }
                array[k + gap] = tmp;
            }
        }
    }

}
