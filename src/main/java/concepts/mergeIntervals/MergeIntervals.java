package concepts.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

    // https://leetcode.com/problems/merge-intervals/description/
    public class MergeIntervalsInt {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int x = 0;
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    intervals[x][0] = start;
                    intervals[x][1] = end;
                    x++;

                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            intervals[x][0] = start;
            intervals[x][1] = end;
            x++;

            return Arrays.copyOfRange(intervals, 0, x);
        }
    }

    public static class MergeIntervalsLong {
        public static long[][] merge(long[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingLong(a -> a[0]));

            int x = 0;
            long start = intervals[0][0];
            long end = intervals[0][1];
            for (int i=1; i<intervals.length; i++) {
                if (intervals[i][0] <= end) {
                    end = Math.max(end, intervals[i][1]);
                } else {
                    intervals[x][0] = start;
                    intervals[x][1] = end;
                    x++;

                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            intervals[x][0] = start;
            intervals[x][1] = end;
            x++;

            return Arrays.copyOfRange(intervals, 0, x);
        }
    }

}


