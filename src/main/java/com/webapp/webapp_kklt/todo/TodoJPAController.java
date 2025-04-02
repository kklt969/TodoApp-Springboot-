package com.webapp.webapp_kklt.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
public class TodoJPAController {


    public String getloggedinUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "todolist", method = RequestMethod.GET)
    public String gotoTodoList()
    {

        return "todolist";
    }

    @RequestMapping(value = "add-todo")
    public String gotoAddTodo(ModelMap model)
    {
        String username = getloggedinUsername();
        Todo todo = new Todo(0, username, "Default" , LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }



}
