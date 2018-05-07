package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	
	public ArrayList<UnidadeMedidaTO> consultaUnidadeMedida() throws UnidadeMedidaException{
		
		ArrayList<UnidadeMedidaTO> list = new ArrayList<UnidadeMedidaTO>();
		
		String sql = "SELECT codigo, descricao FROM unidade_medida"
				   + " ORDER BY codigo";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					UnidadeMedidaTO unidade = new UnidadeMedidaTO(rs.getString(1), rs.getString(2));
					list.add(unidade);
				}
			
				return list;
		}catch(Exception e ){
			throw new UnidadeMedidaException("Erro ao fazer consulta em consultaUnidadeMedida \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public ArrayList<UnidadeMedidaTO> consultaUnidademedidaPorConteudo(String conteudo) throws UnidadeMedidaException{
		
		ArrayList<UnidadeMedidaTO> list = new ArrayList<UnidadeMedidaTO>();
		
		String sql = "SELECT codigo, descricao FROM unidade_medida"
				   + " WHERE codigo LIKE Upper(?) OR descricao LIKE Upper(?)"
				   + " ORDER BY codigo";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, "%"+conteudo+"%");
				statement.setString(2, "%"+conteudo+"%");
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					UnidadeMedidaTO unidade = new UnidadeMedidaTO(rs.getString(1), rs.getString(2));
					list.add(unidade);
				}
			
				return list;
		}catch(Exception e ){
			throw new UnidadeMedidaException("Erro ao fazer consulta em consultaUnidademedidaPorConteudo \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	} 

}
