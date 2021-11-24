import Controller.PlayerController;
import Helpers.MenuHelper;


public class Main {



    public static void main(String[] args) {
        new PlayerController().switchMethod();
        MenuHelper.menu();
    }
}
