
public class Actividad14 extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recurso a = new Recurso(); 
		Recurso b = new Recurso(); 
		
		//CAMBIAMOS LA REFERENCIA EN LOS PARÁMETROS DE LOS HILOS
		//PARA RESOLVER EL DEADLOCK
		Hilo h1 = new Hilo(a, b, "uno"); 
		Hilo h2 = new Hilo(a, b, "dos"); 
		
		h1.start(); 
		h2.start(); 

		
		
	}

}
