package com.example.blog.ortak;

public class Util {
    public static BaseResponse islemSonucGetir(Object o)
    {
        BaseResponse b=new BaseResponse();
        if(o==null)
        {
            b.setSonuc(EnumIslemSonucTipi.Basarili);
            b.setData("");
        }
        else if(o instanceof Exception)
        {
            b.setSonuc(EnumIslemSonucTipi.Basarisiz);
            b.setHata(((Exception)o).getMessage());
        }else
        {
            b.setSonuc(EnumIslemSonucTipi.Basarili);
            b.setData(o);
        }
        return b;
    }
}
