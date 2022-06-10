public class Staff extends Weapon{
    // Default constructor
    public Staff(){
        super(10,0,10);
    }

    // Value constructor
    public Staff(int damage,int speed,int mCost){
        super(damage,speed,mCost);
    }

    // Attack
    public void attack(Entity e){
        System.out.print(e.getName() + " has been dealt ");
        super.attack(e);
    }

    // toString
    public String toString() {
        return "staff";
    }
}