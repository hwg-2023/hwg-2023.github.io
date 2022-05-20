package com.bjpowernode;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EverydayThread implements Runnable{
    private MainAccount maThread1 ;

    public EverydayThread() {
    }

    public EverydayThread(MainAccount ma) {
        this.maThread1 = ma;
    }

    @Override
    public void run() {

        String sn1 = maThread1.getSharesName();
        double ge1 = maThread1.getGolEveryday();
        //接下来要写另外一个线程，通过这个线程去连接数据库，去处理数据，要有锁
        /*System.out.println(sn1);
        System.out.println(ge1);*/


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//获取当前时间方法，下3行
        Date date1 = new Date();
        String daytime = sdf.format(date1);
        //*String sql1 = "insert into t_shares (sharesName,golEveryday,date) values ('"+sn1"',"+ge1,'daytime')";*//*
        //我的意见是不如创个字符串连接对象
        StringBuilder sb1 = new StringBuilder();//拼接字符串对象
        //insert into t_shares (sharesName,golEveryday,date) values ('sn1',ge1,'daytime');
        sb1.append("insert into t_shares (sharesName,golEveryday,date) values ('");
        sb1.append(sn1);
        sb1.append("',");
        sb1.append(ge1);
        sb1.append(",'");
        sb1.append(daytime);
        sb1.append("');");
        //System.out.println(sb);


        //*String sql1 = "insert into t_shares (sharesName,golEveryday,date) values ('"+sn1+"',"+ge1+"+date +)";*//*

        //System.out.println(sn1+"当日盈亏为："+ge1);
        //将sn1和ge1写入sql语句中，最好是预编译的那种写法，这样可以不用该sql语句
        //连接数据库，把那个封装好的类调过来吧
        UtilTool ut1 = new UtilTool();
        Connection cnn = null;
        Statement sta = null;
        try {
            cnn = UtilTool.getConnection();
            sta = cnn.createStatement();
            //*sql1 = "insert into t_shares (sharesName,golEveryday,date) values ('"+sn1+"',"+ge1+"+date +)";*//*
            String sql1 = sb1.toString();
            int re1 = sta.executeUpdate(sql1);
            String threadName1 = Thread.currentThread().getName();
            System.out.println(re1==1?(threadName1+"执行成功"):(threadName1+"执行失败"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilTool.close1(sta,cnn);
        }

    }
}
