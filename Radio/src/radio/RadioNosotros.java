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
public class RadioNosotros extends Radio{
    double[] FM= new double [12];
    double[] AM= new double [12];
    boolean estado=false;
    boolean onda=true; //true es FM y false AM
    double emisora=0;
    
   
    public void estado(){
        if(estado==false){
            estado=true; //si esta apagada la radio se enciende
        }else{
            estado=false; //si esta encendida la rado se apaga
        }
    }
    
    public void frecuencias(boolean direccion){ //direccion de aumento o disminucion de frecuencia
        if(direccion){
            if (onda){
                if(emisora==107.9){
                    emisora=87.9;
                }else{
                    emisora= (emisora+0.2);
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
            if (onda){
                if(emisora==87.9){
                    emisora=107.9;
                }else{
                    emisora=(emisora-0.2);
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
    //cambia la onda que tenga la rado (AM a FM o viceversa)
        if(valor==false){
            onda=true; //la onda cambia a FM
        }else{
            onda=false; //la onda cambia a AM
        }
    }
    
    public void guardar(int x){
        if(onda==true){
            FM[x]=emisora;
        }
        else{
            AM[x]=emisora;
        }
    }
    
    public void seleccionar (int y){
        if(onda){
            if(FM[y]==0){
                JOptionPane.showMessageDialog(null, "No hay ninguna emisora guardada!");
            }else{
                emisora=FM[y];
            }
            
        }else{
            if(AM[y]==0){
               JOptionPane.showMessageDialog(null, "No hay ninguna emisora guardada!"); 
            }
            else{
                emisora=AM[y];
            }
        }
    }  
    
}
