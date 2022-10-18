package com.div.missionfaang.scaler.advanced.hashing;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing2 {

    /**
     * Problem Description
     * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
     * for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
     * <p>
     * Find and return the number of unordered quadruplet (i, j, k, l) such that
     * (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle
     * with the rectangle having all the sides parallel to either x-axis or y-axis.
     *
     * @param A
     * @param B
     * @return
     */
    private static int countRectangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            set.add(A.get(i) + "," + B.get(i));
        }
        int diagonalsCount = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < B.size(); j++) {
                String point1 = A.get(i) + "," + B.get(i);
                String point2 = A.get(j) + "," + B.get(j);
                String point3 = A.get(i) + "," + B.get(j);
                String point4 = A.get(j) + "," + B.get(i);
                if (!point1.equals(point2)) {
                    if (!point1.equals(point3) &&
                            !point2.equals(point4) &&
                            !point1.equals(point4) &&
                            !point2.equals(point3) &&
                            set.contains(point3) && set.contains(point4)) {
                        diagonalsCount++;
                    }
                }
            }
        }
        return (diagonalsCount > 1) ? diagonalsCount / 2 : diagonalsCount;
    }

    /**
     * Problem Description
     * Given two arrays of integers A and B of size N each,
     * where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
     * <p>
     * Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j])
     * and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
     * <p>
     * NOTE: The answer may be large so return the answer modulo (109 + 7).
     *
     * @param A
     * @param B
     * @return
     */
    public int countRightTriangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Long> xAxis = new HashMap<>();
        HashMap<Integer, Long> yAxis = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if( xAxis.containsKey( A.get( i ) ) )
            {
                xAxis.put( A.get( i ), xAxis.get( A.get( i ) ) + 1 );
            }
            else
            {
                xAxis.put( A.get( i ), 1L );
            }

            if( yAxis.containsKey( B.get( i ) ) )
            {
                yAxis.put( B.get( i ), yAxis.get( B.get( i ) ) + 1 );
            }
            else
            {
                yAxis.put( B.get( i ), 1L );
            }
        }

        long count = 0;
        for( int i = 0; i < A.size(); i++ )
        {
            count += (xAxis.get( A.get( i ) ) - 1) * (yAxis.get( B.get( i ) ) - 1);
        }
        return (int) (count % 1000000007);
    }

    /**
     * Problem Description
     * <p>
     * Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented
     * as a concatenation of A similar strings.
     * <p>
     * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
     * <p>
     * If it is possible, return 1, else return -1.
     * <p>
     * Problem Constraints
     * <p>
     * 1 <= Length of string B <= 1000
     * <p>
     * 1 <= A <= 1000
     * <p>
     * All the alphabets of S are lower case (a - z)
     *
     * @param A
     * @param B
     * @return
     */
    private static int replicatingSubstring( int A, String B )
    {

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for( int i = 0; i < B.length(); i++ )
        {
            if( frequencyMap.containsKey( B.charAt( i ) ) )
            {
                frequencyMap.put( B.charAt( i ), frequencyMap.get( B.charAt( i ) ) + 1 );
            }
            else
            {
                frequencyMap.put( B.charAt( i ), 1 );
            }
        }

        for( Integer frequency : frequencyMap.values() )
        {
            if( frequency % A != 0 )
            {
                return -1;
            }
        }
        return 1;
    }

    public static void main( String[] args )
    {
        int[] a = new int[] { 9, 5, 1, 1, 3, 7, 7, 9, 6, 9, 2, 8 };
        int[] b = new int[] { 8, 1, 5, 3, 8, 5, 4, 5, 2, 2, 7, 9 };
        ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
        ArrayList<Integer> B = ArrayUtility.convertArrayToList( b );
        System.out.println( Hashing2.countRectangles( A, B ) );
    }

    //    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    //    }

    /**
     * Problem Description
     * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
     * <p>
     * NOTE:
     * <p>
     * Each element in the result should appear as many times as it appears in both arrays.
     * The result can be in any order.
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N, M <= 10^5
     * <p>
     * 1 <= A[i] <= 10^9
     *
     * @param A
     * @param B
     * @return
     */
    public ArrayList<Integer> commonElements( ArrayList<Integer> A, ArrayList<Integer> B )
    {
        HashMap<Integer, Integer> aFrequencyMap = new HashMap<>();
        for( Integer integer : A )
        {
            if( aFrequencyMap.containsKey( integer ) )
            {
                aFrequencyMap.put( integer, aFrequencyMap.get( integer ) + 1 );
            }
            else
            {
                aFrequencyMap.put( integer, 1 );
            }
        }

        HashMap<Integer, Integer> bFrequencyMap = new HashMap<>();
        for( Integer integer : B )
        {
            if( bFrequencyMap.containsKey( integer ) )
            {
                bFrequencyMap.put( integer, bFrequencyMap.get( integer ) + 1 );
            }
            else
            {
                bFrequencyMap.put( integer, 1 );
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for( Integer key : aFrequencyMap.keySet() )
        {
            if( bFrequencyMap.containsKey( key ) )
            {
                int frequency = Math.min( aFrequencyMap.get( key ), bFrequencyMap.get( key ) );
                for( int i = 0; i < frequency; i++ )
                {
                    result.add( key );
                }
            }
        }
        return result;
    }
}
