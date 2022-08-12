package co.edu.utp.misiontic2022.santiagorojas.model.vo;

public class DeudasPorProyectoVo {
    private Integer id;
    private Double valor;

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public String toString(){
        return String.format("%3d %,15.1f", id, valor);
    }
    
}
