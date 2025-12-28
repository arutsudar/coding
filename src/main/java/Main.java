import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            StringTokenizer st1 = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            int L = Integer.parseInt(st1.nextToken());
            int[][] hurdles = new int[n][2];
            int[][] powerUps = new int[m][2];
            for (int i=0; i<n; i++) {
                StringTokenizer st2 = new StringTokenizer(in.readLine());
                hurdles[i][0] = Integer.parseInt(st2.nextToken());
                hurdles[i][1] = Integer.parseInt(st2.nextToken());
            }
            for (int i=0; i<m; i++) {
                StringTokenizer st3 = new StringTokenizer(in.readLine());
                powerUps[i][0] = Integer.parseInt(st3.nextToken());
                powerUps[i][1] = Integer.parseInt(st3.nextToken());
            }
            Arrays.sort(powerUps, (a,b) -> (a[0] != b[0]) ? (a[0] - b[0]) : (b[1] - a[1]));
        }
        in.close();
        out.close();
    }

}