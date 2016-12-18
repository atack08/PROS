package Actividad_15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREAMOS EL SOCKET UDP
		try {
			DatagramSocket socketUDP =  new DatagramSocket(12348);
			System.out.println("Esperando datagrama.......");
			
			//CREAMOS EL DATAGRAMA PARA RECIBIR EL OBJETO
			byte[] recibidos = new byte[1024];
			DatagramPacket recepcionTenista = new DatagramPacket(recibidos, recibidos.length);
			
			//RECIBIMOS EL OBJETO
			socketUDP.receive(recepcionTenista);
			
			//CONVERTIMOS EL ARRAY DE BYTES A UN OBJETO TENISTA
			ByteArrayInputStream bytesIn = new ByteArrayInputStream(recibidos);
			ObjectInputStream entrada = new ObjectInputStream(bytesIn);
			
			//CREAMOS EL TENISTA
			Tenista tenista1 = (Tenista) entrada.readObject();
			System.out.println("Recibido el objeto: " + tenista1.getApellido() + " " + tenista1.getAltura());
			System.out.println("IP de origen: " + recepcionTenista.getAddress());
			System.out.println("Puerto de origen: " + recepcionTenista.getPort());
			
			
			//CERRAMOS STREAM ENTRADA OBJETO
			entrada.close();
			
			//MODIFICAMOS TENISTA
			tenista1.setApellido("Karlovic");
			tenista1.setAltura(208);
			
			//DEVOLUCIÓN DEL TENISTA MODIFICADO
			System.out.println("Envío el objeto: " + tenista1.getApellido() + " " + tenista1.getAltura());
			
			//CONVERTIMOS EL TENISTA A BYTE[] Y CREAMOS UN STREAM
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);
			//ESCRIBIMOS EL OBJETO
			out.writeObject(tenista1);
			
			//CERRAMOS OBJECT STREAM
			out.close();
			
			//CREAMOS ARRAY DE BYTES
			byte[] bufferObjeto = bs.toByteArray();
			
			//CREAMOS EL DATAGRAMA PARA ENVIAR EL OBJETO
			DatagramPacket envioTenista =  new DatagramPacket(bufferObjeto, bufferObjeto.length, InetAddress.getByName("localhost"),34567);
			socketUDP.send(envioTenista);
			
			//FIN DEL SERVIDOR
			bs.close();
			socketUDP.close();
			System.out.println("Fin del servidor");
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
