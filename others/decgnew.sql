/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50130
Source Host           : localhost:3306
Source Database       : decgnew

Target Server Type    : MYSQL
Target Server Version : 50130
File Encoding         : 65001

Date: 2011-06-27 17:35:34
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `applicationform`
-- ----------------------------
DROP TABLE IF EXISTS `applicationform`;
CREATE TABLE `applicationform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `assure_due_time` int(11) DEFAULT NULL,
  `assure_money` double DEFAULT NULL,
  `assure_type` varchar(50) DEFAULT NULL,
  `assure_type1` varchar(50) DEFAULT NULL,
  `assure_type2` varchar(50) DEFAULT NULL,
  `assure_type3` varchar(50) DEFAULT NULL,
  `assure_type4` varchar(50) DEFAULT NULL,
  `assured_due_time1` int(11) DEFAULT NULL,
  `assured_due_time2` int(11) DEFAULT NULL,
  `assured_due_time3` int(11) DEFAULT NULL,
  `assured_due_time4` int(11) DEFAULT NULL,
  `assured_mature_date1` varchar(255) DEFAULT NULL,
  `assured_mature_date2` varchar(255) DEFAULT NULL,
  `assured_mature_date3` varchar(255) DEFAULT NULL,
  `assured_mature_date4` varchar(255) DEFAULT NULL,
  `assured_money1` double DEFAULT NULL,
  `assured_money2` double DEFAULT NULL,
  `assured_money3` double DEFAULT NULL,
  `assured_money4` double DEFAULT NULL,
  `assured_refund_money1` double DEFAULT NULL,
  `assured_refund_money2` double DEFAULT NULL,
  `assured_refund_money3` double DEFAULT NULL,
  `assured_refund_money4` double DEFAULT NULL,
  `assured_remain_money1` double DEFAULT NULL,
  `assured_remain_money2` double DEFAULT NULL,
  `assured_remain_money3` double DEFAULT NULL,
  `assured_remain_money4` double DEFAULT NULL,
  `assured_type1` varchar(50) DEFAULT NULL,
  `assured_type2` varchar(50) DEFAULT NULL,
  `assured_type3` varchar(50) DEFAULT NULL,
  `assured_type4` varchar(50) DEFAULT NULL,
  `assured_units1` varchar(50) DEFAULT NULL,
  `assured_units2` varchar(50) DEFAULT NULL,
  `assured_units3` varchar(50) DEFAULT NULL,
  `assured_units4` varchar(50) DEFAULT NULL,
  `basic_bank_account` varchar(30) DEFAULT NULL,
  `basic_bank_name` varchar(50) DEFAULT NULL,
  `beneficiary1` varchar(50) DEFAULT NULL,
  `beneficiary2` varchar(50) DEFAULT NULL,
  `businessLicense` varchar(100) DEFAULT NULL,
  `control_name` varchar(20) DEFAULT NULL,
  `control_situation` varchar(255) DEFAULT NULL,
  `control_time` varchar(30) DEFAULT NULL,
  `corporation_birthdate` varchar(30) DEFAULT NULL,
  `corporation_delegate1` varchar(50) DEFAULT NULL,
  `corporation_delegate2` varchar(50) DEFAULT NULL,
  `corporation_delegate3` varchar(50) DEFAULT NULL,
  `corporation_name` varchar(20) DEFAULT NULL,
  `corporation_nationality` varchar(30) DEFAULT NULL,
  `corporation_sex` varchar(4) DEFAULT NULL,
  `custodian_total` int(11) DEFAULT NULL,
  `education_background` varchar(20) DEFAULT NULL,
  `enterprise` varchar(100) DEFAULT NULL,
  `enterpriseType` varchar(100) DEFAULT NULL,
  `financing_name` varchar(20) DEFAULT NULL,
  `financing_situation` varchar(255) DEFAULT NULL,
  `financing_time` varchar(30) DEFAULT NULL,
  `history_situation` varchar(255) DEFAULT NULL,
  `home_address` varchar(100) DEFAULT NULL,
  `home_telphone` varchar(15) DEFAULT NULL,
  `indictee1` varchar(50) DEFAULT NULL,
  `indictee2` varchar(50) DEFAULT NULL,
  `indictee3` varchar(50) DEFAULT NULL,
  `indictee4` varchar(50) DEFAULT NULL,
  `indicter1` varchar(50) DEFAULT NULL,
  `indicter2` varchar(50) DEFAULT NULL,
  `indicter3` varchar(50) DEFAULT NULL,
  `indicter4` varchar(50) DEFAULT NULL,
  `injection_type1` varchar(50) DEFAULT NULL,
  `injection_type2` varchar(50) DEFAULT NULL,
  `injection_type3` varchar(50) DEFAULT NULL,
  `last_year_income` double DEFAULT NULL,
  `last_year_profit` double DEFAULT NULL,
  `last_year_retained_profits` double DEFAULT NULL,
  `lawsuit_cause1` varchar(255) DEFAULT NULL,
  `lawsuit_cause2` varchar(255) DEFAULT NULL,
  `lawsuit_cause3` varchar(255) DEFAULT NULL,
  `lawsuit_cause4` varchar(255) DEFAULT NULL,
  `lawsuit_money1` double DEFAULT NULL,
  `lawsuit_money2` double DEFAULT NULL,
  `lawsuit_money3` double DEFAULT NULL,
  `lawsuit_money4` double DEFAULT NULL,
  `linkman` varchar(20) DEFAULT NULL,
  `linkman_duties` varchar(50) DEFAULT NULL,
  `linkman_fax` varchar(15) DEFAULT NULL,
  `linkman_telphone` varchar(15) DEFAULT NULL,
  `loanCardAccount` varchar(30) DEFAULT NULL,
  `loan_bank1` varchar(50) DEFAULT NULL,
  `loan_bank11` varchar(50) DEFAULT NULL,
  `loan_bank2` varchar(50) DEFAULT NULL,
  `loan_bank22` varchar(50) DEFAULT NULL,
  `loan_due_time1` int(11) DEFAULT NULL,
  `loan_due_time2` int(11) DEFAULT NULL,
  `loan_due_time3` int(11) DEFAULT NULL,
  `loan_due_time4` int(11) DEFAULT NULL,
  `loan_money1` double DEFAULT NULL,
  `loan_money2` double DEFAULT NULL,
  `loan_money3` double DEFAULT NULL,
  `loan_money4` double DEFAULT NULL,
  `loan_person1` varchar(20) DEFAULT NULL,
  `loan_person2` varchar(20) DEFAULT NULL,
  `loan_person3` varchar(20) DEFAULT NULL,
  `loan_person4` varchar(20) DEFAULT NULL,
  `loan_purpose` varchar(255) DEFAULT NULL,
  `manage_scope` varchar(255) DEFAULT NULL,
  `manager_name` varchar(20) DEFAULT NULL,
  `manager_situation` varchar(255) DEFAULT NULL,
  `manager_time` varchar(30) DEFAULT NULL,
  `marriage_status` varchar(255) DEFAULT NULL,
  `matter_name` varchar(50) DEFAULT NULL,
  `mature_date1` varchar(30) DEFAULT NULL,
  `mature_date2` varchar(30) DEFAULT NULL,
  `mature_date3` varchar(30) DEFAULT NULL,
  `mature_date4` varchar(30) DEFAULT NULL,
  `mobile_phone` varchar(15) DEFAULT NULL,
  `money_rate1` double DEFAULT NULL,
  `money_rate2` double DEFAULT NULL,
  `money_rate3` double DEFAULT NULL,
  `money_rate4` double DEFAULT NULL,
  `mortgagor_name` varchar(50) DEFAULT NULL,
  `net_value` double DEFAULT NULL,
  `office_telphone` varchar(10) DEFAULT NULL,
  `organizationId` varchar(50) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `other_bank_account1` varchar(30) DEFAULT NULL,
  `other_bank_account2` varchar(30) DEFAULT NULL,
  `other_bank_account3` varchar(30) DEFAULT NULL,
  `other_bank_account4` varchar(30) DEFAULT NULL,
  `other_bank_account5` varchar(30) DEFAULT NULL,
  `other_bank_name1` varchar(50) DEFAULT NULL,
  `other_bank_name2` varchar(50) DEFAULT NULL,
  `other_bank_name3` varchar(50) DEFAULT NULL,
  `other_bank_name4` varchar(50) DEFAULT NULL,
  `other_bank_name5` varchar(50) DEFAULT NULL,
  `papers_name` varchar(30) DEFAULT NULL,
  `papers_number` varchar(30) DEFAULT NULL,
  `pledge_name` varchar(50) DEFAULT NULL,
  `pledgor_name` varchar(50) DEFAULT NULL,
  `postcode` varchar(10) DEFAULT NULL,
  `present_value` double DEFAULT NULL,
  `president_name` varchar(20) DEFAULT NULL,
  `president_situation` varchar(255) DEFAULT NULL,
  `president_time` varchar(30) DEFAULT NULL,
  `product_name1` varchar(100) DEFAULT NULL,
  `product_name2` varchar(100) DEFAULT NULL,
  `product_name3` varchar(100) DEFAULT NULL,
  `product_ratio1` double DEFAULT NULL,
  `product_ratio2` double DEFAULT NULL,
  `product_ratio3` double DEFAULT NULL,
  `project_situation` varchar(255) DEFAULT NULL,
  `reality_fund` double DEFAULT NULL,
  `refund_money1` double DEFAULT NULL,
  `refund_money2` double DEFAULT NULL,
  `refund_money3` double DEFAULT NULL,
  `refund_money4` double DEFAULT NULL,
  `refund_source` varchar(255) DEFAULT NULL,
  `registerAddress` varchar(100) DEFAULT NULL,
  `registerFund` double DEFAULT NULL,
  `registerNature` varchar(255) DEFAULT NULL,
  `registerTime` varchar(30) DEFAULT NULL,
  `register_fund1` double DEFAULT NULL,
  `register_fund2` double DEFAULT NULL,
  `register_fund3` double DEFAULT NULL,
  `relation_explain` varchar(255) DEFAULT NULL,
  `remain_money1` double DEFAULT NULL,
  `remain_money2` double DEFAULT NULL,
  `remain_money3` double DEFAULT NULL,
  `remain_money4` double DEFAULT NULL,
  `share_ratio1` double DEFAULT NULL,
  `share_ratio2` double DEFAULT NULL,
  `share_ratio3` double DEFAULT NULL,
  `shareholder_name1` varchar(50) DEFAULT NULL,
  `shareholder_name2` varchar(50) DEFAULT NULL,
  `shareholder_name3` varchar(50) DEFAULT NULL,
  `takeOffice_time` varchar(30) DEFAULT NULL,
  `technology_total` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `total_property` double DEFAULT NULL,
  `undergraduate_total` int(11) DEFAULT NULL,
  `warrantor` varchar(50) DEFAULT NULL,
  `warrantor_account` varchar(30) DEFAULT NULL,
  `warrantor_bank` varchar(50) DEFAULT NULL,
  `warrantor_register_fund` double DEFAULT NULL,
  `warrantor_telephone` varchar(15) DEFAULT NULL,
  `warrantor_total_assets` double DEFAULT NULL,
  `workAddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applicationform
-- ----------------------------

