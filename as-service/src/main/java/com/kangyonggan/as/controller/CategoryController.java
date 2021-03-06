package com.kangyonggan.as.controller;

import com.kangyonggan.as.service.NovelService;
import com.kangyonggan.common.Response;
import com.kangyonggan.np.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kangyonggan
 * @since 8/2/18
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private NovelService novelService;

    /**
     * 栏目列表
     *
     * @param type
     * @return
     */
    @GetMapping
    public Response list(@RequestParam("type") String type) {
        Response response = Response.getSuccessResponse();
        List<Category> categories = novelService.categories(type);

        response.put("list", categories);
        return response;
    }

}
