public class Cliente extends Observer{
    public String nome;
    Leilao leilao;
    public Cliente(String nome, Leilao leilao){
        this.nome = nome;
        this.leilao = leilao;
    }

    public void update(int ID){
        System.out.print(nome + " update: ");
        for (Produto prd : leilao.listOfProducts) {
            if (prd.getID() == ID && prd.getState() == State.SOLD) {
                System.out.println(prd.getDescricao() + " has been sold");
            }
            if (prd.getID() == ID && prd.getState() == State.AUCTION) {
                System.out.println(prd.getDescricao() + " has been bid for " + prd.getPrice());
            }
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
