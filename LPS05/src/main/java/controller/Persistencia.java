package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persistencia {
    private static Connection conexao = null;
    
    private Persistencia(){
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro?user=vitor&password=12345678");
        } catch (SQLException ex) {
            System.out.println("Não foi possível conectar ao bando de dados" + ex);
        }
    }
    
    public static Connection conectar() throws ClassNotFoundException{
        if (conexao == null){
            new Persistencia();
        }
        return conexao;
    }
    
    public static void desconectar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
