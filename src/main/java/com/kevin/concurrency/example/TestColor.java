package com.kevin.concurrency.example;

import org.apache.log4j.Logger;

/**
 * Created by Kevin on 2018/9/5.
 */
public class TestColor {
    public static void main(String[] args) {


        final Logger logger = Logger.getLogger("TestErrOut");
        logger.debug(" This is debug!!!");
        logger.info(" This is info!!!");
        logger.warn(" This is warn!!!");
        logger.error(" This is error!!!");
        logger.fatal(" This is fatal!!!");
    }
}
