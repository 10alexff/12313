package com.company;

public class Tyrniket
{
    public boolean tyrniket(int key)
    {
        Reestr R = new Reestr();
        if(R.GetTupe(key)==2) warn();
        return R.One_use(key);
    }

    void warn(){}

}
