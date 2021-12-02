package jcat.view;

import jcat.controller.TcpListener;

public class Main {
	public static void main(String[] args) {
		System.out.println("Java tcp listener");
		int maxparams=args.length;
		if (maxparams > 0) {
			if (args[0].equalsIgnoreCase("-l")) {
				if (maxparams > 1) {
					System.out.println("Starting listen on port "+args[1]);
					TcpListener tcpcon=new TcpListener(Integer.parseInt(args[1]));
					tcpcon.startListening();
				}
			} else {
				System.out.println("-l not detected. " + args[0] + "  Detected instead");
			}
		} else {
			System.out.println("Not enough arguments");
		}
	}
}