package com.shen.config;

import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

@Data
public class ExportUser {

    private String taskName;

    private JSONObject taskParams;

}
