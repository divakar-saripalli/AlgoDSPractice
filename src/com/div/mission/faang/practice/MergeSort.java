package src.com.div.mission.faang.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {

    public static int[] mergeSort(int[] array, int start, int end) {
	System.out.println("Start :: " + start + "End :: " + end);
	System.out.println(Arrays.toString(array));
	if (start >= end) {
	    if(array[start] > array[end]){
		int temp = array[start];
		array[start] = array[end];
		array[end] = temp;
	    }
	    return array;
	} else {
	    int mid = (end + start) / 2;
	    int[] array1 = mergeSort(array, start, mid);
	    int[] array2 = mergeSort(array, mid + 1, end);
	    System.out.println(Arrays.toString(array1));
	    System.out.println(Arrays.toString(array2));
	    int array2Length = end - mid;
	    int[] resultantArray = new int[mid + array2Length];
	    int i = start;
	    int j = mid+1;

	    while (i < mid || j < array2Length) {
		System.out.println(" i :: " + i + " j :: " + j);
		if (i == mid) {
		    resultantArray[i + j] = array2[j];
		    ++j;
		} else if (j == array2Length) {
		    resultantArray[i + j] = array1[i];
		    ++i;
		} else if (array1[i] < array2[j]) {
		    resultantArray[i + j] = array1[i];
		    ++i;
		} else if (array1[i] > array2[j]) {
		    resultantArray[i + j] = array2[j];
		    ++j;
		}
	    }

	    System.out.println(Arrays.toString(resultantArray));
	    return resultantArray;
	}
    }

    public static List<Integer> mergeSort(List<Integer>array, int start, int end) {
	System.out.println("Start :: " + start + "End :: " + end);
	System.out.println(array.toString());
	if (start >= end) {
	    if(array.get(start) > array.get(end)){
		int temp = array.get(start);
		array.set(start, array.get(end));
		array.set(end, temp);
	    }
	    return array;
	} else {
	    int mid = (end + start) / 2;
	    List<Integer> array1 = mergeSort(array, start, mid);
	    List<Integer> array2 = mergeSort(array, mid + 1, end);
	    System.out.println(array1.toString());
	    System.out.println(array2.toString());
	    int array2Length = end - mid;
	    int i = start;
	    int j = mid+1;

	    while (i < mid || j < array2Length) {
		System.out.println(" i :: " + i + " j :: " + j);
		if (i == mid) {
		    array.set((i + j),array2.get(j));
		    ++j;
		} else if (j == array2Length) {
		    array.set((i + j),array1.get(i));
		    ++i;
		} else if (array1.get(i) < array2.get(j)) {
		    array.set((i + j),array1.get(i));
		    ++i;
		} else if (array1.get(i) > array2.get(j)) {
		    array.set((i + j),array2.get(j));
		    ++j;
		}
	    }

	    System.out.println(array.toString());
	    return array;
	}
    }

    public static void main(String[] args) {
	int[] array = new int[] { 2, 4, 1, 6, 5, 9, 7 };
//	ArrayList<Integer> list = Arrays.asList(array);
//	list =
	List<Integer> list = Arrays.stream(array)
			.boxed()
			.collect(Collectors.toList());
	System.out.println(mergeSort(list, 0, list.size()).toString());
    }
}
