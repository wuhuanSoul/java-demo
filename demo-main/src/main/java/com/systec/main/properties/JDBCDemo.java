package com.systec.main.properties;

import java.sql.*;

/**
 * Created by wh on 10/20/2017.
 */
public class JDBCDemo {
    public static void main(String[] args) {
        try {
            String username = "root";
            String password = "systec";
            String url = "jdbc:mysql://192.168.22.158:3306/syvcm_fg";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement("select * from tb_user");
            ResultSet rs = statement.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            statement.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
