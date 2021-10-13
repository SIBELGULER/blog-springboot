package com.example.blog.etiket;

import com.example.blog.blog.BlogDTO;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/etiket")
@RestController
public class EtiketController {
    private final IEtiketService etiketService;
    public EtiketController(IEtiketService etiketService) {
        this.etiketService=etiketService;
    }
    @Operation(summary = "Etiket Kaydet",description = "Kaydetme işleminde harhangi bir hata meydana gelmemişse etiket kaydedilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket kaydetme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\","+
                                                    "\"message\": \"Başarılı.\","+
                                                    "\"path\": \"/api/etiket/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket kaydetme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\","+
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/etiket/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket kaydetme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/etiket/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket kaydetme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/kaydet\","+
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket kaydetme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\","+
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody EtiketDTO etiketDTO){
        try {
            return Util.islemSonucGetir(etiketService.kaydet(etiketDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }
    @Operation(summary = "Etiket Düzenle",description = "Düzenleme işleminde herhangi bir hata meydana gelmemişse etiket düzenlenir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket düzenle işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/etiket/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket düzenle işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/etiket/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket düzenle işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/etiket/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket düzenle işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Etiket düzenle işleminde özel bir surumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/duzenle",method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody EtiketDTO etiketDTO) throws Exception {
        try {
            return Util.islemSonucGetir(etiketService.duzenle(etiketDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }
    @Operation(summary = "Id'ye Göre Etiket Sil",description = "Id'ye göre silme işleminde herhangi bir hata meydana gelmemişse id'ye göre etiket silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\","  +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/etiket/sil/{id}\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/etiket/sil/{id}\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/etiket/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) throws Exception {
        try {
            return Util.islemSonucGetir(etiketService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }    }
    @Operation(summary = "Tüm Etiketleri Getir",description = "Tümünü getir işleminde herhangi bir hata meydana gelmezse tüm etiketleri getirir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\","+
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(etiketService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @Operation(summary = "Tüm Etiketleri Sil",description = "Tümünü sil işleminde herhangi bir hata meydana gelmezse tüm etiketleri siler.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-sil\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\","  +
                                                    "\"message\": \"Forbidden.\","  +
                                                    "\"path\": \"/api/etiket/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm etiketleri silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\","+
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(etiketService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @Operation(summary = "Id'ye Göre Etiket Getir",description = "Id'ye göre getirme işleminde herhangi bir hata meydana gelmezse id'ye göre etiket getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/etiket/getir/{id}\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\","  +
                                                    "\"path\": \"/api/etiket/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/etiket/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket getirme işleminde sayfanın bulunmadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/etiket/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre etiket getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/etiket/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(etiketService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}