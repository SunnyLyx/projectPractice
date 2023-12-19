package edu.fosu.web.controller.tool;

import edu.fosu.common.base.Rs;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.knowledge.domain.KnowledgeMenu;
import edu.fosu.knowledge.domain.KnowledgeOss;
import edu.fosu.knowledge.service.IKnowledgeMenuService;
import edu.fosu.knowledge.service.IKnowledgeOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * swagger 测试方法
 */
@Api("知识管理")
@RestController
@RequestMapping("/menu/*")
public class MenuController extends BaseController
{
    @Autowired
    private IKnowledgeMenuService knowledgeMenuService;

    @Autowired
    private IKnowledgeOssService knowledgeOssService;

    @ApiOperation("获取菜单树形列表")
    @GetMapping("menuList")
    public Rs menuList()
    {
        try{
            List<Map<String, Object>> list = knowledgeMenuService.menuTreeData1();
            return Rs.success(list);
        }catch(Exception e){
            return Rs.faild();
        }
    }

    @ApiOperation("获取文件列表")
    @GetMapping("ossList")
    public Rs ossList(KnowledgeOss knowledgeOss)
    {
        try{
            List<KnowledgeOss> list = knowledgeOssService.selectKnowledgeOssList(knowledgeOss);
            return Rs.success(list);
        }catch(Exception e){
            return Rs.faild();
        }
    }
}

