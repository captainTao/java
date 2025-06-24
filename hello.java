/*
??
1.set类型如何取值？

2.oc sign,token文件位置
ATNetworkDao.m
ATQNSinal.m
needSignatureString

3.单例和静态方法的优劣势？
4.getResourceAsStream路径获取方法
需要建立resources文件夹
https://www.cnblogs.com/printN/p/6204092.html

5.jackson解析嵌套xml

6.md5后是多少位数？
md5后的byte数组长度是16，byte[]数组内java是包含正负数的，oc,python全部是正数
转换为16进制后是一个长度为32的字符串

7.时间戳
// 返回时间距离1970的ms数：（用的时间戳*1000）
String timeNow = String.valueOf(new Date().getTime());
// oc中：
NSString *time = [NSString stringWithFormat:@"%.0f",[[NSDate date] timeIntervalSince1970] * 1000];

8.判断是否是某种类型
https://blog.csdn.net/weixin_49794051/article/details/108843083
instance of
isInstance
getClass()
isPrimitive
*/


/*

intel ideal使用教程：
https://www.cnblogs.com/zsty/p/9950722.html

Java SE：Standard Edition
Java EE：Enterprise Edition
Java ME：Micro Edition

JDK：Java Development Kit
JRE：Java Runtime Environment

JSR规范：Java Specification Request
JCP组织：Java Community Process

RI：Reference Implementation
TCK：Technology Compatibility Kit


int.class.isPrimitive()  //判断是否是基本数据类型
a instanceof Object  // 判断是否是类对象

String s = String.valueOf(int.class);
System.out.println(s.equals("int"));

System.exit(0) //正常退出，一般用在if中
System.exit(1) //非正常退出，一般放在Catch中


hasNextLine() // 有输入就算
hasNext() // 输入非空或空白字符
*/

/*
eclipse查看jar源代码的方式：
https://blog.csdn.net/xiashenbao/article/details/90691544
进入：http://java-decompiler.github.io/
选择JD－Eclipse下载
https://blog.csdn.net/dufufd/article/details/79415141

intelli idea查看jar
https://blog.csdn.net/qq_39704682/article/details/86610092

*/



/*
1.两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？
不对，两个对象的 hashCode()相同，equals()不一定 true。

代码示例：

String str1 = "通话";
String str2 = "重地";
System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
System.out.println(str1.equals(str2));
执行的结果：

str1：1179395 | str2：1179395

false

//代码解读：很显然“通话”和“重地”的 hashCode() 相同，然而 equals() 则为 false，因为在散列表中，hashCode()相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等。


2. String 不属于基础类型，基础类型有 8 种：byte、boolean、char、short、int、float、long、double，而 String 属于对象


3.栈内存和堆内存的区别？
 栈：存放局部变量和堆中对象变量的引用，由系统分配，先进后出，更新速度快，存放变量生命周期结束，立即被释放。栈内存只通过一个线程来运行和使用，不能被其他线程所访问。
 堆：存放对象，由程序员分配，先进先出，更新速度慢，没有引用指向的时候，会被系统内存回收机制不定时回收。堆是被所有线程共享的，所以存储在堆中的对象是全局可以被访问的，在JVM中只有一个堆。


4.内存划分为那些区？
 寄存器(Register) --最快的存储区；
 栈内存（Stack）--存放：局部变量，函数参数值，操作数栈，运行时常量池，数组引用，方法返回地址；内存由系统自动分配；
 堆内存（Heap）--存放：new的对象和数组；内存由程序员分配和释放；
 本地方法区（Native Method）--是为执行本地方法（Native Method）服务的；
 方法区（）--存放：类信息，静态变量，常量以及编译后的代码；
 非RAM存储；


1、栈区（stacksegment）—由编译器自动分配释放,存放函数的参数值，局部变量的值等，具体方法执行结束之后，系统自动释放JVM内存资源
2、堆区（heapsegment）—一般由程序员分配释放，存放由new创建的对象和数组，jvm不定时查看这个对象，如果没有引用指向这个对象就回收
3、静态区（datasegment）—存放全局变量，静态变量和字符串常量，不释放
4、代码区（codesegment）—存放程序中方法的二进制代码，而且是多个对象共享一个代码空间区域



5.向量和数组的区别
https://blog.csdn.net/qq_37723158/article/details/79024838
向量和数组相似，都可以保存一组数据（数据列表）。

a.向量的容量是可变的; 数组不可变。
b.向量的任意位置可以插入不同类型的对象，无需考虑对象的类型，而数组是同一类型。
c.向量作为一种对象提供了比数组更多的方法。
d.向量只能存储对象，不能直接存储简单数据类型，而数组可以。


6.接口和抽象类有哪些区别？
a.一个类可以实现很多个接口，但是只能继承一个抽象类。
b.抽象类可以有构造函数；接口不能有。
c.抽象类不一定非要有抽象方法,而接口都是抽象方法。
d.接口中的方法默认使用 public 修饰；抽象类中的方法可以是任意访问修饰符。
e.抽象类可以有 main 方法，并且我们能运行它；接口不能有 main 方法
f.接口中的字段是public statc final类型，而抽象类中的字段可以随意修饰。
*/



/**
  *java：这个可执行程序其实就是JVM，运行Java程序，就是启动JVM，然后让JVM执行指定的编译后的代码；
  *javac：这是Java的编译器，它用于把Java源码文件（以.java后缀结尾）编译为Java字节码文件（以.class后缀结尾）；
  *jar：用于把一组.class文件打包成一个.jar文件，便于发布；
  *javadoc：用于从Java源码中自动提取注释并生成文档；
  *jdb：Java调试器，用于开发阶段的运行调试。
  */


// Eclipse格式化代码快捷键： Ctrl(win)+Shift+F
// 具体的代码格式要求可以在Eclipse的设置中Java-Code Style查看


-----------------------------------------------------------------------------
java类：

1. 基础类（java.lang）
这些类是 Java 的核心，使用时不需要导入。
类名  用途
String  字符串处理
StringBuilder / StringBuffer    可变字符串
Math    数学运算
Object  所有类的父类
System  系统相关功能（如输入输出）
Runtime 运行时环境信息
Thread  多线程编程
Exception / Throwable   异常处理

2. 数学与大数（java.math）
类名  用途
BigInteger  任意精度整数
BigDecimal  任意精度小数

3. 集合框架（java.util）
类名  用途
ArrayList / LinkedList  列表
HashMap / TreeMap   键值对映射
HashSet / TreeSet   集合（不重复元素）
Collections 集合工具类
Arrays  数组工具类

4. 日期与时间（java.time）
类名  用途
LocalDate   表示日期（无时间）
LocalTime   表示时间（无日期）
LocalDateTime   日期 + 时间
ZonedDateTime   带时区的日期时间
DateTimeFormatter   日期时间格式化

5. 输入输出（java.io & java.nio）
类名  用途
File    文件操作
FileReader / FileWriter 字符流读写
BufferedReader / BufferedWriter 缓冲字符流
InputStream / OutputStream  字节流
Files   文件工具类（NIO）
Paths / Path    路径处理（NIO）

6. 网络编程（java.net）
类名  用途
URL 处理网络地址
Socket / ServerSocket   网络通信
HttpURLConnection   HTTP 请求

7. 实用工具类
类名  用途
Scanner 控制台输入
Random  随机数生成
UUID    唯一标识符生成
Properties  配置文件读取
-----------------------------------------------------------------------------
public class Hello { // Hello,表示类，首字母要大写, class名称和文件名要完全一致
    // Java入口程序规定的方法必须是静态方法，方法名必须为main，括号内的参数必须是String数组。
    // 方法名也有命名规则，命名和class一样，但是首字母小写
    public static void main(String[] args) {
        System.out.println("Hello, world!"); // 每一行都要分号
        // 命令行参数，执行的时候可以加上参数: java Hello -version
        for (String arg : args) {
            if ("-version".equals(arg)) {
                System.out.println("v 1.0");
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {  // void main为某个类的主程序入口
            // ....
        }
    }
/*
1.一个Java源码只能定义一个public类型的class，并且class名称和文件名要完全一致；
2.使用javac可以将.java源码编译成.class字节码；
3.使用java可以运行一个已编译的Java程序，参数是类名。
4.java单文件执行: (xx为类名)
  java xx.java （java11及以上才支持）
  javac xx.java ----> xx.class  ----> java xx (xx.class)
*/

// 对于float类型，需要加上f后缀。
float f1 = 3.14f;
float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38

一个字节（byte）8个bit
byte：-128 ~ 127 // 2^8
short,char: 2 byte //-32768 ~ 32767
int,float,boolean: 4 byte //-2147483648 ~ 2147483647, 21个亿
long,double: 8 byte // -9223372036854775808 ~ 9223372036854775807
String :1汉字 = 2byte, 16bit

关于byte和int之间的联系的理解：
https://www.cnblogs.com/think-in-java/p/5527389.html

// boolean (true, false)

浮点函数科学计数法：对于float类型，需要加上f后缀
float f1 = 3.14f;
float f2 = 3.14e38f; // 科学计数法表示的3.14x10^38
double d = 1.79e308;
double d2 = -1.79e308;
double d3 = 4.9e-324; // 科学计数法表示的4.9x10^-324


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
>>> // 不带符号的右移运算,负数会变成正数

位运算: 与或非
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


类型提升和强制转型
short s = 1234;
int i = 123456;
int x = s + i; // s自动转型为int

int i = 12345;
short s = (short) i; // 12345  (类型)


NaN表示Not a Number
Infinity表示无穷大
-Infinity表示负无穷大
double d1 = 0.0 / 0; // NaN
double d2 = 1.0 / 0; // Infinity
double d3 = -1.0 / 0; // -Infinity

如果要进行四舍五入，可以对浮点数加上0.5,再强制转型为整型


四舍五入：
----------
用Math.round()
double value = 3.14859;
String formattedValue = String.format("%.2f", value); // 四舍五入到两位小数
System.out.println(formattedValue); // 输出：3.14

用bigdecimal的setScale
import java.math.BigDecimal;
import java.math.RoundingMode;
System.out.println(BigDecimal.valueOf(5.7583456).setScale(2, RoundingMode.FLOOR));

collectEntries
------------------------
Map currentAccountValueMapPe = WebUI.callTestCase(findTestCase('Tools/PolicyInvestmentChange/GetAccountValue'), [('policyNum') : policyNum, ('triggerDate') : effectiveDateAT], FailureHandling.STOP_ON_FAILURE)
def currentAccountValueMap = currentAccountValueMapPe.collectEntries{
    key, value ->
    [('currentAccountValue' + key): value]
}


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
// 比较大小
int result = x.compareTo(y);
System.out.println("比较: " + (result > 0 ? "x > y" : result < 0 ? "x < y" : "x = y"));

\n 表示换行符
\r 表示回车符



字符，字符串：
___________
// 一个英文字符和一个中文字符都用一个char类型表示，它们都占用两个字节。
// 单引号字符，双引号字符串
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


字符串的不可变是指字符串内容不可变。对字符串重新赋值，只是改变变量名的指向而已。

null 与 "" 不一样

String.replace()
String.replaceAll() // 支持正则




String类
--------
/*
Java字符串String是不可变对象；
字符串操作不改变原字符串内容，而是返回新字符串；
常用的字符串操作：提取子串、查找、替换、大小写转换等；
*/


// 比较
// 1.比较两个字符串用equals(),不用==：
// 2.equalsIgnoreCase()可以忽略大小写
public class Main {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}

// 是否包含子串和切割:
"Hello".contains("ll"); // true
"Hello".indexOf("l"); // 2
"Hello".lastIndexOf("l"); // 3
"Hello".startsWith("He"); // true
"Hello".endsWith("lo"); // true
"Hello".substring(2); // "llo"
"Hello".substring(2, 4); "ll"

// 去除空格
trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n
"  \tHello\r\n ".trim(); // "Hello"
trim()并没有改变字符串的内容，而是返回了一个新字符串。

strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
"\u3000Hello\u3000".strip(); // "Hello"
" Hello ".stripLeading(); // "Hello "
" Hello ".stripTrailing(); // " Hello"
String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：

"".isEmpty(); // true，因为字符串长度为0
"  ".isEmpty(); // false，因为字符串长度不为0
"  \n".isBlank(); // true，因为只包含空白字符
" Hello ".isBlank(); // false，因为包含非空白字符


// 替换
String s = "hello";
s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
// 正则替换
String s = "A,,B;C ,D";
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D", 不改变s的值

// 分割
String s = "A,B,C,D";
String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}

// 拼接
String[] arr = {"A", "B", "C"};
String s = String.join("***", arr); // "A***B***C"

// list转为String
String.join("", list);// 方法一通过join
list.stream().collect(Collectors.joining("")); // 方法二通过stream()


// 格式化字符串
public class Main {
    public static void main(String[] args) {
        String s = "Hi %s, your score is %d!";
        System.out.println(s.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));
    }
}

// 类型转换
String.valueOf(123); // "123"
String.valueOf(45.67); // "45.67"
String.valueOf(true); // "true"
String.valueOf(new Object()); // 类似java.lang.Object@636be97c

int n1 = Integer.parseInt("123"); // 123
int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

boolean b1 = Boolean.parseBoolean("true"); // true
boolean b2 = Boolean.parseBoolean("FALSE"); // false

// Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
Integer.getInteger("java.version"); // 版本号，11

// 字符串转为浮点函数
//方法一
double score = Double.valueOf(sscore).doubleValue();
double score = Double.parseDouble(sscore);

//方法二
int a = Integer.valueOf(s).intValue();
integer.parseInt(String s);



// char和string互转
char[] cs = "Hello".toCharArray(); // String -> char[]
String s = new String(cs); // char[] -> String

// 如果修改了char[]数组，String并不会改变：
// 通过new String(char[])创建新的String实例时，它并不会直接引用传入的char[]数组，而是会复制一份
public class Main {
    public static void main(String[] args) {
        char[] cs = "Hello".toCharArray();
        String s = new String(cs);
        System.out.println(s); // Hello
        cs[0] = 'X';
        System.out.println(s); // Hello
        System.out.println(cs); // Xello
    }
}




数组：
_______
int[] ns = new int[5];
int ns[] = new int[5];
int[] ns = new int[]{1,2,3,4,5};
int[] ns = {1,2,3,4,5};
new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}

ns[0] = 68;
ns.length  // 数组大小
1.数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
2.数组一旦创建后，大小就不可改变。
3.数组是引用类型，并且数组大小不可变,赋值只是改变了元素的指向，跟字符串一样。
4.可以通过索引访问数组元素，但索引超出范围将报错；
5.数组元素可以是值类型（如int）或引用类型（如String），但数组本身是引用类型；

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

// Arrays.sort(ns); 改变的是原来的数组，没有返回值
// 整形数组内部会变化位置，而字符串数组不会变化位置，是指向变化了；


// array1 = array2, 数组直接赋值


// 数组遍历
/*
 * 1.用for
 * 2.用forEach
 * 3.直接打印数组名会输出引用地址
 * 4.快速打印数组:
 * int[] ns = { 1, 1, 2, 3, 5, 8 };
 * System.out.println(Arrays.toString(ns));
 * 二阶以上数组快速输出：System.out.println(Arrays.deepToString(ns));
 */


// List<String[]> 和 String[][]
--------------------------------
// List<String[]>长度可变，String[][]长度固定
// List 提供的丰富方法，如 add、remove、set 等对元素进行增删改操作

// list.get(0)[0]
import java.util.ArrayList;
import java.util.List;

public class ListAccessExample {
    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"apple", "banana"});
        String element = list.get(0)[0];
        System.out.println(element); 
    }
}

// 访问元素：array[row][column]
public class ArrayAccessExample {
    public static void main(String[] args) {
        String[][] array = {{"apple", "banana"}};
        String element = array[0][0];
        System.out.println(element); 
    }
}

// 初始化List<String[]>
-----------------------
// 方法一：初始化空列表，逐个添加
import java.util.ArrayList;
import java.util.List;

public class DefineEmptyListOfStringArrays {
    public static void main(String[] args) {
        // 定义一个存储 String[] 类型元素的空列表
        List<String[]> list = new ArrayList<>();
        // 可以后续向列表中添加字符串数组元素
        String[] array1 = {"apple", "banana"};
        list.add(array1);
        String[] array2 = {"cherry", "date"};
        list.add(array2);

        // 遍历列表并输出元素
        for (String[] array : list) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}

// 方法二：初始化添加

import java.util.ArrayList;
import java.util.List;

public class InitializeListWithElements {
    public static void main(String[] args) {
        // 定义并初始化一个包含字符串数组的列表
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{"red", "green", "blue"});
        list.add(new String[]{"one", "two", "three"});

        // 遍历列表并输出元素
        for (String[] array : list) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
// 方法三：使用java8 API
// Arrays.stream(array).collect(Collectors.toList())

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InitializeListWithStream {
    public static void main(String[] args) {
        // 使用 Stream API 初始化列表
        List<String[]> list = Arrays.stream(new String[][]{
                {"cat", "dog"},
                {"fish", "bird"}
        }).collect(Collectors.toList());

        // 遍历列表并输出元素
        list.forEach(array -> {
            Arrays.stream(array).forEach(element -> System.out.print(element + " "));
            System.out.println();
        });
    }
}




输出:
_________
print，println，printf（可以格式化输出）

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

/**
 * Output:
 
num is 3.141593
num is {003.140}
06.3 num is 03.142
.3 num is 3.142
9.99 num is 10.00
   
*/

public class MainClass {
  public static void main(String args[]) throws Exception {
    System.out.printf("num is %03f\n", 3.14159265 );
    System.out.printf("num is {%07.3f}\n", 3.14 );
    System.out.printf("06.3 num is %06.3f\n", 3.14159265 );
    System.out.printf(".3 num is %.3f\n", 3.14159265 );
    System.out.printf("9.99 num is %4.2f\n", 9.999999999 );

}


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

// Java提供Scanner对象来方便输入，读取对应的类型可以使用：scanner.nextLine() / nextInt() / nextDouble() / ...


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


判断非引用类型是否相等用 ==
引用类型是否相等用 s1.equals(s2)
// 执行语句s1.equals(s2)时，如果变量s1为null，会报NullPointerException：
// 要避免NullPointerException错误，可以利用短路运算符&&：
public class Main {
    public static void main(String[] args) {
        String s1 = null;
        if (s1 != null && s1.equals("hello")) {
            System.out.println("hello");
        }
    }
}



/*
 *流程控制:
 *_________________________________________________
 */
if ...else if ...



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
// IDE编译检查,可以检查是否漏写break和default;
// https://www.liaoxuefeng.com/wiki/1252599548343744/1259541030848864
// case语句并没有花括号{}
// 漏写break导致case语句具有“穿透性”
// 字符串匹配时，是比较“内容相等”,不会比较引用地址


// java 12之后switch语句升级为表达式，不再需要break，并且允许使用yield返回值 
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
        }; // 注意赋值语句(这里赋值opt)要以;结束
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

// 不设置结束条件:
for (int i=0; ; i++) {
    ...
}
// 不设置结束条件和更新语句:
for (int i=0; ;) {
    ...
}
// 什么都不设置:
for (;;) {
    ...
}


// foreach 可以遍历list,map, foreach不是关键字；
public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int n : ns) {
            System.out.println(n); // 输出n为数组元素
        }
    }
}

break // 结束整个循环
continue//结束本次循环执行下次




/*
 * 面向对象:
 *_________________________________________________
 */

/*

面向对象的基本概念，包括：

类

实例

方法

面向对象的实现方式，包括：

继承

多态

Java语言本身提供的机制，包括：

package

classpath

jar

以及Java标准库提供的核心类，包括：

字符串

包装类型

JavaBean

枚举

常用工具类

*/

public class Main {
    public static void main(String[] args) {
        Person ming = new Person();
        ming.setName("Xiao Ming"); // 设置name
        ming.setAge(12); // 设置age
        System.out.println(ming.getName() + ", " + ming.getAge());
    }
}
class Person {
    private String name;
    private int age;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}



// 可变参数：
// ---------------
// 可变参数用类型...定义，可变参数相当于数组类型：
// 可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null。
class Group {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
}
Group g = new Group();
g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
g.setNames("Xiao Ming"); // 传入1个String
g.setNames(); // 传入0个String

// 基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
// 引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方



// 构造方法：
// ---------------

// 1.如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句.
class Person {
    public Person() {
    }
}
// 2.如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
// 3.如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来
// 4.没有在构造方法中初始化字段时，引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false：
// 5.一个构造方法可以调用另外一个构造方法

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Xiao Ming", 15); // 既可以调用带参数的构造方法
        Person p2 = new Person("Li Gang"); // 也可以调用无参数构造方法
        Person p3 = new Person(); // 也可以调用无参数构造方法
    }
}

// 多构造方法：
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 18); // 调用另一个构造方法Person(String, int)
    }

    public Person() {
        this("Unnamed"); // 调用另一个构造方法Person(String)
    }
}

// new Person("Xiao Ming", 20);
// new Person("Xiao Ming");
// new Person();




// 继承,多态，组合
// ------------

/*
1.如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
2.即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
3.所有类继承自最原始的基类Object，都是单继承
*/

class Person {
    protected String name;  //protected是子类可以访问，main不能访问；private是只能父类访问
    protected int age;

    public Person(String name, int age) {
        super(); // 编译器自动添加这一句，自动调用父类的构造方法
        this.name = name;
        this.age = age;
    }
    public void run() {
        System.out.println("Person.run");
    }
}
class Student extends Person {
    protected int score;

    public String hello() {
        return "Hello, " + name; // super.name; this.name在这的效果是一样的
    }
    public Student(String name, int age, int score) {
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }
    @Override   //override不是必需的,只是编译器会帮助检查
    public void run() {
        System.out.println("Student.run");
    }
}


// Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；
// 如果方法签名相同，并且返回值也相同,就是Override。
// 注意：方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在Java程序中，出现这种情况，编译器会报错。


indexOf
// ---------overload举例
int indexOf(int ch)：根据字符的Unicode码查找；
int indexOf(String str)：根据字符串查找；
int indexOf(int ch, int fromIndex)：根据字符查找，但指定起始位置；
int indexOf(String str, int fromIndex)根据字符串查找，但指定起始位置。


// instanceof
// -----------
// 为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：

Student s = new Student();
System.out.println(s instanceof Person); // true
System.out.println(s instanceof Student); // true

Student n = null;
System.out.println(n instanceof Student); // false


// 向上转型（抽象为父类）和向下转型（转为子类）：
Person p = new Student();
if (p instanceof Student) {
    // 只有判断成功才会向下转型:
    Student s = (Student) p; // 一定会成功
}



// 从Java 14开始，判断instanceof后，可以直接转型为指定变量，避免再次强制转型。
Object obj = "hello";
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.toUpperCase());
}
// 改写如下：
public class Main {
    public static void main(String[] args) {
        Object obj = "hello";
        if (obj instanceof String s) {  
// 使用instanceof variable这种判断并转型为指定类型变量的语法时，必须打开编译器开关--source 14和--enable-preview
            // 可以直接使用变量s:
            System.out.println(s.toUpperCase());
        }
    }
}



/*
Object有以下方法：
toString()：把instance输出为String；
equals()：判断两个instance是否逻辑相等；
hashCode()：计算一个instance的哈希值。
*/


// 在必要的情况下，我们可以覆写Object的这几个方法。例如：
class Person {
    ...
    // 显示更有意义的字符串:
    @Override
    public String toString() {
        return "Person:name=" + name;
    }

    // 比较是否相等:
    @Override
    public boolean equals(Object o) {
        // 当且仅当o为Person类型:
        if (o instanceof Person) {
            Person p = (Person) o;
            // 并且name字段相同时，返回true:
            return this.name.equals(p.name);
        }
        return false;
    }

    // 计算hash:
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}



// 子类调用父类的方法，调用super()
class Person {
    protected String name;
    public String hello() {
        return "Hello, " + name;
    }
}

Student extends Person { //?
    @Override
    public String hello() {
        // 调用父类的hello()方法:
        return super.hello() + "!";
    }
}



// final
// --------------
// 1.用final修饰的方法不能被Override：
class Person {
    protected String name;
    public final String hello() {
        return "Hello, " + name;
    }
}

Student extends Person {
    // compile error: 不允许覆写
    @Override
    public String hello() {
    }
}

// 2.用final修饰的类不能被继承
final class Person {
    protected String name;
}
Student extends Person { // compile error: 不允许继承自Person
}

// 3. 对于一个类的实例字段，同样可以用final修饰。用final修饰的字段在初始化后不能被修改。
class Person {
    public final String name = "Unamed";
}
Person p = new Person();
p.name = "New Name"; // compile error!
// 可以在构造方法中初始化final字段：
class Person {
    public final String name;
    public Person(String name) {
        this.name = name;
    }
}



// 抽象方法
// -------------
// 多态中如果父类的方法本身不需要实现任何功能，
// 仅仅是为了定义方法签名，目的是让子类去覆写它，那么，可以把父类的方法声明为抽象方法：

abstract class Person {
    public abstract void run();
}


// 抽象类
// 面向抽象编程
// abstract抽象方法
// --------------

// 面向抽象编程
public class Main {
    public static void main(String[] args) {
        // Person p = new Person(); // 编译错误，抽象类无法实例化
        Person p = new Student();
        p.run();
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}




// 接口： 
// ----------
/*
Java的接口特指interface的定义，表示一个接口类型和一组方法签名，而编程接口泛指接口规范，如方法签名，数据格式，网络协议等。

更高级的抽象类，抽象方法本质上是定义接口规范。更像是声明，或者协议
如果一个抽象类中没有字段，所有方法都是抽象方法，那么就可以定义为接口

可以定义默认的default方法
*/

// abstract class Person {
//     public abstract void run();
//     public abstract String getName();
// }

interface Person {
    void run(); // public abstract修饰符可以省略
    String getName();
    default void run() { //接口中可以定义default方法（JDK>=1.8），在实现中就不用必须写这个实现了；
            System.out.println(getName() + " run");
        }
}
// 当一个具体的class去实现一个interface时，需要使用implements关键字。
class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(this.name + " run");
    }

    @Override
    public String getName() {
        return this.name;
    }
}


