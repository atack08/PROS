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
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//INSTANCIAMOS EL OBJETO TENISTA
		Tenista tenista1 = new Tenista("del Potro", 198);
		
		//CREAMOS EL SOCKET UDP PARA ENVIAR AL TENISTA
		try {
			DatagramSocket socketUDP =  new DatagramSocket(34567, InetAddress.getByName("localhost"));
			
			//CONVERTIMOS EL TENISTA A BYTE[] Y CREAMOS UN STREAM
			ByteArrayOutputStream bs = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bs);
			
			//ESCRIBIMOS EL OBJETO
			out.writeObject(tenista1);
			
			//CERRAMOS OBJECT STREAM
			out.close();
			
			//CREAMOS ARRAY DE BYTES
			byte[] bufferObjeto = bs.toByteArray();
			bs.close();
			
			//CREAMOS EL DATAGRAMA PARA ENVIAR EL OBJETO
			System.out.println("Envío el objeto: " + tenista1.getApellido() + " " + tenista1.getAltura());
			DatagramPacket envioTenista =  new DatagramPacket(bufferObjeto, bufferObjeto.length, InetAddress.getByName("localhost"),12348);
			
			//ENVIAMOS EL DATAGRAMA Y ESPERAMOS RESPUESTA
			socketUDP.send(envioTenista);
			System.out.println("Esperando datagrama.......");
			
			//CREAMOS EL DATAGRAMA PARA RECIBIR EL OBJETO
			byte[] recibidos = new byte[1024];
			DatagramPacket recepcionTenista = new DatagramPacket(recibidos, recibidos.length);
			
			//RECIBIMOS EL OBJETO
			socketUDP.receive(recepcionTenista);
			
			//CONVERTIMOS EL ARRAY DE BYTES A UN OBJETO TENISTA
			ByteArrayInputStream bytesIn = new ByteArrayInputStream(recibidos);
			ObjectInputStream entrada = new ObjectInputStream(bytesIn);
			
			
			//CREAMOS EL TENISTA, CERRAMOS STREAMS Y SOCKETS
			tenista1 = (Tenista) entrada.readObject();
			entrada.close();
			bytesIn.close();
			socketUDP.close();
			
			System.out.println("He recibido el objeto: " + tenista1.getApellido() + " " + tenista1.getAltura());
			System.out.println("Fin del cliente");
			
			
			
			
			
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
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
