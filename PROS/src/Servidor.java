import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*HE MANTENIDO EL SERVIDOR ESCUCHANDO PARA 
		QUE SOLO SE TENGA QUE REPETIR LA EJECUCIÓN DEL CLIENTE,
		DE ESTE MODO EL SERVIDOR DEVOLVERÁ EL NÚMERO AL CUADRADO 
		CADA VEZ QUE UN CLIENTE LO SOLICITE*/
		
		System.out.println("Esperando al cliente.....");
		
		//CREAMOS LOS STREAMS E/S Y EL SOCKET QUE SE CREARA CON CADA CONEXIÓN ENTRANTE
		DataInputStream entrada = null;
		DataOutputStream salida = null;
		Socket clienteConetado =  null;
		
		try {
			//CREAMOS E INSTANCIAMOS EL SERVER SOCKET
			ServerSocket socketServidor = new ServerSocket(6010);
		
			//HACEMOS UN LOOP PARA QUE EL SERVIDOR ESTÉ SIEMPRE A LA ESCUCHA
			while(true){
				
				try{
					//PONEMOS AL SERVIDOR A LA ESPERA DE UNA CONEXIÓN
					clienteConetado = socketServidor.accept();
					
					//INSTANCIAMOS LOS STREAMS E/S CON EL CLIENTE CONECTADO
					entrada =  new DataInputStream(clienteConetado.getInputStream());
					salida = new DataOutputStream(clienteConetado.getOutputStream());
					
					/*LEEMOS EL NÚMERO ENVIADO POR EL CLIENTE
					SI NO NOS HA ENVIADO UN NÚMERO SALTARÁ UNA EXCEPCIÓN 
					Y SE ENVIARÁ UN MENSAJE DE ERROR AL CLIENTE*/
					String datos = entrada.readUTF();
					int numero = Integer.parseInt(datos);
					
					//ENVIAMOS EL STRING CON EL RESULTADO 
					salida.writeUTF("El cuadrado del número " + numero + " es " + String.valueOf(numero*numero));
			
				}	
				catch (NumberFormatException e) {
			
					//CONTROLA QUE EL CLIENTE HAYÁ ENVIADO UN NÚMERO
					salida.writeUTF("Los datos enviados no tienen formato numérico");
			
				}
				
				//CERAMOS STREAMS E/S Y SOCKET DE CLIENTE
				entrada.close();
				salida.close();
				clienteConetado.close();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
