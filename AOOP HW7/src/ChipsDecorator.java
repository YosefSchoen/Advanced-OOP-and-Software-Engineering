public class ChipsDecorator extends BurgerDecorator {
    public ChipsDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String serve() {
        return super.serve() + " with chips";
    }
}
