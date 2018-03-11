package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos reponsáveis por: incluir, alterar e excluir cadastro de Cliente 
 */

public class Cliente {
	
	public void insertNewCliente(ClienteTO cliente ) throws ClienteException{
		
		String sql = "ISERT INTO CLIENTE (TIPO, RAZAO_SOCIAL, NOME_FANTASIA,  CPF_CNPJ, ENDERECO) "
				   + " VALUES( Upper(?), Upper(?), Upper(?), ?, Upper(?) )";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, String.valueOf(cliente.getTipo()));
				statement.setString(2, cliente.getRazao_social());
				statement.setString(3, cliente.getNome_fantasia());
				statement.setString(4, cliente.getEndereco());
				
				statement.execute();
		
		}catch(Exception e){
			new ClienteException("Erro ao tentar incluir:"+cliente.getCpf_cnpj()+ " - "
														  +cliente.getNome_fantasia()+" \n "
														  +e );
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateCliente(ClienteTO cliente) throws ClienteException{
	
		String sql = "UPDATE CLIENTE"
				   + "	SET RAZAO_SOCIAL = Upper(?), NOME_FANTASIA = Upper(?), ENDERECO = Upper(?)  "; 
				   
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, cliente.getRazao_social());
				statement.setString(2, cliente.getNome_fantasia());
				statement.setString(3, cliente.getEndereco());
				
				statement.execute();
				
		}catch(Exception e){
			new ClienteException("Erro ao tentar alterar:"+cliente.getCpf_cnpj()+ " - "
					  									  +cliente.getNome_fantasia()+" \n "
					  									  +e );
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void deleteCliente(String cpf_cnpj) throws ClienteException{
		
		String sql = "DELETE FROM CLIENTE WHERE CPF_CNPJ = ?";
		Connection connection = null;
		
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, cpf_cnpj);
				
				statement.execute();
				
		}catch(Exception e){
			throw new ClienteException("Erro ao excluir: " + cpf_cnpj+" - "+ e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
