package org.imooc.dao;

import org.imooc.bean.Ad;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdDao {
    List<Ad> selectAds();
}