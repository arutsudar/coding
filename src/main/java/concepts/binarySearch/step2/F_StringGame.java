// https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/F

package concepts.binarySearch.step2;

import java.util.Scanner;

public class F_StringGame {

    static int solve(String x, String y, int[] a) {
        int n = y.length();
        int m = x.length();
        char[] pCopy = x.toCharArray();
        char[] tCopy = y.toCharArray();
        int l = 0;
        int r = m-n+1;
        while (l+1 < r) {
            int mid = (l+r) / 2;
            if (good(a, n, mid, m, pCopy.clone(), tCopy.clone())) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private static boolean good(int[] a, int n, int binarySearch, int m, char[] pCopy, char[] tCopy) {
        for (int i=0; i<binarySearch; i++) {
            pCopy[a[i]-1] = '0';
        }
        return isSubsequence(m, n, pCopy, tCopy);
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