package datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    private static final String JDBC_BD = "control-clientes";
    private static final String JDBC_REQUERIMIENTOS = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "spacecodee";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/" + Conexion.JDBC_BD + Conexion.JDBC_REQUERIMIENTOS;

    public Conexion() {

    }

    public static DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl(Conexion.JDBC_URL);
        ds.setUsername(Conexion.JDBC_USER);
        ds.setPassword(Conexion.JDBC_PASSWORD);
        ds.setInitialSize(50);
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return Conexion.getDataSource().getConnection();
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }

    public static void close(Connection con) {
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }
}
