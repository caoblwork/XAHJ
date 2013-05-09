/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : emes

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2013-05-09 08:14:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `case_info`
-- ----------------------------
DROP TABLE IF EXISTS `case_info`;
CREATE TABLE `case_info` (
  `id` varchar(40) NOT NULL,
  `simple_reason` varchar(120) default NULL COMMENT '案由',
  `case_id` varchar(40) NOT NULL COMMENT '案件编号',
  `party_name` varchar(40) default NULL COMMENT '污染源名称',
  `party_address` varchar(120) default NULL COMMENT '污染源地址',
  `party_legal_person` varchar(40) default NULL COMMENT '污染源法人',
  `party_duty` varchar(40) default NULL COMMENT '当事人职位',
  `party_phone` varchar(40) default NULL COMMENT '当事人联系电话',
  `party_postcode` varchar(12) default NULL COMMENT '当事人邮政编码',
  `pid` varchar(40) NOT NULL COMMENT '流程实例ID',
  `launcher_id` varchar(40) NOT NULL COMMENT '发起人ID',
  `deploy_id` varchar(40) NOT NULL COMMENT '部署ID',
  `status` varchar(1) default NULL COMMENT '状态',
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of case_info
-- ----------------------------
INSERT INTO `case_info` VALUES ('e6028339f04f409faeb056c9e1d47219', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '123', '0', 'caobl', '2013-05-06 16:32:08', 'caobl', '2013-05-06 16:32:08', '0');

-- ----------------------------
-- Table structure for `data_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `data_dictionary`;
CREATE TABLE `data_dictionary` (
  `id` varchar(40) NOT NULL,
  `version` int(11) NOT NULL,
  `data_type` varchar(20) default NULL,
  `data_key` varchar(100) default NULL,
  `data_value` varchar(100) default NULL,
  `create_date` datetime default NULL,
  `create_by` varchar(40) default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` datetime default NULL,
  `status` varchar(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dictionary
-- ----------------------------
INSERT INTO `data_dictionary` VALUES ('0aa2347b668a432bb4f60f3ea8721f25', '1', 'projectStatus', '2', '已取消', null, null, '#曹保利#', '2013-02-01 18:47:11', '0');
INSERT INTO `data_dictionary` VALUES ('0e512bd044744899a6f4e79d49126fe3', '1', 'projectStatus', '1', '已立项', null, null, '#曹保利#', '2013-02-01 18:46:55', '0');
INSERT INTO `data_dictionary` VALUES ('122562ca3acd47b2bd2eec4a4964e44c', '0', 'task_type', '2', '领导指派', '2013-04-22 04:21:56', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('185dc23941624056b0fb8af8c8654c7e', '0', '1', '1', '1', '2013-04-22 04:36:48', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('1e6111e436784c0083b38b2ab5b6257c', '0', 'projectDynamic', '1', '暂停中', '2013-01-29 18:37:37', '#曹保利#', '#曹保利#', '2013-01-29 18:37:37', '0');
INSERT INTO `data_dictionary` VALUES ('28a817087cd04885b7faa18a9fef8d75', '0', 'monitor_item', '2', '大气污染监测', '2013-04-22 04:28:38', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('381f9ccc757c4b8ab369092ef2369e44', '0', 'monitor_item', '4', '生物污染检测', '2013-04-22 04:30:46', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('3cf7606e22614addac97be7ae2f41b3c', '1', 'deploy_type', '1', '已部署(可用)', '2013-04-20 20:15:51', 'caobl', 'caobl', '2013-04-20 20:27:05', '0');
INSERT INTO `data_dictionary` VALUES ('4083759fa38c4f4e9f997184a2b428aa', '1', 'projectStatus', '4', '已结项', null, null, '#曹保利#', '2013-02-01 18:47:32', '0');
INSERT INTO `data_dictionary` VALUES ('5096b22901b1445c8b5b27ceeb290526', '0', 'stage', '1', '研发阶段', '2013-02-02 09:49:16', '#曹保利#', '#曹保利#', '2013-02-02 09:49:16', '0');
INSERT INTO `data_dictionary` VALUES ('6640211fd7c54935a59b12bff8aceebc', '0', 'monitor_item', '0', '水质污染监测', '2013-04-22 04:28:14', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('8d47e6840cdb4262bf9dc6d6c43c0678', '0', 'stage', '3', '正式运行', '2013-02-02 09:49:47', '#曹保利#', '#曹保利#', '2013-02-02 09:49:47', '0');
INSERT INTO `data_dictionary` VALUES ('94f9a3cf8a234739bbdd2d37d26772f9', '0', 'projectType', '0', '信息化', '2013-01-29 15:22:22', '#曹保利#', '#曹保利#', '2013-01-29 15:22:22', '0');
INSERT INTO `data_dictionary` VALUES ('9fc4acb8c75b409abaaf8318e7479084', '0', 'stage', '2', '试用阶段', '2013-02-02 09:49:31', '#曹保利#', '#曹保利#', '2013-02-02 09:49:31', '0');
INSERT INTO `data_dictionary` VALUES ('a4c99153775b41f787f6aaf78a1d7a64', '1', 'monitor_item', '5', '物理污染监测', '2013-04-22 04:31:12', 'caobl', 'caobl', '2013-04-22 04:36:39', '0');
INSERT INTO `data_dictionary` VALUES ('b0c442f9ca244978875399719bbc8d05', '0', 'projectType', '1', '一卡通', '2013-01-29 15:22:36', '#曹保利#', '#曹保利#', '2013-01-29 15:22:36', '0');
INSERT INTO `data_dictionary` VALUES ('b7e1dfa4b0464a4185410efce4293e19', '1', 'projectStatus', '0', '待立项', null, null, '#曹保利#', '2013-02-01 18:46:40', '0');
INSERT INTO `data_dictionary` VALUES ('bcf6a419154f4f4ba3e2a977821ca260', '0', 'sex', '0', '男', '2013-02-12 02:03:13', '#曹保利#', '#曹保利#', '2013-02-12 02:03:13', '0');
INSERT INTO `data_dictionary` VALUES ('c1d6ab5bd14b4d4683494b8ec44ac028', '0', 'task_type', '1', '常规任务', '2013-04-22 04:21:37', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('c9cca2cc775e47fd9186831e7c01b93a', '0', 'projectDynamic', '0', '稼动中', '2013-01-29 18:37:19', '#曹保利#', '#曹保利#', '2013-01-29 18:37:19', '0');
INSERT INTO `data_dictionary` VALUES ('d58afa11c3a9483c8dfb16427c9bae94', '0', 'task_type', '3', '其它任务', '2013-04-22 04:22:17', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('de33f6f0ee164bb295f8593c41b25f42', '1', 'deploy_type', '0', '未部署(不可用)', '2013-04-20 20:15:39', 'caobl', 'caobl', '2013-04-20 20:26:28', '0');
INSERT INTO `data_dictionary` VALUES ('dee6a2affc6842d49ec6d95a2946c44f', '0', 'value', 'null', '未知', '2013-04-01 00:55:16', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('e9d9a7b9a0d24235b92842e0910b2603', '0', 'monitor_item', '3', '生态检测', '2013-04-22 04:29:30', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('f1f034b3562f4780b565c89f1cadbdbe', '0', 'monitor_item', '1', '土壤和固体废弃物监测', '2013-04-22 04:29:05', 'caobl', null, null, '0');
INSERT INTO `data_dictionary` VALUES ('f9843bed54a346c8abb1a323def191f6', '0', 'stage', '0', '策划阶段', '2013-02-02 09:48:57', '#曹保利#', '#曹保利#', '2013-02-02 09:48:57', '0');
INSERT INTO `data_dictionary` VALUES ('fa20456213e24b6590506b0919b2b10b', '1', 'projectStatus', '3', '已验收', null, null, '#曹保利#', '2013-02-01 18:47:21', '0');
INSERT INTO `data_dictionary` VALUES ('fa39dce36cb74fc5a56b1a13ed0bddbe', '0', 'sex', '1', '女', '2013-02-12 02:03:24', '#曹保利#', '#曹保利#', '2013-02-12 02:03:24', '0');

-- ----------------------------
-- Table structure for `deploy_manager`
-- ----------------------------
DROP TABLE IF EXISTS `deploy_manager`;
CREATE TABLE `deploy_manager` (
  `id` varchar(40) NOT NULL,
  `version` int(11) default NULL,
  `cn_name` varchar(200) NOT NULL,
  `en_name` varchar(200) NOT NULL,
  `description` varchar(255) default NULL,
  `file_path` varchar(100) default NULL,
  `deploy_id` varchar(40) default NULL,
  `deploy_version` varchar(22) default '0',
  `create_date` timestamp NULL default NULL,
  `create_by` varchar(40) default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `status` varchar(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deploy_manager
-- ----------------------------
INSERT INTO `deploy_manager` VALUES ('b91986692e1646c7b9cce1c8f5f0b7a3', '0', '任务流程', 'task', null, '51ed20452a4249fd83668c85146554c6', '1', null, '2013-05-03 18:09:50', 'caobl', 'caobl', '2013-05-03 18:09:55', '1');

-- ----------------------------
-- Table structure for `link_man`
-- ----------------------------
DROP TABLE IF EXISTS `link_man`;
CREATE TABLE `link_man` (
  `id` varchar(40) NOT NULL,
  `link_man_group_id` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `qq_number` varchar(40) default NULL,
  `e_mail` varchar(40) default NULL,
  `cell_phone` varchar(40) default NULL,
  `tele_number` varchar(40) default NULL,
  `status` varchar(20) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link_man
-- ----------------------------
INSERT INTO `link_man` VALUES ('289b8509c9654639a97350670f0cfc12', 'f1b840e9807141218f2199446dd2d981', '某先生', '12121212', 'asd@wdd.com', '12345678901', '452232132', null, null, null, 'lijing', '2013-02-19 15:38:47', '1');
INSERT INTO `link_man` VALUES ('709cf6308a524c1d8a2ce91b64b246ea', '7e0e0bdad5e54f9586a00ad2a592f414', '张翠山', '123456789', 'zhangsanf@wud.com', '18723458765', '0000-9999123', null, 'zhangx', '2013-02-19 17:39:18', 'zhangx', '2013-02-19 17:39:18', '0');
INSERT INTO `link_man` VALUES ('bf2bdd5e916b4736a6361baaeed85747', '7e0e0bdad5e54f9586a00ad2a592f414', '王进喜', '1', 'zhangsf@wudang.com', '12345678901', null, null, null, null, '#曹保利#', '2013-02-18 18:02:43', '1');
INSERT INTO `link_man` VALUES ('ca9f5a7a6c36463bac34034fe323ab4c', '7e0e0bdad5e54f9586a00ad2a592f414', '王先生', '12121212', '22@112222.com', '45634563456', null, null, null, null, '#曹保利#', '2013-02-18 18:02:33', '1');
INSERT INTO `link_man` VALUES ('cc75d7847e304130aa1a8be7512cdd89', '7e0e0bdad5e54f9586a00ad2a592f414', '张三丰', '6566756756', 'zhangsanf@wud.com', '18723458765', '0000-9999123', null, null, null, 'lijing', '2013-02-19 16:13:51', '1');

-- ----------------------------
-- Table structure for `link_man_group`
-- ----------------------------
DROP TABLE IF EXISTS `link_man_group`;
CREATE TABLE `link_man_group` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) default NULL,
  `description` text,
  `parent_id` varchar(40) default NULL,
  `status` varchar(20) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link_man_group
-- ----------------------------
INSERT INTO `link_man_group` VALUES ('7e0e0bdad5e54f9586a00ad2a592f414', '客户侧负责人', null, '-1', null, null, null, '#曹保利#', '2013-02-04 14:41:49', '1');
INSERT INTO `link_man_group` VALUES ('f1b840e9807141218f2199446dd2d981', '运营商负责人', null, '-1', null, null, null, '#曹保利#', '2013-02-04 14:42:22', '1');

-- ----------------------------
-- Table structure for `model`
-- ----------------------------
DROP TABLE IF EXISTS `model`;
CREATE TABLE `model` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) default NULL,
  `description` varchar(255) default NULL,
  `code` varchar(20) default NULL,
  `status` varchar(20) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of model
-- ----------------------------
INSERT INTO `model` VALUES ('875ac46616de482da75fefa16822b40c', '系统管理', '系统管理', 'systemMgr', '0', '#曹保利#', '2013-02-17 15:34:49', '#曹保利#', '2013-02-17 15:34:49', '0');
INSERT INTO `model` VALUES ('e83560e3abe34ce7a6a59ae6c5b4633e', '业务管理', '业务管理', 'bizMgr', '0', '#曹保利#', '2013-02-17 15:35:20', '#曹保利#', '2013-02-17 15:35:20', '0');

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` varchar(40) NOT NULL,
  `name` varchar(40) default NULL,
  `parent_id` varchar(40) default NULL,
  `description` text,
  `status` varchar(20) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('47dd30d107b949bc936d0700310b838f', '执法科', null, '执法科', '0', 'caobl', '2013-04-20 20:43:56', null, null, '0');
INSERT INTO `organization` VALUES ('6adea6b6a0b84bd1a8930fa1556e992a', '陕西省环境保护厅', null, '陕西省环境保护厅', '0', 'caobl', '2013-04-20 20:39:02', 'caobl', '2013-04-20 20:43:04', '1');
INSERT INTO `organization` VALUES ('7a5e0216f1984b749b8f40119b79aa77', '陕西省环境保护执法局', null, '陕西省环境保护执法局', '0', 'caobl', '2013-04-20 20:43:39', null, null, '0');

-- ----------------------------
-- Table structure for `page_object_config`
-- ----------------------------
DROP TABLE IF EXISTS `page_object_config`;
CREATE TABLE `page_object_config` (
  `id` varchar(40) NOT NULL,
  `version` int(11) NOT NULL,
  `form_key` varchar(40) default NULL COMMENT '表单以及表单绑定对象的配置关系',
  `object_key` varchar(120) default NULL COMMENT '表单绑定的对象',
  `page_key` varchar(120) default NULL COMMENT '页面的路径',
  `create_date` datetime default NULL,
  `create_by` varchar(40) default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` datetime default NULL,
  `status` varchar(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程定义中的formkey配置项';

-- ----------------------------
-- Records of page_object_config
-- ----------------------------
INSERT INTO `page_object_config` VALUES ('bc89414824e948b882095cc418754fa5', '0', 'ref_case_info_approval', '', '', '2013-05-09 02:11:38', 'caobl', 'caobl', '2013-05-09 02:11:38', '0');
INSERT INTO `page_object_config` VALUES ('cb9ec20d74fc4642967287f1aba1a709', '3', 'ref_case_info_create', 'com.hangu.emes.vo.CaseInfoVo', 'caseInfo/create.jsp', '2013-05-08 23:38:54', 'caobl', 'caobl', '2013-05-09 02:07:52', '0');

-- ----------------------------
-- Table structure for `psbaseinfo`
-- ----------------------------
DROP TABLE IF EXISTS `psbaseinfo`;
CREATE TABLE `psbaseinfo` (
  `id` varchar(255) NOT NULL default '',
  `ps_code` varchar(255) default '',
  `ps_name` varchar(255) default NULL,
  `region_code` varchar(255) default NULL,
  `region_name` varchar(255) default NULL,
  `ps_type` varchar(255) default NULL,
  `monitorLevel` varchar(255) default NULL,
  `ps_address` varchar(255) default NULL,
  `longitude` varchar(255) default NULL,
  `latitude` varchar(255) default NULL,
  `corporation` varchar(255) default NULL,
  `linkman` varchar(255) default NULL,
  `tel` varchar(255) default NULL,
  `fax` varchar(255) default NULL,
  `monitorType` varchar(255) default NULL,
  `isOnlineEnter` varchar(255) default NULL,
  `isVideoEnter` varchar(255) default NULL,
  `status` varchar(2) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of psbaseinfo
-- ----------------------------
INSERT INTO `psbaseinfo` VALUES ('0168a3ffbcb5414d8a9c9647b18fb281', '710070201304', '陕西省化工原料有限责任公司', null, '西安市', '国控', '', '西安市南二环心思路2号', null, null, '杨勇', '李新', '13546578765', null, '气体', '是', null, '0', 'caobl', '2013-04-21 16:38:45', null, '2013-04-22 07:18:31', '0');
INSERT INTO `psbaseinfo` VALUES ('aaa027ea03b44b9c8e3a23fb869483e3', '557', '西安武功气化有限公司', null, 'v兄', '国控', '', 'v以', null, null, '管用', '和另一个', '76767607776', null, '以', 'v以', null, '0', 'caobl', '2013-04-21 16:53:06', null, '2013-04-22 07:18:34', '0');
INSERT INTO `psbaseinfo` VALUES ('afb83f4b789d40d5abd13e148a43fa3a', '465', '陕西见覅欧有限公司', null, '西安市', '市控', '', '高新区', null, null, '恢复', '467577', '46754', null, 'v福德宫', '热议', null, '0', 'caobl', '2013-04-21 17:03:22', null, '2013-04-22 07:18:25', '0');

-- ----------------------------
-- Table structure for `resource`
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) default NULL,
  `type` varchar(40) default NULL,
  `status` varchar(20) default NULL,
  `address` varchar(120) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('20130306101', '角色列表', '123', '1', 'system/role/list.do', null, null, 'caobl', '2013-03-28 05:53:22', '1');
INSERT INTO `resource` VALUES ('20130306102', '角色添加', null, '2', 'system/role/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306103', '角色列表', null, '3', 'system/role/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306104', '角色详情', null, '4', 'system/role/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306105', '角色删除', null, '5', 'system/role/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306201', '资源列表', null, '1', 'system/resource/list.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306202', '资源添加', null, '2', 'system/resource/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306203', '资源列表', null, '3', 'system/resource/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306204', '资源详情', null, '4', 'system/resource/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306205', '资源删除', null, '5', 'system/resource/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306301', '模块列表', null, '1', 'system/model/list.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306302', '模块添加', null, '2', 'system/model/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306303', '模块列表', null, '3', 'system/model/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306304', '模块详情', null, '4', 'system/model/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306305', '模块删除', null, '5', 'system/model/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306401', '用户列表', null, '1', 'system/user/list.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306402', '用户添加', null, '2', 'system/user/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306403', '用户列表', null, '3', 'system/user/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306404', '用户详情', null, '4', 'system/user/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306405', '用户删除', null, '5', 'system/user/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306501', '组织机构列表', null, '1', 'system/organization/list.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306502', '组织机构添加', null, '2', 'system/organization/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306503', '组织机构列表', null, '3', 'system/organization/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306504', '组织机构详情', null, '4', 'system/organization/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306505', '组织机构删除', null, '5', 'system/organization/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306601', '数据字典列表', null, '1', 'system/dataDictionary/list.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306602', '数据字典添加', null, '2', 'system/dataDictionary/add.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306603', '数据字典列表', null, '3', 'system/dataDictionary/edit.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306604', '数据字典详情', null, '4', 'system/dataDictionary/show.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('20130306605', '数据字典删除', null, '5', 'system/dataDictionary/remove.do', null, null, null, null, null);
INSERT INTO `resource` VALUES ('47ecfdd93daa4a2cb5ad48ebf6e8e611', 'list', 'list', '0', 'workflow/deployManager/list.do', 'caobl', '2013-04-03 16:48:44', 'caobl', '2013-04-03 16:48:44', '0');
INSERT INTO `resource` VALUES ('x01', 'cbl001', 'cbl', '0', 'workflow/deployManager/saveDeployInfo.do', null, null, 'caobl', '2013-04-03 16:48:06', '1');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(40) NOT NULL,
  `code` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `description` varchar(480) default NULL,
  `status` varchar(20) default NULL,
  `version` int(1) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('108d33cb071b4247a00ea5e219bc0339', 'Enforcer', '执法者', null, '0', '1', null, null, 'caobl', '2013-05-03 17:44:38');
INSERT INTO `role` VALUES ('3f670b51d8f449e4853f6500a83c4524', 'SYSTEM', '系统管理员', '默认的角色', '0', '1', null, null, 'caobl', '2013-03-28 05:52:35');
INSERT INTO `role` VALUES ('964b8239c6c64ce58b5514d6cdc70fff', 'InspectionOfficeLeader', '局领导', null, '0', '1', null, null, 'caobl', '2013-05-03 17:42:29');
INSERT INTO `role` VALUES ('99effa6287734fd39f96621cdc1e4b22', 'Office', '办公室', null, '0', '1', null, null, 'caobl', '2013-03-25 10:07:37');
INSERT INTO `role` VALUES ('f6497db42b6042a3b6d35da364b2dba7', 'SquadsLeader', '检查支队领导', null, '0', '0', 'caobl', '2013-04-20 20:55:43', 'caobl', '2013-04-20 20:55:43');

-- ----------------------------
-- Table structure for `r_model_resource`
-- ----------------------------
DROP TABLE IF EXISTS `r_model_resource`;
CREATE TABLE `r_model_resource` (
  `id` varchar(40) NOT NULL,
  `model_id` varchar(40) default NULL,
  `resource_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_model_id` (`model_id`),
  KEY `fk_resource_id` (`resource_id`),
  CONSTRAINT `r_model_id` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`),
  CONSTRAINT `r_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_model_resource
-- ----------------------------
INSERT INTO `r_model_resource` VALUES ('20130306x0101', '875ac46616de482da75fefa16822b40c', '20130306101');
INSERT INTO `r_model_resource` VALUES ('20130306x0102', '875ac46616de482da75fefa16822b40c', '20130306102');
INSERT INTO `r_model_resource` VALUES ('20130306x0103', '875ac46616de482da75fefa16822b40c', '20130306103');
INSERT INTO `r_model_resource` VALUES ('20130306x0104', '875ac46616de482da75fefa16822b40c', '20130306104');
INSERT INTO `r_model_resource` VALUES ('20130306x0105', '875ac46616de482da75fefa16822b40c', '20130306105');
INSERT INTO `r_model_resource` VALUES ('20130306x0201', '875ac46616de482da75fefa16822b40c', '20130306201');
INSERT INTO `r_model_resource` VALUES ('20130306x0202', '875ac46616de482da75fefa16822b40c', '20130306202');
INSERT INTO `r_model_resource` VALUES ('20130306x0203', '875ac46616de482da75fefa16822b40c', '20130306203');
INSERT INTO `r_model_resource` VALUES ('20130306x0204', '875ac46616de482da75fefa16822b40c', '20130306204');
INSERT INTO `r_model_resource` VALUES ('20130306x0205', '875ac46616de482da75fefa16822b40c', '20130306205');
INSERT INTO `r_model_resource` VALUES ('20130306x0301', '875ac46616de482da75fefa16822b40c', '20130306301');
INSERT INTO `r_model_resource` VALUES ('20130306x0302', '875ac46616de482da75fefa16822b40c', '20130306302');
INSERT INTO `r_model_resource` VALUES ('20130306x0303', '875ac46616de482da75fefa16822b40c', '20130306303');
INSERT INTO `r_model_resource` VALUES ('20130306x0304', '875ac46616de482da75fefa16822b40c', '20130306304');
INSERT INTO `r_model_resource` VALUES ('20130306x0305', '875ac46616de482da75fefa16822b40c', '20130306305');
INSERT INTO `r_model_resource` VALUES ('20130306x0401', '875ac46616de482da75fefa16822b40c', '20130306401');
INSERT INTO `r_model_resource` VALUES ('20130306x0402', '875ac46616de482da75fefa16822b40c', '20130306402');
INSERT INTO `r_model_resource` VALUES ('20130306x0403', '875ac46616de482da75fefa16822b40c', '20130306403');
INSERT INTO `r_model_resource` VALUES ('20130306x0404', '875ac46616de482da75fefa16822b40c', '20130306404');
INSERT INTO `r_model_resource` VALUES ('20130306x0405', '875ac46616de482da75fefa16822b40c', '20130306405');
INSERT INTO `r_model_resource` VALUES ('20130306x0501', '875ac46616de482da75fefa16822b40c', '20130306501');
INSERT INTO `r_model_resource` VALUES ('20130306x0502', '875ac46616de482da75fefa16822b40c', '20130306502');
INSERT INTO `r_model_resource` VALUES ('20130306x0503', '875ac46616de482da75fefa16822b40c', '20130306503');
INSERT INTO `r_model_resource` VALUES ('20130306x0504', '875ac46616de482da75fefa16822b40c', '20130306504');
INSERT INTO `r_model_resource` VALUES ('20130306x0505', '875ac46616de482da75fefa16822b40c', '20130306505');
INSERT INTO `r_model_resource` VALUES ('20130306x0601', '875ac46616de482da75fefa16822b40c', '20130306601');
INSERT INTO `r_model_resource` VALUES ('20130306x0602', '875ac46616de482da75fefa16822b40c', '20130306602');
INSERT INTO `r_model_resource` VALUES ('20130306x0603', '875ac46616de482da75fefa16822b40c', '20130306603');
INSERT INTO `r_model_resource` VALUES ('20130306x0604', '875ac46616de482da75fefa16822b40c', '20130306604');
INSERT INTO `r_model_resource` VALUES ('20130306x0605', '875ac46616de482da75fefa16822b40c', '20130306605');
INSERT INTO `r_model_resource` VALUES ('cbl-auto-001', 'e83560e3abe34ce7a6a59ae6c5b4633e', 'x01');

-- ----------------------------
-- Table structure for `r_role_model`
-- ----------------------------
DROP TABLE IF EXISTS `r_role_model`;
CREATE TABLE `r_role_model` (
  `id` varchar(40) NOT NULL,
  `role_id` varchar(40) default NULL,
  `model_id` varchar(40) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_model_id` (`model_id`),
  KEY `fk_role_id` (`role_id`),
  CONSTRAINT `model_id` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`),
  CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_role_model
-- ----------------------------
INSERT INTO `r_role_model` VALUES ('5f3ce9bf-ca31-1030-a6b0-b48580f13740', '3f670b51d8f449e4853f6500a83c4524', '875ac46616de482da75fefa16822b40c');
INSERT INTO `r_role_model` VALUES ('5f491775-ca31-1030-a6b0-b48580f13740', '3f670b51d8f449e4853f6500a83c4524', 'e83560e3abe34ce7a6a59ae6c5b4633e');

-- ----------------------------
-- Table structure for `r_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `r_user_role`;
CREATE TABLE `r_user_role` (
  `id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  `role_id` varchar(40) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `index_user_id` (`user_id`),
  KEY `index_role_id` (`role_id`),
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of r_user_role
-- ----------------------------
INSERT INTO `r_user_role` VALUES ('37dcabbb-c957-1030-ae96-d00190d26ead', '4c64c01f3eb24e08b474c5b3305099d9', '3f670b51d8f449e4853f6500a83c4524');

-- ----------------------------
-- Table structure for `supervisory_task`
-- ----------------------------
DROP TABLE IF EXISTS `supervisory_task`;
CREATE TABLE `supervisory_task` (
  `id` varchar(40) NOT NULL,
  `name` varchar(20) default NULL COMMENT '名称',
  `type` varchar(40) default NULL COMMENT '案件类型',
  `pollutant_source_id` varchar(40) default NULL COMMENT '污染源ID',
  `monitor_item` varchar(40) default NULL COMMENT '监察项目',
  `progress` varchar(40) default NULL COMMENT '任务进度',
  `creator` varchar(40) default NULL COMMENT '创建人',
  `executor` varchar(1024) default NULL COMMENT '执法人',
  `status` varchar(20) default NULL COMMENT '状态',
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supervisory_task
-- ----------------------------
INSERT INTO `supervisory_task` VALUES ('9fc93bac1f434c61bdba2857aa128ea4', '123', '3', '123', '123', '123', '4c64c01f3eb24e08b474c5b3305099d9', '', '0', 'caobl', '2013-05-03 18:16:08', 'caobl', '2013-05-03 18:16:08', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `login_id` varchar(40) default NULL,
  `password` text,
  `name` varchar(40) default NULL,
  `sex` varchar(20) default NULL,
  `phone` varchar(20) default NULL,
  `mobile_number` varchar(11) default NULL,
  `organization_id` varchar(40) default NULL,
  `status` varchar(2) default NULL,
  `create_by` varchar(40) default NULL,
  `create_date` timestamp NULL default NULL,
  `update_by` varchar(40) default NULL,
  `update_date` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `version` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3cdee7badc7b4613b5e03229546256e8', 'xiny', '123456', '辛阳', '0', '15691839812', '15691839812', 'c6e301473fe941209de1bd67f2cd65e9', '0', '#曹保利#', '2013-02-12 12:26:34', '#曹保利#', '2013-02-18 13:24:13', '0');
INSERT INTO `user` VALUES ('4c64c01f3eb24e08b474c5b3305099d9', 'caobl', '123456', '曹保利', '1', '15691839812', '15691839812', 'c6e301473fe941209de1bd67f2cd65e9', '0', '#曹保利#', '2013-02-12 01:58:36', '#曹保利#', '2013-02-12 12:24:50', '1');
INSERT INTO `user` VALUES ('73e241372e7f40fcbcd23927fec4cdb5', 'shiym', '123456', '史优美', '1', '0000-0000000', '15691839812', '7f746e799b3b455ebf78a728088c5f96', '0', '#曹保利#', '2013-02-12 12:31:43', '#曹保利#', '2013-02-20 10:16:06', '1');
INSERT INTO `user` VALUES ('7870e63aaa1a4709a3dc31f4b8cd05a9', 'zhangx', '123456', '张鑫', '0', '15691839812', '15691839812', '9640eed98dd1435db96170085fa4c71f', '0', '#曹保利#', '2013-02-12 12:34:11', '#曹保利#', '2013-02-12 12:34:11', '0');
INSERT INTO `user` VALUES ('bff608df4d5a4c3688dbacb40289cdb6', 'dongwy', '123', '董文烨', '0', null, null, 'c6e301473fe941209de1bd67f2cd65e9', '0', 'zhangx', '2013-02-22 18:25:37', null, '2013-03-28 05:52:55', '1');
INSERT INTO `user` VALUES ('d036cf02126f4af28d1df332fd731c80', 'maojh', '123456', '毛建华', '0', '15691839812', '15691839812', '9c2a2e63b0d04c98a51657f3d0ee2e5c', '0', '#曹保利#', '2013-02-12 12:32:21', '#曹保利#', '2013-02-12 12:32:21', '0');
INSERT INTO `user` VALUES ('ea98945234a1461895fda101197ff42c', 'xuh', '123456', '徐浩', '0', '15691839812', '15691839812', 'c6e301473fe941209de1bd67f2cd65e9', '0', '#曹保利#', '2013-02-12 12:33:17', '#曹保利#', '2013-02-12 12:33:17', '0');

-- ----------------------------
-- Table structure for `wrydaxx`
-- ----------------------------
DROP TABLE IF EXISTS `wrydaxx`;
CREATE TABLE `wrydaxx` (
  `id` varchar(40) NOT NULL default '',
  `wrybh` varchar(40) default NULL,
  `dabh` varchar(40) default NULL,
  `dalx` varchar(40) default NULL,
  `sfyx` varchar(500) default NULL,
  `damc` varchar(500) default NULL,
  `wjmc` varchar(500) default NULL,
  `wjhz` varchar(40) default NULL,
  `cflj` varchar(500) default NULL,
  `bz` varchar(400) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='污染源档案信息';

-- ----------------------------
-- Records of wrydaxx
-- ----------------------------
INSERT INTO `wrydaxx` VALUES ('6621355b088144ca8e7ec117221859d9', '习惯法撒', '3256436', '文件', '有', '凡人歌', '非惹我', 'txt', 'D:/huanjian', '哥哥各付各的');

-- ----------------------------
-- Table structure for `wryjbxx`
-- ----------------------------
DROP TABLE IF EXISTS `wryjbxx`;
CREATE TABLE `wryjbxx` (
  `id` varchar(40) NOT NULL,
  `wrybh` varchar(40) default NULL COMMENT '污染源编号',
  `wrymc` varchar(100) default NULL COMMENT '污染源名称',
  `wryjc` varchar(40) default NULL COMMENT '简称',
  `czhm` varchar(40) default NULL COMMENT '传真号码',
  `lxdh` varchar(30) default NULL COMMENT '联系电话',
  `zzjgdm` varchar(100) default NULL COMMENT '组织机构',
  `sssf` varchar(40) default NULL COMMENT '所属省份',
  `ssds` varchar(40) default NULL COMMENT '所属地市',
  `ssqx` varchar(40) default NULL COMMENT '所属区县',
  `ssjd` varchar(40) default NULL COMMENT '所属街道',
  `wgdm` varchar(40) default NULL COMMENT '网格代码',
  `gxgs` varchar(40) default NULL COMMENT '管辖归属',
  `dwlx` varchar(20) default NULL COMMENT '单位类型',
  `dwdz` varchar(100) default NULL COMMENT '单位地址',
  `yzbm` varchar(40) default NULL COMMENT '邮政编码',
  `frdb` varchar(40) default NULL COMMENT '法人代表',
  `wz` varchar(100) default NULL COMMENT '网址',
  `dzyx` varchar(40) default NULL COMMENT '电子邮箱',
  `lsgx` varchar(40) default NULL COMMENT '隶属关系',
  `jjlx` varchar(40) default NULL COMMENT '经济类型',
  `hydm` varchar(40) default NULL COMMENT '行业代码',
  `qygm` varchar(40) default NULL COMMENT '企业规模',
  `ztz` bigint(20) default NULL COMMENT '总投资',
  `hbtz` bigint(20) default NULL COMMENT '环保投资',
  `hblxr` varchar(40) default NULL COMMENT '环保联系人',
  `hblxrlxdz` varchar(40) default NULL COMMENT '联系人地址',
  `jdd` int(11) default NULL COMMENT '经度（度）',
  `jdf` int(11) default NULL COMMENT '经度（分）',
  `jdm` int(11) default NULL COMMENT '经度（秒）',
  `wdd` int(11) default NULL COMMENT '纬度（度）',
  `wdf` int(11) default NULL COMMENT '纬度（分）',
  `wdm` int(11) default NULL COMMENT '纬度（秒）',
  `szgyymc` varchar(40) default NULL COMMENT '工业园名称',
  `pwxkzbh` varchar(40) default NULL COMMENT '排污许可证编号',
  `wryjs` varchar(500) default NULL COMMENT '污染源介绍',
  `bz` varchar(200) default NULL COMMENT '备注',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='污染源基本信息';

-- ----------------------------
-- Records of wryjbxx
-- ----------------------------
INSERT INTO `wryjbxx` VALUES ('f20be4bec1d746fb986a7c78a2387684', 'shanx2013', '陕西鑫源地产有限公司', '鑫源', '587909909009', '13534567896', '甘肃省西安市环境管理所', '陕西省', '西安市', '个人为', '凤城二路', '423664362', '省管', '国企', '南二环3号一层', '710070', '张强', 'www.xinyuan.com', '577666@163.com', '苏醒', '国营', '256766476573', '大于100人', '3526426574', '6437', '王强', '大雁塔西北角', '34', '54325', '543', '5432', '54', '54', '长城数码', '34267755', '地产商', '跟接口收割机');
