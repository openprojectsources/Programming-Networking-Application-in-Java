package task3;

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
			
			String guessed_number;
			int number = (int)(Math.random()*20+1);
			
			do {
				out_socket.println("Guess the number [1-20]");
				guessed_number = in_socket.readLine();
			} while(!(Integer.parseInt(guessed_number)==number));
			
			out_socket.println("You got it!!!");
			System.out.println("Client "+client_number+" guessed the number.");
			socket.close(); // important
			System.out.println("Client "+client_number+" has disconnected.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
