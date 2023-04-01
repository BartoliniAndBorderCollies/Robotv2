public class Robot {

    // robot ma miec poziom energii wartośc od 0 do 100;
    private int energyLevel;
    private String name;
    private boolean isOn;

    public Robot(String name) {
        this.name = name;
        energyLevel = 100;
        isOn = true;
    }

    // robot ma wykonywać ruch
    public void move() {
        // bedziemy wykorzystywać enuma
    }

    // robota można włączyć
    public void turnOn(){
        isOn = true;
    }
    // robota można wyłączyć
    public void turnOff(){
        isOn = false;
    }
// można sprawdzić poziom energii robota
    public int getEnergyLevel() {
        return energyLevel;
    }

    //ustawienie imienia robota
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
