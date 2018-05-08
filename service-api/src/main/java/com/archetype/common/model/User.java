package com.archetype.common.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -7233238826463139634L;

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private Integer age;

}
