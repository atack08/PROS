package ACTIVIDAD9;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREAMOS SOCKET Y STREAM DE ENTRADA
		Socket socketCliente =  null;
		DataInputStream entrada = null;
		
		
		//HACEMOS UN LOOP INFINITO DE CONEXIONES AL SERVIDOR
		//DE ESTA MANERA SERÁ EL SERVIDOR EL QUE RECHAZE LA CONEXIÓN
		while(true){
			
			try {
				System.out.println("PROGRAMA CLIENTE INICIANDO");
				
				//INSTANCIAMOS SOCKET Y CREAMOS LA CONEXIÓN
				//CUANDO EL SERVIDOR NO ESTÉ ESCUCHANDO SALTARÁ UNA EXCEPCIÓN
				//Y SALDRÁ DEL LOOP
				socketCliente = new Socket("localhost", 6013);
				
				//INSTANCIAMOS STREAM DE ENTRADA Y LEEMOS/IMPRIMIMOS EL MENSAJE RECIBIDO
				entrada = new DataInputStream(socketCliente.getInputStream());			
				System.out.println("Recibiendo mensaje del servidor:");				
				System.out.println("\t" + entrada.readUTF() + "\n");
				
					
			} catch (UnknownHostException e) {
				System.out.println(e.getLocalizedMessage());
				break;
			} catch (IOException e) {
				//EXCEPCIÓN QUE CONTROLA EL ERROR QUE SE PRODUCE CUNADO EL SERVIDOR
				//NO ESTÁ ESCUCHANDO
				System.out.println("Connection refused: connect");
				break;
			}
			
		}
		
		try {
			entrada.close();
			socketCliente.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
