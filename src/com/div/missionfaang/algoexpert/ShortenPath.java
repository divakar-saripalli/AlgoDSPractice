package com.div.missionfaang.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ShortenPath {
    private static String shortenPath(String path) {
        // Write your code here;
        if (path.length() < 2) {
            return path;
        }

        List<String> folders = new ArrayList<>();
        StringBuffer folderFileName = new StringBuffer();
        boolean isAbsolute = path.charAt(0) == '/';
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                if (path.charAt(i) == '.') {
                    if (i < path.length() - 1 && path.charAt(i + 1) == '.') {
                        // parent directory case
                        if (folders.size() > 0) {
                            folders.remove(folders.size() - 1);
                        }
                        i++;
                    } else {
                        // current directory case
                    }
                } else {
                    folderFileName.append(path.charAt(i));
                }
            } else {
                if (!folderFileName.toString().isBlank()) {
                    folders.add(folderFileName.toString());
                }
                folderFileName = new StringBuffer();
            }
        }

        String result = (isAbsolute) ? "/" : "";
        for (String string : folders) {
            if (!string.isBlank()) {
                result += string + "/";
            }
        }
        return result + folderFileName;
    }

    public static void main(String[] args) {
        System.out.println(ShortenPath.shortenPath("/foo/../test/../test/../foo//bar/./baz"));
        System.out.println(ShortenPath.shortenPath("/../../foo/bar/baz"));
    }
}
