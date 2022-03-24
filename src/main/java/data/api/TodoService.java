package data.api;


import java.util.List;

//Todo Service can talk to any todo application and return the todo list
public interface TodoService {

    public List<String> retrieveTodoStrings(String user);

}
