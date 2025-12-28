// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/B

package concepts.binarySearch.step2;

import java.util.Scanner;

public class B_Ropes {

    static boolean good(double[] a, double n, double x, double pieces) {
        int s = 0;
        for (int i=0 ;i<n; i++) {
            s += a[i]/x;
        }
        return s >= pieces;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double pieces = scanner.nextInt();
        double[] a = new double[n];

        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        double l = 0;
        double r = 10000001;

        while(r-l > 0.0000001) {
            double m = (l+r) / 2;
            if (good(a, n, m, pieces))
                l = m;
            else
                r = m;
//            System.out.println(l + " " + r);
        }
        System.out.println(r);
    }

}