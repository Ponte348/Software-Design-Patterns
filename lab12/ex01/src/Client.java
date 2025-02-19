public class Client {
    public static void main(String[] args) {
        Revista revista = new Revista();
        TelemovelFactory telemovelFactory = new TelemovelFactory();

        revista.addTelemovel(telemovelFactory.createTelemovel("Snapdragon 888", 999.99, 8, "108MP"));
        revista.addTelemovel(telemovelFactory.createTelemovel("Dimensity 1200", 699.99, 6, "64MP"));
        revista.addTelemovel(telemovelFactory.createTelemovel("Exynos 2100", 799.99, 8, "108MP"));
        revista.addTelemovel(telemovelFactory.createTelemovel("A14 Bionic", 1099.99, 6, "12MP"));
        revista.addTelemovel(telemovelFactory.createTelemovel("Kirin 9000", 899.99, 8, "50MP"));

        revista.setStrategy(new Bogosort());
        revista.sort("preco");
        System.out.println("\nSorted by price:");
        revista.printTelemovelList();

        revista.setStrategy(new Bubblesort());
        revista.sort("camera");
        System.out.println("\nSorted by camera:");
        revista.printTelemovelList();

        revista.setStrategy(new Quicksort());
        revista.sort("memoria");
        System.out.println("\nSorted by memory:");
        revista.printTelemovelList();
    }
}
