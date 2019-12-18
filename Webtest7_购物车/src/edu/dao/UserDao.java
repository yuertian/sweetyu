package edu.dao;

import edu.dao.jdbc.DB;
import edu.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

public class UserDao {
    public User getUser(String username){
        User user =null;
        //准备连接数据库
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            //查询用户信息
            conn = DB.getConnection();
            String sql = "select * from user where username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            rs.next();
            user = new User();
            user.setUid(rs.getInt("uid"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));

            if(conn!=null)conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public int createUser(String username,String password){
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;  //判断是否插入成功
        try {
            //查询用户信息
            conn = DB.getConnection();
            String sql = "insert into user(username,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            count=ps.executeUpdate();
            if(conn!=null)conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return count;
    }


    /*
     判断用户名是否存在于数据库
     */
    public int userIsExit(String username){
        int i;
        ArrayList<String> nameList = new ArrayList<>();
        //准备连接数据库
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            //查询用户信息
            conn = DB.getConnection();
            String sql = "select username from user ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                nameList.add(rs.getString("username"));
            }
            if(conn!=null)conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        i = Collections.binarySearch(nameList,username);
        return i;
    }
}
