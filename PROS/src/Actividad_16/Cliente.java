package Actividad_16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREAMOS LA CADENA Y LA RECOGEMOS DE LA CONSOLA
		String cadena = "";
		Scanner scan = new Scanner(System.in);
		boolean conexion = true;
		
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		
		
		//INICIALIZAMOS EL SOCKET Y LOS STREAMS
		try {
			Socket socketCliente = new Socket("localhost", 6000);
			DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
			DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
			
			while (conexion){
				
				System.out.println("Introduce una cadena:");
				cadena = scan.nextLine();
				
				//ENVIAMOS LA CADENA
				salida.writeUTF(cadena);
				
				//COMPARAMOS PARA SEGUIR O NO CON LA CONEXIÓN
				if(cadena.equals("*"))
					conexion = false;
				
				//RECOGEMOS LA RESPUESTA
				cadena = entrada.readUTF();
				System.out.println("=>Respuesta:" + cadena);

			}
			//CERRAMOS STREAMS Y SOCKET
			scan.close();
			entrada.close();
			salida.close();
			socketCliente.close();

			System.out.println("Fin del envío....");
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
