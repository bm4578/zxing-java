package xyz.onlytype.controller;

import com.google.zxing.WriterException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xyz.onlytype.tools.QRCodeGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

/**
 * The type Zxing controller.
 *
 * @author 白也
 * @date 2023 /3/13 6:53 下午
 * @title
 */
@Api(tags = {"二维码生成"})
@RestController
@RequestMapping
public class ZxingController {
    @Autowired
    private QRCodeGenerator qrCodeGenerator;

    /**
     * 获取二维码
     *
     * @param text the text
     * @return the byte [ ]
     * @throws WriterException the writer exception
     * @throws IOException     the io exception
     */


    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "text", value = "输入信息与网址", required = true)
    })
    @ApiOperation(value = "获取二维码", notes = "", httpMethod = "GET")
    @GetMapping(value = "/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getQRCodeImage(String text) throws WriterException, IOException {
        return qrCodeGenerator.generateQRCodeImage(text, 256, 256);
    }
}
