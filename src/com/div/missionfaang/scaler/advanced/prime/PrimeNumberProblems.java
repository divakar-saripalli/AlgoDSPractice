package com.div.missionfaang.scaler.advanced.prime;

import com.div.missionfaang.scaler.ArrayUtility;
import com.div.missionfaang.scaler.advanced.modulararithmetic.ModularArithmetic;

import java.util.ArrayList;

public class PrimeNumberProblems {

    private static ArrayList<Integer> countOfDivisors(ArrayList<Integer> A) {
        int sum = A.size() * 2;
        return new ArrayList<>();
    }

    /**
     * Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
     * <p>
     * If there is more than one solution possible, return the lexicographically smaller solution.
     * <p>
     * If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
     * [a, b] < [c, d], If a < c OR a==c AND b < d.
     * <p>
     * NOTE: A solution will always exist. Read Goldbach's conjecture.
     * <p>
     * Approach : Build the "Seive of Eratosthenes"
     *
     * @param A
     * @return
     */
    private static ArrayList<Integer> primesum(int A) {
        // Considering the array size to be 1 greater than A to avoid the
        // loop increment complications. Hence 0 and 1 are also in effect
        // considered as primes. This needs to be handled while consuming
        // the seive.
        boolean[] seive = new boolean[A + 1];
        seive[0] = false;
        seive[1] = false;
        // Running the loop starting from 2 to sqrt(A) because, beyond the sqrt(A) will be
        // definitely greater than A.
        for (int i = 2; i * i <= A; i++) {
            for (int j = i * i; j < A; j += i) {
                seive[j] = true;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int j = 2; j < A; j++) {
            if (!seive[j] && !seive[A - j]) {
                result.add(j);
                result.add(A - j);
                break;
            }
        }
        return result;
    }

    /**
     * A lucky number is a number that has exactly 2 distinct prime divisors.
     * <p>
     * You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
     *
     * @param A
     * @return
     */
    private static int luckyNumbers(int A) {
        int[] seive = new int[A + 1];
        seive[0] = 0;
        seive[1] = 0;
        // Running the loop starting from 2 to sqrt(A) because, beyond the sqrt(A) will be
        // definitely greater than A.
        for (int i = 2; i <= A; i++) {
            if (seive[i] == 0) {
                for (int j = i; j <= A; j += i) {
                    seive[j]++;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= A; i++) {
            if (seive[i] == 2) {
                count++;
            }
        }
        return count;
    }

    /**
     * You are given an even number N and you need to represent the given number as the sum of primes.
     * The prime numbers do not necessarily have to be distinct. It is guaranteed that at least one possible solution exists.
     * You need to determine the minimum number of prime numbers needed to represent the given number.
     * <p>
     * Input : The first argument contains an integer N,the number you need to represent (2<=N<=10^9).
     * Output : Return an integer which is the minimum number of prime numbers needed to represent the given number N.
     * Examples
     * <p>
     * Input : 26
     * Output : 2
     * <p>
     * Explanation
     * <p>
     * You can represent 26 as: 13+13
     * So we require minimum of 2 prime numbers to represent the number 26.
     * <p>
     * Approach : As per "Goldbach's conjecture" any large even number can be represented as sum of two prime numbers.
     * Prime numbers need not be distinct.
     * <p>
     * Given that theory, we know that minimum numbers needed to add are 2, except for the case of 2, where 1 is not co
     *
     * @param A
     * @return
     */
    private static int primeAddition(int A) {
        if (A > 2) {
            return 2;
        }
        return 1;
    }

    /**
     * Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.
     * <p>
     * A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.
     * <p>
     * In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
     * In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
     * In the third go, he/she alters the states of doors numbered 3, 6, 9 …
     * This continues till the A'th go in, which you alter the state of the door numbered A.
     * <p>
     * Find and return the number of open doors at the end of the procedure.
     * <p>
     * Approach :
     * When we take a sample test data for 1 - 100, after all the 100 cycles are completed, we can observe that only the perfect squares remain open.
     *
     * @param A
     * @return
     */
    private static int noOfOpenDoors(int A) {
        int count = 1;
        for (int i = 2; i * i <= A; i++) {
            count++;
        }
        return count;
    }

    private static int primeSubsequences(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : A) {
            max = Math.max(max, integer);
        }
        boolean[] seive = new boolean[max + 1];
        seive[0] = true;
        seive[1] = true;
        for (int i = 2; i * i <= max; i++) {
            for (int j = i * i; j <= max; j += i) {
                seive[j] = true;
            }
        }

        int count = 0;
        for (Integer integer : A) {
            if (!seive[integer]) {
                count++;
            }
        }
        int mod = 1000000007;
        return (((ModularArithmetic.pow( 2, count, mod )) - 1) + mod) % mod;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{537445, 926901, 922614, 514341, 811253, 134587, 332929, 169521, 309301, 99047, 493048, 23680, 426435, 549040,
                669724, 38772, 249360, 156431, 595861, 31760, 818743, 8556, 114933, 902174, 218987, 106054, 309391, 984351, 290360, 983677,
                949410, 759992, 851161, 468751, 316851, 623148, 58170, 865188, 352041, 838209, 247982, 575818, 679500, 813411, 862539,
                485042, 816913, 976212, 591756, 517676, 553827, 899763, 742455, 969035, 112450, 217516, 632020, 756573, 309969, 219969,
                944239, 828896, 657917, 63912, 172383, 128135, 51637, 38409, 484878, 917656, 935225, 902641, 578567, 821288, 750758,
                367881, 911060, 31378, 353147, 937192, 261444, 144618, 96751, 754324, 9329, 270035, 524041, 766413, 774904, 240844,
                462742, 161151, 658111, 244610, 670778, 952542, 979626, 512908, 94801, 384461, 478675, 846070, 674279, 19866, 248102,
                985307, 913792, 427700, 334315, 325309, 525120, 194427, 690188, 204507, 252529, 431523, 937374, 704400, 69109, 348482,
                588997, 824860, 898282, 924705, 69278, 23503, 324790, 977756, 653560, 299578, 951283, 426017, 266084, 999221, 470204,
                469955, 157936, 445659, 73464, 579722, 454841, 574409, 486102, 610734, 624008, 723197, 428259, 679911, 206182, 995325,
                144179, 716000, 568615, 237168, 597956, 932530, 522274, 144879, 970866, 478762, 171189, 20397, 396835, 275095, 812829,
                482258, 832498, 723899, 259240, 387361, 806798, 837711, 365084, 795904, 624191, 734975, 831838, 352050, 682325, 431130,
                32519, 305811, 800905, 214304, 261106, 956659, 260047, 980099, 853644, 585468, 555708, 322928, 266303, 375378, 939610,
                279033, 473698, 241236, 659114, 857787, 510307, 60562, 359169, 823218, 301188, 33599, 855339, 723258, 652855, 182052,
                667131, 940660, 868122, 505984, 153214, 599535, 112495, 479223, 4218, 268623, 955171, 768115, 97171, 323028, 38771,
                101052, 632479, 204019, 476422, 562580, 568321, 732080, 276855, 937274, 819959, 829273, 663109, 800582, 755477,
                757226, 512581, 605678, 85787, 624515, 107703, 874282, 814512, 403885, 288418, 632602, 576803, 29030, 282106, 614416,
                805015, 441926, 611985, 115724, 456712, 484748, 16670, 837329, 469230, 667785, 580823, 112448, 116304, 592279, 778945,
                365190, 923149, 204935, 64, 204229, 898468, 749833, 980325, 792187, 860258, 705662, 352283, 968729, 733207, 649872,
                638612, 60152, 693192, 883714, 671400, 866066, 949668, 522261, 276963, 544317, 752227, 496459, 946676, 933712, 846948,
                33534, 861918, 655423, 739949, 352921, 509183, 926697, 203973, 856400, 24569, 362716, 406534, 583644, 203639, 120605,
                953373, 144488, 521086, 269484, 216261, 423067, 321827, 934871, 307056, 649632, 922270, 768718, 428590, 45106, 774390,
                613184, 521252, 351260, 828110, 209513, 735021, 547376, 83533, 325935, 724769, 464781, 136062, 350218, 484596, 665570,
                938393, 853779, 350738, 319075, 609090, 24236, 107816, 454688, 48937, 645977, 869054, 326279, 715760, 912251, 379885,
                27019, 80296, 8032, 53860, 480230, 863570, 696621, 947746, 258263, 763805, 308926, 114707, 515969, 799428, 743511,
                439976, 173754, 548525, 778765, 453527, 275132, 745353, 52090, 72994, 896758, 447157, 768681, 155775, 311569, 142689,
                71268, 814189, 562870, 282485, 926862, 850322, 539806, 552445, 421979, 338763, 834729, 71911, 882238, 932043, 135325,
                244812, 576233, 894901, 213335, 93185, 197201, 819822, 160713, 318744, 181346, 995793, 543019, 623505, 413309, 626445,
                404698, 207838, 610267, 244546, 317025, 486911, 702028, 125970, 529463, 637961, 892778, 516741, 827374, 151080, 97181,
                907147, 734724, 571477, 109714, 828830, 821441, 580629, 455993, 32536, 903049, 144509, 400254, 628556, 800397, 931053,
                157135, 622893, 448281, 34494, 939231, 63227, 725562, 424930, 173198, 134611, 498549, 198488, 2176, 830490, 444080,
                760104, 555775, 433664, 505466, 553342, 762754, 166118, 424798, 137086, 12766, 128232, 265544, 88002, 863428, 250996,
                501207, 956319, 778450, 369829, 714499, 807197, 406114, 487949, 913464, 525780, 160595, 373897, 901609, 480735, 496585,
                59486, 784101, 487201, 718967, 309979, 697664, 910099, 429795, 227549, 770610, 309688, 86556, 652504, 333936, 838341,
                21769, 640752, 915836, 314872, 307082, 86614, 827803, 997676, 159934, 106228, 365580, 845681, 422081, 871612, 917369,
                532130, 356253, 987581, 402625, 849950, 538789, 99637, 961016, 363588, 625214, 497331, 895141, 859508, 269292, 47401,
                165937, 393869, 173045, 281787, 22001, 414971, 199590, 892062, 393055, 58371, 329167, 910474, 265230, 584264, 230383,
                405843, 566220, 943546, 577542, 298874, 181881, 626502, 237192, 775484, 324593, 980597, 586190, 306280, 469540, 833310,
                377679, 478945, 878568, 175989, 172825, 693649, 981062, 423544, 355223, 479573, 833456, 751141, 879503, 485623, 63449,
                407199, 427358, 898787, 553255, 871411, 670163, 959192, 6200, 34348, 302497, 805728, 516315, 542587, 798281, 298896,
                643903, 790638, 701033, 891617, 246611, 616352, 475815, 977326, 755026, 250509, 6927, 922844, 956366, 440126, 789820,
                684993, 166822, 213498, 559263, 484437, 970211, 718793, 575416, 835960, 289173, 167840, 836213, 917036, 396146, 82225,
                112344, 438545, 52768, 793868, 932307, 858868, 271462, 881698, 196647, 426667, 700575, 162898, 38791, 276202, 850330,
                561842, 260718, 685106, 395436, 136670, 777487, 39208, 706412, 579270, 547682, 169068, 998182, 484258, 478558, 352660,
                547765, 758453, 789067, 893626, 851831, 156274, 375605, 207426, 28061, 680409, 4795, 969780, 210080, 711628, 452518,
                951815, 370589, 760782, 982087, 746005, 474696, 142198, 606900, 331950, 814502, 901520, 735849, 808598, 839801, 555617,
                22849, 662435, 233292, 297406, 312407, 949797, 493566, 523394, 688990, 492359, 238469, 67019, 300234, 186505, 417558,
                235062, 630371, 818561, 38879, 689244, 554348, 471497, 319968, 439971, 342977, 651714, 752507, 630699, 246702, 558736,
                827964, 705497, 53084, 183116, 147793, 98887, 47672, 946474, 821675, 116623, 927241, 888358, 796025, 375538, 814390,
                585183, 576128, 823696, 480591, 319351, 188021, 200245, 127434, 901451, 840562, 297174, 96522, 917606, 902542, 731408,
                842213, 416581, 351128, 153034, 280067, 608392, 66663, 737009, 104849, 78108, 2480, 56433, 985165, 701043, 98243,
                396769, 772237, 605483, 674173, 630973, 585530, 903088, 934501, 687427, 477400, 155050, 323115, 552298, 232526, 766469,
                8857, 113685, 835717, 34068, 978048, 641564, 490203, 505398, 647714, 53299, 888889, 943811, 898002, 245216, 76341,
                919752, 969417, 459984, 955226, 34601, 151828, 975787, 786417, 361842, 62065, 983020, 603759, 118025, 214174, 569003,
                913278, 768427, 158813, 141700, 313949, 4905, 602724, 14594, 984553, 769252, 999064, 90082, 396779, 305538, 384275,
                71397, 440915, 904886, 254322, 626452, 352290, 637269, 992796, 676208, 971932, 39037, 479946, 632883, 951296, 161215,
                633424, 880769, 681978, 912160, 462441, 537467, 242943, 648867, 734045, 138102, 907390, 370840, 584119, 824034, 150719,
                412312, 335255, 507024, 556329, 87197, 945069, 41031, 970328, 28167, 54146, 754045, 749133, 219890, 657790, 848116,
                990285, 911979, 696585, 992796, 790929, 848553, 176525, 734162, 522964, 373637, 585231, 878742, 948254, 88033, 663050,
                123059, 842711, 842427};
        ArrayList<Integer> array = ArrayUtility.convertArrayToList(arr1);
        System.out.println(PrimeNumberProblems.primeSubsequences(array));
    }
}
