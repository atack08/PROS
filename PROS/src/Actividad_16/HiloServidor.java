package Actividad_16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloServidor extends Thread {

	private Socket socketCliente;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private int port, localPort;
	private String ip, infoCom;
	private boolean conexion;

	public HiloServidor(Socket socketCliente) {
		super();
		this.socketCliente = socketCliente;
		this.port = socketCliente.getPort();
		this.localPort = socketCliente.getLocalPort();
		this.ip = socketCliente.getInetAddress().toString();
		this.infoCom = "Socket[addr=" + ip + ",port=" + port + ",localport=" + localPort + "]";
		this.conexion = true;
	}
	
	public void run(){
		
		System.out.println("Cliente conectado.....");
		
		//INSTANCIAMOS STREAM DE ENTRADA Y LEEMOS/IMPRIMIMOS EL MENSAJE RECIBIDO
		try {
			//INSTANCIAMOS LOS STREAMS
			salida = new DataOutputStream(socketCliente.getOutputStream());
			entrada = new DataInputStream(socketCliente.getInputStream());
			String cadenaRecibida = "";
			
			while(conexion){
				
				//TRATAMOS DE LEER EN EL STREAM
				cadenaRecibida = entrada.readUTF();
				
				if(!cadenaRecibida.equals("*"))
					System.out.println("Comunico con: " + infoCom);	
				else
					conexion = false;
				
				//DEVOLVEMOS CADENA EN MAYÚSCULAS
				salida.writeUTF(cadenaRecibida.toUpperCase());
			}
	
			System.out.println("Fin de la conexión con: " + infoCom);
			salida.close();
			entrada.close();
			socketCliente.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
