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
