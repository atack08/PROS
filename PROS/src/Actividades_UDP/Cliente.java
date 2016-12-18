package Actividades_UDP;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		try {
			
			DatagramSocket socketUDP = new DatagramSocket(34568);
		
			
			String num = "4";
			String mensaje = "Esperando respuesta...";
			byte[] bufferMsg = num.getBytes();
		
			DatagramPacket peticion =  new DatagramPacket(bufferMsg, bufferMsg.length, InetAddress.getLoopbackAddress(),12346);

			socketUDP.send(peticion);

			System.out.println("Esperando respuesta...");
			
			bufferMsg = new byte[4096];
			peticion = new DatagramPacket(bufferMsg, bufferMsg.length);
			
			socketUDP.receive(peticion);
			
			//RECIBIDO DATAGRAMA
			String c = new String(peticion.getData());
			int n = Integer.parseInt(c);
			String signo;
			if(n<0)
				signo="-";
			else
				signo = "+";
			
			System.out.println("Esperando respuesta...: el cubo de " + signo + " " + num + " es " + c);
			System.out.println("Adiós...");
			
			
			
			socketUDP.close();
			
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

	}

}
