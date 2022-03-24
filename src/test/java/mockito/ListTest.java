package mockito;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void mockListSizeMethod() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2, mockList.size());
    }

    @Test
    public void mockListSizeMethod_MultipleValues() {
        List mockList = mock(List.class);
        //You can use multiple returns here for multiple values
        when(mockList.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());


    }

    @Test
    public void mockListGetMethod() {
        List mockList = mock(List.class);
        //You can use multiple returns here for multiple values
        when(mockList.get(0)).thenReturn("Swing MVC").thenReturn(null);
        assertEquals("Swing MVC", mockList.get(0));
        assertEquals(null, mockList.get(1));
        //If I were to call mockList.get(1) I would be returned a default value, This is called a nice mock.
    }

    @Test
    public void mockListGetMethod_AnyInt() {
        List mockList = mock(List.class);
        //You can use multiple returns here for multiple values
        when(mockList.get(anyInt())).thenReturn("Swing MVC").thenReturn(null);
        assertEquals("Swing MVC", mockList.get(0));
        assertEquals(null, mockList.get(1));
        //If I were to call mockList.get(1) I would be returned a default value, This is called a nice mock.
    }

    @Test(expected=RuntimeException.class)
    public void mockListGetMethod_ThrowAnException() {
        List mockList = mock(List.class);
        //You can use multiple returns here for multiple values
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("Error"));
        mockList.get(0);
    }

}
