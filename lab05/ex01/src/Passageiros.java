public class Passageiros extends Veiculo {
    private int peso;
    private int pasMax;

    public Passageiros(String matricula, String marca, String modelo, int potencia, int peso, int pasMax, String id) {
        super(matricula, marca, modelo, potencia, id);
        this.peso = peso;
        this.pasMax = pasMax;
    }
    public Passageiros(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, 0, 0, "Sem id");
    }

    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public int getPasMax() {
        return pasMax;
    }
    public void setPasMax(int pasMax) {
        this.pasMax = pasMax;
    }

    @Override
    public String toString() {
        return "Pesado de Passageiros\n" + super.toString() + "Peso: " + peso + "; Nº máximo de passageiros: " + pasMax + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Passageiros m = (Passageiros) o;
        return super.equals(m) && this.peso == m.peso && this.pasMax == m.pasMax;
    }
    public int hashCode(){
        return super.hashCode() + peso*347 + pasMax*569;
    }

}
