package templates;

class SegmentTree_RangeSum {

    private int[] a;
    private int n;

    public SegmentTree_RangeSum(int[] nums) {
        n = nums.length;
        a = new int[n*2];
        for (int i=n-1; i>=0; i--)
            a[i+n] = nums[i];
        for (int i=n-1; i>=0; i--)
            a[i] = a[i<<1] + a[i<<1 | 1];
    }

    public void update(int index, int val) {
        int i=index+n;
        int originalVal = a[i];
        a[i] = val;
        for (; i>0 ; i/=2)
            a[i/2] += val - originalVal;
    }

    public int sumRange(int left, int right) {
        int l=left+n;
        int r=right+n;
        int sum = 0;
        for ( ; l<=r ; l/=2, r/=2) {
            if (l%2 == 1) sum += a[l++];
            if (r%2 == 0) sum += a[r--];
        }
        return sum;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */