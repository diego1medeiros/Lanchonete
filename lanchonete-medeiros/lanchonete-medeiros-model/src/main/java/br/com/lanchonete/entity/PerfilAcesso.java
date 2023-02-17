package br.com.lanchonete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class PerfilAcesso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_perfil_acesso")
	private Long idPerfilAcesso;
	private String codigo;
	private String descricao;

	public Long getId_perfil_acesso() {
		return idPerfilAcesso;
	}

	public void setId_perfil_acesso(Long id_perfil_acesso) {
		this.idPerfilAcesso = id_perfil_acesso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
