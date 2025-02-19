public class VehicleFactory {
    public static Motociclo createMotociclo(String matricula, String marca, String modelo, int potencia, String tipo, String id){
        return new Motociclo(matricula, marca, modelo, potencia, tipo, id);
    }

    public static Ligeiro createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, String id){
        return new Ligeiro(matricula, marca, modelo, potencia, num, capBagageira, id);
    }

    public static Taxi createTaxi(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, int licenca, String id){
        return new Taxi(matricula, marca, modelo, potencia, num, capBagageira, licenca, id);
    }

    public static Mercadorias createPesadoMercadorias(String matricula, String marca, String modelo, int potencia, int peso, int cargaMax, String id){
        return new Mercadorias(matricula, marca, modelo, potencia, peso, cargaMax, id);
    }

    public static Passageiros createPesadoPassageiros(String matricula, String marca, String modelo, int potencia, int peso, int numPortas, String id){
        return new Passageiros(matricula, marca, modelo, potencia, peso, numPortas, id);
    }

    public static LigeiroEletrico createALEletrico(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, int autonomia, int carga, String id){
        return new LigeiroEletrico(matricula, marca, modelo, potencia, num, capBagageira, autonomia, carga, id);
    }

    public static PassageirosEletrico createPPEletrico(String matricula, String marca, String modelo, int potencia, int num, int capBagageira, int autonomia, int carga, String id){
        return new PassageirosEletrico(matricula, marca, modelo, potencia, num, capBagageira, autonomia, carga, id);
    }

}