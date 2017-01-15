package models;

public class InitialParams {
    private int numberOfThreaads;
    private int messageQuantity;

    public InitialParams() {
        this.numberOfThreaads = 0;
        this.messageQuantity = 0;
    }

    public int getMessageQuantity() {
        return messageQuantity;
    }

    public int getNumberOfThreaads() {
        return numberOfThreaads;
    }

    public void setConfiguration(int numberOfThreaads,int messageQuantity) {
        this.numberOfThreaads = numberOfThreaads;
        this.messageQuantity = messageQuantity;
    }
}
