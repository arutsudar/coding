// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/A

package concepts.binarySearch.step2;

import java.util.Scanner;

public class A_PackingRectangles {

    static boolean good(long x, long w, long h, long n) {
        return ((x/w)*(x/h) >= n);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        long w = scanner.nextInt();
        long h = scanner.nextInt();
        long n = scanner.nextInt();

        long l = 0;
        long r = 1;

        while (!good(r, w, h, n)) {
            r = r*2;
        }

        while(l+1<r) {
            long m = (l+r) / 2;
            if (good(m, w, h, n))
                r = m;
            else
                l = m;
        }
        System.out.println(r);
    }

}