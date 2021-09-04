public class KMPStringMatching {
    public static void main(String[] args) {
        // String text = "adsgwadsxdsgwadsgz";
        // String pattern = "dsgwadsgz";

        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";

        // String text = "AABAACAADAABAABA";
        // String pattern = "AABA";

        int[] lps = computeLPS(pattern);

        for (int i = 0; i < lps.length; i++) {
            System.out.print(lps[i] + "\t");
        }

        matchPattern(text, pattern, lps);
    }

    public static void matchPattern(String text, String pattern, int[] lps) {
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                System.out.printf("\nPattern found at index %d", i - j);
                j = lps[j-1];
            }

            else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

    }

    public static int[] computeLPS(String pattern) {
        // Iterators i and j
        int i = 0, j = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0;

        // Traverse pattern
        while (j < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                j++;
                i++;
            } else {
                if (i != 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = i;
                    j++;
                }

            }
        }

        return lps;
    }

}