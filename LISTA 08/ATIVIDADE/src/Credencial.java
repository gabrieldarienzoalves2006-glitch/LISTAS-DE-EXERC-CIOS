public class Credencial {
    
    private String codigoHex;
    private boolean ativo;
    private titular: Funcionario;

    Credencial(String codigoHex, titular: funcionario);
    

    public String getCodigoHex() {
        return codigoHex;
    }
    public void setCodigoHex(String codigoHex) {
        this.codigoHex = codigoHex;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoHex == null) ? 0 : codigoHex.hashCode());
        result = prime * result + (ativo ? 1231 : 1237);
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Credencial other = (Credencial) obj;
        if (codigoHex == null) {
            if (other.codigoHex != null)
                return false;
        } else if (!codigoHex.equals(other.codigoHex))
            return false;
        if (ativo != other.ativo)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Credencial [codigoHex=" + codigoHex + ", ativo=" + ativo + "]";
    }


    
}
