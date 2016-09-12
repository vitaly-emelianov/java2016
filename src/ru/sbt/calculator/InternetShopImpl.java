package ru.sbt.calculator;

import ru.sbt.InternetShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 9/12/16.
 */
public class InternetShopImpl implements InternetShop{ // Alt + Insert

    private final String[] availableItems =  {"item1", "222", "item2"};
    private final List<String>  orderedItems = new ArrayList<String>(); // Гиюкость кода


    @Override
    public void order(String itemId) {

    }

    @Override
    public String[] getAvailableItemId() {
        return new String[] {"item1", "222", "item2"};
    }

    @Override
    public String[] getoOrderedItemId() {
        return new String[0];
    }
}
