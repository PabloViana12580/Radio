/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;
/**
 *
 * @author richi
 */
public interface Radio {
    
    public void estado();
    
    public void frecuencias(boolean direccion);
    
    public void cambiar (boolean valor);
    
    public void guardar(int x);
    
    public void seleccionar (int y);

}

