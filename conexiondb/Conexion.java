package conexiondb;

//Paquetes para la conexion con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Connection connection;
    private Statement statement;

    public Conexion(String url, String user, String password){

        //Llamar la clase de la conexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Metodo para instrucciones CRUD
    public void ejecutar(String sql)throws SQLException{
        connection.createStatement().execute(sql);
    }

    //Metodo para el select
    public ResultSet query(String sqlQuery) throws SQLException{
        this.statement = connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }

}
