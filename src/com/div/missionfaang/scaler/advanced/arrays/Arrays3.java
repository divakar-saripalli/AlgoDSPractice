package com.div.missionfaang.scaler.advanced.arrays;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Arrays3
{

    private static ArrayList<Integer> maxNonNegativeSubArray( ArrayList<Integer> A )
    {
        long maxSum = 0;
        long newSum = 0;
        ArrayList<Integer> maxArray = new ArrayList<>();
        ArrayList<Integer> newArray = new ArrayList<>();
        for( Integer i : A )
        {
            if( i >= 0 )
            {
                newSum += i;
                newArray.add( i );
            }
            else
            {
                newSum = 0;
                newArray = new ArrayList<>();
            }
            if( (maxSum < newSum) || ((maxSum == newSum) && (newArray.size() > maxArray.size())) )
            {
                maxSum = newSum;
                maxArray = newArray;
            }
        }
        return maxArray;

        /*
         ************************************
         ** My approach which did not work **
         ************************************
         */

        //        ArrayList<Long> prefixSumArray = new ArrayList<>(A.size());
        //        prefixSumArray.add(Long.valueOf(A.get(0)));
        //        for (int i = 1; i < A.size(); i++) {
        //            prefixSumArray.add(prefixSumArray.get(i - 1) + A.get(i));
        //        }
        //
        //        long sum = 0;
        //        long maxSum = Long.MIN_VALUE;
        //        int start = 0;
        //        int end = 0;
        //        int maxStart = -1;
        //        int maxEnd = -1;
        //        if (prefixSumArray.get(0) > 0) {
        //            sum = prefixSumArray.get(0);
        //        }
        //        for (int i = 1; i < prefixSumArray.size(); i++) {
        //            if (A.get(i) < A.get(i - 1)) {
        //                // This means we encountered a negative number.
        //                if (maxSum < sum) {
        //                    maxStart = start;
        //                    maxEnd = end;
        //                    maxSum = sum;
        //                }
        //                sum = 0;
        //                start = i + 1;
        //                end = i + 1;
        //            } else {
        //                sum += prefixSumArray.get(i);
        //                end = i;
        //            }
        //        }
        //        ArrayList<Integer> result = new ArrayList<>();
        //        for (int i = maxStart; i <= maxEnd && i > -1; i++) {
        //            result.add(A.get(i));
        //        }
        //        return result;
    }

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     * You may assume that the intervals were initially sorted according to their start times.
     * <p>
     * Solution:
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    private static ArrayList<Interval> insertOrMergeNewInterval(ArrayList<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        if (newInterval.end < intervals.get(0).start) {
            intervals.add(0, newInterval);
            return intervals;
        }

        if (newInterval.start > intervals.get(intervals.size() - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }

        ArrayList<Interval> newIntervals = new ArrayList<>();
        boolean merged = false;
        for (Interval interval : intervals) {
            if (interval.end <= newInterval.start) {
                newIntervals.add(interval);
            } else if (newInterval.end < interval.start) {
                if (!merged) {
                    newIntervals.add(newInterval);
                    merged = true;
                }
                newIntervals.add(interval);
            } else if (interval.start >= newInterval.end) {
                newIntervals.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        if (!merged) {
            newIntervals.add(newInterval);
        }
        return newIntervals;
    }

    /**
     * Given an unsorted integer array, A of size N. Find the first missing positive integer.
     * Note: Your algorithm should run in O(n) time and use constant space.
     * <p>
     * Solution:
     * <p>
     * Try placing the value at the index where it belongs. After that,
     * traverse from the start and find the index which is not having intended value and return index+1.
     *
     * @param A
     * @return
     */
    private static int firstMissingPositive(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); ) {
            // Current element should be greater than 0
            // Current element should be lesser than Array size
            // Current element is not its index + 1
            // Element at the index 0f current element value is also not the current element value, meaning if there are 
            // duplicates and the same value is not already placed at that index already.
            if (A.get(i) > 0 && A.get(i) < A.size() && A.get(i) != i + 1 && !A.get(A.get(i) - 1).equals(A.get(i))) {
                int temp = A.get(i);
                A.set(i, A.get(temp - 1));
                A.set(temp - 1, temp);
            } else {
                i++;
            }
        }

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        return A.size() + 1;
    }

    /**
     * You are given an array of N integers, A1, A2, .... AN.
     * <p>
     * Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
     * <p>
     * Solution:
     * <p>
     * f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are looking at max value,
     * we don’t even care if the value becomes negative as long as we are also covering the max value in some way).
     * <p>
     * (A[i] + i) - (A[j] + j)
     * -(A[i] - i) + (A[j] - j)
     * (A[i] - i) - (A[j] - j)
     * (-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
     * Note that case 1 and 4 are equivalent and so are case 2 and 3.
     * <p>
     * We can construct two arrays with values: A[i] + i and A[i] - i. Then, for the above 2 cases, we find the maximum value possible.
     * For that, we just have to store minimum and maximum values of expressions A[i] + i and A[i] - i for all i.
     *
     * @param A
     * @return
     */
    private static int maxAbsoluteDifference(ArrayList<Integer> A) {
//        O(N^2) Approach
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < A.size(); i++) {
//            for (int j = i + 1, k = A.size() - 1; j < k; j++, k--) {
//                max = Math.max(max, (Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j)));
//                max = Math.max(max, (Math.abs(A.get(i) - A.get(k)) + Math.abs(i - k)));
//            }
//        }
//        return max;

//        O(N) approach
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int val1 = A.get(i) + i;
            int val2 = A.get(i) - i;
            max1 = Math.max(max1, val1);
            max2 = Math.max(max2, val2);
            min1 = Math.min(min1, val1);
            min2 = Math.min(min2, val2);
        }
        return Math.max(max1 - min1, max2 - min2);
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * @param intervals
     * @return
     */
    private static ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervals) {
        intervals = (ArrayList<Interval>) Arrays3.mergeSort( intervals );

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i).start = Math.min(intervals.get(i).start, intervals.get(i + 1).start);
                intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
                intervals.remove(i + 1);
                i--;
            }
        }
        return intervals;
    }

    private static List<Interval> mergeSort(List<Interval> array)
    {
        if( array.size() < 3 )
        {
            if( array.size() > 1 && array.get( 0 ).start > array.get( 1 ).start )
            {
                Interval temp = array.get( 0 );
                array.set( 0, array.get( 1 ) );
                array.set( 1, temp );
            }
            return array;
        }
        else
        {
            int mid = array.size() / 2;
            List<Interval> leftArray = array.subList( 0, mid );
            List<Interval> rightArray = array.subList( mid, array.size() );
            List<Interval> array1 = Arrays3.mergeSort( leftArray );
            List<Interval> array2 = Arrays3.mergeSort( rightArray );
            List<Interval> resultantArray = new ArrayList<>( array1.size() + array2.size() );
            int i = 0;
            int j = 0;

            while( i + j < array1.size() + array2.size() )
            {
                Interval resultantArrayNextValue;
                if( i < array1.size() && j < array2.size() )
                {
                    if( array1.get( i ).start < array2.get( j ).start )
                    {
                        resultantArrayNextValue = array1.get( i++ );
                    }
                    else
                    {
                        resultantArrayNextValue = array2.get( j++ );
                    }
                }
                else if( i < array1.size() )
                {
                    resultantArrayNextValue = array1.get( i++ );
                }
                else
                {
                    resultantArrayNextValue = array2.get( j++ );
                }

                resultantArray.add( resultantArrayNextValue );
            }
            return resultantArray;
        }
    }

    /**
     * Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
     * <p>
     * NOTE:
     * <p>
     * If two rows have the maximum number of 1 then return the row which has a lower index.
     * Rows are numbered from top to bottom and columns are numbered from left to right.
     * Assume 0-based indexing.
     * Assume each row to be sorted by values.
     * Expected time complexity is O(rows).
     * <p>
     * Solution:
     * <p>
     * If the matrix is sorted, starting from Top-Right or Bottom-Left would give better
     * suggestion on which direction to go towards.
     * <p>
     * Hence, Start from Top left of the matrix. If the value is 1, decrease column by 1.
     * Otherwise, go to next row.
     * Increase the count each time you encounter a 1.
     *
     * @param A
     * @return
     */
    private static int maxOnes(ArrayList<ArrayList<Integer>> A) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        int maxRow = 0;
        for (int i = 0, j = A.get(0).size() - 1; i < A.size() && j > -1; ) {
            if (A.get(i).get(j) == 1) {
                if (count == 0 && max > 0) {
                    count = max + 1;
                } else {
                    count++;
                }
                j--;
            } else {
                if (count > max) {
                    maxRow = i;
                    max = count;
                }
                i++;
                count = 0;
            }
        }
        if (count > max) {
            return A.size() - 1;
        }
        return maxRow;
    }

    private static int minimumSwaps(ArrayList<Integer> A, int B) {
        int count = 0;
        for (Integer integer : A) {
            if (integer <= B) {
                count++;
            }
        }
        int currentCount = 0;
        for (int i = 0; i < count; i++) {
            if (A.get(i) > B) {
                currentCount++;
            }
        }
        int min = currentCount;
        for (int i = count, j = 0; i < A.size(); i++, j++) {
            if (A.get(i) <= B && A.get(j) > B) {
                currentCount--;
            } else if (A.get(i) > B && A.get(j) <= B) {
                currentCount++;
            }
            min = Math.min(min, currentCount);

        }
        return min;
    }

    /**
     * Given an array of integers A of size N that is a permutation of [0,1,2,...,(N-1)].
     * It is allowed to swap any two elements (not necessarily consecutive).
     * <p>
     * Find the minimum number of swaps required to sort the array in ascending order.
     * <p>
     * Approach:
     * Given the fact that the numbers are from [0,1,2,...,(N-1)], if the array is to be
     * sorted, then the element with value i should be present at index i.
     * <p>
     * This implies that if the numbers are not sorted, all of them would form a cycle.
     * <p>
     * E.g.
     * []
     *
     * @param A
     * @return
     */
    private static int minimumSwaps2(ArrayList<Integer> A) {
        boolean[] visited = new boolean[A.size()];
        int count = 0;
        int finalCount = 0;
        for (int value : A) {
            while (!visited[value]) {
                visited[value] = true;
                count++;
                value = A.get( value );
            }
            finalCount += Math.max( count - 1, 0 );
            count = 0;
        }
        return finalCount;
    }

    private static int maxChunksToBeSorted( ArrayList<Integer> A )
    {
        int max = A.get( 0 );
        int count = 0;
        for( int i = 0; i < A.size(); i++ )
        {
            max = Math.max( max, A.get( i ) );
            if( max == i )
            {
                count++;
            }
        }
        return count;
    }

    private static int maximumGap( List<Integer> A )
    {
        //        ArrayList<Integer> rightMax = new ArrayList<>();
        //        int max = Integer.MIN_VALUE;
        //        for(int i = A.size() - 1; i > -1; i--){
        //            rightMax.add(0, Math.max(max, A.get(i)));
        //            max = Math.max(max, A.get(i));
        //        }
        //
        //        max = 0;
        //        for(int i = 0, j = 0; i < A.size() && j < A.size();){
        //            if(A.get(i) <= rightMax.get(j)){
        //                max = Math.max(max, j - i);
        //                j++;
        //            }else{
        //                i++;
        //            }
        //        }
        //        return max;
        if( A.size() == 1 )
        {
            return 0;
        }
        ArrayList<ArrayList<Integer>> arrayWithIndexInfo = new ArrayList<>();
        for( int i = 0; i < A.size(); i++ )
        {
            ArrayList<Integer> valueWithIndex = new ArrayList<>();
            valueWithIndex.add( A.get( i ) );
            valueWithIndex.add( i );
            arrayWithIndexInfo.add( valueWithIndex );
        }
        arrayWithIndexInfo.sort( new ValueComparator() );

        int maxIndex = arrayWithIndexInfo.get( arrayWithIndexInfo.size() - 1 ).get( 1 );
        int ans = 0;
        for( int i = arrayWithIndexInfo.size() - 2; i > -1; i-- )
        {
            ans = Math.max( ans, maxIndex - arrayWithIndexInfo.get( i ).get( 1 ) );
            maxIndex = Math.max( maxIndex, arrayWithIndexInfo.get( i ).get( 1 ) );
        }
        return ans;
    }

    public static void main( String[] args )
    {

        //        ArrayList<Interval> intervals = new ArrayList<>();
        //        intervals.add(new Interval(3, 5));
        //        intervals.add(new Interval(8, 10));

        //        System.out.println(Arrays3.insertOrMergeNewInterval(intervals, new Interval(1, 12)));

        //        int[] arr1 = new int[]{417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327};
        int[] arr1 = new int[] { 1, 2, 3, 4, 0 };
        ArrayList<Integer> array = ArrayUtility.convertArrayToList( arr1 );
        System.out.println( Arrays3.minimumSwaps2( array ) );

    }

    static class Interval {
        private int start;
        private int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString()
        {
            return start + ", " + end;
        }
    }

}

class ValueComparator implements Comparator<ArrayList<Integer>>
{
    @Override
    public int compare( ArrayList<Integer> a, ArrayList<Integer> b )
    {
        int diff = a.get( 0 ) - b.get( 0 );
        if( diff == 0 )
        {
            return diff;
        }
        return diff > 0 ? 1 : -1;
    }
}
