package templates;

import java.util.Arrays;
import java.util.Comparator;

/*
    Ref: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits
*/
class SortingCustomComparator1 {

    // For Primitive Type Arrays
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }

    // For Wrapper Type Arrays
    public Integer[] sortByBits(Integer[] arr) {
        Arrays.sort(arr, new CustomComparator());
        return arr;
    }

    class CustomComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {          // TODO: Write custom logic for the comparator
            if (Integer.bitCount(a) == Integer.bitCount(b))
                return a - b;
            return Integer.bitCount(a) - Integer.bitCount(b);
        }
    }

}
