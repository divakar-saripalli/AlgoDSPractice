package com.div.missionfaang.scaler.intermediate.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

public class PrefixSum {
    private static int equilibriumIndex(ArrayList<Integer> A) {
        int index = -1;
        Integer arraySummation = 0;
        for (Integer integer : A) {
            arraySummation += integer;
        }

        Integer leftSum = 0;
        Integer rightSum = arraySummation - A.get(0);

        for (int i = 0; i < A.size() - 1; i++) {
            if (leftSum.equals(rightSum)) {
                index = i;
                break;
            } else {
                leftSum += A.get(i);
                rightSum -= A.get(i + 1);
            }
        }
        if (leftSum == 0 && index == -1) {
            index = A.size() - 1;
        }
        return index;
    }

    private static int pickFromBothSides(ArrayList<Integer> A, int B) {
        ArrayList<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(A.get(i) + prefixSum.get(i - 1));
        }

        if (B == A.size()) {
            return prefixSum.get(A.size() - 1);
        }

        int max = (prefixSum.get(A.size() - 1) - prefixSum.get(A.size() - B - 1));
        for (int i = 0; i < B - 1; i++) {
            int startIndex = A.size() - (B - i);
            int endIndex = A.size() - 1;
            int currentSum = prefixSum.get(i) + (prefixSum.get(endIndex) - prefixSum.get(startIndex));
            if (currentSum > max) {
                max = currentSum;
            }
        }
        if (prefixSum.get(B - 1) > max) {
            return prefixSum.get(B - 1);
        }
        return max;
    }

    private static int findBalancingArrayIndices(ArrayList<Integer> A) {
        int count = 0;
        if (A.size() < 3) {
            return 0;
        }

        Integer leftOddSum = 0;
        Integer leftEvenSum = A.get(0);
        Integer rightOddSum = 0;
        Integer rightEvenSum = 0;
        for (int i = 1; i < A.size(); i++) {
            if (i % 2 != 0) {
                rightOddSum += A.get(i);
            } else {
                rightEvenSum += A.get(i);
            }
        }

        // Checks the condition if the first index is a special index
        if (rightEvenSum.equals(rightOddSum)) {
            count++;
        }

        for (int i = 1; i < A.size() - 1; i++) {

            if (i % 2 != 0) {
                rightOddSum -= A.get(i);
            } else {
                rightEvenSum -= A.get(i);
            }

            if (leftEvenSum + rightOddSum == rightEvenSum + leftOddSum) {
                count++;
            }
            if (i % 2 != 0) {
                leftOddSum += A.get(i);
            } else {
                leftEvenSum += A.get(i);
            }
        }

        // Checks the condition if the last index is a special index
        if (leftOddSum.equals(leftEvenSum)) {
            count++;
        }
        return count;
    }

  private static int specialIndex( ArrayList<Integer> A )
  {
        int count = 0;
    if( A.size() < 3 )
    {
            return 0;
        }

        ArrayList<Integer> evenPrefixSum = new ArrayList<>();
        ArrayList<Integer> oddPrefixSum = new ArrayList<>();
    evenPrefixSum.add( A.get( 0 ) );
    evenPrefixSum.add( A.get( 0 ) );
    oddPrefixSum.add( 0 );
    oddPrefixSum.add( A.get( 1 ) );
    for( int i = 2; i < A.size(); i++ )
    {
      if( i % 2 == 0 )
      {
        evenPrefixSum.add( evenPrefixSum.get( i - 1 ) + A.get( i ) );
        oddPrefixSum.add( oddPrefixSum.get( i - 1 ) );
      }
      else
      {
        oddPrefixSum.add( oddPrefixSum.get( i - 1 ) + A.get( i ) );
        evenPrefixSum.add( evenPrefixSum.get( i - 1 ) );
            }
        }

    if( evenPrefixSum.get( evenPrefixSum.size() - 1 ) - A.get( 0 ) == oddPrefixSum.get( oddPrefixSum.size() - 1 ) )
    {
            count++;
        }

    for( int i = 1; i < A.size(); i++ )
    {
      if( i % 2 == 0 )
      {
        int evenSum = evenPrefixSum.get( i ) - A.get( i ) + (oddPrefixSum.get( oddPrefixSum.size() - 1 ) - oddPrefixSum.get( i ));
        int oddSum = oddPrefixSum.get( i ) + (evenPrefixSum.get( evenPrefixSum.size() - 1 ) - evenPrefixSum.get( i ));
        if( evenSum == oddSum )
        {
                    count++;
                }
      }
      else
      {
        int oddSum = oddPrefixSum.get( i ) - A.get( i ) + (evenPrefixSum.get( evenPrefixSum.size() - 1 ) - evenPrefixSum.get( i ));
        int evenSum = evenPrefixSum.get( i ) + (oddPrefixSum.get( oddPrefixSum.size() - 1 ) - oddPrefixSum.get( i ));
        if( evenSum == oddSum )
        {
                    count++;
                }
            }
        }
        return count;
    }

    private static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> resultArray = new ArrayList<>();
        ArrayList<Long> prefixSumArray = new ArrayList<>(A.size());
        if (A.size() < 2) {
            for (int i = 0; i < B.size(); i++) {
                if (A.size() == 1) {
                    resultArray.add(Long.valueOf(A.get(0)));
                } else {
                    resultArray.add(0L);
                }
            }
        } else {
            prefixSumArray.add(Long.valueOf(A.get(0)));
            for (int i = 1; i < A.size(); i++) {
                prefixSumArray.add(prefixSumArray.get(i - 1) + A.get(i));
            }
            for (ArrayList<Integer> range : B) {
                Integer start = range.get(0) - 1;
                Integer end = range.get(1) - 1;
                if (start == 0) {
                    resultArray.add(prefixSumArray.get(end));
                } else {
                    resultArray.add(prefixSumArray.get(end) - prefixSumArray.get(start - 1));
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 7, 1, 2, 3};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
      System.out.println( PrefixSum.specialIndex( array ) );
    }
}
