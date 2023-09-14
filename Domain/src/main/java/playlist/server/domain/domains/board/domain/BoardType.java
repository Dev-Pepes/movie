package playlist.server.domain.domains.board.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BoardType {
    PLAYLIST("플레이리스트 게시판"),
    NOTI("공지사항"),
    NORMAL("일반 게시판"),
    ADMIN("관리자만 확인 가능한 게시판"),
    FAQ("FAQ 전용 게시판");

    private final String value;
}
