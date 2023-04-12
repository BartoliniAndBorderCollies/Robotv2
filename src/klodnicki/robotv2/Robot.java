package klodnicki.robotv2;

import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;

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
    public void move(RobotMovement robotMovement) throws TooLowEnergyException, RobotNotTurnedOnException {
        if (energyLevel < robotMovement.getMoveCost()) {
            throw new TooLowEnergyException(energyLevel, robotMovement.getMoveCost());
        }
        if (!isOn) {
            throw new RobotNotTurnedOnException();
        }
        energyLevel -= robotMovement.getMoveCost();
        System.out.println(robotMovement.getAction());
    }

    // robota można włączyć
    public void turnOn() {
        isOn = true;
    }

    // robota można wyłączyć
    public void turnOff() {
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

    public void setEnergyLevel(int energyLevel) throws MaximumEnergyLevelException {
        if (energyLevel>100) {
            throw new MaximumEnergyLevelException(name);
        }
        this.energyLevel = energyLevel;
    }

    public boolean isOn() {
        return isOn;
    }
}
