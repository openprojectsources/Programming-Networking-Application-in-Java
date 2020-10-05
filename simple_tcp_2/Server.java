package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public Server() throws Exception {
		ServerSocket serverSocket = new ServerSocket(2021); //Opening a new port | 2021 is a port number
		System.out.println("Port 2021 is open.");
		
		Socket socket = serverSocket.accept(); //Blocking method. It accepts incoming connections 
		System.out.println("Client "+socket.getInetAddress()+" has connected.");
		
		// I/O Buffer
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		String message;
		
		int secret_number = (int)(Math.random()*10+1);
		
		do {
			out_socket.println("Guess the number [1-10]: ");
			message = in_socket.readLine();
		}while(!(Integer.parseInt(message)==secret_number));
		
		out_socket.println("You got it!!!");
		System.out.println("Client guessed right number. Exiting the app.");
		
		socket.close(); // important
		System.out.println("Socket is closed");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new Server();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
