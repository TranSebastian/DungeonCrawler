public class Player extends Entity{
    // Declare instance variable
    private int gold;

    // Value constructor
    public Player(String name, Weapon weapon) {
        super(name, 100, 50, weapon);
        this.gold=0;
    }

    // Default constructor
    public Player() {
        this("Player", new Sword());
    }

    // Get gold
    public int getGold() {
        return this.gold;
    }

    // Set gold
    public boolean setGold(int gold) {
        if(gold >= 0) {
            this.gold=gold;
            return true;
        }
        return false;
    }

    // Die
    protected void die(){
        System.out.println(getName()+" dies");
    }
}