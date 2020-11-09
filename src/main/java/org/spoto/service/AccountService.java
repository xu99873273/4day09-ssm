package org.spoto.service;

import org.spoto.model.Account;
import org.spoto.utils.PageData;
import org.spoto.utils.TableData;

import java.util.List;

public interface AccountService {

    TableData<Account> list(PageData pd);

    void save(Account ac);

    void del(List<Integer> idList);

}
