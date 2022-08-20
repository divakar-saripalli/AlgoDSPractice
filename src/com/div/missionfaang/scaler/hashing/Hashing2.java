package com.div.missionfaang.scaler.hashing;

import com.div.missionfaang.scaler.Scaler;

import java.util.*;

public class Hashing2 {

    public ArrayList<Integer> subarrayWithGivenSum(ArrayList<Integer> A, int B) {
        int sum = 0;
        int startIndex = 0;
        boolean found = false;
        for (Integer integer : A) {
            sum += integer;
            if (sum > B) {
                while (sum > B) {
                    sum -= A.get(startIndex);
                    startIndex++;
                }
            }
            if (sum == B) {
                found = true;
                break;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (found) {
            sum = 0;
            for (int i = startIndex; sum < B; i++) {
                result.add(A.get(i));
                sum += A.get(i);
            }
        } else {
            result.add(-1);
        }
        return result;
    }

    public int diffK_II(List<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        if (A.get(0) > B) {
            set.add(A.get(0) - B);
        } else {
            set.add(A.get(0) + B);
        }
        for (int i = 1; i < A.size(); i++) {
            if (set.contains(A.get(i))) {
                return 1;
            } else {
                if (A.get(i) >= B) {
                    set.add(A.get(i) - B);
                } else {
                    set.add(A.get(i) + B);
                }
            }
        }
        return 0;
    }

    private static ArrayList<Integer> twoSum(List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if (A.size() < 2) {
            return result;
        }
        if (A.size() == 2 && (A.get(0) + A.get(1) == B)) {
            result.add(0);
            result.add(1);
            return result;
        }

        HashSet<Integer> set = new HashSet<>();
        int index2 = 1;
        for (Integer integer : A) {
            if (set.contains(integer)) {
                int index = 1;
                for (Integer integer1 : A) {
                    if (integer1 == (B - integer)) {
                        result.add(index);
                        break;
                    }
                    index++;
                }
                result.add(index2);
                break;
            } else {
                set.add(B - integer);
                index2++;
            }
        }
        return result;
    }

    private static int isDictionary(ArrayList<String> A, String B) {
        String originalOrder = A.toString();
        A.sort(new StringComparator(B));
        String sortedOrder = A.toString();
        return (originalOrder.equals(sortedOrder)) ? 1 : 0;
    }

    private static int pairsWithGivenXor(ArrayList<Integer> A, int B) {
        HashSet<Integer> set = new HashSet<>();
        set.add(A.get(0));
        int count = 0;
        for (int i = 1; i < A.size(); i++) {
            if (set.contains(A.get(i) ^ B)) {
                count++;
            }
            set.add(A.get(i));
        }
        return count;
    }

    private static ArrayList<Integer> distinctNumbers(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if (B > A.size()) {
            return result;
        }

        for (int i = 0; i < B; i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }
        result.add(map.size());
        for (int i = B, j = 0; i < A.size(); i++, j++) {
            if (map.get(A.get(j)) == 1) {
                map.remove(A.get(j));
            } else {
                map.put(A.get(j), map.get(A.get(j)) - 1);
            }
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i)) + 1);
            } else {
                map.put(A.get(i), 1);
            }
            result.add(map.size());
        }
        return result;
    }

    public int isValidSudoku(List<String> A) {
        for (int i = A.size() - 1; i >= 0; i--) {
            HashSet<Character> set;
            set = new HashSet<>(9);
            for (int j = 0; j < A.get(i).length(); j++) {
                if (A.get(j).charAt(j) != '.' && set.contains(A.get(i).charAt(j))) {
                    return 0;
                } else {
                    set.add(A.get(i).charAt(j));
                }
            }
        }

        for (int i = 0; i < A.size(); i++) {
            HashSet<Character> set = new HashSet<>(9);
            for (int j = 0; j < A.get(i).length(); j++) {
                if (A.get(j).charAt(i) != '.' && set.contains(A.get(j).charAt(i))) {
                    return 0;
                } else {
                    set.add(A.get(j).charAt(i));
                }
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                HashSet<Character> set = new HashSet<>(9);
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (A.get(k).charAt(l) != '.' && set.contains(A.get(k).charAt(l))) {
                            return 0;
                        } else {
                            set.add(A.get(k).charAt(l));
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        ArrayList<Integer> array = Scaler.convertArrayToList(arr);

        String[] strArray = new String[]{"fine", "none", "no"};
        ArrayList<String> strArrayList = Scaler.convertArrayToList(strArray);
        String newAlphabet = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(Hashing2.isDictionary(strArrayList, newAlphabet));
    }
}

class StringComparator implements Comparator<String> {

    private final HashMap<Character, Integer> alphabetMap = new HashMap<>();

    StringComparator(String newAlphabet) {
        for (int i = 0; i < newAlphabet.length(); i++) {
            alphabetMap.put(newAlphabet.charAt(i), i);
        }
    }

    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            if (alphabetMap.get(o1.charAt(i)) < alphabetMap.get(o2.charAt(i))) {
                return -1;
            }
            if (alphabetMap.get(o1.charAt(i)) > alphabetMap.get(o2.charAt(i))) {
                return 1;
            }
        }
        if (o2.length() < o1.length()) {
            return 1;
        } else if (o2.length() > o1.length()) {
            return -1;
        }
        return 0;
    }
}