// 一个类只能继承自另一个类，不能从多个类继承。但是，一个类可以实现多个interface

class Student implements Person, Hello { // 实现了两个interface
    ...
}

/*
术语区分：
Java的接口特指interface的定义，表示一个接口类型和一组方法签名，而编程接口泛指接口规范，如方法签名，数据格式，网络协议等。
*/


// 接口继承:
// ---------------
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}


static:
-----------
public class Main {
    public static void main(String[] args) {
        Person.setNumber(99);
        System.out.println(Person.number);
    }
}

class Person {
    public String name;
    public int age;

    public static int number;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void setNumber(int value) {
        number = value;
    }
}

/*
静态字段：
1.用static修饰的字段，称为静态字段
2.所有实例都会共享该字段, 是共享空间
3.静态字段并不属于实例
4.一般用： 类名.静态字段来访问静态对象
// System.out.println(Person.number);


静态方法：
5.静态方法不需要实例化，好比oc的类方法
// Person.setNumber(99);
6.静态方法经常用于工具类。例如：
// Arrays.sort()
// Math.random()
7.也经常用于辅助方法。注意到Java程序的入口main()也是静态方法。

*/



8.接口的静态字段
// 因为interface是一个纯抽象类，所以它不能定义实例字段。但是，interface是可以有静态字段的，并且静态字段必须为final类型：
public interface Person {
    // 编译器会自动在定义字段前面加上public statc final:
    int MALE = 1;
    int FEMALE = 2;
}
9.静态类
static class xx{..}



单例模式：
--------
/*
1.自己持有1个自己对象，且为静态持有
2.实例化方法私有，不能被外部实例化
3.外部只能通过类的静态方法获取到一个单例，即持有的对象
4.然后单例调用自己的方法
*/
public class SingleObject {
 
   //创建 SingleObject 的一个对象
   private static SingleObject instance = new SingleObject();
 
   //让构造函数为 private，这样该类就不会被实例化
   private SingleObject(){}
 
   //获取唯一可用的对象
   public static SingleObject getInstance(){
      return instance;
   }
 
   public void showMessage(){
      System.out.println("Hello World!");
   }
}


public class SingletonPatternDemo {
   public static void main(String[] args) {
 
      //不合法的构造函数
      //编译时错误：构造函数 SingleObject() 是不可见的
      //SingleObject object = new SingleObject();
 
      //获取唯一可用的对象
      SingleObject object = SingleObject.getInstance();
 
      //显示消息
      object.showMessage();// Hello World!
   }
}

package
--------
// JDK的Arrays类存放在包java.util下面，因此，完整类名是java.util.Arrays

/*
结构目录：
src存储源码
bin存储编译后的class文件

package_sample
    src
        hong
            Person.java
        ming
            Person.java
        mr
            run
                Arrays.java
        module-info.java
    bin
        ...class  //ide编译后的.class文件会按照src目录结构放在bin文件夹下 
*/



包作用域：
----------
// 1.不用public、protected、private修饰的字段和方法就是包作用域
// 2.编译：(ide会自动编译)javac -d ../bin ming/Person.java hong/Person.java mr/jun/Arrays.java


// 3. import *
// --------
// Person.java
package ming;
// 导入完整类名:
import mr.jun.Arrays;
// 3. *为导入mr.jun包的所有class,但不包括子包的class:
import mr.jun.*;

/*
如果是完整类名，就直接根据完整类名查找这个class；

如果是简单类名，按下面的顺序依次查找：

查找当前package是否存在这个class；

查找import的包是否包含这个class；

查找java.lang包是否包含这个class。
*/


// 4. import static
// -----------------
package main;
// 4. import static为导入System类的所有静态字段和静态方法:
import static java.lang.System.*;
public class Main {
    public static void main(String[] args) {
        // 相当于调用System.out.println(…)
        out.println("Hello, world!");
    }
}

// 5.默认导入系统类 import java.lang.*

/*
Java内建的访问权限包括public、protected、private和package权限；
final修饰符不是访问权限，它可以修饰class、field和method；
一个.java文件只能包含一个public类，但可以包含多个非public类。
如果有public类，文件名必须和public类的名字相同。
*/


/*

包命名：
---------
包名推荐使用倒置的域名，例如org.apache
JDK的其它常用类定义在java.util.*，java.math.*，java.text.*，……；


倒置，子包就可以根据功能自行命名。
org.apache
org.apache.commons.log
com.liaoxuefeng.sample


要注意不要和java.lang包的类重名，即自己的类不要使用这些名字：

String
System
Runtime
...

要注意也不要和JDK常用类重名：

java.util.List
java.text.Format
java.math.BigInteger

*/




classpath, jar
------------------
classpath:
// win间隔用; macos用:
// 用-classpath或者-cp传入参数，不推荐系统变量设置classpath
java -classpath .;C:\work\project1\bin;C:\shared abc.xyz.Hello
java -cp .;C:\work\project1\bin;C:\shared abc.xyz.Hello

/*
jar包还可以包含一个特殊的/META-INF/MANIFEST.MF文件，MANIFEST.MF是纯文本，可以指定Main-Class和其它信息。JVM会自动读取这个MANIFEST.MF文件，如果存在Main-Class，我们就不必在命令行指定启动的类名，而是用更方便的命令：

java -jar hello.jar
jar包还可以包含其它jar包，这个时候，就需要在MANIFEST.MF文件里配置classpath了。
*/

/*
jar包里的第一层目录，不能是bin

JVM通过环境变量classpath决定搜索class的路径和顺序；

不推荐设置系统环境变量classpath，始终建议通过-cp命令传入；

jar包相当于目录，可以包含很多.class文件，方便下载和使用；

MANIFEST.MF文件可以提供jar包的信息，如Main-Class，这样可以直接运行jar包。

java标准库rt.jar,60M左右

打包成jar可以借助Maven
*/



模块
----------
JDK9引入模块概念
将rt.jar分拆成了几十个模块，这些模块以
.jmod扩展名标识，可以在 $JAVA_HOME/jmods 目录下找到他们
模块之间的依赖关系已经被写入到模块内的module-info.class文件
java.base模块不依赖任何模块，它可以被看作是“根模块”,任何模块都会自动引入java.base




// java核心类
///////////////////////////////////////////////


字符编码：
---------
/*
Java使用Unicode编码表示String和char；

转换编码就是将String和byte[]转换，需要指定编码；

转换为byte[]时，始终优先考虑UTF-8编码。
*/
ASCII码

GB2312标准使用两个字节表示一个汉字，其中第一个字节的最高位始终为1，以便和ASCII编码区分开。例如，汉字'中'的GB2312编码是0xd6d0
类似的，日文有Shift_JIS编码，韩文有EUC-KR编码，这些编码因为标准不统一，同时使用，就会产生冲突。

为了统一全球所有语言的编码，全球统一码联盟发布了Unicode编码，它把世界上主要语言都纳入同一个编码，这样，中文、日文、韩文和其他语言就不会冲突。
Unicode编码需要两个或者更多字节表示

UTF-8编码，它是一种变长编码，用来把固定长度的Unicode编码变成1～4字节的变长编码
UTF-8编码的另一个好处是容错能力强

byte[] b1 = "Hello".getBytes(); // 按ISO8859-1编码转换，不推荐
byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
byte[] b2 = "Hello".getBytes("GBK"); // 按GBK编码转换
byte[] b3 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
注意：转换编码后，就不再是char类型，而是byte类型表示的数组。

如果要把已知编码的byte[]转换为String，可以这样做：

byte[] b = ...
String s1 = new String(b, "GBK"); // 按GBK转换
String s2 = new String(b, StandardCharsets.UTF_8); // 按UTF-8转换
始终牢记：Java的String和char在内存中总是以Unicode编码表示。

对于不同版本的JDK，String类在内存中有不同的优化方式。具体来说，早期JDK版本的String总是以char[]存储
而较新的JDK版本的String则以byte[]存储：




StringBuilder, StringJoiner
---------------------------
/*
类似于oc的可变字符串
可变，每次改变并不会创建新的对象，节省内存开销
支持链式操作
*/

public class Main {
    public static void main(String[] args) {
        var sb = new StringBuilder(1024);
        sb.append("Mr ")
          .append("Bob")
          .append("!")
          .insert(0, "Hello, ");
        System.out.println(sb.toString());
    }
}

/*
StringBuilder和StringBuffer接口完全相同，现在完全没有必要使用StringBuffer，StringBuffer是一个过渡版本
StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作

StringBuilder是可变对象，用来高效拼接字符串；
StringBuilder可以支持链式操作，实现链式操作的关键是返回实例本身；
StringBuffer是StringBuilder的线程安全版本，现在很少使用。

StringBuffer 和 StringBuilder 最大的区别在于，StringBuffer 是线程安全的，而 StringBuilder 是非线程安全的，但 StringBuilder 的性能却高于 StringBuffer，所以在单线程环境下推荐使用 StringBuilder，多线程环境下推荐使用 StringBuffer。

要高效拼接字符串，应该使用StringBuilder。
StringJoiner内部实际上就是使用了StringBuilder，所以拼接效率和StringBuilder几乎是一模一样的。
i
*/

public class Main {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        var sb = new StringBuilder();
        sb.append("Hello ");
        for (String name : names) {
            sb.append(name).append(", ");
        }
        // 注意去掉最后的", ":
        sb.delete(sb.length() - 2, sb.length());   // 注意String.delete
        sb.append("!");
        System.out.println(sb.toString());
    }
}


import java.util.StringJoiner;
public class Main {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        // 不会在结尾添加字符
        var sj = new StringJoiner(", "); // Bob, Alice, Grace
        // 可以指定开头和结尾,先定义分隔符，然后开头，然后结尾
        var sj = new StringJoiner(", ", "Hello ", "!"); // Hello Bob, Alice, Grace!
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }
}

// String.join()，String的静态方法
String[] names = {"Bob", "Alice", "Grace"};
var s = String.join(", ", names);


// 字符串反向输出
---------------
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


Instant
--------------
import java.time.Instant;

表示的是一个时间戳（timestamp），精确到纳秒。
不包含时区信息，始终以 UTC 表示。
System.out.println(Instant.parse( "2025-04-01T04:00:00+00:00"));
String now = Instant.now().toString();
System.out.println(now);
System.out.println(Instant.parse(now));

常用方法  说明
Instant.now()   获取当前时间的 Instant
Instant.parse(String)   从字符串解析 Instant
instant.toEpochMilli()  转换为自1970年1月1日以来的毫秒数
instant.plus(Duration)  增加一段时间
instant.minus(Duration) 减少一段时间
instant.isBefore(Instant)   判断是否在另一个时间点之前
instant.isAfter(Instant)    判断是否在另一个时间点之后

long timestamp = Instant.now().toEpochMilli();
System.out.println("当前时间戳（毫秒）: " + String.valueOf(timestamp));

JsonPath
---------------------------------
表达式       说明
$           根对象
.           点操作符，访问子属性
[]          用于访问数组或属性
*           通配符，匹配所有元素
..          递归下降，匹配任意层级的属性
[n]         数组索引
[start:end] 数组切片
[?(<expr>)] 过滤器表达式


$[?(@.<字段> <比较符> <值>)]
------------------------------
@：表示当前数组中的每个元素。
<字段>：要比较的字段名。
<比较符>：如 ==, !=, >, <, >=, <=。
<值>：用于比较的值。

expr支持的操作符
比较：==, !=, <, >, <=, >=
正则匹配：=~（例如 @.title =~ /Book.*/）
逻辑运算：&&, ||

public static void test2(){
    String jsonString = "{\n" +
            "  \"user\": [\n" +
            "    {\n" +
            "      \"name\": \"John\",\n" +
            "      \"gender\": \"girl\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"bob\",\n" +
            "      \"gender\": \"boy\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";
    // 这种parse不支持新增，只支持读和修改
    DocumentContext js = JsonPath.parse(jsonString);
    System.out.println(js.jsonString());

    // 配置 JsonPath, 这种parse可以支持新增,删除
    Configuration conf = Configuration.defaultConfiguration()
            .addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL)
            .addOptions(Option.SUPPRESS_EXCEPTIONS);
    // 解析 JSON 字符串
    DocumentContext jsonBody = JsonPath.using(conf).parse(jsonString);
    // 添加新字段
    jsonBody.set("$.user[0].age", 30);
    // 删除
    jsonBody.delete("$.user[0].name");
    jsonBody.delete("$..gender");
    // 将更新后的 JSON 转换为字符串
    System.out.println(jsonBody.jsonString()); // 输出: {"user":[{"age":30},{"name":"bob"}]}

}


过滤器：
updateRequestBodyMap.put(String.format('$..[?(@.accountCode==\'%s\')].percentage', ac), 
    ((new BigDecimal(transfer[ac]) * 100) / new BigDecimal(currentAccountValueMapPe[ac])).setScale(2, RoundingMode.HALF_UP))

Optional
-------------
/*
避免显式的 null 检查，从而减少 NullPointerException 的风险

Optional.of(value)  创建一个非空的 Optional，值不能为 null
Optional.ofNullable(value)  创建一个可能为空的 Optional
Optional.empty()    创建一个空的 Optional
*/
Optional<String> name = Optional.of("Alice");

// 1. 判断是否有值
if (name.isPresent()) {
    System.out.println(name.get());
}

// 2. 更推荐的写法
name.ifPresent(System.out::println);

// 3. 提供默认值
String result = name.orElse("Default Name");

// 4. 使用 map 转换值
Optional<Integer> length = name.map(String::length);

// 5. 过滤值
Optional<String> filtered = name.filter(n -> n.startsWith("A"));

// 包装类型
// -----------------
/*
Java的数据类型分两种：
基本类型：byte，short，int，long，boolean，float，double，char
引用类型：所有class和interface类型

// 基本类型 转为 引用类型
boolean <------> java.lang.Boolean  //加上java.lang.xx
int     <------> java.lang.Integer  //加上java.lang.xx


Number类是java.lang包下的一个抽象类，提供了将包装类型拆箱成基本类型的方法，
所有基本类型（数据类型）的包装类型都继承了该抽象类，并且是final声明不可继承改变
https://blog.csdn.net/yaomingyang/article/details/79297750

1. 把int变为Integer的赋值写法，称为自动装箱(Auto Boxing)，反过来称为自动拆箱(Auto Unboxing).
2. 自动拆箱执行时可能会报NullPointerException, 这是因为引用类型可以赋值为null，表示空，但基本类型不能赋值为null：
public class Main {
    public static void main(String[] args) {
        Integer n = null;
        int i = n;
    }
}
3. 所有的包装类型都是不变类。
// 下面为Integer的源码，一旦创建了Integer对象，该对象就是不变的。
// 比较用equals(),不用==
public final class Integer {
    private final int value;
}

4. 创建Integer的方法：
方法1：Integer n = new Integer(100);
方法2：Integer n = Integer.valueOf(100); // Integer.valueOf()可能始终返回同一个Integer
Integer n3 = Integer.valueOf("100"); // 参数还可以是String类型

// 把能创建“新”对象的静态方法称为静态工厂方法。
// Integer.valueOf()就是静态工厂方法，相当于类方法，它尽可能地返回缓存的实例以节省内存。


5.自动装箱和自动拆箱都是在编译期完成的（JDK>=1.5）
Java编译器可以帮助我们自动在int和Integer之间转型：
Integer n = 100; // 编译器自动使用Integer.valueOf(int)
int x = n; // 编译器自动使用Integer.intValue()


6.整数和浮点数的包装类型都继承自Number，包装类型提供了大量实用方法。

7.在Java中，并没有无符号整型（Unsigned）的基本数据类型
需要借助包装类型的静态方法完成转换。

可以把一个byte转换为无符号的int, short按unsigned转换为int，把一个int按unsigned转换为long。

byte x = -1;
byte y = 127;
System.out.println(Byte.toUnsignedInt(x)); // 255
System.out.println(Byte.toUnsignedInt(y)); // 127

对比:python的基本数据类型也就是类，而java需要装箱操作

*/

// 进制转换
int x1 = Integer.parseInt("100"); // 100 , 字符串拆成一个整数
int x2 = Integer.parseInt("100", 16); // 256,因为按16进制解析

// 整数格式化为字符串
System.out.println(Integer.toString(100)); // "100",表示为10进制
System.out.println(Integer.toString(100, 36)); // "2s",表示为36进制
System.out.println(Integer.toHexString(100)); // "64",表示为16进制
System.out.println(Integer.toOctalString(100)); // "144",表示为8进制
System.out.println(Integer.toBinaryString(100)); // "1100100",表示为2进制



JavaBean
------------
/*
读写方法符合get,set的class,称为JavaBean
只有setter,称为只读属性
只有getter,称为只写属性


通过IDE，可以快速生成getter和setter。例如，在Eclipse中，先输入以下代码：
public class Person {
    private String name;
    private int age;
}
右键，在弹出的菜单中选择“Source”，“Generate Getters and Setters”


使用Introspector.getBeanInfo()可以获取一个JavaBean属性列表
*/



枚举
---------

// https://www.jianshu.com/p/40faefffc1a1

/*
enum定义的类型就是class，只不过它有以下几个特点：

定义的enum类型总是继承自java.lang.Enum，且无法被继承；
只能定义出enum的实例，而无法通过new操作符创建enum的实例；
定义的每个实例都是引用类型的唯一实例；
可以将enum类型用于switch语句。
比较enum智能用equals,不能用==，因为是引用类型
*/

class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
   FreshJuiceSize size;
}
 
public class FreshJuiceTest {
   public static void main(String []args){
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM;  //取值的方式跟swift一样
   }
}

// enum是一个class，每个枚举的值都是class实例，因此，这些实例有一些方法：
Weekday.SUN.name()  // "SUN",枚举的原型值
//.name()和.toString()输出的结果是一样的，但.toString()可以被覆写，输出可以自定义，.name()则不行

Weekday.MON.ordinal(); // 1，枚举的下标，从0开始


// 为了代码的健壮性，可以定义构造方法给每个枚举值添加字段：
public class Main {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN; // 赋值的时候，还是一样
        if (day.dayValue == 6 || day.dayValue == 0) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}

enum Weekday {
    MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    public final int dayValue;

    private Weekday(int dayValue) {
        this.dayValue = dayValue;
    }
}


// 定义人物类型
enum FigureType {
    S(4, "Pregnant"), P(3,"Patient"), E(2,"Elder"), C(1,"Child"), N(0,"Normal");

    public final int typeValue;
    public final String sign;
    FigureType(int typeValue, String sign){
        this.typeValue = typeValue;
        this.sign = sign;
    }
}


Record:
---------
/*
从Java 14开始，提供新的record关键字，可以非常方便地定义Data Class：
使用record定义的是不变类；
可以编写Compact Constructor对参数进行验证；
可以定义静态方法。
*/
public class Main {
    public static void main(String[] args) {
        Point p = new Point(123, 456);
        System.out.println(p.x());
        System.out.println(p.y());
        System.out.println(p);
    }
}
public record Point(int x, int y) {}



异常处理
----------
try{
    ....
}catch(Exception e){
    ....
}


注解：
-------
/*
@Override：让编译器检查该方法是否正确地实现了覆写；
@SuppressWarnings：告诉编译器忽略此处代码产生的警告。
一个配置了@PostConstruct的方法会在调用构造方法后自动被调用


注解分为三类：
第一类是由编译器使用的注解，例如：
@Override：让编译器检查该方法是否正确地实现了覆写；
@SuppressWarnings：告诉编译器忽略此处代码产生的警告。
这类注解不会被编译进入.class文件，它们在编译后就被编译器扔掉了。

第二类是由工具处理.class文件使用的注解，比如有些工具会在加载class的时候，对class做动态修改，实现一些特殊的功能。这类注解会被编译进入.class文件，但加载结束后并不会存在于内存中。这类注解只被一些底层库使用，一般我们不必自己处理。

第三类是在程序运行期能够读取的注解，它们在加载后一直存在于JVM中，这也是最常用的注解。例如，一个配置了@PostConstruct的方法会在调用构造方法后自动被调用（这是Java代码读取该注解实现的功能，JVM并不会识别该注解）。


*/

// this is a component:
@Resource("hello")
public class Hello {
    @Inject
    int n;

    @PostConstruct
    public void hello(@Param String name) {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Hello";
    }
}

/*
定义一个注解时，还可以定义配置参数。配置参数可以包括：

所有基本类型；
String；
枚举类型；
基本类型、String、Class以及枚举的数组。
因为配置参数必须是常量，所以，上述限制保证了注解在定义时就已经确定了每个参数的值。

注解的配置参数可以有默认值，缺少某个配置参数时将使用默认值。

此外，大部分注解会有一个名为value的配置参数，对此参数赋值，可以只写常量，相当于省略了value参数。

如果只写注解，相当于全部使用默认值。
*/
public class Hello {
    @Check(min=0, max=100, value=55)
    public int n;

    @Check(value=99)
    public int p;

    @Check(99) // @Check(value=99)
    public int x;

    @Check
    public int y;
}


lambda:
---------
/*
Arrays.sort(array, (s1, s2) -> s1.compareTo(s2));
我们把只定义了单方法的接口称之为FunctionalInterface，用注解@FunctionalInterface标记
接收FunctionalInterface作为参数的时候，可以把实例化的匿名类改写为Lambda表达式，能大大简化代码。
*/


// String::compareTo
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "Banana", "Lemon" };
        Arrays.sort(array, String::compareTo);
        System.out.println(String.join(", ", array));
    }
}

package com.tcp;
/*
 * List<String>转为List<Person>
 * Person::new
 * */
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Bob", "Alice", "Tim");
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }
}

class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}



// java8 Stream
// -------------

import java.util.Arrays;
import java.util.List;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.Random;

/*
* stream()
* ----------
* forEach
* map
* reduce
* filter
* limit
* sorted
* Collectors
* distinct
* collect
* */
public class Main {
    public static void main(String[] args) {

        /**
        * .stream()
         *
         * .filter()
         * .isEmpty()
         * .collect(Collectors.toList())
         * import java.util.Arrays;
         * import java.util.List;
         * import java.util.stream.Collectors;
        * */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        /**
         * .parallelStream()
         *
         * .filter()
         * .isEmpty()
         * import java.util.Arrays;
         * import java.util.List;
         * */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd"," ", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);


        /**
        * .forEach()
         * .limt()
         *
         *  import java.util.Random;
        * */
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println); //用系统函数使用::

        /**
        * .map()
         *
         * .distinct()
         * .collect()
         * import java.util.Arrays;
         * import java.util.List;
         * import java.util.stream.Collectors;
        * */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).collect(Collectors.toList());
        System.out.println(squaresList);


        /**
        * reduce()
         *
         * orElse()
        * */
        List<Integer> list = Arrays.asList(2, 4, 6 ,7);
        // int sum = list.stream().reduce(Integer::sum).orElse(0); // orElse()这儿相当于是个可选项
        int sum = list.stream().reduce((i, j) -> (i*10 + j)).orElse(0);
        System.out.println(sum);


        /**
        * filter()
         *
         * .isBlank()
         * .count()
         * import java.util.Arrays;
         * import java.util.List;
        * */
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd"," ", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isBlank()).count();
        System.out.println(count);


        /**
         * 统计
         *
         * import java.util.Arrays;
         * import java.util.List;
         * import java.util.IntSummaryStatistics;
         */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


        /**
         * Collectors
         *
         * import java.util.Arrays;
         * import java.util.List;
         * import java.util.stream.Collectors;
         * */
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


    }
}


// Stream.of()
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        // forEach()方法相当于内部循环调用，
        stream.forEach(System.out::println);
    }
}

