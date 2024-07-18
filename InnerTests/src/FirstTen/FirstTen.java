package FirstTen;

import java.util.Arrays;

public class FirstTen {

    private int computeClosestToZero(int[] ts) {
        int curr = 0;
        if (ts.length == 0) {
            return 0;
        }
        int near = ts[0];
        Arrays.sort(ts);

        for (int t : ts) {
            curr = t * t;
            if (curr <= (near * near)) {
                near = t;
            }
        }
        return near;
    }

    /**
     * https://leetcode.com/problems/longest-common-prefix/description/
     *
     * @param strs - string to check
     * @return string with the longest prefix
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "", pivot = strs[0], tempPrefix = "";
        boolean aux = true;
        if (strs.length == 1) {
            if (pivot.isEmpty())
                return prefix;

            return strs[0];
        }
        if (Arrays.stream(strs).distinct().count() == 1) {
            return strs[0];
        }

        for (int i = 1; i <= pivot.length(); i++) {
            tempPrefix = pivot.substring(0, i);
            for (String str : strs) {
                if (!str.startsWith(tempPrefix)) {
                    aux = false;
                    break;
                }
            }
            prefix = tempPrefix;
            if (!aux) {
                break;
            }
        }

        if (prefix.isEmpty())
            return "";
        if (prefix.length() == 1)
            return prefix;
        else
            return prefix.substring(0, prefix.length() - 1);
    }

    /**
     * https://leetcode.com/problems/palindrome-number/description/
     *
     * @param x - number
     * @return true if is palindrome number, false if not
     */
    private boolean isPalindrome(int x) {
        boolean response = true;
        String number = String.valueOf(x);
        int j = number.length() - 1;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != number.charAt(j)) {
                response = false;
                break;
            }
            j--;
        }
        return response;
    }

    /**
     * https://leetcode.com/problems/two-sum/description/
     *
     * @param nums   -
     * @param target -
     * @return array with the expected numbers
     */
    public int[] twoSum(int[] nums, int target) {
        int[] response = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    response[0] = i;
                    response[1] = j;
                    break;
                }
            }
        }
        return response;
    }

    public boolean isValid(String s) {
        while (true) {
            if (s.contains("()")) {
                s = s.replace("()", "");
            } else if (s.contains("{}")) {
                s = s.replace("{}", "");
            } else if (s.contains("[]")) {
                s = s.replace("[]", "");
            } else {
                return s.isEmpty();
            }
        }
    }

    public static void main(String[] args) {
        FirstTen firstTen = new FirstTen();

        System.out.println(firstTen.isValid("(){}}{"));
        /**System.out.println("----------");
         System.out.println("----- Compute closest to Zero -----");
         System.out.println("----------");
         int[] ts = {};
         System.out.println(firstTen.computeClosestToZero(ts));
         System.out.println("----------");

         System.out.println("----------");
         System.out.println("----- Longest common prefix -----");
         System.out.println("----------");
         String[] strs = {"a", "ac"};
         System.out.println(firstTen.longestCommonPrefix(strs));

         System.out.println("----------");
         System.out.println("----- Palindrome number -----");
         System.out.println("----------");
         System.out.println(firstTen.isPalindrome(10));

         System.out.println("----------");
         System.out.println("----- Two Sums -----");
         System.out.println("----------");
         int nums[] = {3, 3};
         int target = 6;
         System.out.println(Arrays.toString(firstTen.twoSum(nums, target)));*/


    }
}
