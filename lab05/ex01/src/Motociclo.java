public class Motociclo extends Veiculo {
    String tipo;

    public Motociclo(String matricula, String marca, String modelo, int potencia, String tipo, String id) {
        super(matricula, marca, modelo, potencia, id);
        this.tipo = tipo;
    }
    public Motociclo(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, "Sem tipo", "Sem id");
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Motociclo\n" + super.toString() + "Tipo: " + tipo + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Motociclo m = (Motociclo) o;
        return super.equals(m) && this.tipo == m.tipo;
    }
    public int hashCode(){
        return super.hashCode() + tipo.hashCode();
    }

}
