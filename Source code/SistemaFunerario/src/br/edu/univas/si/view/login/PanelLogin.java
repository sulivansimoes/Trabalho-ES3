package br.edu.univas.si.view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.controller.errorlog.ControllerError;
import br.edu.univas.si.view.util.MyMask;

public class PanelLogin extends JPanel{

	private static final long serialVersionUID = -8455360724520146986L;
	
	private BufferedImage img;
	private JFormattedTextField textFieldUser;
	private JPasswordField textFieldSenha;
	private JLabel labelUser;
	private JLabel labelSenha;
	private GridBagConstraints gbcTextFieldUser;
	private GridBagConstraints gbcTextFieldSenha;
	private GridBagConstraints gbclabelUser;
	private GridBagConstraints gbcLabelSenha;
	
	private ControllerError controllerError;	 
	
	public PanelLogin(){
		
		try {
				//Carrego imagem de fundo da tela de login
				URL urlImagem = this.getClass().getResource("/br/edu/univas/si/view/images/login.jpg");
				this.img =  ImageIO.read(urlImagem);
		} catch (IOException e) {
			e.printStackTrace();
			getControllerError().initialize(e);
		}
		
		setBorder(new EmptyBorder(10, 20, 20, 20));
		setLayout(new GridBagLayout());
		initialize();
	}
	
	private void initialize(){
		
		add(getLabelUser(), getGbclabelUser());
		add(getTextFieldUser(), getGbcTextFieldUser());
		add(getLabelSenha(), getGbcLabelSenha());
		add(getTextFieldSenha(), getGridGbcTextFieldSenha());
	}
		
	private JLabel getLabelUser(){
		if(labelUser==null){
			labelUser = new JLabel("Usuário: ");
			labelUser.setFont(new Font("Century",Font.BOLD,14));
			labelUser.setForeground(Color.WHITE);
		}
		return labelUser;
	}
	
	public JFormattedTextField getTextFieldUser() {
		if(textFieldUser==null){
			textFieldUser = new JFormattedTextField();
			textFieldUser.setColumns(12);
			MyMask.maskCpf(textFieldUser);
		}
		return textFieldUser;
	}
	
	private JLabel getLabelSenha(){
		if(labelSenha==null){
			labelSenha = new JLabel("Senha: ");
			labelSenha.setFont(new Font("Century",Font.BOLD,14));
			labelSenha.setForeground(Color.WHITE);
		}
		return labelSenha;
	}

	public JPasswordField getTextFieldSenha() {
		if(textFieldSenha==null){
			textFieldSenha = new JPasswordField();
			textFieldSenha.setColumns(12);
		}
		return textFieldSenha;
	}
	
	private GridBagConstraints getGbclabelUser(){
		if(gbclabelUser==null){
			gbclabelUser = new GridBagConstraints();
			gbclabelUser.gridx = 2;
			gbclabelUser.gridy = 1;
		}
		return gbclabelUser;
	}
	
	private GridBagConstraints getGbcTextFieldUser(){
		if(gbcTextFieldUser==null){
			gbcTextFieldUser = new GridBagConstraints();
			gbcTextFieldUser.gridx = 4;
			gbcTextFieldUser.gridy = 1;
		}
		return gbcTextFieldUser;
	}
	
	private GridBagConstraints getGbcLabelSenha(){
		if(gbcLabelSenha == null){
			gbcLabelSenha = new  GridBagConstraints();
			gbcLabelSenha.gridx = 2;
			gbcLabelSenha.gridy = 2;
		}
		return gbcLabelSenha;
	}
	
	private GridBagConstraints getGridGbcTextFieldSenha(){
		if(gbcTextFieldSenha == null){
			gbcTextFieldSenha = new  GridBagConstraints();
			gbcTextFieldSenha.gridx = 4;
			gbcTextFieldSenha.gridy = 2;
			gbcTextFieldSenha.insets = new  Insets(10, 10, 10, 10);
		}
		return gbcTextFieldSenha;
	}
		
    @Override  //Método para mudar imagem de fundo.
    public void paintComponent(Graphics g) {  
        super.paintComponent(g);        
        Graphics gr = (Graphics2D)g.create();  
        gr.drawImage(img, 0, 0 ,this.getWidth(),this.getHeight(),this);  
        gr.dispose();     
    }  	
    
	private ControllerError getControllerError() {
		if(controllerError == null){
			controllerError = new ControllerError();
		}
		return controllerError;
	}
}

