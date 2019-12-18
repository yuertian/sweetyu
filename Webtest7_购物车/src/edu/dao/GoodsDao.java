package edu.dao;

import edu.dao.jdbc.DB;
import edu.entity.Goods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class GoodsDao {
    public HashMap getAllGoods(){
        HashMap<Integer, Goods> hm = new HashMap<>();

        //准备连接数据库
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        try {
            //查询商品信息
            conn = DB.getConnection();
            String sql = "select * from goods";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Goods goods = new Goods();
                goods = new Goods();
                goods.setGid(rs.getInt("gid"));
                goods.setGname(rs.getString("gname"));
                goods.setPrice(rs.getDouble("price"));

                //放入数据容器中
                hm.put(goods.getGid(),goods);

            }
            if(conn!=null)conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hm;
    }
}
