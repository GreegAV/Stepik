package Stepik;

/**
 * Checks if given <code>text</code> is a palindrome.
 *
 * @param text any string
 * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
 */
public class Palindrome {
    public static void main(String[] args) {
        if (isPalindrome("Madam, I'm Adam!")) {
            System.out.println("YES!");
        }
        else {
            System.out.println("NO!");
        }
    }

    public static boolean isPalindrome2(String text) {
        String src="";
        String tst="";
        for (int i = 0; i <text.length() ; i++) {
            if (Character.isAlphabetic(text.charAt(i)))
                src+=text.charAt(i);
        }

        for (int i = text.length()-1; i >=0 ; i--) {
            if (Character.isAlphabetic(text.charAt(i)))
            tst+=text.charAt(i);
        }
        return src.equalsIgnoreCase(tst);
    }

    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder revst = new StringBuilder(text);
        revst = revst.reverse();
        String str = new String(revst);

        return text.equalsIgnoreCase(str);
    }
}
