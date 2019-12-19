//import com.mysql.jdbc.Util;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class QueryBorrow {
///**
//   * 新增貂蝉同学的借阅记录：诗经，从2019年9月25日17:50到2019年10月25日17:50
//   */
//    public static void main(String[] args) {
//        Connection connection = null;
//     PreparedStatement preparedStatement = null;
//     try {
//    connection = Util.getConnection();
//     String sql = "insert into borrow_info(book_id, student_id," +
//          " start_time, end_time) select b.id,s.id,?,?" +
//          " from book b,student s where b.name=? and s.name=?";
//     preparedStatement = connection.prepareStatement(sql);
//     preparedStatement.setTimestamp(1, Util.getTimestamp("2019-09-25
//                    17:50:00"));
//     preparedStatement.setTimestamp(2, Util.getTimestamp("2019-10-25
//                    17:50:00"));
//     preparedStatement.setString(3, "诗经");
//     preparedStatement.setString(4, "貂蝉");
//     System.out.println(preparedStatement);
//      int result = preparedStatement.executeUpdate();
//     System.out.println(result);
//   } catch (SQLException e) {
//     e.printStackTrace();
//   } finally {
//     Util.close(null, preparedStatement, connection);
//   }
// }
//}
