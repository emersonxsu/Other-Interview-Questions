/**
 * Given a string with parentheses, return a string with balanced parentheses
 * by removing the fewest characters possible. You cannot add anything to the
 * string.
 * Examples:
 * balance("()") -> "()"
 * balance(")(") -> "".
 * balance("(((((") -> ""
 * balance("(()()(") -> "()()"
 * balance(")(())(") -> "(())"
 * 注意：balance(")(())(") != "()()"
 */

public class Solution {
    public static String removeFewestParen(String s) {
        //TODO base cases:

        //general cases
        StringBuilder sb = new StringBuilder(s);
        int count = 0;    // count the number of " ( "
        int i = 0; // index of sb
        while (i < sb.length()) {
            if (sb.charAt(i) == '(') {
                count++;
                i++;
            } else if (sb.charAt(i) == ')') {
                // has '(' left
                if (count > 0) {
                    count--;
                    i++;
                    // no '(' left
                } else if (count == 0) {
                    sb.deleteCharAt(i);    //delete invalid ')'
                }
            }
        }
        //next delete extra '(' s from right to left
        for (i= sb.length() - 1; i >= 0 && count > 0; --i) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                count--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "(()";
        String s3 = ")()";
        String s4 = "((((";
        String s5 = "))))";
        String s6 = "))((()()";
        System.out.println("s1 = " + removeFewestParen(s1));
        System.out.println("s2 = " + removeFewestParen(s2));
        System.out.println("s3 = " + removeFewestParen(s3));
        System.out.println("s4 = " + removeFewestParen(s4));
        System.out.println("s5 = " + removeFewestParen(s5));
        System.out.println("s6 = " + removeFewestParen(s6));
    }
}