package ua.rd.mockitoexample.nixx78;

/**
 * @author Serhii_Mykhliuk
 */


public class InterfaceForTestImpl implements InterfaceForTest {

    private String stringValue;

    @Override
    public void setStringValue(String value) {
        this.stringValue = value;
    }

    @Override
    public String getStringValue() {
        return stringValue;
    }

    @Override
    public int getIntValue() {
        return 156;
    }

    @Override
    public void actionMethod() {
        System.out.println("RealImplementation: process action");
    }

    @Override
    public String processMethod(String input) throws Exception {
        System.out.println("RealImplementation: process method, parameter [" + input + "]");
        return "response" + "." + String.valueOf(System.currentTimeMillis());
    }

}