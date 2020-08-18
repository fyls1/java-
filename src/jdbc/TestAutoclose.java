package jdbc;

import java.sql.*;

public class TestAutoclose {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql0 = "insert into hero values(null,?,?,?)";
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                        "root", "12345678");
                Statement s = c.createStatement();
                PreparedStatement ps = c.prepareStatement(sql0);
        )
        {   for (int i=50;i<100;i++){
            String name = "'英雄" + i +"'";
//            String sql = "insert into hero values(null," + name + "," + 313.0f + "," + 50 + ")";
//            s.execute(sql);
            ps.setString(1,name);
            ps.setFloat(2,313.0f);
            ps.setInt(3,50);
            ps.execute();
        }
        System.out.println("执行sql语句操作成功");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}