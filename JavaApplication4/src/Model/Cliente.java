package Model;

public class Cliente {

    public Cliente(int codigocliente, String nomeCliente, String enderecoCliente, String bairroCliente, String CPFCliente ){
        this.codigocliente = codigocliente;
        this.nomeCliente = nomeCliente;
        this.enderecoCliente = enderecoCliente;
        this.bairroCliente = bairroCliente;
        this.CPFCliente = CPFCliente;
    }
    
    private int codigocliente;
    private String nomeCliente ;
    private String enderecoCliente ;
    private String bairroCliente ;
    private String CPFCliente ;

    public Cliente() {
        
        
    }
 

    public int getCodigocliente() {
        return codigocliente;
    }

    /**
     * @param codigocliente the codigocliente to set
     */
    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the enderecoCliente
     */
    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    /**
     * @param enderecoCliente the enderecoCliente to set
     */
    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    /**
     * @return the bairroCliente
     */
    public String getBairroCliente() {
        return bairroCliente;
    }

    /**
     * @param bairroCliente the bairroCliente to set
     */
    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }
      /**
     * @return the codigocliente
     */
    public String getCPFCliente() {
        return CPFCliente;
    }

    /**
     * @param CPFCliente the CPFCliente to set
     */
    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }    
}

