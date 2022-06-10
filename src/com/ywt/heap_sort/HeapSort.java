package com.ywt.heap_sort;

import com.ywt.SortTemplate;

/**
 * 基于最大堆的升序排序
 *
 * <p>堆排序的时间复杂度是O(N*lgN)。</p>
 *
 * <p>堆排序是不稳定的算法，它不满足稳定算法的定义。
 * 它在交换数据的时候，是比较父结点和子节点之间的数据，
 * 所以，即便是存在两个数值相等的兄弟节点，它们的相对顺序在排序也可能发生变化。</p>
 *
 * @author yiwt
 */
public class HeapSort extends SortTemplate {

    public static void main(String[] args) {
        new HeapSort().run();
    }

    @Override
    public void sort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            int tmp = array[i];
            array[i] = array[0];
            array[0] = tmp;
            heapJust(array, 0, i);
        }
    }

    /**
     * @param array  对 array建立大根堆
     */
    private void buildMaxHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            heapJust(array, i, array.length);
        }
    }

    /**
     * 将父节点元素下沉到合适位置
     * @param array        数组
     * @param parentIndex  父节点元素位置
     * @param length       数组长度
     */
    private void heapJust(int[] array, int parentIndex, int length) {
        int tmp = array[parentIndex];
        int child = 2 * parentIndex + 1;
        while (child < length) {
            // 得到左孩子和右孩子中最大的那个
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            // 如果当前元素已经比孩子节点大，就停止
            if (tmp >= array[child]) {
                break;
            }
            // 否则将孩子节点上移
            array[parentIndex] = array[child];
            parentIndex = child;
            child = 2 * child + 1;
        }
        array[parentIndex] = tmp;
    }
}
