package br.com.lanchonete.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import br.com.lanchonete.entity.Funcionario;

@Stateless
public class FuncionarioDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public Funcionario cadastrarFuncionario(Funcionario funcionario) {
		manager.persist(funcionario);
		return funcionario;
	}

	@Transactional
	public List<Funcionario> listaDadosDosFuncionarios() {
		List<Funcionario> listaFuncionarios = null;
		listaFuncionarios = manager.createQuery("select f from Funcionario f", Funcionario.class).getResultList();
		return listaFuncionarios;
	}

	@Transactional
	public Funcionario removerFuncionario(Funcionario funcionario) {
		funcionario = manager.merge(funcionario);
		manager.remove(funcionario);
		return funcionario;
	}

	@Transactional
	public Funcionario editarFuncionario(Funcionario funcionario) {
		manager.merge(funcionario);
		return funcionario;
	}

}
