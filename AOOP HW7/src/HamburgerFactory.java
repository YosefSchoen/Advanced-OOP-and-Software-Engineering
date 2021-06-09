public class HamburgerFactory {
    public static Hamburger createHamburger(String code){
        //TODO: fix
        Hamburger hamburger;
        switch (code){
            case "cl":
                hamburger = new ClassicHamburger();
                break;

            case "sp":
                hamburger = new SpicyHamburger();
                break;

            case "la":
                hamburger = new LambHamburger();
                break;

            case "hm":
                hamburger = new HomemadeHamburger();
                break;

            default:
                throw new RuntimeException("wrong Hamburger");
        }

        return hamburger;
    }
}

