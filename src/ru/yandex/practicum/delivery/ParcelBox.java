package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel>{
    private List<T> parcels;
    private int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        parcels = new ArrayList<T>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("Вес посылки превышает допустимый вес коробки");
        } else {
            parcels.add(parcel);
            currentWeight += parcel.getWeight();
        }
    }

    public void getAllParcels() {
        for (T parcel : parcels) {
            System.out.println(parcel);
        }
    }

    public int getBoxSize() {
        return parcels.size();
    }
}
