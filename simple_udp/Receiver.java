package simple_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receiver {

	public Receiver() throws Exception {
		
		DatagramSocket socket = new DatagramSocket(2020);
		System.out.println("Receiver is running");
		Scanner scan = new Scanner(System.in);
		
		byte[] buffer = new byte[1500]; //MTU -> Maximum Transmission Unit | 1500 is standard limit
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
		
		socket.receive(packet);
		
		String message = new String(buffer).trim();
		System.out.println("Received: " + message);
		
		InetAddress sender_address = packet.getAddress();
		int sender_port = packet.getPort();
		
		System.out.print("Enter your message: ");
		message = scan.nextLine();
		buffer = message.getBytes();
		packet = new DatagramPacket(buffer, buffer.length, sender_address, sender_port);
		socket.send(packet);
		
		System.out.print("Sent: " + message);
	}
	
	public static void main(String[] args) {
		try {
			new Receiver();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
