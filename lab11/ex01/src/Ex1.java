public class Ex1 {
    public static void main(String[] args) {

        //Criar as entidades
        Leilao leilao = new Leilao();

        Gestor gestor = new Gestor("Gestor1", leilao);

        Cliente c1 = new Cliente("C1", leilao);
        Cliente c2 = new Cliente("C2", leilao);
        Cliente c3 = new Cliente("C3", leilao);

        Produto carro = new Produto("Mercedes", 10000);
        Produto pc = new Produto("MacBook", 3000);
        Produto tlm = new Produto("Samsung S8", 1500);
        Produto vg = new Produto("Viagem de férias", 5600);
        Produto ps5 = new Produto("PlayStation5", 1200);

        //adicionar produtos a serem leiloados
        leilao.addProduct(carro);
        leilao.addProduct(pc);
        leilao.addProduct(tlm);
        leilao.addProduct(vg);
        leilao.addProduct(ps5);

        //manage dos produtos
        carro.subscribe(gestor);
        pc.subscribe(gestor);
        tlm.subscribe(gestor);
        vg.subscribe(gestor);
        ps5.subscribe(gestor);

        //leilões

        System.out.println("Leilão de um Mercedes\n");
        carro.setState(State.AUCTION);
        carro.bid(c3, 11000);
        carro.bid(c2, 12000);
        carro.bid(c3, 12100);
        carro.bid(c1, 13000);
        carro.bid(c2, 15000);
        carro.closeBidding();

        System.out.println("Leilão de uma PlayStation5\n");
        ps5.setState(State.AUCTION);
        ps5.bid(c3, 1201);
        ps5.bid(c2, 1300);
        ps5.bid(c3, 1200);
        tlm.bid(c1, 1400);
        ps5.bid(c2, 1400);
        ps5.closeBidding();
    }
}
