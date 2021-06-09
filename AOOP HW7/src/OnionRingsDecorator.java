public class OnionRingsDecorator extends BurgerDecorator implements Hamburger {
    public OnionRingsDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String serve() {
        return super.serve() + " with onion rings";
    }
}
