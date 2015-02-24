package io.advantageous.qbit.example.todolistapp;

import io.advantageous.qbit.annotation.*;


/**
 * Created by rhightower on 2/10/15.
 */

@RequestMapping("/todoservice")
public class TodoService {


    @RequestMapping("/todoo")
    public TodoObject list() {
        return new TodoObject("");
    }

}
