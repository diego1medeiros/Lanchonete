package br.com.lanchonete.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.lanchonete.dao.FornecedorDao;
import br.com.lanchonete.entity.Fornecedor;

@RequestScoped
public class FornecedorServiceImpl implements FornecedorService {

	@Inject
	private FornecedorDao fornecedorDao;

	@Override
	public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) {
		return fornecedorDao.cadastrarFornecedor(fornecedor);
	}

	@Override
	public List<Fornecedor> listaDadosDosFornecedors() {
		return fornecedorDao.listaDadosDosFornecedors();
	}

	@Override
	public Fornecedor removerFornecedor(Fornecedor fornecedor) {
		return fornecedorDao.removerFornecedor(fornecedor);
	}

	@Override
	public Fornecedor editarFornecedor(Fornecedor fornecedor) {
		return fornecedorDao.editarFornecedor(fornecedor);
	}

	@Override
	public Fornecedor buscarFornecedoresPorId(Long id) {
		return fornecedorDao.buscarFornecedoresPorId(id);
	}

}
