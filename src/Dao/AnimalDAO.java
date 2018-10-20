package Dao;


import Model.Animal;
import Variables.Variaveis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Skalybuhr
 */
public class AnimalDAO {
    
    public static Connection conmysql;
    public static PreparedStatement psmt;
    public static ResultSet rs;
    public static String sql;
    
    public static boolean Cadastrar_Animal(Animal animal){
        sql = "Insert into " + Variaveis.TB_ANIMAL + " (nome, especie, raca, proprietario, nascimento, cadastro, sexo, status) "
                + "values (?,?,?,?,?,?,?,?)";
        try {            
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            psmt.setString(1, animal.getNome());
            psmt.setString(2, animal.getEspecie());
            psmt.setString(3, animal.getRaca());
            psmt.setInt(4, animal.getProprietario().getId());
            psmt.setDate(5, new java.sql.Date(animal.getNascimento().getTime()));
            psmt.setDate(6, new java.sql.Date(animal.getCadastro().getTime()));
            psmt.setString(7, animal.getSexo());
            psmt.setString(8, animal.getStatus());
            psmt.execute();
            psmt.close();
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        }
    }
    
}
