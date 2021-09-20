package com.example.blog.yorum;

import com.example.blog.blog.BlogGetirDTO;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/yorum")
@RestController
public class YorumController {
    private IYorumService yorumService;

    public YorumController(IYorumService yorumService) {
        this.yorumService = yorumService;
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody YorumDTO yorumDTO){
        try {
            return Util.islemSonucGetir(yorumService.kaydet(yorumDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody YorumDTO yorumDTO){
        try {
            return Util.islemSonucGetir(yorumService.duzenle(yorumDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) throws Exception {
        try {
            return Util.islemSonucGetir(yorumService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(yorumService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(yorumService.deleteAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(yorumService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value = "/blog-id-ye-gore-getir", method = RequestMethod.POST)
    public BaseResponse blogIdyeGoreGetir(@RequestBody BlogGetirDTO blogDTO) {
        try {
            return Util.islemSonucGetir(yorumService.findByBlogId(blogDTO.getId()));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }
}