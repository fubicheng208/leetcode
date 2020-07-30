package ali;

public class Ali3 {
    public String replaceString(String s, String beReplaced, String replace) {
        int index = s.indexOf(beReplaced);
        char[] chs = s.toCharArray();
        String s1 = s.substring(0, index);
        String s2 = s.substring(index);
        char[] res = new char[s.length() + replace.length() - beReplaced.length()];
        for (int i = 0, j = 0; i < index + beReplaced.length(); i++, j++) {
            if (i < index)
                res[j] = chs[i];
            else if (i >= index && i <= index + replace.length())
                continue;
            else
        }
    }
}
