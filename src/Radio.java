/**
 * 
 */

/**
 * @author helmuthnistal
 *
 */
public class Radio {
	
	private boolean estado;
	private boolean frecuencia;
	private float emisora;
	private float[] fm;
	private float[] am;

	/**
	 * 
	 */
	public Radio() {
		// TODO Auto-generated constructor stub
		estado=false;
		frecuencia=true;
		emisora=100;
		fm = new float[11];
		am = new float[11];
	}
	
	public void estado(){
		estado=!estado;
		//false= apagado
		//true= encendido
	}
	
	public void frecuencia(){
		frecuencia=!frecuencia;
		if(frecuencia){
			emisora=(float) 87.8;
		}else{
			emisora=530;
		}
		//false= AM
		//true= FM
	}
	
	public void cambiar(boolean valor){
		if(frecuencia){//FM
			if(valor){
				if(emisora==107.8){//DE LIMITE SUPERIOR A INFERIOR
					emisora=(float) 87.8;
				}else{
					emisora+=0.2;
				}
			}else{
				if(emisora==87.8){//DE LIMITE INFERIOR A SUPERIOR
					emisora=(float) 107.8;
				}else{
					emisora+=-0.2;
				}
			}
		}else{//AM
			if(valor){
				if(emisora==1610){//DE LIMITE SUPERIOR A INFERIOR
					emisora=(float) 530;
				}else{
					emisora+=10;
				}
			}else{
				if(emisora==530){//DE LIMITE INFERIOR A SUPERIOR
					emisora=(float) 1610;
				}else{
					emisora+=-10;
				}
			}
		}
	}
	
	public void guardar(int x){
		if (frecuencia){//FM
			fm[x]=emisora;
		}else{//AM
			am[x]=emisora;
		}
	}
	
	public float seleccionar(int y){
		if (frecuencia){//FM
			if(fm[y]==0){
				return (float) 87.8;
			}else{
				return fm[y];
			}

		}else{//AM
			if(am[y]==0){
				return (float) 530;
			}else{
				return fm[y];
			}
		}
		
	}

}
