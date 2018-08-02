package com.kangyonggan.as.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.as.service.NovelService;
import com.kangyonggan.common.Response;
import com.kangyonggan.np.model.Novel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@RestController
@RequestMapping("novel")
public class NovelController extends BaseController {

    @Autowired
    private NovelService novelService;

    /**
     * 小说列表
     *
     * @return
     */
    @GetMapping
    public Response list() {
        Response response = Response.getSuccessResponse();
        PageInfo<Novel> pageInfo = novelService.list(getQuery());

        response.put("pageInfo", pageInfo);
        return response;
    }

    /**
     * 小说详情
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}")
    public Response detail(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Novel novel = novelService.get(code);

        response.put("novel", novel);
        return response;
    }

    /**
     * 拉取小说最新章节
     *
     * @param code
     * @return
     */
    @PutMapping(value = "{code:[\\d]+}/pull")
    public Response pull(@PathVariable("code") Integer code) {
        novelService.pull(code);
        return Response.getSuccessResponse();
    }
}
