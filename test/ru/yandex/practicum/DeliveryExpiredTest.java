package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeliveryExpiredTest {

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
}
