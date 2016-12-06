/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 *
 * @author Michael <GrubenM@GMail.com>
 */
public class Solution {
    
    /**
     * Returns the greatest common denominator of a and b
     * 
     * Non-recursive implementation by Sedgewick and Wayne.
     * http://introcs.cs.princeton.edu/java/23recursion/Euclid.java.html
     * 
     * @param a
     * @param b
     * @return 
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    /**
     * Iterates through the array, copying the value of the current index to
     * the index `k` higher until it reaches the index i it started from.
     * 
     * @param nums
     * @param k
     * @param i 
     */
    private void shift(int[] nums, int k, int i) {
        int fin = i;
        int front = nums[i];
        int back;
        int j;
        do {
            j = (i + k) % nums.length;
            back = nums[j];
            nums[j] = front;
            i = j;
            front = back;
        } while (i != fin);
    }
    /**
     * Rotate an array of n elements to the right by k steps.
     * 
     * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7]
     * is rotated to [5,6,7,1,2,3,4].
     * 
     * @param nums
     * @param k 
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        for (int i = 0; i < gcd(k, nums.length); i++) {
            shift(nums, k, i);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1,2,3};
        int k = 2;
        sol.rotate(nums, k);
        for (int i: nums) System.out.println(i);
    }
    
}
