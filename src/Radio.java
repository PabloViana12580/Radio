/**
 * @author JoséPablo
 * @author helmuthnistal
 * @author Ricardo
 * Esta será la interface que definirá los métodos de todos los radios
 */

public interface Radio {
	
	/**
	 * Este método servirá para saber si el radio se encuentra encendido o apagado
	 */
	public void estado();
	
	/**
	 * Aqui estableceremos si se encuentra en frecuencia FM o AM
	 */
	public void frecuencia();
	
	/**
	 * Con este método cambiaremos de estación dependiendo en qué frecuencia se encuentre el usuario
	 */
	public void cambiar(boolean valor);
	
	/**
	 * Con el método se asignara un espacio de memoria donde se guardarán las estaciones predilectas del usuario
	 */
	public void guardar(int x);
	
	/**
	 * Se cambiará a una de las emisoras guardadas por el usuario en los espacio de memoria
	 */
	public float seleccionar(int y);
	
}
