package br.edu.univas.si.model.dao.cadastros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.univas.si.model.exception.ClienteException;
import br.edu.univas.si.model.to.ClienteTO;
import br.edu.univas.si.model.util.DBUtil;

/**
 * Summary: Classe contém métodos reponsáveis por: incluir, alterar e excluir cadastro de Cliente
 * @author: Súlivan Simões
 * @version:1.0 
 */

public class Cliente {
	
	public void insertNewCliente(ClienteTO cliente ) throws ClienteException{
		
		String sql = "INSERT INTO CLIENTE (TIPO, RAZAO_SOCIAL, NOME_FANTASIA,  CPF_CNPJ, ENDERECO) "
				   + " VALUES( Upper(?), Upper(?), Upper(?), Upper(?), Upper(?) )";
		
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, String.valueOf(cliente.getTipo()));
				statement.setString(2, cliente.getRazao_social());
				statement.setString(3, cliente.getNome_fantasia());
				statement.setString(4, cliente.getCpf_cnpj().trim());
				statement.setString(5, cliente.getEndereco());
				
				statement.execute();
		
		}catch(Exception e){
			throw new ClienteException("Erro ao tentar incluir:"+cliente.getCpf_cnpj()+ " - "
																+cliente.getNome_fantasia()+" \n "
																+e );
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public void updateCliente(ClienteTO cliente) throws ClienteException{
	
		String sql = "UPDATE CLIENTE"
				   + "	SET RAZAO_SOCIAL = Upper(?), NOME_FANTASIA = Upper(?), ENDERECO = Upper(?)  "
				   + "	WHERE CPF_CNPJ = ?"; 
				   
		Connection connection = null;
		try{
				connection = DBUtil.openConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				
				statement.setString(1, cliente.getRazao_social());
				statement.setString(2, cliente.getNome_fantasia());
				statement.setString(3, cliente.getEndereco());
				
				statement.setString(4, cliente.getCpf_cnpj());
				
				statement.execute();
				
		}catch(Exception e){
			throw new ClienteException("Erro ao tentar alterar:"+cliente.getCpf_cnpj()+ " - "
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
	
	public ArrayList<ClienteTO> consultaClientes() throws ClienteException{
		
		ArrayList<ClienteTO> list = new ArrayList<>();
		String sql = "SELECT RAZAO_SOCIAL, NOME_FANTASIA , TIPO,  CPF_CNPJ, ENDERECO FROM CLIENTE";
		
		Connection connection = null;
		try{
			connection = DBUtil.openConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
					
			ResultSet rs= statement.executeQuery();
						
			while(rs.next()){
				ClienteTO cliente = new ClienteTO();
				cliente.setRazao_social(rs.getString(1));
				cliente.setNome_fantasia(rs.getString(2));
				cliente.setTipo(rs.getString(3).charAt(0));
				cliente.setCpf_cnpj(rs.getString(4));
				cliente.setEndereco(rs.getString(5));
				
				list.add(cliente);
			}
			return list;
		}catch(Exception e){
			throw new ClienteException("Erro ao consultar clientes - "+ e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
	
	public ArrayList<ClienteTO> consultaClientesPorConteudo(String conteudo) throws ClienteException{
		
		ArrayList<ClienteTO> list = new ArrayList<>();
		String sql = "SELECT  RAZAO_SOCIAL, NOME_FANTASIA ,TIPO,  CPF_CNPJ, ENDERECO FROM CLIENTE";
			   sql += " WHERE RAZAO_SOCIAL LIKE Upper(?)";
			   sql += "    OR NOME_FANTASIA LIKE Upper(?)";
			   sql += "    OR TIPO LIKE Upper(?)";
			   sql += "    OR CPF_CNPJ LIKE Upper(?)";
			   sql += "    OR ENDERECO LIKE Upper(?)";
		
		Connection connection = null;
		try{
			connection = DBUtil.openConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, "%"+conteudo+"%");
			statement.setString(2, "%"+conteudo+"%");
			statement.setString(3, "%"+conteudo+"%");
			statement.setString(4, "%"+conteudo+"%");
			statement.setString(5, "%"+conteudo+"%");
			
			ResultSet rs= statement.executeQuery();
						
			while(rs.next()){
				ClienteTO cliente = new ClienteTO();
				cliente.setRazao_social(rs.getString(1));
				cliente.setNome_fantasia(rs.getString(2));
				cliente.setTipo(rs.getString(3).charAt(0));
				cliente.setCpf_cnpj(rs.getString(4));
				cliente.setEndereco(rs.getString(5));
				
				list.add(cliente);
			}
			return list;
		}catch(Exception e){
			throw new ClienteException("Erro ao consultar clientes - "+ e);
		}finally{
			DBUtil.closeConnection(connection);
		}
	}
}
