package com.ton_corgi_site_tests.repo;

import com.ton_corgi_site.model.entity.Post;
import com.ton_corgi_site.repository.PostRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class RepositoryPostTest {

    @Autowired
    private PostRepo repository;

    private static final Long POST_ID = 1L;
    private static final String POST_TITLE = "какой-то текст";
    private static final String POST_ANONS = "анонс поста";
    private static final String POST_FULL_TEXT = "полный текст статьи";
    private static final Long POST_VIEWS = 1L;
    private static final String POST_TITLE_SECOND = "какой-то текст, но уже чуть другой";
    private static final String POST_ANONS_SECOND = "анонс второго поста";
    private static final String POST_FULL_TEXT_SECOND = "полный текст статьи, на другой лад";
    private static final int POST_VIEWS_SECOND = 2;
    private static final int INDEX_OF_EXPECTED_POST = 0;
    private static final int EXPECTED_VALUE_ZERO = 0;
    private static final int EXPECTED_VALUE_ONE = 1;

    @Test
    public void findByIdTest() {
        init();
        Post storedPost = repository.getById(POST_ID);

        assertNotNull(storedPost);
        assertEquals(POST_TITLE, storedPost.getTitle());
        assertEquals(POST_ANONS, storedPost.getAnons());
        assertEquals(POST_FULL_TEXT, storedPost.getFullText());
        assertEquals(POST_VIEWS, storedPost.getViews());
    }

    @Test
    public void postSaveTest() {
        init();

        List<Post> postList = repository.findAll();

        assertEquals(EXPECTED_VALUE_ONE, postList.size());
        assertEquals(POST_TITLE, postList.get(INDEX_OF_EXPECTED_POST).getTitle());
        assertEquals(POST_ANONS, postList.get(INDEX_OF_EXPECTED_POST).getAnons());
        assertEquals(POST_FULL_TEXT, postList.get(INDEX_OF_EXPECTED_POST).getFullText());
//        assertEquals(POST_VIEWS, postList.get(INDEX_OF_EXPECTED_POST).getViews());
    }

    @Test
    public void postUpdateTest() {
        init();
        List<Post> postList = repository.findAll();

        Post storedPost = postList.get(INDEX_OF_EXPECTED_POST);

        storedPost.setTitle(POST_TITLE);
        storedPost.setAnons(POST_ANONS);
        storedPost.setFullText(POST_FULL_TEXT);
//        storedPost.setViews(POST_VIEWS);

        repository.save(storedPost);

        List<Post> postListSecond = repository.findAll();
        assertEquals(POST_TITLE, postListSecond.get(INDEX_OF_EXPECTED_POST).getTitle());

        storedPost.setTitle(POST_TITLE_SECOND);
        storedPost.setAnons(POST_ANONS_SECOND);
        storedPost.setFullText(POST_FULL_TEXT_SECOND);
//        storedPost.setViews(POST_VIEWS_SECOND);

        repository.save(storedPost);

        assertEquals(EXPECTED_VALUE_ONE, postList.size());
        assertEquals(POST_TITLE_SECOND, postList.get(INDEX_OF_EXPECTED_POST).getTitle());
        assertEquals(POST_ANONS_SECOND, postList.get(INDEX_OF_EXPECTED_POST).getAnons());
        assertEquals(POST_FULL_TEXT_SECOND, postList.get(INDEX_OF_EXPECTED_POST).getFullText());
//        assertEquals(POST_VIEWS_SECOND, postList.get(INDEX_OF_EXPECTED_POST).getViews());
    }

    @Test
    public void postDeleteByIdTest() {
        init();

        repository.deleteById(POST_ID);

        List<Post> all = repository.findAll();
        assertEquals(EXPECTED_VALUE_ZERO, all.size());
    }

    private void init() {
        Post post = new Post();
        post.setId(POST_ID);
        post.setTitle(POST_TITLE);
        post.setAnons(POST_ANONS);
        post.setFullText(POST_FULL_TEXT);
        post.setViews(POST_VIEWS);
        repository.save(post);
    }
}
