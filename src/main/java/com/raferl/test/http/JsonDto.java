package com.raferl.test.http;

import lombok.Getter;
import lombok.Setter;

/**
 * @author raferlyan
 * @date 2022/10/3 20:05
 **/
@Getter
@Setter
public class JsonDto {
    private String questionType;

    private int questionId;

    private String optionType;
}
