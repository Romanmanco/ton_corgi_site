package com.ton_corgi_site.service.impl;

import com.ton_corgi_site.mapper.PostMapper;
import com.ton_corgi_site.model.dto.PostDTO;
import com.ton_corgi_site.model.entity.Post;
import com.ton_corgi_site.repository.PostRepo;
import com.ton_corgi_site.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo repository;

    @Autowired
    PostMapper postMapper;

    @Override
    public boolean postByIdIsPresent (Long postId) {
        return repository.existsById(postId);
    }

    @Override
    public PostDTO getPostDtoById (Long postId) throws Exception {
//        Post post = repository.getById(postId);
//        return postMapper.entityToDto(post);

        Optional<Post> optionalPost = repository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            return postMapper.entityToDto(post);
        } else {
            throw new Exception("post by id not found");
        }
    }
}
