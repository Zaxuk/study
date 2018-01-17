package com.zaxk.study.pattern;

/**
 * 抽象工厂模式：AbstractFactory - 流量包工厂
 */
interface FlowratePackageFactory {
    int getFlowrate();

    int getPrice();
}

/**
 * 工厂方法模式 & 抽象工厂模式
 * Created by ZhuXu on 2017/11/9 0009.
 */
public class FactoryTest {
    public static void main(String[] args) {
        Provider provider;

        provider = new ChinaMobile1G();
        provider.describe("day");

        provider = new ChinaMobile1G();
        provider.describe("month");

        provider = new ChinaTelecom2G();
        provider.describe("day");

        provider = new ChinaTelecom2G();
        provider.describe("month");
    }
}

/**
 * 供应商
 * 工厂方法模式：Creator
 * 抽象工厂模式：AbstractClient
 */
abstract class Provider {
    // 工厂方法：所有供应商子类都实现此方法
    public abstract FlowratePackage create(String type);

    // 已实现的方法：使用工厂方法创建出来的产品
    public void describe(String type) {
        FlowratePackage flowratePackage = create(type);
        System.out.println(flowratePackage.company + "：" + flowratePackage.desc + "，包含流量" + flowratePackage.flowrate + "M，售价" + flowratePackage.price + "元");
    }
}

/**
 * 中国移动1G流量包供应商
 * 工厂方法模式：ConcreteCreator
 * 抽象工厂模式：Client
 */
class ChinaMobile1G extends Provider {

    // 实例化1G流量包工厂
    FlowratePackageFactory factory = new Flowrate1G();

    // 实现工厂方法，根据客户要求，使用实例化后的抽象工厂创建流量包
    @Override
    public FlowratePackage create(String type) {
        FlowratePackage flowratePackage = null;
        switch (type) {
            case "day":
                flowratePackage = new DayFlowratePackage(factory);
                break;
            case "month":
                flowratePackage = new MonthFlowratePackage(factory);
                break;
            case "halfyear":
                flowratePackage = new HalfYearFlowratePackage(factory);
                break;
            default:
                flowratePackage = new DayFlowratePackage(factory);
                break;
        }
        flowratePackage.company = "中国移动";
        flowratePackage.prepare();
        return flowratePackage;
    }
}

/**
 * 中国电信2G流量包供应商
 * 工厂方法模式：ConcreteCreator
 * 抽象工厂模式：Client
 */
class ChinaTelecom2G extends Provider {

    // 实例化2G流量包工厂
    FlowratePackageFactory factory = new Flowrate2G();

    // 实现工厂方法，根据客户要求，使用实例化后的抽象工厂创建流量包
    @Override
    public FlowratePackage create(String type) {
        FlowratePackage flowratePackage = null;
        switch (type) {
            case "day":
                flowratePackage = new DayFlowratePackage(factory);
                break;
            case "month":
                flowratePackage = new MonthFlowratePackage(factory);
                break;
            case "halfyear":
                flowratePackage = new HalfYearFlowratePackage(factory);
                break;
            default:
                flowratePackage = new DayFlowratePackage(factory);
                break;
        }
        flowratePackage.company = "中国电信";
        flowratePackage.prepare();
        return flowratePackage;
    }
}

/**
 * 流量包
 * 工厂方法模式：Product
 * 抽象工厂模式：AbstractProduct
 */
abstract class FlowratePackage {
    String company;
    String desc;
    int flowrate;
    int price;

    //  持有流量包抽象工厂
    FlowratePackageFactory factory;

    abstract void prepare();
}

/**
 * 日流量包
 * 工厂方法模式：ConcreteProduct
 * 抽象工厂模式：Product
 */
class DayFlowratePackage extends FlowratePackage {

    //  持有流量包抽象工厂
    DayFlowratePackage(FlowratePackageFactory factory) {
        this.factory = factory;
    }

    // 使用流量包工厂创建流量包
    @Override
    void prepare() {
        desc = "日流量包";
        flowrate = factory.getFlowrate();
        price = factory.getPrice();
    }
}

/**
 * 月流量包
 * 工厂方法模式：ConcreteProduct
 * 抽象工厂模式：Product
 */
class MonthFlowratePackage extends FlowratePackage {

    //  持有流量包抽象工厂
    MonthFlowratePackage(FlowratePackageFactory factory) {
        this.factory = factory;
    }

    // 使用流量包工厂创建流量包
    @Override
    void prepare() {
        desc = "月流量包";
        flowrate = factory.getFlowrate();
        price = factory.getPrice();
    }
}

/**
 * 半年流量包
 * 工厂方法模式：ConcreteProduct
 * 抽象工厂模式：Product
 */
class HalfYearFlowratePackage extends FlowratePackage {

    //  持有流量包抽象工厂
    HalfYearFlowratePackage(FlowratePackageFactory factory) {
        this.factory = factory;
    }

    // 使用流量包工厂创建流量包
    @Override
    void prepare() {
        desc = "半年流量包";
        flowrate = factory.getFlowrate();
        price = factory.getPrice();
    }
}

/**
 * 抽象工厂模式：ConcreteFactory - 1G流量包工厂
 */
class Flowrate1G implements FlowratePackageFactory {
    @Override
    public int getFlowrate() {
        return 1024;
    }

    @Override
    public int getPrice() {
        return 10;
    }
}

/**
 * 抽象工厂模式：ConcreteFactory - 2G流量包工厂
 */
class Flowrate2G implements FlowratePackageFactory {
    @Override
    public int getFlowrate() {
        return 2048;
    }

    @Override
    public int getPrice() {
        return 20;
    }
}
