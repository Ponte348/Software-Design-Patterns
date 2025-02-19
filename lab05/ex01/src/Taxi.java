public class Taxi extends Ligeiro{
    private int licenca;

    public Taxi(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, int licenca, String id) {
        super(matricula, marca, modelo, potencia, num, capBagageira, id);
        this.licenca = licenca;
    }
    public Taxi(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, 0, 0, 0, "Sem id");
    }

    public int getLicenca() {
        return licenca;
    }
    public void setLicenca(int licenca) {
        this.licenca = licenca;
    }

    @Override
    public String toString() {
        return super.toString() + "Taxi de licença: " + licenca + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Taxi m = (Taxi) o;
        return super.equals(m) && this.licenca == m.licenca;
    }
    public int hashCode(){
        return super.hashCode() + licenca*733;
    }

}
