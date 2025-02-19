import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<Livro>();
        livros.add(new Livro("Java Anti-Stress", "978085753", 2006, "Omodionah", new LivroInventario()));
        livros.add(new Livro("A Guerra dos Padroes", "978142812", 2000, "Jorge Omel", new LivroInventario()));
        livros.add(new Livro("A Procura da Luz", "978997198", -400, "Khumatkli", new LivroInventario()));
        
        System.out.println("*** Biblioteca ***");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println(i+1 + "\t" + livros.get(i));
        }
        System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela; (6)sair\n");
        
        while(true){
            String input = sc.nextLine();
            String[] parts = input.split(",");

            try{
                int index = Integer.parseInt(parts[0]) - 1;
                int operation = Integer.parseInt(parts[1]);

                switch(operation){
                    case 1:
                        livros.get(index).regista();
                        break;
                    case 2:
                        livros.get(index).requisita();
                        break;
                    case 3:
                        livros.get(index).devolve();
                        break;
                    case 4:
                        livros.get(index).reserva();
                        break;
                    case 5:
                        livros.get(index).cancelaReserva();
                        break;
                    case 6:
                        sc.close();
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Operação inválida!\n");
                }
            } catch (Exception e){
                System.out.println("Comando inválido!\n");
            }

            System.out.println("*** Biblioteca ***");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println(i+1 + "\t" + livros.get(i));
            }
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela\n");

        }
    }
}
