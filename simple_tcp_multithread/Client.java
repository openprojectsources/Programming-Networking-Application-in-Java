package simple_tcp_multithread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception{
		
		Socket socket = new Socket("localhost", 3600);
		System.out.println("Server connection is successful.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner scan = new Scanner(System.in);
		
		String message = in_socket.readLine();
		System.out.println("Server says: "+message);
		message = scan.nextLine();
		out_socket.println(message);
		
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
