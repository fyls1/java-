package jdbc;
import java.sql.*;

public class Testselect {
    public static void main(String[] args) {
        listfind(0,5);
    }
    public static void listfind(int d1,int d2){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8",
                "root", "12345678");
            Statement s = c.createStatement();){
            System.out.println("获取到对象"+s);
            String sql = "select * from hero limit " + d1 + "," + d2;
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                float hp = rs.getFloat(3);
                int damage = rs.getInt("damage");
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }
            System.out.println("执行sql语句操作成功");
            }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
