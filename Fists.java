public class Fists extends Weapon{
    // Default constructor
    public Fists(){
        super(5, 0, 0);
    }

    // Value constructor
    public Fists (int damage,int speed){
        super(damage,speed,0);
    }

    // Attack
    public void attack(Entity e){
        System.out.print(e.getName() + " has been punched for ");
        super.attack(e);
    }

    // toString
    public String toString() {
        return "fists";
    }
}