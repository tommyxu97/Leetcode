package Algorithm;

public class Q925 {
    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length()) return false;
        int index1 = 0, index2 = 0;
        char c = 'a';
        while (index1 < name.length()) {
            c = name.charAt(index1);
            int count1 = 0, count2 = 0;
            while (index1 < name.length() && name.charAt(index1) == c) {
                index1++; count1++;
            }
            while (index2 < typed.length() && typed.charAt(index2) == c) {
                index2++; count2++;
            }
            if (count1 > count2) return false;
        }
        while (index2 < typed.length()) {
            if (typed.charAt(index2) != c) return false;
            index2++;
        }
        return true;
    }
}
