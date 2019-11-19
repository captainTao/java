Java SE：Standard Edition
Java EE：Enterprise Edition
Java ME：Micro Edition

JDK：Java Development Kit
JRE：Java Runtime Environment

JSR规范：Java Specification Request
JCP组织：Java Community Process

RI：Reference Implementation
TCK：Technology Compatibility Kit


public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}

java：这个可执行程序其实就是JVM，运行Java程序，就是启动JVM，然后让JVM执行指定的编译后的代码；
javac：这是Java的编译器，它用于把Java源码文件（以.java后缀结尾）编译为Java字节码文件（以.class后缀结尾）；
jar：用于把一组.class文件打包成一个.jar文件，便于发布；
javadoc：用于从Java源码中自动提取注释并生成文档；
jdb：Java调试器，用于开发阶段的运行调试。

// 对于float类型，需要加上f后缀。
float f1 = 3.14f;
float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38

一个字节8个bit
byte：-128 ~ 127 // 2^8
short,char: 2 byte //-32768 ~ 32767
int,float,boolean: 4 byte //-2147483648 ~ 2147483647, 21个亿
long,double: 8 byte // -9223372036854775808 ~ 9223372036854775807

注意：
char a = 'A';
String b = "adb" //一个是单引号，一个是双引号

常量修饰符final;
final double PI = 3.14; // PI是一个常量

类型推断 var
var sb = new StringBuilder();

整数的除法对于除数为0时运行时将报错，但编译不会报错

位移运算：
<<  // 负数可以变正数，正数也能移成负数
>>  // 有符号的右移，负数是最前面补1，然后移动
>>> // 不带符号的右移运算

位运算:
n = 1 & 0; // 0
n = 0 | 1; // 1
n = ~0; // 1

n = 1 ^ 0; // 1  ,异或，是两个数相同才为1，不同为0
n = 1 ^ 1; // 0

运算优先级:
()
! ~ ++ --
* / %
+ -
<< >> >>>
&
|
+= -= *= /=


NaN表示Not a Number
Infinity表示无穷大
-Infinity表示负无穷大
double d1 = 0.0 / 0; // NaN
double d2 = 1.0 / 0; // Infinity
double d3 = -1.0 / 0; // -Infinity

如果要进行四舍五入，可以对浮点数加上0.5,再强制转型为整型

boolean运算：
比较运算符：>，>=，<，<=，==，!=
与运算 &&
或运算 ||
非运算 !

优先级：
!
>，>=，<，<=
==，!=
&&
||

短路运算：
false && x
三元：
b ? x : y

\n 表示换行符
\r 表示回车符



字符，字符串：
___________
// 一个英文字符和一个中文字符都用一个char类型表示，它们都占用两个字节。
char c1 = 'A';
char c2 = '中';

char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013

// 要显示一个字符的Unicode编码，只需将char类型直接赋值给int类型即可：
int n1 = 'A'; // 字母“A”的Unicodde编码是65
int n2 = '中'; // 汉字“中”的Unicode编码是20013

String s = "abc\"xyz"; 

字符串连接：
String s = s1 + " " + s2 + "!";
// 用+连接字符串和其他数据类型，会将其他类型数据自动转换为字符类型
int age = 25;
String s = "age is " + age;

从Java 13开始，字符串可以用"""..."""表示多行字符串
多行字符串是作为Java 13的预览特性（Preview Language Features）实现的，编译的时候，我们还需要给编译器加上参数：
javac --source 13 --enable-preview Main.java


字符串的不可变是指字符串内容不可变。

null 与 "" 不一样

String.replace()
String.replaceAll() // 支持正则


数组：
_______
int[] ns = new int[5];
int ns[] = new int[5];
// int[] ns = {1,2,3,4,5}
ns[0] = 68;
ns.length
1.数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
2.数组一旦创建后，大小就不可改变。
3.数组是引用类型，并且数组大小不可变。

// Arrays.toString(array)
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 1, 2, 3, 5, 8 };
        System.out.println(Arrays.toString(ns));
    }
}

// 打印二维数组：
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[][] ns = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
        };
        System.out.println(Arrays.deepToString(ns));
    }
}

// Arrays.sort(ns);
// 整形数组内部会变化位置，而字符串数组不会变化位置，是指向变化了；


// array1 = array2, 数组直接赋值


输出:
_________
print，println，printf

double d = 3.1415926;
System.out.printf("%.4f\n", d); // 显示4位小数3.1416
int n = 12345000;
System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数,把一个整数格式化成十六进制，并用0补足8位
/*
%d  格式化输出整数
%x  格式化输出十六进制整数
%f  格式化输出浮点数
%e  格式化输出科学计数法表示的浮点数
%s  格式化字符串
*/


输入:
_________

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        System.out.print("Input your name: "); // 打印提示
        String name = scanner.nextLine(); // 读取一行输入并获取字符串
        System.out.print("Input your age: "); // 打印提示
        int age = scanner.nextInt(); // 读取一行输入并获取整数
        System.out.printf("Hi, %s, you are %d\n", name, age); // 格式化输出
    }
}


==  // 判断值是否相等，不能判断两个变量是否相等，因为引用的地址不一样
s1.equals(s2) // 判断两个变量的内容是否相等
public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");
        }
    }
}


/*
 *逻辑:
 *_________
 */
if ...else if ...


// 编译检查,可以检查是否漏写break和default;
switch(value){  //可以匹配值或者字符串，字符串的时候，是比较的内容
    case value1:
        ...;
        break;
    case value2:
        ...;
        break;
    case value3: // 同一个执行效果的时候
    case value4:
        ...;
        break; 
    default:
        ...;
        break;
}

java 12之后支持switch的新语法
从Java 13开始，switch语句升级为表达式，不再需要break，并且允许使用yield返回值 // so到底是12还是13？
public class Main {
    public static void main(String[] args) {
        String fruit = "apple";
        switch (fruit) {
        case "apple" -> System.out.println("Selected apple");
        case "pear" -> System.out.println("Selected pear");
        case "mango" -> {
            System.out.println("Selected mango");
            System.out.println("Good choice!");
        }
        default -> System.out.println("No fruit selected");
        }
    }
}
// 更可以直接返回值
public class Main {
    public static void main(String[] args) {
        String fruit = "apple";
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> 0;
        }; // 注意赋值语句要以;结束
        System.out.println("opt = " + opt);
    }
}
// yield作为switch语法的返回值
public class Main {
    public static void main(String[] args) {
        String fruit = "orange";
        int opt = switch (fruit) {
            case "apple" -> 1;
            case "pear", "mango" -> 2;
            default -> {
                int code = fruit.hashCode();
                yield code; // switch语句返回值
            }
        };
        System.out.println("opt = " + opt);
    }
}

// while(){} 
// do{}while()
// for(){}
public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=1; i<=100; i++) {
            sum = sum + i;
        }
        System.out.println(sum);
    }
}

// for each 可以遍历list,map, for each不是关键字；
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n);
        }
    }
}

break // 结束整个循环
continue//结束本次循环执行下次


