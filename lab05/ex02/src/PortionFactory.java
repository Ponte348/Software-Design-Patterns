public class PortionFactory{

    public static Portion create (String type, Temperature temperatura){
        if(type.equals("Beverage")){
            if(temperatura == Temperature.COLD){
                return new FruitJuice();
            }else{
                return new Milk();
            }
        }else{
            if(temperatura == Temperature.COLD){
                return new Tuna();
            }else{
                return new Pork();
            }
        }
    }
}
