package ACTIVIDAD9;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	private static int peticiones;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//CREAMOS EL NÚMERO DE PETICIONES AL SERVIDOR
		//EL STREAM DE SALIDA Y EL SOCKET DEL CLIENTE
		peticiones = 0;
		DataOutputStream salida = null;
		Socket clienteConectado = null;
		
		//CREAMOS EL SOCKET DEL SERVIDOR
		ServerSocket socketServidor;
		
		System.out.println("Esperando a los clientes.....");
		
		try {
			
			//INSTANCIAMOS EL SOCKET DEL SERVIDOR
			socketServidor = new ServerSocket(6013);
			
			//ACEPTAMOS SOLO 3 PETICIONES
			//DESPUÉS CERRAMOS EL SOCKET DE CLIENTE Y DEJAMOS DE ESCUCHAR
			while( peticiones < 3){
				
				clienteConectado = socketServidor.accept();
				peticiones ++;
				
				//CREAMOS STREAM DE SALIDA Y ENVIAMOS MENSAJE
				salida = new DataOutputStream(clienteConectado.getOutputStream());				
				salida.writeUTF("Hola cliente " + peticiones);
				
				//CERRAMOS STREAM Y SOCKET
				salida.close();
				clienteConectado.close();
				
			}
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
