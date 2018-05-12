package RunnerTemp;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import com.toedter.calendar.JDateChooser;

import br.edu.univas.si.view.error.FrameError;
import br.edu.univas.si.view.util.MyFrame;

public class RunnerFrame {

	public static void main(String args[]){
		
		MyFrame.setlookAndFeel(MyFrame.GRAPHITE);
//		MyFrame frame = new MyFrame("MEU FRAME TESTE");
//		frame.setPreferredSize(new Dimension(600, 600));
//		frame.pack();
//		frame.setVisible(true);
//		
//		JPanel panel = new JPanel();
//		frame.setContentPane(panel);
//		
//	
//		
//		JLabel label = new  JLabel();
//		panel.add(label);
//		
//		JTextField txtField = new JTextField();
//		txtField.setColumns(40);
//		panel.add(txtField);
//		
//		
//		//JDateChooser cal = new JDateChooser("dd/MM/yyyy", "##/##/#####", ' ');
//		JDateChooser cal = new JDateChooser();
//		panel.add(cal);
//		
//	
//		JButton button = new JButton("TESTE");
//		button.setPreferredSize(new  Dimension(50, 50));
//		button.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				Calendar calendar = cal.getCalendar().getInstance() ;
//			//	Date date = calendar.gettime
//				
//			//	System.out.println(date);
//			}
//		});
//		panel.add(button);
//		
//		String[] columnNames = {"Nome", "Idade", "E-mail"};
//  		
//  		Object[][] tableData = {
//  				{"Maria", "22", "maria@gmail.com"},
//  				{"José", "25", "jose@gmail.com"},
//  				{"Maria", "22", "maria@gmail.com"},
//  				{"José", "25", "jose@gmail.com"},
//  				{"Maria", "22", "maria@gmail.com"},
//  				{"José", "25", "jose@gmail.com"},
//  				{"Maria", "22", "maria@gmail.com"},
//  				{"José", "25", "jose@gmail.com"},
//  				{"Maria", "22", "maria@gmail.com"},
//  				{"José", "25", "jose@gmail.com"},
//  				{"João", "27", "joao@gmail.com"}
//  		}; 
//  		
//  		//O componente JTable é responsável por criar uma tabela
//  		JTable table = new JTable(tableData, columnNames);
//  		table.setFillsViewportHeight(true);
//  		
//  		JScrollPane scrollPane3 = new JScrollPane(table);
//		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//		scrollPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//		scrollPane3.setPreferredSize(new Dimension(530, 170));
//		panel.add(scrollPane3);		
//	}
		
	FrameError fe = new FrameError();
	fe.setVisible(true);
	}
}
