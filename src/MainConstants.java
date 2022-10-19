package src;

import java.util.Arrays;
import java.util.ArrayList;

public class MainConstants {

    // Arrays
    public final static int[] ARRAY_OF_INTEGERS1 = new int[] {1, 1, 1, 1, 1, 2, 3, 4, 4, 5, 3, 5, 23, 1, 2, 4, 5, 2, 1, 3, 4, 1, 1, 3, 4, 5, 6, 6, 6, 3};
    public final static int[] ARRAY_OF_INTEGERS2 = new int[] {1, 2, 5};

    public final static int[] ARRAY_ASCENDING_ORDER = new int[] {10, 20, 30};
    public final static int[] ARRAY_DESCENDING_ORDER = new int[] {25, 15, 0};

    // 2-D Arays
    public final static char[][] GRID1 = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    // Strings
    public final static String VALID_PARENTHESES = "(())(())";
    public final static String INVALID_PARENTHESES = "(())(()))))";

    public final static String VALID_CAPITALIZED_STRING1 = "USA";
    public final static String VALID_CAPITALIZED_STRING2 = "Hello";
    
    public final static String INVALID_CAPITALIZED_STRING1 = "AbCd";
    public final static String INVALID_CAPITALIZED_STRING2 = "FlaG";

    public final static String TEST_STRING1 = "egg";
    public final static String TEST_STRING2 = "foo";
    public final static String TEST_STRING3 = "bar";

    public static final String LYRICS_STRING1 = "We We are the the Champions! Champions!";

    // ArrayLists
    public final static ArrayList<Integer> ARRAYLIST_OF_INTEGERS = new ArrayList<Integer>(Arrays.asList(1,1,1,5,2,3,4,7));
}
