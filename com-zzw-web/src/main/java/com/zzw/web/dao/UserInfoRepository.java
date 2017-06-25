package com.zzw.web.dao;

import org.springframework.data.repository.CrudRepository;
import com.zzw.web.domain.UserInfo;


 
/**
 * UserInfo持久化类;
 * @author 
 * @version v.0.1
 */
public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{
   
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
   
}
