import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Actividad6 {

	private static void VisualizarConexion (URLConnection conexion){
		
		System.out.println("Conexión con www.kaixo.com");
		System.out.println("==========================");
		
		System.out.println("\tMétodo toString():" + conexion.toString());
		System.out.println("\tMétodo Fecha():" + conexion.getDate());
		System.out.println("\tMétodo getContentType():" + conexion.getContentType());
		
		System.out.println("Campos Cabecera con getHeaderField:");
		System.out.println("====================================");
		
		//MOSTRAMOS LA CABECERAS 1 A 1
		System.out.println("\tLínea 1:" + conexion.getHeaderField(0));
		System.out.println("\tLínea 2:" + conexion.getHeaderField(1));
		System.out.println("\tLínea 3:" + conexion.getHeaderField(2));
		System.out.println("\tLínea 4:" + conexion.getHeaderField(3));
		System.out.println("\tLínea 5:" + conexion.getHeaderField(4));
		
		System.out.println("Campos Cabecera con getHeaderFields:");
		System.out.println("====================================");
		
		//CREAMOS MAPA A PARTIR DEL MÉTODO GETHEADERFIELDS
		Map<String, List<String>> mapaHeaders = conexion.getHeaderFields();
		
		//CREAMOS ITERATOR PARA RECORRER EL MAPA E IR IMPRIMIENDO LAS HEADERS
		Iterator it = mapaHeaders.keySet().iterator();
		
		while (it.hasNext()) {
			String header = (String)it.next();
			
			//SACAMOS LA LISTA CON LOS DIFERENTES VALORES DE LAS HEADERS
			List<String> listaHeaders = mapaHeaders.get(header);
			for(String content: listaHeaders){
				System.out.println(header + ":[" + content + "]");
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			//CREAMOS URL Y LA URL CONNECTION A PARTIR DE LA URL
			URL url = new URL("http://www.kaixo.com");
			URLConnection conexion = url.openConnection();
			
			//LLAMAMOS AL MÉTODO PARA VISUALIZAR LOS DATOS DE LA URL CONNECTION
			VisualizarConexion(conexion);
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
