//@Rilan @groggygreggory @Samyan
//LOL is fun hooray
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Create scanner
        Scanner reader = new Scanner (System.in);

        // Declare variables
        boolean endGame = false;
        String weaponChoice="";
        int randomNum=0;

        // Create Player object
        System.out.print("For the best experience, make the console as big as possible\nEnter your name: ");
        String name=reader.nextLine();
        do {
            System.out.println("Which weapon would you like? club/staff/sword: ");
            weaponChoice=reader.nextLine();
        }while(!((weaponChoice.equals("club") || weaponChoice.equals("staff")) || weaponChoice.equals("sword") || weaponChoice.equals("kitchen gun") ) );
        Player hero = null;
        switch(weaponChoice) {
            case "club":
            hero = new Player (name,new Club());
            break;
            case "staff":
            hero = new Player (name,new Staff());
            break;
            case "sword":
            hero = new Player (name,new Sword());
            break;
            case "kitchen gun":
            hero = new Player (name,new KitchenGun());
            break;
            default:
            hero = new Player (name,new Club());
            break;
        }

        // Create array of names
        File names = new File ("names.txt");
        Scanner fileReader = new Scanner (names);
        String [] ranNam = fileReader.nextLine().split(", ");

        // Create SebastianTop10 object
        SebastianTop10 a = new SebastianTop10();

        // Loop until end of game
        while (hero.getHealth() > 0 && !endGame)
        {
            // Clear screen
            System.out.print("\033[H\033[2J");
    
            System.out.flush();

            // Create Enemy object
            Enemy beast = new Enemy(ranNam[(int) (Math.random()*ranNam.length)], getRWeapon());
            System.out.println("An enemy called "+beast.getName()+" has appeared, armed with a "+beast.getWeapon());
            

            // Loop until beast is dead
            do
            {
                // Print health bars
                System.out.print(hero.getName());
                for (int count = 0; count < hero.getHealth(); count++)
                {
                    System.out.print(":");
                }
                System.out.println("\t("+hero.getHealth()+")");
                System.out.print(beast.getName());
                for (int count = 0; count < beast.getHealth(); count++)
                {
                    System.out.print(":");
                }
                System.out.println("\t("+beast.getHealth()+")");

                System.out.println("\nPress enter to continue");
                
                reader.nextLine();

                // Clear screen
                System.out.print("\033[H\033[2J");
        
                System.out.flush();
                
                // Check which is first
                if(hero.getWeapon().getSpeed() > beast.getWeapon().getSpeed()) {
                    if(playerFirst(hero, beast, a)) {
                        return;
                    }
                }
                else if(beast.getWeapon().getSpeed() > hero.getWeapon().getSpeed()) {
                    if(enemyFirst(hero, beast, a)) {
                        return;
                    }
                }
                else {
                    randomNum=(int) (Math.random()*2);
                    if(randomNum == 0) {
                        if(playerFirst(hero, beast, a)) {
                            return;
                        }
                    }
                    else {
                        if(enemyFirst(hero, beast, a)) {
                            return;
                        }
                    }
                }
            }
            while (beast.getHealth() > 0);

            // Declare string variable
            String decision="";

            // Ask if player wants to leave game
            do
            {
                System.out.println("Would you like to leave? y/n");
                decision = reader.nextLine();
                if (decision.equals("y"))
                {
                    endGame = true;

                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    
                    System.out.println("Thanks for playing");
                    
                }
            }
            while (!decision.equals("y") && !decision.equals("n"));


        }
        System.out.println("Final score: "+hero.getGold());
        a.updateScoreList(hero.getGold(),hero.getName());
        System.out.println("High Scores\n"+a.returnScoreList());
    }

    // Get random weapon
    public static Weapon getRWeapon(){
        int r = (int)(Math.random()*4)+1;
        switch(r){
            case 1:return new Staff();
            case 2:return new Club();
            case 3:return new Sword();
            default: return new KitchenGun();
        }
    }

    // Player attacks first
    public static boolean playerFirst(Player hero, Enemy beast, SebastianTop10 a) throws IOException {
        // Attack beast
        if (hero.getMana()-hero.getWeapon().getCost() < 0) 
        {
            hero.setWeapon(new Fists ());
            System.out.println(hero.getName()+" is out of mana, and is now using their fists!");
        }
        
        hero.attack(beast);


        // Check if beast is alive
        if (beast.getHealth() > 0)
        {
            // Attack hero
            if (beast.getMana()-beast.getWeapon().getCost() < 0) 
            {
                beast.setWeapon(new Fists ());
                System.out.println(beast.getName()+" is out of mana, and is now using their fists!");
            }
        
            beast.attack(hero);

            // Check if hero is dead
            if (hero.getHealth() <= 0)
            {
                System.out.println("You ran out of health and died\nThanks for playing\nFinal score: "+(int)(hero.getGold()/4));
                a.updateScoreList((int)(hero.getGold()/4),hero.getName());
                System.out.println("High Scores\n"+a.returnScoreList());
                return true;
            }
        }
        else {
            // Add gold
            hero.setGold(hero.getGold()+beast.getGoldValue());
            System.out.println(hero.getName()+" gained "+beast.getGoldValue()+" gold and now has "+hero.getGold()+" gold");
        }
        return false;
    }

    // Enemy attacks first
    public static boolean enemyFirst(Player hero, Enemy beast, SebastianTop10 a) throws IOException {
        // Attack hero
        if (beast.getMana()-beast.getWeapon().getCost() < 0) 
        {
            beast.setWeapon(new Fists ());
            System.out.println(beast.getName()+" is out of mana, and is now using their fists!");
        }
        beast.attack(hero);
        
        // Check if hero is dead
        if (hero.getHealth() <= 0)
        {
            System.out.println("You ran out of health and died\nThanks for playing\nFinal score: "+(int)(hero.getGold()/4));
            a.updateScoreList((int)(hero.getGold()/4),hero.getName());
            System.out.println("High Scores\n"+a.returnScoreList());
            return true;
        }

        // Attack beast
        if (hero.getMana()-hero.getWeapon().getCost() < 0) 
        {
            hero.setWeapon(new Fists ());
            System.out.println(hero.getName()+" is out of mana, and is now using their fists!");
        }
        
        hero.attack(beast);

        // Check if beast is dead
        if(beast.getHealth() <= 0) {
            // Add gold
            hero.setGold(hero.getGold()+beast.getGoldValue());
            System.out.println(hero.getName()+" gained "+beast.getGoldValue()+" gold and now has "+hero.getGold()+" gold");
        }
        return false;
    }
}
