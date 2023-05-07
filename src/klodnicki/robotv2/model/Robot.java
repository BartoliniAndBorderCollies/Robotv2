package klodnicki.robotv2.model;

import klodnicki.robotv2.RobotMovement;
import klodnicki.robotv2.exception.MaximumEnergyLevelException;
import klodnicki.robotv2.exception.TooLowEnergyException;
import klodnicki.robotv2.exception.RobotNotTurnedOnException;

public class Robot {

    private String name;
    private int energyLevel;
    private boolean isOn;

    public Robot(String name) {
        this.name = name;
        energyLevel = 100;
        isOn = true;
    }

    public Robot(String name, int energyLevel, boolean isOn) {
        this.name = name;
        this.isOn = isOn;
        this.energyLevel = energyLevel;
    }



    public String move(RobotMovement robotMovement) throws TooLowEnergyException, RobotNotTurnedOnException {
        if (energyLevel < robotMovement.getMoveCost()) {
            throw new TooLowEnergyException(energyLevel, robotMovement.getMoveCost());
        }
        if (!isOn) {
            throw new RobotNotTurnedOnException();
        }
        energyLevel -= robotMovement.getMoveCost();
        return robotMovement.getAction();
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEnergyLevel(int energyLevel) throws MaximumEnergyLevelException {
        if (energyLevel > 100) {
            throw new MaximumEnergyLevelException(name);
        }
        this.energyLevel = energyLevel;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "Robot " + name;
    }
}
