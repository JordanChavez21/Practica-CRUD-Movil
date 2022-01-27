package singleton;

import conexiondb.Conexion;

//Clase con patron Singleton
public class ConexionSingleton {

    private static ConexionSingleton conexionSingleton;
    private Conexion conexion;

    //Constructor privado
    private ConexionSingleton(String url,String user,String password) {

        conexion = new Conexion(url,user,password);

    }

    //Metodo de clase, con retorno de la clase ConexionSingleton
    public static ConexionSingleton getInstance(String url,String user,String password) {
        if (conexionSingleton == null){
            conexionSingleton = new ConexionSingleton(url,user,password);
        }
        return conexionSingleton;
    }

    public Conexion getConexion() {
        return conexion;
    }
    
}
