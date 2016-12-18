import java.net.MalformedURLException;
import java.net.URL;

public class Actividad5 {
	
	
	public static void Visualizar(URL url){
		
		//IMPRIMIMIMOS LA SALIDA DE LOS DIFERENTES MÉTODOS
		System.out.println("\tMétodo toString():" + url.toString());
		System.out.println("\tMétodo getProtocol():" + url.getProtocol());
		System.out.println("\tMétodo getHost():" + url.getHost());
		System.out.println("\tMétodo getPort():" + url.getPort());
		System.out.println("\tMétodo getFile():" + url.getFile());
		System.out.println("\tMétodo getUserInfo():" + url.getUserInfo());
		System.out.println("\tMétodo getPath():" + url.getPath());
		System.out.println("\tMétodo getAuthority():" + url.getAuthority());
		System.out.println("\tMétodo getQuery():" + url.getQuery());
	}
	

	public static void main(String[] args) {
		
		
		try {
			//CONTRUCTOR SIMPLE URL
			System.out.println("Constructor simple para una URL:");
			Visualizar(new URL("http://docs.oracle.com"));
			
			//CONSTRUCTOR PROTOCOLO HOST Y DIRECTORIO
			System.out.println("Constructor para protocolo, host y directorio:");
			Visualizar(new URL("http", "docs.oracle.com", "javase/7"));
			
			//CONTRUCTOR PROTOCOLO, HOST, PUERTO Y DIRECTORIO
			System.out.println("Constructor para protocolo, host, puerto y directorio:");
			Visualizar(new URL("http", "docs.oracle.com", 80, "javase/7"));
			
			//CONSTRUCTOR PARA OBJETO URL Y SU DIRECTORIO
			System.out.println("Constructor para un objeto URL y su directorio:");
			Visualizar(new URL(new URL("http://www.oracle.com"), "/javase/7/docs/api/java/net/URL.html"));
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
