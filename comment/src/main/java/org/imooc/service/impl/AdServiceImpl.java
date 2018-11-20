package org.imooc.service.impl;

import org.imooc.bean.Ad;
import org.imooc.dao.AdDao;
import org.imooc.dto.AdDto;
import org.imooc.service.AdService;
import org.imooc.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdDao adDao;

    @Override
    public List<AdDto> searchByPage(AdDto adDto) {
        return null;
    }

    @Override
    public List<Ad> selectAllAd() {
        List<Ad> list = adDao.selectAds();
        return list;
    }
}
