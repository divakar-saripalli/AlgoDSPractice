package com.div.missionfaang.scaler.advanced.recursion;

class Recursion1
{
    private static void printReverseString( String s, int index )
    {
        if( index < s.length() )
        {
            Recursion1.printReverseString( s, index + 1 );
            System.out.print( s.charAt( index ) );
        }
    }

    private static int sumOfDigits( int A )
    {
        if( A >= 10 )
        {
            A = Recursion1.sumOfDigits( A / 10 ) + (A % 10);
        }
        return A;
    }

    private static int anotherSequenceProblem( int A )
    {
        if( A == 0 )
        {
            return 1;
        }
        if( A < 3 )
        {
            return A;
        }
        return A + Recursion1.anotherSequenceProblem( A - 1 ) + Recursion1.anotherSequenceProblem( A - 2 ) + Recursion1.anotherSequenceProblem( A - 3 );
    }

    private static int findAthFibonacci( int A )
    {
        if (A == 0) {
            return A;
        }
        if (A == 1 || A == 2) {
            return 1;
        }
        return Recursion1.findAthFibonacci( A - 1 ) + Recursion1.findAthFibonacci( A - 2 );
    }

    private static int findFactorial(int A) {
        if (A == 1) {
            return 1;
        }
        return A * Recursion1.findFactorial( A - 1 );
    }

    /**
     * @param A
     * @return
     */
    private static int isMagic(int A) {
        if (A < 10) {
            return (A == 1) ? 1 : 0;
        } else {
            int result = 0;
            while (A != 0) {
                result += (A % 10);
                A /= 10;
            }
            return Recursion1.isMagic( result );
        }
    }
}
