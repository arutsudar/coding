package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class DefaultIO {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            StringTokenizer st2 = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int[] a = new int[n];
            for (int i=0; i<n; i++) {
                a[i] = Integer.parseInt(st2.nextToken());
            }
            solve(out, n, a);
        }
        in.close();
        out.close();
    }

    private static void solve(PrintWriter out, int n, int[] a) {
        for (int i=0; i<n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }

}