// List.stream()
// 把数组变成Stream使用Arrays.stream()方法。对于Collection（List、Set、Queue等），直接调用stream()方法就可以获得Stream。
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class Main {
    public static void main(String[] args) {
        Stream<String> stream1 = Arrays.stream(new String[] { "A", "B", "C" });
        Stream<String> stream2 = List.of("X", "Y", "Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }
}


// BigInteger和BigDecimal
// BigInteger常用方法
add(BigInteger val)
subtract(BigInteger val)
multiply(BigInteger val)
divide(BigInteger val)
mod(BigInteger val)
pow(int exponent)
gcd(BigInteger val)

// BigDecimal常用方法
add(BigDecimal val)
subtract(BigDecimal val)
multiply(BigDecimal val)
divide(BigDecimal val, int scale, RoundingMode roundingMode)
setScale(int newScale, RoundingMode roundingMode)
compareTo(BigDecimal val)

public static void main(String[] args) {
    BigDecimal num1 = new BigDecimal("10.25");
    BigDecimal num2 = new BigDecimal(100);
    BigDecimal num3 = BigDecimal.valueOf(-5.7583456);
    System.out.println(num1);
    System.out.println(num2);
    System.out.println(num3);
    System.out.println(num1.add(num2).add(num3));
    System.out.println(num3.setScale(2, RoundingMode.FLOOR));
    testBigIntegerExample();
    testBigDecimalExample();
}

public static void testBigIntegerExample() {
    BigInteger a = new BigInteger("12345678901234567890");
    BigInteger b = new BigInteger("98765432109876543210");
    // 加法
    System.out.println("加法: " + a.add(b));
    // 减法
    System.out.println("减法: " + b.subtract(a));
    // 乘法
    System.out.println("乘法: " + a.multiply(b));
    // 除法
    System.out.println("除法: " + b.divide(a));
    // 取模
    System.out.println("模: " + b.mod(a));
    // 幂运算
    System.out.println("幂: " + a.pow(2));
    // 最大公约数
    System.out.println("GCD: " + a.gcd(b));
}

public static void testBigDecimalExample() {
    BigDecimal x = new BigDecimal("19.3455699");
    BigDecimal y = new BigDecimal("3");
    // 加法
    System.out.println("加法: " + x.add(y));
    // 减法
    System.out.println("减法: " + x.subtract(y));
    // 乘法
    System.out.println("乘法: " + x.multiply(y));
    // 除法（保留2位小数，四舍五入）
    System.out.println("除法: " + x.divide(y, 2, RoundingMode.HALF_UP));
    // 设置小数位数
    System.out.println("设置小数位数: " + x.setScale(3, RoundingMode.FLOOR));
    // 比较大小
    int result = x.compareTo(y);
    System.out.println("比较: " + (result > 0 ? "x > y" : result < 0 ? "x < y" : "x = y"));
}

/*
Math类：
-------
StrictMath保证所有平台计算结果都是完全相同的，而Math会尽量针对平台优化计算速度，所以，绝大多数情况下，使用Math就足够了。

求绝对值：
Math.abs(-100); // 100
Math.abs(-7.8); // 7.8

取最大或最小值：
Math.max(100, 99); // 100
Math.min(1.2, 2.3); // 1.2

计算xy次方：
Math.pow(2, 10); // 2的10次方=1024

计算√x：
Math.sqrt(2); // 1.414...

计算ex次方：
Math.exp(2); // 7.389...

计算以e为底的对数：
Math.log(4); // 1.386...

计算以10为底的对数：
Math.log10(100); // 2

三角函数：
Math.sin(3.14); // 0.00159...
Math.cos(3.14); // -0.9999...
Math.tan(3.14); // -0.0015...
Math.asin(1.0); // 1.57079...
Math.acos(1.0); // 0.0

Math还提供了几个数学常量：
double pi = Math.PI; // 3.14159...
double e = Math.E; // 2.7182818...
Math.sin(Math.PI / 6); // sin(π/6) = 0.5

生成一个随机数x，x的范围是0 <= x < 1：
Math.random(); // 0.53907... 每次都不一样
*/


// Random类：
// ----------
// 生成伪随机数

public boolean nextBoolean() // true, false各50%概率
public double nextDouble() // 数值介于[0,1.0)之间
public int nextInt() // 该值介于int的区间，也就是-231到231-1之间
public int nextInt(int n) // 该值介于[0,n)的区间
public void setSeed(long seed)  // 跟new Random(long seed)一致，设定seed值后，生成的随机数是一个定值


// SecureRandom类：
// ---------------
// 必须使用SecureRandom来产生安全的随机数。
System.out.println(new SecureRandom().nextInt(10)); //随机[0,10)以内的整数


// SecureRandom sr = new SecureRandom();
// System.out.println(sr.nextInt(100));

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SecureRandom sr = null;
        try {
            sr = SecureRandom.getInstanceStrong(); // 获取高强度安全随机数生成器
        } catch (NoSuchAlgorithmException e) {
            sr = new SecureRandom(); // 获取普通的安全随机数生成器
        }
        byte[] buffer = new byte[16];
        sr.nextBytes(buffer); // 用安全随机数填充buffer
        System.out.println(Arrays.toString(buffer));
    }
}


集合
----------
/*
Java的java.util包主要提供了以下三种类型的集合：

List：一种有序列表的集合，例如，按索引排列的Student的List；实现类有ArrayList，LinkedList等;
Set：一种保证没有重复元素的集合，例如，所有无重复名称的Student的Set；
Map：一种通过键值（key-value）查找的映射表集合，例如，根据Student的name查找对应Student的Map。


集合实现类
主要分为3种类型:
List: 有序列表的集合，有ArrayList, LinkedList
Set: 没有重复数据的集合，无序：HashSet, EnumSet, LinkedHashSet 有序：TreeSet
Map: key-value的集合，有：EnumMap, HashMap, LinkedHashMap, TreeMap


java集合使用统一的Iterator遍历，尽量不要使用遗留接口。不应该继续使用：
Enumeration<E>：已被Iterator<E>取代。
Hashtable：一种线程安全的Map实现；
Vector：一种线程安全的List实现；
Stack：基于Vector实现的LIFO的栈。


Iterator<Integer> iterator = list.iterator();
start != iterator.next().intValue();

// https://www.cnblogs.com/hadoop-dev/p/6255466.html

// Map的iterator:
public static String toJsonString(Map<String, String> map) {
    Iterator<Map.Entry<String, String>> i = map.entrySet().iterator();
    if (!i.hasNext())
        return "{}";
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    for (; ; ) {
        Map.Entry<String, String> e = i.next();
        Object key = e.getKey();
        Object value = e.getValue();
        sb.append("\t\"").append(key).append("\"");
        sb.append(" : ");
        sb.append("\"").append(value).append("\"");
        if (!i.hasNext())
            return sb.append("\n}").toString();
        sb.append(",\n").append(' ');
    }
}

*/



/*

List
-------
ArrayList和LinkedList, 通常情况下，我们总是优先使用ArrayList。

list不同于数组,它是数组的再一次封装。



// 创建：
List<String> list = new ArrayList<>(); // 可以修改list,
List<Integer> list = List.of(1, 2, 5); // 不可以修改list, JDK1.8不能这样用，具体哪个版本开始可以这样用？JDK11?


.add(E e)：                 在末尾添加一个元素，返回boolean
.add(int index, E e)：      在指定索引添加一个元素：返回为空
.remove(int index)           删除指定索引的元素：返回删除的元素
.remove(Object e)           删除某个元素：返回boolean
.get(int index)             获取指定索引的元素：
.size()                     获取链表大小（包含元素的个数）：
.contains(object)           返回boolean,是否包含这个元素
.indexOf(object)            返回对应index, 返回-1表示没有找到

List还允许添加null           由List.of建立的list因为只读，无法添加新的元素，这儿只能用new ArrayList<>()；


get(int index)方法只有ArrayList的实现是高效的，换成LinkedList后，索引越大，访问速度越慢;
要始终坚持使用迭代器Iterator来访问List.因为效率较高。
有两个方法： hasNext() next()
*/ 


/*添加*/
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // List.of()这种返回的是一个只读list,这种方式add(),remove()会出错；
        // List<String> list = List.of("apple", "pear", "banana"); 

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("apple");
        list.add(null); // 可以添加null
        list.add(list.get(2));
        
        for (String s : list) {
            System.out.println(s);
        }
    }
}

/*遍历*/
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) { // iterator遍历
            String s = it.next();
            System.out.println(s);
        }
        for (String s : list) {  // foreach遍历，只要实现了Iterable接口的集合类都可以直接用for each循环来遍历，Java编译器本身并不知道如何遍历集合对象，但它会自动把for each循环变成Iterator的调用
            System.out.println(s);
        }
    }
}


/*
list和array互转:

// 转为array
.toArray();
.toArray(list.size());

// 转为list
List.of(array); JDK11之后，返回的是一个只读List
Arrays.asList(array); JDK11之前，返回的List不一定就是ArrayList或者LinkedList，因为List只是一个接口。
*/

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana"); 

        // 方法一：
        Object[] array = list.toArray(); // 这儿取出来为object
        // String array[] = list.toArray(new String[3]);// 这个取出来为string
        
        for (Object s : array) {
            System.out.println(s);
        }
        
        // 方法二：
        /*
        List<Integer> list = List.of(12,34,56);
        Integer[] array = list.toArray(new Integer[list.size()]); //把当前list传入到一个新的数组Integer

        // Integer[] array = list.toArray(Integer[]::new); // 这个是另外一种方法

        // List<Integer> list1 = List.of(array); // array转为list.
       
        for (Integer n : array){
            System.out.println(n);
        }
        */

    }
}

Collections.shuffle(list): 可以打乱一个list顺序



// 判断对象列表中是否包含contains，需要对equals进行重写：
// 如果list.contains()不包含，则返回-1
/*
equals的正确写法：
1.先确定实例“相等”的逻辑，即哪些字段相等，就认为实例相等；
2.用instanceof判断传入的待比较的Object是不是当前类型，如果是，继续比较，否则，返回false；
3.对引用类型用Objects.equals()比较，对基本类型直接用==比较。
*/


Map:
HashMap,LinkedHashMap,EnumMap,TreeMap(实现了接口sortedMap)

/*
 *  HashMap

 * .put(key, value)    // null
 * .remove(key)        // value
 * .get(key)           // value
 * .containsKey(key)   // bool
 * .containsValue(vaule)  // bool
*/


import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("pear", 456);
        map.put("banana", 352);
        System.out.println(map.get("apple")); // 123
        map.put("apple", 789); // 再次放入apple作为key，但value变为789
        System.out.println(map.get("apple")); // 789
        System.out.println(map.remove("apple")); // 789

        // 遍历foreach
        for (String key: map.keySet()){
            System.out.println(key +" = "+ map.get(key));
        }
        // 遍历entrySet
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}


/*
要正确使用HashMap，作为key的类必须正确覆写equals()和hashCode()方法；
一个类如果覆写了equals()，就必须覆写hashCode()，并且覆写规则是：

如果equals()返回true，则hashCode()返回值必须相等；
如果equals()返回false，则hashCode()返回值尽量不要相等。
实现hashCode()方法可以通过Objects.hashCode()辅助方法实现。

*/

/*
编写equals()和hashCode()遵循的原则是：

equals()用到的用于比较的每一个字段，都必须在hashCode()中用于计算；
equals()中没有使用到的字段，绝不可放在hashCode()中计算。
另外注意，对于放入HashMap的value对象，没有任何要求。
*/
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }
}

class Person {
    String firstName;
    String lastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // 对对象的equals进行覆写
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            // 为了避免this.firstName, this.lastName 为null的请况，而使用静态方法Objects.quals()
            return Objects.equals(this.firstName, p.firstName) && Objects.equals(this.lastName, p.lastName) && this.age == p.age;
        }
        return false;
    }

    @Override
    public int hashCode() {
        // 反复使用31*h，这样做的目的是为了尽量把不同的Person实例的hashCode()均匀分布到整个int范围。
        // int h = 0;
        // h = 31 * h + firstName.hashCode();
        // h = 31 * h + lastName.hashCode();
        // h = 31 * h + age;
        // return h;
        // 和实现equals()方法遇到的问题类似，如果firstName或lastName为null，上述代码工作起来就会抛NullPointerException。为了解决这个问题，我们在计算hashCode()的时候，经常借助Objects.hash()
        return Objects.hash(firstName, lastName, age);
        // Objects.hashCode(Object o)方法只接受一个Object参数
        // Objects.hash(Object... values)接受一个可变参数，但是内部调用的是Arrays.hashCode()
    }
}




EnumMap:
----------
// 如果Map的key是enum类型，推荐使用EnumMap，既保证速度，也不浪费空间。
// 使用EnumMap的时候，根据面向抽象编程的原则，应持有Map接口。

Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);// 定义，DayOfWeek是一个枚举类型



TreeMap:
----------
// SortedMap在遍历时严格按照Key的顺序遍历，最常用的实现类是TreeMap；
// 作为SortedMap的Key必须实现Comparable接口，或者传入Comparator；

import java.util.Map;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        // apple, orange, pear
    }
}
// 使用TreeMap时，放入的Key必须实现Comparable接口。String、Integer这些类已经实现了Comparable接口，因此可以直接作为Key使用。作为Value的对象则没有任何要求。
// 如果作为Key的class没有实现Comparable接口，那么，必须在创建TreeMap时同时指定一个自定义排序算法：
// Comparator接口要求实现一个比较方法，它负责比较传入的两个元素a和b，如果a<b，则返回负数，通常是-1，如果a==b，则返回0，如果a>b，则返回正数，通常是1。TreeMap内部根据比较结果对Key进行排序。
// a>b?1:-1

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map.put(new Person("Tom"), 1);
        map.put(new Person("Bob"), 2);
        map.put(new Person("Lily"), 3);
        for (Person key : map.keySet()) {
            System.out.println(key);
        }
        // {Person: Bob}, {Person: Lily}, {Person: Tom}
        System.out.println(map.get(new Person("Bob"))); // 2
    }
}

class Person {
    public String name;
    Person(String name) {
        this.name = name;
    }
    public String toString() { // println会调用toString
        return "{Person: " + name + "}";
    }
}


// TreeMap在比较两个Key是否相等时，依赖Key的compareTo()方法或者Comparator.compare()方法。在两个Key相等时，必须返回0。

import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>(new Comparator<Student>() {
            public int compare(Student p1, Student p2) {
                // 降序排列：
                // if (p1.score == p2.score) {
                //     return 0;
                // }
                // return p1.score > p2.score ? -1 : 1;
                return p2.score - p1.score;
            }
//            public int compare(Student p1, Student p2) {
//                return -Integer.compare(p1.score, p2.score);
//            }
        });
        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        // {Lily: score=99} {Tom: score=77} {Bob: score=66}
        System.out.println(map.get(new Student("Bob", 66))); // 2
    }
}

class Student {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}



// 通过Comparable接口去实现：
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Map<Student, Integer> map = new TreeMap<>();

        map.put(new Student("Tom", 77), 1);
        map.put(new Student("Bob", 66), 2);
        map.put(new Student("Lily", 99), 3);
        for (Student key : map.keySet()) {
            System.out.println(key);
        }
        // {Bob: score=66} {Tom: score=77} {Lily: score=99}
        System.out.println(map.get(new Student("Bob", 66))); // 2
    }
}

// Comparable接口
class Student implements Comparable<Student> {
    public String name;
    public int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        Student p = (Student) o;
        if (this.score == p.score) {
            return 0;
        }
        return this.score < p.score ? -1 : 1;
        // return this.score - p.score;
    }

    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
}



Properties
----------
/*
 * 继承自Hashtable,
 * 但基本不用.get(), .set()方法，些方法的参数签名是Object。
 * 我们调用：
 * .setProperty(key, value)
 * .getProperty(key, defaultValue)
*/


/*
用Properties读取配置文件，一共有三步：

创建Properties实例；
调用load()读取文件；
调用getProperty()获取配置。
*/

// Java默认配置文件以.properties为扩展名，每行以key=value表示，以#课开头的是注释。以下是一个典型的配置文件：

# setting.properties

last_open_file=/data/hello.txt
auto_save_interval=60


// 从文件系统读取这个.properties文件：

String f = "setting.properties";
Properties props = new Properties();
props.load(new java.io.FileInputStream(f));

String interval = props.getProperty("auto_save_interval", "120");


// 也可以从classpath读取.properties文件，因为load(InputStream)方法接收一个InputStream实例，表示一个字节流，它不一定是文件流，也可以是从jar包中读取的资源流：

Properties props = new Properties();
props.load(getClass().getResourceAsStream("/common/setting.properties"));
// 如果有多个.properties文件，可以反复调用load()读取，后读取的key-value会覆盖已读取的key-value：
props.load(new FileInputStream("C:\\conf\\setting.properties"));



// 从内存读取一个字节流
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2020-07-24T12:35:01";
        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
        Properties props = new Properties();
        // load(InputStream)方法接收一个InputStream实例，表示一个字节流，它不一定是文件流，也可以是从jar包中读取的资源流：
        props.load(input);

        System.out.println("course: " + props.getProperty("course"));
        System.out.println("last_open_date: " + props.getProperty("last_open_date"));
        System.out.println("last_open_file: " + props.getProperty("last_open_file"));
        System.out.println("auto_save: " + props.getProperty("auto_save", "60"));
    }
}


// 写入配置文件，写入配置文件使用store()方法：
Properties props = new Properties();
props.setProperty("url", "http://www.liaoxuefeng.com");
props.setProperty("language", "Java");
props.store(new FileOutputStream("C:\\conf\\setting.properties"), "这是写入的properties注释");


编码：
----------
// 早期版本的Java规定.properties文件编码是ASCII编码（ISO8859-1），如果涉及到中文就必须用name=\u4e2d\u6587来表示，非常别扭。从JDK9开始，Java的.properties文件可以使用UTF-8编码了。不过，需要注意的是，由于load(InputStream)默认总是以ASCII编码读取字节流，所以会导致读到乱码。我们需要用另一个重载方法load(Reader)读取：

Properties props = new Properties();
props.load(new FileReader("settings.properties", StandardCharsets.UTF_8));

// InputStream和Reader的区别是一个是字节流，一个是字符流。
// 字符流在内存中已经以char类型表示了，不涉及编码问题。



Set:
------------
// 无序：HashSet, EnumSet, LinkedHashSet 有序：TreeSet

// 放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法

boolean add(E e)              将元素添加进Set<E>：
boolean remove(Object e)      将元素从Set<E>删除：
boolean contains(Object e)    判断是否包含元素：
.size()                       set长度


import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
        Set<String> set = new TreeSet<>();
//        set.add(null); // TreeSet不能传入null
        set.add("cell");
        set.add(String.valueOf(3));
        for (String item:
             set) {
            System.out.println(item);
        }
    }
}

/*
使用TreeSet和使用TreeMap的要求一样，添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。
*/

// 对传入的消息进行去重：
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello!"),
                new Message(2, "发工资了吗？"),
                new Message(2, "发工资了吗？"),
                new Message(3, "去哪吃饭？"),
                new Message(3, "去哪吃饭？"),
                new Message(4, "Bye")
        );
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
    }

    static List<Message> process(List<Message> received) {
        // TODO: 按sequence去除重复消息
//        Set<Message> setMessage = new TreeSet<>();
// //        setMessage.addAll(received);
//        for (Message m : received) {
//            setMessage.add(m);
//        }
        Set<Message> setMessage = new TreeSet<>(received);
        return List.copyOf(setMessage);
    }
}

class Message implements Comparable <Message> {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
    @Override
    public int compareTo(Message o) {
        return this.sequence - o.sequence;
    }
}



// Queue
------------
/*
是一个先进先出队列(FIFO)，可以理解为超市排队

只有两个操作：
把元素添加到队列末尾；
从队列头部取出元素。

int size()：获取队列长度；
boolean add(E)/boolean offer(E)：添加元素到队尾；
E remove()/E poll()：获取队首元素并从队列中删除；
E element()/E peek()：获取队首元素但并不从队列中删除。

避免把null添加到队列,因为poll取不到元素的时候，会返回null

*/


// add()
Queue<String> q = ...
try {
    q.add("Apple");
    System.out.println("添加成功");
} catch(IllegalStateException e) {
    System.out.println("添加失败");
}


// offer()
Queue<String> q = ...
if (q.offer("Apple")) {
    System.out.println("添加成功");
} else {
    System.out.println("添加失败");
}


// remove()
Queue<String> q = ...
try {
    String s = q.remove();
    System.out.println("获取成功");
} catch(IllegalStateException e) {
    System.out.println("获取失败");
}


// poll()
Queue<String> q = ...
String s = q.poll();
if (s != null) {
    System.out.println("获取成功");
} else {
    System.out.println("获取失败");
}



import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // LinkedList既可以当做list,也可以用作Queue,即实现了List接口，又实现了Queue接口
        Queue<String> q = new LinkedList<>();
        // List<String> l = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");
        // 从队列取出元素:
        System.out.println(q.poll()); // apple
        System.out.println(q.poll()); // pear
        System.out.println(q.peek()); // banana, peek()不会删除元素
        System.out.println(q.poll()); // banana
        System.out.println(q.poll()); // null,因为队列是空的
    }
}




// PriorityQueue
------------------
/*

PriorityQueue 调用remove()或poll()方法，返回的总是优先级最高的元素。
放入PriorityQueue的元素，必须实现Comparable接口

*/



/*
银行vip客户优先级大于普通客户
*/
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A10"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // Bob/A10
        System.out.println(q.poll()); // null,因为队列为空
    }
}

// 单独实现Comparator
class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            // return (u1.number.substring(1)).compareTo(u2.number.substring(1));
            return Integer.parseInt(u1.number.substring(1)) - Integer.parseInt(u2.number.substring(1));
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}



// Deque:
----------
/*
Deque接口实际上扩展自Queue：

public interface Deque<E> extends Queue<E> {
    ...
}
实际中应尽量调用子类方法
*/

                           Queue                                Deque
添加元素到队尾         add(E e) / offer(E e)            addLast(E e) / offerLast(E e)
取队首元素并删除       E remove() / E poll()            E removeFirst() / E pollFirst()
取队首元素但不删除     E element() / E peek()            E getFirst() / E peekFirst()
添加元素到队首                 无                        addFirst(E e) / offerFirst(E e)
取队尾元素并删除               无                         E removeLast() / E pollLast()
取队尾元素但不删除              无                        E getLast() / E peekLast()



import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // LinkedList真是一个全能选手，它即是List，又是Queue，还是Deque。
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("A"); // A
        deque.offerLast("B"); // B -> A
        deque.offerFirst("C"); // B -> A -> C
        System.out.println(deque.pollFirst()); // C, 剩下B -> A
        System.out.println(deque.pollLast()); // B
        System.out.println(deque.pollFirst()); // A
        System.out.println(deque.pollFirst()); // null
    }
}



// Stack:
---------
/*
为什么Java的集合类没有单独的Stack接口呢？
因为有个遗留类名字就叫Stack，出于兼容性考虑，所以没办法创建Stack接口，只能用Deque接口来“模拟”一个Stack了。

LIFO:后进先出
Stack只有入栈和出栈的操作：

push(E)：把元素压栈
pop(E)：把栈顶的元素“弹出”
peek(E)：取栈顶元素但不弹出

在Java中，我们用Deque可以实现Stack的功能：
当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，
不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。

push(E)/addFirst(E): 把元素压栈：
pop(E)/removeFirst(): 把栈顶的元素“弹出”：
peek(E)/peekFirst(): 取栈顶元素但不弹出：
*/


// 把一个整数格式化成十六进制：
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> stack = new LinkedList<String>();
//        boolean modFlag = true;
//        while (modFlag) {
//            String s = String.valueOf(n % 16);
//            n = n / 16;
//            List<String> l1 = List.of("10", "11", "12", "13", "14", "15");
//            List<String> l2 = List.of("A", "B", "C", "D", "E", "F");
//            if (n == 0) {
//                modFlag = false;
//            }
//
//            for (int i = 0; i < l1.size(); i++) {
//                if (s.equals(l1.get(i))) {
//                    s = l2.get(i);
//                }
//            }
//            stack.push(s);
//        }
        while (n != 0) {
            String s = Integer.toHexString(n % 16);
            stack.push(s);
            n /= 16;
        }
        System.out.println("Stack = " + stack);
        return String.join("", stack);
    }
}



Collections
------------

// 创建空的集合：
List<Integer> list = Collections.emptyList();
Map<String, Integer> map = Collections.emptyMap();
Set<String> set = Collections.emptySet();

// 创建单集合，不可变，无法添加，删除；
List<Integer> list = Collections.singletonList();
Map<String, Integer> map = Collections.singletonMap();
Set<String> set = Collections.singleton();

// 排序：
 Collections.sort(list); // 会改变list
// 洗牌打乱：
Collections.shuffle(list);


// 封装成不可变List：List<T> unmodifiableList(List<? extends T> list)
// 封装成不可变Set：Set<T> unmodifiableSet(Set<? extends T> set)
// 封装成不可变Map：Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> m)


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        //immutable.add("orange"); // 不可变，会抛UnsupportedOperationException!
        mutable.add("orange"); // 但是可以修改原始的list
        System.out.println(immutable);
        mutable = null;  // 一般创建新的不可变集合后，扔掉原始的集合；
        System.out.println(immutable);
    }
}


// 可以把线程不安全的集合变为线程安全的集合：
// 变为线程安全的List：List<T> synchronizedList(List<T> list)
// 变为线程安全的Set：Set<T> synchronizedSet(Set<T> s)
// 变为线程安全的Map：Map<K,V> synchronizedMap(Map<K,V> m)





IO
--------
/*
InputStream、OutputStream、Reader和Writer都是同步IO的抽象类，
对应的具体实现类，以文件为例，有FileInputStream、FileOutputStream、FileReader和FileWriter。

IO流是一种流式的数据输入/输出模型：
    二进制数据以byte为最小单位在InputStream/OutputStream中单向流动；
    字符数据以char为最小单位在Reader/Writer中单向流动。

Java标准库的java.io包提供了同步IO功能：
    字节流接口,byte为单位：InputStream/OutputStream；
    字符流接口,char为单位：Reader/Writer。
*/



/*
File:
-------
*/

// 路径
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("..");
        System.out.println(f.getPath()); // 返回构造方法传入的路径
        System.out.println(f.getAbsolutePath());   // 返回绝对路径
        System.out.println(f.getCanonicalPath());  // 和绝对路径类似，但是返回的是规范路径。
    }
}


System.out.println(File.separator); // 根据当前平台win还是linux打印"\"或"/"


// 判断
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // File对象既可以表示文件，也可以表示目录, 即使传入的文件或目录不存在，代码也不会出错
        File f1 = new File("C:\\Windows"); // 用\\表示\
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
    }
}

// file对象还有以下操作
boolean canRead()：是否可读；
boolean canWrite()：是否可写；
boolean canExecute()：是否可执行；
long length()：文件字节大小。
// new File(filePath).exists()
// new File(filePath).getName()

// 创建和删除文件：
File file = new File("/path/to/file");
if (file.createNewFile()) {
    // 文件创建成功:
    // TODO:
    if (file.delete()) {
        // 删除文件成功:
    }
}

// 临时文件：
// File对象提供了createTempFile()来创建一个临时文件，以及deleteOnExit()在JVM退出时自动删除该文件。
public class Main {
    public static void main(String[] args) throws IOException {
        File f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
        f.deleteOnExit(); // JVM退出时自动删除
        System.out.println(f.isFile());
        System.out.println(f.getAbsolutePath());
    }
}


