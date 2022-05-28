package SeleniumBootCamp;

public class Strinbuffer {

    public static void main(String[] args) {
        String str = "Welcome";
        StringBuffer str1 = new StringBuffer(str);
        str1.reverse();
        System.out.println(str1);
    }
}
