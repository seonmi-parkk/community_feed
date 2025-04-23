package org.comunity.user.repository.jpa;

import org.comunity.user.repository.entity.UserRelationEntity;
import org.comunity.user.repository.entity.UserRelationIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {
}
