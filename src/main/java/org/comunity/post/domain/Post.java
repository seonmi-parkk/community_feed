package org.comunity.post.domain;

import org.comunity.common.domain.PositiveIntegerCounter;
import org.comunity.post.domain.content.PostContent;
import org.comunity.user.domain.User;

public class Post {
    private final long id; // postId

    // 글쓴이의 User 객체를 가지냐 Long타입으로 아이디를 가지고 있느냐 선택
    // User 객체를 참조하고 있으면
        // 유저객체에 대한 기능이 생긴다면 메서드로 바로 사용가능한 것이 좋고,
        // 유저라는 객체를 참조하고 있다는 가독성이 좋음.
    // 단점은 테스트 셋팅할때 번거로움.
    // Long으로 Id를 주입받을 때 단점은
        // 행동기반으로 생각해보면 객체지향에 가까운 방법이 아님.
    // 우리는 유저의 객체를 확인하고 저장하고 있기 때문에 객체를 주입해주는데 어려움이 없기 때문에 User객체를 주입받는 방향으로 진행
    //private final Long authorId;
    private final User author;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    // 노출상태 enum값
    private PostPublicationState state;

    public Post(Long id, User author, PostContent content) {
        if(author == null){
            throw new IllegalArgumentException("");
        }

        this.id = id;
        //this.authorId = author.getId();
        this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
    }

    public void like(User user) {
        if(this.author.equals(user)) {
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike() {
        this.likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        if(!this.author.equals(user)) {
            throw new IllegalArgumentException();
        }

        this.state = state;
        this.content.updateContent(updateContent);
    }

}
