package cz.honza.eshop.dto;

import lombok.Data;

@Data
public class AddOrEditReviewDto {

    private Long id;

    private String nick;

    private String evaluation;

    private Integer rating;
}
