package br.com.lanchonete.service;

import java.util.List;

import javax.ejb.Local;
import br.com.lanchonete.entity.Fornecedor;

@Local
public interface FornecedorService {

	public Fornecedor cadastrarFornecedor(Fornecedor fornecedor);
	
	public List<Fornecedor> listaDadosDosFornecedors(); 
	
	public Fornecedor removerFornecedor(Fornecedor fornecedor);
	
	public Fornecedor editarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor buscarFornecedoresPorId(Long id) ;
	
}