// list()和listFiles()列出目录下的文件和子目录名
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Windows");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
        // 仅列出.exe文件
        File[] fs2 = f.listFiles((dir, name) -> { 
            return name.endsWith(".exe"); // 返回true表示接受该文件
        });
//        File[] fs2 = f.listFiles(new FilenameFilter() { // 仅列出.exe文件
//            public boolean accept(File dir, String name) {
//                return name.endsWith(".exe"); // 返回true表示接受该文件
//            }
//        });
        printFiles(fs2);
    }

    static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}


// file表示目录时候，有如下方法：
boolean mkdir()：创建当前File对象表示的目录；
boolean mkdirs()：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
boolean delete()：删除当前File对象表示的目录，当前目录必须为空才能删除成功。




查找大文件：
-------------
import java.io.File;
public static void findMaxFiles() {
    // 指定要检查的目录路径
    String directoryPath = "C:\\Users\\wanhait\\Documents\\regional_uip_automation_test_katalon";
    // 设置文件大小阈值为6MB
    long sizeThreshold = 6 * 1024 * 1024;

    // 创建文件对象
    File directory = new File(directoryPath);
    if (directory.exists() && directory.isDirectory()) {
        // 调用方法查找大文件
        findLargeFiles(directory, sizeThreshold);
    } else {
        System.out.println("指定的路径不是一个有效的目录。");
    }

}

public static void findLargeFiles(File directory, long sizeThreshold) {
    // 获取目录下的所有文件和子目录
    File[] files = directory.listFiles();
    if (files != null) {
        for (File file : files) {
            if (file.isFile()) {
                // 检查文件大小是否超过阈值
                if (file.length() > sizeThreshold) {
                    double fileSizeInMB = file.length() / (1024.0 * 1024.0);
                    System.out.println("大文件路径: " + file.getAbsolutePath() + "，大小: " + String.format("%.2f", fileSizeInMB) + " MB");
                }
            } else if (file.isDirectory()) {
                // 递归检查子目录
                findLargeFiles(file, sizeThreshold);
            }
        }
    }
}


/*
Path:
-------
*/
// Java标准库还提供了一个Path对象，它位于java.nio.file包。Path对象和File对象类似，但操作更加简单
// String name = Path.of(filePath).getFileName().toString()

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println(f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }
}


// InputStream:
// ---------------

// Java 7引入的新的try(resource),
// 原先的try格式：
// try{}finally{}


public void readFile() throws IOException {
    try (InputStream input = new FileInputStream("src/readme.txt")) {
        int n;
        while ((n = input.read()) != -1) {
            System.out.println(n);
        }
    } // 编译器在此自动为我们写入finally并调用close()
}

// 实际上，编译器并不会特别地为InputStream加上自动关闭。编译器只看try(resource = ...)中的对象是否实现了java.lang.AutoCloseable接口，如果实现了，就自动加上finally语句并调用close()方法。InputStream和OutputStream都实现了这个接口，因此，都可以用在try(resource)中。


// 缓冲:
// read()：
// int read(byte[] b)：读取若干字节并填充到byte[]数组，返回读取的字节数
// int read(byte[] b, int off, int len)：指定byte[]数组的偏移量和最大填充数

// ByteArrayInputStream可以在内存中模拟一个InputStream
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data = { 72, 101, 108, 108, 111, 33 };
        try (InputStream input = new ByteArrayInputStream(data)) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println((char)n);
            }
        }
    }
}


// 读取文件，然后拼成一个字符串
public class Main {
    public static void main(String[] args) throws IOException {
        String s;
        try (InputStream input = new FileInputStream("C:\\test\\README.txt")) {
            s = readAsString(input);
        }
        System.out.println(s);
    }

    public static String readAsString(InputStream input) throws IOException {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = input.read()) != -1) {
            sb.append((char) n);
        }
        return sb.toString();
    }
}


/*
Java标准库的java.io.InputStream定义了所有输入流的超类：
FileInputStream实现了文件流输入；
ByteArrayInputStream在内存中模拟一个字节流输入。
总是使用try(resource)来保证InputStream正确关闭。
*/


// OutputStream:
// ---------------

// 每次写入一个字节：
public void writeFile() throws IOException {
    OutputStream output = new FileOutputStream("out/readme.txt");
    output.write(72); // H
    output.write(101); // e
    output.write(108); // l
    output.write(108); // l
    output.write(111); // o
    output.close();
}

// 写入byte[]
// void write(byte[])
public void writeFile() throws IOException {
    OutputStream output = new FileOutputStream("out/readme.txt");
    output.write("Hello".getBytes("UTF-8")); // Hello
    output.close();
}

// 上述需要考虑异常，需要用try(resource)来保证OutputStream在无论是否发生IO错误的时候都能够正确地关闭：
public void writeFile() throws IOException {
    try (OutputStream output = new FileOutputStream("out/readme.txt")) {
        output.write("Hello".getBytes("UTF-8")); // Hello
    } // 编译器在此自动为我们写入finally并调用close()
}


// ByteArrayOutputStream可以在内存中模拟一个OutputStream：
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        byte[] data;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            output.write("Hello ".getBytes("UTF-8"));
            output.write("world!".getBytes("UTF-8"));
            data = output.toByteArray();
        }
        System.out.println(new String(data, "UTF-8"));
    }
}

// 同时读写两个文件：
// 读取input.txt，写入output.txt:
try (InputStream input = new FileInputStream("input.txt");
     OutputStream output = new FileOutputStream("output.txt"))
{
    input.transferTo(output); // transferTo的作用是? 实际测试，这个方法没有把数据传输完，怎么解决？
}


/*
steam和string 互转
https://blog.csdn.net/qq_35240673/article/details/81478787
https://www.cnblogs.com/javajetty/p/10684957.html

String转为inputStream
1.
        InputStream is = new ByteArrayInputStream(str.getBytes());

2.Apache
        InputStream targetStream = IOUtils.toInputStream(str, StandardCharsets.UTF_8.name());


inputStream转为string

1.

            InputStream inputStream = resource.getInputStream();
            byte[] bytes = new byte[0];
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            System.out.println("输出"+bytes );
2.（个人建议这种）

            InputStream inputStream = resource.getInputStream();
            
            StringBuilder sb = new StringBuilder();
            String line;
 
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            String str = sb.toString();
            System.out.println("输出"+str );
3. Apache （方便）
String str = IOUtils.toString(inputStream, "utf-8");

4.
String result = new BufferedReader(new InputStreamReader(inputStream))
.lines().parallel().collect(Collectors.joining(System.lineSeparator()));

5.
ByteArrayOutputStream result = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int length;
while ((length = inputStream.read(buffer)) != -1) {
result.write(buffer, 0, length);
}
String str = result.toString(StandardCharsets.UTF_8.name());
return str;

6.
BufferedInputStream bis = new BufferedInputStream(inputStream);
ByteArrayOutputStream buf = new ByteArrayOutputStream();
int result = bis.read();
while(result != -1) {
buf.write((byte) result);
result = bis.read();
}
String str = buf.toString();
return str;


7.
StringWriter writer = new StringWriter();
IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
String str = writer.toString();


8.
String str = new String(ByteStreams.toByteArray(inputStream));
*/

// InputStream, OutputStream:
// --------------------------
// https://blog.csdn.net/weixin_30878501/article/details/95817518

import java.io.*;

public class ByteOperationFile {
    public static void main(String args[]) throws Exception {
       File f = new File("E:" + File.separator + "Java" + File.separator + "bytetest.txt");
        FileOutputStream out =new FileOutputStream(f);
        String message = "hi, i am a QA !";
        byte[] ms = message.getBytes();
        out.write(ms);
        out.close();

        FileInputStream in =new FileInputStream(f);
        byte b[] = new byte[1024];
        in .read(b);
        in .close();
        System.out.println(new String(b));
    }
}


// BufferedInputStream, bufferedOutputStream:
// -------------------------------------------

/*
bufferedInputStream会比直接用inputstream格式更省时间
计算时间可以用:
long start = System.currentTimeMillis();
long end = System.currentTimeMillis();

复制文件：
String srcPath = "E:\\Java\\music.mp3";
String destPath = "D:\\copymusic.mp3";
copyFile(srcPath,destPath);
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferOperation {
    public static void main(String args[]) throws Exception{
        String srcPath = "E:\\Java\\music.mp3";
        String destPath = "D:\\copymusic.mp3";
        copyFile(srcPath,destPath);
    }
    public static void copyFile(String srcPath ,String destPath) throws Exception{
       FileInputStream fis = new FileInputStream(srcPath);
       FileOutputStream fos =new FileOutputStream(destPath);
       int len = 0;
       long start=System.currentTimeMillis();
       while ((len = fis.read()) != -1){
           fos.write(len);
       }
       long end=System.currentTimeMillis();
       System.out.println("======下面是所用的时间======");
       System.out.println(end-start);
       fis.close();
       fos.close();

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int len = 0;
        long start=System.currentTimeMillis();
        while ((len = bis.read()) != -1){
            bos.write(len);
        }
        long end=System.currentTimeMillis();
        System.out.println("======下面是所用的时间======");
        System.out.println(end-start);
        bis.close();
        bos.close();
    }
}


// 从网络读取url,并save到本地
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class main {
    public static void main(String[] args) throws IOException {
        String folder_path = "/Users/captain/Desktop/iotest/save/";
        File file_folder = new File(folder_path);
        if (!file_folder.exists()) {
            file_folder.mkdirs();
        }
        URL url = new URL("http://www.51gjie.com/Images/image1/lkqixikw.lqs.jpg");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(folder_path + "test.jpg")));
        
        int c;
        byte[] temp = new byte[1024 * 2];
        while ((c = bufferedInputStream.read(temp)) != -1) {
            bufferedOutputStream.write(temp,0, c);
        }
        bufferedOutputStream.close();
        inputStream.close();
    }
}


// FileReader, FileWriter
// ----------------------

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CharacterOperationFile {
    public static void main(String[] args) throws Exception {
        File f = new File("E:" + File.separator + "Java" + File.separator + "charactertest.txt");
        FileWriter out = new FileWriter(f);
        out.write ("My name is zhangsan !!");
        out.close();


        FileReader in = new FileReader(f);
        char[] buf = new char[1024];
        int len = in.read(buf);  //此时的read方法可以读取一个字符或几个字符,len代表实际读取到的字符的个数。
        System.out.println(new String(buf));
        in.close();
    }
}



// Filter模式：
// ------------
/*
FileInputStream：从文件读取数据，是最终数据源；
ServletInputStream：从HTTP请求读取数据，是最终数据源；
Socket.getInputStream()：从TCP连接读取数据，是最终数据源；

InputStream file = new FileInputStream("test.gz");
InputStream buffered = new BufferedInputStream(file);
InputStream gzip = new GZIPInputStream(buffered);

Filter模式可以在运行期动态增加功能（又称Decorator模式）

我们也可以自己叠加多个InputStream子类
*/


// ZipInputStream:
// -----------------
// JarInputStream是从ZipInputStream派生，它增加的主要功能是直接读取jar文件里面的MANIFEST.MF文件。因为本质上jar包就是zip包，只是额外附加了一些固定的描述文件。

// 读取zip
// 一个ZipEntry表示一个压缩文件或目录，如果是压缩文件，我们就用read()方法不断读取，直到返回-1：
try (ZipInputStream zip = new ZipInputStream(new FileInputStream(...))) {
    ZipEntry entry = null;
    while ((entry = zip.getNextEntry()) != null) {
        String name = entry.getName();
        if (!entry.isDirectory()) {
            int n;
            while ((n = zip.read()) != -1) {
                ...
            }
        }
    }
}

// 写入zip
try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(...))) {
    File[] files = ...
    for (File file : files) {
        zip.putNextEntry(new ZipEntry(file.getName()));
        zip.write(getFileDataAsBytes(file));
        zip.closeEntry();
    }
}


// 从路径读取资源properties:
String conf = "C:\\conf\\default.properties";
try (InputStream input = new FileInputStream(conf)) {
    // TODO:
}
// 从classpath读取资源:
// 在classpath中的资源文件，路径总是以／开头
try (InputStream input = getClass().getResourceAsStream("/default.properties")) {
    if (input != null) { // 如果为null表示没有找到
        // TODO:
    }
}

// 如果我们把默认的配置放到jar包中，再从外部文件系统读取一个可选的配置文件，
// 就可以做到既有默认的配置文件，又可以让用户自己修改配置：
Properties props = new Properties();
props.load(inputStreamFromClassPath("/default.properties"));
props.load(inputStreamFromFile("./conf.properties"));



/*
序列化：
------
序列化是指把一个Java对象变成二进制内容，本质上就是一个byte[]数组。

一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口
类似Serializable这样的空接口被称为“标记接口”（Marker Interface）
*/ 

// 把一个Java对象变为byte[]数组，需要使用ObjectOutputStream。它负责把一个Java对象写入一个字节流：
import java.io.*;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
        
    }
}


/*
反序列化:
---------
和ObjectOutputStream相反，ObjectInputStream负责从一个字节流读取Java对象：

readObject()可能抛出的异常有：
ClassNotFoundException：没有找到对应的Class；
InvalidClassException：Class不匹配

为了避免异常：
Java的序列化允许class定义一个特殊的serialVersionUID静态变量，用于标识Java类的序列化id
public class Person implements Serializable {
    private static final long serialVersionUID = 2709425275741743919L;
}

//反序列化,反序列化时，由JVM直接构造出Java对象，不调用构造方法，构造方法内部的代码，在反序列化时根本不可能执行

*/
ByteArrayInputStream bufferin = new ByteArrayInputStream(buffer.toByteArray());

try (ObjectInputStream input = new ObjectInputStream(bufferin)) {
    int n = input.readInt();
    String s = input.readUTF();
    Double d = (Double) input.readObject();
}


///////////////////////////////////////////
package serialize;

import java.io.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // 写入int:
            output.writeInt(12345);
            // 写入String:
            output.writeUTF("Hello");
            // 写入Object:
            output.writeObject(123.456);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));

        ByteArrayInputStream bufferIn = new ByteArrayInputStream(buffer.toByteArray());

        try (ObjectInputStream input = new ObjectInputStream(bufferIn)) {
            int n = input.readInt();
            String s = input.readUTF();
            Double d = (Double) input.readObject();
            System.out.format("n = %d, s = %s, d = %f", n, s, d);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

////////////////////////////////
import java.io.*;

public class Serialize {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person hong = new Person("hong", Gender.female, 24);
        Person ming = new Person("ming", 22);
        Serialize main  = new Serialize();
        main.toFile(hong, "/Users/captain/Desktop/hong");
        main.toFile(ming, "/Users/captain/Desktop/ming");
        Person p1 = (Person) main.fromFile("/Users/captain/Desktop/hong");
        System.out.println(p1);
        Person p2 = (Person) main.fromFile("/Users/captain/Desktop/ming");
        System.out.println(p2);
    }

    public void toFile(Serializable obj, String filepath)throws IOException{
        try(FileOutputStream  fileOutputStream = new FileOutputStream(filepath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(obj);
        }
    }


    public Serializable fromFile(String filepath) throws IOException, ClassNotFoundException{
        try(FileInputStream fileInputStream = new FileInputStream(filepath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Serializable) objectInputStream.readObject();
        }
    }
}



/*
Reader：
*/

// FileReader:
// public int read() throws IOException;
public void readFile() throws IOException {
    // 创建一个FileReader对象:
    try (Reader reader = new FileReader("src/readme.txt", StandardCharsets.UTF_8) {
    // TODO
        for (;;) {
        int n = reader.read(); // 反复调用read()方法，直到返回-1
        if (n == -1) {
            break;
        }
        System.out.println((char)n); // 打印char
        }
    }
}

//public int read(char[] c) throws IOException
public void readFile() throws IOException {
    try (Reader reader = new FileReader("src/readme.txt", StandardCharsets.UTF_8)) {
        char[] buffer = new char[1000];
        int n;
        while ((n = reader.read(buffer)) != -1) {  
        //.read(char[] c)表示： 一次性读取若干字符并填充到char[]数组
        // 返回实际读入的字符个数，最大不超过char[]数组的长度。返回-1表示流结束。
            System.out.println("read " + n + " chars.");
        }
    }
}


/*
CharArrayReader:
CharArrayReader可以在内存中模拟一个Reader，它的作用实际上是把一个char[]数组变成一个Reader，这和ByteArrayInputStream非常类似：
*/
try (Reader reader = new CharArrayReader("Hello".toCharArray())) {
}

/*
StringReader:
StringReader可以直接把String作为数据源，它和CharArrayReader几乎一样：
*/
try (Reader reader = new StringReader("Hello")) {
}


/*
InputStreamReader就是这样一个转换器，它可以把任何InputStream转换为Reader。

// 持有InputStream:
InputStream input = new FileInputStream("src/readme.txt");
// 变换为Reader:
Reader reader = new InputStreamReader(input, "UTF-8");

使用try (resource)结构时，当我们关闭Reader时，它会在内部自动调用InputStream的close()方法，所以，只需要关闭最外层的Reader对象即可。

*/
// 整个过程可以简写成：
try (Reader reader = new InputStreamReader(new FileInputStream("src/readme.txt"), "UTF-8")) {
    // TODO:
}
/*
Reader定义了所有字符输入流的超类：
FileReader实现了文件字符流输入，使用时需要指定编码；
CharArrayReader和StringReader可以在内存中模拟一个字符流输入。
Reader是基于InputStream构造的：可以通过InputStreamReader在指定编码的同时将任何InputStream转换为Reader。
总是使用try (resource)保证Reader正确关闭。
*/



/*
writer

写入一个字符（0~65535）：void write(int c)；
写入字符数组的所有字符：void write(char[] c)；
写入String表示的所有字符：void write(String s)。
*/ 
// FileWriter
try (Writer writer = new FileWriter("readme.txt", StandardCharsets.UTF_8)) {
    writer.write('H'); // 写入单个字符
    writer.write("Hello".toCharArray()); // 写入char[]
    writer.write("Hello"); // 写入String
}

// CharArrayWriter
try (CharArrayWriter writer = new CharArrayWriter()) {
    writer.write(65);
    writer.write(66);
    writer.write(67);
    char[] data = writer.toCharArray(); // { 'A', 'B', 'C' }
}

// StringWriter


// OutputStreamWriter
// OutputStreamWriter就是一个将任意的OutputStream转换为Writer的转换器：

try (Writer writer = new OutputStreamWriter(new FileOutputStream("readme.txt"), "UTF-8")) {
    // TODO:
}

/*
Writer定义了所有字符输出流的超类：
FileWriter实现了文件字符流输出；
CharArrayWriter和StringWriter在内存中模拟一个字符流输出。
使用try (resource)保证Writer正确关闭。
Writer是基于OutputStream构造的，可以通过OutputStreamWriter将OutputStream转换为Writer，转换时需要指定编码。
*/



/*
PrintStream和PrintWriter

PrintStream是一种FilterOutputStream，它在OutputStream的接口上，额外提供了一些写入各种数据类型的方法：

写入int：print(int)
写入boolean：print(boolean)
写入String：print(String)
写入Object：print(Object)，实际上相当于print(object.toString())

System.out.println()实际上就是使用PrintStream打印各种数据, 不会抛出IOException
System.err是系统默认提供的标准错误输出。

PrintStream是一种能接收各种数据类型的输出，打印数据时比较方便：
System.out是标准输出；
System.err是标准错误输出。
PrintWriter是基于Writer的输出。
*/

// PrintWriter:
// -------------
// PrintStream最终输出的总是byte数据，而PrintWriter则是扩展了Writer接口，它的print()/println()方法最终输出的是char数据。两者的使用方法几乎是一模一样的：

import java.io.*;
public class Main {
    public static void main(String[] args)     {
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)) {
            pw.println("Hello");
            pw.println(12345);
            pw.println(true);
        }
        System.out.println(buffer.toString());
    }
}




泛型
--------
/*
泛型就是编写模板代码来适应任意类型；

泛型的好处是使用时不必对类型进行强制转换，它通过编译器对类型进行检查；

注意泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），
但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）。


编写泛型时，需要定义泛型类型<T>；
静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；
泛型可以同时定义多种类型，例如Map<K, V>。

*/

/*
泛型的撰写:

编写泛型时，需要定义泛型类型<T>；
静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法；
泛型可以同时定义多种类型，例如Map<K, V>。
*/

// 先写一个类型
public class Pair {
    private String first;
    private String last;
    public Pair(String first, String last) {
        this.first = first;
        this.last = last;
    }
    public String getFirst() {
        return first;
    }
    public String getLast() {
        return last;
    }
}

// 然后把String替换为T，并在头部声明<T>
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { ... }
    public T getLast() { ... }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}



// 泛型类型<T>不能用于静态方法。必须定义其他类型（例如<K>）来实现静态泛型方法；

// 对于静态方法，我们应该把它改为另一种泛型类型，例如，<K>：
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { ... }
    public T getLast() { ... }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}


// 多个泛型
--------------
public class Pair<T, K> {
    private T first;
    private K last;
    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { ... }
    public K getLast() { ... }
}




// 擦拭法
---------
/*

Java的泛型是采用擦拭法实现的；

擦拭法决定了泛型<T>：

泛型的缺陷：
不能是基本类型，例如：int；
不能获取带泛型类型的Class，例如：c2.getClass = Pair<String>.class；
不能判断带泛型类型的类型，例如：x instanceof Pair<String>；
不能实例化T类型，例如：new T()。
泛型方法要防止重复定义方法，例如：public boolean equals(T obj)；
子类可以获取父类的泛型类型<T>。
*/


extends
----------
/*
使用extends通配符表示可以读，不能写。
使用类似<T extends Number>定义泛型类时表示：
泛型类型限定为Number以及Number的子类。

*/
// 如果我们考察Java标准库的java.util.List<T>接口，它实现的是一个类似“可变数组”的列表，主要功能包括：
public interface List<T> {
    int size(); // 获取个数
    T get(int index); // 根据索引获取指定元素
    void add(T t); // 添加一个新元素
    void remove(T t); // 删除一个已有元素
}
// 现在，让我们定义一个方法来处理列表的每个元素
int sumOfList(List<? extends Integer> list) {
    int sum = 0;
    for (int i=0; i<list.size(); i++) {
        Integer n = list.get(i);
        sum = sum + n;
    }
    return sum;
}


// 注意到List<? extends Integer>的限制：

// 允许调用get()方法获取Integer的引用；
// 不允许调用set(? extends Integer)方法并传入任何Integer的引用（null除外）。


// 在定义泛型类型Pair<T>的时候，也可以使用extends通配符来限定T的类型：

public class Pair<T extends Number> { ... }



super
------
// 使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只能写，不能读。


public class Main {
    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }
}

// super和extend的区别:
-------------------
/*
作为方法参数，<? extends T>类型和<? super T>类型的区别在于：

<? extends T>允许调用读方法T get()获取T的引用，但不允许调用写方法set(T)传入T的引用（传入null除外）；
<? super T>允许调用写方法set(T)传入T的引用，但不允许调用读方法T get()获取T的引用（获取Object除外）。

一个是允许读不允许写，另一个是允许写不允许读。
*/

// Java标准库的Collections类定义的copy()方法：
public class Collections {
    // 把src的每个元素复制到dest中:
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i);
            dest.add(t);
        }
    }
}

// 这个copy()方法的定义就完美地展示了extends和super的意图：
// copy()方法内部不会读取dest，因为不能调用dest.get()来获取T的引用；
// copy()方法内部也不会修改src，因为不能调用src.add(T)。


无限定通配符?
// 既不能读，也不能写，只能做一些null判断：
void sample(Pair<?> p) {
}
Pair<?>是所有Pair<T>的超类：




正则表达式
-----------
String str = "32";
boolean result = str.matches("[\\d]+");


import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main{
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})"); // 分组，要用到小括号
        Matcher matcher = pattern.matcher("010-12345678");
        if (matcher.matches()){
            // 用group之前，必须先matches(),匹配成功后，才能得到字符串
            // group(0)获取全部字符串，group(1)获取分组后的第一个
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }
}


// 默认都是贪婪匹配：
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d+)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "1230000"
            System.out.println("group2=" + matcher.group(2)); // ""
        }
    }
}

// 加一个？即可以非贪婪匹配
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }
    }
}

// 分割字符串
"a b c".split("\\s"); // { "a", "b", "c" }
"a b  c".split("\\s"); // { "a", "b", "", "c" }
"a, b ;; c".split("[\\,\\;\\s]+"); // { "a", "b", "c" }


// 查找正则字符串：
//find()只发现匹配的部分字段
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main{
    public static void main(String[] args) {
        String str = "全部fe8832He8你说";
        Pattern pattern = Pattern.compile("\\d+"); // 分组，要用到小括号
        System.out.println(pattern.pattern());
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(str.substring(matcher.start(), matcher.end()));
            System.out.println(matcher.replaceAll("").trim());
        }
        pattern = Pattern.compile("[^\\d]+");
        matcher = pattern.matcher(str);
        if (matcher.find()){
            System.out.println(matcher.replaceAll("").trim());
        }
    }
}
// \d+
// 8832
// 8832
// 全部feHe你说
// 88328


// 替换：
String s = "A,,B;C ,D";
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D", 不改变s的值




