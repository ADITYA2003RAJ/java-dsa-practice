package com.aditya.strings;

// Time Complexity : O(N ^ 2)
// Space Complexity : O(1)

import java.util.Scanner;

public class Problem3234CountTheNumberOfSubstringsWithDominantOnes {
    public static int numberOfSubstrings(String s) {

        int n = s.length();
        int result = 0;

        int[] countSumOnes = new int[n];
        countSumOnes[0] = s.charAt(0) == '1' ? 1 : 0;

        for(int i = 1 ; i<n ; i++){
            countSumOnes[i] = countSumOnes[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = i ; j<n ; j++){

                int onesCount = countSumOnes[j] - (i - 1 >= 0 ? countSumOnes[i - 1] : 0);
                int zeroesCount = (j - i + 1) - onesCount;

                if(zeroesCount * zeroesCount > onesCount){
                    int waste = zeroesCount * zeroesCount - onesCount;
                    j += waste - 1;
                }
                else if(zeroesCount * zeroesCount == onesCount){
                    result += 1;
                }
                else{
                    result += 1;

                    int k = (int)Math.sqrt(onesCount) - zeroesCount;
                    int next = j + k;

                    if(next >= n){
                        result += (n - j - 1);
                        break;
                    }
                    else{
                        result += k;
                    }

                    j = next;
                }

            }
        }

        return result;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.next();

        int result = numberOfSubstrings(s);
        System.out.println("The number of substrings whose square of zeroes less than equal to one is: " + result);

        sc.close();

    }
}
