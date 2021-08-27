package com.example.blog.kategori;

import com.example.blog.blog.BlogDTO;
import com.example.blog.blog.IBlogService;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/kategori")
@RestController
public class KategoriController {
    private IKategoriService kategoriService;

    public KategoriController(IKategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public KategoriDTO kaydet(@RequestBody KategoriDTO kategoriDTO) throws Exception {
        return kategoriService.kaydet(kategoriDTO);
    }

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public KategoriDTO duzenle(@RequestBody KategoriDTO kategoriDTO) throws Exception {
        return kategoriService.duzenle(kategoriDTO);
    }

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return kategoriService.sil(id);
    }
    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(kategoriService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(kategoriService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/bul/{id}", method = RequestMethod.GET)
    public BaseResponse bul(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(kategoriService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}