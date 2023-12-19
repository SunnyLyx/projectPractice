package edu.fosu.web.controller.system;

import java.util.List;
import java.util.Map;

import edu.fosu.framework.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import edu.fosu.common.annotation.Log;
import edu.fosu.common.base.AjaxResult;
import edu.fosu.common.enums.BusinessType;
import edu.fosu.common.page.TableDataInfo;
import edu.fosu.common.utils.StringUtils;
import edu.fosu.common.utils.poi.ExcelUtil;
import edu.fosu.framework.shiro.service.SysPasswordService;
import edu.fosu.framework.web.base.BaseController;
import edu.fosu.system.domain.SysUser;
import edu.fosu.system.service.ISysPostService;
import edu.fosu.system.service.ISysRoleService;
import edu.fosu.system.service.ISysUserService;

/**
 * 用户信息
 */
@Controller
@RequestMapping("/system/user")
public class SysUserController extends BaseController
{
    private String prefix = "system/user";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    @Autowired
    private ISysPostService postService;

    @Autowired
    private SysPasswordService passwordService;

    @RequiresPermissions("system:user:view")
    @GetMapping()
    public String user()
    {
        int userno = ShiroUtils.getUserId().intValue();
        String roleNo = userService.selectUserRoleGroup2(new Long((long)userno));
        if("5".equals(roleNo) || "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo) || "11".equals(roleNo)){
            return prefix + "/user1";
        }else{
            return prefix + "/user";
        }
    }

    @RequiresPermissions("system:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysUser user)
    {
        int userno = ShiroUtils.getUserId().intValue();
        String roleNo = userService.selectUserRoleGroup2(new Long((long)userno));
        if ("5".equals(roleNo)|| "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo) || "11".equals(roleNo)){
            Long deptId = ShiroUtils.getSysUser().getDeptId();
            user.setDeptId(deptId);
        }
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }

    /**
     * @param user
     * @return
     */
    @RequiresPermissions("system:user:list")
    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list1(SysUser user)
    {
        startPage();
        List<Map<String,Object>> list = userService.selectUserListByRole(user);
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @RequiresPermissions("system:user:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user)
    {
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @RequiresPermissions("system:user:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = getSysUser().getLoginName();
        String message = userService.importUser(userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    @RequiresPermissions("system:user:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.importTemplateExcel("用户数据");
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("roles", roleService.selectRoleAll());
        mmap.put("posts", postService.selectPostAll());
        return prefix + "/add";
    }

    /**
     * 新增保存用户
     */
    @RequiresPermissions("system:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(SysUser user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && SysUser.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        user.setCreateBy(ShiroUtils.getLoginName());
        //给用户添加默认图片
        user.setAvatar("http://whfosutech.oss-cn-hangzhou.aliyuncs.com/image/head/admin.jpg");
        //将用户信息添加到缓存
//        stringRedisTemplate.opsForValue().set("testuser", user.toString());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>打印缓存>>>>>>");
//        System.out.println(stringRedisTemplate.opsForValue().get("testuser"));
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>缓存打印完成>>>>>>");
        return toAjax(userService.insertUser(user));
    }

    /**
     * 修改用户
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        mmap.put("roles", roleService.selectRolesByUserId(userId));
        mmap.put("posts", postService.selectPostsByUserId(userId));
        return prefix + "/edit";
    }

    /**
     * 修改保存用户
     */
    @RequiresPermissions("system:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(SysUser user)
    {
        if (StringUtils.isNotNull(user.getUserId()) && SysUser.isAdmin(user.getUserId()))
        {
            return error("不允许修改超级管理员用户");
        }
        user.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(userService.updateUser(user));
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        mmap.put("user", userService.selectUserById(userId));
        return prefix + "/resetPwd";
    }

    @RequiresPermissions("system:user:resetPwd")
    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user)
    {
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getLoginName(), user.getPassword(), user.getSalt()));
        return toAjax(userService.resetUserPwd(user));
    }

    @RequiresPermissions("system:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user)
    {
        return userService.checkEmailUnique(user);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:user:edit")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysUser user)
    {
        return toAjax(userService.changeStatus(user));
    }

    /**
     * 选择list
     */
    @GetMapping("/selectList")
    public String selectList(SysUser user , ModelMap mmap)
    {
        user.setStatus("0");
        int userno = ShiroUtils.getUserId().intValue();
        String roleNo = userService.selectUserRoleGroup2(new Long((long)userno));
        if ("5".equals(roleNo)|| "6".equals(roleNo) || "7".equals(roleNo) || "8".equals(roleNo) || "11".equals(roleNo)){
            Long deptId = ShiroUtils.getSysUser().getDeptId();
            user.setDeptId(deptId);
        }
        List<SysUser> list = userService.selectUserList(user);
        mmap.put("user", list);
        return prefix + "/list";
    }

    /**
     * 选择list
     */
    @GetMapping("/selectList1")
    public String selectList1(SysUser user , ModelMap mmap)
    {
        user.setStatus("0");
        List<Map<String,Object>> list = userService.selectUserListByRole(user);
        mmap.put("user", list);
        return prefix + "/list1";
    }
}