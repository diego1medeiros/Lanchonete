package br.com.lanchonete.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.lanchonete.dao.FuncionarioDao;
import br.com.lanchonete.entity.Funcionario;

@RequestScoped
public class FuncionarioServiceImpl implements FuncionarioService {

	@Inject
	private FuncionarioDao funcionarioDao;

	@Override
	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		return funcionarioDao.cadastrarFuncionario(funcionario);
	}

	@Override
	public List<Funcionario> listaDadosDosFuncionarios() {
		return funcionarioDao.listaDadosDosFuncionarios();
	}

	@Override
	public Funcionario removerFuncionario(Funcionario funcionario) {
		return funcionarioDao.removerFuncionario(funcionario);
	}

	@Override
	public Funcionario editarFuncionario(Funcionario funcionario) {
		return funcionarioDao.editarFuncionario(funcionario);

	}

}
