package com.java.base.debug;

import java.util.concurrent.ThreadLocalRandom;

/**
 * asus 梅锦涛
 * 2022/5/22
 *
 * @author mjt
 */
public class DebugServiceFactory {

    private final DebugService advanceDebugService = new AdvanceDebugServiceImpl();

    private final DebugService generalDebugService = new GeneralDebugServiceImpl();

    public DebugService getDebugService() {
        if (ThreadLocalRandom.current().nextBoolean()) {
            return advanceDebugService;
        } else {
            return generalDebugService;
        }
    }


}
