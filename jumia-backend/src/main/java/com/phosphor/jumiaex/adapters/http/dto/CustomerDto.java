package com.phosphor.jumiaex.adapters.http.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = 7809559376441998463L;

    @NotNull
    private String name;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String country;
    @NotNull
    private String isPhoneValid;
}
