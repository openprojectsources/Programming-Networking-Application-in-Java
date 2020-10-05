package simple_tcp_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public Client() throws Exception{
		
		Socket socket = new Socket("localhost", 2021);
		System.out.println("Server connection is successful.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
		Scanner scan = new Scanner(System.in);
		String number, message;
		
		while((in_socket.readLine()).startsWith("Guess")) {
			System.out.println("Server says: Guess the number [1-10]: ");
			number = scan.nextLine();
			out_socket.println(number);
		}
		
		System.out.println("You got it!!!");
		
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
