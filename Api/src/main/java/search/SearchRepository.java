package search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<SearchEntity, Long> {

    // 태그를 기반으로 검색하기 위한 사용자 정의 메서드
    List<SearchEntity> findByTag(String tag);

    // 자동완성을 위한 사용자 정의 메서드
    List<SearchEntity> findByTitleStartingWith(String query);
}
