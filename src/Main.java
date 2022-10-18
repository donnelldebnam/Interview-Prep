package src;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Stack;

public class Main {

    /**
     * Given two strings s and t, determine if they are isomorphic.
     * 
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t. 
     * All occurrences of a character must be replaced with another character while 
     * preserving the order of characters. No two characters may map to the same character, 
     * but a character may map to itself.
     * https://leetcode.com/problems/isomorphic-strings
     * 
     * Input: s = "egg", t = "add"
     * Output: true
     * 
     * Input: s = "foo", t = "bar"
     * Output: false
     */
    public static boolean isIsomorphic(String s, String t) {
        // Storage
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        // Input validation
        if (s.length() != t.length()) 
            return false;

        // Loop through all characters
        for (int i = 0; i < s.length(); i++) {
            // 
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            // Map has seen this character
            if (sToT.containsKey(sChar)) {
                // Check if the known complement of this character
                // is what we see at this index in the second String
                if (sToT.get(sChar) != tChar) {
                    return false;
                }
                // Map has not seen this character yet
            } else {
                if (tToS.containsKey(tChar)) { return false; }
                // Store the character and its complement
                sToT.put(sChar, tChar);
                tToS.put(tChar, sChar);
            }
        }
        return true;
    }
       

    /** 
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) 
     * and '0's (water), return the number of islands.
     * https://leetcode.com/problems/number-of-islands
     * 
     * An island is surrounded by water and is formed by connecting adjacent lands 
     * horizontally or vertically. You may assume all four edges of the grid are all 
     * surrounded by water.
     * 
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * Output: 1
     */
    public static int numIslands(char[][] grid) {
        // Counter
        int count = 0;

        // Iterate over each element in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we found the start of an island
                if (grid[i][j] == '1') {
                    // Increment our counter
                    count++;
                    // Start exploring the island
                    DFS(i, j, grid);
                }
            }
        }
        return count;
    }

    private static void DFS(int i, int j, char[][] grid) {
        // If the current position isn't valid, return
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') 
            return;
        // Mark this vertex as visited
        grid[i][j] = '0';

        // Explore in each direction
        DFS(i+1, j, grid);
        DFS(i-1, j, grid);
        DFS(i, j+1, grid);
        DFS(i, j-1, grid);
        return;
    }

    /** 
     * Create a function that takes a collection of ints and an int as input
     * and returns the indices of the two elements that sum up to the target sum.
     * https://leetcode.com/problems/two-sum/
     * 
     * Example: arr=[], target=0 --> throws Exception
     * Example: arr=[1, 2, 5], target=7 --> returns [1, 2]
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
            // If map contains the current element
            if (map.containsKey(n)) {
                // Find out how many times it has been seen so far
                occurancesOfN = map.get(n);
                // Increment the number of occurances by 1.
                map.put(n, ++occurancesOfN);
                // Else, if we haven't seent his element yet
            } else {
                // Add the element to the map
                map.put(n, 1);
            }

            // If the nmber of occurances for the current element is greater than that of the
            // mostOccuringNumber, replace it.
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

        // Determine if the Strings are isomorphic.
        System.out.println(isIsomorphic(MainConstants.TEST_STRING1, MainConstants.TEST_STRING2));
        System.out.println(isIsomorphic(MainConstants.TEST_STRING1, MainConstants.TEST_STRING3));

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
        
        // Find number of islands.
        System.out.println(numIslands(MainConstants.GRID1));
    }
}
