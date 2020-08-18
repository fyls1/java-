package jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestHerosql {
    public static void add(Hero h){
        Hero hero = null;
        String sql = "insert into hero values(null,?,?,?)";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
            PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.execute();
            System.out.println("增加一条数据");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void delete(Hero h){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
        Statement s = c.createStatement();){
            String sql = "delete from hero where id=" + h.id;
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void update(Hero h){
        String sql = "update hero set name = ?,hp = ?, damage = ? where id = ?";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
        PreparedStatement ps = c.prepareStatement(sql);){
            ps.setString(1,h.name);
            ps.setFloat(2,h.hp);
            ps.setInt(3,h.damage);
            ps.setInt(4,h.id);
            ps.execute();
            System.out.println("将id为"+h.id+"的数据更新到数据库");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static List<Hero> list(){
        List<Hero> hlist = new ArrayList<Hero>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
        Statement s = c.createStatement();){
            String sql = "select * from hero";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                Hero h = new Hero();
                h.id = rs.getInt(1);
                h.name = rs.getString(2);
                h.hp = rs.getFloat(3);
                h.damage = rs.getInt(4);
                hlist.add(h);
            }
            System.out.println("一共有"+hlist.size()+"个数据");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return hlist;
    }
    public static Hero get(int id) {
        Hero hero = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8","root", "12345678");
             Statement s = c.createStatement();) {

            String sql = "select * from hero where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            // 因为id是唯一的，ResultSet最多只能有一条记录
            // 所以使用if代替while
            if (rs.next()) {
                hero = new Hero();
                String name = rs.getString(2);
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                hero.name = name;
                hero.hp = hp;
                hero.damage = damage;
                hero.id = id;
                System.out.println("取出id=" + id + "的数据,它的name是:");
                System.out.println(hero.name);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hero;

    }
    public static void main(String[] args) {
        Hero h = new Hero();
        list();
        h.damage = 555;
        add(h);
        list();
        h = get(53);
        h.name = "英雄52";
        h.id = 53;
        update(h);
        h = get(53);
        h.id = 53;
        delete(h);
        list();
    }
}
