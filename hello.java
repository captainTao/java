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
// int[] ns = new int[]{1,2,3,4,5}
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


// 可变参数：
可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null。
class Group {
    private String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
}


基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方


// 构造方法：
1.如果一个类没有定义构造方法，编译器会自动为我们生成一个默认构造方法，它没有参数，也没有执行语句.
class Person {
    public Person() {
    }
}
2.如果我们自定义了一个构造方法，那么，编译器就不再自动创建默认构造方法
3.如果既要能使用带参数的构造方法，又想保留不带参数的构造方法，那么只能把两个构造方法都定义出来
4.没有在构造方法中初始化字段时，引用类型的字段默认是null，数值类型的字段用默认值，int类型默认值是0，布尔类型默认值是false：
5.一个构造方法可以调用另外一个构造方法

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

继承,多态，组合
------------
/*
1.如果父类没有默认的构造方法，子类就必须显式调用super()并给出参数以便让编译器定位到父类的一个合适的构造方法。
2.即子类不会继承任何父类的构造方法。子类默认的构造方法是编译器自动生成的，不是继承的。
*/
class Person {
    protected String name;  //protected是子类可以访问，main不能访问；private是只能父类访问
    protected int age;
    protected int score;

    public Student(String name, int age, int score) {
        super(); // 自动调用父类的构造方法
        this.score = score;
    }
    public void run() {
        System.out.println("Person.run");
    }
}
class Student extends Person {
    protected int score;

    public String hello() {
        return "Hello, " + name; // super.name; this.name
    }
    public Student(String name, int age, int score) {
        super(name, age); // 调用父类的构造方法Person(String, int)
        this.score = score;
    }
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}


// Override和Overload不同的是，如果方法签名如果不同，就是Overload，Overload方法是一个新方法；如果方法签名相同，并且返回值也相同,就是Override。
// 注意：方法名相同，方法参数相同，但方法返回值不同，也是不同的方法。在Java程序中，出现这种情况，编译器会报错。

instanceof
-----------
为了避免向下转型出错，Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型：

Student s = new Student();
System.out.println(s instanceof Person); // true
System.out.println(s instanceof Student); // true

Student n = null;
System.out.println(n instanceof Student); // false


// 向上转型和向下转型：
Person p = new Student();
if (p instanceof Student) {
    // 只有判断成功才会向下转型:
    Student s = (Student) p; // 一定会成功
}


toString()：把instance输出为String；
equals()：判断两个instance是否逻辑相等；
hashCode()：计算一个instance的哈希值。


在必要的情况下，我们可以覆写Object的这几个方法。例如：

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

// 调用super()
class Person {
    protected String name;
    public String hello() {
        return "Hello, " + name;
    }
}

Student extends Person {
    @Override
    public String hello() {
        // 调用父类的hello()方法:
        return super.hello() + "!";
    }
}



// final
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



抽象类
-------
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

接口： // 更高级的抽象类，更像是声明，或者协议
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
接口继承:
interface Hello {
    void hello();
}

interface Person extends Hello {
    void run();
    String getName();
}


static:
----------
1.用static修饰的字段，称为静态字段
2.所有实例都会共享该字段
3.静态字段并不属于实例
4.一般用： 类名.静态字段来访问静态对象
// System.out.println(Person.number);
5.静态方法不需要实例化，好比oc的类方法
// Person.setNumber(99);
6.静态方法经常用于工具类。例如：
// Arrays.sort()
// Math.random()
7.也经常用于辅助方法。注意到Java程序的入口main()也是静态方法。

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
8.接口的静态字段
public interface Person {
    // 编译器会自动在定义字段前面加上public statc final:
    int MALE = 1;
    int FEMALE = 2;
}
9.静态类
static class xx{..}


import:
----------
1.不用public、protected、private修饰的字段和方法就是包作用域
2.编译javac -d ../bin ming/Person.java hong/Person.java mr/jun/Arrays.java
3.
//import
// Person.java
package ming;
// 导入完整类名:
import mr.jun.Arrays;
// 导入mr.jun包的所有class,但不包括子包的class:
import mr.jun.*;

4.
// import static
package main;
// 导入System类的所有静态字段和静态方法:
import static java.lang.System.*;
public class Main {
    public static void main(String[] args) {
        // 相当于调用System.out.println(…)
        out.println("Hello, world!");
    }
}
5.默认导入系统类 import java.lang.*

/*
Java内建的访问权限包括public、protected、private和package权限；
final修饰符不是访问权限，它可以修饰class、field和method；
一个.java文件只能包含一个public类，但可以包含多个非public类。
如果有public类，文件名必须和public类的名字相同。
*/


jar
-------
jar包里的第一层目录，不能是bin
/*
JVM通过环境变量classpath决定搜索class的路径和顺序；

不推荐设置系统环境变量classpath，始终建议通过-cp命令传入；

jar包相当于目录，可以包含很多.class文件，方便下载和使用；

MANIFEST.MF文件可以提供jar包的信息，如Main-Class，这样可以直接运行jar包。

java标准库rt.jar,60M左右

打包成jar可以借助Maven
*/
JDK9引入模块概念，.jmod扩展名标识，可以在 $JAVA_HOME/jmods 目录下找到他们


String
--------
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

// 是否包含子串:
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
s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

// 分割
String s = "A,B,C,D";
String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}

// 拼接
String[] arr = {"A", "B", "C"};
String s = String.join("***", arr); // "A***B***C"


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

字符编码：
---------
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

Java使用Unicode编码表示String和char；


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

StringBuilder和StringBuffer接口完全相同，现在完全没有必要使用StringBuffer
StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作
StringBuilder是可变对象，用来高效拼接字符串；
StringBuilder可以支持链式操作，实现链式操作的关键是返回实例本身；
StringBuffer是StringBuilder的线程安全版本，现在很少使用。

要高效拼接字符串，应该使用StringBuilder。
StringJoiner内部实际上就是使用了StringBuilder，所以拼接效率和StringBuilder几乎是一模一样的。
import java.util.StringJoiner;
public class Main {
    public static void main(String[] args) {
        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", "); // Bob, Alice, Grace
        var sj = new StringJoiner(", ", "Hello ", "!"); // Hello Bob, Alice, Grace!
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }
}

// String.join()
String[] names = {"Bob", "Alice", "Grace"};
var s = String.join(", ", names);


// 数据类型
Java的数据类型分两种：
基本类型：byte，short，int，long，boolean，float，double，char
引用类型：所有class和interface类型

引用类型可以赋值为null，表示空，但基本类型不能赋值为null：

// 基本类型转为引用类型
boolean ------ java.lang.Boolean  //加上java.lang.xx


枚举
class FreshJuice {
   enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
   FreshJuiceSize size;
}
 
public class FreshJuiceTest {
   public static void main(String []args){
      FreshJuice juice = new FreshJuice();
      juice.size = FreshJuice.FreshJuiceSize.MEDIUM  ;
   }
}