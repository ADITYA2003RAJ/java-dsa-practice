package com.aditya.strings;

// Time Complexity  : O(n)
// Space Complexity : O(n)

import java.util.Scanner;
import java.util.Stack;

public class Problem2434UsingARobotToPrintTheLexicographicallySmallestString {
    public static String robotWithString(String s) {

        int n = s.length();
        char[] alphabet = new char[n];
        alphabet[n - 1] = s.charAt(n - 1);

        for(int i = n - 2 ; i >= 0 ; i--){
            alphabet[i] = (char) Math.min(s.charAt(i) , alphabet[i + 1]);
        }

        int i = 0;
        StringBuilder paper = new StringBuilder();
        Stack<Character> t = new Stack<>();

        while(i < n){

            t.push(s.charAt(i));
            char minCh = i + 1 < n ? alphabet[i + 1] : s.charAt(i);

            while(!t.isEmpty() && t.peek() <= minCh){
                paper.append(t.pop());
            }

            i++;
        }

        while(!t.isEmpty()){
            paper.append(t.pop());
        }

        return paper.toString();
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.next();

        String result = robotWithString(str);
        System.out.println("The lexographical smallest string is: " + result);

        sc.close();
    }
}
