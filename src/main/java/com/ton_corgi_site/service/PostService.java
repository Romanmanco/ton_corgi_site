package com.ton_corgi_site.service;

import com.ton_corgi_site.model.dto.PostDTO;
import org.springframework.stereotype.Service;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Service
public interface PostService {

    boolean postByIdIsPresent(Long postId);

    PostDTO getPostDtoById(Long postId) throws Exception;

}
