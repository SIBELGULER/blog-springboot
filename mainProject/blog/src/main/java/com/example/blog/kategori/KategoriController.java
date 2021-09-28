package com.example.blog.kategori;

import com.example.blog.blog.BlogDTO;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/kategori")
@RestController
public class KategoriController {
    private IKategoriService kategoriService;

    public KategoriController(IKategoriService kategoriService) {
        this.kategoriService = kategoriService;
    }
    @Operation(summary = "Kategori Kaydet",description = "Kaydetme işleminde herhangi bir hata meydana gelmemişse kategori kaydedilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori kaydetme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\","  +
                                                    "\"path\": \"/api/kategori/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori kaydetme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\","  +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori kaydetme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori kaydetme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/kaydet\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori kaydetme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public KategoriDTO kaydet(@RequestBody KategoriDTO kategoriDTO) throws Exception {
        return kategoriService.kaydet(kategoriDTO);
    }
    @Operation(summary = "Kategori Düzenle",description = "Düzenleme işleminde herhangi bir hata meydana gelmemişse kategori düzenlenir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori düzenle işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/kategori/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori düzenle işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\","+
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori düzenle işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori düzenle işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Kategori düzenle işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/duzenle\","  +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public KategoriDTO duzenle(@RequestBody KategoriDTO kategoriDTO) throws Exception {
        return kategoriService.duzenle(kategoriDTO);
    }
    @Operation(summary = "Id'ye Göre Kategori Sil",description = "Id'ye göre silme işleminde herhangi bir hata meydana gelmemişse id'ye göre kategori silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori silme  işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/kategori/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public String sil(@PathVariable Long id) throws Exception {
        return kategoriService.sil(id);
    }
    @Operation(summary = "Tüm Kategorileri Getir",description = "Tüm kategorileri getir işleminde herhangi bir hata meydana gelmemişse tüm kategoriler getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    }),
    })

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(kategoriService.findAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @Operation(summary = "Tüm Kategorileri Sil",description = "Tüm kategorileri sil işleminde herhangi bir hata meydana gelmemişse tüm kategoriler silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Tüm kategorileri silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(kategoriService.deleteAll());
        } catch (Exception ex) {
            return Util.islemSonucGetir(ex);
        }
    }
    @Operation(summary = "Id'ye Göre Kategori Getir",description = "Id'ye göre getirme işleminde herhangi bir hata meydana gelmemişse id'ye göre kategori getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value={
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/kategori/bul/{id}\"," +
                                                    "\"timestamp\":\"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori bulma işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/kategori/bul/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori bulma işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/kategori/bul/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori bulma işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/kategori/bul/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples= @ExampleObject(
                                            name = "Id'ye göre kategori bulma işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/kategori/bul/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/bul/{id}", method = RequestMethod.GET,consumes = {"application/json"})
    public BaseResponse bul(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(kategoriService.findAllById(id));
        }catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
}