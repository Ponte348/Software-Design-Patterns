public class Ex01 {

    public static void main(String[] args){

        Rental r = new Rental("Rental", "1234-567", "a@ua.pt"); 
        r.addVeiculo(VehicleFactory.createMotociclo("00-AB-12", "Honda", "CBR 600", 100, "desportivo", "MOTO123456789")); 
        r.addVeiculo(VehicleFactory.createAutomovelLigeiro("22-CD-34", "Volkswagen", "Golf", 150, 5, 500, "LIG123456789"));
        r.addVeiculo(VehicleFactory.createTaxi("44-EF-56", "Mercedes-Benz", "Classe E", 200, 5, 500, 123456789, "TAXI123456789"));
        r.addVeiculo(VehicleFactory.createPPEletrico("77-HI-89", "Tesla", "Model S", 500, 5, 500, 1000, 2000, "PPE123456789"));
        r.addVeiculo(VehicleFactory.createALEletrico("88-IJ-90", "Tesla", "Model X", 500, 5, 500, 1000, 2000, "ALE123456789"));
        r.addVeiculo(VehicleFactory.createPesadoMercadorias("66-GH-78", "Volvo", "FH", 500, 2000, 20000, "PME123456789"));
        r.addVeiculo(VehicleFactory.createPesadoPassageiros("99-JK-00", "Volvo", "9700", 500, 50, 3, "PPE123456789"));
 
        for(Veiculo v : r.getStock()){
            System.out.println(v); 
        }
    }
}
