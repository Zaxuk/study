package com.zaxk.study.pattern;

/**
 * 命令
 * 命令模式：Command
 */
interface Command {
    void execute();
}

/**
 * 攻击命令
 * 命令模式：Command
 */
interface AttackCommand extends Command {

    void attack();

    default void execute() {
        attack();
    }
}

/**
 * 命令模式
 * Created by ZhuXu on 2017/11/11 0011.
 */
public class CommandTest {

    public static void main(String[] args) {
        Weapon sword = new Sword();
        Weapon bow = new Bow();
        Weapon staff = new Staff();

        Command swordAttack = new NormalAttackCommand(sword);
        Command swordSkilll = new SkillAttackCommand(sword);

        Command bowAttack = new NormalAttackCommand(bow);
        Command bowSkilll = new SkillAttackCommand(bow);

        Command statffAttack = new NormalAttackCommand(staff);
        Command staffSkilll = new SkillAttackCommand(staff);

        Role warrior = new Role("战士", swordAttack, swordSkilll);
        Role hunter = new Role("猎人", bowAttack, bowSkilll);
        Role mage = new Role("法师", statffAttack, staffSkilll);

        warrior.attack();
        hunter.attack();
        mage.attack();

        warrior.skill();
        hunter.skill();
        mage.skill();

        warrior.defence();
        hunter.escape();
        mage.escape();

    }
}

/**
 * 防御命令
 * 命令模式：ConcreteCommand
 */
class DefenseCommand implements Command {

    public void execute() {
        System.out.println("我扛着，你们快输出！");
    }
}

/**
 * 逃跑命令
 * 命令模式：ConcreteCommand
 */
class EscapeCommand implements Command {

    public void execute() {
        System.out.println("打个毛啊，溜了溜了！");
    }
}

/**
 * 普通攻击命令
 * 命令模式：ConcreteCommand
 */
class NormalAttackCommand implements AttackCommand {

    Weapon weapon;

    NormalAttackCommand(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        weapon.attack();
    }
}

/**
 * 技能攻击命令
 * 命令模式：ConcreteCommand
 */
class SkillAttackCommand implements AttackCommand {

    Weapon weapon;

    SkillAttackCommand(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        weapon.skill();
    }
}

/**
 * 武器
 * 命令模式：Receiver
 */
abstract class Weapon {
    abstract void attack();

    abstract void skill();
}

/**
 * 剑
 * 命令模式：ConcreteReceiver
 */
class Sword extends Weapon {

    @Override
    void attack() {
        System.out.println("我砍！");
    }

    @Override
    void skill() {
        System.out.println("星爆气流斩!");
    }
}

/**
 * 弓箭
 * 命令模式：ConcreteReceiver
 */
class Bow extends Weapon {

    @Override
    void attack() {
        System.out.println("我射！");
    }

    @Override
    void skill() {
        System.out.println("万箭齐发！");
    }
}

/**
 * 法杖
 * 命令模式：ConcreteReceiver
 */
class Staff extends Weapon {

    @Override
    void attack() {
        System.out.println("我打！");
    }

    @Override
    void skill() {
        System.out.println("神灭斩！");
    }
}

/**
 * 角色
 * 命令模式：Invoker
 */
class Role {

    private String name;

    private Command attackCommand, skillCommand, defenseCommand, escapeCommand;

    Role(String name, Command attackCommand, Command skillCommand) {
        this.name = new StringBuffer(name).append("：").toString();
        this.attackCommand = attackCommand;
        this.skillCommand = skillCommand;
        defenseCommand = new DefenseCommand();
        escapeCommand = new EscapeCommand();
    }

    public void attack() {
        System.out.print(name);
        attackCommand.execute();
    }

    public void skill() {
        System.out.print(name);
        skillCommand.execute();
    }

    public void defence() {
        System.out.print(name);
        defenseCommand.execute();
    }

    public void escape() {
        System.out.print(name);
        escapeCommand.execute();
    }
}