/*
网络编程：
--------------

TCP/IP四层模型：
应用层: 包括应用层，表示层，会话层。应用层提供应用程序之间的通信,会话层：负责建立和维护会话；表示层：处理数据格式，加解密等等；
传输层: 负责提供端到端的可靠传输；
IP层: 又称为网络层，负责根据目标地址选择路由来传输数据；
网络接口层: 包括链路层和物理层，链路层和物理层负责把数据进行分片并且真正通过物理网络传输，例如，无线网、光纤等。


TCP

TCP协议是传输控制协议，它是面向连接的协议，支持可靠传输和双向通信。TCP协议是建立在IP协议之上的，TCP协议是应用最广泛的协议，许多高级协议都是建立在TCP协议之上的，例如HTTP、SMTP等。

UDP协议（User Datagram Protocol）是一种数据报文协议，它是无连接协议，不保证可靠传输。因为UDP协议在通信前不需要建立连接，因此它的传输效率比TCP高，而且UDP协议比TCP协议要简单得多。


*/


/*
一个Socket就是由IP地址和端口号（范围是0～65535）组成，可以把Socket简单理解为IP地址加端口号。
端口号总是由操作系统分配，它是一个0～65535之间的数字，其中，小于1024的端口属于特权端口，需要管理员权限，大于1024的端口可以由任意用户的应用程序打开。

当Socket连接成功地在服务器端和客户端之间建立后：
对服务器端来说，它的Socket是指定的IP地址和指定的端口号；
对客户端来说，它的Socket是它所在计算机的IP地址和一个由操作系统分配的随机端口号。



使用Java进行TCP编程时，需要使用Socket模型：

服务器端用ServerSocket监听指定端口；
客户端使用Socket(InetAddress, port)连接服务器；
服务器端用accept()接收连接并返回Socket；
双方通过Socket打开InputStream/OutputStream读写数据；
服务器端通常使用多线程同时处理多个客户端连接，利用线程池可大幅提升效率；
flush()用于强制输出缓冲区到网络。

*/



/*
TCP编程：
---------
OutputStream outputStream = socket.getOutputStream();
outputStream.write("你好，服务器！".getBytes());

// 读：
InputStream inputStream = socket.getInputStream();
byte[] bytes = new byte[1024];

int len = inputStream.read(bytes);
System.out.println(new String(bytes,0,len));// 读取固定长度

int len = 0;
while((len = inputStream.read(bytes)) != -1) { // 一直读取
    os.write(bytes);
    os.flush();
}

socket.close();


// 写：
OutputStream os = client.getOutputStream();
InputStream in = new FileInputStream("Users/xx/Desktop/hello");
byte[] bytes = new byte[1024];
int len = 0;
while((len = in.read(bytes)) != -1) {
    os.write(bytes);
}
os.close();
in.close();


*/

// server:

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666); // 监听指定端口
        System.out.println("server is running...");
        for (; ; ) {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }
}

class Handler extends Thread {
    Socket sock;

    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream input = this.sock.getInputStream()) {
            try (OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));   
        writer.write("hello\n");
        writer.flush();
        for (; ; ) {
            String s = reader.readLine();
            if (s.equals("bye")) {
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok: " + s + "\n");
            writer.flush();
        }
    }
}



// client:

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost", 6666); // 连接指定服务器和端口
        try (InputStream input = sock.getInputStream()) {
            try (OutputStream output = sock.getOutputStream()) {
                handle(input, output);
            }
        }
        sock.close();
        System.out.println("disconnected.");
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server] " + reader.readLine());
        for (;;) {
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }
}



// UDP编程：
// -------------
/*
当服务器收到一个DatagramPacket后，通常必须立刻回复一个或多个UDP包，因为客户端地址在DatagramPacket中，每次收到的DatagramPacket可能是不同的客户端，如果不回复，客户端就收不到任何UDP包。

如果客户端希望向两个不同的服务器发送UDP包，那么它必须创建两个DatagramSocket实例。
通常来说，客户端必须先发UDP包，因为客户端不发UDP包，服务器端就根本不知道客户端的地址和端口号。

disconnect()也不是真正地断开连接，它只是清除了客户端DatagramSocket实例记录的远程服务器地址和端口号，
这样，DatagramSocket实例就可以连接另一个服务器端。
*/

//server:
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6666); // 监听指定端口
        for (;;) { // 无限循环
            // 数据缓冲区:
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            ds.receive(packet); // 收取一个UDP数据包
            // 收取到的数据存储在buffer中，由packet.getOffset(), packet.getLength()指定起始位置和长度
            // 将其按UTF-8编码转换为String:
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            // 发送数据:
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            ds.send(packet);
        }
    }
}

// client:
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"), 6666); // 连接指定服务器和端口
// 发送:
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length);
        ds.send(packet);
// 接收:
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(), packet.getOffset(), packet.getLength());
        ds.disconnect();
    }
}


// 发送和接受邮件：
// -------------
/*
SMTP协议，它是Simple Mail Transport Protocol的缩写，使用标准端口25，也可以使用加密端口465或587。
SMTP协议是一个建立在TCP之上的协议

QQ邮箱：
接收邮件服务器：imap.qq.com，使用SSL，端口号993
发送邮件服务器：smtp.qq.com，使用SSL，端口号465或587

qq企业邮箱：
接收服务器：imap.exmail.qq.com(使用SSL，端口号993)
发送服务器：smtp.exmail.qq.com(使用SSL，端口号465)

163邮箱：SMTP服务器是smtp.163.com，端口是465；
Gmail邮箱：SMTP服务器是smtp.gmail.com，端口是465/587。


接收邮件使用最广泛的协议是POP3：Post Office Protocol version 3，
它也是一个建立在TCP连接之上的协议。POP3服务器的标准端口是110，如果整个会话需要加密，那么使用加密端口995。


<dependencies>
    <dependency>
        <groupId>javax.mail</groupId>
        <artifactId>javax.mail-api</artifactId>
        <version>1.6.2</version>
    </dependency>
    <dependency>
        <groupId>com.sun.mail</groupId>
        <artifactId>javax.mail</artifactId>
        <version>1.6.2</version>
    </dependency>
    ...

*/

// 发送邮件
package com.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws MessagingException {
        // 服务器地址:
        String smtp = "smtp.exmail.qq.com";
        // 登录用户名:
        final String username = "from@camera360.com";
        // 登录口令:
        final String password = "****";//qq邮箱是口令牌，需要在账户->设置中开启smtp,获取口令牌
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "465"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        // props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        props.put("mail.smtp.ssl.enable", "true"); // ssl
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址:
        message.setFrom(new InternetAddress("from@camera360.com"));
        // 设置接收方地址:
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("xx@qq.com"));
        // 设置邮件主题:
        message.setSubject("Hello", "UTF-8");
        // 设置纯文本邮件正文:
        message.setText("Hi Xiaoming...", "UTF-8");
        // 发送:
        Transport.send(message);
    }
}


/*
发送HTML邮件:
发送HTML邮件和文本邮件是类似的，只需要把：
message.setText(body, "UTF-8");
改为：
message.setText(body, "UTF-8", "html");
传入的body是类似<h1>Hello</h1><p>Hi, xxx</p>这样的HTML字符串即可。


常见问题：
1.如果用户名或口令错误，会导致535登录失败：

DEBUG SMTP: AUTH LOGIN failed
Exception in thread "main" javax.mail.AuthenticationFailedException: 535 5.7.3 Authentication unsuccessful [HK0PR03CA0105.apcprd03.prod.outlook.com]

2.如果登录用户和发件人不一致，会导致554拒绝发送错误：

DEBUG SMTP: MessagingException while sending, THROW: 
com.sun.mail.smtp.SMTPSendFailedException: 554 5.2.0 STOREDRV.Submission.Exception:SendAsDeniedException.MapiExceptionSendAsDenied;

3.有些时候，如果邮件主题和正文过于简单，会导致554被识别为垃圾邮件的错误：

DEBUG SMTP: MessagingException while sending, THROW: 
com.sun.mail.smtp.SMTPSendFailedException: 554 DT:SPM
*/

package com.email;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Email {
    public static void main(String[] args) throws MessagingException {
        // 服务器地址:
        String smtp = "smtp.exmail.qq.com";
        // 登录用户名:
        final String username = "from@camera360.com";
        // 登录口令:
        final String password = "*****";//qq邮箱是口令牌，需要在账户->设置中开启smtp,获取口令牌
        // 连接到SMTP服务器587端口:
        Properties props = new Properties();
        props.put("mail.smtp.host", smtp); // SMTP主机名
        props.put("mail.smtp.port", "465"); // 主机端口号
        props.put("mail.smtp.auth", "true"); // 是否需要用户认证
        // props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
        props.put("mail.smtp.ssl.enable", "true"); // ssl
        // 获取Session实例:
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        // 设置debug模式便于调试:
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);
        // 设置发送方地址:
        message.setFrom(new InternetAddress("from@camera360.com"));
        /**
        * 设置接收方地址:set,add方法都有添加单个，数组的方法
         * message.setRecipient(Message.RecipientType.TO, new InternetAddress("578628438@qq.com"));
         * 多个地址添加数组
         * message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("508628438@qq.com")});
         *
         * Message.RecipientType.TO是主送人，Message.RecipientType.CC抄送，BCC是密送
        * */
        String recipientUserString = "a@camera360.com,b@camera360.com";
        if (recipientUserString !=null && !recipientUserString.isEmpty()){
            InternetAddress[] addresses = new InternetAddress().parse(recipientUserString);
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setRecipients(Message.RecipientType.CC, "from@camera360.com");
        }
        // 设置邮件主题:
        message.setSubject("HomeWork: Email from a robot", "UTF-8");
        // 设置邮件纯文本的时候:
        // message.setText("Hi Xiaoming...", "UTF-8");

        // 一个multipart可以添加多个BodyPart
        Multipart multipart = new MimeMultipart();

        /*添加正文文本: */
        BodyPart textPart = new MimeBodyPart();
        String body = "<h3 align ='left'>Hi, buddy:<br>I'm a email robot!</h3>";
        textPart.setContent(body, "text/html;charset=utf-8");// 设置为网页格式:
        // textPart.setContent(body, "text/plain;charset=utf-8");// 设置为文字格式:
        multipart.addBodyPart(textPart);

        /*添加内嵌网页：*/
        // html text:
        BodyPart emTextPart = new MimeBodyPart();
        // 需要对图
        emTextPart.setContent("<h4>给你看个老照片：</h4><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
        multipart.addBodyPart(emTextPart);
        // html image:
        BodyPart emImagePart = new MimeBodyPart();
        emImagePart.setFileName("1.jpg");
        try(InputStream input = new FileInputStream("/Users/captain/Desktop/old.jpg")){
            emImagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "image/jpeg")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 设置header, 与HTML的<img src="cid:img01">关联:
        emImagePart.setHeader("Content-ID", "<img01>");
        // emImagePart.setContentID("img01");
        // emImagePart.setHeader("Content-ID", "img01");
        multipart.addBodyPart(emImagePart);

        /*添加image附件: */
        BodyPart imagePart = new MimeBodyPart();
        imagePart.setFileName("vivo.gif");// 文件名和真实名字可以不一致
        /*
        如果添加附件，需要设置文件名，并且添加一个DataHandler()，传入文件的MIME类型。
        二进制文件可以用application/octet-stream，Word文档则是application/msword
        */
        try (InputStream input = new FileInputStream("/Users/captain/Desktop/vivo.gif")){
            imagePart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
            multipart.addBodyPart(imagePart);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 设置邮件内容为multipart:
        message.setContent(multipart);
        // 发送:
        Transport.send(message);
    }
}




// Http编程：
// -------------

/*

Host：表示请求的域名，因为一台服务器上可能有多个网站，因此有必要依靠Host来识别用于请求；
User-Agent：表示客户端自身标识信息，不同的浏览器有不同的标识，服务器依靠User-Agent判断客户端类型；
Accept：表示客户端能处理的HTTP响应格式，*/*表示任意格式，text/*表示任意文本，image/png表示PNG格式的图片；
Accept-Language：表示客户端接收的语言，多种语言按优先级排序，服务器依靠该字段给用户返回特定语言的网页版本。

GET请求的参数必须附加在URL上，并以URLEncode方式编码，例如：http://www.example.com/?a=1&b=K%26R，参数分别是a=1和b=K&R。
因为URL的长度限制，GET请求的参数不能太多，而POST请求的参数就没有长度限制，因为POST请求的参数必须放到Body中。
并且，POST请求的参数不一定是URL编码，可以按任意格式编码，只需要在Content-Type中正确设置即可。


Content-Type:
text/plain;
application/json
application/x-www-form-urlencoded
text/html
image/jpeg


早期的HTTP/1.0协议，每次发送一个HTTP请求，客户端都需要先创建一个新的TCP连接，然后，收到服务器响应后，关闭这个TCP连接。
由于建立TCP连接就比较耗时，因此，为了提高效率，HTTP/1.1协议允许在一个TCP连接中反复发送-响应，这样就能大大提高效率：

HTTP/2.0允许客户端在没有收到响应的时候，发送多个HTTP请求，服务器返回响应的时候，不一定按顺序返回，
只要双方能识别出哪个响应对应哪个请求，就可以做到并行发送和接收：
*/

// java http请求的三种方式：
// https://www.cnblogs.com/hhhshct/p/8523697.html

//标准库访问http:(比较繁琐，弃用)
URL url = new URL("http://www.example.com/path/to/target?a=1&b=2");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("GET");
conn.setUseCaches(false);
conn.setConnectTimeout(5000); // 请求超时5秒
// 设置HTTP头:
conn.setRequestProperty("Accept", "*/*");
conn.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 11; Windows NT 5.1)");
// 连接并发送HTTP请求:
conn.connect();
// 判断HTTP响应是否200:
if (conn.getResponseCode() != 200) {
    throw new RuntimeException("bad response");
}       
// 获取所有响应Header:
Map<String, List<String>> map = conn.getHeaderFields();
for (String key : map.keySet()) {
    System.out.println(key + ": " + map.get(key));
}
// 获取响应内容:
InputStream input = conn.getInputStream();
...


// JDK11后,引入了新的HttpClient，支持链式：
// https://openjdk.java.net/groups/net/httpclient/intro.html
// get()
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.*;

public class Main {
    // 全局HttpClient:
    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        String url = "https://www.sina.com.cn/";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置Header:
                .header("User-Agent", "Java HttpClient").header("Accept", "*/*")
                // 设置超时:
                .timeout(Duration.ofSeconds(5))
                // 设置版本:
                .version(Version.HTTP_2).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        // HTTP允许重复的Header，因此一个Header可对应多个Value:
        Map<String, List<String>> headers = response.headers().map();
        for (String header : headers.keySet()) {
            System.out.println(header + ": " + headers.get(header).get(0));
        }
        System.out.println(response.body().substring(0, 1024) + "...");
    }
}

/*
如果我们要获取图片这样的二进制内容，只需要把HttpResponse.BodyHandlers.ofString()换成HttpResponse.BodyHandlers.ofByteArray()，就可以获得一个HttpResponse<byte[]>对象。
如果响应的内容很大，不希望一次性全部加载到内存，可以使用HttpResponse.BodyHandlers.ofInputStream()获取一个InputStream流。
*/


// post()

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Main {
    // 全局HttpClient:
    static HttpClient httpClient = HttpClient.newBuilder().build();

    public static void main(String[] args) throws Exception {
        String url = "http://www.example.com/login";
        String body = "username=bob&password=123456";
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                // 设置Header:
                .header("Accept", "*/*")
                .header("Content-Type", "application/x-www-form-urlencoded")
                // 设置超时:
                .timeout(Duration.ofSeconds(5))
                // 设置版本:
                .version(HttpClient.Version.HTTP_2)
                // 使用POST并设置Body:
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String s = response.body();
        System.out.println(s);
    }
}






/*
RMI:
-----
远程调用 Remote Method Invocation
*/





// 编码和加密：

/*

URL编码
https://www.baidu.com/s?wd=%E4%B8%AD%E6%96%87

URL编码有一套规则：

如果字符是A~Z，a~z，0~9以及-、_、.、*，则保持不变；
如果是其他字符，先转换为UTF-8编码，然后对每个字节以%XX表示。

例如：字符 中 的UTF-8编码是0xe4b8ad，因此，它的URL编码是%E4%B8%AD。URL编码总是大写。

和标准的URL编码稍有不同，URLEncoder把空格字符编码成+，而现在的URL编码标准要求空格被编码为%20，不过，服务器都可以处理这两种情况。

URL编码是编码算法，不是加密算法。URL编码的目的是把任意文本数据编码为%前缀表示的文本，

编码后的文本仅包含A~Z，a~z，0~9，-，_，.，*和%，便于浏览器和服务器处理。
*/

//urlencode
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
public class Main {
    public static void main(String[] args) {
        String encoded = URLEncoder.encode("中文!", StandardCharsets.UTF_8);
        System.out.println(encoded);
    }
}

//urldecode
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
public class Main {
    public static void main(String[] args) {
        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87%21", StandardCharsets.UTF_8);
        System.out.println(decoded);
    }
}


/*
Base64编码:
URL编码是对字符进行编码，表示成%xx的形式，而Base64编码是对二进制数据进行编码，表示成文本格式。

这样在很多文本中就可以处理二进制数据。例如，电子邮件协议就是文本协议，如果要在电子邮件中添加一个二进制文件，就可以用Base64编码，然后以文本的形式传送。

Base64编码可以把任意长度的二进制数据变为纯文本，且只包含A~Z、a~z、0~9、+、/、=这些字符。它的原理是把3字节的二进制数据按6bit一组，用4个int整数表示，然后查表，把int整数用索引对应到字符，得到编码后的字符串。

缺点：Base64编码的缺点是传输效率会降低，因为它把原始数据的长度增加了1/3。
和URL编码一样，Base64编码是一种编码算法，不是加密算法。

举个例子：3个byte数据分别是e4、b8、ad，按6bit分组得到39、0b、22和2d：
*/


//encode
import java.util.Base64;
public class Main {
    public static void main(String[] args) {
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input); // 5Lit
        System.out.println(b64encoded);
    }
}

//decode
import java.util.Arrays;
import java.util.Base64;
public class Main {
    public static void main(String[] args) {
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output)); // [-28, -72, -83]
    }
}

// 如果输入的byte[]数组长度不是3的整数倍肿么办？这种情况下，需要对输入的末尾补一个或两个0x00，编码后，在结尾加一个=表示补充了1个0x00，加两个=表示补充了2个0x00，解码的时候，去掉末尾补充的一个或两个0x00即可。

// 实际上，因为编码后的长度加上=总是4的倍数，所以即使不加=也可以计算出原始输入的byte[]。Base64编码的时候可以用withoutPadding()去掉=，解码出来的结果是一样的：

// 非3的倍数encode:
import java.util.Arrays;
import java.util.Base64;
public class Main {
    public static void main(String[] args) {
        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, (byte)0x21 };
        String b64encoded = Base64.getEncoder().encodeToString(input); // 5LitIQ==
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);// 5LitIQ
        System.out.println(b64encoded);
        System.out.println(b64encoded2);
        byte[] output = Base64.getDecoder().decode(b64encoded2);// [-28, -72, -83, 33]
        System.out.println(Arrays.toString(output));
    }
}


// 因为标准的Base64编码会出现+、/和=，所以不适合把Base64编码后的字符串放到URL中。
// 一种针对URL的Base64编码可以在URL中使用的Base64编码，它仅仅是把+变成-，/变成_

//base64.urlencode()
import java.util.Arrays;
import java.util.Base64;
public class Main {
    public static void main(String[] args) {
        byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        String encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded); // AQJ_AA==
        System.out.println(encoded);  // AQJ/AA==
        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output)); // [1, 2, 127, 0]
    }
}


/*
// 哈希算法：
哈希算法        输出长度(bit)       输出长度(字节)
MD5             128 bit             16 bytes
RipeMD160       160 bits            20 bytes
SHA-1           160 bits            20 bytes  
SHA-256         256 bits            32 bytes
SHA-512         512 bits            64 bytes

SHA-1是由美国国家安全局开发的，SHA算法实际上是一个系列,SHA-0已经弃用

比特币使用的哈希算法有两种：SHA-256和RipeMD160
根据碰撞概率，哈希算法的输出长度越长，就越难产生碰撞，也就越安全。

使用哈希口令时，还要注意防止彩虹表攻击。
什么是彩虹表呢？拿到MD5，按照预先计算好的常用口令和它们的MD5的对照表，从MD5反推明文口令。

我们也可以采取措施来抵御彩虹表攻击，方法是对每个口令额外添加随机数，这个方法称之为加盐（salt）：
digest = md5(salt+inputPassword)
*/

// MD5
import java.math.BigInteger;
import java.security.MessageDigest;
public class Main {
    public static void main(String[] args) throws Exception {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        //当输入结束后，调用digest()方法获得byte[]数组表示的摘要
        byte[] result = md.digest();
        // 转换为16进制的字符串 // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));
    }


    // 另外一种通过byte[]生成16进制数的方法：
    // https://www.cnblogs.com/think-in-java/p/5527389.html
    // https://www.cnblogs.com/zktww/p/10388098.html
    byte[] dataMD5Byte = md.digest();

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i<dataMD5Byte.length; i++){
        int c = dataMD5Byte[i] & 0xFF;  // 等同于 unsigned int c = dataMD5Byte[i];因为java天生没有 unsigned
        String e = Integer.toHexString(c);
        // 通过length，或者数字大小来判断
        // if (e.length() < 2){
        //     builder.append(0);
        // }
        if (c < 16){
            builder.append(0);
        }
        builder.append(e);
    }
    System.out.println("builder = "+builder);


    // 另外一种生成md5的方法，结果与上面一致
    // https://www.jianshu.com/p/9527f343f5da
    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String md5(String str) {  
        String digest = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            MessageDigest digester = MessageDigest.getInstance("md5");  
            byte[] digestArray = digester.digest(str.getBytes());  
            for (int i = 0; i < digestArray.length; i++) {  
                buffer.append(String.format("%02x", digestArray[i]));  
            }  
            digest = buffer.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return digest;  
    } 

}


/*
负数与0xff后，变成了正数

byte b=-127;
System.out.println("不:"+Integer.valueOf(b)); // -127
System.out.println("要:"+Integer.valueOf(b&0xff)); //129

*/

// 下方可以把java md5后byte数组中的负数全部转为正数：这样与OC的代码就保持一致了；python md5后byte数组也全部是正数
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        byte[] dataMD5Byte = new byte[]{-112, -32, 2, 34, -10, -85, 98, -33, -80, -126, 52, -113, -87, -118, -39, -77};
        int[] dataMD5ByteInteger = new int[dataMD5Byte.length];
        for (int i = 0; i<dataMD5Byte.length; i++){
            // 方法一：
            dataMD5ByteInteger[i] = dataMD5Byte[i] < 0 ? (256 + dataMD5Byte[i]) :dataMD5Byte[i]; //256= 2^8

            // 方法二：
            dataMD5ByteInteger[i] = dataMD5Byte[i] & 0xFF; // 把负数转为了正数
            // dataMD5ByteInteger[i]= (byte)(dataMD5Byte[i] & 0xFF); // 把正数转为了负数

        }
        System.out.println("dataMD5Byte = "+Arrays.toString(dataMD5Byte));
        System.out.println("dataMD5ByteInteger = "+Arrays.toString(dataMD5ByteInteger));
    }
}



// SHA-1
import java.math.BigInteger;
import java.security.MessageDigest;
public class Main {
    public static void main(String[] args) throws Exception {
        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("SHA-1");// SHA-256,不同的hash算法，这儿填入不同类型即可
        // 反复调用update输入数据:
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest(); // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
        System.out.println(new BigInteger(1, result).toString(16));
    }
}


/*
三方hash库BouncyCastle，
官网下载bcprov-jdk15on-xxx.jar

BouncyCastle是一个开源的第三方算法提供商；
BouncyCastle提供了很多Java标准库没有提供的哈希算法和加密算法；
使用第三方算法前需要通过Security.addProvider()注册。

*/
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Security;
public class Main {
    public static void main(String[] args) throws Exception {
        // 注册BouncyCastle:
        Security.addProvider(new BouncyCastleProvider());
        // 按名称正常调用:
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}



/*
HmacMD5 ≈ md5(secure_random_key, input)

HmacMD5可以看作带有一个安全的key的MD5。使用HmacMD5而不是用MD5加salt，有如下好处：
1. HmacMD5使用的key长度是64字节，更安全；
2. Hmac是标准算法，同样适用于SHA-1等其他哈希算法；
3. Hmac输出和原有的哈希算法长度一致。

和MD5相比，使用HmacMD5的步骤是：

通过名称HmacMD5获取KeyGenerator实例；
通过KeyGenerator创建一个SecretKey实例；
通过名称HmacMD5获取Mac实例；
用SecretKey初始化Mac实例；
对Mac实例反复调用update(byte[])输入数据；
调用Mac实例的doFinal()获取最终的哈希值。
*/

import java.math.BigInteger;
import javax.crypto.*;
public class Main {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();


        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        // System.out.println(Arrays.toString(skey)); // 输出是一个byte数组
        //System.out.println(new BigInteger(1, skey).toString(16));// 16进制的值
        
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(Arrays.toString(result));// 输出是一个byte数组
        System.out.println(new BigInteger(1, result).toString(16));// 16进制的值
    }
}

// 我们可以用Hmac算法取代原有的自定义的加盐算法，因此，可以存储用户名和口令的数据库
// 有了Hmac计算的哈希和SecretKey，我们想要验证怎么办？这时，SecretKey不能从KeyGenerator生成，而是从一个byte[]数组恢复：
// 恢复SecretKey的语句就是new SecretKeySpec(hkey, "HmacMD5")。

// 通过byteArray去还原
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.spec.*;
public class Main {
    public static void main(String[] args) throws Exception {
        byte[] hKey = new byte[] { 106, 70, -110, 125, 39, -20, 52, 56, 85, 9, -19, -72, 52, -53, 52, -45, -6, 119, -63,
                30, 20, -83, -28, 77, 98, 109, -32, -76, 121, -106, 0, -74, -107, -114, -45, 104, -104, -8, 2, 121, 6,
                97, -18, -13, -63, -30, -125, -103, -80, -46, 113, -14, 68, 32, -46, 101, -116, -104, -81, -108, 122,
                89, -106, -109 };

        SecretKey key = new SecretKeySpec(hKey, "HmacMD5");
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(Arrays.toString(result));
        // [126, 59, 37, 63, 73, 90, 111, -96, -77, 15, 82, -74, 122, -55, -67, 54]
    }
}


