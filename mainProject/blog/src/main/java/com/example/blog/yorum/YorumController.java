package com.example.blog.yorum;

import com.example.blog.blog.BlogDTO;
import com.example.blog.blog.IBlogService;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/yorum")
@RestController
public class YorumController {
    private IYorumService yorumService;

    public YorumController(IYorumService yorumService) {
        this.yorumService = yorumService;
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public YorumDTO kaydet(@RequestBody YorumDTO yorumDTO) throws Exception {
        return yorumService.kaydet(yorumDTO);
    }

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public YorumDTO duzenle(@RequestBody YorumDTO yorumDTO) throws Exception {
        return yorumService.duzenle(yorumDTO);
    }

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return yorumService.sil(id);
    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(yorumService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(yorumService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }

    @RequestMapping(value = "/bul/{id}", method = RequestMethod.GET)
    public BaseResponse bul(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(yorumService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}