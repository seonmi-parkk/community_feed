package org.comunity.post.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.comunity.post.application.interfaces.CommentRepository;
import org.comunity.post.domain.comment.Comment;
import org.comunity.post.repository.entity.comment.CommentEntity;
import org.comunity.post.repository.jpa.JpaCommentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    @Transactional
    public Comment save(Comment comment) {
        CommentEntity commentEntity = new CommentEntity(comment);
        if(comment.getId() != null) {
            jpaCommentRepository.updateCommentEntity(commentEntity);
            return comment;
        }
        commentEntity = jpaCommentRepository.save(commentEntity);
        return commentEntity.toComment();
    }

    @Override
    public Comment findById(Long id) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElseThrow();
        return commentEntity.toComment();
    }
}
