package ua.rd.mockitoexample;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @author Serhii_Mykhliuk
 */
public class MockitoTest {

    @Test
    public void iteratorTest() {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello").thenReturn("World");

        String result = i.next() + " " + i.next();

        System.out.println(result);

    }

    @Test
    public void withArguments() {
        Comparable c = mock(Comparable.class);
        when(c.compareTo("Test")).thenReturn(10);
        System.out.println(c.compareTo("Test"));
        System.out.println(c.compareTo("1"));
        when(c.compareTo(anyString())).thenReturn(100);
        System.out.println(c.compareTo("1"));

    }

    @Test(expected = IOException.class)
    public void rethrowException() throws IOException{
        OutputStream mock = mock(OutputStream.class);
        OutputStreamWriter osw = new OutputStreamWriter(mock);
        doThrow(new IOException()).when(mock).close();

        osw.close();
        verify(mock).close();

    }

    @Test
    public void listTest(){
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one1");
        verify(mockedList).clear();
    }

}
