public class SaladDecorator extends BurgerDecorator {
    public SaladDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String serve() {
        return super.serve() + " with salad";
    }
}
