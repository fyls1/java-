package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Testcommit {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
             Statement s_select = c.createStatement();Statement s_delete = c.createStatement();) {

            // 有事务的前提下
            // 在事务中的多个操作，要么都成功，要么都失败
            c.setAutoCommit(false);
            String sql = "select *from hero limit 0,10";
            ResultSet rs = s_select.executeQuery(sql);
            int id = 0;
//            for(int count = 0;count<10;count++){
            while (rs.next()){
                id = rs.getInt(1);
                System.out.println("试图删除id为"+id+"的数据");
                s_delete.execute("delete from hero where id="+id);
            }
//            }N
            String input = null;
            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("确定要删除前十条数据吗？ Y/N");
                input = scanner.nextLine();
                if (input.equals("Y")){
                    c.commit();
                    System.out.println("删除成功");
                    break;
                }else if(input.equals("N")){
                    System.out.println("取消删除");
                    break;
                }
            }


            // 手动提交
            c.commit();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}