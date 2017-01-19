/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import javax.swing.JOptionPane;

/**
 *
 * @author richi
 */
public class RadioNosotros implements IRadio{
    private double[] FM= new double [12];
    private double[] AM= new double [12];
    private boolean estado=false;
    private boolean frecuencia=true; //true es FM y false AM
    private float emisora=0;

    public double[] getFM() {
        return FM;
    }

    public double[] getAM() {
        return AM;
    }

    public boolean getEstado() {
        return estado;
    }

    public boolean getFrecuencia() {
        return frecuencia;
    }

    public float getEmisora() {
        return emisora;
    }

    public void setFM(double[] FM) {
        this.FM = FM;
    }

    public void setAM(double[] AM) {
        this.AM = AM;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFrecuencia(boolean frecuencia) {
        this.frecuencia = frecuencia;
    }

    public void setEmisora(float emisora) {
        this.emisora = emisora;
    }
    
   
    public void estado(){
        if(estado==false){
            estado=true; //si esta apagada la radio se enciende
        }else{
            estado=false; //si esta encendida la rado se apaga
        }
    }
    
    public void frecuencia(){ //direccion de aumento o disminucion de frecuencia
        boolean direccion=true;
        if(direccion){
            if (frecuencia){
                if(emisora==107.9){
                    emisora=(float)87.9;
                }else{
                    emisora= (float)(emisora+0.2);
                }
            }
            else{
                if(emisora==1610){
                    emisora=530;
                }else{
                    emisora=emisora+10;
                }
            }
        }
        else{
            if (frecuencia){
                if(emisora==87.9){
                    emisora=(float)107.9;
                }else{
                    emisora=(float)(emisora-0.2);
                }
            }
            else{
                if(emisora==530){
                    emisora=1610;
                }else{
                    emisora=emisora-10;
                }
            }
        }
    }
    
    public void cambiar (boolean valor){
    //cambia la frecuencia que tenga la rado (AM a FM o viceversa)
        if(valor==false){
            frecuencia=true; //la frecuencia cambia a FM
        }else{
            frecuencia=false; //la frecuencia cambia a AM
        }
    }
    
    //guarda la emisora
    public void guardar(int x){
        if(frecuencia==true){
            FM[x]=emisora;
        }
        else{
            AM[x]=emisora;
        }
    }
    
    //Selecciona emisora guardada
    public float seleccionar (int y){
        if(frecuencia){
            if(FM[y]==0){
                JOptionPane.showMessageDialog(null, "No hay ninguna emisora guardada!");
            }else{
                emisora=(float)FM[y];
            }
            
        }else{
            if(AM[y]==0){
               JOptionPane.showMessageDialog(null, "No hay ninguna emisora guardada!"); 
            }
            else{
                emisora=(float)AM[y];
            }
        }
        return (float) emisora;
    }  





    
}
