// what is a kitchen gun???
//https://www.youtube.com/watch?v=6-7NDP8V-6A

public class KitchenGun extends Weapon{
    // Default constructor
    public KitchenGun(){
        super(200, 10, 35);
    }

    // Value constructor
    public KitchenGun (int damage,int speed){
        super(damage,speed,35);
    }

    // Attack
    public void attack(Entity e){
        System.out.print(e.getName() + " has been cleansed for ");
        super.attack(e);
    }

    // toString
    public String toString() {
        return "Kitchen Gun";
    }
}