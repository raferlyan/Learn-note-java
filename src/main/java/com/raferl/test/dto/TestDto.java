package com.raferl.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author raferlyan
 * @date 2022/9/29 08:33
 **/
@Getter
@Setter
public class TestDto {
    private List<String> info;

    private String reasonableRange;

    private String owner;

    private String dataDate;
}
