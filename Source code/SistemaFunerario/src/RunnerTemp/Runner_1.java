package RunnerTemp;

import java.awt.Dimension;

import br.edu.univas.si.view.util.MyFrame;


public class Runner_1 {
	
	public static void main(String args){
		
		MyFrame.setlookAndFeel(MyFrame.ACRYL);
		MyFrame frame = new MyFrame();
		frame.setPreferredSize(new Dimension(500, 600));
		frame.setVisible(true);
		System.out.println("Testando..");
	}
}
