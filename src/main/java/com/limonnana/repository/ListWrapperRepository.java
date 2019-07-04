package com.limonnana.repository;

import com.limonnana.domain.ListWrapper;
import com.limonnana.domain.MonthList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListWrapperRepository extends JpaRepository<ListWrapper, Integer> {
}
