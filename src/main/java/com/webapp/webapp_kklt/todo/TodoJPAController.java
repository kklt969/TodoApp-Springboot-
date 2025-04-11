package com.webapp.webapp_kklt.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TodoJPAController {

    private TodoService todoService;

    public TodoJPAController(TodoService todoService)
    {
        this.todoService = todoService;
    }

    public String getloggedinUsername()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "todolist", method = RequestMethod.GET)
    public String gotoTodoList(@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "") String status, ModelMap model) {
        String toReturn = "todolist";
        String username = getloggedinUsername();
        List<Todo> todos = new ArrayList<>();
        if ((keyword.equals("") &&  status.equals(""))) {
             todos = todoService.getTodosByUsername(username);

        }

        else if(status.equals("pending"))
        {
            todos = todoService.getPendingTodo(username);
        }

        else if (status.equals("completed"))
        {
            todos = todoService.getCompletedTodo(username);

        }


        else if(!keyword.isEmpty() && status.equals("description"))
        {
            todos = todoService.getTodobyDescription(keyword);
        }

        else if(!keyword.isEmpty() && status.equals("targetDate"))
        {
            LocalDate date = LocalDate.parse(keyword);
            todos = todoService.getTodoByTargetDate(date);
        }

        model.addAttribute("todos",todos);





        return toReturn;
    }

    @RequestMapping(value = "add-todo")
    public String gotoAddTodo(ModelMap model)
    {
        String username = getloggedinUsername();
        Todo todo = new Todo(0, username, "Default" , LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "addTodo";
    }

    @RequestMapping(value = "add-todo", method =  RequestMethod.POST)
    public String saveTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
        String username = getloggedinUsername();

      if(result.hasErrors()){
          return "addTodo";
      }
      todo.setUsername(username);

      todoService.saveTodo(todo);

        return "redirect:todolist";
    }

    @RequestMapping(value = "delete-todo")
    public String deleteTodo(@RequestParam int id)
    {
        todoService.deleteTodo(id);
        return "redirect:todolist";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String gotoUpdateTodo(@RequestParam int id, ModelMap model)
    {
        
        Optional<Todo> todo = todoService.getTodoById(id);
        model.addAttribute("todo",todo);

        return "addTodo";

    }
    
    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result)
    {
    	String username = getloggedinUsername();
    	
    	if(result.hasErrors())
    	{
    		return "addTodo";
    		
    	}
    	
    	todo.setUsername(username);
    	todoService.saveTodo(todo);
    	return "redirect:todolist";
    }

    @RequestMapping(value =  "toggle-done")
    public String updateDone(@RequestParam int id)
    {
        todoService.updateDone(id);
        return "redirect:todolist";
    }





}
