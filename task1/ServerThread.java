package task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.*;

public class ServerThread implements Runnable {
	
	private Socket socket;
	ServerMain server_main;
	
	public ServerThread(Socket socket, ServerMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}
	
	@Override
	public void run() {
		try {
			
			int client_number = server_main.getClientNumber();
			System.out.println("Client "+client_number+" has connected.");
			
			//I/O Buffer
			BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
			
			out_socket.println("Welcome! You are client number "+client_number); // send "Welcome" to the client
			
			String message = "";
			
			while(message.equalsIgnoreCase("EXIT") == false) {
//				out_socket.println("Enter your text: ");
				message = in_socket.readLine();
				System.out.println("Client "+client_number+" says: "+message);
				out_socket.println("Result: "+message.toUpperCase());
			}
			
			
			socket.close(); // important
			System.out.println("Client "+client_number+" has disconnected.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
