package com.raferl.test.javacv.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class SynthesisDto {
    @NotBlank private String imagesRealPath;

    @NotBlank private String destinationPath;

    private int width;

    private int height;
}
