package com.aditya.strings;

// Time Complexity : O(M * K + N * K)
// M = word1.length , N = word2.length
// Space Complexity : O(1)

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Problem916WordSubsets {
    private static boolean isSubset(int[] freq , int[] temp){

        for(int i = 0 ; i<26 ; i++){
            if(temp[i] < freq[i]){
                return false;
            }
        }
        return true;
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> answer = new ArrayList<>();

        int[] freq2 = new int[26];

        for(String word : words2){
            int[] temp = new int[26];
            for(char ch : word.toCharArray()){
                temp[ch - 'a']++;
                freq2[ch - 'a'] = Math.max(freq2[ch - 'a'] , temp[ch - 'a']);
            }
        }

        for(String word : words1){
            int[] temp = new int[26];
            for(char ch : word.toCharArray()){
                temp[ch - 'a']++;
            }

            if(isSubset(freq2 , temp)){
                answer.add(word);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter word1 separated by space: ");
        String[] word1 = sc.nextLine().split(" ");

        System.out.println("Enter word2 separated by space");
        String[] word2 = sc.nextLine().split(" ");

        List<String> result = wordSubsets(word1 , word2);
        System.out.println("The final universal String list: " + result);

        sc.close();

    }
}
