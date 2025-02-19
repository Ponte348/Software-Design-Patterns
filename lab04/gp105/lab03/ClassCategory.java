public enum ClassCategory {
    EXECUTIVE("E", 0, 1, "Executiva"), TURISTIC("T", 1, 0, "Turística");
    
    private String classLetter;
    private Integer classOrder;
    private Integer orderInPlane;
    private String toString;

    ClassCategory(String classLetter, Integer classOrder, Integer orderInPlane, String toString){
        this.classLetter = classLetter;
        this.classOrder = classOrder;
        this.orderInPlane = orderInPlane;
        this.toString = toString;
    }
    
    public static String getClassLetter(ClassCategory airplaneClass) {
        return airplaneClass.classLetter;
    }

    public static Integer getClassOrder(ClassCategory airplaneClass) {
        return airplaneClass.classOrder;
    }

    public static Integer getOrderInPlane(ClassCategory airplaneClass) {
        return airplaneClass.orderInPlane;
    }

    public static String getToString(ClassCategory airplaneClass) {
        return airplaneClass.toString;
    }

    public static ClassCategory[] getAllClasses(){
        return values();
    }

    public static ClassCategory getClassFromLetter(String letter){
        for (int classIterator = 0; classIterator < getAllClasses().length; classIterator++){
            ClassCategory currentClass = getAllClasses()[classIterator];
            if (getClassLetter(currentClass).equals(letter)) return currentClass;
        }
        return null;
    }
}
