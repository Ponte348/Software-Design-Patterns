import java.text.Normalizer;

public class NormalizationFilter extends TextDecorator {

    public NormalizationFilter(TextProcessor textProcessor){
        super(textProcessor);
    }

    @Override
    public String next(){
        String text = this.textProcessor.next();

        String output = Normalizer.normalize(text, Normalizer.Form.NFD); //remover acentuação

        return output.replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{Punct}", "");//remover pontuação
    }
}
