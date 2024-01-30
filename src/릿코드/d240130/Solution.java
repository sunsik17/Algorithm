package 릿코드.d240130;

class Solution {

	public String mergeAlternately(String word1, String word2) {
		int word1Len = word1.length();
		int word2Len = word2.length();
		int len = word1Len + word2Len + (Math.abs(word1Len - word2Len));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				sb.append(word1.charAt(i));
				continue;
			}
			if (i % 2 == 0) {
				if (word1Len > i / 2) {
					sb.append(word1.charAt(i / 2));
				} else {
					sb.append(' ');
				}
			} else {
				if (word2Len > i / 2) {
					sb.append(word2.charAt(i / 2));
				} else {
					sb.append(' ');
				}
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String word1 = "ab";
		String word2 = "pqrs";
		System.out.println(new Solution().mergeAlternately(word1, word2));
	}
}