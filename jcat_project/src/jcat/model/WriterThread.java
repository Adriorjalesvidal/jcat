package jcat.model;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriterThread extends Thread implements Runnable {
	private PrintWriter writer;
	private Socket activeSocket;
	private Scanner sc;
	
	public WriterThread(Socket activeSocket) {
		this.activeSocket=activeSocket;
	}
	
	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	public Socket getActiveSocket() {
		return activeSocket;
	}

	public void setActiveSocket(Socket activeSocket) {
		this.activeSocket = activeSocket;
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void run() {
		try {
			writer=new PrintWriter(new OutputStreamWriter(activeSocket.getOutputStream()));
			sc=new Scanner(System.in);
			while (!activeSocket.isClosed()) {
				writer.print(sc.nextLine()+"\n");
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NoSuchElementException e) {
			System.out.println("exiting");
		}
	}
}
