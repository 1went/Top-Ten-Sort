package com.ywt.insert_sort;


import com.ywt.SortTemplate;


/**
 * <p>
 * 直接插入排序(Straight Insertion Sort)的基本思想是:
 * 把 n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含 1个元素，
 * 无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，
 * 重复 n-1次可完成排序过程。
 * </p>
 *
 * <p>直接插入排序的时间复杂度是O(N2)。</p>
 * <p>直接插入排序是稳定的算法</p>
 * @author yiwt
 */
public class InsertSort extends SortTemplate {
    public static void main(String[] args) {
        new InsertSort().run();
    }

    @Override
    public void sort(int[] array) {
        int i, j, k;
        // 从 1开始，默认第 0个元素有序
        for (i = 1; i < array.length; i++) {
            // 待插入元素 array[i]，搜寻这个元素合适的插入位置
            for (j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    break;
                }
            }
            if (j != i - 1) {
                // 记录待插入元素
                int tmp = array[i];
                // 将该元素插入位置之后的元素后移
                for (k = i - 1; k > j; k--) {
                    array[k + 1] = array[k];
                }
                array[k + 1] = tmp;
            }
        }
    }
}
