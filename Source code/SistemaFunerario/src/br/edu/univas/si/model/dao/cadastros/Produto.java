package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.ProdutoException;
import br.edu.univas.si.model.to.ProdutoTO;
import br.edu.univas.si.model.util.DBUtil;
import br.edu.univas.si.view.util.MyValidations;

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
	
	public ArrayList<ProdutoTO> consultaProdutos() throws ProdutoException{
	
			ArrayList<ProdutoTO> list = new ArrayList<>();
			
			String sql = "SELECT CODIGO, DESCRICAO, TIPO, UNIDADE_MEDIDA, QUANTIDADE, VALOR FROM PRODUTO"
					   + " ORDER BY CODIGO";
			
			Connection connection = null;
			try{
					connection = DBUtil.openConnection();
					PreparedStatement statement = connection.prepareStatement(sql);
					
					ResultSet rs = statement.executeQuery();
					
					while(rs.next()){
						ProdutoTO produto = new ProdutoTO();
						produto.setCodigo(rs.getString(1));
						produto.setDescricao(rs.getString(2));
						produto.setTipo(rs.getString(3));
						produto.setUnidadeMedida(rs.getString(4));
						produto.setQuantidade(rs.getDouble(5));
						produto.setValor(rs.getDouble(6));
						
						list.add(produto);
					}
				
					return list;
			}catch(Exception e ){
				throw new ProdutoException("Erro ao fazer consulta em contultaProdutos \n"+e);
			}finally{
				DBUtil.closeConnection(connection);
			}
		}
	
	public ArrayList<ProdutoTO> consultaProdutosPorConteudo(String conteudo) throws ProdutoException{
		
		ArrayList<ProdutoTO> list = new ArrayList<>();
		
		String sql  = "SELECT CODIGO, DESCRICAO, TIPO, UNIDADE_MEDIDA, QUANTIDADE, VALOR FROM PRODUTO";
			   sql += " WHERE  CODIGO LIKE Upper(?) ";
			   sql += "  	OR DESCRICAO LIKE Upper(?) ";
			   sql += "	  	OR TIPO LIKE Upper(?) ";
			   sql += "	  	OR UNIDADE_MEDIDA LIKE Upper(?)";
			   if(MyValidations.isNumber(conteudo)){
				   sql += "	  OR QUANTIDADE = ?";
				   sql += "	  OR VALOR = ?";
			   }
			   sql += " ORDER BY CODIGO";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, "%"+conteudo+"%");
				statement.setString(2, "%"+conteudo+"%");
				statement.setString(3, "%"+conteudo+"%");
				statement.setString(4, "%"+conteudo+"%");
				if(MyValidations.isNumber(conteudo)){
					statement.setDouble(5, Double.valueOf(conteudo));
					statement.setDouble(6, Double.valueOf(conteudo));
				}
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					ProdutoTO produto = new ProdutoTO();
					produto.setCodigo(rs.getString(1));
					produto.setDescricao(rs.getString(2));
					produto.setTipo(rs.getString(3));
					produto.setUnidadeMedida(rs.getString(4));
					produto.setQuantidade(rs.getDouble(5));
					produto.setValor(rs.getDouble(6));
					
					list.add(produto);
				}
			
				return list;
		}catch(Exception e ){
			throw new ProdutoException("Erro ao fazer consulta em consultaProdutosPorConteudo \n"+e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
