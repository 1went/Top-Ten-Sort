package com.ywt.merge_sort;

import com.ywt.SortTemplate;

/**
 * 分解 -- 将当前区间一分为二，即求分裂点 mid = (low + high)/2;
 * 求解 -- 递归地对两个子区间a[low...mid] 和 a[mid+1...high]进行归并排序。递归的终结条件是子区间长度为1。
 * 合并 -- 将已排序的两个子区间a[low...mid]和 a[mid+1...high]归并为一个有序的区间a[low...high]。
 *
 * <p>归并排序的时间复杂度是O(N*lgN)。</p>
 * <p>归并排序是稳定的算法</p>
 * @author yiwt
 */
public class MergeSort extends SortTemplate {

    public static void main(String[] args) {
        new MergeSort().run();
    }

    @Override
    public void sort(int[] array) {
        int[] helper = new int[array.length];
        sort(array, 0, array.length - 1, helper);
    }

    private void sort(int[] array, int low, int high, int[] helper) {
        if (array == null || low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(array, low, mid, helper);
        sort(array, mid + 1, high, helper);
        merge(array, low, mid, high, helper);
    }

    private void merge(int[] array, int low, int mid, int high, int[] helper) {
//        for (int i = low; i <= high; i++) {
//            helper[i] = array[i];
//        }
        if (high + 1 - low >= 0)
            System.arraycopy(array, low, helper, low, high + 1 - low);

        int i = low;  // 左边有序区间的起始位置
        int j = mid + 1;  // 右边有序区间的起始位置
        for (int k = low; k <= high; k++) {
            if (i > mid) {  // 当左边的数组合并完成后，只需要合并右边
                array[k] = helper[j++];
            } else if (j > high) {  // 当右边的合并完成后，只需要合并左边的
                array[k] = helper[i++];
            } else if (helper[i] <= helper[j]) {
                array[k] = helper[i++];
            } else {
                array[k] = helper[j++];
            }
        }
    }
}
