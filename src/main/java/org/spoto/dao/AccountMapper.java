package org.spoto.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.spoto.model.Account;

import java.util.List;

public interface AccountMapper {

    List<Account> list(@Param("account") String account, @Param("passwd") String passwd, RowBounds rb);

    Integer listCount(@Param("account") String account, @Param("passwd") String passwd);

    Integer add(@Param("ac") Account ac);

    Integer change(@Param("ac") Account ac);

    Integer del(@Param("ids") List<Integer> ids);

}
