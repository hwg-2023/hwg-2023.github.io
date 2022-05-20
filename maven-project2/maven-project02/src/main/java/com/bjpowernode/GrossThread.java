package com.bjpowernode;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GrossThread implements Runnable {
    private MainAccount maThread2;

    public GrossThread() {
    }

    public GrossThread(MainAccount maThread2) {
        this.maThread2 = maThread2;
    }

    @Override
    public void run() {
        double gol2 = maThread2.getGrossGol();
        double ge2 = maThread2.getGolEveryday();

        //*String sql1 = "insert into t_shares (sharesName,golEveryday,date) values ('"+sn1+"',"+ge1+"+date +)";*//*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//获取当前时间方法，下3行
        Date date2 = new Date();
        String daytime = sdf.format(date2);

        //建立评价：
        String evaluation = null;
        if (ge2>=200){
            evaluation = "赢麻了！！！可以收手了";
        }else if (ge2<=-200){
            evaluation = "输麻了！！！记得补仓";
        }else {
            evaluation = "正常发挥，再接再厉！";
        }

        //创建字符串对象，拼接字符串
        //需要的sql语句是："insert into t_gross(Date,grossGol,evaluation) values ('daytime',gol2,'evaluation');
        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert into t_gross(Date,grossGol,evaluation) values ('");
        sb2.append(daytime);
        sb2.append("',");
        sb2.append(gol2);
        sb2.append(",'");
        sb2.append(evaluation);
        sb2.append("');");


        //System.out.println(sn1+"当日盈亏为："+ge1);
        //将sn1和ge1写入sql语句中，最好是预编译的那种写法，这样可以不用该sql语句
        //连接数据库，把那个封装好的类调过来吧
        UtilTool ut2 = new UtilTool();
        Connection cnn = null;
        Statement sta = null;
        try {
            cnn = UtilTool.getConnection();
            sta = cnn.createStatement();
            //String sql2 = "insert into t_gross (grossGol) values ("+gol2+")";
            String sql2 = sb2.toString();
            int re2 = sta.executeUpdate(sql2);
            String threadName2 = Thread.currentThread().getName();
            System.out.println(re2==1?(threadName2+"执行成功"):(threadName2+"执行失败"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            UtilTool.close1(sta,cnn);
        }
    }
}
