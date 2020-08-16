package com.example.PashaWeb;


import com.example.PashaWeb.entity.Item;
import com.example.PashaWeb.entity.Shipping;
import com.example.PashaWeb.entity.Town;
import com.example.PashaWeb.service.ItemsService;
import com.example.PashaWeb.service.ShippingsService;
import com.example.PashaWeb.service.TownsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Bootstrap {

    private final ItemsService itemsService;
    private final TownsService townsService;
    private final ShippingsService shippingsService;

    public void init(){
        createAndFill(itemsService, townsService);
    }

    private void createAndFill(ItemsService itemsService, TownsService townsService) {
        Set<Map.Entry<Object, Object>> items = SampleDataLoader.readFile("items.txt");
        Set<Map.Entry<Object, Object>> towns = SampleDataLoader.readFile("towns.txt");

        for (Map.Entry<Object, Object> entry : items) {
            itemsService.createItem( (String) entry.getKey(), (String) entry.getValue());
        }

        for (Map.Entry<Object, Object> entry : towns) {
            townsService.createTown( (String) entry.getKey(), (String) entry.getValue());
        }
    }




    public void handle(Scanner scanner) {
        final String command = scanner.next();
        System.out.println("Command: " + command);
        switch (command) {
            case "add_item":
                String name = scanner.next();
                String quantity = scanner.next();
                itemsService.createItem(name, quantity);
                System.out.printf("Вы успешно добавили %s со значением %s", name, quantity);
                break;
            case "add_town":
                String townName = scanner.next();
                String distance = scanner.next();
                townsService.createTown(townName, distance);
                System.out.printf("Вы успешно добавили %s со значением %s", townName, distance);
                break;
            case "add_shipping":
                String itemId = scanner.next();
                String townId = scanner.next();
                String startDate = scanner.next();
                String endDate = scanner.next();

                shippingsService.createShipping(townId, itemId, startDate, endDate);
                break;
            case "delete_item":
                String idToRemoveItem = scanner.next();
                itemsService.deleteItem(idToRemoveItem);
                break;
            case "delete_town":
                String idToRemoveTown = scanner.next();
                townsService.deleteTown(idToRemoveTown);
                break;
            case "delete_shipping":
                String idToRemoveShipping = scanner.next();
                shippingsService.deleteShipping(idToRemoveShipping);
                break;
            case "show_items":
                Collection<Item> items = itemsService.showItems();
                printItems(items);
                break;
            case "show_towns":
                Collection<Town> towns = townsService.showTown();
                printTowns(towns);
                break;
            case "show_shippings":
                Collection<Shipping> shippings = shippingsService.showShippings();
                printShippings(shippings);
                break;
            default:
                throw new RuntimeException();
        }
    }

    private void printItems(Collection<Item> items) {
        for (Item item : items) {
            System.out.println(item.getId() + " " + item.getName() + " " + item.getQuantity());
        }
    }

    private void printTowns(Collection<Town> towns) {
        for (Town town : towns) {
            System.out.println(town.getId() + " " + town.getName() + " " + town.getDistance());
        }
    }

    public void printShippings(Collection<Shipping> shippings) {
        for (Shipping shipping : shippings) {
            System.out.println(shipping.getId() + " " + shipping.getTowns_id() + " " + shipping.getItems_id() + " " + shipping.getStart_date() + " " + shipping.getEnd_date());
        }
    }


}
