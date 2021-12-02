package jcat.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReaderThread extends Thread implements Runnable{
	private BufferedReader is;
	private int port;
	
	public ReaderThread(int port) {
		super();
		this.port=port;
	}

	@Override
	public void run() {
		try(Socket portSocket=(new ServerSocket(this.port).accept())) {
			System.out.println("Connection stablished with "+portSocket.getRemoteSocketAddress());
			is=new BufferedReader(new InputStreamReader(portSocket.getInputStream()));
			WriterThread writer=new WriterThread(portSocket);
			writer.start();
			String line="";
			while ((line=is.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
