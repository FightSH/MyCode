package org.example.commandpattern.cook.impl;

import org.example.commandpattern.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiChuanCook implements ICook{
    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间喜欢的菜系。");
    }

}
