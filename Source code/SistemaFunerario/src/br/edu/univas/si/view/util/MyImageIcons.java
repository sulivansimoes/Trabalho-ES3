package br.edu.univas.si.view.util;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * Summary: Função retornas images icons do sistema.
 * @author Súlivan Simões
 * @since 06/05/2018
 */
public class MyImageIcons {

	private static ImageIcon imageIconChart;
	private static ImageIcon imageIconLupa;
	private static ImageIcon imageIconPencil;
	private static ImageIcon imageIconLixo;
	private static ImageIcon imageIconAdd;
	private static ImageIcon imageIconExit;
	private static ImageIcon imageIconPlanilhaAdd;
	
	/**
	 * Summary: Retorna imagem de um chart(grafico) de pizza.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconChart(int width, int height){
		
		if(imageIconChart==null){
			if(imageIconChart==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/chart.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconChart = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconChart;
	}
	
	/**
	 * Summary: Retorna imagem de uma lupa.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconLupa(int width, int height){
		
		if(imageIconLupa==null){
			if(imageIconLupa==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/search.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconLupa = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconLupa;
	}
	
	/**
	 * Summary: Retorna imagem de um lápis.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconPencil(int width, int height){
		
		if(imageIconPencil==null){
			if(imageIconPencil==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/pencil.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconPencil = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconPencil;
	}
	
	/**
	 * Summary: Retorna imagem de uma lixeira.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconLixo(int width, int height){
		
		if(imageIconLixo==null){
			if(imageIconLixo==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/lixo.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconLixo = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconLixo;
	}
	
	/**
	 * Summary: Retorna imagem de um add.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconAdd(int width, int height){
		
		if(imageIconAdd==null){
			if(imageIconAdd==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/add.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconAdd = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconAdd;
	}
	
	/**
	 * Summary: Retorna imagem de saida.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconExit(int width, int height){
		
		if(imageIconExit==null){
			if(imageIconExit==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/saida.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconExit = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconExit;
	}
	
	/**
	 * Summary: Retorna imagem de uma planilha com sinal de adição.
	 * @param width	Largura da imagem
	 * @param height Altura da imagem
	 * @return ImageIcon 
	 */
	public static final ImageIcon getImageIconPlanilhaAdd(int width, int height){
		
		if(imageIconPlanilhaAdd==null){
			if(imageIconPlanilhaAdd==null){				
				try {
						URL urlImg = MyImageIcons.class.getResource(("/br/edu/univas/si/view/images/window_add.png"));
						Image image = ImageIO.read(urlImg);;
						Image imageNew = image.getScaledInstance(width,height,Image.SCALE_REPLICATE); 
						imageIconPlanilhaAdd = new ImageIcon(imageNew);
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
		}
		return imageIconPlanilhaAdd;
	}

}
