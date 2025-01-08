package edu.guilford;

public class LotteryTicket {
 // attributes
    private int[] numbers;
    private int powerBall;
    // ticket number attribute
    private int ticketNumber;
    // constructor

    public LotteryTicket() {
        // create a new array of 5 integers
        numbers = new int[5];
        // set the ticket number to a random number between 1 and 1000
        ticketNumber = (int) (Math.random() * 1000) + 1;
        // set the power ball to a random number between 1 and 26
        powerBall = (int) (Math.random() * 26) + 1;
        // fill the array with random numbers between 1 and 69 without duplication
        for (int i = 0; i < 5; i++) {
            int number = (int) (Math.random() * 69) + 1;
            // check to see if the number is already in the array
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (numbers[j] == number) {
                    duplicate = true;
                    break;
                }
            }
            // if the number is a duplicate, decrement i so that we try again
            if (duplicate) {
                i--;
            } else {
                numbers[i] = number;
            }
        }
        
      
    }
    // getters
    public int[] getNumbers() {
        return numbers;
    }

    public int getPowerBall() {
        return powerBall;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    // toString method
    public String toString() {
        String result = "";
        for (int i = 0; i < 5; i++) {
            result += numbers[i] + " ";
        }
        result += "Powerball: " + powerBall + " Ticket Number: " + ticketNumber;
        return result;
    }

    // method to check winning ticket
    public boolean checkWinningTicket(int[] winningNumbers, int winningPowerBall) {
        // check the first 5 numbers
        for (int i = 0; i < 5; i++) {
            boolean match = false;
            for (int j = 0; j < 5; j++) {
                if (numbers[i] == winningNumbers[j]) {
                    match = true;
                    break;
                }
            }
            if (!match) {
                return false;
            }
        }
        // check the powerball
        if (powerBall != winningPowerBall) {
            return false;
        }
        return true;
    }

}
