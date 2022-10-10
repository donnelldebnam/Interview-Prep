package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
 
    /** 
     * Create a function that takes a collection of ints and an int as input
     * and returns the indices of the two elements that sum up to the target sum.
     * https://leetcode.com/problems/two-sum/
     * 
     * Example: arr=[], target=0 --> throws Exception
     * Example: arr=[1, 2, 5], taret=7 --> returns [1, 2]
     * Example: arr=[5, 10, 15], target=8 --> returns null
     * 
     * @param arr a collection of integers.
     * @param target the wanted sum of two integers in the collection.
     * 
     * @return indices of the two integers that sum up to the target input.
     */
    public static int[] twoSum(int[] arr, int target) throws Exception {
        // Input validation 
        if (arr.length < 2) {
            throw new IllegalArgumentException("Invalid input array; length too short.");
        }

        // Map to store complements and their indices.
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // Visit each element in the input array. If the complement of the current element has 
        // already been added to our map, return the two as a pair. Else, store the complement and its position.
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }

    /**
     * Given a String of lyrics with duplicated words, return the String without the duplicates.
     * 
     * @param list an ArrayList of elements.
     * @return a String containing only the unique elements.
     * 
     * Big-O: O(N) as we are visiting each element to dump it into the set/other ArrayList.
     * 
     * NOTE: Using a HashSet will sort the elements, thus destroys the order. Using a LinkedHashSet,
     * we can maintain the order
     */
    public static String removeDuplicateLyrics(String str) {
        /*
         * Uses O(N) space to store elements in the HashSet.
         * Uses O(N) space to store elements back in the ArrayList.
         * 
         * Note: one way to absolve this is to clear() the original list and reuse it.
         */
        String[] strSplit = str.split(" ");
        ArrayList<String> listSplit = new ArrayList<String>(Arrays.asList(strSplit));
        LinkedHashSet<String> setSplit = new LinkedHashSet<String>(listSplit);

        return String.join(" ", setSplit); 
    }

    /**
     * Given an input string `str` that only contains parentheses, determine whether the
     * string's parentheses are balanced.
     * https://leetcode.com/problems/valid-parentheses/
     * 
     * Balanced = "(()"
     * Unbalanced = ")(", "(()"
     * 
     * @param str a string of parenetheses.
     * @return true if the parentheses are balanced.
     */
    public static boolean containsBalancedParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isOpenParenthesis(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * Given an input string `str` that only contains parentheses, determine whether the
     * string's parentheses are balanced.
     * https://leetcode.com/problems/valid-parentheses/
     * 
     * Balanced = "(()"
     * Unbalanced = ")(", "(()"
     * 
     * @param str a string of parenetheses.
     * @return true if the parentheses are balanced.
     */   
    public static boolean containsBalancedParentheses2(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isOpenParenthesis(c)) {
                count++;
            } else {
                if (count < 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }

    // A helper function for readability.
    private static boolean isOpenParenthesis(char c) {
        return c == '(';
    }

    /**
     * Create a function that returns the most occuring element in a given
     * collection of numbers.
     * 
     * @param arr an array of integer values.
     * @return mostOccuringValue the most frequently occuring value
     */
    public static int mostOccuringNumber(int[] arr) throws Exception {
        
        // Input validation
        if (arr.length == 0) { 
            throw new IllegalArgumentException("Array must at least be of length 1");
        }

        // Map to store the occurances of each value.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through each value in the array and populate the HashMap.
        // Big-O: O(N) as we need to visit each index of the array.
        int mostOccuringNumber = arr[0];
        for (int n : arr) {
            int occurancesOfN = 0;
            if (map.containsKey(n)) {
                occurancesOfN = map.get(n);
                map.put(n, ++occurancesOfN);
            } else {
                map.put(n, occurancesOfN);
            }
            if (occurancesOfN > map.get(mostOccuringNumber))
                mostOccuringNumber = n;
        }
        return mostOccuringNumber;
    }

    /**
     * Create a function that detects if its input uses correct/valid capitalization.
     * https://leetcode.com/problems/detect-capital/description/
     * 
     * Valid: "USA", "Hello", "leetcode"
     * Invalid: "FlaG", "AbCd"
     * 
     * @param word
     * @return true if input uses correct capitalization.
    */
    public static boolean usesValidCapitalization(String word) {
        return (word.toUpperCase().equals(word) ||
               word.toLowerCase().equals(word) ||
               word.toLowerCase().substring(1).equals(word.substring(1))
               );
    }

    public static void main(String[] args) throws Exception {

        // Find the two numbers in the collection that make the target value.
        System.out.println(Arrays.toString(twoSum(MainConstants.ARRAY_OF_INTEGERS2, 7)));

        // Remove duplicates from the following Strings.
        System.out.println(removeDuplicateLyrics(MainConstants.LYRICS_STRING1));

        // Find most occuring number.
        System.out.println(mostOccuringNumber(MainConstants.ARRAY_OF_INTEGERS1));

        // Determine if parentheses are balanced
        System.out.println(containsBalancedParentheses(MainConstants.VALID_PARENTHESES));
        System.out.println(containsBalancedParentheses(MainConstants.INVALID_PARENTHESES));

        // Determine if string uses valid capitalization.
        System.out.println(usesValidCapitalization(MainConstants.VALID_CAPITALIZED_STRING2));
        System.out.println(usesValidCapitalization(MainConstants.INVALID_CAPITALIZED_STRING1));
        
    }
}
