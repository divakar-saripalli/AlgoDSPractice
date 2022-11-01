package com.div.missionfaang.scaler.advanced.gcd;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;

/**
 * Important GCD formulae:
 * <p>
 * gcd(a. b) == gcd(a, b-a)
 * <p>
 * gcd(a, b) == gcd(a, b%a)
 * <p>
 * lcm(a, b) == (a*b)/gcd(a,b)
 */
public class GCD {

    /**
     * Scooby has 3 three integers A, B, and C.
     * <p>
     * Scooby calls a positive integer special if it is divisible by B, and it is divisible by C.
     * You need to tell the number of special integers less than or equal to A.
     *
     * @param A
     * @param B
     * @param C
     * @return
     */
    private static int divisorGame( int A, int B, int C )
    {
        int count = 0;
        int divisor = 0;
        if( B % C == 0 )
        {
            divisor = C;
        }
        else if( C % B == 0 )
        {
            divisor = B;
        }
        else
        {
            divisor = GCD.gcd( B, C );
            divisor *= (B / divisor) * (C / divisor);
        }
        if( A > divisor )
        {
            A -= (A % divisor);
            count = A / divisor;
        }
        return count;
    }

    private static int gcd( int A, int B )
    {
        if( A == B )
        {
            return A;
        }

        if( A == 0 )
        {
            return B;
        }

        if( B == 0 )
        {
            return A;
        }

        if( A == 1 || B == 1 )
        {
            return 1;
        }

        if( B < A )
        {
            int temp = A;
            A = B;
            B = temp;
        }
        return GCD.gcd( A, B % A );
    }

    private static int deleteOne( ArrayList<Integer> A )
    {
        int[] prefixGCDArray = new int[A.size()];
        int[] suffixGCDArray = new int[A.size()];

        prefixGCDArray[0] = A.get( 0 );
        suffixGCDArray[A.size() - 1] = A.get( A.size() - 1 );

        for( int i = 1; i < A.size(); i++ )
        {
            prefixGCDArray[i] = GCD.gcd( prefixGCDArray[i - 1], A.get( i ) );
        }

        for( int i = A.size() - 2; i >= 0; i-- )
        {
            suffixGCDArray[i] = GCD.gcd( suffixGCDArray[i + 1], A.get( i ) );
        }
        int maxGCD = Integer.MIN_VALUE;
        for( int i = 0; i < A.size(); i++ )
        {
            int leftGCD = 0;
            int rightGCD = 0;
            if( i == 0 )
            {
                maxGCD = suffixGCDArray[i + 1];
            }
            else if( i == A.size() - 1 )
            {
                maxGCD = Math.max( maxGCD, prefixGCDArray[i - 1] );
            }
            else
            {
                leftGCD = prefixGCDArray[i - 1];
                rightGCD = suffixGCDArray[i + 1];
                maxGCD = Math.max( maxGCD, GCD.gcd( leftGCD, rightGCD ) );
            }
        }
        return maxGCD;
    }

    public static void main( String[] args )
    {
        //        System.out.println( GCD.divisorGame( 411753753, 1876, 7430 ) );
        //        int[] a = new int[] { 12, 30, 15, 18, 24 };
        //        int[] a = new int[] { 7, 21 };
        int[] a = new int[] { 12, 15, 18 };
        ArrayList<Integer> A = ArrayUtility.convertArrayToList( a );
        System.out.println( GCD.deleteOne( A ) );

        //        System.out.println( GCD.gcd( 7, 21 ) );
    }
}
