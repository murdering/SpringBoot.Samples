package com.attemp;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //String str1 = new String("aa");
        //String str2 = new String("aa");
        //System.out.println(str2==str1);

        String str3 = new String("bb");
        str3.intern();
        String str4 = new String("bb");
        System.out.println(str3==str4);

        String str2 = new String("str")+new String("01");
        //String str2 = "str01";
        str2.intern();
        //String str1 = "str01";
        String str1 = new String("str01");
        System.out.println(str2==str1);
    }
}
