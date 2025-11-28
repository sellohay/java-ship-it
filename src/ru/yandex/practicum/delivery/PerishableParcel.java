package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{

    public static final int BASE_COST_PERISHABLE = 3;

    private int timeToLive;
    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    public int getBaseCost() {
        return BASE_COST_PERISHABLE;
    }

}

