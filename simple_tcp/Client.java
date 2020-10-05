package simple_tcp;

import java.net.Socket;
import java.io.*;

public class Client {
	
	public Client() throws Exception{
		
		Socket socket = new Socket("localhost", 2021);
		System.out.println("Server connection is successful.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		
		String message = in_socket.readLine();
		System.out.println("Server says: "+message);
		out_socket.println("Thank you!");
		
		socket.close();
		System.out.println("Socket closed.");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			new Client();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
