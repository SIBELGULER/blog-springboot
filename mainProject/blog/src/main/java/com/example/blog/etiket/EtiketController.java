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
    public EtiketDTO kaydet(@RequestBody EtiketDTO etiketDTO) throws Exception {
        return etiketService.kaydet(etiketDTO);
    }

    @RequestMapping(value = "/duzenle",method = RequestMethod.PUT)
    public EtiketDTO duzenle(@RequestBody EtiketDTO etiketDTO) throws Exception {
        return etiketService.duzenle(etiketDTO);
    }

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return etiketService.sil(id);
    }
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

    @RequestMapping(value = "/bul/{id}", method = RequestMethod.GET)
    public BaseResponse bul(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(etiketService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}