package templates;

import java.util.Arrays;

public class SortingCustomComparator3_Lambda {

    // For Primitive Type Arrays
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((o1, o2) -> {           // TODO: Write custom logic for the comparator
                    if (Integer.bitCount(o1) == Integer.bitCount(o2))
                        return o1 - o2;
                    return Integer.bitCount(o1) - Integer.bitCount(o2);
                })
                .mapToInt(Integer::intValue).toArray();
    }

    // For Wrapper Type Arrays
    public Integer[] sortByBits(Integer[] nums) {
        Arrays.sort(nums, (o1, o2) -> {        // TODO: Write custom logic for the comparator
            if (Integer.bitCount(o1) == Integer.bitCount(o2))
                return o1 - o2;
            return Integer.bitCount(o1) - Integer.bitCount(o2);
        });
        return nums;
    }

}
