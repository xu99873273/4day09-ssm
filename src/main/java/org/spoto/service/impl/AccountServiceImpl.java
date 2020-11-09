package org.spoto.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.spoto.dao.AccountMapper;
import org.spoto.model.Account;
import org.spoto.service.AccountService;
import org.spoto.utils.PageData;
import org.spoto.utils.PageUtils;
import org.spoto.utils.TableData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper ma;

    @Override
    public TableData<Account> list(PageData pd) {
        // 构造结果数据
        TableData<Account> td = new TableData<>(pd);

        // 获取查询参数
        String account = null;
        String passwd = null;
        JSONObject sd = pd.getSd();
        if (sd != null) {
            account = sd.getString("account");
            passwd = sd.getString("passwd");
        }

        // 调用Dao
        Integer count = ma.listCount(account, passwd);
        td.setDataCount(count);
        if (count > 0) {
            List<Account> list = ma.list(account, passwd, PageUtils.getRb(pd));
            td.setDataList(list);
        }
        return td;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Account ac) {
        // 调用Dao
        if (ac.getId() > 0) {
            ma.change(ac);
        } else {
            ma.add(ac);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void del(List<Integer> idList) {
        // 调用Dao
        ma.del(idList);
    }

}
