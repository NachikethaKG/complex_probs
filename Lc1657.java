import java.util.Arrays;

 class Lc1657 {
    public boolean closeStrings(String word1, String word2) {
        // Condition 1: Lengths must be equal
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequencies of each character
        for (char c : word1.toCharArray()) freq1[c - 'a']++;
        for (char c : word2.toCharArray()) freq2[c - 'a']++;

        // Condition 2: They must contain the exact same unique characters
        for (int i = 0; i < 26; i++) {
            // If one word has a character but the other doesn't, they aren't close
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        // Condition 3: The frequency distributions must be identical when sorted
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }
    public static void main(String[] args) {
        Lc1657 solution = new Lc1657();
    System.out.println(solution.closeStrings("abc", "bca")); // true
    System.out.println(solution.closeStrings("abc", "dacb")); // false
}
}