package org.junit;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/*
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