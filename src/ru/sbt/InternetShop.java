package ru.sbt;

/**
 * Created by vitaly on 9/12/16.
 */
public interface InternetShop { // нет множественного наследования, но может релизовать большое количетсов интерфейсов
    void order(String itemId);
    String[] getAvailableItemId();
    String[] getoOrderedItemId();
}
