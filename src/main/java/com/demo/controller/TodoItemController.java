package com.demo.controller;

import com.demo.model.TodoData;
import com.demo.model.TodoItem;
import com.demo.service.TodoItemService;
import com.demo.util.AttributeNames;
import com.demo.util.Mappings;
import com.demo.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private final TodoItemService todoItemService;

    // == constructor ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    // the attribute will be handle by item_list.jsp with jstl tag
    public TodoData todoData() {
        return todoItemService.getData();
    }

    // == handler methods ==
    // http://localhost:8080/todo-list-mvc/items
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    // return the view of form
    // reuse method for edit
    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(name = "id", required = false, defaultValue = "-1") int id, Model model) {
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        if (todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    // data-binding: getting data from form in model container
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        log.info("todoItem from form = {}", todoItem);
        // a new item is processed add it
        if (todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        // redirecting to item page
        return "redirect:/" + Mappings.ITEMS;
    }

    // TODO: 其實他這個做法並不好! 應該使用delete method
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int id) {
        log.info("Deleting item with id: {}", id);
        todoItemService.removeItem(id);
        // redirecting to item page
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam("id") int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.VIEW_ITEM;
    }

}
