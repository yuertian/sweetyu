//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//
//import javax.sql.DataSource;
//import java.sql.*;
//
//public class DBUtil {
//
//    private static final String URL = "jdbc:mysql://localhost:3306/test";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";
//
//    private  static DataSource DATASOURCE = new MysqlDataSource();
//    static {
//        ((MysqlDataSource)DATASOURCE).setURL(URL);
//        ((MysqlDataSource)DATASOURCE).setUser(USERNAME);
//        ((MysqlDataSource)DATASOURCE).setPassword(PASSWORD);
//    }
//
//    private  static DataSource DATASOURCE2;
//
//    private DBUtil() {//私有的构造方法
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getConnection1());
//        System.out.println(getConnection2());
//        System.out.println(getDataSource());
//    }
//
//    /**
//     * DriverManager 方式获取数据库连接
//     * @return
//     */
//    public static Connection getConnection1() {
//        Connection connection = null;
//        try {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            } finally {
//                connection.close();
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    /**
//     * DataSource 静态变量 + 静态代码块的方式
//     * @return
//     */
//    public static  Connection getConnection2() {
//        try {
//            return DATASOURCE.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("数据库连接失败");
//        }
//    }
//
//    /**
//     * 单例模式
//     * @return
//     */
//    public static DataSource getDataSource() {
//        if (DATASOURCE2 == null) {
//            DATASOURCE2 = new MysqlDataSource();
//            ((MysqlDataSource)DATASOURCE2).setURL(URL);
//            ((MysqlDataSource)DATASOURCE2).setUser(USERNAME);
//            ((MysqlDataSource)DATASOURCE2).setPassword(PASSWORD);
//        }
//        return DATASOURCE2;
//    }
//
//    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
//        try {
//            if (resultSet != null) {
//                resultSet.close();
//            }
//            if (statement != null) {
//                statement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("数据库释放资源失败");
//        }
//    }
//}
