package SeleniumBootCamp;

public class Reverseusingtwopointer {

    public static void main (String[] args){

        String str = "Welcome";
        int left = 0;
        int right = str.length() - 1;
        char[] charArray = str.toCharArray();
        while (left < right) {
            char temp = charArray[right];
            charArray[right] = charArray[left];
            charArray[left] = temp;
            left++;
            right--;
        }
        System.out.println(new String(charArray));
    }

}
