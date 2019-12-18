package edu.dao;

import edu.dao.jdbc.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IdiomDao {
    public List<String> getIdiom(String s){
        ArrayList<String> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {

             /*
            查询成语信息
            用户:一心一意
            数据库:匹配"意"字开头的成语
            */
            conn = DB.getConnection();
            String sql = "select * from tb_chengyu where chengyu like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,s+'%');
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getString("chengyu"));
            }

            if(conn!=null)conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
