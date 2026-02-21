package com.aditya.strings;

// Time Complexity : O(N^2)
// Space Complexity : O(N^2)

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Problem2981FindLongestSpecialSubstringThatOccursThrice1 {

    public static int maximumLength(String s) {

        int n = s.length();
        Map<String , Integer> map = new HashMap<>();

        for(int i = 0 ; i<n ; i++){
            char ch = s.charAt(i);
            int length = 0;
            for(int j = i ; j<n ; j++){
                if(s.charAt(j) == ch){
                    length++;
                    String key = ch + "#" + length;
                    map.put(key , map.getOrDefault(key , 0) + 1);
                }
                else{
                    break;
                }
            }
        }

        int length = 0;

        for(String key : map.keySet()){
            int wordLen = Integer.parseInt(key.split("#")[1]);
            int freq = map.get(key);

            if(freq >= 3 && wordLen > length){
                length = wordLen;
            }
        }

        return length == 0 ? -1 : length;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String str = sc.nextLine();

        int length = maximumLength(str);
        System.out.println("Maximum length: " + length);

        sc.close();
    }
}


// Time Complexity : O(N^3)
// Space Complexity : O(N^3)

//import java.util.Scanner;
//import java.util.Map;
//import java.util.HashMap;
//
//public class Problem2981FindLongestSpecialSubstringThatOccursThrice1 {
//
//    public static int maximumLength(String s) {
//
//        int n = s.length();
//        Map<String , Integer> map = new HashMap<>();
//
//        for(int i = 0 ; i<n ; i++){
//            StringBuilder result = new StringBuilder();
//
//            for(int j = i ; j<n ; j++){
//                if(result.isEmpty() || result.charAt(result.length() - 1) == s.charAt(j)){
//                    result.append(s.charAt(j));
//                    map.put(result.toString() , map.getOrDefault(result.toString() , 0) + 1);
//                }
//                else{
//                    break;
//                }
//            }
//        }
//
//        int length = 0;
//
//        for(Map.Entry<String , Integer> entry : map.entrySet()){
//            String word = entry.getKey();
//            int freq = entry.getValue();
//
//            if(freq >= 3 && word.length() > length){
//                length = word.length();
//            }
//        }
//
//        return length == 0 ? -1 : length;
//
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Enter String: ");
//        String str = sc.nextLine();
//
//        int length = maximumLength(str);
//        System.out.println("Maximum length: " + length);
//
//        sc.close();
//    }
//}
