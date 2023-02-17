package br.com.lanchonete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_estoque\"")
	private Long idEstoque;
	private int qtde;
	private int qtde_min_aviso;
	@ManyToOne
	@JoinColumn(name = "\"id_produto\"")
	private Produto produto;

	
	
	public Long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public int getQtde_min_aviso() {
		return qtde_min_aviso;
	}

	public void setQtde_min_aviso(int qtde_min_aviso) {
		this.qtde_min_aviso = qtde_min_aviso;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
