public class Lab08ex01 {
    public static void main(String[] args) throws Exception {
        final String filename = "example.txt";

        TextProcessor file = new TextReader(filename);
        TextProcessor term = new TermFilter(new TextReader(filename));
        TextProcessor normalized = new NormalizationFilter(new TextReader(filename));
        TextProcessor vowel = new VowelFilter(new TextReader(filename));
        TextProcessor capitalized = new CapitalizationFilter(new TextReader(filename));

        System.out.println("-----------File-----------");
        while (file.hasNext()) {
            System.out.println(file.next());
        }

        System.out.println("-----------TermFilter-----------");
        while (term.hasNext()) {
            System.out.println(term.next());
        }

        System.out.println("-----------NormalizedFilter-----------");
        while (normalized.hasNext()) {
            System.out.println(normalized.next());
        }

        System.out.println("-----------VowelFilter-----------");
        while (vowel.hasNext()) {
            System.out.println(vowel.next());
        }

        System.out.println("-----------CapitalizedFilter-----------");
        while (capitalized.hasNext()) {
            System.out.println(capitalized.next());
        }
    }
}
