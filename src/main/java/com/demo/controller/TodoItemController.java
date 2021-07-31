package com.demo.controller;

import com.demo.model.TodoData;
import com.demo.util.Mappings;
import com.demo.util.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TodoItemController {

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return new TodoData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list-mvc/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }
}
