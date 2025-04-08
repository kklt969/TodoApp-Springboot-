package com.webapp.webapp_kklt.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private  Todo todo;
    private TodoRepository todoRepository;


    public TodoService(TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;

    }

    public void saveTodo(Todo todo)
    {
        todoRepository.save(todo);
    }

    public List<Todo> getTodosByUsername(String username)
    {
        return todoRepository.findByUsername(username);
    }

    public  void deleteTodo(int id)
    {
        todoRepository.deleteById(id);
    }

    public Optional<Todo> getTodoById(int id)
    {
        return todoRepository.findById(id);
    }


    public void updateDone(int id)
    {
        Boolean done = todoRepository.findDoneById(id);
        if(!done)
        {
            todoRepository.setDoneById(id, true);
            return;
        }
        todoRepository.setDoneById(id, false);

    }


    public List<Todo> getCompletedTodo(String username)
    {
        return todoRepository.findByUsernameAndDoneTrue(username);
    }

    public List<Todo> getPendingTodo(String username)
    {
        return todoRepository.findByUsernameAndDoneFalse(username);
    }

    public List<Todo> getTodobyDescription(String description)
    {
        return todoRepository.findByDescription(description);
    }










}
