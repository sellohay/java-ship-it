package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void calculateDeliveryCostStandard10() {
        StandardParcel standardParcel = new StandardParcel("Стандартная посылка", 10, "Москва", 5);
        int expected = 20;
        assertEquals(expected, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCostStandard20() {
        StandardParcel standardParcel = new StandardParcel("Стандартная посылка", 20, "Москва", 7);
        int expected = 40;
        assertEquals(expected, standardParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCostFragile1() {
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 1, "Нижний Новгород", 10);
        int expected = 4;
        assertEquals(expected, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCostFragile15() {
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка", 15, "Нижний Новгород", 10);
        int expected = 60;
        assertEquals(expected, fragileParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCostPerishable4() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 4, "Чебоксары", 12, 5);
        int expected = 12;
        assertEquals(expected, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void calculateDeliveryCostPerishable11() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка", 11, "Чебоксары", 12, 5);
        int expected = 33;
        assertEquals(expected, perishableParcel.calculateDeliveryCost());
    }

    @Test
    public void notExpired2DaysToLive() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 3, "Казань", 10, 7);
        assertFalse(parcel.isExpired(15));
    }

    @Test
    public void notExpired0DaysToLive() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 3, "Казань", 10, 7);
        assertFalse(parcel.isExpired(17));
        assertTrue(parcel.isExpired(18));
    }

    @Test
    public void expiredAlready() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 3, "Казань", 10, 7);
        assertTrue(parcel.isExpired(19));
    }

    @Test
    public void addToStandardParcelBox() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(60);
        StandardParcel p1 = new StandardParcel("Посылка 1", 20, "Москва", 1);
        StandardParcel p2 = new StandardParcel("Посылка 2", 30, "Нижний Новгород", 2);
        StandardParcel p3 = new StandardParcel("Посылка 3", 35, "Казань", 3);
        box.addParcel(p1);
        box.addParcel(p2);
        assertEquals(box.getBoxSize(), 2);
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 2);
    }

    @Test
    public void addToFragileParcelBox() {
        ParcelBox<FragileParcel> box = new ParcelBox<>(40);
        FragileParcel p1 = new FragileParcel("Посылка 1", 30, "Москва", 1);
        FragileParcel p2 = new FragileParcel("Посылка 2", 20, "Нижний Новгород", 2);
        FragileParcel p3 = new FragileParcel("Посылка 3", 10, "Казань", 3);

        box.addParcel(p1);
        assertEquals(box.getBoxSize(), 1);
        box.addParcel(p2);
        assertEquals(box.getBoxSize(), 1);
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 2);
    }

    @Test
    public void addToPerishableParcelBox() {
        ParcelBox<PerishableParcel> box = new ParcelBox<>(50);
        PerishableParcel p1 = new PerishableParcel("Посылка 1", 30, "Москва", 1, 5);
        PerishableParcel p2 = new PerishableParcel("Посылка 2", 20, "Нижний Новгород", 2, 10);
        box.addParcel(p1);
        box.addParcel(p2);
        assertEquals(box.getBoxSize(), 2);
        PerishableParcel p3 = new PerishableParcel("Посылка 3", 0, "Казань", 3, 15);
        box.addParcel(p3);
        assertEquals(box.getBoxSize(), 3);
    }
}
