package com.example.blog.resim;

import com.example.blog.blog.BlogDTO;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/resim")
@RestController
public class ResimController {
    IResimService iResimService;

    public ResimController(IResimService iResimService) {
        this.iResimService = iResimService;
    }

    @Operation(summary = "Resim Kaydet", description = "Resim kaydetme işleminde herhangi bir hata meydana gelmemişse resim kaydedilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim kaydetme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim kaydetme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim kaydetme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim kaydetme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim kaydetme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/kaydet\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody ResimDTO resimDTO) {
        try {
            return Util.islemSonucGetir(iResimService.kaydet(resimDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Resim Sil", description = "Id'ye göre resim silme işleminde herhangi bir hata meydana gelmemişse id'ye göre resim silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/sil/{id}\"," +
                                                    "\"timestamp\":\"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/sil/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/sil/{id}", method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(iResimService.sil(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Resimleri Sil", description = "Tüm resimleri silme işleminde herhangi bir hata meydana gelmemişse tüm resimler silinir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri silme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri silme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri silme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri silme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri silme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/tumunu-sil\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-sil", method = RequestMethod.DELETE)
    public BaseResponse tumunuSil() {
        try {
            return Util.islemSonucGetir(iResimService.tumunuSil());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Resim Düzenle", description = "Resim düzenle işleminde herhangi bir hata meydana gelmemişse resim düzenlenir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim düzenle işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim düzenle işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim düzenle işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim düzenle işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Resim düzenle işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/duzenle\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/duzenle", method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody ResimDTO resimDTO) {
        try {
            return Util.islemSonucGetir(iResimService.duzenle(resimDTO));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Tüm Resimleri Getir", description = "Tüm resimleri getirme işleminde herhangi bir hata meydana gelmemişse tüm resimler getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Tüm resimleri getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/tumunu-getir\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/tumunu-getir", method = RequestMethod.GET)
    public BaseResponse tumunuGetir() {
        try {
            return Util.islemSonucGetir(iResimService.findAll());
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

    @Operation(summary = "Id'ye Göre Resim Getir", description = "Id'ye göre resim getirme işleminde herhangi bir hata meydana gelmemişse id'ye göre resim getirilir.")
    @io.swagger.v3.oas.annotations.responses.ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "successful operation",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim getirme işleminin başarılı olduğunu bildirir.",
                                            value = "{\"status\": \"200\"," +
                                                    "\"message\": \"Başarılı.\"," +
                                                    "\"path\": \"/api/resim/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim getirme işleminde yetkisiz erişim olduğunu bildirir.",
                                            value = "{\"status\": \"401\"," +
                                                    "\"message\": \"Unauthorized.\"," +
                                                    "\"path\": \"/api/resim/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "403", description = "Forbidden",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim getirme işleminin yasaklı olduğunu bildirir.",
                                            value = "{\"status\": \"403\"," +
                                                    "\"message\": \"Forbidden.\"," +
                                                    "\"path\": \"/api/resim/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not Found",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim getirme işleminde sayfanın bulunamadığını bildirir.",
                                            value = "{\"status\": \"404\"," +
                                                    "\"message\": \"Not Found.\"," +
                                                    "\"path\": \"/api/resim/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )

                    }),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "405", description = "Validation exception",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = BlogDTO.class),
                                    examples = @ExampleObject(
                                            name = "Id'ye göre resim getirme işleminde özel bir durumun oluştuğunu bildirir.",
                                            value = "{\"status\": \"405\"," +
                                                    "\"message\": \"Validation exception.\"," +
                                                    "\"path\": \"/api/resim/getir/{id}\"," +
                                                    "\"timestamp\": \"21.09.2021\"}"
                                    )
                            )
                    })
    })

    @RequestMapping(value = "/getir/{id}", method = RequestMethod.GET)
    public BaseResponse getir(@PathVariable Long id) {
        try {
            return Util.islemSonucGetir(iResimService.findById(id));
        } catch (Exception e) {
            return Util.islemSonucGetir(e);
        }
    }

}
