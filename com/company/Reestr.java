package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Reestr
{
    static ArrayList<Accaunt> LAcc = new ArrayList<Accaunt>();
    static ArrayList<Hist> History = new ArrayList<Hist>();
     int ACC_key = 0;
     double cost =8;
    public int AddAc(int Tupe,double To_use)
    {
        Accaunt ac = new Accaunt();

        ac.key = ACC_key;
        ACC_key +=1;
        ac.Tupe =Tupe;
        ac.To_use = To_use;
        ac.blok = false;
        LAcc.add(ac);

        Hist Y = new Hist();
        Y.key=ACC_key-1;
        Y.cod = 1;
        Y.Discr="created";
        History.add(Y);

        return ACC_key-1;
    }



    public boolean ADD_use(int k, double Uses)
    {
        int index = Search(k);
        if(index ==-1){return false;}
        else
            {
                Accaunt ac = new Accaunt();
                ac.To_use +=Uses;
                return true;
            }
    }

    public int Search(int k)
    {
        int index =-1;
        for(int i=0;i<LAcc.size();i++)
        {
            Accaunt ac = LAcc.get(i);
            if(ac.key == k){index = i;break;}
        }
        return index;
    }
    public boolean  One_use(int key2)
    {
        int index = Search(key2);
        if (index ==-1){return false;}
        else
            {
                Accaunt ac = LAcc.get(index);
                if(!ac.blok)
                {
                    switch (ac.Tupe)
                    {
                        case 1:
                            if(ac.To_use>=cost)
                            {
                                ac.To_use-=cost; LAcc.set(index,ac);
                                Hist Y = new Hist();
                                Y.key=key2; Y.cod = 2; Y.Discr="Use";
                                History.add(Y);
                                return true;
                            }
                            else
                                {
                                    Hist Y = new Hist();
                                    Y.key=key2; Y.cod = 3; Y.Discr="Not enough points";
                                    History.add(Y);
                                  return  false;
                                }
                        case 2:
                            if(ac.To_use>=cost/2)
                            {
                                ac.To_use-=cost/2; LAcc.set(index,ac);
                                Hist Y = new Hist();
                                Y.key=key2; Y.cod = 2; Y.Discr="Use";
                                History.add(Y);
                                return true;

                            }
                            else
                                {
                                    Hist Y = new Hist();
                                    Y.key=key2; Y.cod = 3; Y.Discr="Not enough points";
                                    History.add(Y);
                                    return  false;
                                }
                        case 3:
                            if(ac.To_use>=1)
                            {
                                Hist Y = new Hist();
                                Y.key=key2; Y.cod = 2; Y.Discr="Use";
                                ac.To_use-=1;LAcc.set(index,ac);
                                return  true;
                            }
                            else
                                {
                                    Hist Y = new Hist();
                                    Y.key=key2; Y.cod = 3; Y.Discr="Not enough points";
                                    return  false;
                                }
                    }
                }
                else
                    {
                        Hist Y = new Hist();
                        Y.key=key2; Y.cod = 4; Y.Discr="Try to use, but it was bloked";
                        return false;
                    }

                return true;
            }

    }

    public boolean To_blok(int key_)
    {
        int index = Search(key_);
        if (index==-1){return false;}
        else
            {
                Accaunt ac = LAcc.get(index);
                ac.blok = true;
                LAcc.set(index,ac);
                Hist Y = new Hist();
                Y.key=key_; Y.cod = 5; Y.Discr="successfully bloked";
                return true;
            }
    }

    public List<Hist> Get_All_History()
    {
        return History;
    }

    public List<Hist> Get_History(int ket)
    {
        ArrayList<Hist> To_get = new ArrayList<Hist>();
        for(int i=0;i<History.size();i++)
        {
            if(History.get(i).key==ket){To_get.add(History.get(i));}
        }
        return To_get;
    }


    public int GetTupe(int key1)
    {
        return LAcc.get(key1).Tupe;
    }
    public boolean Getblok(int key1)
    {
        return LAcc.get(key1).blok;
    }
    public double GetTo_use(int key1)
    {
        return LAcc.get(key1).To_use;
    }
}

class Hist
{
    int key;
    String Discr;
    int cod;
}

