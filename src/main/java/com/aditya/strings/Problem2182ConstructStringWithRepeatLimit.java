package com.aditya.strings;

// Time Complexity = O(n log 26)
// Space Complexity = O(n)

import java.util.PriorityQueue;
import java.util.Scanner;

public class Problem2182ConstructStringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {

        int n = s.length();
        int[] letters = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>((a , b) -> b - a);

        for(int i = 0 ; i<n ; i++){
            int ch_idx = s.charAt(i) - 'a';
            letters[ch_idx] += 1;
        }

        for(int i = 0 ; i<26 ; i++){
            if(letters[i] > 0){
                pq.add((char)(i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){

            char ch = pq.poll();
            int freq = Math.min(letters[ch - 'a'] , repeatLimit);

            for(int k = 0 ; k<freq ; k++){
                sb.append(ch);
            }

            letters[ch - 'a'] -= freq;

            if(letters[ch - 'a'] > 0 && !pq.isEmpty()){
                char next = pq.poll();
                sb.append(next);
                letters[next - 'a']--;

                if(letters[next - 'a'] > 0){
                    pq.add(next);
                }

                pq.add(ch);
            }
        }

        return sb.toString();

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();

        System.out.println("Enter repeatLimit: ");
        int repeatLimit = sc.nextInt();

        String result = repeatLimitedString(str , repeatLimit);
        System.out.println("Repeat Limited String: " + result);

        sc.close();

    }
}


/*

// Time Complexity = O(n)
// Space Complexity = O(n)

import java.util.Scanner;

public class Problem2182ConstructStringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {

        int n = s.length();
        int[] letters = new int[26];
        int idx = 25;

        for(int i = 0 ; i<n ; i++){
            int ch_idx = s.charAt(i) - 'a';
            letters[ch_idx] += 1;
        }

        StringBuilder sb = new StringBuilder();

        while(idx >= 0){

            if(letters[idx] == 0){
                idx--;
                continue;
            }

            char ch = (char)(idx + 'a');
            int freq = Math.min(letters[ch - 'a'] , repeatLimit);

            for(int k = 0 ; k<freq ; k++){
                sb.append(ch);
            }

            letters[ch - 'a'] -= freq;

            if(letters[ch - 'a'] > 0){
                int j = idx - 1;

                while(j >= 0 && letters[j] == 0){
                    j--;
                }

                if(j < 0){
                    break;
                }

                sb.append((char)(j + 'a'));
                letters[j]--;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = sc.nextLine();

        System.out.println("Enter repeatLimit: ");
        int repeatLimit = sc.nextInt();

        String result = repeatLimitedString(str , repeatLimit);
        System.out.println("Repeat Limited String: " + result);

        sc.close();

    }
}


 */
