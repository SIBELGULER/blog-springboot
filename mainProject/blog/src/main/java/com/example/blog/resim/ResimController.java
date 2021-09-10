package com.example.blog.resim;

import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/resim")
@RestController
public class ResimController {
    IResimService iResimService;

    public ResimController(IResimService iResimService) {
        this.iResimService = iResimService;
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody ResimDTO resimDTO) {
        try {
            return Util.islemSonucGetir(iResimService.kaydet(resimDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(iResimService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(iResimService.tumunuSil());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody ResimDTO resimDTO) {
        try {
            return Util.islemSonucGetir(iResimService.duzenle(resimDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(iResimService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(iResimService.findById(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

}
