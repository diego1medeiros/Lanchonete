package br.com.lanchonete.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Long idFuncionario;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco = new Endereco() ;
	private String funcao;
	private Double salario;
	private String login;
	private String senha;
	@ManyToOne( cascade=CascadeType.ALL)
	@JoinColumn(name = "id_perfil_acesso")
	private PerfilAcesso perfil = new PerfilAcesso();
	
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
		
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		
	}
	public PerfilAcesso getPerfil() {
		return perfil;
		
	}
	public void setPerfil(PerfilAcesso perfil) {
		this.perfil = perfil;
		
	}
	
}
