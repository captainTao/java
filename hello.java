/*
??
1. set如何取值？
*/


Java SE：Standard Edition
Java EE：Enterprise Edition
Java ME：Micro Edition

JDK：Java Development Kit
JRE：Java Runtime Environment

JSR规范：Java Specification Request
JCP组织：Java Community Process

RI：Reference Implementation
TCK：Technology Compatibility Kit


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
nteger.parseInt(String s);



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

Weekday.SUN.name()  // "SUN",枚举的原型值
Weekday.MON.ordinal(); // 1，枚举的下标，从0开始



异常处理
----------
try{
    ....
}catch(Exception e){
    ....
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



Random类：
----------

public boolean nextBoolean() // true, false各50%概率
public double nextDouble() // 数值介于[0,1.0)之间
public int nextInt() // 该值介于int的区间，也就是-231到231-1之间
public int nextInt(int n) // 该值介于[0,n)的区间
public void setSeed(long seed)  // 跟new Random(long seed)一致

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
        System.out.println(map.get(new Student("Bob", 66))); // null?
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
        System.out.println(map.get(new Student("Bob", 66))); // null?
    }
}

// 实现Comparable接口
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
    字节流接口：InputStream/OutputStream；
    字符流接口：Reader/Writer。
*/


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

// 创建和删除文件：
File file = new File("/path/to/file");
if (file.createNewFile()) {
    // 文件创建成功:
    // TODO:
    if (file.delete()) {
        // 删除文件成功:
    }
}



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



// Java标准库还提供了一个Path对象，它位于java.nio.file包。Path对象和File对象类似，但操作更加简单
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