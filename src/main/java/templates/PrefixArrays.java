package templates;

public class PrefixArrays {

    private static int[] getPrefixXor(int[] a) {
        int n = a.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = a[0];
        for (int i = 1; i < n; i++)
            prefixXor[i] = prefixXor[i - 1] ^ a[i];
        return prefixXor;
    }

}
