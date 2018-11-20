package org.imooc.service;


import org.imooc.dto.BusinessDto;
import org.imooc.dto.BusinessListDto;

public interface BusinessService {
    BusinessListDto searchByPageForApi(BusinessDto businessDto);

    BusinessDto getById(Long id);
}
