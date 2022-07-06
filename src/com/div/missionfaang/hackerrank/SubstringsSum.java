package com.div.missionfaang.hackerrank;

public class SubstringsSum {
    private static int substrings(String n) {
        int total = 0;

        for (int i = 0; i < n.length(); i++) {
            StringBuffer numberString = new StringBuffer();
            for (int j = i; j < n.length(); j++) {
                numberString.append(n.charAt(j));
                total += Long.parseLong(numberString.toString());
                total %= (Math.pow(10, 9) + 7);
            }
        }
        return (int) (total % (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
//		63007895494540748697130257211701132911672127113982917934957238363754144356260578781606111036085360074
//		System.out.println(substrings("972698438521"));
        System.out.println(SubstringsSum.substrings(
                "63007895494540748697130257211701132911672127113982917934957238363754144356260578781606111036085360074"));
    }
}
