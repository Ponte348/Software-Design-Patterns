public class LivroDisponivel implements State {
    @Override
    public boolean regista(Livro livro) {
        return false;
    }

    @Override
    public boolean requisita(Livro livro) {
        return true;
    }

    @Override
    public boolean reserva(Livro livro) {
        return true;
    }

    @Override
    public boolean cancelaReserva(Livro livro) {
        return false;
    }

    @Override
    public boolean devolve(Livro livro) {
        return false;
    }

    @Override
    public String toString() {
        return "Disponível";
    }
}
