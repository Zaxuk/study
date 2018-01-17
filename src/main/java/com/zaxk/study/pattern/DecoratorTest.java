package com.zaxk.study.pattern;

/**
 * 装饰者模式
 * Created by ZhuXu on 2017/11/9 0009.
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Food food = new PorkRib();
        food = new Vinegar(food);
        food = new Suger(food);
        System.out.println(food.getDesc());

        System.out.println(new Sauerkraut(new Fish()).getDesc());
    }
}

abstract class Food {
    String desc;

    String getDesc() {
        return desc;
    }
}

abstract class Condiment extends Food {
    abstract String getDesc();
}

class Fish extends Food {
    Fish() {
        desc = "鱼";
    }
}

class PorkRib extends Food {
    PorkRib() {
        desc = "排骨";
    }
}

class Suger extends Condiment {

    Food food;

    Suger(Food food) {
        this.food = food;
    }

    @Override
    String getDesc() {
        return "糖" + food.getDesc();
    }
}

class Vinegar extends Condiment {

    Food food;

    Vinegar(Food food) {
        this.food = food;
    }

    @Override
    String getDesc() {
        return "醋" + food.getDesc();
    }
}

class Sauerkraut extends Condiment {

    Food food;

    Sauerkraut(Food food) {
        this.food = food;
    }

    @Override
    String getDesc() {
        return "酸菜" + food.getDesc();
    }
}
