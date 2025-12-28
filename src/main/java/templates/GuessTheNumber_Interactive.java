package templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GuessTheNumber_Interactive {

    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int l = 1, r = 1000000, ans = 0;
        while (l <= r) {
            int m = l + (r-l)/2;
            out.println(m);
            out.flush();
            if (in.readLine().equals("<"))
                r = m - 1;
            else {
                l = m+1;
                ans = m;
            }
        }
        out.println("! " + ans);
        out.flush();
    }

}
