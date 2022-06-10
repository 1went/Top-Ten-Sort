package com.ywt.bubble_sort;

import com.ywt.SortTemplate;

/**
 * <p>
 * 冒泡排序。它会遍历若干次要排序的数列，每次遍历时，它都会从前往后依次的比较相邻两个数的大小；
 * 如果前者比后者大，则交换它们的位置。这样，一次遍历之后，最大的元素就在数列的末尾！
 * 采用相同的方法再次遍历时，第二大的元素就被排列在最大元素之前。重复此操作，直到整个数列都有序为止！
 * <p/>
 *
 * <p>时间复杂度 O(n^2)</p>
 *
 * <p>
 * 稳定性分析：冒泡排序是稳定的算法，它满足稳定算法的定义。
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 * </p>
 * @author yiwt
 */
public class BubbleSort extends SortTemplate {
    public static void main(String[] args) {
        new BubbleSort().run();
    }
    // 常规版
//    public void sort(int[] arrays) {
//        for (int i = arrays.length - 1; i >= 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if (arrays[j] > arrays[j + 1]) {
//                    swap(arrays, j, j + 1);
//                }
//            }
//        }
//    }

    // 改进版
    @Override
    public void sort(int[] arrays) {
        // 记录最后一次交换的位置
        int lastExchangeIndex = 0;
        // 数组边界，每次比较到这里就可以了
        int sortBorder = arrays.length - 1;
        for (int i = 0; i < arrays.length - 1; i++) {
            // 有序标记，每一轮的初始值都是 true
            boolean isSorted = true;
            for (int j = 0; j < sortBorder; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    swap(arrays, j, j + 1);
                    // 因为有元素交换，所以不是有序
                    isSorted = false;
                    // 更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }

    private static void swap(int[] arrays, int one, int two) {
        int tmp = arrays[one];
        arrays[one] = arrays[two];
        arrays[two] = tmp;
    }
}
