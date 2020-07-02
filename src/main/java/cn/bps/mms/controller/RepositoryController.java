package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.service.RepositoryService;
import cn.bps.mms.domain.vo.KeyValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 仓库 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@RestController
@RequestMapping("/repository")
public class RepositoryController {

    @Resource
    private RepositoryService repositoryService;

    @GetMapping("/names")
    public Ret<List<KeyValue>> getAllRepoNames(){
        return Ret.ok(repositoryService.listAllRepoNames());
    }

}

