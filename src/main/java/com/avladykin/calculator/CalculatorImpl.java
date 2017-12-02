package com.avladykin.calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Sergey Mikhluk.
 */
public class CalculatorImpl implements Calculator {

    @Override
    public double calculate(String expression){
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        expression = expression.replace("sin", "Math.sin").replace("cos", "Math.cos");
        try {
            //defineMathFunctions(scriptEngine);
            return ((Number) scriptEngine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to evaluate expression");
        }
    }

    private static void defineMathFunctions(ScriptEngine scriptEngine) throws ScriptException{
        for(String function : new String[] {"sin", "cos", "sqrt"}){
            scriptEngine.eval("function " + function + "(x) return Java.type('java.lang.Math')." + function + "(x);}");
        }
    }
}
