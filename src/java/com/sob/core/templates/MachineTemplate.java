package com.sob.core.templates;

import com.sob.core.*;

public class machineTemplate extends itemTemplate {

    /** The amount of joules used per tick */
    protected math.Big inputWatt;
    /** The amount of joules generates per tick */
    protected math.Big outputWatt;

    /** The thing it does when used */
    protected Runnable function;

    /** The process time in ticks */
    protected long processT;
    /** The success probaility */
    protected double succesP;

    public math.Big getInputWatt() {
        return inputWatt;
    }

    public math.Big getOutputWatt() {
        return outputWatt;
    }

    public Runnable getFunction() {
        return function;
    }

    public long getProcessTime() {
        return processT;
    }

    public double getSuccessProbaility() {
        return succesP;
    }

}
