package com.qc.qcrobot.lib.pt_1;

/**
 * Java generic pipe and filter classes
 * @author roryokane
 */
public interface IPipe<T> {
    public boolean put(T obj);
    public T nextOrNullIfEmptied() throws InterruptedException;
    public void closeForWriting();
}