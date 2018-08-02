package com.kangyonggan.as.controller;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.as.service.PhrasalService;
import com.kangyonggan.common.Response;
import com.kangyonggan.pp.model.Phrasal;
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
@RequestMapping("phrasal")
public class PhrasalController extends BaseController {

    @Autowired
    private PhrasalService phrasalService;

    /**
     * 成语列表
     *
     * @return
     */
    @GetMapping
    public Response phrasals() {
        Response response = Response.getSuccessResponse();
        PageInfo<Phrasal> pageInfo = phrasalService.phrasals(getQuery());

        response.put("pageInfo", pageInfo);
        return response;
    }

    /**
     * 成语详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id:[\\d]+}")
    public Response phrasal(@PathVariable("id") Long id) {
        Response response = Response.getSuccessResponse();
        Phrasal phrasal = phrasalService.phrasal(id);
        List<Phrasal> phrasalList = phrasalService.phrasalsBelow(phrasal.getName().substring(phrasal.getName().length() - 1));

        response.put("phrasal", phrasal);
        response.put("phrasalList", phrasalList);
        return response;
    }

}
