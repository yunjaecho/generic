import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by USER on 2017-03-30.
 */
public class Main {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@//192.168.100.67:1521/afct";
        //String url = "jdbc:oracle:oci8:@afct",\"아이디\",\"패스워드\");
        String username = "ateat";
        String password = "atqwaszx12";



        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);

            System.out.println(conn.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
