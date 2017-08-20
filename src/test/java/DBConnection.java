import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver.*;


/**
 * Created by acedric on 20/04/2017.
 */
public class DBConnection {
    public static void main(String[] args) {


//        String url = "jdbc:sqlserver://slqv-grp-sql01:1433;databaseName=SISTraderQA;failoverPartner=mkqv-grp-sql01";
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SqlServerDriver").newInstance();
//            conn = DriverManager.getConnection(url);
//            System.out.println(" Connection Established ");
//
//            String sql = " SELECT * FROM AUDIT ";
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//
//            while (rs.next()){
//                System.out.println(rs.getString(1)+ "   " + rs.getString(2) + " " + rs.getString(3) +" "+ rs.getString(4))  ;
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "testing";
        String username = "root";
        String password = "";

        //connect to DB
        //send queries
        //disconnect its a must

        try {
            //connect to DB
            Class.forName(driver).newInstance(); // create object of Driver
            conn = DriverManager.getConnection(url+dbName,username,password);
            System.out.println(conn.isClosed());

            // queries
            /**************************************************/
            Statement st = conn.createStatement();
            // can not use conditional statement using the below code
            ResultSet rs = st.executeQuery("select * from EMPLOYEE");
            while (rs.next()){
                System.out.println(rs.getString("Name") +" "+ rs.getString("Place") +" "+ rs.getInt("Age"));
            }



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if ((conn !=null) && (!conn.isClosed())){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
