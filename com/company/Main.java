package com.company;

public class Main
{

    public static void main(String[] args)
    {

        Reestr R = new Reestr();
        int key_1=R.AddAc(1,20);
        int key_2=R.AddAc(2,3);
        int key_3=R.AddAc(3,2);

        System.out.println(R.One_use(key_1)+"  "+R.GetTo_use(key_1));
        System.out.println(R.One_use(key_2)+"  "+R.GetTo_use(key_2));

        System.out.println(R.To_blok(key_3)+"  "+R.One_use(key_3)+"  "+R.GetTo_use(key_3));

        Tyrniket T = new Tyrniket();

        T.tyrniket(1);
        
        R.Get_All_History();
        R.Get_History(key_1);


    }
}
