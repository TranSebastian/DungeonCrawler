public abstract class Weapon{
    // Declare instance variables
    private int speed;
    private int damage;
    private int mCost;

    // Value constructor
    public Weapon(int damage,int speed, int mCost){
        this.speed = speed;
        this.damage = damage;
        this.mCost = mCost;
    }

    // Get damage
    public int getDamage(){
        return damage;
    }

    // Set damage
    public void setDamage(int d){
        if(d>0){
            damage = d;
        }
    }

    // Get speed
    public int getSpeed(){
        return speed;
    }

    // Set speed
    public void setSpeed(int s){
        speed = s;
    }

    // Get cost
    public int getCost(){
        return mCost;
    }

    // Attack
    public void attack(Entity e){
        // attacks entity "e" and removes health and mana from instance called from
        double dmg = damage*Math.random()*3;
        System.out.print((int)dmg+" damage\n");
        e.setHealth(e.getHealth()-(int)dmg);
    }

    // toString
    public abstract String toString();
}