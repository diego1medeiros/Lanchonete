package br.com.lanchonete.service;

import java.util.List;

import javax.ejb.Local;

import br.com.lanchonete.entity.Produto;

@Local
public interface ProdutoService {

	public Produto cadastrarProduto(Produto produto);
	
	public List<Produto> listaDadosDosProdutos();
	
	public Produto removerProduto(Produto produto);
	
	public Produto editarProduto(Produto produto);
	
}
