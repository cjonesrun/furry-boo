package com.sarcastico.as.impl;

/**
 * A simple default CDI service
 */
public class DefaultService implements Service {

	@Override
    public String createMessage(String msg) {
        return this.getClass().getSimpleName() + ": " + msg + ".";
    }

}
