package br.com.lanchonete.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovimentacaoCaixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"id_movimentacao_caixa\"")
	private Long idMovimentacaoCaixa;
	private String tipoMovimento;
	private Date data;
	private double valor_total;
	private String observacao;
	
	public Long getId_movimentacao_caixa() {
		return idMovimentacaoCaixa;
	}
	public void setId_movimentacao_caixa(Long id_movimentacao_caixa) {
		this.idMovimentacaoCaixa = id_movimentacao_caixa;
	}
	public String getTipo_movimento() {
		return tipoMovimento;
	}
	public void setTipo_movimento(String tipo_movimento) {
		this.tipoMovimento = tipo_movimento;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
