public class Ligeiro extends Veiculo {
    private int num;
    private int capBagageira;

    public Ligeiro(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, String id) {
        super(matricula, marca, modelo, potencia, id);
        this.num = num;
        this.capBagageira = capBagageira;
    }
    public Ligeiro(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, 0, 0, "Sem id");
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    public int getCapBagageira() {
        return capBagageira;
    }
    public void setCapBagageira(int capBagageira) {
        this.capBagageira = capBagageira;
    }

    @Override
    public String toString() {
        return "Ligeiro\n" + super.toString() + "Número de cilindrada: " + num + "; Capacidade da bagageira: " + capBagageira + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Ligeiro m = (Ligeiro) o;
        return super.equals(m) && this.num == m.num && this.capBagageira == m.capBagageira;
    }
    public int hashCode(){
        return super.hashCode() + num*347 + capBagageira*569;
    }

}
