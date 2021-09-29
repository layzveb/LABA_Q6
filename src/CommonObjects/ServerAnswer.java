package CommonObjects;

import java.io.Serializable;

public class ServerAnswer implements Serializable {
    private static final long serialVersionUID = 666L;

    private String mes;
    
    public ServerAnswer(String mes){
        this.mes = mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return mes;
    }
}
