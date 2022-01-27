import java.sql.ResultSet;
import java.sql.SQLException;

import singleton.ConexionSingleton;

public class Main {
    
    public static void main(String[] args){
        try {
        /**-------------------------------------------------------------------------------------------------------------- */
        //Creacion de objeto singleton
        System.out.println("Esta es la tabla Ciudadano");
        //Tabla ciudadanos
        ConexionSingleton conn = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ejemplo",
            "jordan",
            "inicio01");
            //Creamos elempleado Raul
            conn.getConexion().ejecutar("insert into ciudadano values ('Pamela Cardoza')");
            //Eliminamos el usuario Jordan para que no se repita
            conn.getConexion().ejecutar("delete from ciudadano where nombre = 'Gabriel Olivas'");
            //Actualizamos el usuario Raul para que se llame Jordan
            conn.getConexion().ejecutar("update ciudadano set nombre = 'Gabriel Olivas' where nombre = 'Pamela Cardoza'");
            //Variable que guarda la informacion de la tabla que nos proporciona el query del INSERT
            ResultSet rs = conn.getConexion().query("select * from ciudadano");
            //While para imprimir la informacion de la tabla
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            System.out.println("Esta es la tabla Empleados");
        /**------------------------------------------------------------------------------------------------------------ */    
        //Tabla empleados
        ConexionSingleton conn2 = ConexionSingleton.getInstance(
            "jdbc:mysql://localhost:3306/ejemplo",
            "jordan",
            "inicio01");
            //Creamos elempleado Raul
            conn2.getConexion().ejecutar("insert into empleados values ('Raul','24')");
            //Eliminamos el usuario Jordan para que no se repita
            conn2.getConexion().ejecutar("delete from empleados where nombre = 'Jordan'");
            //Actualizamos el usuario Raul para que se llame Jordan
            conn2.getConexion().ejecutar("update empleados set nombre = 'Jordan' where nombre = 'Raul'");
            //Variable que guarda la informacion de la tabla que nos proporciona el query del INSERT
            ResultSet rs2 = conn2.getConexion().query("select * from empleados");
            //While para imprimir la informacion de la tabla
            while (rs2.next()) {
                System.out.println(rs2.getString("nombre")+"  "+rs2.getString("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }       
        
    }
}
