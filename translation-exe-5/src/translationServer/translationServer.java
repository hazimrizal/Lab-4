package translationServer;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import translation.translation;

public class translationServer {
	
	
	public static void main(String []args) throws IOException {
		try {
		translation tl = new translation();
		serverFrame sf = new serverFrame();
		
		sf.setVisible(true);
		sf.setLocationRelativeTo(null);
		
		while(true) {
		ServerSocket ss = new ServerSocket(1998);
		Socket cs =  ss.accept();
		
		DataOutputStream dout = new DataOutputStream(cs.getOutputStream());
		DataInputStream din = new DataInputStream(cs.getInputStream());
		
		String textReceived = din.readUTF();
		String langReceived = din.readUTF();
		System.out.print("received: " + textReceived);
		System.out.print("\nLanguage: "+ langReceived);
		//String langReceived = din.readUTF();
		
		String translated = tl.translateText(textReceived, langReceived);
		System.out.print("\n" + translated);
		sf.setTextArea(translated);
		
		//System.out.print("Translation: " + translated );
		}
	}catch (IOException e) {
		e.printStackTrace();
	}
		
	}

}
