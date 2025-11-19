package com.revature.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

        logger.info("This is INFO.");

        logger.warn("This is WARN.");

        logger.error("This is ERROR.");
    }
}
