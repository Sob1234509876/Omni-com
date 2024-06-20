package top.sob.core.templates;

import java.math.*;

public class machineTemplate extends itemTemplate {

    /** The amount of joules used per tick */
    protected BigInteger inputWatt;
    /** The amount of joules generates per tick */
    protected BigInteger outputWatt;

    /** The thing it does when used */
    protected Runnable function;

    /** The process time in ticks */
    protected long processT;
    /** The success probaility */
    protected double succesP;

    /**
     * Returns the input watt of this.
     * 
     * @return the input watt of this
     */
    public BigInteger getInputWatt() {
        return inputWatt;
    }

    /**
     * Returns the output watt of this.
     * 
     * @return the output watt of this
     */
    public BigInteger getOutputWatt() {
        return outputWatt;
    }

    /**
     * Returns the function of this.
     * 
     * @return the function of this
     */
    public Runnable getFunction() {
        return function;
    }

    /**
     * Returns the process time of this.
     * 
     * @return the process time of this
     */
    public long getProcessTime() {
        return processT;
    }

    /**
     * Returns the success probaility of this.
     * 
     * @return the success probaility of this
     */
    public double getSuccessProbaility() {
        return succesP;
    }

    /**
     * 
     * Sets this input watt into a new one.
     * 
     * @param o the new input watt
     * @return returns this
     */
    public machineTemplate setInputWatt(BigInteger o) {
        this.inputWatt = o;
        return this;
    }

    /**
     * 
     * Sets this output watt into a new one.
     * 
     * @param o the new output watt
     * @return returns this
     */
    public machineTemplate setOutputWatt(BigInteger o) {
        this.outputWatt = o;
        return this;
    }

    /**
     * 
     * Sets this function into a new one.
     * 
     * @param o the new function
     * @return returns this
     */
    public machineTemplate setFunction(Runnable o) {
        this.function = o;
        return this;
    }

    /**
     * 
     * Sets this process time into a new one.
     * 
     * @param o the new process time
     * @return returns this
     */
    public machineTemplate setProcessTime(long o) {
        this.processT = o;
        return this;
    }

    /**
     * 
     * Sets this success probaility into a new one.
     * 
     * @param o the new success probaility
     * @return returns this
     */
    public machineTemplate setSuccessProbaility(double o) {
        this.succesP = o;
        return this;
    }

}
