public abstract class Chef {
    protected Chef nextChef;
    public abstract void setNexChef(Chef chef);
    public abstract void cook(Food food);
}
