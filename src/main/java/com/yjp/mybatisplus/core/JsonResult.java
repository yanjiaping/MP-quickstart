package com.yjp.mybatisplus.core;

import lombok.Data;

@Data
public class JsonResult {
    private String status = null;
    private Object result = null;
}
