package br.com.lanchonete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_item_venda\"")
	private Long idItemVenda;
	private int qtde;
	private double valor_total;
	@ManyToOne
	@JoinColumn(name = "\"id_produto\"")
	private Produto produto;

	public Long getId_item_venda() {
		return idItemVenda;
	}

	public void setId_item_venda(Long id_item_venda) {
		this.idItemVenda = id_item_venda;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
