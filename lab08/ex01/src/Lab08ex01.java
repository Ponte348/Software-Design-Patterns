import java.util.Date;

public class Lab08ex01 {
    public static void main(String[] args) throws Exception {        
        Employee pedro = new BasicEmployee("Pedro");
        Employee joao = new BasicEmployee("Joao");
        Employee ricardo = new BasicEmployee("Ricardo");

        pedro.start(new Date());
        joao.start(new Date());
        ricardo.start(new Date());

        System.out.println("Employees:");
        System.out.println(pedro.work());
        System.out.println(joao.work());
        System.out.println(ricardo.work());

        System.out.println("\nDecorated Employees:");
        pedro = new TeamMemberDecorator(pedro);
        System.out.println(pedro.work());

        joao = new ManagerDecorator(joao);
        System.out.println(joao.work());

        ricardo = new TeamLeaderDecorator(ricardo);
        ricardo = new ManagerDecorator(ricardo);
        System.out.println(ricardo.work());
    }
}
