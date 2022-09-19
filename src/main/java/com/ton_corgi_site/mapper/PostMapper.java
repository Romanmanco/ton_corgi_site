package com.ton_corgi_site.mapper;

import com.ton_corgi_site.model.dto.PostDTO;
import com.ton_corgi_site.model.entity.Post;
import org.springframework.stereotype.Component;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Component
public class PostMapper {
    public PostDTO entityToDto(Post entity) {
        PostDTO dto = new PostDTO();
        dto.setFullText(entity.getFullText());
        dto.setAnons(entity.getAnons());
        dto.setTitle(entity.getTitle());
        return dto;
    }
}