-- ----------------------------
-- Table structure for `bank`
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `bankId` varchar(5) NOT NULL,
  `address` varchar(128) DEFAULT NULL,
  `bankName` varchar(64) NOT NULL,
  `demo` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `parentId` varchar(2) DEFAULT NULL,
  `postcode` varchar(6) DEFAULT NULL,
  `telephoneNumber` varchar(20) DEFAULT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`bankId`),
  UNIQUE KEY `bankId` (`bankId`),
  UNIQUE KEY `bankName` (`bankName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO bank VALUES ('01', null, '中国银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('02', null, '建设银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('03', null, '农业银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('04', null, '交通银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('05', null, '浦发银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('06', null, '广发银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('07', null, '民生银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('08', null, '工商银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('09', null, '招商银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('10', null, '大连银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('11', null, '深发展银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('12', null, '国家开发银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('13', null, '兴业银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('14', null, '哈尔滨商行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('15', null, '融达公司', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('16', null, '光大银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('17', null, '中信银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('18', null, '锦州银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('19', null, '营口银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('20', null, '吉林银行', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('21', null, '海尔集团财务有限责任公司', null, null, null, null, null, 'YES');
INSERT INTO bank VALUES ('99', null, '银行待定', null, null, null, null, null, 'YES');

-- ----------------------------
-- Table structure for `bankcd`
-- ----------------------------
DROP TABLE IF EXISTS `bankcd`;
CREATE TABLE `bankcd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consCD` varchar(32) NOT NULL,
  `consValue` varchar(1) NOT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `visiable` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bankcd
-- ----------------------------
INSERT INTO bankcd VALUES ('1', 'FILETYPE', '0', null, '提交用文件', 'YES');
INSERT INTO bankcd VALUES ('2', 'FILETYPE', '1', null, '签署用文件', 'YES');
INSERT INTO bankcd VALUES ('3', 'BUSINESSTYPE', '0', null, '签约', 'YES');
INSERT INTO bankcd VALUES ('4', 'BUSINESSTYPE', '1', null, '放款', 'YES');

-- ----------------------------
-- Table structure for `bankfile`
-- ----------------------------
DROP TABLE IF EXISTS `bankfile`;
CREATE TABLE `bankfile` (
  `bankFileId` int(11) NOT NULL AUTO_INCREMENT,
  `bankId` varchar(2) DEFAULT NULL,
  `businessTypeCD` varchar(2) DEFAULT NULL,
  `fileName` varchar(32) DEFAULT NULL,
  `fileTypeCD` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`bankFileId`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bankfile
-- ----------------------------
INSERT INTO bankfile VALUES ('1', '01', '1', '授信额度协议', '0');
INSERT INTO bankfile VALUES ('2', '01', '1', '人民币借款合同(短期)', '0');
INSERT INTO bankfile VALUES ('3', '01', '1', '授信业务总协议', '0');
INSERT INTO bankfile VALUES ('4', '01', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('5', '01', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('6', '01', '0', '授信额度协议', '0');
INSERT INTO bankfile VALUES ('7', '01', '0', '人民币借款合同(短期)', '0');
INSERT INTO bankfile VALUES ('8', '01', '0', '授信业务总协议', '0');
INSERT INTO bankfile VALUES ('9', '01', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('10', '01', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('11', '02', '0', '人民币流动资金贷款合同', '0');
INSERT INTO bankfile VALUES ('12', '02', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('13', '02', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('14', '02', '1', '人民币流动资金贷款合同', '0');
INSERT INTO bankfile VALUES ('15', '02', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('16', '03', '1', '可循环使用信用授信合同', '0');
INSERT INTO bankfile VALUES ('17', '03', '1', '商业汇票银行承兑合同', '0');
INSERT INTO bankfile VALUES ('18', '03', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('19', '03', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('20', '03', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('21', '03', '0', '可循环使用信用授信合同', '0');
INSERT INTO bankfile VALUES ('22', '03', '0', '商业汇票银行承兑合同', '0');
INSERT INTO bankfile VALUES ('23', '03', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('24', '03', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('25', '03', '1', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('26', '03', '0', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('27', '03', '1', '商业汇票银行承兑申请书', '1');
INSERT INTO bankfile VALUES ('28', '03', '1', '进口开证合同', '0');
INSERT INTO bankfile VALUES ('29', '05', '0', '融资额度协议', '0');
INSERT INTO bankfile VALUES ('30', '05', '0', '短期贷款协议书', '0');
INSERT INTO bankfile VALUES ('31', '05', '0', '开立银行承兑汇票协议书', '0');
INSERT INTO bankfile VALUES ('32', '05', '0', '进口信用证开证协议', '0');
INSERT INTO bankfile VALUES ('33', '05', '0', '进口押汇协议', '0');
INSERT INTO bankfile VALUES ('34', '05', '0', '信用证出口押汇、托收押汇协议书', '0');
INSERT INTO bankfile VALUES ('35', '05', '0', '打包贷款协议书', '0');
INSERT INTO bankfile VALUES ('36', '05', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('37', '05', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('38', '05', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('39', '05', '1', '融资额度协议', '0');
INSERT INTO bankfile VALUES ('40', '05', '1', '短期贷款协议书', '0');
INSERT INTO bankfile VALUES ('41', '05', '1', '开立银行承兑汇票协议书', '0');
INSERT INTO bankfile VALUES ('42', '05', '1', '进口信用证开证协议', '0');
INSERT INTO bankfile VALUES ('43', '05', '1', '进口押汇协议', '0');
INSERT INTO bankfile VALUES ('44', '05', '1', '信用证出口押汇、托收押汇协议书', '0');
INSERT INTO bankfile VALUES ('45', '05', '1', '打包贷款协议书', '0');
INSERT INTO bankfile VALUES ('46', '05', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('47', '05', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('48', '05', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('49', '05', '0', '进口代付业务协议书', '0');
INSERT INTO bankfile VALUES ('50', '05', '0', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('51', '05', '0', '保证合同-单笔', '1');
INSERT INTO bankfile VALUES ('52', '05', '1', '进口代付业务协议书', '0');
INSERT INTO bankfile VALUES ('53', '05', '1', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('54', '05', '1', '保证合同-单笔', '1');
INSERT INTO bankfile VALUES ('55', '05', '1', '开立信用证协议书', '0');
INSERT INTO bankfile VALUES ('56', '05', '1', '开立保函(备用信用证)协议书', '0');
INSERT INTO bankfile VALUES ('57', '05', '0', '开立保函(备用信用证)协议书', '0');
INSERT INTO bankfile VALUES ('58', '05', '1', '国内信用证买方代付业务协议书', '0');
INSERT INTO bankfile VALUES ('59', '05', '0', '核保书', '1');
INSERT INTO bankfile VALUES ('60', '05', '1', '核保书', '1');
INSERT INTO bankfile VALUES ('61', '05', '1', '放款通知书', '1');
INSERT INTO bankfile VALUES ('62', '05', '1', '委托贷款合同', '1');
INSERT INTO bankfile VALUES ('63', '05', '1', '委托贷款委托协议', '1');
INSERT INTO bankfile VALUES ('64', '05', '1', '信用证进口押汇协议书', '0');
INSERT INTO bankfile VALUES ('65', '06', '0', '综合授信额度合同', '0');
INSERT INTO bankfile VALUES ('66', '06', '0', '借款合同', '0');
INSERT INTO bankfile VALUES ('67', '06', '0', '外币短期贷款合同', '0');
INSERT INTO bankfile VALUES ('68', '06', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('69', '06', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('70', '06', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('71', '06', '1', '综合授信额度合同', '0');
INSERT INTO bankfile VALUES ('72', '06', '1', '借款合同', '0');
INSERT INTO bankfile VALUES ('73', '06', '1', '外币短期贷款合同', '0');
INSERT INTO bankfile VALUES ('74', '06', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('75', '06', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('76', '06', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('77', '06', '0', '核保书', '1');
INSERT INTO bankfile VALUES ('78', '06', '1', '核保书', '1');
INSERT INTO bankfile VALUES ('79', '06', '1', '授信额度合同', '0');
INSERT INTO bankfile VALUES ('80', '06', '0', '授信额度合同', '0');
INSERT INTO bankfile VALUES ('81', '07', '0', '综合授信额度合同', '0');
INSERT INTO bankfile VALUES ('82', '07', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('83', '07', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('84', '07', '1', '流动资金贷款借款合同', '0');
INSERT INTO bankfile VALUES ('85', '07', '0', '中小企业金融服务合同', '0');
INSERT INTO bankfile VALUES ('86', '07', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('87', '07', '0', '核保书', '1');
INSERT INTO bankfile VALUES ('88', '09', '0', '授信协议', '0');
INSERT INTO bankfile VALUES ('89', '09', '0', '借款合同', '0');
INSERT INTO bankfile VALUES ('90', '09', '0', '银行承兑协议', '0');
INSERT INTO bankfile VALUES ('91', '09', '0', '最高额不可撤销担保书', '1');
INSERT INTO bankfile VALUES ('92', '09', '0', '不可撤销担保书', '1');
INSERT INTO bankfile VALUES ('93', '09', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('94', '09', '1', '授信协议', '0');
INSERT INTO bankfile VALUES ('95', '09', '1', '借款合同', '0');
INSERT INTO bankfile VALUES ('96', '09', '1', '银行承兑协议', '0');
INSERT INTO bankfile VALUES ('97', '09', '1', '最高额不可撤销担保书', '1');
INSERT INTO bankfile VALUES ('98', '09', '1', '不可撤销担保书', '1');
INSERT INTO bankfile VALUES ('99', '09', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('100', '09', '0', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('101', '09', '1', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('102', '09', '0', '对保书', '1');
INSERT INTO bankfile VALUES ('103', '09', '1', '对保书', '1');
INSERT INTO bankfile VALUES ('104', '09', '1', '担保协议', '0');
INSERT INTO bankfile VALUES ('105', '10', '0', '综合授信额度协议', '0');
INSERT INTO bankfile VALUES ('106', '10', '0', '汇票承兑合同', '0');
INSERT INTO bankfile VALUES ('107', '10', '0', '人民币借款合同', '0');
INSERT INTO bankfile VALUES ('108', '10', '0', '打包放款合同', '0');
INSERT INTO bankfile VALUES ('109', '10', '0', '最高额承兑保证担保合同', '1');
INSERT INTO bankfile VALUES ('110', '10', '0', '汇票承兑保证担保合同', '1');
INSERT INTO bankfile VALUES ('111', '10', '0', '人民币借款保证合同', '1');
INSERT INTO bankfile VALUES ('112', '10', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('113', '10', '1', '综合授信额度协议', '0');
INSERT INTO bankfile VALUES ('114', '10', '1', '汇票承兑合同', '0');
INSERT INTO bankfile VALUES ('115', '10', '1', '人民币借款合同', '0');
INSERT INTO bankfile VALUES ('116', '10', '1', '打包放款合同', '0');
INSERT INTO bankfile VALUES ('117', '10', '1', '最高额承兑保证担保合同', '1');
INSERT INTO bankfile VALUES ('118', '10', '1', '汇票承兑保证担保合同', '1');
INSERT INTO bankfile VALUES ('119', '10', '1', '人民币借款保证合同', '1');
INSERT INTO bankfile VALUES ('120', '10', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('121', '10', '0', '人民币流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('122', '10', '1', '人民币流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('123', '10', '1', '人民币委托贷款合同', '1');
INSERT INTO bankfile VALUES ('124', '10', '1', '放款通知书', '1');
INSERT INTO bankfile VALUES ('125', '10', '1', '委托贷款通知单', '1');
INSERT INTO bankfile VALUES ('126', '10', '1', '委托贷款申请书', '1');
INSERT INTO bankfile VALUES ('127', '10', '1', '委托划款承诺书', '1');
INSERT INTO bankfile VALUES ('128', '10', '1', '委托资金来源证明', '1');
INSERT INTO bankfile VALUES ('129', '11', '0', '综合授信额度合同', '0');
INSERT INTO bankfile VALUES ('130', '11', '0', '贷款合同', '0');
INSERT INTO bankfile VALUES ('131', '11', '0', '汇票承兑合同', '0');
INSERT INTO bankfile VALUES ('132', '11', '0', '最高额保证担保合同', '1');
INSERT INTO bankfile VALUES ('133', '11', '0', '保证担保合同', '1');
INSERT INTO bankfile VALUES ('134', '11', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('135', '11', '1', '综合授信额度合同', '0');
INSERT INTO bankfile VALUES ('136', '11', '1', '贷款合同', '0');
INSERT INTO bankfile VALUES ('137', '11', '1', '汇票承兑合同', '0');
INSERT INTO bankfile VALUES ('138', '11', '1', '最高额保证担保合同', '1');
INSERT INTO bankfile VALUES ('139', '11', '1', '保证担保合同', '1');
INSERT INTO bankfile VALUES ('140', '11', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('141', '11', '1', '承兑申请书', '0');
INSERT INTO bankfile VALUES ('142', '11', '0', '承兑申请书', '0');
INSERT INTO bankfile VALUES ('143', '11', '1', '打包放款合同', '0');
INSERT INTO bankfile VALUES ('144', '11', '1', '贴现申请书', '0');
INSERT INTO bankfile VALUES ('145', '12', '0', '国家开发银行人民币资金借款合同', '0');
INSERT INTO bankfile VALUES ('146', '12', '0', '委托贷款合同', '0');
INSERT INTO bankfile VALUES ('147', '12', '0', '开行人民币资金银团贷款合同', '0');
INSERT INTO bankfile VALUES ('148', '12', '0', '国家开发银行人民币资金贷款保证合同', '1');
INSERT INTO bankfile VALUES ('149', '12', '0', '委托贷款保证合同', '1');
INSERT INTO bankfile VALUES ('150', '12', '0', '银团贷款保证合同', '1');
INSERT INTO bankfile VALUES ('151', '12', '1', '国家开发银行人民币资金借款合同', '0');
INSERT INTO bankfile VALUES ('152', '12', '1', '委托贷款合同', '0');
INSERT INTO bankfile VALUES ('153', '12', '1', '开行人民币资金银团贷款合同', '0');
INSERT INTO bankfile VALUES ('154', '12', '1', '国家开发银行人民币资金贷款保证合同', '1');
INSERT INTO bankfile VALUES ('155', '12', '1', '委托贷款保证合同', '1');
INSERT INTO bankfile VALUES ('156', '12', '1', '银团贷款保证合同', '1');
INSERT INTO bankfile VALUES ('157', '12', '1', '贷款支出通知函', '1');
INSERT INTO bankfile VALUES ('158', '12', '1', '放款通知书', '1');
INSERT INTO bankfile VALUES ('159', '13', '0', '基本额度授信合同', '0');
INSERT INTO bankfile VALUES ('160', '13', '0', '兴业银行承兑协议', '0');
INSERT INTO bankfile VALUES ('161', '13', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('162', '13', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('163', '13', '1', '基本额度授信合同', '0');
INSERT INTO bankfile VALUES ('164', '13', '1', '兴业银行承兑协议', '0');
INSERT INTO bankfile VALUES ('165', '13', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('166', '13', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('167', '13', '0', '人民币短期借款合同', '0');
INSERT INTO bankfile VALUES ('168', '13', '0', '兴业银行保证合同', '1');
INSERT INTO bankfile VALUES ('169', '13', '1', '人民币短期借款合同', '0');
INSERT INTO bankfile VALUES ('170', '13', '1', '兴业银行保证合同', '1');
INSERT INTO bankfile VALUES ('171', '13', '1', '兴业银行开立银行保函协议书', '0');
INSERT INTO bankfile VALUES ('172', '13', '1', '兴业银行商业汇票银行承兑合同', '0');
INSERT INTO bankfile VALUES ('173', '13', '1', '兴业银行流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('174', '13', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('175', '13', '0', '项目融资借款合同', '0');
INSERT INTO bankfile VALUES ('176', '14', '0', '最高额综合授信合同', '0');
INSERT INTO bankfile VALUES ('177', '14', '0', '银行承兑协议', '0');
INSERT INTO bankfile VALUES ('178', '14', '1', '最高额综合授信合同', '0');
INSERT INTO bankfile VALUES ('179', '14', '1', '银行承兑协议', '0');
INSERT INTO bankfile VALUES ('180', '14', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('181', '14', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('182', '14', '1', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('183', '14', '1', '进口押汇合同', '0');
INSERT INTO bankfile VALUES ('184', '14', '1', '出口打包放款合同', '0');
INSERT INTO bankfile VALUES ('185', '14', '1', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('186', '14', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('187', '14', '0', '流动资金借款合同', '0');
INSERT INTO bankfile VALUES ('188', '14', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('189', '15', '0', '担保确认函', '1');
INSERT INTO bankfile VALUES ('190', '15', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('191', '17', '0', '人民币流动资金贷款合同', '0');
INSERT INTO bankfile VALUES ('192', '17', '0', '最高额保证合同', '1');
INSERT INTO bankfile VALUES ('193', '17', '0', '保证核保书', '1');
INSERT INTO bankfile VALUES ('194', '17', '1', '人民币流动资金贷款合同', '0');
INSERT INTO bankfile VALUES ('195', '17', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('196', '20', '1', '委托贷款合同', '1');
INSERT INTO bankfile VALUES ('197', '20', '1', '委托贷款协议书', '1');
INSERT INTO bankfile VALUES ('198', '20', '1', '委托贷款业务委托书', '1');
INSERT INTO bankfile VALUES ('199', '20', '1', '委托贷款发放通知书', '1');
INSERT INTO bankfile VALUES ('200', '20', '0', '小企业人民币借款合同', '0');
INSERT INTO bankfile VALUES ('201', '20', '0', '保证合同', '1');
INSERT INTO bankfile VALUES ('202', '20', '1', '小企业人民币借款合同', '0');
INSERT INTO bankfile VALUES ('203', '20', '1', '保证合同', '1');
INSERT INTO bankfile VALUES ('204', '20', '1', '担保确认函', '1');
INSERT INTO bankfile VALUES ('205', '21', '1', '买方信贷额度借款合同', '0');
INSERT INTO bankfile VALUES ('206', '21', '1', '担保确认函', '1');

-- ----------------------------
-- Table structure for `commondocument`
-- ----------------------------
DROP TABLE IF EXISTS `commondocument`;
CREATE TABLE `commondocument` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `demo` varchar(100) DEFAULT NULL,
  `fileType` varchar(1) DEFAULT NULL,
  `isDocumentManagerChecked` varchar(1) DEFAULT NULL,
  `isProjectManagerChecked` varchar(1) DEFAULT NULL,
  `isRecoveryStaffChecked` varchar(1) DEFAULT NULL,
  `isReviewChecked` varchar(1) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `projectDocumentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC561046A76EF98D` (`projectDocumentId`),
  CONSTRAINT `FKC561046A76EF98D` FOREIGN KEY (`projectDocumentId`) REFERENCES `projectdocument` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commondocument
-- ----------------------------

-- ----------------------------
-- Table structure for `cooperativebank`
-- ----------------------------
DROP TABLE IF EXISTS `cooperativebank`;
CREATE TABLE `cooperativebank` (
  `bankId` int(11) NOT NULL AUTO_INCREMENT,
  `childBankId` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `projectApprovalId` int(11) DEFAULT NULL,
  `projectApproval_id` int(11) NOT NULL,
  PRIMARY KEY (`bankId`),
  KEY `FK847D9807C59FAF8A` (`projectApproval_id`),
  CONSTRAINT `FK847D9807C59FAF8A` FOREIGN KEY (`projectApproval_id`) REFERENCES `projectapproval` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cooperativebank
-- ----------------------------

-- ----------------------------
-- Table structure for `currency`
-- ----------------------------
DROP TABLE IF EXISTS `currency`;
CREATE TABLE `currency` (
  `id` varchar(3) NOT NULL,
  `exchangeRate` double DEFAULT NULL,
  `name` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of currency
-- ----------------------------

-- ----------------------------
-- Table structure for `dynamicprocesser`
-- ----------------------------
DROP TABLE IF EXISTS `dynamicprocesser`;
CREATE TABLE `dynamicprocesser` (
  `StepsProcessers_id` varchar(32) NOT NULL,
  `relationId` varchar(5) NOT NULL,
  `stepId` varchar(5) NOT NULL,
  `userId` varchar(5) DEFAULT NULL,
  `taskId` int(11) DEFAULT NULL,
  PRIMARY KEY (`StepsProcessers_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dynamicprocesser
-- ----------------------------
INSERT INTO dynamicprocesser VALUES ('51866030a6bd4902a456008fcc58540d', '00006', '44', '00006', '4');
INSERT INTO dynamicprocesser VALUES ('55049c0ab82e446bbdd26a6906733c04', '00006', '04', '00040', '2');
INSERT INTO dynamicprocesser VALUES ('676497b9b1e847fcb3821ac5fa700b5e', '00006', '04', '00040', '1');
INSERT INTO dynamicprocesser VALUES ('6ba812ecf3294d5a822e3601fa081610', '00006', '03', '00006', '1');
INSERT INTO dynamicprocesser VALUES ('74c547f4a4bd4262bc4f5ae295117697', '00006', '44', '00006', '3');
INSERT INTO dynamicprocesser VALUES ('a392ccade0fc49b0b24c1313c778c4a8', '00006', '03', '00006', '2');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeId` varchar(5) NOT NULL,
  `address` varchar(80) DEFAULT NULL,
  `aupEmpDate` datetime NOT NULL,
  `aupEmpcode` varchar(5) NOT NULL,
  `birthday` date DEFAULT NULL,
  `contractEndDate` date DEFAULT NULL,
  `contractStartDate` date DEFAULT NULL,
  `demo` varchar(125) DEFAULT NULL,
  `email01` varchar(32) DEFAULT NULL,
  `email02` varchar(32) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `nativePlace` varchar(80) DEFAULT NULL,
  `onBoardDate` date DEFAULT NULL,
  `telephone01` varchar(20) DEFAULT NULL,
  `telephone02` varchar(20) DEFAULT NULL,
  `trainFlag` varchar(3) NOT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `employeeId` (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO employee VALUES ('00001', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00002', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00003', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00004', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00005', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00006', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00007', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00008', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00009', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00010', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00011', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00012', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00013', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00014', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00015', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00016', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00017', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00018', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00019', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00020', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00021', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00022', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00023', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00024', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00025', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00026', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00027', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00028', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00029', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00030', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00031', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00032', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00033', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00034', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00035', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00036', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00037', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00038', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00039', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00040', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00041', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00042', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');
INSERT INTO employee VALUES ('00043', null, '2011-06-27 14:17:18', '00001', null, null, null, null, null, null, 'MAN', null, null, null, null, 'YES');

-- ----------------------------
-- Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `applicationForm_id` int(11) DEFAULT NULL,
  `contactPhone` varchar(15) DEFAULT NULL,
  `contacterName` varchar(50) DEFAULT NULL,
  `enterpriseNo` varchar(10) DEFAULT NULL,
  `enterpriseType_id` int(11) DEFAULT NULL,
  `legalPersonName` varchar(50) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `registAddress` varchar(100) DEFAULT NULL,
  `registTime` varchar(30) DEFAULT NULL,
  `registType_id` int(11) DEFAULT NULL,
  `registrationCapital` double DEFAULT NULL,
  `sendApplicationForm` varchar(3) DEFAULT NULL,
  `withdrawApplicationForm` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK46F90F81FF9064BD` (`applicationForm_id`),
  KEY `FK46F90F81F043BB09` (`registType_id`),
  KEY `FK46F90F81282680BE` (`enterpriseType_id`),
  CONSTRAINT `FK46F90F81282680BE` FOREIGN KEY (`enterpriseType_id`) REFERENCES `enterprisecd` (`id`),
  CONSTRAINT `FK46F90F81F043BB09` FOREIGN KEY (`registType_id`) REFERENCES `enterprisecd` (`id`),
  CONSTRAINT `FK46F90F81FF9064BD` FOREIGN KEY (`applicationForm_id`) REFERENCES `applicationform` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO enterprise VALUES ('1', null, '39565015', '雷晓飞', null, '3', '雷晓飞', '大连北方测控工程有限公司', '辽宁 大连市 高新园区七贤岭学子街2号3-1-2', '2011-06-22', '26', '1212', null, null);
INSERT INTO enterprise VALUES ('2', null, '87987879', '周方年', null, '2', '周方年', '大连松祥贸易有限公司', '辽宁 大连市 开发区', '2011-06-07', '26', '121212', null, null);

-- ----------------------------
-- Table structure for `enterprisecd`
-- ----------------------------
DROP TABLE IF EXISTS `enterprisecd`;
CREATE TABLE `enterprisecd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consCD` varchar(32) NOT NULL,
  `consValue` varchar(2) NOT NULL,
  `demo` varchar(255) DEFAULT NULL,
  `name` varchar(32) NOT NULL,
  `visiable` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprisecd
-- ----------------------------
INSERT INTO enterprisecd VALUES ('1', 'industryType', 'A', null, '农、林、牧、渔业', 'YES');
INSERT INTO enterprisecd VALUES ('2', 'industryType', 'B', null, '采掘业', 'YES');
INSERT INTO enterprisecd VALUES ('3', 'industryType', 'C1', null, '--食品、饮料', 'YES');
INSERT INTO enterprisecd VALUES ('4', 'industryType', 'C2', null, '--纺织、服装、皮毛', 'YES');
INSERT INTO enterprisecd VALUES ('5', 'industryType', 'C3', null, '--木材、家具', 'YES');
INSERT INTO enterprisecd VALUES ('6', 'industryType', 'C4', null, '--造纸、印刷', 'YES');
INSERT INTO enterprisecd VALUES ('7', 'industryType', 'C5', null, '--石油、化学、塑料、塑胶', 'YES');
INSERT INTO enterprisecd VALUES ('8', 'industryType', 'C6', null, '--电子', 'YES');
INSERT INTO enterprisecd VALUES ('9', 'industryType', 'C7', null, '--金属、非金属', 'YES');
INSERT INTO enterprisecd VALUES ('10', 'industryType', 'C8', null, '--机械、设备、仪表', 'YES');
INSERT INTO enterprisecd VALUES ('11', 'industryType', 'C9', null, '--医药、生物制造', 'YES');
INSERT INTO enterprisecd VALUES ('12', 'industryType', 'CA', null, '--其他制造业', 'YES');
INSERT INTO enterprisecd VALUES ('13', 'industryType', 'D', null, '电力、煤气、水的生产和供应业', 'YES');
INSERT INTO enterprisecd VALUES ('14', 'industryType', 'E', null, '建筑业', 'YES');
INSERT INTO enterprisecd VALUES ('15', 'industryType', 'F', null, '交通运输、仓储业', 'YES');
INSERT INTO enterprisecd VALUES ('16', 'industryType', 'G', null, '信息技术业', 'YES');
INSERT INTO enterprisecd VALUES ('17', 'industryType', 'H', null, '批发、零售业', 'YES');
INSERT INTO enterprisecd VALUES ('18', 'industryType', 'I', null, '金融、保险业', 'YES');
INSERT INTO enterprisecd VALUES ('19', 'industryType', 'J', null, '房地产业', 'YES');
INSERT INTO enterprisecd VALUES ('20', 'industryType', 'K', null, '社会服务业', 'YES');
INSERT INTO enterprisecd VALUES ('21', 'industryType', 'L', null, '传播、文化业', 'YES');
INSERT INTO enterprisecd VALUES ('22', 'industryType', 'M', null, '综合业', 'YES');
INSERT INTO enterprisecd VALUES ('23', 'industryType', 'N', null, '其他', 'YES');
INSERT INTO enterprisecd VALUES ('24', 'registrationType', 'A', null, '有限公司', 'YES');
INSERT INTO enterprisecd VALUES ('25', 'registrationType', 'B', null, '股份有限公司', 'YES');
INSERT INTO enterprisecd VALUES ('26', 'registrationType', 'C', null, '三资企业', 'YES');
INSERT INTO enterprisecd VALUES ('27', 'registrationType', 'D', null, '自然人', 'YES');
INSERT INTO enterprisecd VALUES ('28', 'registrationType', 'E', null, '个体工商户', 'YES');
INSERT INTO enterprisecd VALUES ('29', 'registrationType', 'F', null, '事业法人', 'YES');
INSERT INTO enterprisecd VALUES ('30', 'registrationType', 'G', null, '社会团体', 'YES');
INSERT INTO enterprisecd VALUES ('31', 'registrationType', 'H', null, '其他', 'YES');
INSERT INTO enterprisecd VALUES ('32', 'sourceType', 'A', null, '自荐', 'YES');
INSERT INTO enterprisecd VALUES ('33', 'sourceType', 'B', null, '银行推荐', 'YES');
INSERT INTO enterprisecd VALUES ('34', 'sourceType', 'C', null, '自行开拓', 'YES');
INSERT INTO enterprisecd VALUES ('35', 'sourceType', 'D', null, '老项目', 'YES');
INSERT INTO enterprisecd VALUES ('36', 'sourceType', 'E', null, '行业协会推荐', 'YES');
INSERT INTO enterprisecd VALUES ('37', 'sourceType', 'F', null, '其他', 'YES');
INSERT INTO enterprisecd VALUES ('38', 'promptType', 'A', null, '固定月', 'YES');
INSERT INTO enterprisecd VALUES ('39', 'promptType', 'B', null, '不限定', 'YES');
INSERT INTO enterprisecd VALUES ('40', 'promptType', 'C', null, '其他', 'YES');
INSERT INTO enterprisecd VALUES ('41', 'chargeType', 'A', null, '同意', 'YES');
INSERT INTO enterprisecd VALUES ('42', 'chargeType', 'B', null, '单笔', 'YES');
INSERT INTO enterprisecd VALUES ('43', 'chargeType', 'C', null, '分期', 'YES');
INSERT INTO enterprisecd VALUES ('44', 'chargeType', 'D', null, '混合', 'YES');
INSERT INTO enterprisecd VALUES ('45', 'chargeType', 'E', null, '委贷', 'YES');
INSERT INTO enterprisecd VALUES ('46', 'loanType', 'A', null, '逐笔发放', 'YES');
INSERT INTO enterprisecd VALUES ('47', 'loanType', 'B', null, '一笔发放', 'YES');
INSERT INTO enterprisecd VALUES ('48', 'refundType', 'A', null, '一次还款', 'YES');
INSERT INTO enterprisecd VALUES ('49', 'refundType', 'B', null, '分期还款', 'YES');
INSERT INTO enterprisecd VALUES ('50', 'refundType', 'C', null, '逐笔归还', 'YES');
INSERT INTO enterprisecd VALUES ('51', 'projectFileType', 'A', null, '项目审核报告', 'YES');
INSERT INTO enterprisecd VALUES ('52', 'projectFileType', 'B', null, '项目工作底稿', 'YES');
INSERT INTO enterprisecd VALUES ('53', 'projectFileType', 'C', null, '担保项目申请表', 'YES');
INSERT INTO enterprisecd VALUES ('54', 'projectFileType', 'D', null, '企业法人营业执照复印件', 'YES');
INSERT INTO enterprisecd VALUES ('55', 'projectFileType', 'E', null, '企业法人代码证书复印件', 'YES');
INSERT INTO enterprisecd VALUES ('56', 'projectFileType', 'F', null, '税务登记证复印件', 'YES');
INSERT INTO enterprisecd VALUES ('57', 'projectFileType', 'G', null, '验资报告复印件', 'YES');
INSERT INTO enterprisecd VALUES ('58', 'projectFileType', 'H', null, '企业章程复印件', 'YES');
INSERT INTO enterprisecd VALUES ('59', 'projectFileType', 'I', null, '法定代表人任职证明', 'YES');
INSERT INTO enterprisecd VALUES ('60', 'projectFileType', 'J', null, '法定代表人简历', 'YES');
INSERT INTO enterprisecd VALUES ('61', 'projectFileType', 'K', null, '法定代表人身份证复印件', 'YES');
INSERT INTO enterprisecd VALUES ('62', 'projectFileType', 'L', null, '法定代表人授权委托书', 'YES');
INSERT INTO enterprisecd VALUES ('63', 'projectFileType', 'M', null, '法定代表人受托人身份证复印件', 'YES');
INSERT INTO enterprisecd VALUES ('64', 'projectFileType', 'N', null, '贷款卡复印件及贷款卡查询结果', 'YES');
INSERT INTO enterprisecd VALUES ('65', 'projectFileType', 'O', null, '个人征信查询结果', 'YES');
INSERT INTO enterprisecd VALUES ('66', 'projectFileType', 'P', null, '企业上两年度以及当期会计报表', 'YES');
INSERT INTO enterprisecd VALUES ('67', 'projectFileType', 'Q', null, '审计报告', 'YES');
INSERT INTO enterprisecd VALUES ('68', 'projectFileType', 'R', null, '银行对帐单', 'YES');
INSERT INTO enterprisecd VALUES ('69', 'projectFileType', 'S', null, '税单', 'YES');

-- ----------------------------
-- Table structure for `flow`
-- ----------------------------
DROP TABLE IF EXISTS `flow`;
CREATE TABLE `flow` (
  `flowId` int(11) NOT NULL AUTO_INCREMENT,
  `flowName` varchar(16) NOT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`flowId`),
  UNIQUE KEY `flowName` (`flowName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flow
-- ----------------------------
INSERT INTO flow VALUES ('1', '正常上会', 'YES');
INSERT INTO flow VALUES ('2', '快速通道', 'YES');
INSERT INTO flow VALUES ('3', '办公会审批', 'YES');
INSERT INTO flow VALUES ('4', '审批复议', 'YES');
INSERT INTO flow VALUES ('5', '签约(非逐笔确认)', 'YES');
INSERT INTO flow VALUES ('6', '签约(逐笔确认)', 'YES');
INSERT INTO flow VALUES ('7', '放款', 'YES');
INSERT INTO flow VALUES ('8', '保费收取', 'YES');
INSERT INTO flow VALUES ('9', '项目文档确认', 'YES');
INSERT INTO flow VALUES ('10', '法律文档确认', 'YES');

-- ----------------------------
-- Table structure for `flowssteps`
-- ----------------------------
DROP TABLE IF EXISTS `flowssteps`;
CREATE TABLE `flowssteps` (
  `flowsSteps_Id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_id` int(11) NOT NULL,
  `isleaf` varchar(3) NOT NULL,
  `stepIndex` varchar(5) NOT NULL,
  `step_id` varchar(5) NOT NULL,
  PRIMARY KEY (`flowsSteps_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of flowssteps
-- ----------------------------
INSERT INTO flowssteps VALUES ('1', '1', 'NO', '01', '01');
INSERT INTO flowssteps VALUES ('2', '1', 'YES', '02', '02');
INSERT INTO flowssteps VALUES ('3', '1', 'NO', '03', '03');
INSERT INTO flowssteps VALUES ('4', '1', 'NO', '04', '04');
INSERT INTO flowssteps VALUES ('5', '1', 'NO', '05', '05');
INSERT INTO flowssteps VALUES ('6', '1', 'NO', '06', '06');
INSERT INTO flowssteps VALUES ('7', '1', 'NO', '07', '07');
INSERT INTO flowssteps VALUES ('8', '1', 'NO', '08', '08');
INSERT INTO flowssteps VALUES ('9', '1', 'YES', '09', '09');
INSERT INTO flowssteps VALUES ('10', '1', 'NO', '10', '10');
INSERT INTO flowssteps VALUES ('11', '1', 'NO', '11', '11');
INSERT INTO flowssteps VALUES ('12', '1', 'NO', '12', '12');
INSERT INTO flowssteps VALUES ('13', '1', 'NO', '13', '13');
INSERT INTO flowssteps VALUES ('14', '1', 'NO', '14', '14');
INSERT INTO flowssteps VALUES ('15', '1', 'NO', '15', '15');
INSERT INTO flowssteps VALUES ('16', '1', 'NO', '16', '16');
INSERT INTO flowssteps VALUES ('17', '1', 'NO', '17', '17');
INSERT INTO flowssteps VALUES ('18', '1', 'NO', '18', '41');
INSERT INTO flowssteps VALUES ('19', '1', 'NO', '19', '42');
INSERT INTO flowssteps VALUES ('20', '4', 'NO', '01', '19');
INSERT INTO flowssteps VALUES ('21', '4', 'NO', '02', '20');
INSERT INTO flowssteps VALUES ('22', '4', 'NO', '03', '21');
INSERT INTO flowssteps VALUES ('23', '4', 'NO', '04', '22');
INSERT INTO flowssteps VALUES ('24', '4', 'NO', '05', '23');
INSERT INTO flowssteps VALUES ('25', '2', 'NO', '01', '03');
INSERT INTO flowssteps VALUES ('26', '2', 'NO', '02', '04');
INSERT INTO flowssteps VALUES ('27', '2', 'NO', '03', '05');
INSERT INTO flowssteps VALUES ('28', '2', 'NO', '04', '07');
INSERT INTO flowssteps VALUES ('29', '2', 'NO', '05', '08');
INSERT INTO flowssteps VALUES ('30', '2', 'NO', '06', '09');
INSERT INTO flowssteps VALUES ('31', '2', 'NO', '07', '06');
INSERT INTO flowssteps VALUES ('32', '2', 'NO', '08', '18');
INSERT INTO flowssteps VALUES ('33', '2', 'NO', '09', '16');
INSERT INTO flowssteps VALUES ('34', '2', 'NO', '10', '13');
INSERT INTO flowssteps VALUES ('35', '2', 'NO', '11', '17');
INSERT INTO flowssteps VALUES ('36', '2', 'NO', '12', '17');
INSERT INTO flowssteps VALUES ('37', '3', 'NO', '01', '03');
INSERT INTO flowssteps VALUES ('38', '3', 'YES', '02', '04');
INSERT INTO flowssteps VALUES ('39', '3', 'NO', '03', '05');
INSERT INTO flowssteps VALUES ('40', '3', 'NO', '04', '06');
INSERT INTO flowssteps VALUES ('41', '3', 'NO', '05', '07');
INSERT INTO flowssteps VALUES ('42', '3', 'NO', '06', '08');
INSERT INTO flowssteps VALUES ('43', '3', 'YES', '07', '09');
INSERT INTO flowssteps VALUES ('44', '3', 'NO', '08', '18');
INSERT INTO flowssteps VALUES ('45', '3', 'NO', '09', '40');
INSERT INTO flowssteps VALUES ('46', '3', 'NO', '10', '16');
INSERT INTO flowssteps VALUES ('47', '3', 'NO', '11', '13');
INSERT INTO flowssteps VALUES ('48', '3', 'NO', '12', '13');
INSERT INTO flowssteps VALUES ('49', '3', 'YES', '13', '17');
INSERT INTO flowssteps VALUES ('50', '5', 'NO', '01', '26');
INSERT INTO flowssteps VALUES ('51', '5', 'NO', '02', '27');
INSERT INTO flowssteps VALUES ('52', '5', 'NO', '03', '28');
INSERT INTO flowssteps VALUES ('53', '5', 'NO', '04', '29');
INSERT INTO flowssteps VALUES ('54', '5', 'NO', '05', '30');
INSERT INTO flowssteps VALUES ('55', '5', 'NO', '06', '43');
INSERT INTO flowssteps VALUES ('56', '6', 'NO', '01', '26');
INSERT INTO flowssteps VALUES ('57', '6', 'NO', '02', '30');
INSERT INTO flowssteps VALUES ('58', '5', 'NO', '03', '43');
INSERT INTO flowssteps VALUES ('59', '7', 'NO', '01', '31');
INSERT INTO flowssteps VALUES ('60', '7', 'NO', '02', '32');
INSERT INTO flowssteps VALUES ('61', '7', 'NO', '03', '33');
INSERT INTO flowssteps VALUES ('62', '7', 'NO', '04', '34');
INSERT INTO flowssteps VALUES ('63', '7', 'NO', '05', '35');
INSERT INTO flowssteps VALUES ('64', '7', 'NO', '06', '36');
INSERT INTO flowssteps VALUES ('65', '8', 'NO', '01', '37');
INSERT INTO flowssteps VALUES ('66', '8', 'NO', '02', '38');
INSERT INTO flowssteps VALUES ('67', '8', 'NO', '03', '39');
INSERT INTO flowssteps VALUES ('68', '9', 'NO', '01', '44');
INSERT INTO flowssteps VALUES ('69', '9', 'NO', '02', '45');
INSERT INTO flowssteps VALUES ('70', '9', 'NO', '03', '46');
INSERT INTO flowssteps VALUES ('71', '10', 'NO', '01', '47');
INSERT INTO flowssteps VALUES ('72', '10', 'NO', '02', '48');
INSERT INTO flowssteps VALUES ('73', '10', 'NO', '03', '49');

-- ----------------------------
-- Table structure for `loantype`
-- ----------------------------
DROP TABLE IF EXISTS `loantype`;
CREATE TABLE `loantype` (
  `loanTypeId` varchar(5) NOT NULL,
  `loanTypeName` varchar(16) NOT NULL,
  `parentId` varchar(5) DEFAULT NULL,
  `passagewayable` varchar(3) NOT NULL,
  `searchFlag` varchar(16) DEFAULT NULL,
  `surveyReportTypeId` int(11) DEFAULT NULL,
  `versionable` varchar(3) NOT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`loanTypeId`),
  UNIQUE KEY `loanTypeId` (`loanTypeId`),
  KEY `FK7269346A5B01F762` (`surveyReportTypeId`),
  CONSTRAINT `FK7269346A5B01F762` FOREIGN KEY (`surveyReportTypeId`) REFERENCES `enterprisecd` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loantype
-- ----------------------------
INSERT INTO loantype VALUES ('A', '综合授信', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('B', '流贷', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('C', '委托贷款', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('D', '长期贷款', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('E', '国际贸易融资', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('E1', '进口开证', 'E', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('E2', '进出口押汇', 'E', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('E3', '打包贷款', 'E', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('F', '国内贸易融资', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('F1', '承兑汇票', 'F', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('F2', '国内信用证', 'F', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G', '保函', null, 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G1', '保函授信', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G2', '投标保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G3', '预付款保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G4', '质量保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G5', '支付保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G6', '履约保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('G7', '其他保函', 'G', 'NO', '2', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('H', '司法担保', null, 'NO', '3', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('I', '其他类', null, 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('I1', '个人助业贷款', 'I', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('I2', '集合债', 'I', 'NO', '1', null, 'NO', 'YES');
INSERT INTO loantype VALUES ('I9', '其他担保', 'I', 'NO', '1', null, 'NO', 'YES');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `menuName` varchar(20) NOT NULL,
  `menuUrl` varchar(125) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO menu VALUES ('1', '企业咨询', '', null);
INSERT INTO menu VALUES ('2', '企业咨询', 'control/consulation/ConsulationAction.action', '1');
INSERT INTO menu VALUES ('3', '立项核准', 'control/consulation/ApprovalAction.action', '1');
INSERT INTO menu VALUES ('4', '立项评审', '', null);
INSERT INTO menu VALUES ('5', '项目调查(A角)', 'control/consulation/SurveyAReportAction.action', '4');
INSERT INTO menu VALUES ('6', '项目调查(B角)', 'control/consulation/SurveyBReportAction.action', '4');
INSERT INTO menu VALUES ('7', '部门经理审查', 'control/consulation/SurveyDepartManagerAction.action', '4');
INSERT INTO menu VALUES ('8', 'AB角色变更', 'control/consulation/ABReplaceAction.action', '4');
INSERT INTO menu VALUES ('9', '分管领导审查', 'control/consulation/LeaderCheckAction.action', '4');
INSERT INTO menu VALUES ('10', '项目复审', 'control/consulation/ReviewAndLawerCheckAction.action', '4');
INSERT INTO menu VALUES ('11', '法务审查', 'control/consulation/ReviewAndLawerCheckAction_executefwsh.action', '4');
INSERT INTO menu VALUES ('12', '风控经理审查', 'control/consulation/WindControlManagerCheckAction.action', '4');
INSERT INTO menu VALUES ('13', '项目审批', '', null);
INSERT INTO menu VALUES ('14', '上会项目一览', 'control/assessment/ProjectOverViewAction.action', '13');
INSERT INTO menu VALUES ('15', '快速通道项目', 'control/assessment/FastChanelAction.action', '13');
INSERT INTO menu VALUES ('16', '办公会项目', 'control/assessment/OfficeAction.action', '13');
INSERT INTO menu VALUES ('17', '审报会日程安排', 'control/assessment/OverviewScheduleAction.action', '13');
INSERT INTO menu VALUES ('18', '上会日程安排', 'control/assessment/OfficeScheduleAction.action', '13');
INSERT INTO menu VALUES ('19', '审批处理', 'control/assessment/ApproveAction.action', '13');
INSERT INTO menu VALUES ('20', '项目经理确认', 'control/assessment/ProjectConfirmAction.action', '13');
INSERT INTO menu VALUES ('21', '审保主任确认', 'control/assessment/SecurityDirectorConfirmAction.action', '13');
INSERT INTO menu VALUES ('22', '业务分管领导审批', 'control/assessment/YWDepartmentLeaderApproveAction.action', '13');
INSERT INTO menu VALUES ('23', '风控分管领导审批', 'control/assessment/FKDepartmentLeaderApproveAction.action', '13');
INSERT INTO menu VALUES ('24', '总经理审批', 'control/assessment/GMApproveAction.action', '13');
INSERT INTO menu VALUES ('25', '执行单做成', 'control/assessment/ZhixindanAction.action', '13');
INSERT INTO menu VALUES ('26', '签约承保', '', null);
INSERT INTO menu VALUES ('27', '签约申请', 'control/signed/SignedApplyAction.action', '26');
INSERT INTO menu VALUES ('28', '部门签约审批', 'control/signed/DepartmentSignedApproveAction.action', '26');
INSERT INTO menu VALUES ('29', '放款人签约审批', 'control/signed/LenderSignedApproveAction.action', '26');
INSERT INTO menu VALUES ('30', '风控部签约审批', 'control/signed/RiskControlManagerApproveAction.action', '26');
INSERT INTO menu VALUES ('31', '总经理签约审批', 'control/signed/GmSignedApproveAction.action', '26');
INSERT INTO menu VALUES ('32', '放款申请', 'control/loans/LoansApplyAction.action', '26');
INSERT INTO menu VALUES ('33', '部门放款审批', 'control/loans/DepartmentLoansApproveAction.action', '26');
INSERT INTO menu VALUES ('34', '复审放款审批', 'control/loans/ReviewLoansApproveAction.action', '26');
INSERT INTO menu VALUES ('35', '放款人放款审批', 'control/loans/LenderLoansApproveAction.action', '26');
INSERT INTO menu VALUES ('36', '风控部放款审批', 'control/loans/RiskControlManagerApproveAction.action', '26');
INSERT INTO menu VALUES ('37', '总经理放款审批', 'control/loans/GMLoansApproveAction.action', '26');
INSERT INTO menu VALUES ('38', '放款确认', 'control/loans/LoansConfirmAction.action', '26');
INSERT INTO menu VALUES ('39', '保费收取申请', 'control/charge/PremiumChargeAction.action', '26');
INSERT INTO menu VALUES ('40', '保费收取确认', 'control/charge/PremiumChargeReviewAction.action', '26');
INSERT INTO menu VALUES ('41', '财务保费收取', 'control/charge/FinancialChargeAction.action', '26');
INSERT INTO menu VALUES ('42', '保后管理', '', null);
INSERT INTO menu VALUES ('43', '监管记录', '', '42');
INSERT INTO menu VALUES ('44', '重点监管', '', '42');
INSERT INTO menu VALUES ('45', '重点解除审批', '', '42');
INSERT INTO menu VALUES ('46', '项目预警申请', '', '42');
INSERT INTO menu VALUES ('47', '项目预警审批', '', '42');
INSERT INTO menu VALUES ('48', '追踪报告', '', '42');
INSERT INTO menu VALUES ('49', '项目分类', '', '42');
INSERT INTO menu VALUES ('50', '项目逾期', '', '42');
INSERT INTO menu VALUES ('51', '统计汇总', '', '42');
INSERT INTO menu VALUES ('52', '调度会简报', '', '42');
INSERT INTO menu VALUES ('53', '担保终结', '', null);
INSERT INTO menu VALUES ('54', '解除申请', '', '53');
INSERT INTO menu VALUES ('55', '解除审核', '', '53');
INSERT INTO menu VALUES ('56', '退费申请', '', '53');
INSERT INTO menu VALUES ('57', '退费审批', '', '53');
INSERT INTO menu VALUES ('58', '代偿管理', '', null);
INSERT INTO menu VALUES ('59', '代偿申请', '', '58');
INSERT INTO menu VALUES ('60', '代偿审批', '', '58');
INSERT INTO menu VALUES ('61', '追偿申请', '', '58');
INSERT INTO menu VALUES ('62', '追偿审批', '', '58');
INSERT INTO menu VALUES ('63', '追偿收支', '', '58');
INSERT INTO menu VALUES ('64', '追偿记录', '', '58');
INSERT INTO menu VALUES ('65', '档案管理', '', null);
INSERT INTO menu VALUES ('66', '项目档案管理', 'control/file/ProjectFileAction.action', '65');
INSERT INTO menu VALUES ('67', '法律档案管理', 'control/file/LeagalFileAction.action', '65');
INSERT INTO menu VALUES ('68', '终结档案管理', 'control/file/TerminateFileAction.action', '65');
INSERT INTO menu VALUES ('69', '押品管理', '', null);
INSERT INTO menu VALUES ('70', '押品查询', '', '69');
INSERT INTO menu VALUES ('71', '解押申请', '', '69');
INSERT INTO menu VALUES ('72', '解押审批', '', '69');
INSERT INTO menu VALUES ('73', '情况变化说明', '', null);
INSERT INTO menu VALUES ('74', '审批项目', '', '73');
INSERT INTO menu VALUES ('75', '变更结果统计', '', '73');
INSERT INTO menu VALUES ('76', '修改执行单', '', '73');
INSERT INTO menu VALUES ('77', '公司项目库', '', null);
INSERT INTO menu VALUES ('78', '咨询项目查询', '', '77');
INSERT INTO menu VALUES ('79', '立项项目查询', '', '77');
INSERT INTO menu VALUES ('80', '审批项目查询', '', '77');
INSERT INTO menu VALUES ('81', '承保项目查询', '', '77');
INSERT INTO menu VALUES ('82', '代偿项目查询', '', '77');
INSERT INTO menu VALUES ('83', '统计报表管理', '', null);
INSERT INTO menu VALUES ('84', '咨询项目查询', '', '83');
INSERT INTO menu VALUES ('85', '系统设置', '', null);
INSERT INTO menu VALUES ('86', '系统消息管理', 'control/notice/NoticeAction.action', '85');
INSERT INTO menu VALUES ('87', '部门管理', 'control/organization/OrganizationAction.action', '85');
INSERT INTO menu VALUES ('88', '角色管理', 'control/role/RoleAction.action', '85');
INSERT INTO menu VALUES ('89', '员工管理', 'control/user/UserAction.action', '85');
INSERT INTO menu VALUES ('90', '菜单管理', 'control/menu/MenuAction.action', '85');
INSERT INTO menu VALUES ('91', '步骤阶段管理', 'control/step/StageAction.action', '85');
INSERT INTO menu VALUES ('92', '步骤管理', 'control/step/StepAction.action', '85');
INSERT INTO menu VALUES ('93', '员工关系管理', 'control/relation/RelationAction.action', '85');
INSERT INTO menu VALUES ('94', '流程管理', 'control/step/FlowAction.action', '85');
INSERT INTO menu VALUES ('95', '担保种类', 'control/loantype/LoanTypeAction.action', '85');
INSERT INTO menu VALUES ('96', '银行管理', 'control/bank/BankAction.action', '85');
INSERT INTO menu VALUES ('97', '项目Code管理', 'control/enterprise/EnterpriseCDAction.action', '85');
INSERT INTO menu VALUES ('98', '项目号策略管理', 'control/projectNoStrategy/ProjectNoStrategyAction.action', '85');
INSERT INTO menu VALUES ('99', '投票规则管理', 'control/vote/VoteAction.action', '85');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(256) DEFAULT NULL,
  `countFiles` int(11) DEFAULT NULL,
  `isImportent` int(11) DEFAULT NULL,
  `isNew` int(11) DEFAULT NULL,
  `msgDate` date DEFAULT NULL,
  `msgInDate` int(11) DEFAULT NULL,
  `msgMan` varchar(16) DEFAULT NULL,
  `title` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for `noticesusers`
-- ----------------------------
DROP TABLE IF EXISTS `noticesusers`;
CREATE TABLE `noticesusers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isRead` varchar(3) DEFAULT NULL,
  `noticeId` int(11) DEFAULT NULL,
  `userId` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3CAD564DABA64A78` (`noticeId`),
  KEY `FK3CAD564D297F5058` (`userId`),
  CONSTRAINT `FK3CAD564D297F5058` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK3CAD564DABA64A78` FOREIGN KEY (`noticeId`) REFERENCES `notice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of noticesusers
-- ----------------------------

-- ----------------------------
-- Table structure for `officeschedule`
-- ----------------------------
DROP TABLE IF EXISTS `officeschedule`;
CREATE TABLE `officeschedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `absentNumbers` int(11) DEFAULT NULL,
  `advanceTime` datetime NOT NULL,
  `agreeNumbers` int(11) DEFAULT NULL,
  `apposeNumbers` int(11) DEFAULT NULL,
  `entipriseName` varchar(60) DEFAULT NULL,
  `indexNo` int(11) NOT NULL,
  `itemType` varchar(11) DEFAULT NULL,
  `officenumber` int(11) NOT NULL,
  `operatorId` varchar(10) DEFAULT NULL,
  `projectNo` varchar(10) NOT NULL,
  `reAgreeNumbers` int(11) DEFAULT NULL,
  `reApposeNumbers` int(11) DEFAULT NULL,
  `reconsiderNumbers` int(11) DEFAULT NULL,
  `reresult` varchar(10) DEFAULT NULL,
  `result` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officeschedule
-- ----------------------------

-- ----------------------------
-- Table structure for `officeschedule_user`
-- ----------------------------
DROP TABLE IF EXISTS `officeschedule_user`;
CREATE TABLE `officeschedule_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isReConsider` bit(1) DEFAULT NULL,
  `officeScheduleId` int(11) DEFAULT NULL,
  `suggestionType` varchar(1) NOT NULL,
  `userId` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE2241717406065F1` (`officeScheduleId`),
  KEY `FKE2241717297F5058` (`userId`),
  CONSTRAINT `FKE2241717297F5058` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKE2241717406065F1` FOREIGN KEY (`officeScheduleId`) REFERENCES `officeschedule` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of officeschedule_user
-- ----------------------------

-- ----------------------------
-- Table structure for `organization`
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `orgNo` varchar(1) NOT NULL,
  `orgName` varchar(10) NOT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`orgNo`),
  UNIQUE KEY `orgNo` (`orgNo`),
  UNIQUE KEY `orgName` (`orgName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO organization VALUES ('A', '系统管理员', 'YES');
INSERT INTO organization VALUES ('B', '业务一部', 'YES');
INSERT INTO organization VALUES ('C', '业务二部', 'YES');
INSERT INTO organization VALUES ('D', '业务三部', 'YES');
INSERT INTO organization VALUES ('E', '风险控制部门', 'YES');
INSERT INTO organization VALUES ('F', '行政部', 'YES');
INSERT INTO organization VALUES ('G', '公司发展部', 'YES');
INSERT INTO organization VALUES ('H', '总经理办公会', 'YES');
INSERT INTO organization VALUES ('I', '董事长', 'YES');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permission_Id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NOT NULL,
  `role_id` varchar(11) NOT NULL,
  PRIMARY KEY (`permission_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO permission VALUES ('1', '85', 'A');
INSERT INTO permission VALUES ('2', '87', 'A');
INSERT INTO permission VALUES ('3', '88', 'A');
INSERT INTO permission VALUES ('4', '89', 'A');
INSERT INTO permission VALUES ('5', '90', 'A');
INSERT INTO permission VALUES ('6', '91', 'A');
INSERT INTO permission VALUES ('7', '92', 'A');
INSERT INTO permission VALUES ('8', '93', 'A');
INSERT INTO permission VALUES ('9', '94', 'A');
INSERT INTO permission VALUES ('10', '95', 'A');
INSERT INTO permission VALUES ('11', '96', 'A');
INSERT INTO permission VALUES ('12', '97', 'A');
INSERT INTO permission VALUES ('13', '98', 'A');
INSERT INTO permission VALUES ('14', '86', 'A');
INSERT INTO permission VALUES ('15', '99', 'A');
INSERT INTO permission VALUES ('16', '24', 'C');
INSERT INTO permission VALUES ('18', '13', 'C');
INSERT INTO permission VALUES ('19', '31', 'C');
INSERT INTO permission VALUES ('20', '37', 'C');
INSERT INTO permission VALUES ('21', '26', 'C');
INSERT INTO permission VALUES ('22', '3', 'E');
INSERT INTO permission VALUES ('23', '1', 'E');
INSERT INTO permission VALUES ('24', '4', 'E');
INSERT INTO permission VALUES ('25', '7', 'E');
INSERT INTO permission VALUES ('26', '8', 'E');
INSERT INTO permission VALUES ('28', '26', 'E');
INSERT INTO permission VALUES ('29', '28', 'E');
INSERT INTO permission VALUES ('30', '33', 'E');
INSERT INTO permission VALUES ('31', '4', 'F');
INSERT INTO permission VALUES ('32', '9', 'F');
INSERT INTO permission VALUES ('33', '13', 'F');
INSERT INTO permission VALUES ('34', '22', 'F');
INSERT INTO permission VALUES ('35', '12', 'H');
INSERT INTO permission VALUES ('36', '4', 'H');
INSERT INTO permission VALUES ('37', '11', 'I');
INSERT INTO permission VALUES ('38', '4', 'I');
INSERT INTO permission VALUES ('42', '67', 'I');
INSERT INTO permission VALUES ('43', '66', 'I');
INSERT INTO permission VALUES ('44', '10', 'J');
INSERT INTO permission VALUES ('45', '4', 'J');
INSERT INTO permission VALUES ('46', '34', 'J');
INSERT INTO permission VALUES ('47', '26', 'J');
INSERT INTO permission VALUES ('48', '66', 'J');
INSERT INTO permission VALUES ('49', '67', 'J');
INSERT INTO permission VALUES ('50', '65', 'L');
INSERT INTO permission VALUES ('51', '66', 'L');
INSERT INTO permission VALUES ('52', '67', 'L');
INSERT INTO permission VALUES ('53', '65', 'M');
INSERT INTO permission VALUES ('54', '66', 'M');
INSERT INTO permission VALUES ('55', '67', 'M');
INSERT INTO permission VALUES ('57', '65', 'O');
INSERT INTO permission VALUES ('58', '66', 'O');
INSERT INTO permission VALUES ('59', '67', 'O');
INSERT INTO permission VALUES ('60', '13', 'P');
INSERT INTO permission VALUES ('61', '21', 'P');
INSERT INTO permission VALUES ('62', '23', 'R');
INSERT INTO permission VALUES ('63', '13', 'R');
INSERT INTO permission VALUES ('64', '30', 'H');
INSERT INTO permission VALUES ('65', '36', 'H');
INSERT INTO permission VALUES ('66', '26', 'H');
INSERT INTO permission VALUES ('67', '13', 'T');
INSERT INTO permission VALUES ('68', '18', 'T');
INSERT INTO permission VALUES ('69', '19', 'T');
INSERT INTO permission VALUES ('70', '25', 'T');
INSERT INTO permission VALUES ('71', '1', 'G');
INSERT INTO permission VALUES ('72', '2', 'G');
INSERT INTO permission VALUES ('73', '4', 'G');
INSERT INTO permission VALUES ('74', '5', 'G');
INSERT INTO permission VALUES ('75', '6', 'G');
INSERT INTO permission VALUES ('76', '13', 'G');
INSERT INTO permission VALUES ('77', '20', 'G');
INSERT INTO permission VALUES ('78', '27', 'G');
INSERT INTO permission VALUES ('79', '32', 'G');
INSERT INTO permission VALUES ('80', '65', 'G');
INSERT INTO permission VALUES ('81', '66', 'G');
INSERT INTO permission VALUES ('82', '67', 'G');

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accepter_id` varchar(10) DEFAULT NULL,
  `bank1Children_id` varchar(5) DEFAULT NULL,
  `bank1_id` varchar(5) DEFAULT NULL,
  `bank2Children_id` varchar(5) DEFAULT NULL,
  `bank2_id` varchar(5) DEFAULT NULL,
  `beginSurveyDate` date DEFAULT NULL,
  `confirmationDate` date DEFAULT NULL,
  `consulationDate` date DEFAULT NULL,
  `cooperationBank` varchar(32) DEFAULT NULL,
  `createJob` int(11) DEFAULT NULL,
  `createRevenue` double DEFAULT NULL,
  `enterprise_id` int(11) DEFAULT NULL,
  `fdbAction` longtext,
  `flow_id` int(11) DEFAULT NULL,
  `guaranteeIssue` varchar(60) DEFAULT NULL,
  `lgName1` varchar(16) DEFAULT NULL,
  `lgName2` varchar(16) DEFAULT NULL,
  `loanAmount` double DEFAULT NULL,
  `loanExpires` int(11) DEFAULT NULL,
  `loanRate` double DEFAULT NULL,
  `loanTypeChildren_id` varchar(11) DEFAULT NULL,
  `loanType_id` varchar(11) DEFAULT NULL,
  `loanUse` longtext,
  `loanUseage` longtext,
  `newProject` varchar(1) DEFAULT NULL,
  `orgNo` varchar(1) DEFAULT NULL,
  `otherWayContent` varchar(32) DEFAULT NULL,
  `projectARoleId` varchar(5) DEFAULT NULL,
  `projectBRoleId` varchar(5) DEFAULT NULL,
  `projectNo` varchar(10) DEFAULT NULL,
  `relation_id` varchar(5) DEFAULT NULL,
  `sourceAndPlan` longtext,
  `source_id` int(11) DEFAULT NULL,
  `strategyId` int(11) DEFAULT NULL,
  `surveyWay` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK50C8E2F9B78882BE` (`source_id`),
  KEY `FK50C8E2F9E5185EDE` (`bank1_id`),
  KEY `FK50C8E2F98120D817` (`accepter_id`),
  KEY `FK50C8E2F965D68738` (`loanTypeChildren_id`),
  KEY `FK50C8E2F9E046D6DE` (`bank2Children_id`),
  KEY `FK50C8E2F969968B00` (`flow_id`),
  KEY `FK50C8E2F9CE2ABE10` (`relation_id`),
  KEY `FK50C8E2F980980F97` (`loanType_id`),
  KEY `FK50C8E2F9E518D33D` (`bank2_id`),
  KEY `FK50C8E2F9103FB0D7` (`enterprise_id`),
  KEY `FK50C8E2F93FEA5C3F` (`orgNo`),
  KEY `FK50C8E2F9D895317F` (`bank1Children_id`),
  CONSTRAINT `FK50C8E2F9D895317F` FOREIGN KEY (`bank1Children_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK50C8E2F9103FB0D7` FOREIGN KEY (`enterprise_id`) REFERENCES `enterprise` (`id`),
  CONSTRAINT `FK50C8E2F93FEA5C3F` FOREIGN KEY (`orgNo`) REFERENCES `organization` (`orgNo`),
  CONSTRAINT `FK50C8E2F965D68738` FOREIGN KEY (`loanTypeChildren_id`) REFERENCES `loantype` (`loanTypeId`),
  CONSTRAINT `FK50C8E2F969968B00` FOREIGN KEY (`flow_id`) REFERENCES `flow` (`flowId`),
  CONSTRAINT `FK50C8E2F980980F97` FOREIGN KEY (`loanType_id`) REFERENCES `loantype` (`loanTypeId`),
  CONSTRAINT `FK50C8E2F98120D817` FOREIGN KEY (`accepter_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK50C8E2F9B78882BE` FOREIGN KEY (`source_id`) REFERENCES `enterprisecd` (`id`),
  CONSTRAINT `FK50C8E2F9CE2ABE10` FOREIGN KEY (`relation_id`) REFERENCES `relation` (`projectManagerId`),
  CONSTRAINT `FK50C8E2F9E046D6DE` FOREIGN KEY (`bank2Children_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK50C8E2F9E5185EDE` FOREIGN KEY (`bank1_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK50C8E2F9E518D33D` FOREIGN KEY (`bank2_id`) REFERENCES `bank` (`bankId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO project VALUES ('1', '00006', null, '03', null, '05', null, '2011-06-27', '2011-06-27', null, null, null, '1', null, '1', null, '雷晓飞', '雷晓飞', '12', '12', null, null, 'B', null, '测试', null, 'B', null, '00006', '00040', '11B001', '00006', null, '5', '1', null);
INSERT INTO project VALUES ('2', '00006', null, '05', null, '03', null, '2011-06-27', '2011-06-27', null, null, null, '2', null, '1', null, '周方年', '周方年', '1212', '21', null, null, 'B', null, '测试', null, 'B', null, '00006', '00040', '11B002', '00006', null, '3', '1', null);

-- ----------------------------
-- Table structure for `projectapproval`
-- ----------------------------
DROP TABLE IF EXISTS `projectapproval`;
CREATE TABLE `projectapproval` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acceptor` varchar(20) DEFAULT NULL,
  `acceptorState` longtext,
  `actionDescription` longtext,
  `confirmation` varchar(1) DEFAULT NULL,
  `controlAction` varchar(5) DEFAULT NULL,
  `controlObject` varchar(5) DEFAULT NULL,
  `detailState` longtext,
  `insurance` varchar(1) DEFAULT NULL,
  `isReview` varchar(1) DEFAULT NULL,
  `loanCondition` int(11) DEFAULT NULL,
  `loanConditionstate1` longtext,
  `loanConditionstate2` longtext,
  `operatorName` varchar(50) DEFAULT NULL,
  `otherConditions` longtext,
  `otherState` longtext,
  `other_request` longtext,
  `payment` varchar(1) DEFAULT NULL,
  `plansreturn` varchar(100) DEFAULT NULL,
  `processControlDescription` longtext,
  `projectName` varchar(60) NOT NULL,
  `projectNo` varchar(10) NOT NULL,
  `relatedProjectNo` varchar(10) DEFAULT NULL,
  `repayment` varchar(1) DEFAULT NULL,
  `sbhNumber` int(11) NOT NULL,
  `superviseSchema` longtext,
  `usageDescription` longtext,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projectNo` (`projectNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectapproval
-- ----------------------------

-- ----------------------------
-- Table structure for `projectdocument`
-- ----------------------------
DROP TABLE IF EXISTS `projectdocument`;
CREATE TABLE `projectdocument` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `banks` varchar(100) DEFAULT NULL,
  `beneficiary` varchar(50) DEFAULT NULL,
  `enterpriseName` varchar(50) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `projectNo` varchar(10) DEFAULT NULL,
  `projectOperator` varchar(20) DEFAULT NULL,
  `step_id` varchar(255) DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectdocument
-- ----------------------------

-- ----------------------------
-- Table structure for `projectfile`
-- ----------------------------
DROP TABLE IF EXISTS `projectfile`;
CREATE TABLE `projectfile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currencyId` varchar(3) DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `fileCount` varchar(3) DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `fileNo` varchar(20) DEFAULT NULL,
  `flag` varchar(1) DEFAULT NULL,
  `loansAmount` double DEFAULT NULL,
  `remark` longtext,
  `rmbLoansAmount` double DEFAULT NULL,
  `signApplyId` int(11) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2B5E281586E884E8` (`signApplyId`),
  KEY `FK2B5E2815C5F38AB3` (`currencyId`),
  CONSTRAINT `FK2B5E2815C5F38AB3` FOREIGN KEY (`currencyId`) REFERENCES `currency` (`id`),
  CONSTRAINT `FK2B5E281586E884E8` FOREIGN KEY (`signApplyId`) REFERENCES `signedapply` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectfile
-- ----------------------------

-- ----------------------------
-- Table structure for `projectimplementation`
-- ----------------------------
DROP TABLE IF EXISTS `projectimplementation`;
CREATE TABLE `projectimplementation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acceptor` varchar(20) DEFAULT NULL,
  `acceptorState` longtext,
  `actionDescription` longtext,
  `confirmation` varchar(1) DEFAULT NULL,
  `controlAction` varchar(5) DEFAULT NULL,
  `controlObject` varchar(5) DEFAULT NULL,
  `detailState` longtext,
  `insurance` varchar(1) DEFAULT NULL,
  `isReview` varchar(1) DEFAULT NULL,
  `loanCondition` int(11) DEFAULT NULL,
  `loanConditionstate1` longtext,
  `loanConditionstate2` longtext,
  `operatorName` varchar(50) DEFAULT NULL,
  `otherConditions` longtext,
  `otherState` longtext,
  `other_request` longtext,
  `payment` varchar(1) DEFAULT NULL,
  `plansreturn` varchar(100) DEFAULT NULL,
  `processControlDescription` longtext,
  `projectName` varchar(60) NOT NULL,
  `projectNo` varchar(10) NOT NULL,
  `relatedProjectNo` varchar(10) DEFAULT NULL,
  `repayment` varchar(1) DEFAULT NULL,
  `sbhNumber` int(11) NOT NULL,
  `superviseSchema` longtext,
  `usageDescription` longtext,
  `bank1` tinyblob,
  `bank1children` tinyblob,
  `bank2` tinyblob,
  `bank2children` tinyblob,
  `bank3` tinyblob,
  `bank3children` tinyblob,
  `beneficiary` tinyblob,
  `bank1_id` varchar(5) DEFAULT NULL,
  `bank1children_id` varchar(5) DEFAULT NULL,
  `bank2_id` varchar(5) DEFAULT NULL,
  `bank2children_id` varchar(5) DEFAULT NULL,
  `bank3_id` varchar(5) DEFAULT NULL,
  `bank3children_id` varchar(5) DEFAULT NULL,
  `beneficiary_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projectNo` (`projectNo`),
  KEY `FK959C330BE5185EDE` (`bank1_id`),
  KEY `FK959C330BE046D6DE` (`bank2children_id`),
  KEY `FK959C330BE7F87C3D` (`bank3children_id`),
  KEY `FK959C330BE519479C` (`bank3_id`),
  KEY `FK959C330BE518D33D` (`bank2_id`),
  KEY `FK959C330BD895317F` (`bank1children_id`),
  KEY `FK959C330BA858B2E7` (`beneficiary_id`),
  CONSTRAINT `FK959C330BA858B2E7` FOREIGN KEY (`beneficiary_id`) REFERENCES `user` (`userId`),
  CONSTRAINT `FK959C330BD895317F` FOREIGN KEY (`bank1children_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK959C330BE046D6DE` FOREIGN KEY (`bank2children_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK959C330BE5185EDE` FOREIGN KEY (`bank1_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK959C330BE518D33D` FOREIGN KEY (`bank2_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK959C330BE519479C` FOREIGN KEY (`bank3_id`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK959C330BE7F87C3D` FOREIGN KEY (`bank3children_id`) REFERENCES `bank` (`bankId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectimplementation
-- ----------------------------

-- ----------------------------
-- Table structure for `projectnostrategy`
-- ----------------------------
DROP TABLE IF EXISTS `projectnostrategy`;
CREATE TABLE `projectnostrategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customPrefix` varchar(32) DEFAULT NULL,
  `demo` varchar(64) DEFAULT NULL,
  `isDepartNoUserable` varchar(3) DEFAULT NULL,
  `numberFilter` varchar(32) DEFAULT NULL,
  `prefix` varchar(32) DEFAULT NULL,
  `sequence` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectnostrategy
-- ----------------------------
INSERT INTO projectnostrategy VALUES ('1', null, '默认策略', 'YES', null, 'LASTTOW', '3');

-- ----------------------------
-- Table structure for `projectsteptemp`
-- ----------------------------
DROP TABLE IF EXISTS `projectsteptemp`;
CREATE TABLE `projectsteptemp` (
  `stepId` varchar(5) NOT NULL,
  `projectId` int(11) NOT NULL,
  PRIMARY KEY (`stepId`,`projectId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectsteptemp
-- ----------------------------

-- ----------------------------
-- Table structure for `projectsubflow`
-- ----------------------------
DROP TABLE IF EXISTS `projectsubflow`;
CREATE TABLE `projectsubflow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flowId` int(11) NOT NULL,
  `projectId` int(11) NOT NULL,
  `type` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK85AC2E556351FB70` (`projectId`),
  CONSTRAINT `FK85AC2E556351FB70` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of projectsubflow
-- ----------------------------
INSERT INTO projectsubflow VALUES ('1', '9', '1', '档案管理子流程');
INSERT INTO projectsubflow VALUES ('2', '9', '2', '档案管理子流程');

-- ----------------------------
-- Table structure for `relation`
-- ----------------------------
DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `projectManagerId` varchar(5) NOT NULL,
  `cashierId` varchar(5) NOT NULL,
  `cashierName` varchar(32) NOT NULL,
  `collateralManagerId` varchar(5) NOT NULL,
  `collateralManagerName` varchar(32) NOT NULL,
  `contactManagerId` varchar(5) NOT NULL,
  `contactManagerId_Z` varchar(5) NOT NULL,
  `contactManagerName` varchar(32) NOT NULL,
  `contactManagerName_Z` varchar(32) NOT NULL,
  `departLeaderId` varchar(5) NOT NULL,
  `departLeaderName` varchar(32) NOT NULL,
  `departManagerId` varchar(5) NOT NULL,
  `departManagerName` varchar(32) NOT NULL,
  `extendLoanerId` varchar(5) NOT NULL,
  `extendLoanerName` varchar(32) NOT NULL,
  `generalManagerId` varchar(5) NOT NULL,
  `generalManagerName` varchar(32) NOT NULL,
  `lawerId` varchar(5) NOT NULL,
  `lawerName` varchar(32) NOT NULL,
  `officeSecretaryId` varchar(5) NOT NULL,
  `officeSecretaryName` varchar(32) NOT NULL,
  `orgId` varchar(255) NOT NULL,
  `orgName` varchar(32) NOT NULL,
  `projectManagerName` varchar(32) NOT NULL,
  `recoveryStaffId` varchar(5) NOT NULL,
  `recoveryStaffName` varchar(32) NOT NULL,
  `remark` varchar(225) DEFAULT NULL,
  `reviewId` varchar(5) NOT NULL,
  `reviewName` varchar(32) NOT NULL,
  `securityDirectorId` varchar(5) NOT NULL,
  `securityDirectorName` varchar(32) NOT NULL,
  `securitySecretaryId` varchar(5) NOT NULL,
  `securitySecretaryName` varchar(32) NOT NULL,
  `securitySupervisionId` varchar(5) NOT NULL,
  `securitySupervisionName` varchar(32) NOT NULL,
  `windControlManagerId` varchar(5) NOT NULL,
  `windControlManagerName` varchar(32) NOT NULL,
  `windLeaderId` varchar(5) NOT NULL,
  `windLeaderName` varchar(32) NOT NULL,
  PRIMARY KEY (`projectManagerId`),
  UNIQUE KEY `projectManagerId` (`projectManagerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of relation
-- ----------------------------
INSERT INTO relation VALUES ('00006', '00028', '潘莉', '00023', '储莺歌', '00025', '00029', '陈香', '荣卉颍', '00005', '杨希亨', '00006', '张月', '00025', '陈香', '00002', '杨玉坤', '00024', '崔志', '00030', '郭野飞', 'B', '业务一部', '张月', '00026', '李春阳', '', '00026', '李春阳', '00005', '杨希亨', '00024', '崔志', '00027', '陈晓光', '00022', '戴谦', '00022', '戴谦');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` varchar(2) NOT NULL,
  `roleName` varchar(16) NOT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `roleId` (`roleId`),
  UNIQUE KEY `roleName` (`roleName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('A', '系统管理员', 'YES');
INSERT INTO role VALUES ('B', '董事长', 'YES');
INSERT INTO role VALUES ('C', '总经理', 'YES');
INSERT INTO role VALUES ('D', '副总经理', 'YES');
INSERT INTO role VALUES ('E', '业务部经理 ', 'YES');
INSERT INTO role VALUES ('F', '分管领导(业)', 'YES');
INSERT INTO role VALUES ('G', '项目经理', 'YES');
INSERT INTO role VALUES ('H', '风控部经理', 'YES');
INSERT INTO role VALUES ('I', '法务复审', 'YES');
INSERT INTO role VALUES ('J', '项目复审', 'YES');
INSERT INTO role VALUES ('K', '合同管理(风)', 'YES');
INSERT INTO role VALUES ('L', '追偿人员', 'YES');
INSERT INTO role VALUES ('M', '合同管理(综)', 'YES');
INSERT INTO role VALUES ('O', '出纳员', 'YES');
INSERT INTO role VALUES ('P', '审保会主任', 'YES');
INSERT INTO role VALUES ('Q', '审保委员', 'YES');
INSERT INTO role VALUES ('R', '分管领导(风)', 'YES');
INSERT INTO role VALUES ('S', '保后监管岗', 'YES');
INSERT INTO role VALUES ('T', '审保会秘书', 'YES');
INSERT INTO role VALUES ('U', '放款人', 'YES');
INSERT INTO role VALUES ('V', '办公会秘书', 'YES');
INSERT INTO role VALUES ('X', '押品管理人', 'YES');
INSERT INTO role VALUES ('Y', '行政主管', 'YES');

-- ----------------------------
-- Table structure for `sbhsuggestion`
-- ----------------------------
DROP TABLE IF EXISTS `sbhsuggestion`;
CREATE TABLE `sbhsuggestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `securityMemberDateTime` datetime DEFAULT NULL,
  `securityMemberName` varchar(20) DEFAULT NULL,
  `securityMemberState` varchar(10) DEFAULT NULL,
  `securityMemberSuggestion` varchar(225) DEFAULT NULL,
  `suggestion_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEECFAABD3B3A09F7` (`suggestion_id`),
  CONSTRAINT `FKEECFAABD3B3A09F7` FOREIGN KEY (`suggestion_id`) REFERENCES `suggestion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sbhsuggestion
-- ----------------------------

-- ----------------------------
-- Table structure for `shouxininfo`
-- ----------------------------
DROP TABLE IF EXISTS `shouxininfo`;
CREATE TABLE `shouxininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creditamount` varchar(20) DEFAULT NULL,
  `eachdate` varchar(5) DEFAULT NULL,
  `eachperiod` varchar(1) DEFAULT NULL,
  `premiumcharges` varchar(1) DEFAULT NULL,
  `premiumstandard` varchar(5) DEFAULT NULL,
  `projectImplementation_id` int(11) DEFAULT NULL,
  `projectNo` varchar(10) NOT NULL,
  `recovery` varchar(5) DEFAULT NULL,
  `releaseTime` varchar(5) DEFAULT NULL,
  `shouxinType` varchar(1) DEFAULT NULL,
  `standardpremium` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projectNo` (`projectNo`),
  KEY `FKCCDB1E70C032C12A` (`projectImplementation_id`),
  CONSTRAINT `FKCCDB1E70C032C12A` FOREIGN KEY (`projectImplementation_id`) REFERENCES `projectimplementation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shouxininfo
-- ----------------------------

-- ----------------------------
-- Table structure for `signedapply`
-- ----------------------------
DROP TABLE IF EXISTS `signedapply`;
CREATE TABLE `signedapply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `appNote` longtext,
  `bankId` varchar(5) DEFAULT NULL,
  `beneficiary` varchar(50) DEFAULT NULL,
  `deptDate` datetime DEFAULT NULL,
  `deptManagerId` varchar(5) DEFAULT NULL,
  `deptManagerState` varchar(1) DEFAULT NULL,
  `deptSuggestion` longtext,
  `gmDate` datetime DEFAULT NULL,
  `gmId` varchar(5) DEFAULT NULL,
  `gmState` varchar(1) DEFAULT NULL,
  `gmSuggestion` longtext,
  `loanTypeId` varchar(5) DEFAULT NULL,
  `loanerDate` datetime DEFAULT NULL,
  `loanerId` varchar(5) DEFAULT NULL,
  `loanerState` varchar(1) DEFAULT NULL,
  `loanerSuggestion` longtext,
  `projectId` int(11) DEFAULT NULL,
  `projectNo` varchar(6) DEFAULT NULL,
  `signedDate` date DEFAULT NULL,
  `subNo` varchar(3) DEFAULT NULL,
  `windControlManagerDate` datetime DEFAULT NULL,
  `windControlManagerId` varchar(5) DEFAULT NULL,
  `windControlManagerState` varchar(1) DEFAULT NULL,
  `windControlManagerSuggestion` longtext,
  PRIMARY KEY (`id`),
  KEY `FK4FD1DD926351FB70` (`projectId`),
  KEY `FK4FD1DD926325690C` (`loanTypeId`),
  KEY `FK4FD1DD92BD9310` (`bankId`),
  CONSTRAINT `FK4FD1DD92BD9310` FOREIGN KEY (`bankId`) REFERENCES `bank` (`bankId`),
  CONSTRAINT `FK4FD1DD926325690C` FOREIGN KEY (`loanTypeId`) REFERENCES `loantype` (`loanTypeId`),
  CONSTRAINT `FK4FD1DD926351FB70` FOREIGN KEY (`projectId`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of signedapply
-- ----------------------------

-- ----------------------------
-- Table structure for `spshouxininfo`
-- ----------------------------
DROP TABLE IF EXISTS `spshouxininfo`;
CREATE TABLE `spshouxininfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creditamount` varchar(20) DEFAULT NULL,
  `eachdate` varchar(5) DEFAULT NULL,
  `eachperiod` varchar(1) DEFAULT NULL,
  `premiumcharges` varchar(1) DEFAULT NULL,
  `premiumstandard` varchar(5) DEFAULT NULL,
  `projectApproval_id` int(11) DEFAULT NULL,
  `projectNo` varchar(10) NOT NULL,
  `recovery` varchar(5) DEFAULT NULL,
  `releaseTime` varchar(5) DEFAULT NULL,
  `shouxinType` varchar(1) DEFAULT NULL,
  `standardpremium` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `projectNo` (`projectNo`),
  KEY `FK88D9E7F3C59FAF8A` (`projectApproval_id`),
  CONSTRAINT `FK88D9E7F3C59FAF8A` FOREIGN KEY (`projectApproval_id`) REFERENCES `projectapproval` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of spshouxininfo
-- ----------------------------

-- ----------------------------
-- Table structure for `stage`
-- ----------------------------
DROP TABLE IF EXISTS `stage`;
CREATE TABLE `stage` (
  `stageId` varchar(1) NOT NULL,
  `stageName` varchar(20) NOT NULL,
  PRIMARY KEY (`stageId`),
  UNIQUE KEY `stageId` (`stageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stage
-- ----------------------------
INSERT INTO stage VALUES ('1', '企业咨询');
INSERT INTO stage VALUES ('2', '项目调查');
INSERT INTO stage VALUES ('3', '项目审批');
INSERT INTO stage VALUES ('4', '档案管理');
INSERT INTO stage VALUES ('5', '签约放款');

-- ----------------------------
-- Table structure for `step`
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `stepId` varchar(5) NOT NULL,
  `stageId` varchar(3) DEFAULT NULL,
  `stepName` varchar(16) NOT NULL,
  PRIMARY KEY (`stepId`),
  UNIQUE KEY `stepId` (`stepId`),
  UNIQUE KEY `stepName` (`stepName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step
-- ----------------------------
INSERT INTO step VALUES ('01', '1', '受理人新建企业咨询');
INSERT INTO step VALUES ('02', '1', '部门经理分配A/B角');
INSERT INTO step VALUES ('03', '2', 'A角填写调查报告');
INSERT INTO step VALUES ('04', '2', 'B角审核');
INSERT INTO step VALUES ('05', '2', '部门经理审核');
INSERT INTO step VALUES ('06', '2', '业务分管领导审核');
INSERT INTO step VALUES ('07', '2', '复审审核');
INSERT INTO step VALUES ('08', '2', '法务审核');
INSERT INTO step VALUES ('09', '2', '风控经理审核');
INSERT INTO step VALUES ('10', '3', '秘书上会日程安排');
INSERT INTO step VALUES ('11', '3', '秘书投标');
INSERT INTO step VALUES ('12', '3', '秘书投票统计');
INSERT INTO step VALUES ('13', '3', '生成审批单');
INSERT INTO step VALUES ('14', '3', 'A角确认');
INSERT INTO step VALUES ('15', '3', '审保主任审批');
INSERT INTO step VALUES ('16', '3', '总经理审批');
INSERT INTO step VALUES ('17', '3', '秘书生成执行单');
INSERT INTO step VALUES ('18', '3', '风控分管领导审批');
INSERT INTO step VALUES ('19', '3', '秘书整理复议意见');
INSERT INTO step VALUES ('20', '3', 'A角答复复议意见');
INSERT INTO step VALUES ('21', '3', '秘书根据复议意见重新投票');
INSERT INTO step VALUES ('22', '3', '秘书进行复议投票统计');
INSERT INTO step VALUES ('23', '3', '秘书完成复议后生成审批单');
INSERT INTO step VALUES ('24', '4', '项目A角提交');
INSERT INTO step VALUES ('25', '4', '复审确认');
INSERT INTO step VALUES ('26', '5', 'A角提交签约申请');
INSERT INTO step VALUES ('27', '5', '部门经理签约审批');
INSERT INTO step VALUES ('28', '5', '放款人签约审批');
INSERT INTO step VALUES ('29', '5', '风控经理签约审批');
INSERT INTO step VALUES ('30', '5', '总经理审批签约（放款人代点）');
INSERT INTO step VALUES ('31', '5', 'A角提交放款申请');
INSERT INTO step VALUES ('32', '5', '部门经理审批放款');
INSERT INTO step VALUES ('33', '5', '复审放款审批');
INSERT INTO step VALUES ('34', '5', '放款人审批放款');
INSERT INTO step VALUES ('35', '5', '风控经理审批放款');
INSERT INTO step VALUES ('36', '5', '总经理放款审批（放款人代点）');
INSERT INTO step VALUES ('37', '5', 'A角保费收取申请');
INSERT INTO step VALUES ('38', '5', '放款人保费收取审批');
INSERT INTO step VALUES ('39', '5', '出纳保费收取');
INSERT INTO step VALUES ('40', '3', '办公会秘书审批');
INSERT INTO step VALUES ('41', '4', '项目/法律档案管理');
INSERT INTO step VALUES ('42', '4', 'joinPL');
INSERT INTO step VALUES ('43', '5', '签约审批完成');
INSERT INTO step VALUES ('44', '4', '项目经理提交档案审核');
INSERT INTO step VALUES ('45', '4', '复审确认档案');
INSERT INTO step VALUES ('46', '4', '档案确认终结');
INSERT INTO step VALUES ('47', '4', '法律档案项目经理确认');
INSERT INTO step VALUES ('48', '4', '法律档案放款人确认');
INSERT INTO step VALUES ('49', '4', '法律档案终结');

-- ----------------------------
-- Table structure for `stepsprocessers`
-- ----------------------------
DROP TABLE IF EXISTS `stepsprocessers`;
CREATE TABLE `stepsprocessers` (
  `StepsProcessers_id` varchar(32) NOT NULL,
  `relationId` varchar(5) NOT NULL,
  `stepId` varchar(5) NOT NULL,
  `userId` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`StepsProcessers_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stepsprocessers
-- ----------------------------
INSERT INTO stepsprocessers VALUES ('0b93e4eff79448318f7e12f18daaa4fe', '00006', '27', '00006');
INSERT INTO stepsprocessers VALUES ('0d97e973b25f45e79806237bbc3cbffd', '00006', '21', '00024');
INSERT INTO stepsprocessers VALUES ('17376c7125ea437386d55f1317bca27d', '00006', '41', '00029');
INSERT INTO stepsprocessers VALUES ('1b6737eff8814257b5743bde37072100', '00006', '48', '00025');
INSERT INTO stepsprocessers VALUES ('24491b4c18fe4e9ab04eb69bc05316f4', '00006', '12', '00024');
INSERT INTO stepsprocessers VALUES ('298541a6ec314d42a4891945ce8d1363', '00006', '38', '00025');
INSERT INTO stepsprocessers VALUES ('31ce906cff7d41068b85d3cd593f69b3', '00006', '05', '00006');
INSERT INTO stepsprocessers VALUES ('31eb080298ed40fa99a1c275fe1550dc', '00006', '36', '00025');
INSERT INTO stepsprocessers VALUES ('3aae582050d8420e920db62244fc8385', '00006', '34', '00025');
INSERT INTO stepsprocessers VALUES ('3dd209899ec749cdbc18c58f5d776b9b', '00006', '11', '00024');
INSERT INTO stepsprocessers VALUES ('406a062ab42d4de4b18463fd848cee36', '00006', '08', '00024');
INSERT INTO stepsprocessers VALUES ('443cfcbba59b47deb861b052651d1aa7', '00006', '40', '00030');
INSERT INTO stepsprocessers VALUES ('5a6a3dda67094842a314a5a3724ce428', '00006', '19', '00024');
INSERT INTO stepsprocessers VALUES ('5af4404568c547adadaebf9e07bb136c', '00006', '16', '00002');
INSERT INTO stepsprocessers VALUES ('5d16f4dfdede4d13a24769049f855cf4', '00006', '33', '00026');
INSERT INTO stepsprocessers VALUES ('5ea517169f94450abf9bd4283df86025', '00006', '18', '00022');
INSERT INTO stepsprocessers VALUES ('670f7ae6818648349fb5943a8b0d5ff7', '00006', '01', '00006');
INSERT INTO stepsprocessers VALUES ('695ad9190bbf4a55a92adad51d6ef693', '00006', '06', '00005');
INSERT INTO stepsprocessers VALUES ('6daf73d820d6495c93677136e1ba2651', '00006', '15', '00005');
INSERT INTO stepsprocessers VALUES ('742bff7acde244e19131287ebe4570ca', '00006', '39', '00028');
INSERT INTO stepsprocessers VALUES ('772aa2e8aafd4bd1a57f20d44f8c1d0f', '00006', '23', '00024');
INSERT INTO stepsprocessers VALUES ('7f477aa8d7764d3797d9d1c2e2aa0ecd', '00006', '45', '00026');
INSERT INTO stepsprocessers VALUES ('83dd032ee819457a9623bbdc9f19a03c', '00006', '17', '00024');
INSERT INTO stepsprocessers VALUES ('8a530d46b0954d5eac7d4fe6b172af34', '00006', '31', '00025');
INSERT INTO stepsprocessers VALUES ('8cd230d4f8bd4f6784e2b9e69deb2725', '00006', '07', '00026');
INSERT INTO stepsprocessers VALUES ('8e892baafaaf4de2a502045d6a9a9d50', '00006', '25', '00026');
INSERT INTO stepsprocessers VALUES ('8f07896ddef6452d9169074d31e95240', '00006', '13', '00024');
INSERT INTO stepsprocessers VALUES ('93379b3b7a7d4c1a9bc5470b5efb7058', '00006', '32', '00006');
INSERT INTO stepsprocessers VALUES ('9af8c5d427ad423184a2c19996d06963', '00006', '02', '00006');
INSERT INTO stepsprocessers VALUES ('a2f9d899a9e349db95ff586b38947a0f', '00006', '10', '00024');
INSERT INTO stepsprocessers VALUES ('ac1faa74580e4d02af055fef51448fb9', '00006', '30', '00025');
INSERT INTO stepsprocessers VALUES ('af4124286cd940dd88e63d883af03931', '00006', '22', '00024');
INSERT INTO stepsprocessers VALUES ('c83f67efe60d4a558d1c6c8d7cbfa90a', '00006', '29', '00022');
INSERT INTO stepsprocessers VALUES ('c8d2bce0ccad443f86003086cfc8fef4', '00006', '09', '00022');
INSERT INTO stepsprocessers VALUES ('ca34d5daf8ea4931b22a988e19291d1e', '00006', '35', '00022');
INSERT INTO stepsprocessers VALUES ('efe303ed49294aeaa301bf06c952edab', '00006', '28', '00025');

-- ----------------------------
-- Table structure for `suggestion`
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ajConfirmDateTime` datetime DEFAULT NULL,
  `ajConfirmName` varchar(20) DEFAULT NULL,
  `ajConfirmState` varchar(10) DEFAULT NULL,
  `ajConfirmSuggestion` varchar(225) DEFAULT NULL,
  `ajfyConfirmDateTime` datetime DEFAULT NULL,
  `ajfyConfirmName` varchar(20) DEFAULT NULL,
  `ajfyConfirmState` varchar(10) DEFAULT NULL,
  `ajfyConfirmSuggestion` varchar(225) DEFAULT NULL,
  `aroleDateTime` datetime DEFAULT NULL,
  `aroleName` varchar(20) DEFAULT NULL,
  `aroleState` varchar(10) DEFAULT NULL,
  `aroleSuggestion` varchar(225) DEFAULT NULL,
  `broleDateTime` datetime DEFAULT NULL,
  `broleName` varchar(20) DEFAULT NULL,
  `broleState` varchar(10) DEFAULT NULL,
  `broleSuggestion` varchar(225) DEFAULT NULL,
  `cashierDateTime` datetime DEFAULT NULL,
  `cashierName` varchar(20) DEFAULT NULL,
  `cashierState` varchar(10) DEFAULT NULL,
  `cashierSuggestion` varchar(225) DEFAULT NULL,
  `collateralManagerDateTime` datetime DEFAULT NULL,
  `collateralManagerName` varchar(20) DEFAULT NULL,
  `collateralManagerState` varchar(10) DEFAULT NULL,
  `collateralManagerSuggestion` varchar(225) DEFAULT NULL,
  `contactManagerDateTime` datetime DEFAULT NULL,
  `contactManagerState` varchar(10) DEFAULT NULL,
  `contactManagerSuggestion` varchar(225) DEFAULT NULL,
  `contactManager_ZDateTime` datetime DEFAULT NULL,
  `contactManager_ZName` varchar(20) DEFAULT NULL,
  `contactManager_ZState` varchar(10) DEFAULT NULL,
  `contactManager_ZSuggestion` varchar(225) DEFAULT NULL,
  `departDateTime` datetime DEFAULT NULL,
  `departLeaderDateTime` datetime DEFAULT NULL,
  `departLeaderName` varchar(20) DEFAULT NULL,
  `departLeaderState` varchar(10) DEFAULT NULL,
  `departLeaderSuggestion` varchar(225) DEFAULT NULL,
  `departState` varchar(10) DEFAULT NULL,
  `departSuggestion` varchar(225) DEFAULT NULL,
  `departmentManagerDateTime` datetime DEFAULT NULL,
  `departmentManagerName` varchar(20) DEFAULT NULL,
  `departmentManagerState` varchar(10) DEFAULT NULL,
  `departmentManagerSuggestion` varchar(225) DEFAULT NULL,
  `extendLoanerDateTime` datetime DEFAULT NULL,
  `extendLoanerName` varchar(20) DEFAULT NULL,
  `extendLoanerState` varchar(10) DEFAULT NULL,
  `extendLoanerSuggestion` varchar(225) DEFAULT NULL,
  `generalManagerDateTime` datetime DEFAULT NULL,
  `generalManagerName` varchar(20) DEFAULT NULL,
  `generalManagerState` varchar(10) DEFAULT NULL,
  `generalManagerSuggestion` varchar(225) DEFAULT NULL,
  `lawerDateTime` datetime DEFAULT NULL,
  `lawerName` varchar(20) DEFAULT NULL,
  `lawerState` varchar(10) DEFAULT NULL,
  `lawerSuggestion` varchar(225) DEFAULT NULL,
  `officeSecretaryDateTime` datetime DEFAULT NULL,
  `officeSecretaryName` varchar(20) DEFAULT NULL,
  `officeSecretaryState` varchar(10) DEFAULT NULL,
  `officeSecretarySuggestion` varchar(225) DEFAULT NULL,
  `projectManagerDateTime` datetime DEFAULT NULL,
  `projectManagerState` varchar(10) DEFAULT NULL,
  `projectManagerSuggestion` varchar(225) DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `recoveryStaffDateTime` datetime DEFAULT NULL,
  `recoveryStaffState` varchar(10) DEFAULT NULL,
  `recoveryStaffSuggestion` varchar(225) DEFAULT NULL,
  `reviewDateTime` datetime DEFAULT NULL,
  `reviewName` varchar(20) DEFAULT NULL,
  `reviewState` varchar(10) DEFAULT NULL,
  `reviewSuggestion` varchar(225) DEFAULT NULL,
  `securityDirectorDateTime` datetime DEFAULT NULL,
  `securityDirectorName` varchar(20) DEFAULT NULL,
  `securityDirectorState` varchar(10) DEFAULT NULL,
  `securityDirectorSuggestion` varchar(225) DEFAULT NULL,
  `securitySecretaryDateTime` datetime DEFAULT NULL,
  `securitySecretaryName` varchar(20) DEFAULT NULL,
  `securitySecretaryState` varchar(10) DEFAULT NULL,
  `securitySecretarySuggestion` varchar(225) DEFAULT NULL,
  `securitySupervisionDateTime` datetime DEFAULT NULL,
  `securitySupervisionName` varchar(20) DEFAULT NULL,
  `securitySupervisionState` varchar(10) DEFAULT NULL,
  `securitySupervisionSuggestion` varchar(225) DEFAULT NULL,
  `srecoveryStaffName` varchar(20) DEFAULT NULL,
  `windControlManagerDateTime` datetime DEFAULT NULL,
  `windControlManagerName` varchar(20) DEFAULT NULL,
  `windControlManagerState` varchar(10) DEFAULT NULL,
  `windControlManagerSuggestion` varchar(225) DEFAULT NULL,
  `windLeaderDateTime` datetime DEFAULT NULL,
  `windLeaderName` varchar(20) DEFAULT NULL,
  `windLeaderState` varchar(10) DEFAULT NULL,
  `windLeaderSuggestion` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBE35A624233CA97D` (`project_id`),
  CONSTRAINT `FKBE35A624233CA97D` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO suggestion VALUES ('1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2011-06-27 14:43:46', null, null, null, null, '1', '立项', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '立项', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO suggestion VALUES ('2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2011-06-27 14:46:45', null, null, null, null, '1', '同意', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '立项', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(120) DEFAULT NULL,
  `fromWho` varchar(16) DEFAULT NULL,
  `processURL` varchar(125) DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  `step_id` varchar(255) NOT NULL,
  `submitTime` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK27A9A526643E40` (`step_id`),
  KEY `FK27A9A5233CA97D` (`project_id`),
  CONSTRAINT `FK27A9A5233CA97D` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FK27A9A526643E40` FOREIGN KEY (`step_id`) REFERENCES `step` (`stepId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO task VALUES ('1', '项目 [大连北方测控工程有限公司] 立项完成，正在请求A角填写调查报告', '张月', 'control/consulation/SurveyAReportAction_detailProjectSurvey.action?projectView.projectNo=11B001', '1', '03', '2011-06-27 14:43:46');
INSERT INTO task VALUES ('2', '项目 [大连松祥贸易有限公司] 立项完成，正在请求A角填写调查报告', '张月', 'control/consulation/SurveyAReportAction_detailProjectSurvey.action?projectView.projectNo=11B002', '2', '03', '2011-06-27 14:46:45');
INSERT INTO task VALUES ('3', '项目 [大连北方测控工程有限公司] 立项完成，正在请求项目经理提交档案审核', '张月', 'control/file/ProjectFileAction_detail.action?projectView.projectNo=11B001', '1', '44', '2011-06-27 14:43:46');
INSERT INTO task VALUES ('4', '项目 [大连松祥贸易有限公司] 立项完成，正在请求项目经理提交档案审核', '张月', 'control/file/ProjectFileAction_detail.action?projectView.projectNo=11B002', '2', '44', '2011-06-27 14:46:45');

-- ----------------------------
-- Table structure for `understand`
-- ----------------------------
DROP TABLE IF EXISTS `understand`;
CREATE TABLE `understand` (
  `id` varchar(36) NOT NULL,
  `stepId` varchar(5) DEFAULT NULL,
  `userId` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDA8641E621167B9` (`stepId`),
  KEY `FKDA8641E297F5058` (`userId`),
  CONSTRAINT `FKDA8641E297F5058` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  CONSTRAINT `FKDA8641E621167B9` FOREIGN KEY (`stepId`) REFERENCES `step` (`stepId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of understand
-- ----------------------------

-- ----------------------------
-- Table structure for `uploadfiles`
-- ----------------------------
DROP TABLE IF EXISTS `uploadfiles`;
CREATE TABLE `uploadfiles` (
  `id` varchar(36) NOT NULL,
  `noticeId` int(11) DEFAULT NULL,
  `realFileName` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA17EFCD6ABA64A78` (`noticeId`),
  CONSTRAINT `FKA17EFCD6ABA64A78` FOREIGN KEY (`noticeId`) REFERENCES `notice` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uploadfiles
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` varchar(5) NOT NULL,
  `officeMumber` varchar(3) NOT NULL,
  `orgNo` varchar(1) NOT NULL,
  `password` varchar(16) NOT NULL,
  `realName` varchar(10) NOT NULL,
  `shenBaoHuiMumber` varchar(3) NOT NULL,
  `username` varchar(16) NOT NULL,
  `visible` varchar(3) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userId` (`userId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO user VALUES ('00001', 'NO', 'A', 'admin', 'admin', 'NO', 'admin', 'YES');
INSERT INTO user VALUES ('00002', 'NO', 'H', 'yangyukun', '杨玉坤', 'NO', 'yangyukun', 'YES');
INSERT INTO user VALUES ('00003', 'NO', 'H', 'miaowei', '苗玮', 'NO', 'miaowei', 'YES');
INSERT INTO user VALUES ('00004', 'NO', 'H', 'lichengxiang', '李成祥', 'NO', 'lichengxiang', 'YES');
INSERT INTO user VALUES ('00005', 'NO', 'H', 'yangxiheng', '杨希亨', 'NO', 'yangxiheng', 'YES');
INSERT INTO user VALUES ('00006', 'NO', 'B', 'zhangyue', '张月', 'YES', 'zhangyue', 'YES');
INSERT INTO user VALUES ('00007', 'NO', 'B', 'zhangguosheng', '张国生', 'NO', 'zhangguosheng', 'YES');
INSERT INTO user VALUES ('00008', 'NO', 'B', 'xumu', '续沐', 'NO', 'xumu', 'YES');
INSERT INTO user VALUES ('00009', 'NO', 'C', 'sunguoqing', '孙国庆', 'NO', 'sunguoqing', 'YES');
INSERT INTO user VALUES ('00010', 'NO', 'C', 'yuling', '于玲', 'NO', 'yuling', 'YES');
INSERT INTO user VALUES ('00011', 'NO', 'C', 'jiaoyang', '焦阳', 'NO', 'jiaoyang', 'YES');
INSERT INTO user VALUES ('00012', 'NO', 'C', 'suibin', '隋斌', 'NO', 'suibin', 'YES');
INSERT INTO user VALUES ('00013', 'NO', 'C', 'fengxiaoli', '冯晓莉', 'NO', 'fengxiaoli', 'YES');
INSERT INTO user VALUES ('00014', 'NO', 'D', 'zuolian', '左莲', 'NO', 'zuolian', 'YES');
INSERT INTO user VALUES ('00015', 'NO', 'D', 'wanzhihui', '万智慧', 'NO', 'wanzhihui', 'YES');
INSERT INTO user VALUES ('00016', 'NO', 'D', 'xuehongyu', '薛宏雨', 'NO', 'xuehongyu', 'YES');
INSERT INTO user VALUES ('00017', 'NO', 'D', 'lixiaomei', 'lixiaomei', 'NO', 'lixiaomei', 'YES');
INSERT INTO user VALUES ('00018', 'NO', 'D', 'liguobin', '李国斌', 'NO', 'liguobin', 'YES');
INSERT INTO user VALUES ('00019', 'NO', 'D', 'zhouwanxin', '周万昕', 'NO', 'zhouwanxin', 'YES');
INSERT INTO user VALUES ('00020', 'NO', 'C', 'dushiyao', '杜湜垚', 'NO', 'dushiyao', 'YES');
INSERT INTO user VALUES ('00021', 'NO', 'D', 'muren', '牧仁', 'NO', 'muren', 'YES');
INSERT INTO user VALUES ('00022', 'NO', 'E', 'daiqian', '戴谦', 'NO', 'daiqian', 'YES');
INSERT INTO user VALUES ('00023', 'NO', 'E', 'chuyingge', '储莺歌', 'NO', 'chuyingge', 'YES');
INSERT INTO user VALUES ('00024', 'NO', 'E', 'cuizhi', '崔志', 'NO', 'cuizhi', 'YES');
INSERT INTO user VALUES ('00025', 'NO', 'E', 'chenxiang', '陈香', 'NO', 'chenxiang', 'YES');
INSERT INTO user VALUES ('00026', 'NO', 'E', 'lichunyang', '李春阳', 'NO', 'lichunyang', 'YES');
INSERT INTO user VALUES ('00027', 'NO', 'E', 'chenxiaoguang', '陈晓光', 'NO', 'chenxiaoguang', 'YES');
INSERT INTO user VALUES ('00028', 'NO', 'F', 'panli', '潘莉', 'NO', 'panli', 'YES');
INSERT INTO user VALUES ('00029', 'NO', 'F', 'ronghuiying', '荣卉颍', 'NO', 'ronghuiying', 'YES');
INSERT INTO user VALUES ('00030', 'NO', 'G', 'guoyefei', '郭野飞', 'NO', 'guoyefei', 'YES');
INSERT INTO user VALUES ('00031', 'NO', 'C', 'wangbin', '王斌', 'NO', 'wangbin', 'YES');
INSERT INTO user VALUES ('00032', 'NO', 'C', 'niyuan', '倪媛', 'NO', 'niyuan', 'YES');
INSERT INTO user VALUES ('00033', 'NO', 'D', 'zhangjintao', '张金涛', 'NO', 'zhangjintao', 'YES');
INSERT INTO user VALUES ('00034', 'NO', 'B', 'tengkunpeng', '腾鲲鹏', 'NO', 'tengkunpeng', 'YES');
INSERT INTO user VALUES ('00035', 'NO', 'D', 'jinlingyuan', '金玲媛', 'NO', 'jinlingyuan', 'YES');
INSERT INTO user VALUES ('00036', 'NO', 'B', 'hanxue', '韩雪', 'NO', 'hanxue', 'YES');
INSERT INTO user VALUES ('00037', 'NO', 'F', 'dongqin', '蕫勤', 'NO', 'dongqin', 'YES');
INSERT INTO user VALUES ('00038', 'NO', 'I', 'liuzhong', '刘忠', 'NO', 'liuzhong', 'YES');
INSERT INTO user VALUES ('00039', 'NO', 'G', 'lixixi', '李希茜', 'NO', 'lixixi', 'YES');
INSERT INTO user VALUES ('00040', 'NO', 'B', 'limingjie', '李明杰', 'NO', 'limingjie', 'YES');
INSERT INTO user VALUES ('00041', 'NO', 'C', 'sunxin', '孙欣', 'NO', 'sunxin', 'YES');
INSERT INTO user VALUES ('00042', 'NO', 'C', 'liangchuyue', '梁楚悦', 'NO', 'liangchuyue', 'YES');
INSERT INTO user VALUES ('00043', 'NO', 'D', 'zuolian', '邢珍珠', 'NO', 'xingzhenzhu', 'YES');

-- ----------------------------
-- Table structure for `usersroles`
-- ----------------------------
DROP TABLE IF EXISTS `usersroles`;
CREATE TABLE `usersroles` (
  `usersRoles_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(255) NOT NULL,
  `user_Id` varchar(5) NOT NULL,
  PRIMARY KEY (`usersRoles_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usersroles
-- ----------------------------
INSERT INTO usersroles VALUES ('1', 'A', '00001');
INSERT INTO usersroles VALUES ('2', 'G', '00006');
INSERT INTO usersroles VALUES ('3', 'E', '00006');
INSERT INTO usersroles VALUES ('4', 'G', '00040');
INSERT INTO usersroles VALUES ('5', 'G', '00036');
INSERT INTO usersroles VALUES ('6', 'G', '00008');
INSERT INTO usersroles VALUES ('7', 'G', '00007');
INSERT INTO usersroles VALUES ('8', 'G', '00034');
INSERT INTO usersroles VALUES ('9', 'E', '00009');
INSERT INTO usersroles VALUES ('10', 'G', '00009');
INSERT INTO usersroles VALUES ('11', 'G', '00013');
INSERT INTO usersroles VALUES ('12', 'G', '00020');
INSERT INTO usersroles VALUES ('13', 'G', '00012');
INSERT INTO usersroles VALUES ('14', 'G', '00010');
INSERT INTO usersroles VALUES ('15', 'G', '00011');
INSERT INTO usersroles VALUES ('16', 'G', '00042');
INSERT INTO usersroles VALUES ('17', 'G', '00041');
INSERT INTO usersroles VALUES ('18', 'G', '00031');
INSERT INTO usersroles VALUES ('19', 'G', '00032');
INSERT INTO usersroles VALUES ('20', 'G', '00014');
INSERT INTO usersroles VALUES ('21', 'E', '00014');
INSERT INTO usersroles VALUES ('22', 'G', '00043');
INSERT INTO usersroles VALUES ('23', 'G', '00021');
INSERT INTO usersroles VALUES ('24', 'G', '00019');
INSERT INTO usersroles VALUES ('25', 'G', '00018');
INSERT INTO usersroles VALUES ('26', 'G', '00017');
INSERT INTO usersroles VALUES ('27', 'G', '00016');
INSERT INTO usersroles VALUES ('28', 'G', '00015');
INSERT INTO usersroles VALUES ('29', 'G', '00035');
INSERT INTO usersroles VALUES ('30', 'G', '00033');
INSERT INTO usersroles VALUES ('31', 'R', '00022');
INSERT INTO usersroles VALUES ('32', 'H', '00022');
INSERT INTO usersroles VALUES ('33', 'I', '00024');
INSERT INTO usersroles VALUES ('34', 'J', '00024');
INSERT INTO usersroles VALUES ('35', 'T', '00024');
INSERT INTO usersroles VALUES ('36', 'X', '00024');
INSERT INTO usersroles VALUES ('37', 'J', '00026');
INSERT INTO usersroles VALUES ('38', 'L', '00026');
INSERT INTO usersroles VALUES ('39', 'J', '00027');
INSERT INTO usersroles VALUES ('40', 'S', '00027');
INSERT INTO usersroles VALUES ('41', 'G', '00027');
INSERT INTO usersroles VALUES ('42', 'K', '00025');
INSERT INTO usersroles VALUES ('43', 'U', '00025');
INSERT INTO usersroles VALUES ('44', 'L', '00023');
INSERT INTO usersroles VALUES ('45', 'X', '00023');
INSERT INTO usersroles VALUES ('46', 'M', '00029');
INSERT INTO usersroles VALUES ('47', 'O', '00028');
INSERT INTO usersroles VALUES ('48', 'Y', '00037');
INSERT INTO usersroles VALUES ('49', 'V', '00030');
INSERT INTO usersroles VALUES ('50', 'Y', '00039');
INSERT INTO usersroles VALUES ('51', 'C', '00002');
INSERT INTO usersroles VALUES ('52', 'D', '00004');
INSERT INTO usersroles VALUES ('53', 'D', '00003');
INSERT INTO usersroles VALUES ('54', 'D', '00005');
INSERT INTO usersroles VALUES ('55', 'F', '00005');
INSERT INTO usersroles VALUES ('56', 'P', '00005');
INSERT INTO usersroles VALUES ('57', 'B', '00038');

-- ----------------------------
-- Table structure for `vote`
-- ----------------------------
DROP TABLE IF EXISTS `vote`;
CREATE TABLE `vote` (
  `validCount` int(11) NOT NULL,
  `passCount` int(11) DEFAULT NULL,
  `vetoCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`validCount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vote
-- ----------------------------
INSERT INTO vote VALUES ('1', null, null);
