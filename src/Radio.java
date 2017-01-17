/**
 * @author Jos�Pablo
 * @author helmuthnistal
 * @author Ricardo
 * Esta ser� la interface que definir� los m�todos de todos los radios
 */

public interface Radio {
	
	/**
	 * Este m�todo servir� para saber si el radio se encuentra encendido o apagado
	 */
	public void estado();
	
	/**
	 * Aqui estableceremos si se encuentra en frecuencia FM o AM
	 */
	public void frecuencia();
	
	/**
	 * Con este m�todo cambiaremos de estaci�n dependiendo en qu� frecuencia se encuentre el usuario
	 */
	public void cambiar(boolean valor);
	
	/**
	 * Con el m�todo se asignara un espacio de memoria donde se guardar�n las estaciones predilectas del usuario
	 */
	public void guardar(int x);
	
	/**
	 * Se cambiar� a una de las emisoras guardadas por el usuario en los espacio de memoria
	 */
	public float seleccionar(int y);
	
}
