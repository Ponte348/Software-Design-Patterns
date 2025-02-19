public class Mercadorias extends Veiculo {
    private int peso;
    private int cargaMax;

    public Mercadorias(String matricula, String marca, String modelo, int potencia, int peso, int cargaMax, String id) {
        super(matricula, marca, modelo, potencia, id);
        this.peso = peso;
        this.cargaMax = cargaMax;
    }
    public Mercadorias(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, 0, 0, "Sem id");
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getCargaMax() {
        return cargaMax;
    }
    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "Pesado de Mercadorias\n" + super.toString() + "Peso: " + peso + "; Carga Máxima: " + cargaMax + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Mercadorias m = (Mercadorias) o;
        return super.equals(m) && this.peso == m.peso && this.cargaMax == m.cargaMax;
    }
    public int hashCode(){
        return super.hashCode() + peso*347 + cargaMax*569;
    }

}
