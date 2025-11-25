package ru.yandex.practicum.delivery;

public abstract class Parcel {

    public static final int BASE_COST_STANDARD = 2;
    public static final int BASE_COST_PERISHABLE = 3;
    public static final int BASE_COST_FRAGILE = 4;

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();

    @Override
    public String toString() {
        return "Посылка: " + description;
    }
}
