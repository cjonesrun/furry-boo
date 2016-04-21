package com.sarcastico.as.impl;

import javax.enterprise.inject.Alternative;

/**
 * A simple alternative CDI service (enabled through beans.xml)
 */

@Alternative
public class AltService implements Service {

	@Override
    public String createMessage(String msg) {
        return this.getClass().getSimpleName() + ": " + msg + ".";
    }

}
