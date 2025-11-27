package com.randaegs.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record LoginRequestDto(
        @Email @NotBlank @NotNull
        String email,
        @NotBlank @NotNull @Length(min = 8)
        String password
) {
}
