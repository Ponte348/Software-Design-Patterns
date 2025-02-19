public class Cabazes {
    public static void main(String[] args) {
        Caixa principal = Caixa.createCaixa("Principal", 4);
        Caixa top = Caixa.createCaixa("Topo", 2);
        Caixa bot = Caixa.createCaixa("Especialidades", 2);
        top.add(Bebida.createBebida("Vinho Reserva UA 2017", 6));
        top.add(Bebida.createBebida("Vinho Reserva UA 2018", 6));
        principal.add(top);
        principal.add(bot);
        bot.add(Conserva.createConserva("Atum à Algarvia", 3));
        bot.add(Doce.createDoce("Morango", 2));
        top.add(Caixa.createCaixa("Interior", 1));
        top.add(Conserva.createConserva("Sardinhas em Azeite", 5));
        principal.draw();
    }
}
