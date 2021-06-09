public abstract class BurgerDecorator implements Hamburger {
    private Hamburger hamburger;
    public BurgerDecorator(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    @Override
    public String serve() {
        return hamburger.serve();
    }
}
