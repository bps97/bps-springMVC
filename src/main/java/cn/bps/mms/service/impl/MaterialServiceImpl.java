package cn.bps.mms.service.impl;

import cn.bps.common.lang.api.Page;
import cn.bps.mms.domain.PageRequest;
import cn.bps.mms.domian.ao.MaterialAo;
import cn.bps.mms.entity.Category;
import cn.bps.mms.entity.Material;
import cn.bps.mms.mapper.MaterialMapper;
import cn.bps.mms.service.CategoryService;
import cn.bps.mms.service.MaterialService;
import cn.bps.mms.domian.vo.KeyValue;
import cn.bps.mms.domian.vo.MaterialVo;
import cn.bps.mms.service.RepositoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 产品 服务实现类
 * </p>
 *
 * @author bps
 * @since 2020-06-09
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {


    @Resource
    private CategoryService categoryService;

    @Resource
    private RepositoryService repositoryService;



    @Override
    public List<Material> listMaterials(String categoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("category_id",categoryId);
        return this.list(wrapper);
    }

    @Override
    public List<Material> listMaterialsByRepositoryId(String repositoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("repository_id", repositoryId);
        return this.list(wrapper);
    }

    @Override
    public List<Material> listMaterialsByRepositoryId(String categoryId, String repositoryId) {
        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper
                .eq("repository_id", repositoryId)
                .eq("category_id",categoryId);
        return this.list(wrapper);
    }

    @Override
    public List<KeyValue> listMaterialNames(String categoryId, String repositoryId) {
        List<Material> materials = repositoryId.isEmpty() ? listMaterials(categoryId) : listMaterialsByRepositoryId(categoryId, repositoryId);
        return materials.stream().map(e->{
            KeyValue keyValue = new KeyValue();
            keyValue.setKey(e.getId());
            keyValue.setValue(e.getName());
            return keyValue;
        }).collect(Collectors.toList());
    }

    @Override
    public IPage<MaterialVo> pageMaterials(com.baomidou.mybatisplus.extension.plugins.pagination.Page<Material> page, MaterialAo ao) {

        String categoryId = ao.getCategoryId();
        Set<String> children = categoryService.getChildren(categoryId)
                .stream()
                .map(Category::getId)
                .collect(Collectors.toSet());
        children.add(categoryId);

        QueryWrapper<Material> wrapper = new QueryWrapper<>();
        wrapper.in("category_id",children);

        String key = ao.getKey();
        if(key.isEmpty() == false){
            wrapper.like("name",key);
        }

        IPage<Material> pageMaterial = this.page(page, wrapper);
        List vos = (List) pageMaterial.getRecords()
                .stream()
                .map(e->{return model2Vo((Material)e);})
                .collect(Collectors.toList());
        IPage<MaterialVo> iPage =  pageMaterial.setRecords(vos);

        return iPage;
    }

    private MaterialVo model2Vo(Material material){
        MaterialVo vo = new MaterialVo();
        vo.setName(material.getName());
        vo.setAvailable(material.getAvailable());
        vo.setCategoryId(material.getCategoryId());
        vo.setCount(material.getCount());
        vo.setCreateTime(material.getCreateTime());
        vo.setUpdateTime(material.getUpdateTime());
        vo.setId(material.getId());
        vo.setRepositoryId(material.getRepositoryId());
        vo.setRepositoryName(repositoryService.getById(material.getRepositoryId()).getName());
        vo.setSpecialLine(material.getSpecialLine());
        vo.setCategoryName(categoryService.getById(material.getCategoryId()).getName());
        return vo;
    }
}
