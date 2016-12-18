package Actividades_UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DatagramSocket socketUDP = null;
		
		try{
			
			//CREAMOS EL SOCKET UDP
			socketUDP =  new DatagramSocket(12346);
			byte[] msg = new byte[4096];

		
			//PONEMOS AL SERVIDOR A LA ESCUCHA DE PETICIONES
			while(true){
				
				System.out.println("Esperando datagrama...");
				
				//CONSTRUIMOS EL DATAGRAMA PARA RECIBIR LA PETICI�N
				DatagramPacket peticion = new DatagramPacket(msg, msg.length);
				
				socketUDP.receive(peticion);
				
				//RECIBIDO DATAGRAMA
				String c = new String(peticion.getData());
				
				int n = Integer.parseInt("4");
				String nCubo = String.valueOf(n*n*n);
				msg = nCubo.getBytes();
				
				System.out.println("Vamos a calcular el cubo de: " + c);
				System.out.println("IP de origen: "  + peticion.getAddress());
				System.out.println("Puerto de origen: " + peticion.getPort());
				System.out.println("Enviamos el resultado..." + nCubo);
				
				peticion = new DatagramPacket(msg, msg.length);
				
				socketUDP.send(peticion);
				
				System.out.println("Adíosss");
				
			
			}
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		socketUDP.close();
	}

}
