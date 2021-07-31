package com.demo.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

// data object for in-memory database
public class TodoData {

    // == fields ==
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList();

    // == constructors ==
    public TodoData() {
        // add dummy item
        addItem(new TodoItem("first", "first detail", LocalDate.now()));
        addItem(new TodoItem("second", "second detail", LocalDate.now()));
        addItem(new TodoItem("third", "third detail", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth detail", LocalDate.now()));
    }

    // == public method ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem toAdd) {
        // Null is handled by lomboak
        /*
        if (toAdd == null) {
            throw new NullPointerException("toAdd is a required parameter.");
        }
         */
        toAdd.setId(idValue);
        items.add(toAdd);
        idValue += 1;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();

            if (item.getId() == id) {
                itemListIterator.remove();
                break;
            }
        }
    }

    public TodoItem getItem(int id) {
        for (TodoItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate) {
        ListIterator<TodoItem> itemListIterator = items.listIterator();
        while (itemListIterator.hasNext()) {
            TodoItem item = itemListIterator.next();

            if (item.equals(toUpdate)) {
                itemListIterator.set(toUpdate);
                break;
            }
        }
    }
}
