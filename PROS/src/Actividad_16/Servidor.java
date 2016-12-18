package Actividad_16;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREAMOS EL SOCKET SERVIDOR
		try {
			ServerSocket socketServidor = new ServerSocket(6000);
			
			//CREAMOS BUCLE INFINITO
			while (true){
				
				//CREAMOS EL SOCKET PARA EL CLIENTE QUE CONECTE
				Socket socketCliente = socketServidor.accept();
				
				//DIRIGIMOS EL CLIENTE CONECTADO A UN NUEVO HILO
				HiloServidor hS = new HiloServidor(socketCliente);
				hS.start();
				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