// 通过生成的hash值去还原：
// https://www.cnblogs.com/victor2302/p/11018189.html
import java.math.BigInteger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class Main {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();

        // 把key转为16进制数输出并记录:
        byte[] keyByteArray = key.getEncoded();
        String macMd5Res = new BigInteger(1, keyByteArray).toString(16);//参数1表示为正数

        // 通过记录的16位hash数来还原key
        byte[] keyByteArray1 = new BigInteger(macMd5Res, 16).toByteArray();
        // 因为前面是正数BigInteger,会有符号位,去除第一个符号位0,还原得到真正原始数组
        if (keyByteArray1[0]==0) {
            byte[] temArray = new byte[keyByteArray1.length - 1];
            System.arraycopy(keyByteArray1, 1, temArray, 0, temArray.length);
            keyByteArray1 = temArray;
        }
        SecretKey key1 = new SecretKeySpec(keyByteArray1, "HmacMD5");// 此方法只能通过keyByte数组来还原key

        System.out.println(key.equals(key1)); //true

        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));

        Mac mac1 = Mac.getInstance("HmacMD5");
        mac1.init(key1);
        mac1.update("HelloWorld".getBytes("UTF-8"));
        byte[] result1 = mac1.doFinal();
        System.out.println(new BigInteger(1, result1).toString(16));
    }
}


/*
对称加密算法：
-------------
常用的对称加密算法有：

算法        密钥长度            工作模式             填充模式
DES         56/64        ECB/CBC/PCBC/CTR/...    NoPadding/PKCS5Padding/...
AES       128/192/256    ECB/CBC/PCBC/CTR/...    NoPadding/PKCS5Padding/PKCS7Padding/...
IDEA        128            ECB                   PKCS5Padding/PKCS7Padding/...


密钥长度直接决定加密强度，而工作模式和填充模式可以看成是对称加密算法的参数和格式选择。
DES算法由于密钥过短，可以在短时间内被暴力破解，所以现在已经不安全了。


secret = encrypt(key, message);

plain = decrypt(key, secret);
*/


/*
Java标准库提供的对称加密接口非常简单，使用时按以下步骤编写代码：

根据算法名称/工作模式/填充模式获取Cipher实例；
根据算法名称初始化一个SecretKey实例，密钥必须是指定长度；
使用SerectKey初始化Cipher实例，并设置加密或解密模式；
传入明文或密文，获得密文或明文
*/ 

// AES算法是目前应用最广泛的加密算法。我们先用ECB模式加密并解密
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 128位密钥 = 16 bytes Key:
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    }

    // 加密:
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        return cipher.doFinal(input);
    }
}

/*
ECB模式是最简单的AES加密模式，它只需要一个固定长度的密钥，固定的明文会生成固定的密文，这种一对一的加密方式会导致安全性降低，更好的方式是通过CBC模式，它需要一个随机数作为IV参数，这样对于同一份明文，每次生成的密文都不同：

在CBC模式下，需要一个随机生成的16字节IV参数，必须使用SecureRandom生成。因为多了一个IvParameterSpec实例，因此，初始化方法需要调用Cipher的一个重载方法并传入IvParameterSpec。

观察输出，可以发现每次生成的IV不同，密文也不同。
*/

// AES - CBC
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 原文:
        String message = "Hello, world!";
        System.out.println("Message: " + message);
        // 256位密钥 = 32 bytes Key:
        byte[] key = "1234567890abcdef1234567890abcdef".getBytes("UTF-8");
        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(key, data);
        System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println("Decrypted: " + new String(decrypted, "UTF-8"));
    }

    // 加密:
    public static byte[] encrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        // CBC模式需要生成一个16 bytes的initialization vector:
        SecureRandom sr = SecureRandom.getInstanceStrong();
        byte[] iv = sr.generateSeed(16);
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivps);
        byte[] data = cipher.doFinal(input);
        // IV不需要保密，把IV和密文一起返回:
        return join(iv, data);
    }

    // 解密:
    public static byte[] decrypt(byte[] key, byte[] input) throws GeneralSecurityException {
        // 把input分割成IV和密文:
        byte[] iv = new byte[16];
        byte[] data = new byte[input.length - 16];
        System.arraycopy(input, 0, iv, 0, 16);
        System.arraycopy(input, 16, data, 0, data.length);
        // 解密:
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivps = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivps);
        return cipher.doFinal(data);
    }

    public static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
}


/*
口令加密算法：
------------

PBE算法，采用随机数和用户的输入杂凑计算出真正的密钥，再进行加密。
key = generate(userPassword, secureRandomPassword);

使用PBE时，我们还需要引入BouncyCastle，并指定算法是PBEwithSHA1and128bitAES-CBC-BC。
观察代码，实际上真正的AES密钥是调用Cipher的init()方法时同时传入SecretKey和PBEParameterSpec实现的。
在创建PBEParameterSpec的时候，我们还指定了循环次数1000，循环次数越多，暴力破解需要的计算量就越大。

如果我们把salt和循环次数固定，就得到了一个通用的“口令”加密软件。如果我们把随机生成的salt存储在U盘，就得到了一个“口令”加USB Key的加密软件，它的好处在于，即使用户使用了一个非常弱的口令，没有USB Key仍然无法解密，因为USB Key存储的随机数密钥安全性非常高。
*/

import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws Exception {
        // 把BouncyCastle作为Provider添加到java.security:
        Security.addProvider(new BouncyCastleProvider());
        // 原文:
        String message = "Hello, world!";
        // 加密口令:
        String password = "hello12345";
        // 16 bytes随机Salt:
        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
        System.out.printf("salt: %032x\n", new BigInteger(1, salt));
        // 加密:
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(password, salt, data);
        System.out.println("encrypted: " + Base64.getEncoder().encodeToString(encrypted));
        // 解密:
        byte[] decrypted = decrypt(password, salt, encrypted);
        System.out.println("decrypted: " + new String(decrypted, "UTF-8"));
    }

    // 加密:
    public static byte[] encrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }

    // 解密:
    public static byte[] decrypt(String password, byte[] salt, byte[] input) throws GeneralSecurityException {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory skeyFactory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey skey = skeyFactory.generateSecret(keySpec);
        PBEParameterSpec pbeps = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.DECRYPT_MODE, skey, pbeps);
        return cipher.doFinal(input);
    }
}



/*
密钥交换算法:
-----------

即DH算法：Diffie-Hellman算法应运而生
DH算法是一个密钥协商算法，双方最终协商出一个共同的密钥，而这个密钥不会通过网络传输。

DH算法的本质就是双方各自生成自己的私钥和公钥，私钥仅对自己可见，然后交换公钥，并根据自己的私钥和对方的公钥，生成最终的密钥secretKey，DH算法通过数学定律保证了双方各自计算出的secretKey是相同的。

但是DH算法并未解决中间人攻击，即甲乙双方并不能确保与自己通信的是否真的是对方。消除中间人攻击需要其他方法。
*/



import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import javax.crypto.KeyAgreement;

public class Main {
    public static void main(String[] args) {
        // Bob和Alice:
        Person bob = new Person("Bob");
        Person alice = new Person("Alice");

        // 各自生成KeyPair:
        bob.generateKeyPair();
        alice.generateKeyPair();

        // 双方交换各自的PublicKey:
        // Bob根据Alice的PublicKey生成自己的本地密钥:
        bob.generateSecretKey(alice.publicKey.getEncoded());
        // Alice根据Bob的PublicKey生成自己的本地密钥:
        alice.generateSecretKey(bob.publicKey.getEncoded());

        // 检查双方的本地密钥是否相同:
        bob.printKeys();
        alice.printKeys();
        // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...
    }
}

class Person {
    public final String name;

    public PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] secretKey;

    public Person(String name) {
        this.name = name;
    }

    // 生成本地KeyPair:
    public void generateKeyPair() {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(512);
            KeyPair kp = kpGen.generateKeyPair();
            this.privateKey = kp.getPrivate();
            this.publicKey = kp.getPublic();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {
            // 从byte[]恢复PublicKey:
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = kf.generatePublic(keySpec);
            // 生成本地密钥:
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey); // 自己的PrivateKey
            keyAgreement.doPhase(receivedPublicKey, true); // 对方的PublicKey
            // 生成SecretKey密钥:
            this.secretKey = keyAgreement.generateSecret();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    public void printKeys() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
    }
}


/*
非对称加密算法:
-------------
典型算法就是RSA算法

优点：相比对称加密，每个人管理的秘钥数比较少，不容易泄漏，可以公开各自的公钥，不需要协商秘钥。
缺点：运算速度非常慢。


在实际应用的时候，非对称加密总是和对称加密一起使用。假设小明需要给小红需要传输加密文件，他俩首先交换了各自的公钥，然后：

小明生成一个随机的AES口令，然后用小红的公钥通过RSA加密这个口令，并发给小红；
小红用自己的RSA私钥解密得到AES口令；
双方使用这个共享的AES口令用AES加密通信。

可见非对称加密实际上应用在第一步，即加密“AES口令”。这也是我们在浏览器中常用的HTTPS协议的做法，即浏览器和服务器先通过RSA交换AES口令，接下来双方通信实际上采用的是速度较快的AES对称加密，而不是缓慢的RSA非对称加密。

以RSA算法为例，它的密钥有256/512/1024/2048/4096等不同的长度。长度越长，密码强度越大，当然计算速度也越慢。
如果修改待加密的byte[]数据的大小，可以发现，使用512bit的RSA加密时，明文长度不能超过53字节，使用1024bit的RSA加密时，明文长度不能超过117字节，这也是为什么使用RSA的时候，总是配合AES一起使用，即用AES加密任意长度的明文，用RSA加密AES口令。
此外，只使用非对称加密算法不能防止中间人攻击。
*/

// java标准库提供了RSA算法的实现，示例代码如下：

import java.math.BigInteger;
import java.security.*;
import javax.crypto.Cipher;

public class Main {
    public static void main(String[] args) throws Exception {
        // 明文:
        byte[] plain = "Hello, encrypt use RSA".getBytes("UTF-8");
        // 创建公钥／私钥对:
        Person alice = new Person("Alice");
        // 用Alice的公钥加密:
        byte[] pk = alice.getPublicKey();
        System.out.println(String.format("public key: %x", new BigInteger(1, pk)));
        byte[] encrypted = alice.encrypt(plain);
        System.out.println(String.format("encrypted: %x", new BigInteger(1, encrypted)));
        // 用Alice的私钥解密:
        byte[] sk = alice.getPrivateKey();
        System.out.println(String.format("private key: %x", new BigInteger(1, sk)));
        byte[] decrypted = alice.decrypt(encrypted);
        System.out.println(new String(decrypted, "UTF-8"));
    }
}

class Person {
    String name;
    // 私钥:
    PrivateKey sk;
    // 公钥:
    PublicKey pk;

    public Person(String name) throws GeneralSecurityException {
        this.name = name;
        // 生成公钥／私钥对:
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        this.sk = kp.getPrivate();
        this.pk = kp.getPublic();
    }

    // 把私钥导出为字节
    public byte[] getPrivateKey() {
        return this.sk.getEncoded();
    }

    // 把公钥导出为字节
    public byte[] getPublicKey() {
        return this.pk.getEncoded();
    }

    // 用公钥加密:
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.pk);
        return cipher.doFinal(message);
    }

    // 用私钥解密:
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.sk);
        return cipher.doFinal(input);
    }
}


/*
签名算法:

私钥加密得到的密文实际上就是数字签名,然后用公钥解密
signature = encrypt(privateKey, sha256(message))
hash = decrypt(publicKey, signature)

常用数字签名算法有：
MD5withRSA
SHA1withRSA
SHA256withRSA
*/

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class Main {
    public static void main(String[] args) throws GeneralSecurityException {
        // 生成RSA公钥/私钥:
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        PrivateKey sk = kp.getPrivate();
        PublicKey pk = kp.getPublic();

        // 待签名的消息:
        byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);

        // 用私钥签名:
        Signature s = Signature.getInstance("SHA1withRSA");
        s.initSign(sk);
        s.update(message);
        byte[] signed = s.sign();
        System.out.println(String.format("signature: %x", new BigInteger(1, signed)));

        // 用公钥验证:
        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(pk);
        v.update(message);
        boolean valid = v.verify(signed);
        System.out.println("valid? " + valid);
    }
}

/*
DSA签名
除了RSA可以签名外，还可以使用DSA算法进行签名。DSA是Digital Signature Algorithm的缩写，它使用ElGamal数字签名算法。

DSA只能配合SHA使用，常用的算法有：

SHA1withDSA
SHA256withDSA
SHA512withDSA
和RSA数字签名相比，DSA的优点是更快。

ECDSA签名
椭圆曲线签名算法ECDSA：Elliptic Curve Digital Signature Algorithm也是一种常用的签名算法，它的特点是可以从私钥推出公钥。
比特币的签名算法就采用了ECDSA算法，使用标准椭圆曲线secp256k1。BouncyCastle提供了ECDSA的完整实现。
*/


/*
数字证书:

数字证书就是集合了多种密码学算法，用于实现数据加解密、身份认证、签名等多种功能的一种安全标准。
数字证书采用链式签名管理，顶级的Root CA证书已内置在操作系统中。
数字证书存储的是公钥，可以安全公开，而私钥必须严格保密。

*/


// 日期：

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date oldDate = dataFormat.parse("19700101080000");
        System.out.println(oldDate);

        Date dateNow = new Date();
        String dateNowString = dataFormat.format(new Date());
        System.out.println(dateNowString);
        
        long between = dateNow.getTime() - oldDate.getTime(); // seconds
        System.out.println(between);
        System.out.println(dateNow.getTime());
        System.out.println(dateNow.getTime() == between); // true
    }
}


import java.text.SimpleDateFormat;

public class testMain {
    public static void main(String[] args) {
        java.util.Date dateNow = new java.util.Date();
        
        SimpleDateFormat sy1=new SimpleDateFormat("yyyyMMdd");
        String dateFormat=sy1.format(dateNow);
        System.out.println(dateFormat); // 20210505

        // 如果希望分开得到年，月，日
        SimpleDateFormat sy=new SimpleDateFormat("yyyy");
        SimpleDateFormat sm=new SimpleDateFormat("MM");
        SimpleDateFormat sd=new SimpleDateFormat("dd");
        String syear=sy.format(dateNow); // 2021
        String smon=sm.format(dateNow); // 05
        String sday=sd.format(dateNow); //05
    }
}


/*
Maven:
------
a-maven-project
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       └── resources
└── target

Maven使用pom.xml定义项目内容，并使用预设的目录结构；
在Maven中声明一个依赖项可以自动下载并导入classpath；
Maven使用groupId，artifactId和version唯一定位一个依赖。

<project ...>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.itranswarp.learnjava</groupId>
    <artifactId>hello</artifactId>
    <version>1.0</version>
    <packaging>jar</packaging>
    <properties>
        ...
    </properties>
    <dependencies>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
    </dependencies>
</project>


//依赖关系：
scope       说明                                         示例
compile     编译时需要用到该jar包（默认）                  commons-logging
test        编译Test时需要用到该jar包                     junit
runtime     编译时不需要，但运行时需要用到                  mysql
provided    编译时需要用到，但运行时由JDK或某个服务器提供    servlet-api

注：只有以-SNAPSHOT结尾的版本号会被Maven视为开发版本，开发版本每次都会重复下载，这种SNAPSHOT版本只能用于内部私有的Maven repo，公开发布的版本不允许出现SNAPSHOT。

一个jar包一旦被下载过，就会被Maven自动缓存在本地目录（用户主目录的.m2目录）

使用Maven镜像仓库需要一个配置，在用户主目录下进入.m2目录，创建一个settings.xml配置文件，内容如下：
<settings>
    <mirrors>
        <mirror>
            <id>aliyun</id>
            <name>aliyun</name>
            <mirrorOf>central</mirrorOf>
            <!-- 国内推荐阿里云的Maven镜像 -->
            <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        </mirror>
    </mirrors>
</settings>


搜索第三方组件：
比如okhttp，如何确切地获得它的groupId、artifactId和version？
方法是通过search.maven.org搜索关键字，找到对应的组件后，直接复制


命令行编译:
在命令中，进入到pom.xml所在目录，输入以下命令：
$ mvn clean package
如果一切顺利，即可在target目录下获得编译后自动打包的jar。


在Eclipse中，可以直接创建或导入Maven项目。
如果导入后的Maven项目有错误，可以尝试选择项目后点击右键，选择Maven - Update Project...更新：


构建流程：
可以自动化实现编译，打包，发布，等等

Maven的生命周期由一系列阶段（phase）构成，以内置的生命周期default为例，它包含以下phase：

validate
initialize
generate-sources
process-sources
generate-resources
process-resources
compile
process-classes
generate-test-sources
process-test-sources
generate-test-resources
process-test-resources
test-compile
process-test-classes
test
prepare-package
package
pre-integration-test
integration-test
post-integration-test
verify
install
deploy

如果我们运行mvn package，Maven就会执行default生命周期，它会从开始一直运行到package这个phase为止：
validate
...
package

如果我们运行mvn compile，Maven也会执行default生命周期，但这次它只会运行到compile，即以下几个phase：
validate
...
compile

Maven另一个常用的生命周期是clean，它会执行3个phase：
pre-clean
clean （注意这个clean不是lifecycle而是phase）
post-clean

所以，我们使用mvn这个命令时，后面的参数是phase，Maven自动根据生命周期运行到指定的phase。

在实际开发过程中，经常使用的命令有：
mvn clean：清理所有生成的class和jar；
mvn clean compile：先清理，再执行到compile；
mvn clean test：先清理，再执行到test，因为执行test前必须执行compile，所以这里不必指定compile；
mvn clean package：先清理，再执行到package。

大多数phase在执行过程中，因为我们通常没有在pom.xml中配置相关的设置，所以这些phase什么事情都不做。

经常用到的phase其实只有几个：
clean：清理
compile：编译
test：运行测试
package：打包

执行一个phase又会触发一个或多个goal：

lifecycle相当于Java的package，它包含一个或多个phase；
phase相当于Java的class，它包含一个或多个goal；
goal相当于class的method，它其实才是真正干活的。

大多数情况，我们只要指定phase，就默认执行这些phase默认绑定的goal，只有少数情况，我们可以直接指定运行一个goal，例如，启动Tomcat服务器：
mvn tomcat:run

下面列举了一些常用的插件：
maven-shade-plugin：打包所有依赖包并生成可执行jar；
cobertura-maven-plugin：生成单元测试覆盖率报告；
findbugs-maven-plugin：对Java源码进行静态分析以找出潜在问题。

其他：
1.如何用pom.xml管理多个模块
2.如何指定maven版本
3.如何发布自己的maven
*/


/*
进程（Process）和线程(Thread)：
----------------------------

一个进程可以包含一个或多个线程，但至少会有一个线程。
操作系统调度的最小任务单位其实不是进程，而是线程。


进程VS线程：
和多线程相比，多进程的缺点在于：
创建进程比创建线程开销大，尤其是在Windows系统上；
进程间通信比线程间通信要慢，因为线程间通信就是读写同一个变量，速度很快。
而多进程的优点在于：

多进程稳定性比多线程高，因为在多进程的情况下，一个进程崩溃不会影响其他进程，而在多线程的情况下，任何一个线程崩溃会直接导致整个进程崩溃。


Java语言内置了多线程支持：一个Java程序实际上是一个JVM进程，JVM进程用一个主线程来执行main()方法，在main()方法内部，我们又可以启动多个线程。此外，JVM还有负责垃圾回收的其他工作线程等。

因此，对于大多数Java程序来说，我们说多任务，实际上是说如何使用多线程实现多任务。
*/



/*
创建新线程:

Java用Thread对象表示一个线程，通过调用start()启动一个新线程；
一个线程对象只能调用一次start()方法；
线程的执行代码写在run()方法中；
线程调度由操作系统决定，程序本身无法决定调度顺序；
Thread.sleep()可以把当前线程暂停一段时间。
*/ 

// 创建线程的时候，可以传入线程名
Web12306 web = new Web12306();
Thread proxy1 = new Thread(web, "黄牛");
Thread proxy2 = new Thread(web, "程序员");
/*
获取线程名：
不传入线程名，则默认：
main:
Thread-0:
Thread-1:
*/ 
Thread.currentThread().getName()


// 方法一：从Thread派生一个自定义类，然后覆写run()方法：
public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程, start()会自动调用run()方法，
        // 直接调用run()方法是无效的，即：t.run()
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

// 方法二：创建Thread实例时，传入一个Runnable实例：
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start(); // 启动新线程
    }
}

class MyRunnable implements Runnable { //这儿是一个接口
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

// 方法三： lambda表达式简写：
public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("start new thread!");
        });
        t.start(); // 启动新线程
    }
}


// 在线程中调用Thread.sleep()，强迫当前线程暂停一段时间：
public class Main {
    public static void main(String[] args) {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10); //sleep()传入的参数是毫秒
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }
}


// 可以对线程设定优先级，设定优先级的方法是：
// 但 不能通过设置优先级来确保高优先级的线程一定会先执行。
Thread.setPriority(int n) // 1~10, 默认值5, 其他值Thread.MAX_PRIORITY，Thread.MIN_PRIORITY


/*
线程状态：
----------

New：新创建的线程，尚未执行；
|
Runnable：运行中的线程，正在执行run()方法的Java代码；
Blocked：运行中的线程，因为某些操作被阻塞而挂起；
Waiting：运行中的线程，因为某些操作在等待中；
Timed Waiting：运行中的线程，因为执行sleep()方法正在计时等待；
|
Terminated：线程已终止，因为run()方法执行完毕。


线程终止的原因有：

线程正常终止：run()方法执行到return语句返回；
线程意外终止：run()方法因为未捕获的异常导致线程终止；
对某个线程的Thread实例调用stop()方法强制终止（强烈不推荐使用）。

*/ 

// 可以通过t.join()等待t线程结束后再继续运行

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join(); // 等待t结束，这儿可以制定等待时间。对已经运行结束的线程调用join()方法会立刻返回。
        System.out.println("end");
    }
}
// start
// hello
// end



/*
线程中断：

调用目标线程的.interrupt()可以中断线程
对线程调用.isInterrupted()可以判断是否被中断了
目标线程检测到isInterrupted()为true或者捕获了InterruptedException都应该立刻结束自身线程；

还有一种设置标志位，可以中断线程
*/

//interrupt
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1000);
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
    }
}

class MyThread extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        } finally {
            hello.interrupt();
        }
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

//设置标志位flag来进行中断:
/*
volatile关键字的目的是告诉虚拟机：

每次访问变量时，总是获取主内存的最新值；
每次修改变量后，立刻回写到主内存。
*/

public class Main {
    public static void main(String[] args)  throws InterruptedException {
        HelloThread t = new HelloThread();
        t.start();
        Thread.sleep(1);
        t.running = false; // 标志位置为false
    }
}

class HelloThread extends Thread {
    public volatile boolean running = true; // 线程间共享变量需要使用volatile关键字标记
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

/*
守护线程：
-----------
Daemon Thread

守护线程是指为其他线程服务的线程。
在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。

在调用start()方法前，调用setDaemon(true)可以把该线程标记为守护线程：

在守护线程中，编写代码要注意：守护线程不能持有任何需要关闭的资源，
例如打开文件等，因为虚拟机退出时，守护线程没有任何机会来关闭文件，这会导致数据丢失。
*/

// 创建守护线程：标记为守护线程，相当于它是一个后台线程，main结束后，JVM也就结束了，
Thread t = new MyThread();
t.setDaemon(true);
t.start();

//下面这个，没有标记为守护线程，那么main结束后，t并没有结束，JVM也不会退出。
package com.tcp;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws Exception {
        var t = new TimerThread();
        t.start();
    }
}

class TimerThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

/*
线程同步：

加锁和解锁之间的代码块我们称之为临界区（Critical Section），任何时候临界区最多只有一个线程能执行。
Java程序使用synchronized关键字对一个对象进行加锁：
synchronized(lock) {
    n = n + 1;
}

synchronized(Counter.lock) { // 获取锁
    ...
} // 释放锁

如何使用synchronized：
找出修改共享变量的线程代码块；
选择一个共享实例作为锁；
使用synchronized(lockObject) { ... }。


多线程同时读写共享变量时，会造成逻辑错误，因此需要通过synchronized同步；
同步的本质就是给指定对象加锁，加锁后才能继续执行后续代码；
注意加锁对象必须是同一个实例；

对JVM定义的单个原子操作不需要同步：
long和double是64位数据，JVM没有明确规定64位赋值操作是不是一个原子操作，不过在x64平台的JVM是把long和double的赋值作为原子操作实现的。
*/


// 单个锁：
public class Main {
    public static void main(String[] args) throws Exception {
        var add = new AddThread();
        var dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);
    }
}

class Counter {
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lock) {
                Counter.count -= 1;
            }
        }
    }
}


// 可以并行进行的就不用加锁，需要读取同一个对象的，才加锁！下面例子为两个锁
public class Main {
    public static void main(String[] args) throws Exception {
        var ts = new Thread[] { new AddStudentThread(), new DecStudentThread(), new AddTeacherThread(), new DecTeacherThread() };
        for (var t : ts) {
            t.start();
        }
        for (var t : ts) {
            t.join();
        }
        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }
}

