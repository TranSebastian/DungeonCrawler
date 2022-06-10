public class Sword extends Weapon{
    // Default constructor
    public Sword(){
        super(5,5,0);
    }

    // Value constructor
    public Sword(int damage,int speed){
        super(damage,speed,0);
    }

    // Attack
    public void attack(Entity e){
        System.out.print(e.getName() + " has been sliced for ");
        super.attack(e);
    }

    // toString
    public String toString() {
        return "sword";
    }
}