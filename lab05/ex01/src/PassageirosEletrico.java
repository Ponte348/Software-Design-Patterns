public class PassageirosEletrico extends Passageiros implements VeiculoEletrico {
    private int autonomia;
    private int carga;

    public PassageirosEletrico(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, int autonomia, int carga, String id) {
        super(matricula, marca, modelo, potencia, num, capBagageira, id);
        this.autonomia = autonomia;
        this.carga = carga;
    }
    public PassageirosEletrico(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, 0, 0, 0, 0, "Sem id");
    }

    public int getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }
    public int getCarga() {
        return carga;
    }
    public void setCarga(int carga) {
        this.carga = carga;
    }

    @Override
    public String toString() {
        return super.toString() + "Autonomia: " + autonomia + "; Carga: " + carga + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        PassageirosEletrico m = (PassageirosEletrico) o;
        return super.equals(m) && this.autonomia == m.autonomia && this.carga == m.carga;
    }
    public int hashCode(){
        return super.hashCode() + autonomia*733 + carga*27;
    }

    public int autonomia() {
        return autonomia;
    }
    public void carregar(int carga) {
        this.carga = carga;
    }

}