class Counter {
    public static final Object lockStudent = new Object();
    public static final Object lockTeacher = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lockStudent) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lockStudent) {
                Counter.studentCount -= 1;
            }
        }
    }
}

class AddTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lockTeacher) {
                Counter.teacherCount += 1;
            }
        }
    }
}

class DecTeacherThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter.lockTeacher) {
                Counter.teacherCount -= 1;
            }
        }
    }
}


/*
同步方法：
---------
用synchronized修饰方法可以把整个方法变为同步代码块，synchronized方法加锁对象是this；
通过合理的设计和数据封装可以让一个类变为“线程安全”；
一个类没有特殊说明，默认不是thread-safe；
*/


// synchronized封装：
public class Main {
    public static void main(String[] args) throws Exception {
        var c1 = new Counter();
        var c2 = new Counter();

        new Thread(() -> c1.add(1)).start();
        new Thread(() -> c1.dec(1)).start();

        new Thread(() -> c2.add(1)).start();
        new Thread(() -> c2.dec(1)).start();

        System.out.println(c1.get()); //这儿读取状态，线程不一定结束了
        System.out.println(c2.get());
        /*执行结果为0，1或者 0，0等，
        同步只保证多线程执行的synchronized块是依次执行，最终状态对不对还取决于你的逻辑。*/
    }
}
class Counter {
    private int count = 0;

    // 下面两种写法等价
    /*
    public void add(int n) {
        synchronized(this) { //锁住this,当前对象
            count += n;
        } //解锁
    }
    * */
    public synchronized void add(int n) { // 锁住this
        count += n;
    } // 解锁

    /*
    public void dec(int n) {
        synchronized(this) {
            count -= n;
        }
    }
    * */
    public synchronized void dec(int n) {
        count -= n;
    }

    public int get() {
        return count; //因为读取一个变量，不需要同步，如果这儿读取两个变量，就需要同步加锁了。
    }

    public synchronized static void test(int n) {
    }
    /*
    对于静态方法，锁住的是该类的Class实例，相当于:
    public static void test1(int n) {
        synchronized (Counter.class){ // 锁住类Class
        }
    }
    * */
}


/*
上面的Counter类就是线程安全的。Java标准库的java.lang.StringBuffer也是线程安全的。

还有一些不变类，例如String，Integer，LocalDate，它们的所有成员变量都是final，多线程同时访问时只能读不能写，这些不变类也是线程安全的。

最后，类似Math这些只提供静态方法，没有成员变量的类，也是线程安全的。

除了上述几种少数情况，大部分类，例如ArrayList，都是非线程安全的类，我们不能在多线程中修改它们。但是，如果所有线程都只读取，不写入，那么ArrayList是可以安全地在线程间共享的。
*/


/*
重入锁:
JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁
*/
public class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}

/*
死锁：
两个线程不能获取同一个锁多次

线程1和线程2如果分别执行add()和dec()方法时
线程1：进入add()，获得lockA；
线程2：进入dec()，获得lockB。
随后：
线程1：准备获得lockB，失败，等待中；
线程2：准备获得lockA，失败，等待中。
*/
public void add(int m) {
    synchronized(lockA) { // 获得lockA的锁
        this.value += m;
        synchronized(lockB) { // 获得lockB的锁
            this.another += m;
        } // 释放lockB的锁
    } // 释放lockA的锁
}

public void dec(int m) {
    synchronized(lockB) { // 获得lockB的锁
        this.another -= m;
        synchronized(lockA) { // 获得lockA的锁
            this.value -= m;
        } // 释放lockA的锁
    } // 释放lockB的锁
}

/*如何避免死锁？
线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序，改写dec()方法如下：
*/
public void dec(int m) {
    synchronized(lockA) { // 获得lockA的锁
        this.value -= m;
        synchronized(lockB) { // 获得lockB的锁
            this.another -= m;
        } // 释放lockB的锁
    } // 释放lockA的锁
}


/*
wait()
notify()
*/
package com.tcp;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 新建TaskQueue实例对象
        var q = new TaskQueue();
        // 存放线程的数组
        var ts = new ArrayList<Thread>();
        // 开启并运行5个线程，每个线程都尝试打印q中的task
        for (int i = 0; i < 5; i++) {
            /* 等价于：
             var t = new Thread() {
                public void run() {  */
            var t = new Thread(() -> {
                // 执行task:
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        // 新建add线程，在线程中，每隔100ms，往q中添加一个String
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task " + i + ": " + s);
                q.addTask(s);
                // 这里每次往q中添加一个String后暂停100ms的原因是为了让上述5个线程中的某一个能够及时捕捉到，并打印
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        // 这里是main线程等待add线程执行完毕，但是for循环创建的5个线程是在一直运行中的
        add.join();
        // 主线程暂停100ms,目的是留出一点时间，让上述5个线程能够将q中的String全部get出来
        // 然后再对所有的 提出中断请求
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll(); // 使用.notify(),notifyAll()唤醒其他线程
    }

    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait(); // wait()释放锁，然后进入等待状态，当notify之后，又重新获取锁
        }
        return queue.remove();
    }
}


/*
ReentrantLock:
---------------
从Java 5开始，引入了一个高级的处理并发的java.util.concurrent包，它提供了大量更高级的并发功能，能大大简化多线程程序的编写。
java.util.concurrent.locks包提供的ReentrantLock用于替代synchronized加锁
*/

// 使用synchronized加锁
public class Counter {
    private int count;

    public void add(int n) {
        synchronized(this) {
            count += n;
        }
    }
}

/*
如果用ReentrantLock替代，可以把代码改造为：

因为ReentrantLock是Java代码实现的锁，我们就必须先获取锁，再进入try {...}代码块, 然后在finally中正确释放锁。
*/ 

// 使用ReentrantLock加锁
public class Counter {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        lock.lock(); //获取锁
        try {
            count += n;
        } finally {
            lock.unlock();
        }
    }
}


/*
和synchronized不同的是，ReentrantLock可以尝试获取锁：//用tryLock()

如果1秒后仍未获取到锁，tryLock()返回false，程序就可以做一些额外处理，而不是无限等待下去。
所以，使用ReentrantLock比直接使用synchronized更安全，线程在tryLock()失败的时候不会导致死锁。
*/ 
if (lock.tryLock(1, TimeUnit.SECONDS)) {
    try {
        ...
    } finally {
        lock.unlock();
    }
}

/*
Condition:
------------
ReentrantLock使用Condition对象来实现wait和notify的功能。
*/

//上面的代码改成用rentrantLock来实现
import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 新建TaskQueue实例对象
        var q = new TaskQueue();
        // 存放线程的数组
        var ts = new ArrayList<Thread>();
        // 开启并运行5个线程，每个线程都尝试打印q中的task
        for (int i = 0; i < 5; i++) {
            /* 等价于：
             var t = new Thread() {
                public void run() {  */
            var t = new Thread(() -> {
                // 执行task:
                while (true) {
                    try {
                        String s = q.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            ts.add(t);
        }
        // 新建add线程，在线程中，每隔100ms，往q中添加一个String
        var add = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task " + i + ": " + s);
                q.addTask(s);
                // 这里每次往q中添加一个String后暂停100ms的原因是为了让上述5个线程中的某一个能够及时捕捉到，并打印
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        });
        add.start();
        // 这里是main线程等待add线程执行完毕，但是for循环创建的5个线程是在一直运行中的
        add.join();
        // 主线程暂停100ms,目的是留出一点时间，让上述5个线程能够将q中的String全部get出来
        // 然后再对所有的 提出中断请求
        Thread.sleep(100);
        for (var t : ts) {
            t.interrupt();
        }
    }
}

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    // condition提供await(), signal(), signallAll(), 对应synchronized锁对象的wait(), notify(), notifyAll()
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}


// 此外，和tryLock()类似，await()可以在等待指定时间后，如果还没有被其他线程通过signal()或signalAll()唤醒，可以自己醒来：
if (condition.await(1, TimeUnit.SECOND)) {
    // 被其他线程唤醒
} else {
    // 指定时间内没有被其他线程唤醒
}

/*
ReadWriteLock:
-------------
一个线程写，多个线程读

使用ReadWriteLock可以提高读取效率：
ReadWriteLock只允许一个线程写入；
ReadWriteLock允许多个线程在没有写入时同时读取；
ReadWriteLock适合读多写少的场景。比如帖子的回复和阅读
*/

import java.util.*;
import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    }
}
/**
 * ReadWriteLock特点：
 *
 * 只允许一个线程写入（其他线程既不能写入也不能读取）；
 * 没有写入时，多个线程允许同时读（提高性能）
 *
 * 缺点：线程正在读的时候，不允许写，这是一种悲观的读锁
 * */
class Counter {
    private final ReadWriteLock rwlock = new ReentrantReadWriteLock();
    private final Lock rlock = rwlock.readLock();
    private final Lock wlock = rwlock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        wlock.lock(); // 加写锁
        try {
            counts[index] += 1;
        } finally {
            wlock.unlock(); // 释放写锁
        }
    }

    /**
     * 如果没有加读锁:
     *
     * 锁的目的不是读的数据是错的，是保证连续读逻辑上一致的：
     *
     * int x = obj.x;
     * // 这里线程可能中断
     * int y = obj.y;
     *
     * 假设obj的x，y是[0,1]，某个写线程修改成[2,3]，你读到的要么是[0,1]，要么是[2,3]，但是没有锁，你读到的可能是[0,3]
     * */
    public int[] get() {
        rlock.lock(); // 加读锁
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            rlock.unlock(); // 释放读锁
        }
    }
}

/*
StampedLock:
------------
Java 8引入；
相对于ReadWriteLock, 读的过程中也允许获取写锁后写入。
这样一来，我们读的数据就可能不一致，所以，需要一点额外的代码来判断读的过程中是否有写入，这种读锁是一种乐观锁。

乐观锁的意思就是乐观地估计读的过程中大概率不会有写入，因此被称为乐观锁。
反过来，悲观锁则是读的过程中拒绝有写入，也就是写入必须等待。
显然乐观锁的并发效率更高，但一旦有小概率的写入导致读取的数据不一致，需要能检测出来，再读一遍就行。

缺点： StampedLock是不可重入锁。

StampedLock还提供了更复杂的将悲观读锁升级为写锁的功能，它主要使用在if-then-update的场景：即先读，如果读的数据满足条件，就返回，如果读的数据不满足条件，再尝试写。
*/

import java.util.concurrent.locks.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    }
}

class Point {
    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }

    /**
     * 先用乐观锁读数据
     * 如果乐观锁数据无效，则重新用悲观锁读一遍
     */
    public double distanceFromOrigin() {
        // 获得一个乐观读锁，tryOptimisticRead返回的是版本号，不是锁，根本没有锁。版本号是个long.
        long stamp = stampedLock.tryOptimisticRead(); 
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生，validata是判断版本号变了没有，如果没变，就没有写入。
            stamp = stampedLock.readLock(); // 获取一个悲观读锁, readLock()才返回真正的读锁，必须finally中unlock
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}


/*
线程安全集合类：
-------------
java.util.concurrent

interface    non-thread-safe               thread-safe
List         ArrayList                     CopyOnWriteArrayList
Map          HashMap                       ConcurrentHashMap
Set          HashSet / TreeSet             CopyOnWriteArraySet
Queue        ArrayDeque / LinkedList       ArrayBlockingQueue / LinkedBlockingQueue
Deque        ArrayDeque / LinkedList       LinkedBlockingDeque


使用这些并发集合与使用非线程安全的集合类完全相同。我们以ConcurrentHashMap为例：

Map<String, String> map = new ConcurrentHashMap<>();
// 在不同的线程读写:
map.put("A", "1");
map.put("B", "2");
map.get("A", "1");


所有的加锁和同步逻辑都在集合内部实现，我们只关心接口即可：
Map<String, String> map = new HashMap<>();
改为：
Map<String, String> map = new ConcurrentHashMap<>();


java.util.Collections工具类还提供了一个旧的线程安全集合转换器，可以这么用：
Map unsafeMap = new HashMap();
Map threadSafeMap = Collections.synchronizedMap(unsafeMap);

*/


/*
Atomic:
-------
使用java.util.concurrent.atomic提供的原子操作可以简化多线程编程：

Atomic类是通过无锁（lock-free）的方式实现的线程安全（thread-safe）访问。它的主要原理是利用了CAS：Compare and Set。
我们以AtomicInteger为例，它提供的主要操作有：

增加值并返回新值：int addAndGet(int delta)
加1后返回新值：int incrementAndGet()
获取当前值：int get()
用CAS方式设置：int compareAndSet(int expect, int update)

原子操作实现了无锁的线程安全；
适用于计数器，累加器等。
CAS相比Synchronized，避免了锁的使用，总体性能比Synchronized高很多。


我们利用AtomicLong可以编写一个多线程安全的全局唯一ID生成器：
class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
*/


/*
线程池：
------

Java标准库提供了ExecutorService接口表示线程池，它的典型用法如下：

// 创建固定大小的线程池:
ExecutorService executor = Executors.newFixedThreadPool(3);
// 提交任务:
executor.submit(task1);
executor.submit(task2);
executor.submit(task3);
executor.submit(task4);
executor.submit(task5);

因为ExecutorService只是接口，Java标准库提供的几个常用实现类有：

FixedThreadPool：线程数固定的线程池；
CachedThreadPool：线程数根据任务动态调整的线程池；
SingleThreadExecutor：仅单线程执行的线程池。
*/


// thread-pool：

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        /**
         * 创建一个固定大小的线程池:
         * 一次只能执行4个线程，多余线程需要等其他线程结束后才能执行。
         * ExecutorService es = Executors.newFixedThreadPool(4);
         * */
        int min = 4;
        int max = 10;
        /**
         * 配置动态线程池大小在4~10之间
         * */
        ExecutorService es = new ThreadPoolExecutor(min, max, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
        /**
         * shutdown()方法关闭线程池的时候，它会等待正在执行的任务先完成，然后再关闭
         * shutdownNow()会立刻停止正在执行的任务
         * awaitTermination()则会等待指定的时间让线程池关闭

         * 网友：如果最后只使用了awaitTermination()，会发现程序一直没结束，因为这个函数并没有关闭线程池。其通常放在shutdown()函数后面用来判断固定时间后线程池是否关闭
         * */
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}


/**
 * ScheduledThreadPool:
 * --------------------
 * FixedRate是指任务总是以固定时间间隔触发，不管任务执行多长时间
 * FixedDelay是指，上一次任务执行完毕后，等待固定的时间间隔，再执行下一次任务
 *
 * Q: 在scheduleAtFixedRate模式下，假设每秒触发，如果某次任务执行时间超过1秒，后续任务会不会并发执行？
 * A: 如果此任务的任何执行时间超过其周期，则后续执行可能会延迟开始，但不会并发执行。
 * Q: 如果任务抛出了异常，后续任务是否继续执行？
 * A: 如果任务的任何执行遇到异常，则将禁止后续任务的执行。
 *
 * Java标准库还提供了一个java.util.Timer类，这个类也可以定期执行任务，但是，一个Timer会对应一个Thread，所以，一个Timer只能定期执行一个任务，多个定时任务必须启动多个Timer，
 * 而一个ScheduledThreadPool就可以调度多个定时任务，所以，我们完全可以用ScheduledThreadPool取代旧的Timer。
 * */

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);// 1s后执行一次性任务

        // ses.scheduleAtFixedRate(new Task("fixed -rate"), 2, 3, TimeUnit.SECONDS);// 2s后每间隔3s执行一次任务, 不管上次任务是否完毕
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);// 2s后开始执行,任务完成后，以3秒为间隔再执行
    }
}

class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("end task " + name);
    }
}


/*
Future:
--------

Runnable接口有个问题，它的方法没有返回值。
class Task implements Runnable {
    public String result;

    public void run() {
        this.result = longTimeCalculation(); 
    }
}

Java标准库还提供了一个Callable接口，和Runnable接口比，它多了一个返回值：
Callable接口是一个泛型接口，可以返回指定类型的结果。
class Task implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation(); 
    }
}

ExecutorService.submit()方法，可以看到，它返回了一个Future类型，一个Future类型的实例代表一个未来能获取结果的对象：

ExecutorService executor = Executors.newFixedThreadPool(4); 
// 定义任务:
Callable<String> task = new Task();
// 提交任务并获得Future:
Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
String result = future.get(); // 可能阻塞


一个Future<V>接口表示一个未来可能会返回的结果，它定义的方法有：

get()：获取结果（可能会等待）
get(long timeout, TimeUnit unit)：获取结果，但只等待指定的时间；
cancel(boolean mayInterruptIfRunning)：取消当前任务；
isDone()：判断任务是否已完成。

缺点：
使用Future获得异步执行结果时，要么调用阻塞方法get()，要么轮询看isDone()是否为true，这两种方法都不是很好，因为主线程也会被迫等待。
*/


/*
CompletableFuture:
------------------

从Java 8开始引入了CompletableFuture，它针对Future做了改进，
可以传入回调对象，当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
完成时，CompletableFuture会调用Consumer对象：
异常时，CompletableFuture会调用Function对象：

CompletableFuture的优点是：
异步任务结束时，会自动回调某个对象的方法；
异步任务出错时，会自动回调某个对象的方法；
主线程设置好回调后，不再关心异步任务的执行。


CompletableFuture可以指定异步处理流程：

thenAccept()处理正常结果；
exceptional()处理异常结果；
thenApplyAsync()用于串行化另一个CompletableFuture；
anyOf()和allOf()用于并行化多个CompletableFuture。
*/


// 基本用法：

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建异步执行任务:
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(Main::fetchPrice);
        // 如果执行成功:
        cf.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 如果执行异常:
        cf.exceptionally((e) -> {
            e.printStackTrace();
            return null;
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("fetch price failed!");
        }
        return 5 + Math.random() * 20;
    }
}



// 串行执行任务：
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 第一个任务，查询code
        CompletableFuture<String> cfQuery = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油");
        });
        // cfQuery成功后继续执行下一个任务,获取价格
        CompletableFuture<Double> cfFetch = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice(code);
        });
        // cfFetch成功后打印结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(2000);
    }

    static String queryCode(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}


/*
并行执行任务：
------------
anyOf()可以实现“任意个CompletableFuture只要一个成功”，allOf()可以实现“所有CompletableFuture都必须成功”

注意CompletableFuture的命名规则：
xxx()：表示该方法将继续在已有的线程中执行；
xxxAsync()：表示将异步在线程池中执行。
*/ 
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws Exception {
        // 两个CompletableFuture执行异步查询:
        CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://finance.sina.com.cn/code/");
        });
        CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
            return queryCode("中国石油", "https://money.163.com/code/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

        // 两个CompletableFuture执行异步查询:
        CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
        });
        CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
            return fetchPrice((String) code, "https://money.163.com/price/");
        });

        // 用anyOf合并为一个新的CompletableFuture:
        CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

        // 最终结果:
        cfFetch.thenAccept((result) -> {
            System.out.println("price: " + result);
        });
        // 主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:
        Thread.sleep(200);
    }

    static String queryCode(String name, String url) {
        System.out.println("query code from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return "601857";
    }

    static Double fetchPrice(String code, String url) {
        System.out.println("query price from " + url + "...");
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
        }
        return 5 + Math.random() * 20;
    }
}

/*
fork/join
----------
Java 7开始引入了一种新的Fork/Join线程池，它可以执行一种特殊的任务：把一个大任务拆成多个小任务并行执行。

ForkJoinPool线程池可以把一个大任务分拆成小任务并行执行，任务类必须继承自RecursiveTask或RecursiveAction

Fork/Join线程池在Java标准库中也有应用。
Java标准库提供的java.util.Arrays.parallelSort(array)可以进行并行排序，它的原理就是内部通过Fork/Join对大数组分拆进行并行排序，在多核CPU上就可以大大提高排序的速度。
*/

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Main {
    public static void main(String[] args) throws Exception {
        // 创建2000个随机数组成的数组:
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        // fork/join:
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    static Random random = new Random(3); // 设定seed值后，生成的随机数是一个定值

    static long random() {
        return random.nextInt(10000);
    }
}

class SumTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 200; // 设定最大持有多少个数
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += this.array[i];
                // 故意放慢计算速度:
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
        System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        invokeAll(subtask1, subtask2); // 并行运行两个子任务
        Long subresult1 = subtask1.join(); // 获取子任务的结果
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }
}

/*
ThreadLocal:
------------
Java标准库提供了一个特殊的ThreadLocal，它可以在一个线程中传递同一个对象。

static ThreadLocal<User> threadLocalUser = new ThreadLocal<>(); // 通常以静态字段初始化

使用：
void processUser(user) {
    try {
        threadLocalUser.set(user);
        step1();
        step2();
    } finally {
        threadLocalUser.remove();  // 一定要记得清除
    }
}

// 一个线程中不同的方法获取threadLocalUser.
void step1() {
    User u = threadLocalUser.get();
    log();
    printUser();
}

void log() {
    User u = threadLocalUser.get();
    println(u.name);
}

void step2() {
    User u = threadLocalUser.get();
    checkUser(u.id);
}

*/

// 调用Thread.currentThread()获取当前线程：
public class Main {
    public static void main(String[] args) throws Exception {
        log("start main...");
        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main.");
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}


// 例如： 一个保存了当前用户名的ThreadLocal可以封装为一个UserContext对象：
public class Main {
    public static void main(String[] args) throws Exception {
        try (var ctx = new UserContext("Bobi")) {
            // 可任意调用UserContext.currentUser():
            String currentUser = UserContext.currentUser(); // 获取当前线程绑定的用户名
            System.out.println(currentUser);
        } // 在此自动调用UserContext.close()方法释放ThreadLocal关联对象
    }
}

class UserContext implements AutoCloseable {
    static final ThreadLocal<String> ctx = new ThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() {
        ctx.remove();
    }
}

/*
JDBC:
------------
Java DataBase Connectivity

PreparedStatement比Statement更安全，能避免sql语句注入的问题，而且更快
使用Java对数据库进行操作时，必须使用PreparedStatement，严禁任何通过参数拼字符串的代码！

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.20</version>
    <scope>runtime</scope>
</dependency>

Mysql语句中，优先级:  and > or

只有最新的JDBC驱动才支持LocalDate和LocalTime

*/


/*
作业：
1、DDL/DML/DQL/DCL分别指什么，并分别举1-2个例子；
2、创建数据库PinGuo,表stuff,包含ID(自增长),name,sex(male/female，默认male),age,department
Stuff表插入20条数据，其中年龄为22-40随机输入。筛选并打印年龄<25岁的所有人显示全部信息，打印并删除年龄>35的所有人信息。


DML（DataManipulationLanguage）：数据操作语言，select,update,insert,delete
DCL（DataControlLanguage）：数据控制语言，用来定义访问权限和安全级别；grant, revoke
DQL（DataQueryLanguage）：数据查询语言，用来查询记录; select * from * where *
DDL（DataDefinitionLanguage）：数据定义语言，用来定义数据库对象：库、表、列等, create,alter,drop
*/


/*
用try来自动释放资源
try () {
    ...
}
*/
// 链接数据库
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    // 创建声明
    try (Statement stmt = conn.createStatement()) {
        // 执行查询
        // ResultSet获取列时，索引从1开始而不是0
        try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
            // 获取结果
            while (rs.next()) { // 用next()反复调用
                long id = rs.getLong(1); // 注意：索引从1开始,中间的index为对应列，或者列名
                long grade = rs.getLong(2);
                String name = rs.getString(3);
                int gender = rs.getInt(4);
            }
        }
    }
}

/*
Statement:
executeUpdate()

PreparedStatement
查询：executeQuery()
插入/更新/删除：executeUpdate()， 不同点只是sql语句不一样

executeUpdate()
插入时候：返回的是插入记录的数量，一条信息为1，类型为int, 
更新时候：返回的是更新的行数的数量，也有可能是0(表示没有数据进行更新)
删除时候：返回的是删除的行数的数量
*/

// 查询：
// 为了避免SQL语句注入的问题，可以用PreparedStatement来进行查询或者更新，用？表示占位符
try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
    try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
        ps.setObject(1, 1); // 注意：索引从1开始
        ps.setObject(2, 3);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                long grade = rs.getLong("grade");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
            }
        }
    }
}

// 插入：
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    try (PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO students (id, grade, name, gender) VALUES (?,?,?,?)")) {
        ps.setObject(1, 999); // 注意：索引从1开始
        ps.setObject(2, 1); // grade
        ps.setObject(3, "Bob"); // name
        ps.setObject(4, "M"); // gender
        int n = ps.executeUpdate(); // 1
    }
}

// 插入并获取自增主键值
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    try (PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO students (grade, name, gender) VALUES (?,?,?)",
            Statement.RETURN_GENERATED_KEYS)) { // 必须传入常量Statement.RETURN_GENERATED_KEYS来返回自增主键
        ps.setObject(1, 1); // grade
        ps.setObject(2, "Bob"); // name
        ps.setObject(3, "M"); // gender
        int n = ps.executeUpdate(); // 1
        try (ResultSet rs = ps.getGeneratedKeys()) {  // 调用getGeneratedKeys()获取
            if (rs.next()) {
                long id = rs.getLong(1); // 注意：索引从1开始
            }
        }
    }
}

// 更新：
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=? WHERE id=?")) {
        ps.setObject(1, "Bob"); // 注意：索引从1开始
        ps.setObject(2, 999);
        int n = ps.executeUpdate(); // 返回更新的行数
    }
}

// 删除：
try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    try (PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?")) {
        ps.setObject(1, 999); // 注意：索引从1开始
        int n = ps.executeUpdate(); // 删除的行数
    }
}

// 实例
package org.jdbc;
import java.sql.*;
public class Main {
    /*
    MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL:
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/TEST";
    */

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL, 8.0以上版本不需要建立ssl,需要关闭
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/javatest?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf8";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "captain";
    static final String PASS = "zhuniu1211";

