package templates;

import java.util.Arrays;
import java.util.Comparator;

public class SortingCustomComparator2 {

    // For Primitive Type Arrays
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                     .boxed()
                     .sorted(new Comparator<Integer>() {
                                @Override
                                public int compare(Integer o1, Integer o2) { // TODO: Write custom logic for the comparator
                                    if (Integer.bitCount(o1) == Integer.bitCount(o2))
                                        return o1 - o2;
                                    return Integer.bitCount(o1) - Integer.bitCount(o2);
                                }
                            })
                     .mapToInt(Integer::intValue).toArray();
    }

    // For Wrapper Type Arrays
    public Integer[] sortByBits(Integer[] nums) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {        // TODO: Write custom logic for the comparator
                if (Integer.bitCount(o1) == Integer.bitCount(o2))
                    return o1 - o2;
                return Integer.bitCount(o1) - Integer.bitCount(o2);
            }
        });
        return nums;
    }

}
