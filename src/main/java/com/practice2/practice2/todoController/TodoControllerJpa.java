package com.practice2.practice2.todoController;

import com.practice2.practice2.controller.Todo;
import com.practice2.practice2.repository.TodoRespository;
import com.practice2.practice2.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
//    to return the todo list now we Autowired the TodoService using Constractot
    private  TodoService todoService;

//    here we auwired todoRespository
    public TodoControllerJpa(TodoRespository respository) {
        super();
        this.respository = respository;
    }
    private TodoRespository respository;
    @RequestMapping("todos")
    public  String allTodoList(ModelMap modelMap){
        String username = (String) modelMap.get("name");
         List<Todo> todos= respository.findByUsername(username);
         modelMap.addAttribute("todos",todos);
        return "listTodos";

    }
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)

    public  String addDetails(ModelMap model){
        String username =(String)model.get("name");
                Todo todo = new Todo(0,username,"Default Description",LocalDate.now().plusYears(1),false);
                model.put("todo",todo);
        return "saveTodo";

    }
    //this more time consuming and not good practace instead this wen dow bean cammond (Form Baking Object)
//    for the reason we comment the below code
//    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
//    public  String addNewDetails(@RequestParam String description, ModelMap model){
//        String username =(String)model.get("name");
//        //ther the one way bindin form bean to form ("Default Value")
//        todoService.addTod(username,description, LocalDate.now().plusYears(1),false);
//        return "redirect:todos";
//
//    }

//    here is we implemented the command beean or form backing object instead Request form we use Todo class objec
    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public  String addNewDetails(ModelMap model, @Valid  Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "saveTodo";
        }
        String username =getUserDetais(model);
        todo.setUsername(username);
        //ther the one way bindin form bean to form ("Default Value")
//        todoService.addTod(username,todo.getDescription(), todo.getTargetDate(),false);
        respository.save(todo);
        return "redirect:todos";

    }
    @RequestMapping("delete")
    public String delete(@RequestParam int id){
//        todoService.deleteById(id);

        respository.deleteById(id);
        return "redirect:todos";
    }
    @RequestMapping("update")
    public  String updatDetails(@RequestParam int id, ModelMap model){
        Todo todo = respository.findById(id).get();
        model.addAttribute("todo",todo);
        return "saveTodo";
    }
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public  String update(ModelMap model, @Valid  Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "saveTodo";
        }
//        show only related data to logined user
        String username = getUserDetais(model);
        //ther the one way bindin form bean to form ("Default Value")
        todo.setUsername(username);
        respository.save(todo);
        return "redirect:todos";

    }
    private String getUserDetais(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
