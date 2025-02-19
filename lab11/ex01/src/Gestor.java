public class Gestor extends Observer{
    String nome;
    Leilao leilao;

    public Gestor(String nome, Leilao leilao){
        this.nome = nome;
        this.leilao = leilao;
    }

    @Override
    public String toString(){
        return nome;
    }

    @Override
    public void update(int code) {
        System.out.print(nome + " update: ");
        for (Produto prd : leilao.listOfProducts) {
            if (prd.getID() == code && prd.getState() == State.SOLD) {
                System.out.println(prd.getDescricao() + " has been sold");
            }
            if (prd.getID() == code && prd.getState() == State.AUCTION) {
                System.out.println(prd.getDescricao() + " has been bid for " + prd.getPrice());
            }
        }
    }
}
