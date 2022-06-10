public class Club extends Weapon{
    // Default constructor
    public Club(){
        super(10,-5,0);
    }

    // Value constructor
    public Club(int damage,int speed){
        super(damage,speed,0);
    }

    
    // Attack
    public void attack(Entity e){
        System.out.print(e.getName() + " has been clubbed for ");
        super.attack(e);
    }

    // toString
    public String toString() {
        return "club";
    }
}