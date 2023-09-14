package playlist.server.domain.domains.board.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ArticleStatus {
    WRITING("작성중"),
    PUBLIC("공개상태"),
    HIDING("숨김처리"),
    DELETE("삭제처리");

    private final String value;
}
