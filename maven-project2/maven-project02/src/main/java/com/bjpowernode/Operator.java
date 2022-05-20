package com.bjpowernode;

import java.util.Scanner;

public class Operator {


    public static void main(String[] args) {
        //定义一个主方法，能够通过对主账户的操作，来实现数据库的输入输出
        System.out.print("请输入当日持有股票名称：");
        Scanner sc1 = new Scanner(System.in);
        String sn = sc1.next();
        System.out.println();
        System.out.print("请输入当日该股票的盈亏：");
        double ge = sc1.nextDouble();
        System.out.println();
        System.out.print("请输入今日股票总盈亏：");
        double gol = sc1.nextDouble();

        MainAccount ma = new MainAccount(sn, ge, gol);




        //写两个线程，一个执行“记录每日股票以及单日股票盈亏”，另一个执行“记录每日股票总盈亏并评价”
        Thread t1 = new Thread(new EverydayThread(ma));
        Thread t2 = new Thread(new GrossThread(ma));
        t1.setName("单日盈亏记录线程");
        t2.setName("总盈亏记录线程");
        t1.start();
        t2.start();

    }
}
