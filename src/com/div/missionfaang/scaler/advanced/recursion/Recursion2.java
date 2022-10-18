package com.div.missionfaang.scaler.advanced.recursion;

import java.util.ArrayList;

public class Recursion2
{

    private static int kthSymbol( int A, int B )
    {
        if( A == 1 || B == 0 )
        {
            return 0;
        }
        int value = Recursion2.kthSymbol( A - 1, B / 2 );
        if( B % 2 != 0 )
        {
            return value;
        }
        else
        {
            return 1 - value;
        }
    }

    private static ArrayList<Integer> grayCode(int a) {
        if (a == 1) {
            ArrayList<Integer> start = new ArrayList<>();
            start.add(0);
            start.add(1);
            return start;
        }
        ArrayList<Integer> result = Recursion2.grayCode( a - 1 );
        for (int i = result.size() - 1; i > -1; i--) {
            result.add(result.get(i) + (1 << (a - 1)));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println( Recursion2.kthSymbol( 2, 2 ) );
    }
}
