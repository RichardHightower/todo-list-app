package io.advantageous.qbit.example.todolistapp;

/**
 * Created by rhightower on 2/10/15.
 */


public class TodoObject {
    private final String todo;
    private final long time = System.currentTimeMillis();

    public TodoObject(String todo) {
        this.todo = todo;
    }
}


