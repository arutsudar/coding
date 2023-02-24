// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/C

package concepts.binarySearch.step2;

import java.util.Scanner;

public class C_VeryEasyTask {

    static boolean good(long m, int copies, int type1S, int type2S) {
        if (type1S > type2S) {
            m-=type2S;
            copies--;
        } else {
            m-=type1S;
            copies--;
        }
        return m/type1S + m/type2S >= copies;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int copies = scanner.nextInt();
        int type1PrinterSeconds = scanner.nextInt();
        int type2PrinterSeconds = scanner.nextInt();

        long l = Math.min(type1PrinterSeconds, type2PrinterSeconds) - 1;
        long r = Math.max(type1PrinterSeconds, type2PrinterSeconds) * copies;

        while(l+1 < r) {
            long m = (l+r) / 2;
            if (good(m, copies, type1PrinterSeconds, type2PrinterSeconds))
                r = m;
            else
                l = m;
//            System.out.println(l + " " + r);
        }
        System.out.println(r);
    }

}