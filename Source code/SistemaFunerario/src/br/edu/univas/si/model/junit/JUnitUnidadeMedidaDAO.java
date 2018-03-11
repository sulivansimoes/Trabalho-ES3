package br.edu.univas.si.model.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.edu.univas.si.model.dao.cadastros.UnidadeMedida;
import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import sun.rmi.log.ReliableLog.LogFile;

public class JUnitUnidadeMedidaDAO {

	@Test
	public void testInsertNewUnidadeMedida() {
		
		boolean resposta=true;
		
		UnidadeMedida dao =  new UnidadeMedida();
		UnidadeMedidaTO unidadeMedidaTo = new  UnidadeMedidaTO("KG","QUILO");
		
		try {
			dao.insertNewUnidadeMedida(unidadeMedidaTo);
			
			assertTrue(resposta);
			
			
		} catch (UnidadeMedidaException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
