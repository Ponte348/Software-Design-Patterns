public interface Mediator {
    void notify(Colleague sender);
    void addColleague(Colleague colleague);
}