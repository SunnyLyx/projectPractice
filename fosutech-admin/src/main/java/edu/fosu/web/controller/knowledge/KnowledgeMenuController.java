package edu.fosu.web.controller.knowledge;

import java.util.List;
import java.util.Map;

import edu.fosu.framework.util.ShiroUtils;
import edu.fosu.knowledge.domain.KnowledgeMenu;
import edu.fosu.knowledge.service.IKnowledgeMenuService;
import edu.fosu.system.domain.SysRole;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.utils.poi.ExcelUtil;

/**
 * 菜单权限 信息操作处理
 *  */
@Controller
@RequestMapping("/knowledge/knowledgeMenu")
public class KnowledgeMenuController extends BaseController
{
    private String prefix = "knowledge/knowledgeMenu";
	
	@Autowired
	private IKnowledgeMenuService knowledgeMenuService;
	
	@RequiresPermissions("knowledge:knowledgeMenu:view")
	@GetMapping()
	public String knowledgeMenu()
	{
	    return prefix + "/knowledgeMenu";
	}
	
	/**
	 * 查询菜单权限列表
	 */
	@RequiresPermissions("knowledge:knowledgeMenu:list")
	@GetMapping("/list")
	@ResponseBody
	public List<KnowledgeMenu> list(KnowledgeMenu knowledgeMenu)
	{
        List<KnowledgeMenu> list = knowledgeMenuService.selectKnowledgeMenuList(knowledgeMenu);
		return  list;
	}

	/**
	 * 查询菜单权限列表
	 */
	@RequiresPermissions("knowledge:knowledgeMenu:list")
	@PostMapping("/list1")
	@ResponseBody
	public TableDataInfo list1(KnowledgeMenu knowledgeMenu)
	{
		startPage();
		List<KnowledgeMenu> list = knowledgeMenuService.selectKnowledgeMenuList(knowledgeMenu);
		return getDataTable(list);
	}
	
	/**
	 * 导出菜单权限列表
	 */
	@RequiresPermissions("knowledge:knowledgeMenu:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KnowledgeMenu knowledgeMenu)
    {
    	List<KnowledgeMenu> list = knowledgeMenuService.selectKnowledgeMenuList(knowledgeMenu);
        ExcelUtil<KnowledgeMenu> util = new ExcelUtil<KnowledgeMenu>(KnowledgeMenu.class);
        return util.exportExcel(list, "knowledgeMenu");
    }
	
	/**
	 * 新增菜单权限
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
	{
		KnowledgeMenu menu = null;
		if (0L != parentId)
		{
			menu = knowledgeMenuService.selectMenuById(parentId);
		}
		else
		{
			menu = new KnowledgeMenu();
			menu.setMenuId(0L);
			menu.setMenuName("主目录");
		}
		mmap.put("menu", menu);
		return prefix + "/add";
	}
	
	/**
	 * 新增保存菜单权限
	 */
	@RequiresPermissions("knowledge:knowledgeMenu:add")
	@Log(title = "菜单权限", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(KnowledgeMenu knowledgeMenu)
	{
		knowledgeMenu.setCreateBy(ShiroUtils.getLoginName());
		ShiroUtils.clearCachedAuthorizationInfo();
		return toAjax(knowledgeMenuService.insertKnowledgeMenu(knowledgeMenu));
	}

	/**
	 * 修改菜单权限
	 */
	@GetMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		mmap.put("menu", knowledgeMenuService.selectMenuById(menuId));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存菜单权限
	 */
	@RequiresPermissions("knowledge:knowledgeMenu:edit")
	@Log(title = "菜单权限", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(KnowledgeMenu knowledgeMenu)
	{
		knowledgeMenu.setUpdateBy(ShiroUtils.getLoginName());
		ShiroUtils.clearCachedAuthorizationInfo();
		return toAjax(knowledgeMenuService.updateKnowledgeMenu(knowledgeMenu));
	}

	/**
	 * 选择菜单图标
	 */
	@GetMapping("/icon")
	public String icon()
	{
		return prefix + "/icon";
	}

	/**
	 * 校验菜单名称
	 */
	@PostMapping("/checkMenuNameUnique")
	@ResponseBody
	public String checkMenuNameUnique(KnowledgeMenu menu)
	{
		return knowledgeMenuService.checkMenuNameUnique(menu);
	}

	/**
	 * 加载角色菜单列表树
	 */
	@GetMapping("/roleMenuTreeData")
	@ResponseBody
	public List<Map<String, Object>> roleMenuTreeData(SysRole role)
	{
		List<Map<String, Object>> tree = knowledgeMenuService.roleMenuTreeData(role);
		return tree;
	}

	/**
	 * 加载所有菜单列表树
	 */
	@GetMapping("/menuTreeData")
	@ResponseBody
	public List<Map<String, Object>> menuTreeData(SysRole role)
	{
		List<Map<String, Object>> tree = knowledgeMenuService.menuTreeData();
		return tree;
	}

	/**
	 * 加载所有菜单列表树
	 */
	@GetMapping("/menuTreeData1")
	@ResponseBody
	public List<Map<String, Object>> menuTreeData1()
	{
		List<Map<String, Object>> tree = knowledgeMenuService.menuTreeData1();
		return tree;
	}

	/**
	 * 选择菜单树
	 */
	@GetMapping("/selectMenuTree/{menuId}")
	public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		mmap.put("menu", knowledgeMenuService.selectMenuById(menuId));
		return prefix + "/tree";
	}
	
	/**
	 * 删除菜单权限
	 */
	/*@RequiresPermissions("knowledge:knowledgeMenu:remove")
	@Log(title = "菜单权限", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(knowledgeMenuService.deleteKnowledgeMenuByIds(ids));
	}*/
	@Log(title = "知识管理-菜单管理", businessType = BusinessType.DELETE)
	@RequiresPermissions("knowledge:knowledgeMenu:remove")
	@PostMapping("/remove/{menuId}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("menuId") Long menuId)
	{
		if (knowledgeMenuService.selectCountMenuByParentId(menuId) > 0)
		{
			return error(1, "存在子菜单,不允许删除");
		}
		if (knowledgeMenuService.selectCountRoleMenuByMenuId(menuId) > 0)
		{
			return error(1, "菜单已分配,不允许删除");
		}
		ShiroUtils.clearCachedAuthorizationInfo();
		return toAjax(knowledgeMenuService.deleteMenuById(menuId));
	}

	/**
	 * 选择list
	 */
	@GetMapping("/selectList/{menuId}")
	public String selectList(@PathVariable("menuId") Long menuId, ModelMap mmap)
	{
		KnowledgeMenu knowledgeMenu = new KnowledgeMenu();
		knowledgeMenu.setMenuId(menuId);
		mmap.put("knowledgeMenu",knowledgeMenu);
		return prefix + "/list";
	}
	
}
