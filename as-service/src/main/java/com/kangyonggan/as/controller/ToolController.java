package com.kangyonggan.as.controller;

import com.kangyonggan.as.service.ToolService;
import com.kangyonggan.common.Response;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kangyonggan
 * @since 5/17/18
 */
@RestController
@RequestMapping("tool")
public class ToolController extends BaseController {

    @Autowired
    private ToolService toolService;

    /**
     * 预处理
     *
     * @return
     */
    @GetMapping
    public Response preSubmit() {
        Response response = Response.getSuccessResponse();
        toolService.preHandle(getRequestParams(), response);

        return response;
    }

    /**
     * 提交
     *
     * @param file
     * @return
     */
    @PostMapping
    public Response submit(@RequestParam(value = "file", required = false) MultipartFile file) throws FileUploadException {
        Response response = Response.getSuccessResponse();
        toolService.handle(getRequestParams(), response, file);

        return response;
    }

}

