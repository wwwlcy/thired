package org.imooc.dao;

import org.imooc.bean.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberDao {
    /**
     * 根据查询条件查询会员列表
     * @param member 查询条件
     * @return 会员列表
     */
    List<Member> select(Member member);
}