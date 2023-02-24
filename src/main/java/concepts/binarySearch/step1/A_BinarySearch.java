// https://codeforces.com/edu/course/2/lesson/6/1/practice/contest/283911/problem/A

package concepts.binarySearch.step1;

import java.util.Scanner;

public class A_BinarySearch {

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
            int l = 0;
            int r = n-1;
            while (l<r) {
                int m = (l+r) / 2;
                if (a[m] == x) {
                    break;
                }
                else if (a[m] < x)
                    l = m+1;
                else
                    r = m-1;
            }
            if (a[(l+r)/2] == x)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

}

