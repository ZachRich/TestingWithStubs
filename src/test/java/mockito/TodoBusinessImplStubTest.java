package mockito;

import business.TodoBusinessImpl;
import data.api.TodoServiceStub;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.mockito.*;
import org.hamcrest.*;

public class TodoBusinessImplStubTest {

    @Test
    public void testTodosFilteredBySpring_usingAStub() {

        TodoServiceStub todoServiceStub = new TodoServiceStub();

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

       List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Zach");

       assertEquals(2, filteredTodos.size());
       assertEquals(true, filteredTodos.contains("Learn Spring MVC"));

    }

    @Test
    public void testTodosFilteredBySpring_NoResults_usingAStub() {

        TodoServiceStub todoServiceStub = new TodoServiceStub();

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos =  todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(0, filteredTodos.size());


    }

}
