package com.practice2.practice2.service;

import com.practice2.practice2.controller.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.stream;

@Service
public class TodoService {
    public static List<Todo> todos = new ArrayList<>();
    private static int idcout =0;
    static {
        todos.add(new Todo(++idcout,"khan","khan",
                LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++idcout,"khanf","khan",
                LocalDate.now().plusYears(2),false));
    }
    public List<Todo> findByUsername(String username){
        Predicate <? super  Todo> predicate
               = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }
    // add new details here
    public void addTod(String username, String description, LocalDate targetDate, boolean done){
      Todo todo=  new Todo(++idcout,username,description,targetDate,done);
      todos.add(todo);
    }
    public void  deleteById(int id){
        // also we can use conditional statements

        for (int i=0; i<todos.size();i++  ){
            Todo todo = todos.get(i);
            if(todo.getId() == id){
                todos.remove(i);
                --i;
            }
        }
        boolean remove = false;

//        switch (todos.size()){
//            case 0: // do nothing
//                break;
//            default: for (int i=0; i< todos.size(); i++  ){Todo todo = todos.get(i);todos.remove(i);remove =true;
//                i++;
//                break;
//
//
//            }
//       }
//        Predicate <? super  Todo> predicate
//                =todo -> todo.getId()==id;
//        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
//        for (int i =0; i< todos.size(); i++){
//            Todo todo = todos.get(i);
//
//        }
// this functional programing to retrieve a matched id element to update page but we can use conditional statements
//        Predicate <? super  Todo> predicate
//                = todo -> todo.getId() == id;
//        Todo todo =todos. stream().filter(predicate).findFirst().get();
//        return todo;
//        using conditional statments to retrieve the matched id element in todos list
        for (int i = 0; i< todos.size(); i++){
            Todo todo = todos.get(i);
            if (todo.getId()==id){
                return  todo;
            }
        }
        return null;
    }
// delete item form the list
    public void setUpdate(@Valid  Todo todo) {
        deleteById((int) todo.getId());

        todos.add(todo);
    }
}
