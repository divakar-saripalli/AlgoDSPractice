package com.div.missionfaang.scaler;

public class Scaler {

    static int calcLoops(int n) {
        int count = 0;
        for (int i = n; i > 0; i /= 2) {
            for (int j = 0; j < i; j++) {
                count += 1;
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        int[] arr = {186, 192, 193, 202, 204, 2, 3, 6, 10, 11, 12, 17, 21, 28, 29, 30, 31, 32, 37, 38, 39, 40, 41, 47, 49, 50, 51, 52, 55, 57, 58, 59, 60, 65, 67, 68, 71, 72, 74,
//                77, 78, 80, 82, 83, 88, 89, 90, 94, 100, 107, 108, 109, 111, 112, 114, 115, 116, 118, 119, 121, 123, 124, 126, 129, 133, 134, 135, 137, 138, 144, 147, 148,
//                150, 151, 154, 156, 159, 161, 163, 165, 166, 167, 168, 169, 174, 178, 180, 182, 183, 185};
//        ArrayList<Integer> list = Scaler.convertArrayToList(arr);
//        System.out.println(Scaler.findPivot(list));
//        System.out.println(Scaler.search(list, 6));
//        System.out.println(generateMatrix(1));
//        ArrayList<String> A = new ArrayList<>();
//        A.add("aaaaa");
//        A.add("aaab");
//        A.add("ab");
//        A.add("b");
//        System.out.println(Scaler.prefixMatching(A, "b"));
//
//        arr = new int[]{683, 354, 95, 937, 78, 246, 319, 516, 913, 112};
//        list = Scaler.convertArrayToList(arr);
//        System.out.println(Scaler.maxMod(list));
//
//        System.out.println(Scaler.nextSmallestPalindrome("2345745"));
//        System.out.println(Scaler.nextSmallestPalindrome("999"));
//        System.out.println(Scaler.nextSmallestPalindrome("1001"));
//
//        int[] arr = new int[]{2, 1, 4, 10};
//        int[] arr1 = new int[]{3, 6, 2, 10, 10};
//        ArrayList<Integer> A = Scaler.convertArrayToList(arr);
//        ArrayList<Integer> B = Scaler.convertArrayToList(arr1);
//        System.out.println(Scaler.commonElements(A, B));
//
//        int[] arr1 = new int[]{5, 5, 2, 5, 8};
//        ArrayList<Integer> B = Scaler.convertArrayToList(arr1);
//        System.out.println(Scaler.balancedArray(B));
//        Scaler.isPrime();

    }
}