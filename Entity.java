public abstract class Entity{
    // Declare instance variables
    private String name;
    private int health;
    private int mana;
    private Weapon weapon;
    
    // Value constructor
    public Entity(String name, int health, int mana, Weapon weapon) {
        this.name=name;
        this.health=health;
        this.mana=mana;
        this.weapon=weapon;
    }

    // Default constructor
    public Entity() {
        this.name="Entity";
        this.health=100;
        this.mana=50;
        this.weapon=new Sword();
    }

    // Get name
    public String getName() {
        return this.name;
    }

    // Set name
    public void setName(String name) {
        this.name=name;
    }

    // Get health
    public int getHealth() {
        return this.health;
    }
    
    // Set health
    public void setHealth(int health) {
        if(health <= 0) {
            this.health=0;
            die();
        }
        else {
            this.health=health;
        }
    }

    // Get mana
    public int getMana() {
        return this.mana;
    }

    // Set mana
    public boolean setMana(int mana) {
        if(mana >= 0) {
            this.mana=mana;
            return true;
        }
        return false;
    }

    // Get weapon
    public Weapon getWeapon() {
        return this.weapon;
    }

    // Set weapon
    public void setWeapon(Weapon weapon) {
        this.weapon=weapon;
    }

    // Die
    protected abstract void die();
    
    //attacks other entity
    public void attack(Entity e){
        weapon.attack(e);
        this.mana-=weapon.getCost();
    }
}