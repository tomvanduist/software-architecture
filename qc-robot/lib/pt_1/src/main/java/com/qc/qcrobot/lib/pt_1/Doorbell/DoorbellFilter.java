package com.qc.qcrobot.lib.pt_1.Doorbell;

import com.qc.qcrobot.lib.pt_1.Filter;
import com.qc.qcrobot.lib.pt_1.IPipe;

/**
 *
 * @author sander
 */
public class DoorbellFilter extends Filter<Enum, Boolean> {

    public DoorbellFilter(IPipe<Enum> input, IPipe<Boolean> output) {
        super(input, output);
    }

    @Override
    protected Boolean transformOne(Enum in) {
        Boolean out = in.equals(DoorbellEnum.Opened);
        System.out.println("The state of the door is "+ in.toString());
         System.out.println("Filtered " + in.toString() + " to " + out.toString());
        return out;
    }
}

	
 