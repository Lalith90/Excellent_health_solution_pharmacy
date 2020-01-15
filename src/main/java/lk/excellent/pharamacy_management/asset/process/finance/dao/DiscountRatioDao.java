package lk.excellent.pharamacy_management.asset.process.finance.dao;

import lk.excellent.pharamacy_management.asset.process.finance.entity.DiscountRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRatioDao extends JpaRepository<DiscountRatio, Integer> {
}
