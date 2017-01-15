package models;

public class InitialParams implements InitParamsInterface {
    private int numberOfThreaads;
    private int messageQuantity;

    public InitialParams() {
        this.numberOfThreaads = 0;
        this.messageQuantity = 0;
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
