package com.family.wqq.controller;

import com.alibaba.fastjson.JSON;
import com.family.wqq.common.rsp.Result;
import com.family.wqq.common.rsp.ResultCode;
import com.family.wqq.dto.LoginDTO;
import com.family.wqq.vo.sys.LoginVO;
import com.family.wqq.vo.sys.SysUserInfoVO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author hudongping@xdf.cn
 * @Date 2021/3/29 15:18
 * @Version 1.0
 **/
@RestController
public class LoginController {
    @PostMapping("/api/login")
    public Result<LoginVO> login(@RequestBody LoginDTO dto){
        if(dto.getUsername().equals("admin") && dto.getPassword().equals("123456")){
            LoginVO vo = new LoginVO();
            vo.setToken("4291d7da9005377ec9aec4a71ea837f");
            return new Result<>(ResultCode.SUCCESS,vo);
        }
        return Result.FAIL();
    }
    @GetMapping("/api/user/info")
    public Result<SysUserInfoVO> getUserInfo(){
        SysUserInfoVO vo = new SysUserInfoVO();
        vo.setId(1L);
        vo.setName("stramt");
        vo.setUsername("admin");
        vo.setPassword("");
        vo.setAvatar("https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png");
        vo.setStatus((short)1);
        vo.setTelephone("");
        vo.setLastLoginIp("27.154.74.117");
        vo.setCreatorId("admin");
        vo.setLastLoginTime(new Date());
        vo.setCreateTime(new Date());
        vo.setDeleted(0);
        vo.setRoleId("admin");
        vo.setLang("zh-CN");
        vo.setToken("4291d7da9005377ec9aec4a71ea837f");
        String role ="{\n" +
                "    'id': 'admin',\n" +
                "    'name': '管理员',\n" +
                "    'describe': '拥有所有权限',\n" +
                "    'status': 1,\n" +
                "    'creatorId': 'system',\n" +
                "    'createTime': 1497160610259,\n" +
                "    'deleted': 0,\n" +
                "    'permissions': [{\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'dashboard',\n" +
                "      'permissionName': '仪表盘',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'exception',\n" +
                "      'permissionName': '异常页面权限',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'result',\n" +
                "      'permissionName': '结果权限',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'profile',\n" +
                "      'permissionName': '详细页权限',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'table',\n" +
                "      'permissionName': '表格权限',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'import',\n" +
                "        'describe': '导入',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'form',\n" +
                "      'permissionName': '表单权限',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'order',\n" +
                "      'permissionName': '订单管理',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'permission',\n" +
                "      'permissionName': '权限管理',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'role',\n" +
                "      'permissionName': '角色管理',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'table',\n" +
                "      'permissionName': '桌子管理',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'query',\n" +
                "        'describe': '查询',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }, {\n" +
                "      'roleId': 'admin',\n" +
                "      'permissionId': 'user',\n" +
                "      'permissionName': '用户管理',\n" +
                "      'actions': '[{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"},{\"action\":\"export\",\"defaultCheck\":false,\"describe\":\"导出\"}]',\n" +
                "      'actionEntitySet': [{\n" +
                "        'action': 'add',\n" +
                "        'describe': '新增',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'import',\n" +
                "        'describe': '导入',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'get',\n" +
                "        'describe': '详情',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'update',\n" +
                "        'describe': '修改',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'delete',\n" +
                "        'describe': '删除',\n" +
                "        'defaultCheck': false\n" +
                "      }, {\n" +
                "        'action': 'export',\n" +
                "        'describe': '导出',\n" +
                "        'defaultCheck': false\n" +
                "      }],\n" +
                "      'actionList': null,\n" +
                "      'dataAccess': null\n" +
                "    }]\n" +
                "  }";
        Map roleMap = JSON.parseObject(role, Map.class);
        vo.setRole(roleMap);
        return new Result<>(ResultCode.SUCCESS,vo);
    }
    @GetMapping("/api/user/nav")
    public Result getUserMenu(){
        String menuJSON= "[\n" +
                "    // dashboard\n" +
                "    {\n" +
                "      'name': 'dashboard',\n" +
                "      'parentId': 0,\n" +
                "      'id': 1,\n" +
                "      'meta': {\n" +
                "        'icon': 'dashboard',\n" +
                "        'title': '仪表盘',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'RouteView',\n" +
                "      'redirect': '/dashboard/workplace'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'workplace',\n" +
                "      'parentId': 1,\n" +
                "      'id': 7,\n" +
                "      'meta': {\n" +
                "        'title': '工作台',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'Workplace'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'monitor',\n" +
                "      'path': 'https://www.baidu.com/',\n" +
                "      'parentId': 1,\n" +
                "      'id': 3,\n" +
                "      'meta': {\n" +
                "        'title': '监控页（外部）',\n" +
                "        'target': '_blank',\n" +
                "        'show': true\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'Analysis',\n" +
                "      'parentId': 1,\n" +
                "      'id': 2,\n" +
                "      'meta': {\n" +
                "        'title': '分析页',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'Analysis',\n" +
                "      'path': '/dashboard/analysis'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'tests',\n" +
                "      'parentId': 1,\n" +
                "      'id': 8,\n" +
                "      'meta': {\n" +
                "        'title': '测试功能',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'TestWork'\n" +
                "    },\n" +
                "\n" +
                "    // form\n" +
                "    {\n" +
                "      'name': 'form',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10,\n" +
                "      'meta': {\n" +
                "        'icon': 'form',\n" +
                "        'title': '表单页'\n" +
                "      },\n" +
                "      'redirect': '/form/base-form',\n" +
                "      'component': 'PageView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'basic-form',\n" +
                "      'parentId': 10,\n" +
                "      'id': 6,\n" +
                "      'meta': {\n" +
                "        'title': '基础表单'\n" +
                "      },\n" +
                "      'component': 'BasicForm'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'step-form',\n" +
                "      'parentId': 10,\n" +
                "      'id': 5,\n" +
                "      'meta': {\n" +
                "        'title': '分步表单'\n" +
                "      },\n" +
                "      'component': 'StepForm'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'advanced-form',\n" +
                "      'parentId': 10,\n" +
                "      'id': 4,\n" +
                "      'meta': {\n" +
                "        'title': '高级表单'\n" +
                "      },\n" +
                "      'component': 'AdvanceForm'\n" +
                "    },\n" +
                "\n" +
                "    // list\n" +
                "    {\n" +
                "      'name': 'list',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10010,\n" +
                "      'meta': {\n" +
                "        'icon': 'table',\n" +
                "        'title': '列表页',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/list/table-list',\n" +
                "      'component': 'PageView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'table-list',\n" +
                "      'parentId': 10010,\n" +
                "      'id': 10011,\n" +
                "      'path': '/list/table-list/:pageNo([1-9]\\\\d*)?',\n" +
                "      'meta': {\n" +
                "        'title': '查询表格',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'TableList'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'basic-list',\n" +
                "      'parentId': 10010,\n" +
                "      'id': 10012,\n" +
                "      'meta': {\n" +
                "        'title': '标准列表',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'StandardList'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'card',\n" +
                "      'parentId': 10010,\n" +
                "      'id': 10013,\n" +
                "      'meta': {\n" +
                "        'title': '卡片列表',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'CardList'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'search',\n" +
                "      'parentId': 10010,\n" +
                "      'id': 10014,\n" +
                "      'meta': {\n" +
                "        'title': '搜索列表',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/list/search/article',\n" +
                "      'component': 'SearchLayout'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'article',\n" +
                "      'parentId': 10014,\n" +
                "      'id': 10015,\n" +
                "      'meta': {\n" +
                "        'title': '搜索列表（文章）',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'SearchArticles'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'project',\n" +
                "      'parentId': 10014,\n" +
                "      'id': 10016,\n" +
                "      'meta': {\n" +
                "        'title': '搜索列表（项目）',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'SearchProjects'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'application',\n" +
                "      'parentId': 10014,\n" +
                "      'id': 10017,\n" +
                "      'meta': {\n" +
                "        'title': '搜索列表（应用）',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'SearchApplications'\n" +
                "    },\n" +
                "\n" +
                "    // profile\n" +
                "    {\n" +
                "      'name': 'profile',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10018,\n" +
                "      'meta': {\n" +
                "        'title': '详情页',\n" +
                "        'icon': 'profile',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/profile/basic',\n" +
                "      'component': 'RouteView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'basic',\n" +
                "      'parentId': 10018,\n" +
                "      'id': 10019,\n" +
                "      'meta': {\n" +
                "        'title': '基础详情页',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'ProfileBasic'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'advanced',\n" +
                "      'parentId': 10018,\n" +
                "      'id': 10020,\n" +
                "      'meta': {\n" +
                "        'title': '高级详情页',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'ProfileAdvanced'\n" +
                "    },\n" +
                "\n" +
                "    // result\n" +
                "    {\n" +
                "      'name': 'result',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10021,\n" +
                "      'meta': {\n" +
                "        'title': '结果页',\n" +
                "        'icon': 'check-circle-o',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/result/success',\n" +
                "      'component': 'PageView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'success',\n" +
                "      'parentId': 10021,\n" +
                "      'id': 10022,\n" +
                "      'meta': {\n" +
                "        'title': '成功',\n" +
                "        'hiddenHeaderContent': true,\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'ResultSuccess'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'fail',\n" +
                "      'parentId': 10021,\n" +
                "      'id': 10023,\n" +
                "      'meta': {\n" +
                "        'title': '失败',\n" +
                "        'hiddenHeaderContent': true,\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'ResultFail'\n" +
                "    },\n" +
                "\n" +
                "    // Exception\n" +
                "    {\n" +
                "      'name': 'exception',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10024,\n" +
                "      'meta': {\n" +
                "        'title': '异常页',\n" +
                "        'icon': 'warning',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/exception/403',\n" +
                "      'component': 'RouteView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': '403',\n" +
                "      'parentId': 10024,\n" +
                "      'id': 10025,\n" +
                "      'meta': {\n" +
                "        'title': '403',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'Exception403'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': '404',\n" +
                "      'parentId': 10024,\n" +
                "      'id': 10026,\n" +
                "      'meta': {\n" +
                "        'title': '404',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'Exception404'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': '500',\n" +
                "      'parentId': 10024,\n" +
                "      'id': 10027,\n" +
                "      'meta': {\n" +
                "        'title': '500',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'Exception500'\n" +
                "    },\n" +
                "\n" +
                "    // account\n" +
                "    {\n" +
                "      'name': 'account',\n" +
                "      'parentId': 0,\n" +
                "      'id': 10028,\n" +
                "      'meta': {\n" +
                "        'title': '个人页',\n" +
                "        'icon': 'user',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/account/center',\n" +
                "      'component': 'RouteView'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'center',\n" +
                "      'parentId': 10028,\n" +
                "      'id': 10029,\n" +
                "      'meta': {\n" +
                "        'title': '个人中心',\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'component': 'AccountCenter'\n" +
                "    },\n" +
                "    // 特殊三级菜单\n" +
                "    {\n" +
                "      'name': 'settings',\n" +
                "      'parentId': 10028,\n" +
                "      'id': 10030,\n" +
                "      'meta': {\n" +
                "        'title': '个人设置',\n" +
                "        'hideHeader': true,\n" +
                "        'hideChildren': true,\n" +
                "        'show': true\n" +
                "      },\n" +
                "      'redirect': '/account/settings/base',\n" +
                "      'component': 'AccountSettings'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'BaseSettings',\n" +
                "      'path': '/account/settings/base',\n" +
                "      'parentId': 10030,\n" +
                "      'id': 10031,\n" +
                "      'meta': {\n" +
                "        'title': '基本设置',\n" +
                "        'show': false\n" +
                "      },\n" +
                "      'component': 'BaseSettings'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'SecuritySettings',\n" +
                "      'path': '/account/settings/security',\n" +
                "      'parentId': 10030,\n" +
                "      'id': 10032,\n" +
                "      'meta': {\n" +
                "        'title': '安全设置',\n" +
                "        'show': false\n" +
                "      },\n" +
                "      'component': 'SecuritySettings'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'CustomSettings',\n" +
                "      'path': '/account/settings/custom',\n" +
                "      'parentId': 10030,\n" +
                "      'id': 10033,\n" +
                "      'meta': {\n" +
                "        'title': '个性化设置',\n" +
                "        'show': false\n" +
                "      },\n" +
                "      'component': 'CustomSettings'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'BindingSettings',\n" +
                "      'path': '/account/settings/binding',\n" +
                "      'parentId': 10030,\n" +
                "      'id': 10034,\n" +
                "      'meta': {\n" +
                "        'title': '账户绑定',\n" +
                "        'show': false\n" +
                "      },\n" +
                "      'component': 'BindingSettings'\n" +
                "    },\n" +
                "    {\n" +
                "      'name': 'NotificationSettings',\n" +
                "      'path': '/account/settings/notification',\n" +
                "      'parentId': 10030,\n" +
                "      'id': 10034,\n" +
                "      'meta': {\n" +
                "        'title': '新消息通知',\n" +
                "        'show': false\n" +
                "      },\n" +
                "      'component': 'NotificationSettings'\n" +
                "    }\n" +
                "  ]";
        List<Map> maps = JSON.parseArray(menuJSON, Map.class);
        return new Result(ResultCode.SUCCESS,maps);
    }
}
