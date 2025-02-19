public class Empresa {
    private String nome;
    private String postal;
    private String email;
    private Veiculo[] veiculos;

    public Empresa(String nome, String postal, String email, Veiculo[] veiculos) {
        this.nome = nome;
        this.postal = postal;
        this.email = email;
        this.veiculos = veiculos;
    }
    public Empresa(){
        this("Sem nome","Sem postal","Sem email", new Veiculo[0]);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPostal() {
        return postal;
    }
    public void setPostal(String postal) {
        this.postal = postal;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Veiculo[] getVeiculos() {
        return veiculos;
    }
    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        String s = "Empresa: " + nome + "; Morada: " + postal + "; Email: " + email + "\nVeículos:\n";
        for(Veiculo v : veiculos)
            s += v.toString() + "\n";
        return s;
    }
}
