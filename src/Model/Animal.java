package Model;

import java.util.Date;

/**
 *
 * @author Skalybuhr
 */
public class Animal {

    public Integer id;
    public String nome;
    public String especie;
    public String raca;
    public Cliente proprietario;
    public Date nascimento;
    public Date cadastro;
    public String sexo;
    public String status;

    public Animal() {
    }

    public Animal(Integer id, String nome, String especie, String raca, Cliente proprietario, Date nascimento, Date cadastro, String sexo, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.proprietario = proprietario;
        this.nascimento = nascimento;
        this.cadastro = cadastro;
        this.sexo = sexo;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
