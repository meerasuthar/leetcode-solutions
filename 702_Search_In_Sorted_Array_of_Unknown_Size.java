/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int low = 0;
        int high = 1_000_000_000;
        while(low<high) {
            int mid = low + (high-low)/2;
            int midElement = reader.get(mid);
            if (midElement==target) {
                return mid;
            }
            if (midElement < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return (reader.get(low)==target?low:-1);
    }
}