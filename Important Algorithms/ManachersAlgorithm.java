public class ManachersAlgorithm {
    public String longestPalindrome(String s) {
        char arr[] = preprocess(s);
        int P[] = new int[arr.length];
        int c = 0;
        int r = 0;
        for (int i = 1; i < arr.length-1; i++) {
            int iMirror = 2 * c - i;
            if (r > i) {
                P[i] = Math.max(0, Math.min(r - i, P[iMirror]));
            }

            while (arr[i + 1 + P[i]] == arr[i - 1 - P[i]]) {
                P[i]++;
            }

            if (i + P[i] > r) {
                c = i;
                r = i + P[i];
            }
        }
        int centreIndex = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < P.length; i++) {
            if (P[i] > maxLen) {
                centreIndex = i;
                maxLen = P[i];
            }
        }
        return s.substring((centreIndex - maxLen) / 2, (centreIndex + maxLen) / 2);
    }

    public char[] preprocess(String s) {
        char[] arr = new char[2 * s.length() + 3];
        arr[0] = '@'; // start placeholder
        for (int i = 0; i < s.length(); i++) {
            arr[2 * i + 1] = '#';
            arr[2 * i + 2] = s.charAt(i);
        }
        arr[2 * s.length() + 1] = '#';
        arr[2 * s.length() + 2] = '$'; // end placeholder
        return arr;
    }
}
