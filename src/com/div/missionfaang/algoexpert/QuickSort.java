package com.div.missionfaang.algoexpert;

import java.util.Arrays;

public class QuickSort
{
    private static int[] quickSort( int[] array )
    {
        if( array.length > 1 )
        {
            for( int i = 0; i < array.length; i++ )
            {
                QuickSort.quickSelect( array, i );
                System.out.println( Arrays.toString( array ) );
            }
        }
        return array;
    }

    private static void quickSelect( int[] array, int k )
    {
        int i = 0;
        int j = k + 1;

        while( i < k || j < array.length )
        {
            if( i < k && j < array.length )
            {
                if( array[i] < array[k] && array[j] > array[k] )
                {
                    i++;
                    j++;
                }
                else if( array[i] > array[k] && array[j] < array[k] )
                {
                    QuickSort.swap( array, j, i );
                    i++;
                    j++;
                }
                else if( array[i] > array[k] )
                {
                    QuickSort.swap( array, k, i );
                    i++;
                }
                else if( array[j] < array[k] )
                {
                    QuickSort.swap( array, k, j );
                    j++;
                }
                else if( array[i] < array[k] )
                {
                    i++;
                }
                else if( array[j] > array[k] )
                {
                    j++;
                }
            }
            else if( i < k )
            {
                if( array[i] > array[k] )
                {
                    QuickSort.swap( array, k, i );
                }
                i++;
            }
            else
            {
                if( array[j] < array[k] )
                {
                    QuickSort.swap( array, k, j );
                }
                j++;
            }
        }
    }

    private static void swap(int[] array, int k, int i) {
        int temp = array[i];
        array[i] = array[k];
        array[k] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 8, 5, 9, 5, 6, 3};
        System.out.println( Arrays.toString( QuickSort.quickSort( array ) ) );
    }
}
