package test.optus;

public class StringUtils {
    public static boolean isStringLargerThan(String str, int length) {
        if (str == null) {
            return false;
        } else {
            return str.length() > length;
        }
 }


}
