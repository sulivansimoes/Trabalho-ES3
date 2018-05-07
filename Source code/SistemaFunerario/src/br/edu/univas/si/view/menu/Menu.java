package br.edu.univas.si.view.menu;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.edu.univas.si.controller.principal.ControllerPrincipal;
import br.edu.univas.si.view.util.MyFrame;
import br.edu.univas.si.view.util.MyImageIcons;

public class Menu extends MyFrame{

	private static final long serialVersionUID = 8422957020123439948L;

	private JMenuBar menuBar;
	
	private JMenu jmCadastro;
	private JMenu jmRelatorios;
//	private JMenu jmVendas;
	
	private JMenuItem jmCadastroUnidadeMedida;
	private JMenuItem jmCadastroCliente;
	private JMenuItem jmCadastroProduto;
//	private JMenuItem jmCadastroUsuarios;
//	private JMenuItem jmRealizarVendas;
		
	private ControllerPrincipal controller;
	
	public Menu(ControllerPrincipal controller) {
		super("Sistema Funerário");
		
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());
		
		initialize();
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pack();
		setLocationRelativeTo(null);
	}

	private void initialize(){
		menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(30, 30, 30, 30)); 
		
		//Cadastros
		getMenuCadastro().add(getJmCadastroUnidadeMedida());
		getMenuCadastro().add(getJmCadastroProduto());
		getMenuCadastro().add(getJmCadastroCliente());
		//getMenuCadastro().add(getJmCadastroUsuarios());
		menuBar.add(getMenuCadastro());
		
		//Vendas
//		getMenuVendas().add(getJmRealizarVendas());
//		menuBar.add(getMenuVendas());
		
		//Relatórios
		getMenuRelatorios();
		menuBar.add(getMenuRelatorios());
				
		add(menuBar);
	}
	
	private JMenu getMenuCadastro() {
		if(jmCadastro==null){
			jmCadastro = new JMenu("Cadastros");
			jmCadastro.setFont(new Font("Century",Font.PLAIN,20));
			jmCadastro.setIcon(MyImageIcons.getImageIconPlanilhaAdd(120, 120));
			jmCadastro.setVerticalTextPosition(SwingConstants.BOTTOM);
			jmCadastro.setHorizontalTextPosition(SwingConstants.CENTER);
			jmCadastro.setMargin(new Insets(50, 50, 50, 50));
		}
		return jmCadastro;
	}
	
	private JMenuItem getJmCadastroUnidadeMedida() {
		if(jmCadastroUnidadeMedida==null){
			jmCadastroUnidadeMedida = new JMenuItem("Unidade Medida");
			jmCadastroUnidadeMedida.setFont(new Font("Century",Font.PLAIN,18));
			jmCadastroUnidadeMedida.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenFrameUnidadeMedida();
				}
			});
		}
		return jmCadastroUnidadeMedida;
	}
	
	private JMenuItem getJmCadastroProduto() {
		if(jmCadastroProduto==null){
			jmCadastroProduto = new JMenuItem("Produto");
			jmCadastroProduto.setFont(new Font("Century",Font.PLAIN,18));
			jmCadastroProduto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenFrameProduto();					
				}
			});
		}
		return jmCadastroProduto;
	}
	
	private JMenuItem getJmCadastroCliente(){
		if(jmCadastroCliente==null){
			jmCadastroCliente = new JMenuItem("Cliente");
			jmCadastroCliente.setFont(new Font("Century",Font.PLAIN,18));
			jmCadastroCliente.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.callScreenFrameCliente();					
				}
			});
		}
		return jmCadastroCliente;
	}
	
	private JMenu getMenuRelatorios(){
		if(jmRelatorios==null){
			jmRelatorios = new JMenu("Relatórios");
			jmRelatorios.setFont(new Font("Century",Font.PLAIN,20));
			jmRelatorios.setIcon(MyImageIcons.getImageIconChart(120, 120));
			jmRelatorios.setVerticalTextPosition(SwingConstants.BOTTOM);
			jmRelatorios.setHorizontalTextPosition(SwingConstants.CENTER);
			jmRelatorios.setMargin(new Insets(50, 50, 50, 50));
		}
		return jmRelatorios;
	}
	
//	private JMenuItem getJmCadastroUsuarios() {
//		if(jmCadastroUsuarios==null){
//			jmCadastroUsuarios = new JMenuItem("Usuário");
//			jmCadastroUsuarios.setFont(new Font("Century",Font.PLAIN,15));
//			jmCadastroUsuarios.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					controller.callScreenUsuario();					
//				}
//			});
//		}
//		return jmCadastroUsuarios;
//	}
	
//	private JMenuItem getJmRealizarVendas() {
//		//
//	}
}
