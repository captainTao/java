import java.util.Scanner;
import java.util.Stack;

public class stringOrder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要逆转的字符串：");
        String inputStr = sc.next();
        System.out.println(stringReverseByStrReverse(inputStr));
    }

    /**
     * 用StringBuffer或StringBuilder的reverse()
     */
    public static String stringReverseByStrReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }


    /**
     * 把字符串转为数组，然后再反向取
     */
    public static String stringReverseByCharArray(String str) {
        int strLength = str.length();
        char[] stringArray = str.toCharArray();
        for (int i = 0; i < strLength / 2; i++) {
            stringArray[i] = str.charAt(strLength - 1 - i);
            stringArray[strLength - 1 - i] = str.charAt(i);
        }
        return new String(stringArray);
    }

    /**
     * 新建StringBuffer通过反向index添加char,
     * StringBuffer是线程安全，即使StringBuilder比StringBuffer要快
     */
    public static String stringReverseByNewString(String str) {
        int strLength = str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = strLength - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 新建一个stack,利用它的先进后出原理来重新生成一个char[]
     * */
    public static String stringReverseByStack(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Stack<Character> strStack = new Stack<Character>();
        char[] chArray = str.toCharArray();
        for(Character ch: chArray) {
            strStack.push(ch);
        }
        int strLength = str.length();
        for(int i = 0; i < strLength;i++){
            chArray[i] = strStack.pop();
        }
        return new String(chArray);
    }


    /**
     * 使用递归,每次取string[0],再添加到最后
     * */
    public static String stringReverseByRecursive(String str) {
        if (str == null || str.length() == 0 ||str.length() ==1) {
            return str;
        }
        return stringReverseByRecursive(str.substring(1))+str.charAt(0);
    }
}