package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class ArrayOfProducts {
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int product = 1;
        int zeroIndex = -1;
        int multipleZeros = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroIndex = i;
                multipleZeros = multipleZeros << 1;
            } else {
                product *= array[i];
            }
        }
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (multipleZeros > 1) {
                if (multipleZeros < 3 && zeroIndex == i) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = product / array[i];
            }
        }
        return result;
    }

    public static int[] arrayOfProductsAlgoExpert(int[] array) {
        // Write your code here.
        int left = 1;
        int right = 1;
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = left;
            left *= array[i];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= array[i];
        }
        return result;
    }

    public static void main(String[] args) {
//		arrayOfProductsAlgoExpert(new int[] { 1, 2, 3, 4, 5, 6 });
//		arrayOfProductsAlgoExpert(new int[] { 1, 2, 3, 0, 5, 6 });
//		arrayOfProductsAlgoExpert(new int[] { 0, 2, 3, 0, 5, 6 });
//		arrayOfProductsAlgoExpert(new int[] { 5, 8, 4, 1, 2 });

        System.out.println(Arrays.toString(arrayOfProducts(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{1, 2, 3, 0, 5, 6})));
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{0, 2, 3, 0, 5, 6})));
        System.out.println(Arrays.toString(arrayOfProducts(new int[]{5, 8, 4, 1, 2})));
    }
}
