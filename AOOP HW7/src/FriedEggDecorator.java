public class FriedEggDecorator extends BurgerDecorator {
    public FriedEggDecorator(Hamburger hamburger) {
        super(hamburger);
    }

    public String serve() {
        return super.serve() + " with fried egg";
    }
}
