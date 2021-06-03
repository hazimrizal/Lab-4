package translationClient;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import translation.translation;

public class translationClient {
	public static void main(String[]args) throws IOException, InterruptedException {
		
		
	try {
		clientFrame cl = new clientFrame();
		cl.setVisible(true);
		cl.setLocationRelativeTo(null);
		
		while(true) {
		
		Socket s = new Socket("localhost", 1998);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		
		dos.writeUTF(cl.getPhraseExtract());
		dos.writeUTF(cl.getLangExtract());
		
		//dos.writeUTF(cl.getLangExtract());
		}
	}catch (IOException e) {
		e.printStackTrace();
	}
	
	
		
	}

}
