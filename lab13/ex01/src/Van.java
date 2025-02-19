public class Van implements Product{
    private String code;
    private String description;
    private double points;
    private ProductState state = new AvailableState();

    public Van(String codigo, String descricao, double pontos){
        code = codigo;
        description = descricao;
        points = pontos;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPoints(double points) {
        this.points = points;
    }
    @Override
    public String code() {
        return code;
    }
    @Override
    public String description() {
        return description;
    }
    @Override
    public double points() {
        return points;
    }

    @Override
    public String toString(){
        return "Van - Code: " + code + "; Description: " + description + "; Points: " + points;
    }

    @Override
    public boolean nextState(){
        state.nextState(this);
        return true;
    }

    public void setState(ProductState estado){
        state = estado;
    }

    @Override
    public boolean equals(Product p){
        if(this.code.equals(p.code()) &&
            this.description.equals(p.description()) &&
                this.points == p.points())
            return true;
        return false;
    }
    
}
