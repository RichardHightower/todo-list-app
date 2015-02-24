package io.advantageous.qbit.example.todolistapp;

import io.advantageous.qbit.annotation.*;



/**
 * Created by rhightower on 2/10/15.
 */

@RequestMapping("/todoservice")
public class TodoService {


    @RequestMapping( value = "/todoo", method = RequestMethod.POST)
    public TodoObject list(@RequestParam("itemContent") String item) {
        return new TodoObject(item);
    }

}
