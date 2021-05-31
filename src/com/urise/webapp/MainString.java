package com.urise.webapp;

public class MainString {
    public static void main(String[] args) {
        String[] strArray = new String[]{"1","2","3","4","5"};
        StringBuilder sbResult = new StringBuilder();
        for (String str : strArray) {
            sbResult.append(str).append(",");
        }
        System.out.println(sbResult.toString());

        String str1 = "abc";
        String str2 = "c";
        String str3 = ("ab" + str2).intern();
        System.out.println(str1==str3);
    }
}
