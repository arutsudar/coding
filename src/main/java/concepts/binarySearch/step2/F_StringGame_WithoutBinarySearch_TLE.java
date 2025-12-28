// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/F

package concepts.binarySearch.step2;

import java.util.Scanner;

public class F_StringGame_WithoutBinarySearch_TLE {

    static int solve(String x, String y, int[] a) {
        int n = y.length();
        int m = x.length();
        char[] pCopy = x.toCharArray();
        char[] tCopy = y.toCharArray();
        int i=0;
        for (; i<m; i++) {
            pCopy[a[i]-1] = '0';
            if (isSubsequence(m, n, pCopy, tCopy)) {

            } else {
                break;
            }
        }
//        if (i>0) pCopy[a[i]-1] = x.charAt(a[i]-1);
//        for (int j=0; j<m; j++) {
//            System.out.print(pCopy[j]);
//        }
        return i;
    }

    private static boolean isSubsequence(int m, int n, char[] pCopy, char[] tCopy) {
        boolean flag = false;
        int j = 0;
        for (int i=0; i<n; i++) {
            flag = false;
            for (; j<m; j++) {
                if (tCopy[i] == pCopy[j]) {
                    flag = true;
                    j++;
                    break;
                }
            }
            if (!flag) break;
        }
        return flag;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.next();
        String t = scanner.next();
        int n = p.length();
        int[] a = new int[n];
        for (int i=0 ; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int answer = solve(p, t, a);
        System.out.println(answer);
    }

}