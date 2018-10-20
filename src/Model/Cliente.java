package Model;

import java.util.Date;

/**
 *
 * @author Skalybuhr
 */
public class Cliente {

    public Integer id;
    public String nome;
    public String endereco;
    public String cpf;
    public String telefone;
    public String celular;
    public Date nascimento;
    public String sexo;
    public String status;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String endereco, String cpf, String telefone, String celular, Date nascimento, String sexo, String status, Date cadastro) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.celular = celular;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.status = status;
        this.cadastro = cadastro;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
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

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }
    public Date cadastro;

}
