package com.github.ponymaggie.jpa.repository;

import com.github.ponymaggie.jpa.entity.TabFavorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author XUAN
 * @date 2020/11/1 - 1:19
 * @references
 * @purpose
 * @errors
 */
public interface TabFavoriteRepository extends JpaRepository<TabFavorite, Long> {
    @Query("select t from TabFavorite t where t.rid = ?1 and t.uid = ?2")
    TabFavorite getRidAndUid(int rid, int uid);
}
