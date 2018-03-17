package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.VendaException;
import br.edu.univas.si.model.to.VendaCabecalhoTO;
import br.edu.univas.si.model.to.VendaItemTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos reponsáveis por: incluir, alterar e excluir cadastro de Vendas 
 * @author: Súlivan Simões
 * @version: 1.0
 */
public class Venda {

	public void insertNewVenda(VendaCabecalhoTO cabecalho, ArrayList<VendaItemTO>  itens) throws VendaException{
		
		String sqlCabecalho =" INSERT INTO VENDA_CABECALHO(CODIGO, SERIE, DT_EMISSAO, CLIENTE, VALOR_VENDA)"
				   			+" VALUES(Upper(?), Upper(?), ?, Upper(?), ?)";
		
		String sqlItens = "INSERT INTO VENDA_ITEM(CODIGO_VENDA, SERIE_VENDA, ITEM, PRODUTO, QUANTIDADE, VALOR_PRODUTO, VALOR_ITEM)"
						+ " VALUES(Upper(?), Upper(?), ?, Upper(?), ?, ?, ? )";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				connection.setAutoCommit(false);
				
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				statementCabecalho.setString(1, cabecalho.getCodigo());
				statementCabecalho.setString(2, cabecalho.getSerie());
				statementCabecalho.setTimestamp(3, new Timestamp(cabecalho.getDtEmissao().getTime()));
				statementCabecalho.setString(4, cabecalho.getCliente());
				statementCabecalho.setDouble(5, cabecalho.getValorVenda());
				statementCabecalho.execute();
				
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				for(VendaItemTO item : itens){
					
					statementItens.setString(1, item.getCodigoVenda());
					statementItens.setString(2, item.getSerieVenda());
					statementItens.setInt(3, item.getItem());
					statementItens.setString(4, item.getProduto());
					statementItens.setDouble(4, item.getQuantidade());
					statementItens.setDouble(6, item.getValorProduto());
					statementItens.setDouble(7, item.getValorItem());
					statementItens.execute();
				}
				
			connection.commit();
		}catch(Exception e){
			
			try {
				connection.rollback();
				throw new VendaException("Erro ao registrar venda - "+ cabecalho.getCodigo()+" - "
				 													 + cabecalho.getCodigo()+" - "
				 													 + "A transação será desfeita. \n"
				 													 + e);
			} catch (Exception e1) {
				throw new VendaException("Erro ao tentar executar rollback da venda "+ cabecalho.getCodigo()+" - "
																					 + cabecalho.getSerie()+" - "
																					 + e1);
			}			
			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateVenda(String codigoVenda, String serieVenda, ArrayList<VendaItemTO> itens ){
		
		//TODO implements..
	}
	
	public void deleteVenda(String codigoVenda, String serieVenda) throws VendaException{
			
		String sqlCabecalho = "DELETE FROM VENDA_CABECALHO WHERE CODIGO = ? AND SERIE = ?";
		String sqlItens = "DELETE FROM VENDA_ITEM WHERE CODIGO_VENDA = ? AND SERIE_VENDA = ?"; 

		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				connection.setAutoCommit(false);	
				
				PreparedStatement statementCabecalho = connection.prepareStatement(sqlCabecalho);
				statementCabecalho.setString(1, codigoVenda);
				statementCabecalho.setString(2, codigoVenda);
				statementCabecalho.execute();
				
				PreparedStatement statementItens = connection.prepareStatement(sqlItens);
				statementItens.setString(1, codigoVenda);
				statementItens.setString(1, serieVenda);
				statementItens.execute();
				
				connection.commit();
				
		}catch(Exception e){
			
			try{
					connection.rollback();
					throw new VendaException("Erro ao excluir venda "+codigoVenda+" - "
							 										 +serieVenda+"\n"
							 										 +e);
			}catch(Exception e1){
				throw new VendaException("Erro ao executar roolback da exclusão da venda"+codigoVenda+" - " 
																						 +serieVenda +"\n"
																						 +e);	
			}			
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
