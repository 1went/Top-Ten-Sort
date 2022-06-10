package com.ywt;

import java.util.Arrays;

/**
 * 模板
 * @author yiwt
 */
public abstract class SortTemplate {
    public void run() {
        int[] arr = {5,1,3,6,7,35,16,22};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public abstract void sort(int[] array);
}
