package com.ton_corgi_site.repository;

import com.ton_corgi_site.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Roman Manko
 * @version 1.0
 */

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {
}
