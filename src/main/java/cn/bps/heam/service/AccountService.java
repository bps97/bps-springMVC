package cn.bps.heam.service;

import cn.bps.common.lang.api.Page;
import cn.bps.common.lang.api.Token;
import cn.bps.common.lang.domain.Callback;
import cn.bps.heam.domain.PageRequest;
import cn.bps.heam.domain.form.UserForm;
import cn.bps.heam.domain.model.Account;
import cn.bps.heam.domain.result.UserResult;

import java.util.List;

public interface AccountService {

    void userRegister(UserForm userForm);

    Token login(UserForm userForm);

    boolean checkUsername(UserForm userForm);

    Account getAccountByUsername(String username);

    UserResult getUserById(String id);

    Account getAccountById(String id);

    void deleteAccount(String id);

    List<UserResult> listUsers(PageRequest pageRequest, String key);

    Page<UserResult> pageUsers(PageRequest pageRequest, String key);

    UserResult changeAvailable(String id, boolean available);


    /**
     * 关于控制层和业务层的功能配置
     * 对于业务层的业务，如果包含多种结果，不直接返回而通过抛出异常
     * 对于抛出的异常，在控制层解决，待以后项目体系变大了之后，再考虑拆分控制层的异常解决
     */

}
