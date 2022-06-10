public class Enemy extends Entity{
    // Declare instance variable
    private int goldValue;

    // Value constructor
    public Enemy(String name, Weapon weapon) {
        super(name, (int) (Math.random()*100) +1, 50, weapon);
        this.goldValue = (int)(Math.random()*10)+1;
    }

    // Default constructor
    public Enemy() {
        this("Enemy", new Sword());
    }

    // Get gold value
    public int getGoldValue() {
        return this.goldValue;
    }

    // Die
    protected void die(){
        System.out.println(getName()+" has been defeated");
    }
}