package com.limonnana.monthFactory;

import com.limonnana.domain.ListWrapper;
import com.limonnana.domain.UnitOfCalendar;
import com.limonnana.repository.ListWrapperRepository;
import com.limonnana.repository.UnitOfCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {

    @Autowired
    ListWrapperRepository listWrapperRepository;

    @Autowired
    UnitOfCalendarRepository unitOfCalendarRepository;

    public void saveEntity(ListWrapper listWrapper){

        for(UnitOfCalendar u : listWrapper.getList()){
            unitOfCalendarRepository.save(u);
        }
        listWrapperRepository.save(listWrapper);
    }
}
