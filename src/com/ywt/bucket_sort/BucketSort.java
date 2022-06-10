package com.ywt.bucket_sort;

import com.ywt.SortTemplate;

/**
 * <p>桶排序(Bucket Sort)的原理很简单，将数组分到有限数量的桶子里。
 * 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）</p>
 *
 * 假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。
 * 在桶排序时，创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
 * 在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。例如，读取到数组a[3]=5，则将r[5]的值+1。
 * 在将数据放到桶中之后，再通过一定的算法，将桶中的数据提出出来并转换成有序数组。就得到我们想要的结果了
 *
 * 平均时间复杂度: O(n + k)
 * 最佳时间复杂度: O(n + k)
 * 最差时间复杂度: O(n ^ 2)
 * 空间复杂度: O(n * k)
 *
 * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。
 * 很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
 *
 * <p>稳定性排序</p>
 * @author yiwt
 */
public class BucketSort extends SortTemplate {
    private final int max;
    public BucketSort(int max) {
        this.max = max;
    }

    @Override
    public void sort(int[] array) {
        bucketSort(array, max);
    }

    /**
     *
     * @param array 待排序数组
     * @param max   需要 > 数组中最大值
     */
    private void bucketSort(int[] array, int max) {
        int[] buckets;
        if (array == null || max < 1)
            return;

        buckets = new int[max];

        for (int value : array)
            buckets[value]++;

        for (int i = 0, j = 0; i < max; i++) {
            while ((buckets[i]--) > 0) {
                array[j++] = i;
            }
        }
    }

    public static void main(String[] args) {
        new BucketSort(36).run();
    }
}
