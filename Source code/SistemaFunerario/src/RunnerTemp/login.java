package RunnerTemp;

import br.edu.univas.si.view.login.FrameLogin;
import br.edu.univas.si.view.util.MyFrame;

public class login {
	
	public static void main(String args[]){
		
		MyFrame.setlookAndFeel(MyFrame.GRAPHITE);
		FrameLogin f = new FrameLogin();
		f.setVisible(true);
	}
}
