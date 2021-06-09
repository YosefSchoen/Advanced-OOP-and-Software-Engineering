public class HaburgerDecoratorFactory {
    public static Hamburger decorate(String code, Hamburger hamburger) {
        BurgerDecorator decorator;
        switch (code) {
            case "ch":
                decorator = new ChipsDecorator(hamburger);
                break;

            case "or":
                decorator = new OnionRingsDecorator(hamburger);
                break;

            case "sa":
                decorator = new SaladDecorator(hamburger);
                break;

            case "fe":
                decorator = new FriedEggDecorator(hamburger);
                break;

            default:
                throw new RuntimeException("not a valid topping");
        }

        return decorator;
    }
}
