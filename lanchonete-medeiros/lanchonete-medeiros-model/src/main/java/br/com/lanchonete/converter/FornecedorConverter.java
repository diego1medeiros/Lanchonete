package br.com.lanchonete.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.lanchonete.dao.FornecedorDao;
import br.com.lanchonete.entity.Fornecedor;


@FacesConverter(value = "fornecedorConverter", forClass = Fornecedor.class)
public class FornecedorConverter implements Converter{

	FornecedorDao fornecedorDao = new FornecedorDao();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String codigo) {
	
		if (codigo != null && !codigo.isEmpty()) {
			System.out.println(codigo);
			return (Fornecedor) fornecedorDao.buscarFornecedoresPorId(new Long(codigo));
		}
		return codigo;
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object != null) {
			Long idFornecedor = (Long) object;
			return idFornecedor != null && idFornecedor > 0
					? idFornecedor.toString()
					: null;
		}
		return null;
	
	}

	
	
}
