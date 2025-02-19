public abstract class Veiculo implements KmPercorridosInterface{
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private int quilometrosTemp;
    private int quilometrosTotal;
    private String id;


    public Veiculo(String matricula, String marca, String modelo, int potencia, String id) {
        if(isMatriculaValida(matricula))
            this.matricula = matricula;
        else
            throw new IllegalArgumentException("Matrícula inválida");
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.id = id;

    }
    public Veiculo(){
        this("Sem matrícula","Sem marca","Sem modelo", 0, "Sem id");
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        if(isMatriculaValida(matricula))
            this.matricula = matricula;
        else
            throw new IllegalArgumentException("Matrícula inválida");
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + "; Marca: " + marca + "; Modelo: " + modelo + "\n";
    }
    public boolean equals(Object o){
        if(o == null || this.getClass() != o.getClass())
            return false;
        Veiculo v = (Veiculo) o;
        return this.matricula.equals(v.matricula) && this.marca.equals(v.marca) && this.modelo.equals(v.modelo);
    }
    public int hashCode(){
        int hash = 103;
        hash = 31 * hash + (null == matricula ? 0 : matricula.hashCode());
        hash = 31 * hash + (null == marca ? 0 : marca.hashCode());
        hash = 31 * hash + (null == modelo ? 0 : modelo.hashCode());
        return hash;
    }

    public void trajeto(int quilometros) {
        quilometrosTemp = quilometros;
        quilometrosTotal += quilometros;
    }
    public int ultimoTrajeto() {
        return quilometrosTemp;
    }
    public int distanciaTotal() {
        return quilometrosTotal;
    }

    public boolean isMatriculaValida(String matricula){
        // Matriucla deve ser do formato XX-YY-XX onde X é um digito e Y uma letra
        if(matricula.length() != 8)
            return false;
        if(matricula.matches("^(?=.*\\d{2})(?=.*[A-Z]{2})(?=.*\\d{2})[A-Z\\d]{2}-[A-Z\\d]{2}-[A-Z\\d]{2}$"))
            return true;
        return false;
    }

}
