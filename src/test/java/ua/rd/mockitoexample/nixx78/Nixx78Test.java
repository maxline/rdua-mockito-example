package ua.rd.mockitoexample.nixx78;

import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * @author Serhii_Mykhliuk
 */
public class Nixx78Test {

    @Test
    public void methodCallCheckSample(){
        // create mock for interface
        InterfaceForTest mockedObject = mock(InterfaceForTest.class);

        // call methods
        mockedObject.setStringValue("value1");
        mockedObject.actionMethod();

        // verify, that methods are called, please note that we check
        // also parameter value
        verify(mockedObject).setStringValue("value1");
        verify(mockedObject).actionMethod();

        // in this point we expect exception, because method "getStringValue" not called
        //verify(mockedObject).getStringValue();
    }

    /**
     * Чуть более сложный пример, добавим заглушки методов
     Пример, в котором мы рассматриваем как мы можем сделать стабы для методов,
     в стабах мы указываем, какое значение мы ожидаем от метода при его вызове
     с определенными параметрами. Показаны различные подходы, как можно задавать
     условия,при создании заглушек для методов.
     */
    @Test
    public void stubUsageSample() throws Exception{
        // create mocked object
        InterfaceForTest mockedObject = mock(InterfaceForTest.class);

        // describe expected behavior for our interface
        when(mockedObject.getStringValue()).thenReturn("expectedValue");

        // we can define for one method different return values depending from input value
        when(mockedObject.processMethod("input1")).thenReturn("value1");
        when(mockedObject.processMethod("input2")).thenReturn("value2");
        when(mockedObject.processMethod("input3")).thenThrow(new Exception("exception during method 'processMethod' call"));

        // also we can define expected value using another approach: doReturn
        doReturn("value4").when(mockedObject).processMethod("input4");
        doThrow(new Exception()).when(mockedObject).processMethod("method with exception parameter");

        // assert expected values, that method returns
        assertEquals("value1", mockedObject.processMethod("input1"));
        assertEquals("value2", mockedObject.processMethod("input2"));

        try {
            mockedObject.processMethod("input3");
        } catch (Exception ex) {
            // we expect exception there
            System.err.println(ex);
        }

        // for non mocked input value we expect null
        assertNull(mockedObject.processMethod("not mocked value"));

        assertEquals("getString value", "expectedValue", mockedObject.getStringValue());
    }


}
