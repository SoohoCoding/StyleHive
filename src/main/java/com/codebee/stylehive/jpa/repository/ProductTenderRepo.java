package com.codebee.stylehive.jpa.repository;

import com.codebee.stylehive.jpa.entity.ProductTenderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductTenderRepo extends JpaRepository<ProductTenderEntity, Integer> {
    // 추천 상품 상위 5개
    @Query(value = "SELECT t.product_id " +
            "FROM product_tender t " +
            "WHERE t.tender_date >= :oneWeekAgo " +
            "GROUP BY t.product_id " +
            "ORDER BY COUNT(t.product_id) DESC, MAX(t.tender_date) DESC, t.tender_num desc " +
            "LIMIT 5", nativeQuery = true)
    List<Object[]> findTop5MostTenderedProductIdsInLastWeek(Date oneWeekAgo);

    // 인기 브랜드 상위 6개
    @Query("SELECT pb, COUNT(pt) as saleCount " +
            "FROM ProductTenderEntity pt " +
            "JOIN pt.product p " +
            "JOIN p.productBrand pb " +
            "GROUP BY pb " +
            "ORDER BY saleCount DESC " +
            "LIMIT 6")
    List<Object[]> findTop6BrandsByTenderCountCustomQuery();

}