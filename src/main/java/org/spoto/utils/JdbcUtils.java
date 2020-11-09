package org.spoto.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 数据库连接工具
 */
public class JdbcUtils {

    // jdbc:mysql://spoto-edu:11010/class_202?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai

    /**
     * 获取连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.连接数据库
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://spoto-edu:11010/class_106?characterEncoding=utf8",
                    "spoto",
                    "spoto321"
            );
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭资源
     *
     * @param con 连接
     * @param ps  PreparedStatement
     */
    public static void close(Connection con, PreparedStatement ps) {
        close(con, ps, null);
    }

    /**
     * 关闭资源
     *
     * @param con 连接
     * @param ps  PreparedStatement
     * @param rs  ResultSet
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        // 6.关闭
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
