package Tris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) {
        int port = 12345; // Porta su cui il server ascolta
        String message = null;

        ServerSocket server;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
        System.out.println("Server avviato. In attesa di connessioni...");
		System.out.println("Server in ascolto su "+server.getLocalSocketAddress());
		System.out.println("Server in ascolto su "+server.getInetAddress()+":"+server.getLocalPort());

        try {
            	
            while (true) {
                // Accetta e aspetta la connessione di un client una nuova connessione dal client
                Socket link = server.accept();
                System.out.println("Nuovo client connesso.");
                
				BufferedReader reader = new BufferedReader(new InputStreamReader(link.getInputStream()));
				PrintWriter writer = new PrintWriter(link.getOutputStream(), true);

                message = reader.readLine();
				
	            if ("Hello".equalsIgnoreCase(message)) {
	                // Calcola un tempo casuale basato sul numero di client attivi
	            	long delay = 1000;
	                System.out.println("Tempo di attesa per rispondere: " + delay + " ms");
	
	                Thread.sleep(delay);
	
	                // Invia la risposta al client
	                writer.println("World");
	                System.out.println("Risposta inviata al client: World");                    
	            }
            }
            
        } catch (Exception e) {
            System.err.println("Errore del server: " + e.getMessage());
            e.printStackTrace();
        } 
    }
}
