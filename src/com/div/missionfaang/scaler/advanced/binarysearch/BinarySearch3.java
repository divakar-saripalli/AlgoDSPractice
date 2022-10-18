package com.div.missionfaang.scaler.advanced.binarysearch;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch3
{

    private static int paint( int A, int B, ArrayList<Integer> C )
    {
        int mod = 10000003;
        int maxLength = Integer.MIN_VALUE;
        int totalLength = 0;
        for( int boardLength : C )
        {
            totalLength += boardLength;
            maxLength = Math.max( maxLength, boardLength );
        }

        if( A == 1 )
        {
            long result = (long) totalLength * B;
            return (int) (((result % mod) + mod) % mod);
        }

        while( maxLength <= totalLength )
        {
            int mid = (maxLength + totalLength) / 2;
            int paintersCount = 0;
            int workload = 0;
            int i = 0;
            for( ; i < C.size() && paintersCount <= A; i++ )
            {
                if( (workload + C.get( i )) > mid )
                {
                    paintersCount++;
                    workload = C.get( i );
                }
                else
                {
                    workload += C.get( i );
                }
            }
            if( paintersCount >= A )
            {
                maxLength = mid + 1;
            }
            else
            {
                totalLength = mid - 1;
            }
        }
        long result = (long) maxLength * B;
        return (int) (((result % mod) + mod) % mod);
    }

    /**
     * Problem Description
     * Given an array of integers A of size N and an integer B.
     * <p>
     * The College library has N books. The ith book has A[i] number of pages.
     * <p>
     * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
     * <p>
     * A book will be allocated to exactly one student.
     * Each student has to be allocated at least one book.
     * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
     * Calculate and return that minimum possible number.
     * <p>
     * NOTE: Return -1 if a valid assignment is not possible.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 10^5
     * 1 <= A[i], B <= 10^5
     *
     * @param A
     * @param B
     * @return
     */
    private static int books( ArrayList<Integer> A, int B )
    {
        int minPages = Integer.MAX_VALUE;
        int totalPages = 0;
        for( int pages : A )
        {
            totalPages += pages;
            minPages = Math.min( minPages, pages );
        }

        if( B == 1 )
        {
            return totalPages;
        }

        if( B == A.size() )
        {
            return minPages;
        }

        while( minPages <= totalPages )
        {
            int mid = (minPages + totalPages) / 2;
            int studentsCount = 0;
            int currentPages = 0;
            int i = 0;
            for( ; i < A.size(); i++ )
            {
                if( (currentPages + A.get( i )) > mid )
                {
                    studentsCount++;
                    currentPages = A.get( i );
                }
                else
                {
                    currentPages += A.get( i );
                }
            }
            if( studentsCount > B )
            {
                minPages = mid + 1;
            }
            else
            {
                totalPages = mid - 1;
            }
        }
        return minPages;
    }

    /**
     * Problem Description
     * Farmer John has built a new long barn with N stalls.
     * Given an array of integers A of size N where each element of the array
     * represents the location of the stall and an integer B which represents the number of cows.
     * <p>
     * <p>
     * His cows don't like this barn layout and become aggressive towards each other once put into a stall.
     * To prevent the cows from hurting each other, John wants to assign the cows to the stalls,
     * such that the minimum distance between any two of them is as large as possible.
     * What is the largest minimum distance?
     * <p>
     * Problem Constraints
     * 2 <= N <= 100000
     * 0 <= A[i] <= 109
     * 2 <= B <= N
     *
     * @param A
     * @param B
     * @return
     */
    private static int aggressiveCows( ArrayList<Integer> A, int B )
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( Integer integer : A )
        {
            min = Math.min( min, integer );
            max = Math.max( max, integer );
        }

        if( B == 2 )
        {
            return max - min;
        }

        if( B == A.size() )
        {
            int secondMin = Integer.MAX_VALUE;
            for( Integer integer : A )
            {
                if( integer != min )
                {
                    secondMin = Math.min( secondMin, integer );
                }
            }
            return secondMin - min;
        }

        Collections.sort( A );

        int left = 1;
        int right = max - min;
        int maxPossibleLength = right;
        while( left <= right )
        {
            int mid = (left + right) / 2;
            int count = 1;
            int lastCowIndex = 0;
            for( int i = 1; i < A.size() && count < B; i++ )
            {
                if( (A.get( i ) - A.get( lastCowIndex )) >= mid )
                {
                    count++;
                    lastCowIndex = i;
                }
            }
            if( count == B )
            {
                left = mid + 1;
                maxPossibleLength = mid;
            }
            else
            {
                right = mid - 1;
            }
        }
        return maxPossibleLength;
    }

    /**
     * Problem Description
     * The government wants to set up B distribution offices across N cities for the distribution of food packets.
     * The population of the ith city is A[i].
     * Each city must have at least 1 office, and people can go to an office of their own city.
     * We want to maximize the minimum number of people who can get food in any single office.
     * <p>
     * <p>
     * <p>
     * Problem Constraints
     * 1 <= N <= 10^5
     * <p>
     * 1 <= A[i] <= 10^6
     * <p>
     * 1 <= B <= 5 x 10^5
     *
     * @param A
     * @param B
     * @return
     */
    private static int foodPacketsDistribution( ArrayList<Integer> A, int B )
    {
        if( A.size() == 1 )
        {
            return A.get( 0 ) / B;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long total = 0;
        for( Integer integer : A )
        {
            min = Math.min( min, integer );
            max = Math.max( max, integer );
            total += integer;
        }

        if( B == 1 )
        {
            return (int) total;
        }

        if( total < B )
        {
            return 0;
        }

        int left = 1;
        int right = min;

        Collections.sort( A );

        int mid;
        int minNoOfPersons = Integer.MAX_VALUE;
        while( left <= right )
        {
            mid = (left + right) / 2;
            int stallsCount = 0;
            for( Integer persons : A )
            {
                int stalls = (persons / mid);
                stallsCount += stalls;
            }

            if( stallsCount >= B )
            {
                left = mid + 1;
                minNoOfPersons = mid;
            }
            else
            {
                right = mid - 1;
            }
        }
        return minNoOfPersons;
    }

    public static void main( String[] args )
    {
        //        int[] arr1 = new int[]{1000, 2000, 3000};
        //        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        //        System.out.println(BinarySearch3.foodPacketsDistribution(array1, 6));
        //        int[] arr1 = new int[]{1, 1, 1};
        //        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        //        System.out.println(BinarySearch3.foodPacketsDistribution(array1, 4));
        //        int[] arr1 = new int[]{8, 7, 1, 5, 5, 10, 10, 1, 5, 3};
        //        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        //        System.out.println(BinarySearch3.foodPacketsDistribution(array1, 17));
        //        int[] arr1 = new int[] { 2, 9, 5, 4 };
        //        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
        //        System.out.println( BinarySearch3.foodPacketsDistribution( array1, 13 ) );

        //        int[] arr1 = new int[] { 7919, 4522, 1397, 1533, 9122, 4283, 2040, 9874, 7721, 2591, 8029, 1506, 7050, 6109, 6771, 1344, 872, 5228, 717, 3129, 855,
        //            8036, 2276, 3767, 7479, 7387, 2172, 8413, 6041, 570, 8644, 2161, 7690, 2444, 7243, 1765, 532, 5581, 8063, 3257, 6111, 4479, 8640, 7626, 8563, 4707,
        //            7819, 381, 3759, 5049, 8091, 6604, 9125, 6434, 5888, 8577, 4843, 5183, 4300, 1791, 1665, 6903, 4301, 1383, 9904, 1198, 6289, 1849, 116, 9450, 1433,
        //            2700, 1899, 2263, 5445, 1402, 1142, 9431, 6604, 6799, 7301, 6970, 4206, 4322, 9114, 7913, 8101, 7518, 1990, 3814, 354, 9705, 6973, 3960, 6442, 2535,
        //            4904, 4596, 6021, 5698, 1601, 2998, 856, 869, 4850, 6503, 3686, 994, 4579, 4973, 4165, 6632, 6063, 3278, 4008, 973, 7430, 904, 5371, 7063, 2100,
        //            6536, 9839, 2062, 2734, 3139, 4650, 4013, 4909, 8280, 7497, 6994, 721, 3070, 907, 7973, 904, 9143, 360, 9800, 3561, 5717, 4054, 7288, 5324, 6292,
        //            9883, 6386, 9564, 7702, 2493, 9916, 9907, 7159, 2062, 9453, 9024, 4332, 6986, 8087, 7490, 6265, 4759, 3017, 4657, 3603, 3050, 5004, 6456, 1659,
        //            8151, 6561, 7975, 5779, 8111, 6058, 4059, 1163, 4940, 4916, 2661, 2661, 3767, 4327, 5489, 5162, 8482, 2101, 7013, 4296, 7683, 6173, 3979, 3974,
        //            2561, 4403, 5991, 8757, 1082, 3296, 4703, 5962, 5518, 9191, 2697, 9789, 5992, 8807, 9370, 6495, 8497, 6218, 8310, 5557, 9269, 3769, 5472, 4632,
        //            8057, 5002, 200, 3842, 3893, 848, 5718, 4293, 1432, 8622, 8078, 6246, 7309, 6261, 4148, 8333, 7584, 3404, 6180, 3390, 5313, 178, 9562, 265, 7662,
        //            5571, 7954, 7233, 8423, 9466, 1634, 4475, 3600, 4085, 1625, 312, 867, 6309, 911, 8020, 6189, 4476, 3335, 2120, 1719, 6546, 6803, 2914, 3186, 1624,
        //            1716, 4818, 2001, 7675, 4853, 2965, 1777, 3827, 5595, 3233, 6507, 2956, 4072, 4087, 9679, 7868, 525, 5427, 9223, 541, 8596, 7730, 8075, 5031, 5288,
        //            924, 9379, 1763, 5608, 6594, 4954, 2247, 3027, 5530, 2797, 2482, 5795, 9935, 3110, 8423, 5695, 9558, 8845, 3422, 8588, 9090, 8757, 7885, 5292, 5687,
        //            9366, 8286, 4460, 9543, 9098, 9462, 6800, 251, 5835, 172, 5710, 1359, 2434, 5192, 8674, 756, 3126, 2491, 2291, 7005, 1933, 169, 5306, 8651, 2815,
        //            4837, 8182, 4159, 2653, 3066, 6228, 7947, 6275, 4409, 2354, 1367, 7552, 8621, 5654, 3677, 5067, 3361, 7051, 6292, 5719, 7921, 5758, 7043, 8498,
        //            3825, 2385, 5587, 9359, 803, 8974, 1733, 8931, 5823, 1966, 5145, 3951, 4215, 2309, 4421, 3636, 9108, 5824, 1753, 5633, 1121, 2880, 7620, 9046, 6415,
        //            7992, 3767, 4197, 1781, 4441, 8761, 8057, 7371, 9017, 2417, 9563, 8110, 7042, 238, 3528, 9204, 5976, 1915, 6311, 3025, 912, 1277, 4278, 4293, 8133,
        //            3925, 9533, 4216, 4044, 8019, 6603, 6132, 7397, 8072, 7142, 2795, 6254, 3599, 7339, 6559, 5817, 7172, 1113, 4513, 6560, 4755, 5798, 2438, 969, 7261,
        //            7887, 3594, 3255, 3898, 8294, 6628, 8701, 7311, 4773, 4600, 9857, 751, 778, 8316, 2552, 8102, 5125, 1086, 1626, 5445, 3815, 2613, 6891, 4898, 994,
        //            8693, 7924, 1183, 8788, 4920, 994, 1132, 1459, 9299, 2681, 7817, 8038, 8017, 6240, 8199, 8872, 425, 3305, 4308, 6635, 9639, 8215, 2843, 9890, 7136,
        //            5781, 452, 6445, 1273, 2301, 949, 5898, 9385, 9450, 1908, 6035, 9374, 3057, 5301, 9782, 8653, 8092, 2880, 973, 9275, 1792, 4649, 6330, 3908, 8196,
        //            4989, 8614, 5011, 6706, 2804, 8713, 9579, 4930, 9371, 1027, 3200, 1249, 8149, 8965, 5704, 2274, 4232, 9248, 6926, 8964, 2822, 5307, 9764, 4857,
        //            2625, 1780, 3953, 7338, 7234, 3084, 160, 7380, 9604, 5447, 5020, 7969, 406, 2349, 7281, 8456, 7381, 5421, 386, 1374 };
        //        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
        //        System.out.println( BinarySearch3.foodPacketsDistribution( array1, 3619 ) );

        int[] arr1 = new int[] { 1730, 3188, 1462, 7252, 2060, 9557, 6440, 4666, 7499, 2624, 9353, 8028, 5703, 9744, 4884, 2809, 8716, 2012, 9422, 7912, 7074,
            1465, 4414, 5475, 4864, 4962, 4687, 3923, 7807, 3565, 7951, 3085, 1580, 2716, 5034, 9488, 8305, 3111, 9546, 9046, 3684, 3285, 3037, 9195, 3836,
            1411, 1055, 6980, 4643, 4773, 1098, 7073, 1265, 4986, 8560, 6366, 1762, 9077, 5174, 5489, 7062, 8227, 2074, 6185, 1159, 3852, 9887, 8241, 2465,
            5466, 7871, 4986, 603, 504, 8884, 1602, 8480, 8315, 4866, 4182, 2605, 1581, 6653, 5336, 2901, 7380, 6895, 483, 4270, 4264, 5803, 7883, 3259, 4116,
            9364, 1431, 7323, 4352, 8030, 4398, 4170, 2598, 242, 5843, 538, 2512, 2933, 7264, 3455, 6485, 3931, 8862, 9263, 4320, 3030, 8574, 1399, 7015, 7678,
            5457, 3471, 8341, 4659, 6397, 2633, 5748, 947, 8017, 8235, 9794, 9390, 2581, 1990, 3160, 2627, 7257, 6688, 763, 9112, 4291, 8619, 9295, 6022, 2839,
            8997, 5821, 8330, 4225, 4378, 5900, 9127, 8917, 3594, 1718, 2834, 5527, 9672, 4007, 7486, 1385, 3000 };
        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList( arr1 );
        System.out.println( BinarySearch3.foodPacketsDistribution( array1, 4371 ) );
    }
}
