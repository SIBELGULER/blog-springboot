package com.example.blog.etiket;

import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/etiket")
@RestController
public class EtiketController {
    private IEtiketService etiketService;
    public EtiketController(IEtiketService etiketService) {
        this.etiketService=etiketService;
    }

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody EtiketDTO etiketDTO){
        try {
            return Util.islemSonucGetir(etiketService.kaydet(etiketDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }

    @RequestMapping(value = "/duzenle",method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody EtiketDTO etiketDTO) throws Exception {
        try {
            return Util.islemSonucGetir(etiketService.duzenle(etiketDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) throws Exception {
        try {
            return Util.islemSonucGetir(etiketService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }
    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(etiketService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(etiketService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(etiketService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}