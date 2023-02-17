package br.com.lanchonete.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"id_tipo_pagamento\"")
	private Long idTipoPagamneto;
	private String codigo;
	private String descricao;

	public Long getId_tipo_pagamneto() {
		return idTipoPagamneto;
	}

	public void setId_tipo_pagamneto(Long id_tipo_pagamneto) {
		this.idTipoPagamneto = id_tipo_pagamneto;
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
