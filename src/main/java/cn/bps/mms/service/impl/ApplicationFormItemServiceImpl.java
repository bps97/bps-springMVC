package cn.bps.mms.service.impl;

import cn.bps.mms.entity.ApplicationForm;
import cn.bps.mms.entity.ApplicationFormItem;
import cn.bps.mms.mapper.ApplicationFormItemMapper;
import cn.bps.mms.service.*;
import cn.bps.mms.domain.vo.ApplicationItemVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 申请单项 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-21
 */
@Service
public class ApplicationFormItemServiceImpl extends ServiceImpl<ApplicationFormItemMapper, ApplicationFormItem> implements ApplicationFormItemService {

    @Resource
    private CategoryService categoryService;

    @Resource
    private MaterialService materialService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private ApplicationFormService applicationFormService;


    @Override
    public void addItem(ApplicationFormItem item, String tokenValue) {

        

        ApplicationForm applicationForm = applicationFormService.getApplication(tokenValue);
        item.setApplicationFormId(applicationForm.getId());

        String categoryId = item.getCategoryId();
        String categoryName = categoryService.getById(categoryId).getName();
        item.setCategoryName(categoryName);

        String materialId = item.getMaterialId();
        String materialName = materialService.getById(materialId).getName();
        item.setMaterialName(materialName);

        String repositoryId  = item.getRepositoryId();
        String repositoryName = repositoryService.getById(repositoryId).getName();
        item.setRepositoryName(repositoryName);

        this.save(item);
    }

    @Override
    public List<ApplicationItemVo> list(String tokenValue) {

        ApplicationForm applicationForm = applicationFormService.getApplication(tokenValue);

        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_form_id", applicationForm.getId());
        List<ApplicationFormItem> items = this.list(wrapper);

        return items.stream().map(this::model2Vo).collect(Collectors.toList());
    }

    @Override
    public void closeItems(ApplicationForm applicationForm) {
        ApplicationFormItem item = new ApplicationFormItem();
        item.setAvailable(false);
        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("available", true)
                .eq("application_form_id", applicationForm.getId());
        this.update(item,wrapper);
    }

    @Override
    public List<ApplicationFormItem> list(ApplicationForm applicationForm) {
        QueryWrapper<ApplicationFormItem> wrapper = new QueryWrapper<>();
        wrapper
                .eq("application_form_id", applicationForm.getId());
        return this.list(wrapper);
    }

    private ApplicationItemVo model2Vo(ApplicationFormItem item){
        ApplicationItemVo vo = new ApplicationItemVo();
        vo.setId(item.getId());
        vo.setMaterialName(item.getMaterialName());
        vo.setCategoryName(item.getCategoryName());
        vo.setRepositoryName(item.getRepositoryName());
        vo.setCount(item.getCount());
        vo.setSpecialLine(materialService.getById(item.getMaterialId()).getSpecialLine());
        return vo;
    }
}
