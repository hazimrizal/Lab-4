package TLserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import textLength.textLength;

public class TLserver {
	public static void main(String[] args) throws IOException{
		ServerSocket serversocket = null;
		
		try {
			
			textLength tl = new textLength();
			//Bind serversocket to a port
			int port = 4228;
			serversocket = new ServerSocket(port);
			System.out.println("Connecting...");
			
			while(true) {
				//Accept client request for connection
				Socket clientSocket = serversocket.accept();
				System.out.println("Connected");
				
				//Create stream to send data to TLclient
				DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());
				
				//Create stream to accept data from TLclient
				DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
				
				//Accept data from TLclient
				String text = dis.readUTF();
				System.out.println("The text is: " + text);
				
				int numOfChar  = tl.wordCounter(text);
				System.out.print("The word count: "+ numOfChar);
				
				//Send data to client
				os.writeInt(numOfChar);
				
				//Close the socket
				clientSocket.close();
			}
			
			
		}catch (IOException ioe) {
			
			if(serversocket != null)
				serversocket.close();
			
			ioe.printStackTrace();
		}

	}
}
