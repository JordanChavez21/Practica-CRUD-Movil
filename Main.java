import java.sql.ResultSet;
import java.sql.SQLException;

import singleton.ConexionSingleton;

public class Main {
    
    public static void main(String[] args){
        try {
        //Creacion de objeto singleton
        System.out.println("Esta es la tabla Ciudadano");
        //Tabla ciudadanos
        ConexionSingleton conn = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ejemplo",
            "jordan",
            "inicio01");
            //conn.getConexion().ejecutar("insert into ciudadano values ('Pamela Cardoza')");
            ResultSet rs = conn.getConexion().query("select * from ciudadano");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            System.out.println("Esta es la tabla Empleados");
        //Tabla empleados
        ConexionSingleton conn2 = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ejemplo",
            "jordan",
            "inicio01");
            //conn2.getConexion().ejecutar("insert into empleados values ('Pamela','22')");
            ResultSet rs2 = conn2.getConexion().query("select * from empleados");
            while (rs2.next()) {
                System.out.println(rs2.getString("nombre")+"  "+rs2.getString("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        
    }
}
