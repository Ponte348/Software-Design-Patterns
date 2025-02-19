public abstract class TextDecorator implements TextProcessor{
    protected TextProcessor textProcessor;
    
    public TextDecorator(TextProcessor textProcessor){
        this.textProcessor = textProcessor;
    }

    @Override
    public boolean hasNext(){
        return textProcessor.hasNext();
    }

}
