package com.kangyonggan.as.controller;

import com.kangyonggan.as.service.NovelService;
import com.kangyonggan.common.Response;
import com.kangyonggan.np.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@RestController
@RequestMapping("section")
public class SectionController extends BaseController {

    @Autowired
    private NovelService novelService;

    /**
     * 章节列表
     *
     * @return
     */
    @GetMapping
    public Response sections() {
        Response response = Response.getSuccessResponse();
        List<Section> sections = novelService.sections(getQuery());

        response.put("list", sections);
        return response;
    }

    /**
     * 章节详情
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}")
    public Response section(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = novelService.section(code);

        response.put("section", section);
        return response;
    }

    /**
     * 上一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}/prev")
    public Response sectionPrev(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = novelService.sectionPrev(code);

        response.put("section", section);
        return response;
    }

    /**
     * 下一章
     *
     * @param code
     * @return
     */
    @GetMapping(value = "{code:[\\d]+}/next")
    public Response sectionNext(@PathVariable("code") Integer code) {
        Response response = Response.getSuccessResponse();
        Section section = novelService.sectionNext(code);

        response.put("section", section);
        return response;
    }


}
