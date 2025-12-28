// https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/B

package concepts.binarySearch.step1;

import java.util.Scanner;

public class B_ClosestToTheLeft {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i=0; i<k; i++) {
            int x = scanner.nextInt();
            int l = -1;
            int r = n;
            while (l+1<r) {
                int m = (l+r) / 2;
                if (a[m] <= x)
                    l = m;
                else
                    r = m;
            }
            System.out.println(l+1);
        }
    }

}
