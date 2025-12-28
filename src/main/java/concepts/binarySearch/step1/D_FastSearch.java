// https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/D

package concepts.binarySearch.step1;

import java.util.Arrays;
import java.util.Scanner;

public class D_FastSearch {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        int k = scanner.nextInt();
        for (int i=0; i<k; i++) {
            int lFind = scanner.nextInt();
            int rFind = scanner.nextInt();

            int l = -1;
            int r = n;
            while (l+1<r) {
                int m = (l+r) / 2;
                if (a[m] <= rFind)
                    l = m;
                else
                    r = m;
            }
            int rAns = l+1;

            int l2 = -1;
            int r2 = n;
            while (l2+1<r2) {
                int m = (l2+r2) / 2;
                if (a[m] < lFind)
                    l2 = m;
                else
                    r2 = m;
            }
            int lAns = r2+1;
            System.out.print(rAns - lAns + 1 + " ");
        }
    }

}