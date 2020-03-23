package com.it.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonFormatController {

    @PostMapping("/format")
    public String format(@RequestBody String jsonStr) {

        if (!StringUtils.hasText(jsonStr)) {
            return "";
        }

        JSONObject jsonObject = JSON.parseObject(jsonStr);
        return JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue
                , SerializerFeature.WriteDateUseDateFormat);

    }
}
