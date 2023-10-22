package service;

import states.Direction;
import states.Speed;
import states.UserInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

import static states.UserInput.*;

/**
 * Ceiling Fan designed with concurrency in mind in order to have the following 4 components running in non-blocking manner:
 *     Motor
 *     SpeedControl (Speed Cord)
 *     DirectionControl (Direction Cord)
 *     UserInput
 * The application uses a ConcurrentLinkedQueue to serve as the input signal channel to pass Speed-change or Direction-change
 *   signal from the controls to the motor.
 */
public class CeilingFan {

    private Motor motor;
    private SpeedControl speedControl;
    private DirectionControl directionControl;
    ConcurrentLinkedQueue<UserInput> inputSignalQueue;

    public CeilingFan() {
        this.motor = new CeilingFanMotor();
        this.speedControl = new CeilingFanSpeedControl(this.motor);
        this.directionControl = new CeilingFanDirectionControl(this.motor);
        this.inputSignalQueue = new ConcurrentLinkedQueue<>();

        // Ceiling Fan is always powered and operating once it's setup
        this.initializeMotor();
        this.initializeSpeedControl();
        this.initializeDirectionControl();
        this.initializeUserInputListener();
    }

    private void initializeMotor() {
        Thread motorThread = new Thread(() -> {
            while(true) {
                try {
                    // Simulate motor operating on its own thread
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println("Error occurred:" + e);
                }
            }
        });
        motorThread.start();
    }

    private void initializeSpeedControl() {
        Thread speedControlThread = new Thread(() -> {
            while(true) {
                if (this.inputSignalQueue.peek() == CHANGE_SPEED) {
                    this.inputSignalQueue.poll();
                    this.speedControl.changeSpeed();
                    System.out.println("Fan Speed changed. Current Speed: " + this.motor.getCurrentSpeed().getLabel());
                }
            }
        });
        speedControlThread.start();
    }

    private void initializeDirectionControl() {
        Thread directionControlThread = new Thread(() -> {
            while(true) {
                if (this.inputSignalQueue.peek() == CHANGE_DIRECTION) {
                    this.inputSignalQueue.poll();
                    this.directionControl.changeDirection();
                    System.out.println("Fan Direction changed. Current Direction: " + this.motor.getCurrentDirection().getLabel());
                }
            }
        });
        directionControlThread.start();
    }

    private void initializeUserInputListener() {
        Thread userInputListenerThread = new Thread(() -> {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the first letter for the following options: [S]peed change, [D]irection change:");
            while(true) {
                try {
                    String inputs = in.readLine();
                    if (inputs != null && inputs.toUpperCase().contains(CHANGE_SPEED.getLabel()))
                        this.pullSpeedCord();
                    if (inputs != null && inputs.toUpperCase().contains(CHANGE_DIRECTION.getLabel()))
                        this.pullDirectionCord();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println("Error occurred:" + e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        userInputListenerThread.start();
    }

    public void pullSpeedCord() {
        this.inputSignalQueue.offer(CHANGE_SPEED);
    }

    public void pullDirectionCord() {
        this.inputSignalQueue.offer(CHANGE_DIRECTION);
    }

    public Speed getCurrentFanSpeed() {
        return this.motor.getCurrentSpeed();
    }

    public Direction getCurrentFanDirection() {
        return this.motor.getCurrentDirection();
    }
}
