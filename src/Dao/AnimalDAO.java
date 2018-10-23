package Dao;

import Model.Animal;
import Model.Cliente;
import Variables.Variaveis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static boolean Cadastrar_Animal(Animal animal) {
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
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } finally {
            conexaomysql.closeConnection(conmysql, psmt);
        }
    }

    public List<Animal> Listar_Animais() {
        List<Animal> animais = new ArrayList();

        sql = "Select * from " + Variaveis.TB_ANIMAL;

        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                Cliente cliente = new Cliente();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                cliente.setId(rs.getInt("proprietario"));
                animal.setProprietario(cliente);
                animal.setNascimento(rs.getDate("nascimento"));
                animal.setCadastro(rs.getDate("cadastro"));
                animal.setSexo(rs.getString("sexo"));
                animal.setStatus("status");
                animais.add(animal);
            }

        } catch (Exception ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexaomysql.closeConnection(conmysql, psmt, rs);
        }

        return animais;
    }

    public static boolean Atualizar_Animal(Animal animal) {
        sql = "Update " + Variaveis.TB_ANIMAL + " set nome = ?, especie = ?, raca = ?, proprietario = ?, nascimento = ?,"
                + " cadastro = ?, sexo = ?, status = ? where id = ?";
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
            psmt.setInt(9, animal.getId());
            psmt.executeUpdate();
            return true;

        } catch (Exception error) {
            JOptionPane.showMessageDialog(null, error);
            return false;
        } finally {
            conexaomysql.closeConnection(conmysql, psmt);
        }
    }

    public static boolean Deletar_Animal(Animal animal) {

        sql = "Delete from " + Variaveis.TB_ANIMAL + " where id = ?";

        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            psmt.setInt(1, animal.getId());
            psmt.execute();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            conexaomysql.closeConnection(conmysql, psmt);
        }
    }
    
    public List<Animal> Buscar_Animal_Id(Animal a) {
        List<Animal> animais = new ArrayList();

        sql = "Select * from " +Variaveis.TB_ANIMAL+" where id = ?";

        try {
            conmysql = conexaomysql.conectabdmysql();
            psmt = conmysql.prepareStatement(sql);
            psmt.setInt(1, a.getId());
            rs = psmt.executeQuery();

            while (rs.next()) {
                Animal animal = new Animal();
                Cliente cliente = new Cliente();
                animal.setId(rs.getInt("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                cliente.setId(rs.getInt("proprietario"));
                animal.setProprietario(cliente);
                animal.setNascimento(rs.getDate("nascimento"));
                animal.setCadastro(rs.getDate("cadastro"));
                animal.setSexo(rs.getString("sexo"));
                animal.setStatus("status");
                animais.add(animal);
            }

        } catch (Exception ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexaomysql.closeConnection(conmysql, psmt, rs);
        }

        return animais;
    }

}
