package br.com.lanchonete.service;

import java.util.List;

import javax.ejb.Local;

import br.com.lanchonete.entity.Funcionario;

@Local
public interface FuncionarioService {

	public Funcionario cadastrarFuncionario (Funcionario funcionario);

	public List<Funcionario> listaDadosDosFuncionarios(); 

	public Funcionario  removerFuncionario(Funcionario funcionario);

	public Funcionario editarFuncionario(Funcionario funcionario);
	
	}


