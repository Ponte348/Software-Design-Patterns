
public class VowelFilter extends TextDecorator {

    public VowelFilter(TextProcessor textProcessor){
        super(textProcessor);
    }

    @Override
    public String next(){
        return textProcessor.next().replaceAll("[AEIOUaeiou]", "");
    }
}
