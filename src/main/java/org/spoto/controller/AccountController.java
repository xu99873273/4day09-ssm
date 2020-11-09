package org.spoto.controller;

import com.alibaba.fastjson.JSONObject;
import org.spoto.model.Account;
import org.spoto.service.AccountService;
import org.spoto.utils.PageData;
import org.spoto.utils.StringUtils;
import org.spoto.utils.TableData;
import org.spoto.utils.WebUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Resource
    private AccountService as;

    @RequestMapping("/account-list.ajax")
    public String accountList(PageData pd) {
        return WebUtils.returnData(as.list(pd));
    }

    @RequestMapping("/account-save.ajax")
    public String accountSave(Account ac) {
        // 调用Service
        as.save(ac);
        JSONObject data = new JSONObject();
        data.put("type", 0);
        return data.toString();
    }

    @RequestMapping("/account-del.ajax")
    public String accountDel(String ids) {
        JSONObject data = new JSONObject();

        System.out.println(ids);
        // 参数校验
        if (StringUtils.isEmpty(ids)) {
            data.put("type", -1);
            return data.toString();
        }

        // 参数转换
        String[] idArr = ids.split(",");
        List<Integer> idList = new ArrayList<>();
        for (String id : idArr) {
            int i = Integer.parseInt(id);
            idList.add(i);
        }
        // 调用Service
        as.del(idList);
        data.put("type", 0);
        return data.toString();
    }

}