    public static void main(String[] args) {
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            System.out.println("连接数据库...");
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //获取最后一条记录的id,以便于给新插入行正确的id
            System.out.println("实例化查询最后一条记录的Statement对象...");
            Statement stmtLastLine = conn.createStatement();

            String getLastLine = "SELECT * FROM websites ORDER BY id DESC LIMIT 1";
            ResultSet rsLastLine = stmtLastLine.executeQuery(getLastLine);
            // ResultSet获取列时，索引从1开始，而不是0；
            int lastID = 0;
            rsLastLine.next();  //一定要用.next()把ResultSet对象的光标移至指定行,反复调用next()来读取每一行结果
            lastID = rsLastLine.getInt("id");

            System.out.println("最后一行的id是："+lastID);
            int nextID = lastID+1;

            //preparedStatement案例：
            // 1.
            System.out.println("实例化用于插入新记录的PreparedStatement对象...");
            String ppInsert = "INSERT INTO websites VALUES (?,?,?,?,?)";
            // 2. 获取PreparedStatement
            PreparedStatement preparedStatement = conn.prepareStatement(ppInsert);
            // 3. 设置查询参数
            preparedStatement.setInt(1,nextID); // .setObject()
            preparedStatement.setString(2,"百度");
            preparedStatement.setString(3,"https://www.baidu.com/");
            preparedStatement.setString(4,"20");
            preparedStatement.setString(5,"CN");
            int rows = preparedStatement.executeUpdate();
            if (rows>0){
                System.out.println("插入成功！");
            }else {
                System.out.println("插入失败啦！Debug去～");
            }

            // Statement执行查看全表内容
            System.out.println("实例化查询全表内容的Statement对象...");
            Statement stmtAll = conn.createStatement();
            String selectAll = "SELECT id, name, url FROM websites";
            ResultSet rs = stmtAll.executeQuery(selectAll);

            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String url = rs.getString("url");
                // 输出数据
                System.out.print("ID:" + id);
                System.out.print(" , 站点名称:" + name);
                System.out.print(" , 站点URL:" + url);
                System.out.print("\n");
            }

            // 完成后关闭
            rsLastLine.close();
            rs.close();
            stmtLastLine.close();
            preparedStatement.close();
            stmtAll.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
        System.out.println("Goodbye!");
    }
}

/*
数据库事务具有ACID特性：

Atomicity：原子性
Consistency：一致性
Isolation：隔离性
Durability：持久性

MySQL的默认隔离级别是REPEATABLE READ

Isolation Level 脏读（Dirty Read）  不可重复读（Non Repeatable Read）  幻读（Phantom Read）
Read Uncommitted    Yes Yes Yes
Read Committed      -   Yes Yes
Repeatable Read     -   -   Yes
Serializable        -   -   -

*/

Connection conn = openConnection();
try {
    // 关闭自动提交:
    conn.setAutoCommit(false);
    // 执行多条SQL语句:
    insert(); update(); delete();
    // 提交事务:
    conn.commit();
} catch (SQLException e) {
    // 回滚事务:
    conn.rollback();
} finally {
    conn.setAutoCommit(true); // 恢复到初始状态
    conn.close();
}


// 执行多条sql语句：用addBatch()
try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
    try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (name, gender, grade, score) VALUES (?, ?, ?, ?)")) {
        // 对同一个PreparedStatement反复设置参数并调用addBatch():
        for (Student s : students) {
            ps.setString(1, s.name);
            ps.setBoolean(2, s.gender);
            ps.setInt(3, s.grade);
            ps.setInt(4, s.score);
            ps.addBatch(); // 添加到batch
        }
        // 执行batch:
        int[] ns = ps.executeBatch(); // 执行
        for (int n : ns) {
            System.out.println(n + " inserted."); // batch中每个SQL执行的结果数量
        }
    }
}



// JDBC链接池：

/*
JDBC连接池有一个标准的接口javax.sql.DataSource。要使用JDBC连接池，我们必须选择一个JDBC连接池的实现。
常用的JDBC连接池有：

HikariCP
C3P0
BoneCP
Druid


// HikariCP
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>2.7.1</version>
</dependency>

*/


// 链接池：
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:mysql://localhost:3306/learnjdbc");
config.setUsername("learn");
config.setPassword("learnpassword");
config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒
config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒
config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10
DataSource ds = new HikariDataSource(config);
try (Connection conn = ds.getConnection()) {

}



// XML:
// -----------

/*

XML使用嵌套结构的数据表示方式，支持格式验证；
XML常用于配置文件、网络消息传输等。

book.xml:

<?xml version="1.0" encoding="UTF-8" ?>
<book id="1">
    <name>Java核心技术</name>
    <author>Cay S. Horstmann</author>
    <isbn lang="CN">1234567</isbn>
    <tags>
        <tag>Java</tag>
        <tag>Network</tag>
    </tags>
    <pubDate/>
</book>


特殊符号，需要使用&???;表示转义。
例如，Java<tm>必须写成：
<name>Java&lt;tm&gt;</name>

// 特殊字符表示：

<   &lt;
>   &gt;
&   &amp;
"   &quot;
'   &apos;


而合法的XML是指，不但XML格式正确，而且它的数据结构可以被DTD或者XSD验证。

DTD文档可以指定一系列规则，例如：

1.根元素必须是book
2.book元素必须包含name，author等指定元素
3.isbn元素必须包含属性lang
4...


如何验证XML文件的正确性呢？
最简单的方式是通过浏览器验证。
可以直接把XML文件拖拽到浏览器窗口，如果格式错误，浏览器会报错。


XML是一个技术体系，除了我们经常用到的XML文档本身外，XML还支持：

DTD和XSD：验证XML结构和数据是否有效；
Namespace：XML节点和属性的名字空间；
XSLT：把XML转化为另一种文本；
XPath：一种XML节点查询语言；


XML是一种树形结构的文档，它有两种标准的解析API：

DOM：一次性读取XML，并在内存中表示为树形结构；
SAX：以流的形式读取XML，使用事件回调。


*/ 

// 使用DOM API解析一个XML文档的代码如下：

InputStream input = Main.class.getResourceAsStream("/book.xml");
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(input);


// DocumentBuilder.parse()用于解析一个XML，它可以接收InputStream，File或者URL，如果解析无误，我们将获得一个Document对象


/*
SAX:
-----
使用DOM解析XML的优点是用起来省事，但它的主要缺点是内存占用太大。

另一种解析XML的方式是SAX，它是一种基于流的解析方式，边读取XML边解析，并以事件回调的方式让调用者获取数据。
因为是一边读一边解析，所以无论XML有多大，占用的内存都很小。

SAX解析会触发一系列事件：

startDocument：开始读取XML文档；
startElement：读取到了一个元素，例如<book>；
characters：读取到了字符；
endElement：读取到了一个结束的元素，例如</book>；
endDocument：读取XML文档结束。
如果我们用SAX API解析XML，Java代码如下：
*/

InputStream input = Main.class.getResourceAsStream("/book.xml");
SAXParserFactory spf = SAXParserFactory.newInstance();
SAXParser saxParser = spf.newSAXParser();
saxParser.parse(input, new MyHandler());
// 关键代码SAXParser.parse()除了需要传入一个InputStream外，还需要传入一个回调对象，这个对象要继承自DefaultHandler：

class MyHandler extends DefaultHandler {
    public void startDocument() throws SAXException {
        print("start document");
    }

    public void endDocument() throws SAXException {
        print("end document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start element:", localName, qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        print("end element:", localName, qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        print("characters:", new String(ch, start, length));
    }

    public void error(SAXParseException e) throws SAXException {
        print("error:", e);
    }

    void print(Object... objs) {
        for (Object obj : objs) {
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}

/*
Jackson
---------

xml转为javabean

<?xml version="1.0" encoding="UTF-8" ?>
<book id="1">
    <name>Java核心技术</name>
    <author>Cay S. Horstmann</author>
    <isbn lang="CN">1234567</isbn>
    <tags>
        <tag>Java</tag>
        <tag>Network</tag>
    </tags>
    <pubDate/>
</book>

public class Book {
    public long id;
    public String name;
    public String author;
    public String isbn;
    public List<String> tags;
    public String pubDate;
}


先添加两个Maven的依赖：

com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.10.1
org.codehaus.woodstox:woodstox-core-asl:4.4.1

<dependency>
  <groupId>com.fasterxml.jackson.dataformat</groupId>
  <artifactId>jackson-dataformat-xml</artifactId>
  <version>2.10.1</version>
</dependency>
<dependency>
  <groupId>org.codehaus.woodstox</groupId>
  <artifactId>woodstox-core-asl</artifactId>
  <version>4.4.1</version>
</dependency>



@JacksonXmlElementWrapper：可用于指定List等集合类，外围标签名；
@JacksonXmlProperty：指定包装标签名，或者指定标签内部属性名；
@JacksonXmlRootElement：指定生成xml根标签的名字；
@JacksonXmlText：指定当前这个值，没有xml标签包裹

然后，定义好JavaBean，就可以用下面几行代码解析：

*/

InputStream input = Main.class.getResourceAsStream("/book.xml");
JacksonXmlModule module = new JacksonXmlModule();
XmlMapper mapper = new XmlMapper(module);
Book book = mapper.readValue(input, Book.class); //读取xml并返回一个javaBean
System.out.println(book.id);
System.out.println(book.name);
System.out.println(book.author);
System.out.println(book.isbn);
System.out.println(book.tags);
System.out.println(book.pubDate);


/*
JSON:
-------
JSON作为数据传输的格式，有几个显著的优点：

JSON只允许使用UTF-8编码，不存在编码问题；
JSON只允许使用双引号作为key，特殊字符用\转义，格式简单；
浏览器内置JSON支持，如果把数据用JSON发送给浏览器，可以用JavaScript直接处理。

因此，JSON适合表示层次结构，因为它格式简单，仅支持以下几种数据类型：
键值对：{"key": value}
数组：[1, 2, 3]
字符串："abc"
数值（整数和浮点数）：12.34
布尔值：true或false
空值：null


浏览器直接支持使用JavaScript对JSON进行读写：
// JSON string to JavaScript object:
jsObj = JSON.parse(jsonStr);

// JavaScript object to JSON string:
jsonStr = JSON.stringify(jsObj);


常用的用于解析JSON的第三方库有：
Jackson
Gson
Fastjson


jackson maven依赖：
com.fasterxml.jackson.core:jackson-databind:2.10.0


<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.10.0</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.datatype</groupId>
    <artifactId>jackson-datatype-jsr310</artifactId>
    <version>2.10.0</version>
</dependency>
*/

// 反序列化：
InputStream input = Main.class.getResourceAsStream("/book.json");
ObjectMapper mapper = new ObjectMapper();
// 反序列化时忽略不存在的JavaBean属性，这样就不会报错
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
Book book = mapper.readValue(input, Book.class);


// 把JSON解析为JavaBean的过程称为反序列化。
// 如果把JavaBean变为JSON，那就是序列化。
// 要实现JavaBean到JSON的序列化，只需要一行代码：
String json = mapper.writeValueAsString(book);


// 要把JSON的某些值解析为特定的Java对象，例如LocalDate，也是完全可以的。例如：

{
    "name": "Java核心技术",
    "pubDate": "2016-09-01"
}getResourceAsStream
// 要解析为：

public class Book {
    public String name;
    public LocalDate pubDate;
}
// 只需要引入标准的JSR 310关于JavaTime的数据格式定义至Maven：
// com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.0
// 然后，在创建ObjectMapper时，注册一个新的JavaTimeModule：

ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

// 也可以自定义解析格式



/*

gson:
------
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.6</version>
</dependency>



*/

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;


String json1="{'id':302,'name':'三年二班'," +
                "'stus':[{'id':101,'name':'小青蛙','age':16},{'id':102,'name':'小蚂蚁','age':13}]}";
Gson gson = new Gson();

//解析对象：第一个参数：待解析的字符串 第二个参数结果数据类型的Class对象
Grade grade = gson.fromJson(json1,Grade.class);
System.out.println(grade);

// 解析string为list:
String json2="['北京','天津','杭州']";//解析数组
ArrayList<String> list=gson.fromJson(json2, new TypeToken<ArrayList<String>>(){}.getType());



/*
fastjson
---------

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.73</version>
</dependency>

*/

import com.alibaba.fastjson.JSON;

List<UserList> lists =  JSON.parseArray(result,UserList.class);
System.out.println(lists);

/*
监听文件变化：
------------
*/


// 方法一：common-io
/*
<dependency>
  <groupId>commons-io</groupId>
  <artifactId>commons-io</artifactId>
  <version>2.6</version>
</dependency>
<dependency>
  <groupId>log4j</groupId>
  <artifactId>log4j</artifactId>
  <version>1.2.12</version>
</dependency>

*/
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import java.io.File;
import java.util.logging.Logger;
// 新建一个自己的监听类
public class FileListener extends FileAlterationListenerAdaptor{
    private Logger log = Logger.getLogger(String.valueOf(FileListener.class));

    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
        log.info("[目录改变：]"+ directory.getAbsolutePath());
    }

    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
        log.info("[修改：]" + file.getAbsolutePath());
    }

    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        log.info("[创建：]" + file.getAbsolutePath());
    }

    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
        log.info("[删除：]" + file.getAbsolutePath());
    }
}


import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main( String[] args ) throws Exception {
        // 监控目录
        String rootDir = "/Users/captain/Desktop/test";
        // 轮询间隔 5 秒
        long interval = TimeUnit.SECONDS.toMillis(1);
        // 创建过滤器
        IOFileFilter directories = FileFilterUtils.and(
                FileFilterUtils.directoryFileFilter(),
                HiddenFileFilter.VISIBLE);
        IOFileFilter files = FileFilterUtils.and(
                FileFilterUtils.fileFileFilter(),
                FileFilterUtils.suffixFileFilter(".txt"));
        IOFileFilter filter = FileFilterUtils.or(directories, files);
        // 使用过滤器
        FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), filter);
        //不使用过滤器
        //FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));
        observer.addListener(new FileListener());
        //创建文件变化监听器
        FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
        // 开始监控
        monitor.start();
    }
}


IOUtils 与 FileUtils
------------------
/*

<dependency>
  <groupId>commons-io</groupId>
  <artifactId>commons-io</artifactId>
  <version>2.8.0</version>
</dependency>

*/


保存图片：
-------
//获取网络图片通过ImageIO
BufferedImage image = ImageIO.read(new URL(uri));
ImageIO.write(image, "png", new File(savePath));

// 获取网络图片通过get请求
HttpResponse<InputStream> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofInputStream());
BufferedImage image = ImageIO.read(response.body());

// 通过本地图片获取到新的图片
BufferedImage image = ImageIO.read(new File("/Users/captain/Desktop/meinv.png"));
ImageIO.write(image, "png", new File("/Users/captain/Desktop/sansan.png"));
ImageIO.write(image, "png", new File(savePath));




ProcessBuilder和runtime调用cmd或shell:
// ------------------------------

/**
 * public Process exec(String command)-----在单独的进程中执行指定的字符串命令。
 * public Process exec(String [] cmdArray)---在单独的进程中执行指定命令和变量
 * public Process exec(String command, String [] envp)----在指定环境的独立进程中执行指定命令和变量
 * public Process exec(String [] cmdArray, String [] envp)----在指定环境的独立进程中执行指定的命令和变量
 * public Process exec(String command,String[] envp,File dir)----在有指定环境和工作目录的独立进程中执行指定的字符串命令
 * public Process exec(String[] cmdarray,String[] envp,File dir)----在指定环境和工作目录的独立进程中执行指定的命令和变量
 *
 * Runtime run = Runtime.getRuntime();
 * Process p = run.exec("ping 127.0.0.1");
 * InputStream ins= p.getInputStream();
 * InputStream ers= p.getErrorStream();
 * 这两个流要用不同的线程去处理，不然容易引发阻塞
 *
 * cmd命令执行窗口开闭指令
 * cmd /c dir 是执行完dir命令后关闭命令窗口。
 * cmd /k dir 是执行完dir命令后不关闭命令窗口。
 * cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
 * cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。
 * */


import java.io.*;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        runtime();
        processBuilder();
    }

    static void runtime() throws IOException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        Process process;
        if (isWindows) {
            process = Runtime.getRuntime().exec("ipconfig");
        } else {
            process = Runtime.getRuntime().exec("ifconfig");
        }
        InputStream inputStream = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    static void processBuilder() throws IOException {
        Process process = new ProcessBuilder().command("ifconfig").start();
        InputStream in = process.getInputStream();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }
        String str = sb.toString();
        System.out.println(str);
    }
}



junit
-----------
/*
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>


JUnit介绍
https://blog.csdn.net/qq_26295547/article/details/83145642

JUnit 所提供的断言方法:
assertArrayEquals(expecteds, actuals)   查看两个数组是否相等。
assertEquals(expected, actual)  查看两个对象是否相等。类似于字符串比较使用的equals()方法。
assertNotEquals(first, second)  查看两个对象是否不相等。
assertNull(object)  查看对象是否为空。
assertNotNull(object)   查看对象是否不为空。
assertSame(expected, actual)    查看两个对象的引用是否相等。类似于使用“==”比较两个对象。
assertNotSame(unexpected, actual)   查看两个对象的引用是否不相等。类似于使用“!=”比较两个对象。
assertTrue(condition)   查看运行结果是否为true。
assertFalse(condition)  查看运行结果是否为false。
assertThat(actual, matcher) 查看实际值是否满足指定的条件。
fail()  让测试失败。


指定用例执行顺序：
@FixMethodOrder(MethodSorters.DEFAULT)  默认，但不可预期
@FixMethodOrder(MethodSorters.JVM)   按JVM得到的顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)   按方法字母顺序执行

 @Test 的注解：
　　1.@Test: 测试方法
　　　　a)(expected=XXException.class)如果程序的异常和XXException.class一样，则测试通过
　　　　b)(timeout=100)如果程序的执行能在100毫秒之内完成，则测试通过
　　2.@Ignore: 被忽略的测试方法：加上之后，暂时不运行此段代码
　　3.@Before: 每一个测试方法之前运行
　　4.@After: 每一个测试方法之后运行
　　5.@BeforeClass: 方法必须必须要是静态方法（static 声明），所有测试开始之前运行，注意区分before，是所有测试方法
　　6.@AfterClass: 方法必须要是静态方法（static 声明），所有测试结束之后运行，注意区分 @After

*/

//import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JunitDemo1 {

    //assertEquals(expected, actual)查看两个对象是否相等。类似于字符串比较使用的equals()方法。
    @Test
    public void test1() {
        assertEquals(2 + 2, 4);
    }


    //assertArrayEquals(expecteds, actuals) 查看两个数组是否相等。
    int[] list1 = {1};
    int[] list2 = {1};

    @Test
    public void test2() {
        assertArrayEquals(list1, list2);
    }


    //assertNull(object) 查看对象是否为空
    String a = null;

    @Test
    public void test3() {
        assertNull(a);
    }

}




//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;



public class JunitDemo2 {
    @Test
    public void testAdd() {
        Count count = new Count();
        int result = count.add(2, 2);
        assertEquals(result, 4);
    }

    @Test(timeout = 10)
    public void testSub() {
        Count count = new Count();
        int result = count.sub(2, 2);
        assertEquals(result, 0);
    }

    //在当前测试类开始时运行。
    @BeforeClass
    public static void beforeClass() {
        System.out.println("-------------------beforeClass");
    }

    //在当前测试类结束时运行。
    @AfterClass
    public static void afterClass() {
        System.out.println("-------------------afterClass");
    }

    //每个测试方法运行之前运行
    @Before
    public void before() {
        System.out.println("===== each case before");
    }

    //每个测试方法运行之后运行
    @After
    public void after() {
        System.out.println("===== each case after");
    }

}

class Count {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}



参数化测试
----------
/*
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.2.0</version>
    <scope>test</scope>
</dependency>
————————————————

参数化测试
https://blog.csdn.net/ryo1060732496/article/details/80823696
参数化测试使使用不同参数多次运行测试成为可能。它们与常规的@Test方法一样被声明，但是使用 @ParameterizedTest注释。
此外，您必须声明至少一个源，该源将为每个调用提供参数，然后使用测试方法中的参数。
@ValueSource –提供对文字值数组（即整数，字符串等）的访问。
@CsvSource –从一个或多个提供的CSV行中读取逗号分隔值（CSV）
@CsvFileSource –用于加载逗号分隔值（CSV）文件
@EnumSource
@MethodSource
 */

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


public class ParameterTest {
    //@CsvFileSource允许您使用类路径中的CSV文件。CSV文件中的每一行都会调用一次参数化测试。
    @ParameterizedTest
    @CsvFileSource(resources = "/ADD.csv", numLinesToSkip = 1, delimiter = ',')
    //numLinesToSkip忽略几行，delimiter默认为','
    public void testCsvAdd(int a, int b, int c) {
        Count count = new Count();
        int result = count.add(a, b);
        assertEquals(result, c);
    }

    //@ValueSource –提供对文字值数组（即整数，字符串等）的访问。
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testNum(int a) {
        assertTrue(a > 0);
    }

    //@CsvSource允许将参数列表表示为逗号分隔的值
    @ParameterizedTest
    @CsvSource({"1,2", "5,5"})
    public void testSub(int a, int b) {
        Count count = new Count();
        int result = count.sub(a, b);
        assertEquals(result, 0);
    }
}


/*
测试报告：
https://blog.csdn.net/AOBO516/article/details/90451236
Java更好用的测试报告：
extentreports
allure2
*/



selenium
-----------
/*
<dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.141.59</version>
</dependency>


下载谷歌驱动“chromedriver.exe”
下载地址：https://npm.taobao.org/mirrors/chromedriver/
java+selenium元素定位和元素操作
https://www.cnblogs.com/peachh/p/9740001.html


   driver.get(Url);//启动浏览器打开url
   driver.manage().window().maximize(); //浏览器最大化
　　driver.navigate().to("http://www.baidu.com"); //打开百度
　　driver.navigate().refresh();//刷新浏览器
　　driver.navigate().back();//浏览器后退
　　driver.navigate().forward();//浏览器前进
　　driver.close();//关闭当前页面
　　driver.quit();//关闭所有窗口


    getText(): 获取元素的visible内嵌文字。
    getAttribute(String name)：获取元素中名为name的属性的值。
      <input attr1='a'>foo</input>
    getAttribute(attr1) 你得到’a’
    getText() 没有参数，你只能得到’foo’
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        testSelenium();
    }
    public static String testSelenium() throws InterruptedException {
        String re;
        System.setProperty("webdriver.chrome.driver", "/Users/captain/Downloads/pkg/chromedriver");
        WebDriver driver = new ChromeDriver();
        String url = "http://www.baidu.com";
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys("渣男");
        driver.findElement(By.id("su")).click();
        Thread.sleep(3);
        re = driver.findElement(By.xpath("//*[@id=\"u\"]/a[3]")).getAttribute("href");
        Thread.sleep(3000);
        driver.close();
        driver.quit();
        return re;

    }
}



log4j
--------
/*
https://www.scalyr.com/blog/maven-log4j2-project/


    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-api</artifactId>
      <version>2.14.0</version>
    </dependency>
    <dependency>
      <groupId>org.apache.logging.log4j</groupId>
      <artifactId>log4j-core</artifactId>
      <version>2.14.0</version>
    </dependency>


*/


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class seleniumDemo {
    private static final Logger logger = LogManager.getLogger(seleniumDemo.class); //类前声明

    public static void main(String[] args) throws InterruptedException {
        // main中使用
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.error("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");
    }
}


log4j2.xml
------------
/*
1.可以分开定义输出和日志的格式，和日志等级，也可以统一定义
2.可以把所有日志写入到一个文件，也可以进行分片
*/

<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
    <Appenders>
        <Console name="ConsoleAppender" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
        </Console>
        <File name="FileAppender" fileName="application-${date:yyyyMMdd}.log" immediateFlush="false" append="true">
            <PatternLayout pattern="%d{yyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </File>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <AppenderRef ref="ConsoleAppender" />
            <AppenderRef ref="FileAppender" />
        </Root>
    </Loggers>
</Configuration>



<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
    <Properties>
        <!-- 定义日志格式 -->
        <Property name="log.pattern">%d{MM-dd HH:mm:ss.SSS} [%t] [%-5level] %logger{36} line:%L %M: %msg%n%n</Property>
        <!-- 定义文件名变量 -->
        <Property name="file.err.filename">log/err.log</Property>
        <Property name="file.err.pattern">log/err.%i.log.gz</Property>
    </Properties>
    <!-- 定义Appender，即目的地 -->
    <Appenders>
        <!-- 定义输出到屏幕 -->
        <Console name="console" target="SYSTEM_OUT">
            <!-- 日志格式引用上面定义的log.pattern -->
            <PatternLayout pattern="${log.pattern}" />
        </Console>
        <!-- 定义输出到文件,文件名引用上面定义的file.err.filename -->
        <RollingFile name="err" bufferedIO="true" fileName="${file.err.filename}" filePattern="${file.err.pattern}">
            <PatternLayout pattern="${log.pattern}" />
            <Policies>
                <!-- 根据文件大小自动切割日志 -->
                <SizeBasedTriggeringPolicy size="1 MB" />
            </Policies>
            <!-- 保留最近10份 -->
            <DefaultRolloverStrategy max="10" />
        </RollingFile>
    </Appenders>
    <Loggers>
        <Root level="debug">
            <!-- 对info级别的日志，输出到console -->
            <AppenderRef ref="console" level="debug" />
            <!-- 对error级别的日志，输出到err，即上面定义的RollingFile -->
            <AppenderRef ref="err" level="info" />
        </Root>
    </Loggers>
</Configuration>
