package org.comunity.post.application.interfaces;

import org.comunity.post.domain.Post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);

}
