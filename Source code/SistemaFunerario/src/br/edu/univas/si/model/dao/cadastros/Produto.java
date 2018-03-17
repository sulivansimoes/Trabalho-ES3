package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos reponsáveis por: incluir, alterar e excluir cadastro de Produto
 * @author: Súlivan Simões
 * @version: 1.0 
 */
public class Produto {

	
	public void insertNewProduto(ProdutoTO produto) throws ProdutoException{
		
		String sql = "INSERT INTO PRODUTO(CODIGO, DESCRICAO, TIPO, UNIDADE_MEDIDA, QUANTIDADE, VALOR)"
				+ " VALUES(?, Upper(?), Upper(?), Upper(?), ?, ?)";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, produto.getCodigo());
				statement.setString(2, produto.getDescricao());
				statement.setString(3, produto.getTipo());
				statement.setString(4, produto.getUnidadeMedida());
				statement.setDouble(5, produto.getQuantidade());
				statement.setDouble(6, produto.getValor());
				
				statement.execute();
		
		}catch(Exception e){
			throw new ProdutoException("Erro ao incluir produto: "+produto.getCodigo()+" - "
																  +produto.getDescricao() + "\n"
																  +e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateProduto(ProdutoTO produto) throws ProdutoException{
		
		String sql = "UPDATE PRODUTO "
				   + " SET DESCRICAO = Upper(?), TIPO = Upper(?), UNIDADE_MEDIDA = Upper(?), QUANTIDADE = ?, VALOR = ?"
				   + " WHERE CODIGO = ?";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, produto.getDescricao());
				statement.setString(2, produto.getTipo());
				statement.setString(3, produto.getUnidadeMedida());
				statement.setDouble(4, produto.getQuantidade());
				statement.setDouble(5, produto.getValor());
				statement.setString(6, produto.getCodigo());
				
				statement.execute();
		
		}catch(Exception e){
			throw new ProdutoException("Erro ao alterar produto: "+produto.getCodigo()+" - "
																  +produto.getDescricao() + "\n"
																  +e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteProduto(String codigo) throws ProdutoException{
		
		String sql = "DELETE FROM PRODUTO WHERE CODIGO = ?";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, codigo);				
				statement.execute();
		
		}catch(Exception e){
			throw new ProdutoException("Erro ao excluir produto: "+codigo+"\n"
																  +e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
