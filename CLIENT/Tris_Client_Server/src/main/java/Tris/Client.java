package Tris;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        // Configura l'indirizzo IP e la porta del server
        String serverAddress = "127.0.0.1"; // IP del server (localhost)
        int port = 12345; // Porta del server
        
        try {
            // Crea una connessione al server
            Socket socket = new Socket(serverAddress, port);
            
            // Ottiene l'output stream per inviare dati
            OutputStream out = socket.getOutputStream();            
            // Usa un PrintWriter per inviare RIGHE di testo al server
            PrintWriter writer = new PrintWriter(out, true);
        
            // Ottiene l'input stream per ricever dati
            InputStream in = socket.getInputStream();
            // Usa un BufferedReader per poter leggere RIGHE di testo            
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            
            // Invia il messaggio "Hello"
			long send = System.currentTimeMillis();
			writer.println("Hello");				
			System.out.println("Messaggio inviato al server: Hello");
			
			String answer = reader.readLine();
			System.out.println(answer);
			long receive = System.currentTimeMillis();
			
			System.out.println("Ricevuta risposta dopo:"+(receive-send)+"ms");				
        } catch (Exception e) {
            // Gestisce eventuali errori
            System.err.println("Errore: " + e.getMessage());
            e.printStackTrace();
        }
    }
}