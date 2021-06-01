package TLclient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TLclient {
	public static void main (String [] args) {
		
		
		try {
			//Connect to TLserver
			Socket socket = new Socket("localhost", 4228);
			
			//Create output stream to send data out
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			//Create input stream to accept data in
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			Scanner sc = new Scanner(System.in);
			
			//Input from user
			System.out.print("Input a sentence: ");
			String text = sc.nextLine();
			
			//to send text to TLserver
			dos.writeUTF(text);
			System.out.println("Text sent");
			
			//to accept response from Tlserver
			int num = dis.readInt();
			System.out.println("The number of words: " + num);
			
			
			//Close everything
			dis.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
