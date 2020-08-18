package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestGetid {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql = "insert into hero values(null,?,?,?)";
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
            Statement s = c.createStatement();
            PreparedStatement ps = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ){
            ps.setString(1,"吕布");
            ps.setFloat(2,513);
            ps.setInt(3,60);
            //执行语句
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int id = -1;
            if(rs.next()){
                id = rs.getInt(1);
                System.out.println("获取的id数据是" + id);
            }
            int temp = id - 1;
            String delete_sql = "delete from hero where id =" + temp;
            while (true){
                String sql1 = "select id from hero where id=" + temp;
                ResultSet rs1 = ps.executeQuery(sql1);
                if (rs1.next()){
                    s.execute(delete_sql);
                    System.out.println("前一条数据删除成功");
                    break;
                }
                temp --;
            }
        }catch (SQLException e){
            e.printStackTrace();;
        }
    }
}
