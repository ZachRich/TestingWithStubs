package mockito;

import business.TodoBusinessImpl;
import data.api.TodoService;
import data.api.TodoServiceStub;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TodoBusinessImplMockTest {

    @Test
    public void testTodosFilteredBySpring_usingAMock() {

        //Mock Dependancy of SUT
        TodoService MockTodoService = mock(TodoService.class);

        //Create Data to test Against
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Hibernate", "Learn Mockito", "Test", "Spring");

        //Define service functionality - Put in own data
        when(MockTodoService.retrieveTodoStrings("Zach")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(MockTodoService);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Zach");

        assertEquals(2, filteredTodos.size());

    }

    @Test
    public void testTodosFilteredBySpring_NoResults_usingAMock() {

        TodoService todoServiceMock = mock(TodoService.class);

        //Data to test against
        List<String> todos = Arrays.asList();

        when(todoServiceMock.retrieveTodoStrings("Zach")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());


    }

}
