package com.nourcine.backend.dto;

import com.nourcine.backend.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategory {
    Long id;
    String name;

    public static ResponseCategory makeCategory(Category category) {
        return ResponseCategory.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
