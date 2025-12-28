// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/E

package concepts.binarySearch.step2;

import java.util.Scanner;

public class E_Equation {

    static boolean good(double x, double c) {
        return Math.pow(x,2) + Math.sqrt(x) >= c;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double c = scanner.nextFloat();

        double l = 0;
        double r = c;

        while(r-l >= 0.000001) {
            double m = (l+r) / 2;
            if (good(m, c))
                r = m;
            else
                l = m;
        }
        System.out.println(r);
    }

}