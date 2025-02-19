public class CapitalizationFilter extends TextDecorator {

    public CapitalizationFilter(TextProcessor textProcessor){
        super(textProcessor);
    }

    @Override
    public String next(){
        String text = this.textProcessor.next();

        if(text.length() == 1){
            return text.toUpperCase();
        }

        return Character.toUpperCase(text.charAt(0)) +
        text.substring(1, text.length() - 1) +
        Character.toUpperCase(text.charAt(text.length() - 1));

    }
}
