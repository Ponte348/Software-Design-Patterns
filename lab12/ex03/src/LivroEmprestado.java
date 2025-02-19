public class LivroEmprestado implements State {

    @Override
    public boolean regista(Livro livro) {
        return false;
    }

    @Override
    public boolean requisita(Livro livro) {
        return false;
    }

    @Override
    public boolean reserva(Livro livro) {
        return false;
    }

    @Override
    public boolean cancelaReserva(Livro livro) {
        return false;
    }

    @Override
    public boolean devolve(Livro livro) {
        return true;
    }

    @Override
    public String toString() {
        return "Emprestado";
    }
    
}
