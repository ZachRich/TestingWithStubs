package data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService{

    //STUB Method
    @Override
    public List<String> retrieveTodoStrings(String user) {

        if (user == "Zach") {
            return Arrays.asList("Learn Spring MVC", "Learn Hibernate", "Learn Mockito", "Test", "Spring");
        }
        //Creating dummy implementation of Todo Service
        return Arrays.asList();
    }
}
