package org.imooc.dao;

import org.imooc.bean.Dic;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DicDao {
    List<Dic> select(Dic dic);
}