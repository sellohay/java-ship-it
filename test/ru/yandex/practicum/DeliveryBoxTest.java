package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryBoxTest {

    @Test
    public void addWeightNotOverLimit() {
        ParcelBox<FragileParcel> box = new ParcelBox<>(40);
        FragileParcel p1 = new FragileParcel("Посылка 1", 20, "Москва", 1);
        FragileParcel p3 = new FragileParcel("Посылка 3", 10, "Казань", 3);
        box.addParcel(p1);
        assertEquals(box.getBoxSize(), 1);
        assertTrue(box.getAllParcels().contains(p1));
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 2);
        assertTrue(box.getAllParcels().contains(p3));
    }

    @Test
    public void addWeightOverLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(50);
        StandardParcel p2 = new StandardParcel("Посылка 2", 30, "Нижний Новгород", 2);
        StandardParcel p3 = new StandardParcel("Посылка 3", 35, "Казань", 3);

        box.addParcel(p2);
        assertEquals(box.getBoxSize(), 1);
        assertTrue(box.getAllParcels().contains(p2));
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 1);
        assertFalse(box.getAllParcels().contains(p3));
    }

    @Test
    public void addWeightUpToLimit() {
        ParcelBox<PerishableParcel> box = new ParcelBox<>(50);
        PerishableParcel p1 = new PerishableParcel("Посылка 1", 30, "Москва", 1, 5);
        PerishableParcel p2 = new PerishableParcel("Посылка 2", 20, "Нижний Новгород", 2, 10);
        PerishableParcel p3 = new PerishableParcel("Посылка 3", 0, "Чебоксары", 3, 15);

        box.addParcel(p1);
        assertEquals(box.getBoxSize(), 1);
        assertTrue(box.getAllParcels().contains(p1));
        box.addParcel(p2);
        assertEquals(box.getBoxSize(), 2);
        assertTrue(box.getAllParcels().contains(p2));
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 3);
        assertTrue(box.getAllParcels().contains(p3));
    }

}
