package com.div.missionfaang.scaler.advanced.binarysearch;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch2 {

    /**
     * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.
     * <p>
     * NOTE:
     * <p>
     * A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.
     *
     * @param A
     * @param B
     * @return
     */
    private static int searchInBitonicArray(ArrayList<Integer> A, int B) {
        if (A.get(0) == B) {
            return 0;
        }
        if (A.get(A.size() - 1) == B) {
            return A.size() - 1;
        }
        if (B < A.get(0) && B < A.get(A.size() - 1)) {
            return -1;
        }
        int left = 1;
        int right = A.size() - 2;
        while (left <= right) {
            int midIndex = (left + right) / 2;
            Integer midValue = A.get(midIndex);
            if (midValue == B) {
                return midIndex;
            } else {
                Integer midMinus1Value = A.get(midIndex - 1);
                if (midValue < B && midValue > midMinus1Value) {
                    left = midIndex + 1;
                } else if (midValue < B && midValue < midMinus1Value) {
                    right = midIndex - 1;
                } else if (midValue > B && midValue > midMinus1Value) {
                    right = midIndex - 1;
                } else if (midValue > B && midValue < midMinus1Value) {
                    left = midIndex + 1;
                }
            }
        }
        return -1;
    }

    /**
     * Given an integer A.
     * <p>
     * Compute and return the square root of A.
     * <p>
     * If A is not a perfect square, return floor(sqrt(A)).
     * <p>
     * DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
     * <p>
     * NOTE: Do not use the sqrt function from the standard library. Users are expected to solve this in O(log(A)) time.
     *
     * @param A
     * @return
     */
    private static int sqrt(int A) {
        long left = 0;
        long right = A;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if ((mid * mid) == A) {
                return (int) mid;
            } else if ((mid * mid) < A) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    private static int kthPrice(List<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer price : A) {
            min = Math.min(min, price);
            max = Math.max(max, price);
        }

        if (B == 1) {
            return min;
        }

        if (B == A.size()) {
            return max;
        }

        while (min <= max) {
            int countOfSmallerNumbers = 0;
            int countOfEqualNumbers = 0;
            int mid = (min + max) / 2;
            for (Integer price : A) {
                if (price < mid) {
                    countOfSmallerNumbers++;
                } else if (price == mid) {
                    countOfEqualNumbers++;
                }
            }
            if ((((countOfSmallerNumbers + countOfEqualNumbers) == B) && countOfEqualNumbers > 0) || ((countOfSmallerNumbers < B) && (countOfSmallerNumbers + countOfEqualNumbers) > B)) {
                return mid;
            } else if ((countOfSmallerNumbers + countOfEqualNumbers) < B) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * You are given three positive integers, A, B, and C.
     * <p>
     * Any positive integer is magical if divisible by either B or C.
     * <p>
     * Return the Ath the smallest magical number. Since the answer may be very large, return modulo 109 + 7.
     *
     * @param A
     * @param B
     * @param C
     * @return
     */
    private static int athMagicalNumber(int A, int B, int C) {
        long left = Math.min(C, B);
        long right = left * A;
        long ans = 1;
        while (left <= right) {
            long mid = (left + right) / 2;
            long bMultiples = mid / B;
            long cMultiples = mid / C;
            int gcdOfBC = BinarySearch2.gcd(B, C);
            int lcmOfBC = (B * C) / gcdOfBC;
            long bcMultiples = mid / lcmOfBC;
            long divisors = bMultiples + cMultiples - bcMultiples;
            if (divisors == A) {
                ans = mid;
                right = mid - 1;
            } else if (divisors < A) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    private static int gcd(int B, int A) {
        if (A == B) {
            return A;
        }

        if (A == 0) {
            return B;
        }

        if (B == 0) {
            return A;
        }

        if (A == 1 || B == 1) {
            return 1;
        }

        if (B < A) {
            int temp = A;
            A = B;
            B = temp;
        }
        return BinarySearch2.gcd(A, B % A);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                3, 5, 7, 24, 25, 40, 41, 56, 57, 64, 75, 79, 100, 118, 121, 129, 130, 132, 135, 145, 149, 153, 154, 158, 165, 171, 184,
                186, 192, 193, 199, 209, 214, 220, 223, 225, 240, 241, 243, 262, 264, 267, 284, 287, 305, 306, 307, 321, 327, 331, 334,
                342, 344, 346, 347, 352, 360, 370, 373, 391, 396, 397, 411, 413, 416, 418, 423, 428, 437, 438, 440, 441, 445, 455, 477,
                488, 491, 503, 505, 508, 515, 521, 526, 531, 554, 573, 578, 590, 602, 615, 619, 620, 628, 632, 634, 636, 642, 648, 668,
                678, 687, 700, 703, 705, 706, 720, 722, 726, 728, 732, 733, 735, 736, 747, 750, 754, 757, 758, 765, 767, 777, 788, 795,
                797, 800, 809, 811, 815, 818, 823, 824, 825, 829, 831, 833, 841, 846, 851, 852, 860, 864, 868, 876, 878, 884, 886, 894,
                900, 901, 906, 909, 923, 930, 938, 944, 949, 957, 965, 973, 978, 984, 988, 990, 994, 1006, 1020, 1026, 1031, 1043, 1058,
                1074, 1076, 1080, 1083, 1086, 1091, 1093, 1096, 1099, 1108, 1118, 1122, 1123, 1129, 1131, 1145, 1147, 1148, 1154, 1167,
                1181, 1198, 1206, 1207, 1217, 1228, 1234, 1255, 1257, 1258, 1262, 1277, 1280, 1286, 1298, 1310, 1311, 1312, 1325, 1340,
                1342, 1354, 1357, 1361, 1369, 1377, 1378, 1390, 1392, 1393, 1399, 1402, 1403, 1405, 1406, 1408, 1422, 1424, 1427, 1429,
                1436, 1437, 1438, 1447, 1452, 1453, 1462, 1463, 1469, 1473, 1475, 1481, 1482, 1492, 1494, 1505, 1513, 1515, 1529, 1530,
                1539, 1546, 1569, 1576, 1581, 1603, 1614, 1619, 1620, 1629, 1631, 1658, 1677, 1678, 1685, 1688, 1696, 1697, 1698, 1704,
                1706, 1707, 1710, 1713, 1726, 1728, 1732, 1743, 1750, 1769, 1774, 1778, 1782, 1792, 1807, 1812, 1815, 1820, 1822, 1853,
                1858, 1862, 1869, 1877, 1882, 1897, 1899, 1900, 1902, 1908, 1923, 1927, 1928, 1930, 1933, 1934, 1940, 1941, 1948, 1953,
                1954, 1959, 1983, 1991, 1998, 2000,
                1997, 1992, 1982, 1980, 1979, 1975, 1970, 1956, 1943, 1938, 1935, 1918, 1914, 1907, 1898, 1891, 1876, 1871, 1865, 1857,
                1855, 1852, 1847, 1840, 1839, 1835, 1824, 1811, 1808, 1800, 1796, 1795, 1791, 1790, 1788, 1780, 1776, 1771, 1770, 1764,
                1753, 1724, 1723, 1717, 1711, 1686, 1679, 1674, 1672, 1670, 1663, 1657, 1650, 1648, 1639, 1635, 1634, 1630, 1627, 1622,
                1621, 1615, 1608, 1604, 1600, 1595, 1584, 1572, 1571, 1568, 1561, 1557, 1550, 1543, 1540, 1537, 1524, 1520, 1516, 1514,
                1503, 1500, 1496, 1495, 1491, 1486, 1485, 1484, 1478, 1466, 1464, 1456, 1450, 1443, 1439, 1433, 1430, 1425, 1421, 1420,
                1409, 1407, 1401, 1385, 1381, 1379, 1375, 1374, 1372, 1367, 1358, 1355, 1352, 1351, 1349, 1348, 1344, 1331, 1323, 1308,
                1305, 1289, 1275, 1272, 1271, 1265, 1260, 1244, 1243, 1232, 1229, 1225, 1220, 1218, 1212, 1210, 1209, 1201, 1197, 1182,
                1172, 1169, 1161, 1160, 1157, 1143, 1136, 1133, 1106, 1105, 1094, 1092, 1090, 1087, 1075, 1071, 1057, 1056, 1055, 1054,
                1050, 1049, 1038, 1037, 1034, 1033, 1023, 1012, 1009, 1005, 1004, 1001, 996, 977, 970, 963, 951, 948, 940, 929, 914, 910,
                908, 905, 899, 898, 897, 895, 892, 888, 883, 875, 874, 850, 849, 843, 840, 839, 836, 830, 822, 817, 812, 807, 805, 798,
                790, 789, 786, 785, 768, 766, 763, 761, 759, 756, 753, 746, 745, 743, 737, 734, 730, 716, 711, 701, 697, 691, 688, 684,
                683, 679, 673, 667, 664, 654, 651, 650, 649, 644, 640, 637, 633, 630, 629, 626, 614, 613, 606, 605, 594, 583, 579, 571,
                570, 564, 553, 552, 544, 542, 541, 532, 519, 517, 512, 504, 498, 494, 486, 484, 482, 475, 473, 466, 462, 461, 460, 459,
                439, 424, 406, 402, 389, 380, 374, 371, 364, 348, 337, 335, 333, 324, 322, 314, 313, 311, 310, 303, 301, 298, 286, 279,
                274, 251, 249, 248, 238, 237, 231, 228, 215, 191, 189, 187, 185, 177, 162, 157, 117, 115, 109, 108, 107, 105, 104, 101,
                99, 94, 89, 82, 81, 77, 74, 72, 71, 70, 58, 52, 32, 26, 22, 18, 15, 10};

//        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
//        System.out.println(BinarySearch2.searchInBitonicArray(array1, 841));
//        System.out.println(BinarySearch2.athMagicalNumber(807414236, 3788, 38141));

        arr1 = new int[]{
                60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4,
                10, 47, 1, 99, 91, 53, 99, 18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62
        };

        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        System.out.println(BinarySearch2.kthPrice(array1, 22));
    }
}
