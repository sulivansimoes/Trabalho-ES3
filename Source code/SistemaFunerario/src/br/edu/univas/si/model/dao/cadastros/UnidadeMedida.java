package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.UnidadeMedidaException;
import br.edu.univas.si.model.to.UnidadeMedidaTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos reponsáveis por: incluir, alterar e excluir cadastro de Unidade de Medida 
 * @author: Súlivan Simões
 * @version: 1.0
 */

public class UnidadeMedida {
	
	public void insertNewUnidadeMedida(UnidadeMedidaTO unidadeMedida)throws UnidadeMedidaException{
		
		String sql  = "INSERT INTO UNIDADE_MEDIDA(CODIGO, DESCRICAO)"
					+ " VALUES(Upper(?), Upper(?) ) ";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, unidadeMedida.getCodigo());
				statement.setString(2, unidadeMedida.getDescricao());
				
				statement.execute();
		}catch(Exception e ){
			throw new UnidadeMedidaException("Erro ao incluir "+ unidadeMedida.getCodigo()+" - "
															   + unidadeMedida.getDescricao()+"\n"
															   + e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateUnidadeMedida(UnidadeMedidaTO unidadeMedida) throws UnidadeMedidaException{
		
		String sql  = "UPDATE UNIDADE_MEDIDA"
					+ " SET DESCRICAO = Upper(?)"
					+ " WHERE CODIGO = ?";
	
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, unidadeMedida.getDescricao());
				statement.setString(2, unidadeMedida.getCodigo());
				
				statement.execute();
		}catch(Exception e){
			throw new UnidadeMedidaException("Erro ao alterar unidade de medida "+unidadeMedida.getCodigo()+" - "
															   					 +unidadeMedida.getDescricao()
															   					 +e);
			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteUnidadeMedida(String codigo) throws UnidadeMedidaException{
		
		
		String sql = "DELETE FROM UNIDADE_MEDIDA WHERE CODIGO = ?";
	
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, codigo);
				
				statement.execute();
		}catch(Exception e){
			throw new UnidadeMedidaException("Erro ao excluir "+ codigo+ "\n" +e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
