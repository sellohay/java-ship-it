package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
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

}
