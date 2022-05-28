package SeleniumBootCamp;

public class Stringbuilder {

    public static void main(String[] args) {

        String str = "Welcome";

       StringBuilder str1 = new StringBuilder(str);
       str1.reverse();
       System.out.println(str1);
    }
}
