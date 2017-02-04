package models;

public class InitialParams implements InitParamsInterface {
    private int numberOfThreaads;
    private int messageQuantity;

    public InitialParams() {
        this.numberOfThreaads = 1;
        this.messageQuantity = 1;
    }

    @Override
    public int getMessageQuantity() {
        return messageQuantity;
    }

    @Override
    public int getNumberOfThreaads() {
        return numberOfThreaads;
    }

    @Override
    public void setNumberOfThreaads(int numberOfThreaads) {
        this.numberOfThreaads = numberOfThreaads;
    }

    @Override
    public void setMessageQuantity(int messageQuantity) {
        this.messageQuantity = messageQuantity;
    }
}
