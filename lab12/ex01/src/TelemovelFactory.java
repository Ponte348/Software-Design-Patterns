public class TelemovelFactory {
    public Telemovel createTelemovel(String processador, Double preco, Integer memoria, String camera) {
        return Telemovel.creaTelemovel(processador, preco, memoria, camera);
    }
}
