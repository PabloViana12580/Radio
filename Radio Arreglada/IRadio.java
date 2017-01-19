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
public interface IRadio {
    
    public void estado();
    
    public void frecuencia();
    
    public void cambiar (boolean valor);
    
    public void guardar(int x);
    
    public float seleccionar (int y);
    
    public boolean getFrecuencia();
    
    public boolean getEstado();
    
    public float getEmisora();

}

