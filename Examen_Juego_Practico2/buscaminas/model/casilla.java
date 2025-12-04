package model;
public class casilla {

    private boolean tieneMina;
    private boolean revelada;
    private int minasAlrededor;

   
    public casilla() {
        this.tieneMina = false;
        this.revelada = false;
        this.minasAlrededor = 0;
    }

    
    public boolean tieneMina() {
        return this.tieneMina;
    }

    public void setMina(boolean estado) {
        this.tieneMina = estado;
    }

    
    private boolean casillarevelada = false;
    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }

   
    public int getMinasAlrededor() {
        return minasAlrededor;
    }

    public void setMinasAlrededor(int minasAlrededor) {
        this.minasAlrededor = minasAlrededor;
    }
    @Override
    public String toString() {

        if (revelada && tieneMina) {
            return " X ";
        }

        if (revelada && minasAlrededor > 0) {
            return " " + minasAlrededor + " ";
        }

        if (revelada) {
            return " V ";
        }

        return " ■ ";
    
}


	public boolean isCasillarevelada() {
		return casillarevelada;
	}


	public void setCasillarevelada(boolean casillarevelada) {
		this.casillarevelada = casillarevelada;
	}

}
