public class Livro{
    private String titulo;
    private String ISBN;
    private int ano;
    private String autor;
    private State state;

    public Livro(String titulo, String ISBN, int ano, String autor, State state) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autor = autor;
        this.state = state;
    }

    public void regista() {
        if (state.regista(this)) {
            this.state = new LivroDisponivel();
        } else {
            System.out.println("Operação não disponível\n");
        }
    }

    public void requisita() {
        if (state.requisita(this)) {
            this.state = new LivroEmprestado();
        } else {
            System.out.println("Operação não disponível\n");
        }
    }

    public void reserva() {
        if (state.reserva(this)) {
            this.state = new LivroReservado();
        } else {
            System.out.println("Operação não disponível\n");
        }
    }

    public void cancelaReserva() {
        if (state.cancelaReserva(this)) {
            this.state = new LivroDisponivel();
        } else {
            System.out.println("Operação não disponível\n");
        }
    }

    public void devolve() {
        if (state.devolve(this)) {
            this.state = new LivroDisponivel();
        } else {
            System.out.println("Operação não disponível\n");
        }
    }
        
    @Override
    public String toString() {
        return titulo + "\t" + autor + "\t[" + state.toString() + "]";
    }
}
