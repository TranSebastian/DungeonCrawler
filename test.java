//@Rilan @groggygreggory @Samyan
//LOL is fun hooray
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Player hero = new Player ();
        Player notHero = new Player();
        System.out.println(notHero.getHealth());
        hero.attack(notHero);
        System.out.println(notHero.getHealth());
        hero.die();
    }
}
