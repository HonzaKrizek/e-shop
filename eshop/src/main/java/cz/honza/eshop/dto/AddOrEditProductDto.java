package cz.honza.eshop.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@Data
public class AddOrEditProductDto {

    private Long id;

    private String name;

    private Integer price;

    private String description;

    private MultipartFile image;


}
