package jcat.controller;

import jcat.model.ReaderThread;

public class TcpListener {
	private int port;

	public TcpListener() {
	}

	public TcpListener(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void startListening() {
		ReaderThread reader=new ReaderThread(this.port);
		reader.start();
	}
}