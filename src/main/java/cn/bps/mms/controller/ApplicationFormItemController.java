package cn.bps.mms.controller;


import cn.bps.common.lang.domain.Ret;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.service.ApplicationFormItemService;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 账户基本信息 前端控制器
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/applyItem")
public class ApplicationFormItemController {

    @Resource
    private ApplicationFormItemService applicationFormItemService;

    @PostMapping("")
    public Ret add(@RequestBody ApplicationFormItem item, @RequestHeader String token){
        return Ret.create(()-> applicationFormItemService.addItem(item, token));
    }

    @GetMapping("")
    public Ret<List<ApplicationItemVo>> list(@RequestHeader String token){
        return Ret.ok(applicationFormItemService.list(token));
    }

    @DeleteMapping("/{id}")
    public Ret deleteUser(@PathVariable String id) {
        return Ret.ok(()-> applicationFormItemService.removeById(id));
}

}

