package org.imooc.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

@Repository
public interface BusinessDao {
    void updateStar(Map<String, Date> map);
}
