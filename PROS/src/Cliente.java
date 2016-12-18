import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("PROGRAMA CLIENTE INICIANDO");
		System.out.println("Introduce un número");

		//LEEMOS LA ENTRADA DEL TECLADO
		Scanner entradaDatos = new Scanner(System.in);
		String numero = entradaDatos.nextLine();
		
		//CERRAMOS LA ENTRADA DEL TECLADO
		entradaDatos.close();
		
		try {
			//CREAMOS EL SOCKET DEL CLIENTE
			Socket socketCliente = new Socket("localhost", 6010);
			
			//CREAMOS EL STREAM DE SALIDA Y ENVIAMOS EL NÚMERO INTRODUCIDO
			DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
			salida.writeUTF(numero);
			
			//CREAMOS EL STREAM DE ENTRADA Y ESPERAMOS LA RESPUESTA DEL SERVIDOR
			DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
			System.out.println("Recibiendo mensaje del servidor:");
			
			//RECOGEMOS RESPUESTA DEL SERVIDOR E IMPRIMIMOS POR PANTALLA
			String datosRecibidos = entrada.readUTF();		
			System.out.println("\t" + datosRecibidos);
			
			//CERRAMOS STREAMS Y SOCKET
			entrada.close();
			salida.close();
			socketCliente.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
