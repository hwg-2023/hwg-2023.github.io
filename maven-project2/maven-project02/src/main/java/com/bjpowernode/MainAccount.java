package com.bjpowernode;

public class MainAccount {
    //创建一个主账户，其中记录股票的类型，股票的每日盈亏，股票的总盈亏
    private String sharesName;
    private double golEveryday;
    private double grossGol;

    public MainAccount() {
    }

    public MainAccount(String sharesName, double golEveryday) {
        this.sharesName = sharesName;
        this.golEveryday = golEveryday;
    }

    /*public MainAccount(String sharesName, double golEveryday, double grossGol) {
        this.sharesName = sharesName;
        this.golEveryday = golEveryday;
        this.grossGol = grossGol;
    }*/

    public MainAccount(String sharesName, double golEveryday, double grossGol) {
        this.sharesName = sharesName;
        this.golEveryday = golEveryday;
        this.grossGol = grossGol;
    }

    public String getSharesName() {
        return sharesName;
    }

    public void setSharesName(String sharesName) {
        this.sharesName = sharesName;
    }

    public double getGolEveryday() {
        return golEveryday;
    }

    public void setGolEveryday(double golEveryday) {
        this.golEveryday = golEveryday;
    }

    public double getGrossGol() {
        return grossGol;
    }

    public void setGrossGol(double grossGol) {
        this.grossGol = grossGol;
    }
    //以上就是目前主账户所有的属性以及方法

}
