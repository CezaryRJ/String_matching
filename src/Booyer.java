
public class Booyer {

	int CHAR_MAX = 256;

	public void findNeedle(char[] needle, String haystack) {

		// estsisk del
		System.out.println("Needle = " + new String(needle) + "\nHaystack = " + haystack + "\n");

		for (int i = 0; i < haystack.length() - 1; i++) {
			System.out.print(haystack.charAt(i) + "|");
		}
		System.out.print(haystack.charAt(haystack.length() - 1) + "\n");

		// faktisk losning
		int start = 0, end = needle.length;
		int i = 0;
		while (needle[i] == '_') {
			start++;
			i++;
		}
		i = needle.length - 1;
		while (needle[i] == '_') {
			end--;
			i--;
		}

		int[] badShift = new int[CHAR_MAX]; // 256
		for (i = 0; i < CHAR_MAX; i++) {
			badShift[i] = end - start;

		}
		for (i = 0; i < needle.length - 1; i++) {

			badShift[(int) needle[i]] = needle.length - 1 - i;

		}

		int offset = 0;

		int scan = 0;

		while (offset <= (haystack.length() - needle.length)) {

			for (scan = needle.length - 1; needle[scan] == haystack.charAt(scan + offset)
					|| needle[scan] == '_'; scan--) {

				if (scan == 0) {

					printResult(haystack, offset, needle.length);

					break;
				}
			}
			offset += badShift[haystack.charAt(offset + needle.length - 1)];
		}
		System.out.println();
	}

	public void printResult(String haystack, int index, int needleLength) {

		for (int i = 0; i < index * 2; i++) {
			System.out.print(" ");
		}

		for (int i = index; i < needleLength + index - 1; i++) {
			System.out.print(haystack.charAt(i) + "|");
		}

		System.out.print(haystack.charAt(index + needleLength - 1));
		for (int i = 0; i < (haystack.length() - index - needleLength) * 2 + 1; i++) {
			System.out.print(" ");
		}
		System.out.print(index + "\n");
	}

}
