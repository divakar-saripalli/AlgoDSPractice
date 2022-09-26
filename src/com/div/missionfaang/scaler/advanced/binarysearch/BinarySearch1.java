package com.div.missionfaang.scaler.advanced.binarysearch;

import com.div.missionfaang.scaler.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch1 {

    /**
     * Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * <p>
     * NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.
     *
     * @param A
     * @param B
     * @return
     */
    private static int sortedInsertPosition(ArrayList<Integer> A, int B) {
        if (A.get(0) >= B) {
            return 0;
        }

        if (A.get(A.size() - 1) == B) {
            return A.size() - 1;
        }

        if (A.get(A.size() - 1) < B) {
            return A.size();
        }
        int left = 1;
        int right = A.size() - 2;
        int mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (A.get(mid) == B) {
                return mid;
            }
            if (A.get(mid) < B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return (A.get(mid) > B) ? mid : mid + 1;
    }

    /**
     * Given an array of integers A, find and return the peak element in it. An array element is peak if it is NOT smaller than its neighbors.
     * <p>
     * For corner elements, we need to consider only one neighbor. We ensure that answer will be unique.
     * <p>
     * NOTE: Users are expected to solve this in O(log(N)) time. The array may have duplicate elements.
     *
     * @param A
     * @return
     */
    private static int findPeakElement(ArrayList<Integer> A) {
        if (A.size() == 1 || A.get(0) > A.get(1)) {
            return A.get(0);
        }

        if (A.get(A.size() - 1) > A.get(A.size() - 2)) {
            return A.get(A.size() - 1);
        }

        int left = 1;
        int right = A.size() - 2;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A.get(mid - 1) < A.get(mid) &&
                    A.get(mid + 1) < A.get(mid)) {
                return A.get(mid);
            } else if (A.get(mid + 1) > A.get(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return A.get(mid);
    }

    /**
     * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
     * <p>
     * This matrix A has the following properties:
     * <p>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than or equal to the last integer of the previous row.
     * Return 1 if B is present in A, else return 0.
     * <p>
     * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
     *
     * @param A
     * @param B
     * @return
     */
    private static int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int i = 0;
        int j = A.get(0).size() - 1;
        while (i < A.size() && j > -1) {
            if (A.get(i).get(j) == B) {
                return 1;
            }
            if (A.get(i).get(j) < B) {
                i++;
            } else {
                j--;
            }
        }
        return 0;
    }

    /**
     * Given a sorted array of integers A of size N and an integer B.
     * <p>
     * array A is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
     * <p>
     * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * NOTE: Users are expected to solve this in O(log(N)) time.
     *
     * @param A
     * @param B
     * @return
     */
    private static int rotatedSortedArraySearch(List<Integer> A, int B) {
        if (A.get(0) == B) {
            return 0;
        }
        if (A.get(A.size() - 1) == B) {
            return A.size() - 1;
        }
        int left = 0;
        int right = A.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) > A.get(0) && A.get(mid) > B && B > A.get(0)) {
                right = mid - 1;
            } else if (A.get(mid) > A.get(0) && A.get(mid) > B && B < A.get(0)) {
                left = mid + 1;
            } else if (A.get(mid) > A.get(0) && A.get(mid) < B) {
                left = mid + 1;
            } else if (A.get(mid) < A.get(A.size() - 1) && A.get(mid) < B && B < A.get(A.size() - 1)) {
                left = mid + 1;
            } else if (A.get(mid) < A.get(A.size() - 1) && A.get(mid) > B) {
                right = mid - 1;
            } else if (A.get(mid) < A.get(A.size() - 1) && A.get(mid) < B && B > A.get(A.size() - 1)) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static double findMedianSortedArrays(List<Integer> a, List<Integer> b) {
        if (a.size() == 0) {
            return (b.size() % 2 != 0) ? b.get(b.size() / 2) : (b.get(b.size() / 2) + b.get(b.size() / 2 - 1)) / 2.0d;
        }

        if (b.size() == 0) {
            return (a.size() % 2 != 0) ? a.get(a.size() / 2) : (a.get(a.size() / 2) + a.get(a.size() / 2 - 1)) / 2.0d;
        }

        int i = 0;
        int j = 0;
        int[] median = new int[2];
        while (i + j <= (a.size() + b.size()) / 2) {
            if (j == b.size() || (i < a.size() && a.get(i) <= b.get(j))) {
                median[0] = median[1];
                median[1] = a.get(i);
                i++;
            } else {
                median[0] = median[1];
                median[1] = b.get(j);
                j++;
            }
        }

        if ((a.size() + b.size()) % 2 != 0) {
            return median[1];
        } else {
            return (((double) (median[0] + median[1])) / 2.0d);
        }
    }

    public static void main(String[] args) {
//        int[] arr1 = new int[]{
//                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33,
//                34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
//                64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93,
//                94, 95, 96, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119,
//                120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139,
//                140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163,
//                164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187,
//                188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 208, 209, 210, 211, 212,
//                213, 214, 215, 216, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237,
//                239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262,
//                263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 283, 284, 285, 286, 287,
//                289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 309, 310, 311, 312, 313,
//                314, 315, 316, 317, 318, 319, 320, 321, 322, 324, 325, 326, 328, 329, 330, 331, 332, 333, 335, 336, 337, 338, 339, 340,
//                341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364,
//                365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388,
//                389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 413,
//                414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437,
//                438, 440, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463,
//                464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487,
//                488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511,
//                512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535,
//                536, 537, 538, 539, 540, 541, 542, 543, 544, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560,
//                561, 562, 563, 564, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585,
//                586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609,
//                610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634,
//                635, 636, 638, 639, 640, 641, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660,
//                661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685,
//                686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709,
//                710, 711, 712, 713, 714, 715, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734,
//                735, 736, 737, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759,
//                760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783,
//                784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807,
//                808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831,
//                832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855,
//                856, 857, 858, 859, 861, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881,
//                882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905,
//                906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929,
//                930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953,
//                954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977,
//                978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001};

//        int[] arr1 = new int[]{
//                3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140,
//                141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285,
//                293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438,
//                445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605,
//                612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778,
//                783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919,
//                937, 946, 948, 951, 961, 971, 979, 980, 986, 993
//        };

//        A : [ -37, -9, 10, 19 ]
//        B : [ -29, 18, 46 ]

//        A : [ -49, 33, 35, 42 ]
//        B : [ -26 ]

//        A : [ -1 ]
//        B : [ -1, 0, 4, 11, 18 ]

//        int[] arr1 = new int[]{-50, -47, -36, -35, 0, 13, 14, 16};
//        int[] arr2 = new int[]{-31, 1, 9, 23, 30, 39};

        int[] arr1 = new int[]{38, 40, 41, 43, 45, 47, 28, 29, 31, 33, 34, 36};
        int[] arr2 = new int[]{-1, 0, 4, 11, 18};

        ArrayList<Integer> array1 = ArrayUtility.convertArrayToList(arr1);
        ArrayList<Integer> array2 = ArrayUtility.convertArrayToList(arr2);
        System.out.println(BinarySearch1.rotatedSortedArraySearch(array1, 47));
    }
}
