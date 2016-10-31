package ua.rd.mockitoexample;

import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
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


    @Test
    public void stubExampleTest(){
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(999)); //rerurns NULL
    }

    @Test
    public void quantityTimesTest(){
        LinkedList mockedList = mock(LinkedList.class);
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("once");

        verify(mockedList, times(2)).add("twice");
        verify(mockedList, atLeastOnce()).add("once");
    }

    @Test
    public void spyTest(){
        List list = new LinkedList();
        List spy = spy(list);
        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));

        System.out.println(spy.size());
        System.out.println(list.size());

        verify(spy).add("one");
        verify(spy).add("two");
    }
}
