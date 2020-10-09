package task3;

import java.net.*;

public class ServerMain {
	
	public ServerMain() throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(3600);
		System.out.println("Port 3600 is now open.");
	
	
		while(true) {
			Socket socket = serverSocket.accept();
			ServerThread server_thread = new ServerThread(socket, this);
			Thread thread = new Thread(server_thread);
			thread.start();
		}
	}
	
	private int clientNumber = 1;
	
	public int getClientNumber() {
		return clientNumber++;
	}
	
	
	public static void main(String[] args) {
		try {
			new ServerMain();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
