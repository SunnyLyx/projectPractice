-- MySQL dump 10.13  Distrib 5.6.51, for Linux (x86_64)
--
-- Host: localhost    Database: fosutech
-- ------------------------------------------------------
-- Server version	5.6.51

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `act_evt_log`
--

DROP TABLE IF EXISTS `act_evt_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_evt_log` (
  `LOG_NR_` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_STAMP_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DATA_` longblob,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  `IS_PROCESSED_` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`LOG_NR_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_evt_log`
--

LOCK TABLES `act_evt_log` WRITE;
/*!40000 ALTER TABLE `act_evt_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_evt_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ge_bytearray`
--

DROP TABLE IF EXISTS `act_ge_bytearray`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_bytearray` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTES_` longblob,
  `GENERATED_` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_BYTEARR_DEPL` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_BYTEARR_DEPL` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_bytearray`
--

LOCK TABLES `act_ge_bytearray` WRITE;
/*!40000 ALTER TABLE `act_ge_bytearray` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ge_bytearray` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ge_property`
--

DROP TABLE IF EXISTS `act_ge_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ge_property` (
  `NAME_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `VALUE_` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  PRIMARY KEY (`NAME_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ge_property`
--

LOCK TABLES `act_ge_property` WRITE;
/*!40000 ALTER TABLE `act_ge_property` DISABLE KEYS */;
INSERT INTO `act_ge_property` VALUES ('next.dbid','1',1),('schema.history','create(5.22.0.0)',1),('schema.version','5.22.0.0',1);
/*!40000 ALTER TABLE `act_ge_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_actinst`
--

DROP TABLE IF EXISTS `act_hi_actinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_actinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin NOT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CALL_PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ACT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_ACT_INST_START` (`START_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_ACT_INST_PROCINST` (`PROC_INST_ID_`,`ACT_ID_`),
  KEY `ACT_IDX_HI_ACT_INST_EXEC` (`EXECUTION_ID_`,`ACT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_actinst`
--

LOCK TABLES `act_hi_actinst` WRITE;
/*!40000 ALTER TABLE `act_hi_actinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_actinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_attachment`
--

DROP TABLE IF EXISTS `act_hi_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_attachment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `URL_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CONTENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_attachment`
--

LOCK TABLES `act_hi_attachment` WRITE;
/*!40000 ALTER TABLE `act_hi_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_comment`
--

DROP TABLE IF EXISTS `act_hi_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_comment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MESSAGE_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `FULL_MSG_` longblob,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_comment`
--

LOCK TABLES `act_hi_comment` WRITE;
/*!40000 ALTER TABLE `act_hi_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_detail`
--

DROP TABLE IF EXISTS `act_hi_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_detail` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TIME_` datetime(3) NOT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_DETAIL_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_ACT_INST` (`ACT_INST_ID_`),
  KEY `ACT_IDX_HI_DETAIL_TIME` (`TIME_`),
  KEY `ACT_IDX_HI_DETAIL_NAME` (`NAME_`),
  KEY `ACT_IDX_HI_DETAIL_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_detail`
--

LOCK TABLES `act_hi_detail` WRITE;
/*!40000 ALTER TABLE `act_hi_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_identitylink`
--

DROP TABLE IF EXISTS `act_hi_identitylink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_TASK` (`TASK_ID_`),
  KEY `ACT_IDX_HI_IDENT_LNK_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_identitylink`
--

LOCK TABLES `act_hi_identitylink` WRITE;
/*!40000 ALTER TABLE `act_hi_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_identitylink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_procinst`
--

DROP TABLE IF EXISTS `act_hi_procinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_procinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `START_USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `END_ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `PROC_INST_ID_` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PRO_INST_END` (`END_TIME_`),
  KEY `ACT_IDX_HI_PRO_I_BUSKEY` (`BUSINESS_KEY_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_procinst`
--

LOCK TABLES `act_hi_procinst` WRITE;
/*!40000 ALTER TABLE `act_hi_procinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_procinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_taskinst`
--

DROP TABLE IF EXISTS `act_hi_taskinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_taskinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime(3) NOT NULL,
  `CLAIM_TIME_` datetime(3) DEFAULT NULL,
  `END_TIME_` datetime(3) DEFAULT NULL,
  `DURATION_` bigint(20) DEFAULT NULL,
  `DELETE_REASON_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_TASK_INST_PROCINST` (`PROC_INST_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_taskinst`
--

LOCK TABLES `act_hi_taskinst` WRITE;
/*!40000 ALTER TABLE `act_hi_taskinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_taskinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_hi_varinst`
--

DROP TABLE IF EXISTS `act_hi_varinst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_hi_varinst` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VAR_TYPE_` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `REV_` int(11) DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` datetime(3) DEFAULT NULL,
  `LAST_UPDATED_TIME_` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_HI_PROCVAR_PROC_INST` (`PROC_INST_ID_`),
  KEY `ACT_IDX_HI_PROCVAR_NAME_TYPE` (`NAME_`,`VAR_TYPE_`),
  KEY `ACT_IDX_HI_PROCVAR_TASK_ID` (`TASK_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_hi_varinst`
--

LOCK TABLES `act_hi_varinst` WRITE;
/*!40000 ALTER TABLE `act_hi_varinst` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_hi_varinst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `act_id_group`
--

DROP TABLE IF EXISTS `act_id_group`;
/*!50001 DROP VIEW IF EXISTS `act_id_group`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `act_id_group` AS SELECT 
 1 AS `id_`,
 1 AS `rev_`,
 1 AS `name_`,
 1 AS `type_`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `act_id_membership`
--

DROP TABLE IF EXISTS `act_id_membership`;
/*!50001 DROP VIEW IF EXISTS `act_id_membership`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `act_id_membership` AS SELECT 
 1 AS `user_id_`,
 1 AS `group_id_`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `act_id_user`
--

DROP TABLE IF EXISTS `act_id_user`;
/*!50001 DROP VIEW IF EXISTS `act_id_user`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `act_id_user` AS SELECT 
 1 AS `id_`,
 1 AS `rev_`,
 1 AS `first_`,
 1 AS `last_`,
 1 AS `email_`,
 1 AS `pwd_`,
 1 AS `picture_id_`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `act_procdef_info`
--

DROP TABLE IF EXISTS `act_procdef_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_procdef_info` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `INFO_JSON_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_IDX_INFO_PROCDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_INFO_JSON_BA` (`INFO_JSON_ID_`),
  CONSTRAINT `ACT_FK_INFO_JSON_BA` FOREIGN KEY (`INFO_JSON_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_INFO_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_procdef_info`
--

LOCK TABLES `act_procdef_info` WRITE;
/*!40000 ALTER TABLE `act_procdef_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_procdef_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_deployment`
--

DROP TABLE IF EXISTS `act_re_deployment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_deployment`
--

LOCK TABLES `act_re_deployment` WRITE;
/*!40000 ALTER TABLE `act_re_deployment` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_deployment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_model`
--

DROP TABLE IF EXISTS `act_re_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_model` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LAST_UPDATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `VERSION_` int(11) DEFAULT NULL,
  `META_INFO_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EDITOR_SOURCE_EXTRA_VALUE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_MODEL_SOURCE` (`EDITOR_SOURCE_VALUE_ID_`),
  KEY `ACT_FK_MODEL_SOURCE_EXTRA` (`EDITOR_SOURCE_EXTRA_VALUE_ID_`),
  KEY `ACT_FK_MODEL_DEPLOYMENT` (`DEPLOYMENT_ID_`),
  CONSTRAINT `ACT_FK_MODEL_DEPLOYMENT` FOREIGN KEY (`DEPLOYMENT_ID_`) REFERENCES `act_re_deployment` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE` FOREIGN KEY (`EDITOR_SOURCE_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_MODEL_SOURCE_EXTRA` FOREIGN KEY (`EDITOR_SOURCE_EXTRA_VALUE_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_model`
--

LOCK TABLES `act_re_model` WRITE;
/*!40000 ALTER TABLE `act_re_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_re_procdef`
--

DROP TABLE IF EXISTS `act_re_procdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_re_procdef`
--

LOCK TABLES `act_re_procdef` WRITE;
/*!40000 ALTER TABLE `act_re_procdef` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_re_procdef` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_event_subscr`
--

DROP TABLE IF EXISTS `act_ru_event_subscr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_event_subscr` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `EVENT_TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EVENT_NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACTIVITY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `CONFIGURATION_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `CREATED_` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EVENT_SUBSCR_CONFIG_` (`CONFIGURATION_`),
  KEY `ACT_FK_EVENT_EXEC` (`EXECUTION_ID_`),
  CONSTRAINT `ACT_FK_EVENT_EXEC` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_event_subscr`
--

LOCK TABLES `act_ru_event_subscr` WRITE;
/*!40000 ALTER TABLE `act_ru_event_subscr` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_event_subscr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_execution`
--

DROP TABLE IF EXISTS `act_ru_execution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp(3) NULL DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`),
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`),
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`),
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_EXE_PARENT` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_EXE_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `ACT_FK_EXE_SUPER` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_execution`
--

LOCK TABLES `act_ru_execution` WRITE;
/*!40000 ALTER TABLE `act_ru_execution` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_execution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_identitylink`
--

DROP TABLE IF EXISTS `act_ru_identitylink`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_identitylink` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `GROUP_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `USER_ID_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_IDENT_LNK_USER` (`USER_ID_`),
  KEY `ACT_IDX_IDENT_LNK_GROUP` (`GROUP_ID_`),
  KEY `ACT_IDX_ATHRZ_PROCEDEF` (`PROC_DEF_ID_`),
  KEY `ACT_FK_TSKASS_TASK` (`TASK_ID_`),
  KEY `ACT_FK_IDL_PROCINST` (`PROC_INST_ID_`),
  CONSTRAINT `ACT_FK_ATHRZ_PROCEDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_IDL_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TSKASS_TASK` FOREIGN KEY (`TASK_ID_`) REFERENCES `act_ru_task` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_identitylink`
--

LOCK TABLES `act_ru_identitylink` WRITE;
/*!40000 ALTER TABLE `act_ru_identitylink` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_identitylink` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_job`
--

DROP TABLE IF EXISTS `act_ru_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_job` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `LOCK_EXP_TIME_` timestamp(3) NULL DEFAULT NULL,
  `LOCK_OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `EXCLUSIVE_` tinyint(1) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROCESS_INSTANCE_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `RETRIES_` int(11) DEFAULT NULL,
  `EXCEPTION_STACK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `EXCEPTION_MSG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `DUEDATE_` timestamp(3) NULL DEFAULT NULL,
  `REPEAT_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_TYPE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `HANDLER_CFG_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`ID_`),
  KEY `ACT_FK_JOB_EXCEPTION` (`EXCEPTION_STACK_ID_`),
  CONSTRAINT `ACT_FK_JOB_EXCEPTION` FOREIGN KEY (`EXCEPTION_STACK_ID_`) REFERENCES `act_ge_bytearray` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_job`
--

LOCK TABLES `act_ru_job` WRITE;
/*!40000 ALTER TABLE `act_ru_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_task`
--

DROP TABLE IF EXISTS `act_ru_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp(3) NULL DEFAULT NULL,
  `DUE_DATE_` datetime(3) DEFAULT NULL,
  `CATEGORY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`),
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`),
  CONSTRAINT `ACT_FK_TASK_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCDEF` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`ID_`),
  CONSTRAINT `ACT_FK_TASK_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_task`
--

LOCK TABLES `act_ru_task` WRITE;
/*!40000 ALTER TABLE `act_ru_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `act_ru_variable`
--

DROP TABLE IF EXISTS `act_ru_variable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `act_ru_variable` (
  `ID_` varchar(64) COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `TYPE_` varchar(255) COLLATE utf8_bin NOT NULL,
  `NAME_` varchar(255) COLLATE utf8_bin NOT NULL,
  `EXECUTION_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `TASK_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `BYTEARRAY_ID_` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `DOUBLE_` double DEFAULT NULL,
  `LONG_` bigint(20) DEFAULT NULL,
  `TEXT_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `TEXT2_` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_VARIABLE_TASK_ID` (`TASK_ID_`),
  KEY `ACT_FK_VAR_EXE` (`EXECUTION_ID_`),
  KEY `ACT_FK_VAR_PROCINST` (`PROC_INST_ID_`),
  KEY `ACT_FK_VAR_BYTEARRAY` (`BYTEARRAY_ID_`),
  CONSTRAINT `ACT_FK_VAR_BYTEARRAY` FOREIGN KEY (`BYTEARRAY_ID_`) REFERENCES `act_ge_bytearray` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_EXE` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`ID_`),
  CONSTRAINT `ACT_FK_VAR_PROCINST` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `act_ru_variable`
--

LOCK TABLES `act_ru_variable` WRITE;
/*!40000 ALTER TABLE `act_ru_variable` DISABLE KEYS */;
/*!40000 ALTER TABLE `act_ru_variable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `districts`
--

DROP TABLE IF EXISTS `districts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `districts` (
  `id` int(6) unsigned NOT NULL COMMENT '编号',
  `pid` int(6) NOT NULL DEFAULT '0' COMMENT '上级编号',
  `deep` tinyint(1) NOT NULL DEFAULT '0' COMMENT '层级',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '名称',
  `pinyin` varchar(64) DEFAULT NULL COMMENT '拼音',
  `pinyin_shor` varchar(64) DEFAULT '' COMMENT '拼音缩写',
  `ext_name` varchar(64) DEFAULT '' COMMENT '扩展名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `operator` varchar(32) DEFAULT '' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT COMMENT='地区';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `districts`
--

LOCK TABLES `districts` WRITE;
/*!40000 ALTER TABLE `districts` DISABLE KEYS */;
/*!40000 ALTER TABLE `districts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_menu`
--

DROP TABLE IF EXISTS `knowledge_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) COLLATE utf8_bin DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) COLLATE utf8_bin DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) COLLATE utf8_bin DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  `extend1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_menu`
--

LOCK TABLES `knowledge_menu` WRITE;
/*!40000 ALTER TABLE `knowledge_menu` DISABLE KEYS */;
INSERT INTO `knowledge_menu` VALUES (1,'教研部',0,1,'#','M','0',NULL,'fa fa-tag','admin',NULL,'admin',NULL,'',NULL,NULL,NULL,NULL,NULL),(3,'教学资料',1,1,'#','C','0',NULL,'#','admin',NULL,'admin',NULL,'',NULL,NULL,NULL,NULL,NULL),(16,'学术部',0,1,'#','C','0',NULL,'#','admin',NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL),(17,'教质部',0,2,'#','C','0',NULL,'fa fa-address-book','admin',NULL,'',NULL,'',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `knowledge_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `knowledge_oss`
--

DROP TABLE IF EXISTS `knowledge_oss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `knowledge_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `file_name` varchar(64) NOT NULL DEFAULT '' COMMENT '文件名',
  `file_suffix` varchar(10) NOT NULL DEFAULT '' COMMENT '文件后缀名',
  `url` varchar(200) NOT NULL COMMENT 'URL地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) NOT NULL DEFAULT '' COMMENT '上传人',
  `service` tinyint(2) NOT NULL DEFAULT '1' COMMENT '服务商',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `status` varchar(2) DEFAULT NULL COMMENT '状态',
  `extend1` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '文件来源',
  `extend2` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `extend3` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `extend4` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `extend5` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='文件上传';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_oss`
--

LOCK TABLES `knowledge_oss` WRITE;
/*!40000 ALTER TABLE `knowledge_oss` DISABLE KEYS */;
/*!40000 ALTER TABLE `knowledge_oss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_blob_triggers`
--

DROP TABLE IF EXISTS `qrtz_blob_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_blob_triggers`
--

LOCK TABLES `qrtz_blob_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_blob_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_blob_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_calendars`
--

DROP TABLE IF EXISTS `qrtz_calendars`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `calendar_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`sched_name`,`calendar_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_calendars`
--

LOCK TABLES `qrtz_calendars` WRITE;
/*!40000 ALTER TABLE `qrtz_calendars` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_calendars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_cron_triggers`
--

DROP TABLE IF EXISTS `qrtz_cron_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `cron_expression` varchar(200) COLLATE utf8_bin NOT NULL,
  `time_zone_id` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_cron_triggers`
--

LOCK TABLES `qrtz_cron_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_cron_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_cron_triggers` VALUES ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT','0/10 * * * * ?','Asia/Shanghai'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT','0/20 * * * * ?','Asia/Shanghai'),('fosutechScheduler','__TASK_CLASS_NAME__1','DEFAULT','0/10 * * * * ?','Hongkong');
/*!40000 ALTER TABLE `qrtz_cron_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_fired_triggers`
--

DROP TABLE IF EXISTS `qrtz_fired_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `entry_id` varchar(95) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `instance_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `fired_time` bigint(13) NOT NULL,
  `sched_time` bigint(13) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) COLLATE utf8_bin NOT NULL,
  `job_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `job_group` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `is_nonconcurrent` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `requests_recovery` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_fired_triggers`
--

LOCK TABLES `qrtz_fired_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_fired_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_fired_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_job_details`
--

DROP TABLE IF EXISTS `qrtz_job_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `job_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `job_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `description` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `job_class_name` varchar(250) COLLATE utf8_bin NOT NULL,
  `is_durable` varchar(1) COLLATE utf8_bin NOT NULL,
  `is_nonconcurrent` varchar(1) COLLATE utf8_bin NOT NULL,
  `is_update_data` varchar(1) COLLATE utf8_bin NOT NULL,
  `requests_recovery` varchar(1) COLLATE utf8_bin NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_job_details`
--

LOCK TABLES `qrtz_job_details` WRITE;
/*!40000 ALTER TABLE `qrtz_job_details` DISABLE KEYS */;
INSERT INTO `qrtz_job_details` VALUES ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT',NULL,'com.hp.quartz.util.ScheduleJob','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.hp.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0com.hp.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/10 * * * * ?t\0系统默认（无参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0\nryNoParamst\0\0t\03t\01x\0'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT',NULL,'com.hp.quartz.util.ScheduleJob','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.hp.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0com.hp.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xpt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0b,�)�xpt\0\0pppt\00/20 * * * * ?t\0系统默认（有参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0ryTaskt\0ryParamst\0ryt\03t\01x\0'),('fosutechScheduler','__TASK_CLASS_NAME__1','DEFAULT',NULL,'edu.fosu.quartz.util.ScheduleJob','0','1','0','0','��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0edu.fosu.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0edu.fosu.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0countq\0~\0\nL\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminppt\0\0pppt\00/10 * * * * ?t\0统计sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0统计信息t\0statisticsTeachClassMontht\0\0t\01t\01x\0');
/*!40000 ALTER TABLE `qrtz_job_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_locks`
--

DROP TABLE IF EXISTS `qrtz_locks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `lock_name` varchar(40) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_locks`
--

LOCK TABLES `qrtz_locks` WRITE;
/*!40000 ALTER TABLE `qrtz_locks` DISABLE KEYS */;
INSERT INTO `qrtz_locks` VALUES ('HpScheduler','STATE_ACCESS'),('HpScheduler','TRIGGER_ACCESS'),('RuoyiScheduler','STATE_ACCESS'),('RuoyiScheduler','TRIGGER_ACCESS'),('fosutechScheduler','STATE_ACCESS'),('fosutechScheduler','TRIGGER_ACCESS');
/*!40000 ALTER TABLE `qrtz_locks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_paused_trigger_grps`
--

DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_paused_trigger_grps`
--

LOCK TABLES `qrtz_paused_trigger_grps` WRITE;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_paused_trigger_grps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_scheduler_state`
--

DROP TABLE IF EXISTS `qrtz_scheduler_state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `instance_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `last_checkin_time` bigint(13) NOT NULL,
  `checkin_interval` bigint(13) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_scheduler_state`
--

LOCK TABLES `qrtz_scheduler_state` WRITE;
/*!40000 ALTER TABLE `qrtz_scheduler_state` DISABLE KEYS */;
INSERT INTO `qrtz_scheduler_state` VALUES ('HpScheduler','Moe1702813682286',1702814166523,15000),('RuoyiScheduler','53fe071ca0c11547797734583',1552296681699,15000),('fosutechScheduler','Moe1703009694909',1703011544115,15000);
/*!40000 ALTER TABLE `qrtz_scheduler_state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simple_triggers`
--

DROP TABLE IF EXISTS `qrtz_simple_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `repeat_count` bigint(7) NOT NULL,
  `repeat_interval` bigint(12) NOT NULL,
  `times_triggered` bigint(10) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simple_triggers`
--

LOCK TABLES `qrtz_simple_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simple_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simple_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_simprop_triggers`
--

DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `str_prop_1` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `str_prop_2` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `str_prop_3` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `int_prop_1` int(11) DEFAULT NULL,
  `int_prop_2` int(11) DEFAULT NULL,
  `long_prop_1` bigint(20) DEFAULT NULL,
  `long_prop_2` bigint(20) DEFAULT NULL,
  `dec_prop_1` decimal(13,4) DEFAULT NULL,
  `dec_prop_2` decimal(13,4) DEFAULT NULL,
  `bool_prop_1` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `bool_prop_2` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_simprop_triggers`
--

LOCK TABLES `qrtz_simprop_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` DISABLE KEYS */;
/*!40000 ALTER TABLE `qrtz_simprop_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qrtz_triggers`
--

DROP TABLE IF EXISTS `qrtz_triggers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) COLLATE utf8_bin NOT NULL,
  `trigger_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `trigger_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `job_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `job_group` varchar(200) COLLATE utf8_bin NOT NULL,
  `description` varchar(250) COLLATE utf8_bin DEFAULT NULL,
  `next_fire_time` bigint(13) DEFAULT NULL,
  `prev_fire_time` bigint(13) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) COLLATE utf8_bin NOT NULL,
  `trigger_type` varchar(8) COLLATE utf8_bin NOT NULL,
  `start_time` bigint(13) NOT NULL,
  `end_time` bigint(13) DEFAULT NULL,
  `calendar_name` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `misfire_instr` smallint(2) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`) USING BTREE,
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qrtz_triggers`
--

LOCK TABLES `qrtz_triggers` WRITE;
/*!40000 ALTER TABLE `qrtz_triggers` DISABLE KEYS */;
INSERT INTO `qrtz_triggers` VALUES ('RuoyiScheduler','__TASK_CLASS_NAME__1','DEFAULT','__TASK_CLASS_NAME__1','DEFAULT',NULL,1547706280000,-1,5,'PAUSED','CRON',1547706273000,0,NULL,0,'��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0com.hp.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0com.hp.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0countq\0~\0\nL\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0i\"7	xpt\0\0pppt\00/10 * * * * ?t\0系统默认（无参）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0hpTaskt\0\nryNoParamst\0\0t\00t\01x\0'),('RuoyiScheduler','__TASK_CLASS_NAME__2','DEFAULT','__TASK_CLASS_NAME__2','DEFAULT',NULL,1547706280000,-1,5,'PAUSED','CRON',1547706279000,0,NULL,2,''),('fosutechScheduler','__TASK_CLASS_NAME__1','DEFAULT','__TASK_CLASS_NAME__1','DEFAULT',NULL,1702913070000,-1,5,'PAUSED','CRON',1702913066000,0,NULL,-1,'��\0sr\0org.quartz.JobDataMap���迩��\0\0xr\0&org.quartz.utils.StringKeyDirtyFlagMap�����](\0Z\0allowsTransientDataxr\0org.quartz.utils.DirtyFlagMap�.�(v\n�\0Z\0dirtyL\0mapt\0Ljava/util/Map;xpsr\0java.util.HashMap���`�\0F\0\nloadFactorI\0	thresholdxp?@\0\0\0\0\0w\0\0\0\0\0\0t\0__TASK_PROPERTIES__sr\0edu.fosu.quartz.domain.SysJob\0\0\0\0\0\0\0\0L\0cronExpressiont\0Ljava/lang/String;L\0jobGroupq\0~\0	L\0jobIdt\0Ljava/lang/Long;L\0jobNameq\0~\0	L\0\nmethodNameq\0~\0	L\0methodParamsq\0~\0	L\0\rmisfirePolicyq\0~\0	L\0statusq\0~\0	xr\0edu.fosu.common.base.BaseEntity\0\0\0\0\0\0\0\0L\0countq\0~\0\nL\0createByq\0~\0	L\0\ncreateTimet\0Ljava/util/Date;L\0paramsq\0~\0L\0remarkq\0~\0	L\0searchValueq\0~\0	L\0updateByq\0~\0	L\0\nupdateTimeq\0~\0xppt\0adminsr\0java.util.Datehj�KYt\0\0xpw\0\0�{��xpt\0\0pppt\00/10 * * * * ?t\0月数据汇总（按班级）sr\0java.lang.Long;��̏#�\0J\0valuexr\0java.lang.Number������\0\0xp\0\0\0\0\0\0\0t\0fosutechTaskt\0statisticsTeachClassMontht\0\0t\01t\01x\0');
/*!40000 ALTER TABLE `qrtz_triggers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_config`
--

DROP TABLE IF EXISTS `sys_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_config` (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(2000) COLLATE utf8_bin DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) COLLATE utf8_bin DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='参数配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_config`
--

LOCK TABLES `sys_config` WRITE;
/*!40000 ALTER TABLE `sys_config` DISABLE KEYS */;
INSERT INTO `sys_config` VALUES (1,'主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2023-12-05 15:27:11','admin','2023-12-05 15:27:11','蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),(2,'用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','初始化密码 123456'),(3,'oss存储配置','sys.oss.cloudStorage','{\"type\":2,\"qiniuDomain\":\"\",\"qiniuPrefix\":\"upload\",\"qiniuAccessKey\":\"\",\"qiniuSecretKey\":\"\",\"qiniuBucketName\":\"ios-app\",\"aliyunDomain\":\"http://whhp.oss-cn-hangzhou.aliyuncs.com\",\"aliyunPrefix\":\"image/head\",\"aliyunEndPoint\":\"http://oss-cn-hangzhou.aliyuncs.com\",\"aliyunAccessKeyId\":\"LTAIhF7G5e1HF7tt\",\"aliyunAccessKeySecret\":\"BTawwOGhYZuLbag2b1QunDRhcX5UTI\",\"aliyunBucketName\":\"whhp\",\"qcloudDomain\":\"\",\"qcloudPrefix\":\"\",\"qcloudSecretId\":\"\",\"qcloudBucketName\":\"\",\"qcloudRegion\":\"\"}','Y','admin','2023-12-05 15:27:11','','2023-12-05 15:27:11','oss存储配置'),(4,'系统配置化名称','sys.index.SystemName','智慧教育管理平台','Y','admin','2023-12-05 15:27:11','admin','2023-12-05 15:27:11',''),(5,'系统公告滚动','sys.index.radio','测试','Y','admin','2023-12-05 15:27:11','admin','2023-12-05 15:27:11','');
/*!40000 ALTER TABLE `sys_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dept` (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父部门id',
  `ancestors` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) COLLATE utf8_bin DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `leader` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept` VALUES (100,0,'0','智软科技教育有限公司 (总部)',0,'张鹏','13800138000','test@qq.com','0','0','',NULL,'admin','2023-12-19 14:30:44'),(146,100,'0,100','佛山南海 - 智启未来',0,'张三',NULL,NULL,'0','0','admin','2023-12-19 07:28:42','admin','2023-12-19 08:56:57'),(147,100,'0,100','佛山禅城 - 菁智教育',0,'王五',NULL,NULL,'0','0','admin','2023-12-19 08:01:45','admin','2023-12-19 09:03:03'),(148,100,'0,100','广州花都 - 智启未来',1,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:02:47','',NULL),(149,100,'0,100','佛山禅城 - 智启托管',0,NULL,NULL,NULL,'0','0','admin','2023-12-19 08:04:04','admin','2023-12-19 14:30:44'),(150,146,'0,100,146','青教部',0,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:53:24','admin','2023-12-19 08:56:57'),(151,147,'0,100,147','奥教部',0,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:53:42','admin','2023-12-19 09:03:03'),(152,149,'0,100,149','少托部',0,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:53:58','admin','2023-12-19 14:30:44'),(153,146,'0,100,146','高教部',0,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:57:21','',NULL),(154,100,'0,100','测试用户',100,NULL,NULL,NULL,'0','0','admin','2023-12-19 08:58:32','admin','2023-12-19 09:17:14'),(155,100,'0,100','测试2',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:44','',NULL),(156,100,'0,100','测试3',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:50','',NULL),(157,100,'0,100','测试4',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:57','',NULL),(158,100,'0,100','测试5',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:32','',NULL),(159,100,'0,100','测试6',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:44','',NULL),(160,100,'0,100','测试7',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:50','',NULL),(161,100,'0,100','测试8',100,NULL,NULL,NULL,'0','2','admin','2023-12-19 08:58:57','',NULL),(162,147,'0,100,147','青教部',0,NULL,NULL,NULL,'0','2','admin','2023-12-19 12:40:48','',NULL);
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_data`
--

DROP TABLE IF EXISTS `sys_dict_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_data` (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) DEFAULT '0' COMMENT '字典排序',
  `dict_label` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) COLLATE utf8_bin DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='字典数据表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_data`
--

LOCK TABLES `sys_dict_data` WRITE;
/*!40000 ALTER TABLE `sys_dict_data` DISABLE KEYS */;
INSERT INTO `sys_dict_data` VALUES (1,1,'男','0','sys_user_sex','','','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','性别男'),(2,2,'女','1','sys_user_sex','','','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','性别女'),(3,3,'未知','2','sys_user_sex','','','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','性别未知'),(4,1,'显示','0','sys_show_hide','','primary','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','显示菜单'),(5,2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','隐藏菜单'),(6,1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','正常状态'),(7,2,'停用','1','sys_normal_disable','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','停用状态'),(8,1,'正常','0','sys_job_status','','primary','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','正常状态'),(9,2,'暂停','1','sys_job_status','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','停用状态'),(10,1,'是','Y','sys_yes_no','','primary','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','系统默认是'),(11,2,'否','N','sys_yes_no','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','系统默认否'),(12,1,'通知','1','sys_notice_type','','warning','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','通知'),(13,2,'公告','2','sys_notice_type','','success','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','公告'),(14,1,'正常','0','sys_notice_status','','primary','Y','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','正常状态'),(15,2,'关闭','1','sys_notice_status','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','关闭状态'),(16,1,'新增','1','sys_oper_type','','info','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','新增操作'),(17,2,'修改','2','sys_oper_type','','info','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','修改操作'),(18,3,'删除','3','sys_oper_type','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','删除操作'),(19,4,'授权','4','sys_oper_type','','primary','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','授权操作'),(20,5,'导出','5','sys_oper_type','','warning','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','导出操作'),(21,6,'导入','6','sys_oper_type','','warning','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','导入操作'),(22,7,'强退','7','sys_oper_type','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','强退操作'),(23,8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','生成操作'),(24,8,'清空数据','9','sys_oper_type','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','清空操作'),(25,1,'成功','0','sys_common_status','','primary','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','正常状态'),(26,2,'失败','1','sys_common_status','','danger','N','0','admin','2023-12-05 15:27:11','ry','2018-03-16 11:33:00','停用状态'),(32,1,'小学','1','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:06:57',''),(33,2,'初中','2','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:07:04',''),(34,3,'高中','3','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:07:16',''),(35,4,'中专','4','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:07:27',''),(36,5,'中职','5','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:09:45',''),(37,6,'大专','6','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:09:53',''),(38,7,'本科','7','teach_education','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:10:05',''),(39,1,'否','1','teach_basic','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-01-21 17:03:56',''),(40,2,'是','2','teach_basic','','','Y','0','admin','2023-12-05 15:27:11','',NULL,''),(41,1,'义务教育','1','teach_nature','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:21:15',''),(42,2,'高等教育（全日制）','2','teach_nature','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:22:01',''),(43,3,'高等教育（非全日制）','3','teach_nature','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:22:11',''),(44,1,'在读','1','teach_status','','','Y','0','admin','2023-12-05 15:27:11','',NULL,''),(47,4,'退学','4','teach_status','','','Y','0','admin','2023-12-05 15:27:11','',NULL,''),(48,5,'休学','5','teach_status','','','Y','0','admin','2023-12-05 15:27:11','',NULL,''),(49,6,'转线上课程','6','teach_status','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:37:30',''),(50,7,'提前结束（已就业/已毕业）','7','teach_status','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:38:13',''),(51,8,'提前结束（非预期）','8','teach_status','','','Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:38:21',''),(52,9,'班级结课','9','teach_status','','','Y','0','admin','2023-12-05 15:27:11','',NULL,''),(53,2,'是','2','teach_single_parent','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-01-21 17:55:14',''),(54,1,'否','1','teach_single_parent','','','Y','0','admin','2023-12-05 15:27:11','admin','2019-01-21 17:55:21',''),(55,1,'知名度（社会来源）','1','teach_student_source','','','Y','0','1105','2023-12-05 15:27:11','admin','2023-12-19 14:10:36',''),(56,2,'广告投放','2','teach_student_source','','','Y','0','1105','2023-12-05 15:27:11','admin','2023-12-19 14:10:54',''),(58,3,'合作关系','3','teach_student_source','','','Y','0','1105','2023-12-05 15:27:11','admin','2023-12-19 14:11:17',''),(59,2,'复学','2','teach_status',NULL,NULL,'Y','0','1105','2019-04-17 10:03:34','',NULL,NULL),(60,3,'转班','3','teach_status',NULL,NULL,'Y','0','1105','2023-12-05 15:27:11','1105','2019-04-17 10:04:21',NULL),(61,1,'百度云','1','knowledge_source',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(62,2,'其他','2','knowledge_source',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(63,3,'上传','3','knowledge_source',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(68,4,'非高等教育','4','teach_nature',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:22:32',NULL),(69,8,'硕士','8','teach_education',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:10:12',NULL),(70,9,'博士','9','teach_education',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:10:19',NULL),(71,10,'其他','10','teach_education',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2019-07-04 11:10:27',NULL),(72,1,'佛山','1','teach_job_city',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:07:09',NULL),(73,2,'广州','2','teach_job_city',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:07:14',NULL),(76,1,'无','1','teach_english_level',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:06:37',NULL),(77,2,'初级（只学过基本知识）','2','teach_english_level',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:06:52',NULL),(78,3,'中级（能看懂一般的英语）','3','teach_english_level',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:06:12',NULL),(79,4,'高级（能基本上无障碍阅读英语）','4','teach_english_level',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:06:28',NULL),(80,0,'少儿编程','0','teach_major_type',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','admin','2023-12-19 03:09:04',NULL),(81,1,'NOIP信息奥赛','1','teach_major_type',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(82,2,'课外托管','2','teach_major_type',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(83,3,'青少年编程','3','teach_major_type',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(84,4,'IT教育（面向成人）','4','teach_major_type',NULL,NULL,'Y','0','admin','2023-12-05 15:27:11','',NULL,NULL),(85,0,'不需要就业','0','teach_job_city',NULL,NULL,'Y','0','admin','2023-12-19 14:07:31','',NULL,NULL),(86,0,'幼儿园','0','teach_education',NULL,NULL,'Y','0','admin','2023-12-19 16:23:35','',NULL,NULL),(87,0,'未知','0','teach_english_level',NULL,NULL,'Y','0','admin','2023-12-19 17:44:04','',NULL,NULL);
/*!40000 ALTER TABLE `sys_dict_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict_type`
--

DROP TABLE IF EXISTS `sys_dict_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_dict_type` (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '字典类型',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE KEY `dict_type` (`dict_type`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='字典类型表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_type`
--

LOCK TABLES `sys_dict_type` WRITE;
/*!40000 ALTER TABLE `sys_dict_type` DISABLE KEYS */;
INSERT INTO `sys_dict_type` VALUES (1,'用户性别','sys_user_sex','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','用户性别列表'),(2,'菜单状态','sys_show_hide','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','菜单状态列表'),(3,'系统开关','sys_normal_disable','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','系统开关列表'),(4,'任务状态','sys_job_status','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','任务状态列表'),(5,'系统是否','sys_yes_no','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','系统是否列表'),(6,'通知类型','sys_notice_type','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','通知类型列表'),(7,'通知状态','sys_notice_status','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','通知状态列表'),(8,'操作类型','sys_oper_type','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','操作类型列表'),(9,'系统状态','sys_common_status','0','admin','2023-12-05 15:27:11','ry','2023-12-05 15:27:11','登录状态列表'),(11,'学生学历','teach_education','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:20:20','学生学历列表'),(12,'是否有基础','teach_basic','0','admin','2023-12-05 15:27:11','',NULL,'学习本专业的基础'),(13,'学历性质','teach_nature','0','admin','2023-12-05 15:27:11','admin','2023-12-05 15:27:11','学历性质列表'),(14,'学生状态','teach_status','0','admin','2023-12-05 15:27:11','admin','2023-12-19 16:20:33','学生状态列表'),(15,'是否是单亲家庭','teach_single_parent','0','admin','2023-12-05 15:27:11','',NULL,''),(17,'学生来源','teach_student_source','0','1105','2023-12-05 15:27:11','',NULL,'学生来源'),(19,'文件来源','knowledge_source','0','admin','2023-12-05 15:27:11','',NULL,'文件来源'),(20,'专业类型','teach_major_type','0','admin','2023-12-05 15:27:11','',NULL,'专业类型'),(21,'就业城市','teach_job_city','0','admin','2023-12-05 15:27:11','admin','2023-12-19 14:07:47','就业意向城市'),(22,'英语水平','teach_english_level','0','admin','2023-12-05 15:27:11','',NULL,'英语水平');
/*!40000 ALTER TABLE `sys_dict_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job`
--

DROP TABLE IF EXISTS `sys_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` varchar(500) COLLATE utf8_bin DEFAULT '' COMMENT '任务方法',
  `method_params` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '方法参数',
  `cron_expression` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) COLLATE utf8_bin DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='定时任务调度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job`
--

LOCK TABLES `sys_job` WRITE;
/*!40000 ALTER TABLE `sys_job` DISABLE KEYS */;
INSERT INTO `sys_job` VALUES (1,'fosutechTask','月数据汇总（按班级）','statisticsTeachClassMonth','','0/10 * * * * ?','1','1','1','admin','2023-12-18 15:24:26','admin','2023-12-18 15:27:07','');
/*!40000 ALTER TABLE `sys_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_job_log`
--

DROP TABLE IF EXISTS `sys_job_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_job_log` (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '方法参数',
  `job_message` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '日志信息',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) COLLATE utf8_bin DEFAULT '' COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='定时任务调度日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_job_log`
--

LOCK TABLES `sys_job_log` WRITE;
/*!40000 ALTER TABLE `sys_job_log` DISABLE KEYS */;
INSERT INTO `sys_job_log` VALUES (1,'月数据汇总（按班级）','汇总','statisticsTeachClassMonth',NULL,'月数据汇总（按班级） 总共耗时：0毫秒','1','No bean named \'月数据汇总（按班级）\' available','2023-12-18 15:26:50'),(2,'月数据汇总（按班级）','汇总','statisticsTeachClassMonth',NULL,'月数据汇总（按班级） 总共耗时：1毫秒','1','No bean named \'月数据汇总（按班级）\' available','2023-12-18 15:27:00'),(3,'fosutechTask','月数据汇总（按班级）','statisticsTeachClassMonth',NULL,'fosutechTask 总共耗时：33毫秒','0','','2023-12-18 15:27:11'),(4,'fosutechTask','月数据汇总（按班级）','statisticsTeachClassMonth',NULL,'fosutechTask 总共耗时：16毫秒','0','','2023-12-18 15:29:59'),(5,'fosutechTask','月数据汇总（按班级）','statisticsTeachClassMonth',NULL,'fosutechTask 总共耗时：16毫秒','0','','2023-12-18 15:39:02');
/*!40000 ALTER TABLE `sys_job_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_logininfor`
--

DROP TABLE IF EXISTS `sys_logininfor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_logininfor` (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `login_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '操作系统',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='系统访问记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_logininfor`
--

LOCK TABLES `sys_logininfor` WRITE;
/*!40000 ALTER TABLE `sys_logininfor` DISABLE KEYS */;
INSERT INTO `sys_logininfor` VALUES (1,'admin','127.0.0.1','内网IP','Firefox 11','Windows 10','0','登录成功','2023-12-19 10:21:44'),(2,'admin','127.0.0.1','内网IP','Firefox 11','Windows 10','0','登录成功','2023-12-19 11:48:46'),(3,'admin','127.0.0.1','内网IP','Firefox 11','Windows 10','0','登录成功','2023-12-19 12:04:14'),(4,'admin','127.0.0.1','内网IP','Firefox 11','Windows 10','0','登录成功','2023-12-19 15:07:20'),(5,'admin','127.0.0.1','内网IP','Firefox 11','Windows 10','0','登录成功','2023-12-19 18:15:05');
/*!40000 ALTER TABLE `sys_logininfor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父菜单ID',
  `order_num` int(4) DEFAULT '0' COMMENT '显示顺序',
  `url` varchar(200) COLLATE utf8_bin DEFAULT '#' COMMENT '请求地址',
  `menu_type` char(1) COLLATE utf8_bin DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `perms` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) COLLATE utf8_bin DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1258 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',0,8,'#','M','0','','fa fa-gear','admin',NULL,'',NULL,'系统管理目录'),(2,'系统监控',0,6,'#','M','0','','fa fa-video-camera','admin',NULL,'',NULL,'系统监控目录'),(3,'系统工具',0,7,'#','M','0','','fa fa-bars','admin',NULL,'',NULL,'系统工具目录'),(100,'职工管理',1101,1,'/system/user','C','0','system:user:view','#','admin',NULL,'',NULL,'用户管理菜单'),(101,'角色管理',1101,2,'/system/role','C','0','system:role:view','#','admin',NULL,'',NULL,'角色管理菜单'),(102,'菜单管理',1,3,'/system/menu','C','0','system:menu:view','#','admin',NULL,'',NULL,'菜单管理菜单'),(103,'分部管理',1101,4,'/system/dept','C','0','system:dept:view','#','admin',NULL,'',NULL,'部门管理菜单'),(104,'职位管理',1101,5,'/system/post','C','0','system:post:view','#','admin',NULL,'',NULL,'岗位管理菜单'),(105,'字典管理',1,6,'/system/dict','C','0','system:dict:view','#','admin',NULL,'',NULL,'字典管理菜单'),(106,'参数设置',1,7,'/system/config','C','0','system:config:view','#','admin',NULL,'',NULL,'参数设置菜单'),(107,'通知公告',1,8,'/system/notice','C','1','system:notice:view','#','admin',NULL,'',NULL,'通知公告菜单'),(108,'日志管理',1,9,'#','M','0','','#','admin',NULL,'',NULL,'日志管理菜单'),(109,'在线用户',2,1,'/monitor/online','C','0','monitor:online:view','#','admin',NULL,'',NULL,'在线用户菜单'),(110,'定时任务',2,2,'/monitor/job','C','0','monitor:job:view','#','admin',NULL,'',NULL,'定时任务菜单'),(111,'数据监控',2,3,'/monitor/data','C','0','monitor:data:view','#','admin',NULL,'',NULL,'数据监控菜单'),(112,'服务监控',2,3,'/monitor/server','C','0','monitor:server:view','#','admin',NULL,'',NULL,'服务监控菜单'),(113,'表单构建',3,1,'/tool/build','C','0','tool:build:view','#','admin',NULL,'',NULL,'表单构建菜单'),(114,'代码生成',3,2,'/tool/gen','C','0','tool:gen:view','#','admin',NULL,'',NULL,'代码生成菜单'),(115,'系统接口',3,3,'/tool/swagger','C','0','tool:swagger:view','#','admin',NULL,'',NULL,'系统接口菜单'),(500,'操作日志',108,1,'/monitor/operlog','C','0','monitor:operlog:view','#','admin',NULL,'',NULL,'操作日志菜单'),(501,'登录日志',108,2,'/monitor/logininfor','C','0','monitor:logininfor:view','#','admin',NULL,'',NULL,'登录日志菜单'),(1000,'用户查询',100,1,'#','F','0','system:user:list','#','admin',NULL,'',NULL,''),(1001,'用户新增',100,2,'#','F','0','system:user:add','#','admin',NULL,'',NULL,''),(1002,'用户修改',100,3,'#','F','0','system:user:edit','#','admin',NULL,'',NULL,''),(1003,'用户删除',100,4,'#','F','0','system:user:remove','#','admin',NULL,'',NULL,''),(1004,'用户导出',100,5,'#','F','0','system:user:export','#','admin',NULL,'',NULL,''),(1005,'用户导入',100,6,'#','F','0','system:user:import','#','admin',NULL,'',NULL,''),(1006,'重置密码',100,7,'#','F','0','system:user:resetPwd','#','admin',NULL,'',NULL,''),(1007,'角色查询',101,1,'#','F','0','system:role:list','#','admin',NULL,'',NULL,''),(1008,'角色新增',101,2,'#','F','0','system:role:add','#','admin',NULL,'',NULL,''),(1009,'角色修改',101,3,'#','F','0','system:role:edit','#','admin',NULL,'',NULL,''),(1010,'角色删除',101,4,'#','F','0','system:role:remove','#','admin',NULL,'',NULL,''),(1011,'角色导出',101,5,'#','F','0','system:role:export','#','admin',NULL,'',NULL,''),(1012,'菜单查询',102,1,'#','F','0','system:menu:list','#','admin',NULL,'',NULL,''),(1013,'菜单新增',102,2,'#','F','0','system:menu:add','#','admin',NULL,'',NULL,''),(1014,'菜单修改',102,3,'#','F','0','system:menu:edit','#','admin',NULL,'',NULL,''),(1015,'菜单删除',102,4,'#','F','0','system:menu:remove','#','admin',NULL,'',NULL,''),(1016,'校区查询',103,1,'#','F','0','system:dept:list','#','admin',NULL,'',NULL,''),(1017,'校区新增',103,2,'#','F','0','system:dept:add','#','admin',NULL,'',NULL,''),(1018,'校区修改',103,3,'#','F','0','system:dept:edit','#','admin',NULL,'',NULL,''),(1019,'校区删除',103,4,'#','F','0','system:dept:remove','#','admin',NULL,'',NULL,''),(1020,'岗位查询',104,1,'#','F','0','system:post:list','#','admin',NULL,'',NULL,''),(1021,'岗位新增',104,2,'#','F','0','system:post:add','#','admin',NULL,'',NULL,''),(1022,'岗位修改',104,3,'#','F','0','system:post:edit','#','admin',NULL,'',NULL,''),(1023,'岗位删除',104,4,'#','F','0','system:post:remove','#','admin',NULL,'',NULL,''),(1024,'岗位导出',104,5,'#','F','0','system:post:export','#','admin',NULL,'',NULL,''),(1025,'字典查询',105,1,'#','F','0','system:dict:list','#','admin',NULL,'',NULL,''),(1026,'字典新增',105,2,'#','F','0','system:dict:add','#','admin',NULL,'',NULL,''),(1027,'字典修改',105,3,'#','F','0','system:dict:edit','#','admin',NULL,'',NULL,''),(1028,'字典删除',105,4,'#','F','0','system:dict:remove','#','admin',NULL,'',NULL,''),(1029,'字典导出',105,5,'#','F','0','system:dict:export','#','admin',NULL,'',NULL,''),(1030,'参数查询',106,1,'#','F','0','system:config:list','#','admin',NULL,'',NULL,''),(1031,'参数新增',106,2,'#','F','0','system:config:add','#','admin',NULL,'',NULL,''),(1032,'参数修改',106,3,'#','F','0','system:config:edit','#','admin',NULL,'',NULL,''),(1033,'参数删除',106,4,'#','F','0','system:config:remove','#','admin',NULL,'',NULL,''),(1034,'参数导出',106,5,'#','F','0','system:config:export','#','admin',NULL,'',NULL,''),(1035,'公告查询',107,1,'#','F','0','system:notice:list','#','admin',NULL,'',NULL,''),(1036,'公告新增',107,2,'#','F','0','system:notice:add','#','admin',NULL,'',NULL,''),(1037,'公告修改',107,3,'#','F','0','system:notice:edit','#','admin',NULL,'',NULL,''),(1038,'公告删除',107,4,'#','F','0','system:notice:remove','#','admin',NULL,'',NULL,''),(1039,'操作查询',500,1,'#','F','0','monitor:operlog:list','#','admin',NULL,'',NULL,''),(1040,'操作删除',500,2,'#','F','0','monitor:operlog:remove','#','admin',NULL,'',NULL,''),(1041,'详细信息',500,3,'#','F','0','monitor:operlog:detail','#','admin',NULL,'',NULL,''),(1042,'日志导出',500,4,'#','F','0','monitor:operlog:export','#','admin',NULL,'',NULL,''),(1043,'登录查询',501,1,'#','F','0','monitor:logininfor:list','#','admin',NULL,'',NULL,''),(1044,'登录删除',501,2,'#','F','0','monitor:logininfor:remove','#','admin',NULL,'',NULL,''),(1045,'日志导出',501,3,'#','F','0','monitor:logininfor:export','#','admin',NULL,'',NULL,''),(1046,'在线查询',109,1,'#','F','0','monitor:online:list','#','admin',NULL,'',NULL,''),(1047,'批量强退',109,2,'#','F','0','monitor:online:batchForceLogout','#','admin',NULL,'',NULL,''),(1048,'单条强退',109,3,'#','F','0','monitor:online:forceLogout','#','admin',NULL,'',NULL,''),(1049,'任务查询',110,1,'#','F','0','monitor:job:list','#','admin',NULL,'',NULL,''),(1050,'任务新增',110,2,'#','F','0','monitor:job:add','#','admin',NULL,'',NULL,''),(1051,'任务修改',110,3,'#','F','0','monitor:job:edit','#','admin',NULL,'',NULL,''),(1052,'任务删除',110,4,'#','F','0','monitor:job:remove','#','admin',NULL,'',NULL,''),(1053,'状态修改',110,5,'#','F','0','monitor:job:changeStatus','#','admin',NULL,'',NULL,''),(1054,'任务详细',110,6,'#','F','0','monitor:job:detail','#','admin',NULL,'',NULL,''),(1055,'任务导出',110,7,'#','F','0','monitor:job:export','#','admin',NULL,'',NULL,''),(1056,'生成查询',114,1,'#','F','0','tool:gen:list','#','admin',NULL,'',NULL,''),(1057,'生成代码',114,2,'#','F','0','tool:gen:code','#','admin',NULL,'',NULL,''),(1058,'学生管理',0,2,'#','M','0','','fa fa-address-card-o','admin',NULL,'',NULL,''),(1062,'数据汇总',0,4,'#','M','0','','fa fa-bar-chart','admin',NULL,'',NULL,''),(1063,'学生档案',1058,1,'/teach/student','C','0','teach:student:view','#','admin',NULL,'',NULL,''),(1064,'学生查询',1063,1,'#','F','0','teach:student:list','#','admin',NULL,'',NULL,''),(1065,'学生新增',1063,2,'#','F','0','teach:student:add','#','admin',NULL,'',NULL,''),(1066,'学生修改',1063,3,'#','F','0','teach:student:edit','#','admin',NULL,'',NULL,''),(1067,'学生删除',1063,4,'#','F','0','teach:student:remove','#','admin',NULL,'',NULL,''),(1068,'学生导入',1063,5,'#','F','0','teach:student:import','#','admin',NULL,'',NULL,''),(1069,'学生导出',1063,6,'#','F','0','teach:student:export','#','admin',NULL,'',NULL,''),(1070,'地区菜单',3,1,'/system/districts','C','0','system:districts:view','#','admin',NULL,'',NULL,'地区菜单'),(1071,'地区查询',1070,1,'#','F','0','system:districts:list','#','admin',NULL,'',NULL,''),(1072,'地区新增',1070,2,'#','F','0','system:districts:add','#','admin',NULL,'',NULL,''),(1073,'地区修改',1070,3,'#','F','0','system:districts:edit','#','admin',NULL,'',NULL,''),(1074,'地区删除',1070,4,'#','F','0','system:districts:remove','#','admin',NULL,'',NULL,''),(1075,'文件管理',1,10,'/system/oss','C','1','system:oss:view','#','admin',NULL,'',NULL,''),(1076,'文件上传',1056,1,'#','F','0','system:oss:add','#','admin',NULL,'',NULL,''),(1077,'文件删除',1056,2,'#','F','0','system:oss:remove','#','admin',NULL,'',NULL,''),(1078,'文件配置',1056,3,'#','F','0','system:oss:config','#','admin',NULL,'',NULL,''),(1079,'文件修改',1056,4,'#','F','0','system:oss:remove','#','admin',NULL,'',NULL,''),(1101,'学校管理',0,0,'','M','0','','fa fa-institution','admin',NULL,'',NULL,''),(1102,'专业设置',1101,2,'/teach/teachMajor','C','0','teach:teachMajor:view','#','admin',NULL,'',NULL,''),(1104,'班级管理',0,1,'#','M','0','','fa fa-users','admin',NULL,'',NULL,''),(1105,'班级列表',1104,1,'/teach/teachClasses','C','0','teach:teachClasses:view','#','admin',NULL,'',NULL,''),(1106,'月度考核标准',1101,5,'/teach/teachAssessMonth','C','0','teach:teachAssessMonth:view','#','admin',NULL,'',NULL,''),(1107,'考核设置',1101,3,'/teach/teachAssessmentCriterion','C','0','teach:teachAssessmentCriterion:view','#','admin',NULL,'',NULL,''),(1113,'考核标准查询',1107,1,'#','F','0','teach:teachAssessmentCriterion:list','#','admin',NULL,'',NULL,''),(1114,'考核标准新增',1107,2,'#','F','0','teach:teachAssessmentCriterion:add','#','admin',NULL,'',NULL,''),(1115,'考核标准修改',1107,3,'#','F','0','teach:teachAssessmentCriterion:edit','#','admin',NULL,'',NULL,''),(1116,'考核标准删除',1107,4,'#','F','0','teach:teachAssessmentCriterion:remove','#','admin',NULL,'',NULL,''),(1121,'月度考核标准查询',1106,1,'#','F','0','teach:teachAssessMonth:list','#','admin',NULL,'',NULL,''),(1122,'月度考核标准新增',1106,2,'#','F','0','teach:teachAssessMonth:add','#','admin',NULL,'',NULL,''),(1123,'月度考核标准修改',1106,3,'#','F','0','teach:teachAssessMonth:edit','#','admin',NULL,'',NULL,''),(1124,'月度考核标准删除',1106,4,'#','F','0','teach:teachAssessMonth:remove','#','admin',NULL,'',NULL,''),(1125,'专业查询',1102,1,'#','F','0','teach:teachMajor:list','#','admin',NULL,'',NULL,''),(1126,'专业新增',1102,2,'#','F','0','teach:teachMajor:add','#','admin',NULL,'',NULL,''),(1127,'专业修改',1102,3,'#','F','0','teach:teachMajor:edit','#','admin',NULL,'',NULL,''),(1128,'专业删除',1102,4,'#','F','0','teach:teachMajor:remove','#','admin',NULL,'',NULL,''),(1129,'班级查询',1105,1,'#','F','0','teach:teachClasses:list','#','admin',NULL,'',NULL,''),(1130,'班级新增',1105,2,'#','F','0','teach:teachClasses:add','#','admin',NULL,'',NULL,''),(1131,'班级修改',1105,3,'#','F','0','teach:teachClasses:edit','#','admin',NULL,'',NULL,''),(1132,'班级删除',1105,4,'#','F','0','teach:teachClasses:remove','#','admin',NULL,'',NULL,''),(1133,'班级考勤',1104,2,'/teach/teachAttendance','C','0','teach:teachAttendance:view','#','admin',NULL,'',NULL,'班级考勤菜单'),(1134,'班级考勤查询',1133,1,'#','F','0','teach:teachAttendance:list','#','admin',NULL,'',NULL,''),(1135,'班级考勤新增',1133,2,'#','F','0','teach:teachAttendance:add','#','admin',NULL,'',NULL,''),(1136,'班级考勤修改',1133,3,'#','F','0','teach:teachAttendance:edit','#','admin',NULL,'',NULL,''),(1137,'班级考勤删除',1133,4,'#','F','0','teach:teachAttendance:remove','#','admin',NULL,'',NULL,''),(1148,'班级作业',1104,4,'/teach/teachJob','C','0','teach:teachJob:view','#','admin',NULL,'',NULL,''),(1149,'班级作业查询',1148,1,'#','F','0','teach:teachJob:list','#','admin',NULL,'',NULL,''),(1150,'班级作业新增',1148,2,'#','F','0','teach:teachJob:add','#','admin',NULL,'',NULL,''),(1151,'班级作业修改',1148,3,'#','F','0','teach:teachJob:edit','#','admin',NULL,'',NULL,''),(1152,'班级作业删除',1148,4,'#','F','0','teach:teachJob:remove','#','admin',NULL,'',NULL,''),(1153,'班级考试',1104,3,'/teach/teachExam','C','0','teach:teachExam:view','#','admin',NULL,'',NULL,''),(1154,'班级考试查询',1153,1,'#','F','0','teach:teachExam:list','#','admin',NULL,'',NULL,''),(1155,'班级考试新增',1153,2,'#','F','0','teach:teachExam:add','#','admin',NULL,'',NULL,''),(1156,'班级考试修改',1153,3,'#','F','0','teach:teachExam:edit','#','admin',NULL,'',NULL,''),(1157,'班级考试删除',1153,4,'#','F','0','teach:teachExam:remove','#','admin',NULL,'',NULL,''),(1163,'评教管理',0,3,'#','M','0','','fa fa-heart','admin',NULL,'',NULL,''),(1164,'课程满意度',1163,1,'/teach/teachSatisfaction','C','0','teach:teachSatisfaction:view','#','admin',NULL,'',NULL,''),(1165,'满意度查询',1164,1,'#','F','0','teach:teachSatisfaction:list','#','admin',NULL,'',NULL,''),(1166,'满意度新增',1164,2,'#','F','0','teach:teachSatisfaction:add','#','admin',NULL,'',NULL,''),(1167,'满意度修改',1164,3,'#','F','0','teach:teachSatisfaction:edit','#','admin',NULL,'',NULL,''),(1168,'满意度删除',1164,4,'#','F','0','teach:teachSatisfaction:remove','#','admin',NULL,'',NULL,''),(1174,'抽查归档',0,5,'#','M','0','','fa fa-binoculars','admin',NULL,'',NULL,''),(1175,'总部督查（项目）',1174,1,'/teach/teachSupervisionSubject','C','0','teach:teachSupervisionSubject:view','#','admin',NULL,'',NULL,''),(1176,'总部督查（考试）',1174,2,'/teach/teachSupervisionExam','C','0','teach:teachSupervisionExam:view','#','admin',NULL,'',NULL,''),(1177,'数据汇总（班级）',1062,10,'/teach/teachClassStatistics','C','0','teach:teachClassStatistics:view','#','admin',NULL,'',NULL,''),(1178,'数据汇总（专业）',1062,20,'/teach/teachMajorStatistics','C','0','teach:teachMajorStatistics:view','#','admin',NULL,'',NULL,''),(1179,'数据汇总（老师）',1062,30,'/teach/teachTeacherStatistics','C','0','teach:teachTeacherStatistics:view','#','admin',NULL,'',NULL,''),(1180,'班级项目',1104,5,'/teach/teachSubject','C','0','teach:teachSubject:view','#','admin',NULL,'',NULL,''),(1181,'班级项目查询',1180,1,'#','F','0','teach:teachSubject:list','#','admin',NULL,'',NULL,''),(1182,'班级项目新增',1180,2,'#','F','0','teach:teachSubject:add','#','admin',NULL,'',NULL,''),(1183,'班级项目修改',1180,3,'#','F','0','teach:teachSubject:edit','#','admin',NULL,'',NULL,''),(1184,'班级项目删除',1180,4,'#','F','0','teach:teachSubject:remove','#','admin',NULL,'',NULL,''),(1185,'总部督查考试查询',1176,1,'#','F','0','teach:teachSupervisionExam:list','#','admin',NULL,'',NULL,''),(1186,'总部督查考试新增',1176,2,'#','F','0','teach:teachSupervisionExam:add','#','admin',NULL,'',NULL,''),(1187,'总部督查考试修改',1176,3,'#','F','0','teach:teachSupervisionExam:edit','#','admin',NULL,'',NULL,''),(1188,'总部督查考试删除',1176,4,'#','F','0','teach:teachSupervisionExam:remove','#','admin',NULL,'',NULL,''),(1189,'总部督查项目查询',1175,1,'#','F','0','teach:teachSupervisionSubject:list','#','admin',NULL,'',NULL,''),(1190,'总部督查项目新增',1175,2,'#','F','0','teach:teachSupervisionSubject:add','#','admin',NULL,'',NULL,''),(1191,'总部督查项目修改',1175,3,'#','F','0','teach:teachSupervisionSubject:edit','#','admin',NULL,'',NULL,''),(1192,'总部督查项目删除',1175,4,'#','F','0','teach:teachSupervisionSubject:remove','#','admin',NULL,'',NULL,''),(1193,'数据汇总（班级）查询',1177,1,'#','F','0','teach:teachClassStatistics:list','#','admin',NULL,'',NULL,''),(1194,'数据汇总（班级）新增',1177,2,'#','F','0','teach:teachClassStatistics:add','#','admin',NULL,'',NULL,''),(1195,'数据汇总（班级）修改',1177,3,'#','F','0','teach:teachClassStatistics:edit','#','admin',NULL,'',NULL,''),(1196,'数据汇总（班级）删除',1177,4,'#','F','0','teach:teachClassStatistics:remove','#','admin',NULL,'',NULL,''),(1197,'数据汇总（专业）查询',1178,1,'#','F','0','teach:teachMajorStatistics:list','#','admin',NULL,'',NULL,''),(1198,'数据汇总（专业）新增',1178,2,'#','F','0','teach:teachMajorStatistics:add','#','admin',NULL,'',NULL,''),(1199,'数据汇总（专业）修改',1178,3,'#','F','0','teach:teachMajorStatistics:edit','#','admin',NULL,'',NULL,''),(1200,'数据汇总（专业）删除',1178,4,'#','F','0','teach:teachMajorStatistics:remove','#','admin',NULL,'',NULL,''),(1201,'数据汇总（教师）查询',1179,1,'#','F','0','teach:teachTeacherStatistics:list','#','admin',NULL,'',NULL,''),(1202,'数据汇总（教师）新增',1179,2,'#','F','0','teach:teachTeacherStatistics:add','#','admin',NULL,'',NULL,''),(1203,'数据汇总（教师）修改',1179,3,'#','F','0','teach:teachTeacherStatistics:edit','#','admin',NULL,'',NULL,''),(1209,'就业信息',1104,6,'/teach/teachStudentEmployment','C','0','teach:teachStudentEmployment:view','#','admin',NULL,'',NULL,''),(1210,'学生就业查询',1209,1,'#','F','0','teach:teachStudentEmployment:list','#','admin',NULL,'',NULL,''),(1211,'学生就业新增',1209,2,'#','F','0','teach:teachStudentEmployment:add','#','admin',NULL,'',NULL,''),(1212,'学生就业修改',1209,3,'#','F','0','teach:teachStudentEmployment:edit','#','admin',NULL,'',NULL,''),(1213,'学生就业删除',1209,4,'#','F','0','teach:teachStudentEmployment:remove','#','admin',NULL,'',NULL,''),(1214,'更改学员状态',1063,8,'#','F','0','teach:student:updateState','#','1105',NULL,'',NULL,''),(1215,'详情',1063,7,'#','F','0','teach:student:detail','#','1105',NULL,'',NULL,''),(1216,'考试子表（详情中的查询）',1063,9,'#','F','0','teach:teachStudentExam:list','#','1105',NULL,'',NULL,''),(1218,'作业子表（详情中的查询）',1063,9,'#','F','0','teach:teachStudentJob:list','#','1105',NULL,'',NULL,''),(1219,'项目子表（详情中的查询）',1063,9,'#','F','0','teach:teachStudentSubject:list','#','1105',NULL,'',NULL,''),(1220,'考勤子表（详情中的查询）',1063,9,'#','F','0','teach:teachStudentAttendance:list','#','1105',NULL,'',NULL,''),(1221,'老师列表',1105,9,'#','F','0','system:user:list','#','admin',NULL,'',NULL,''),(1222,'班级考勤统计',1133,8,'#','F','0','teach:teachMajorStage:list','#','admin',NULL,'',NULL,''),(1223,'班级详情',1105,6,'#','F','0','teach:teachClasses:detail','#','admin',NULL,'',NULL,''),(1224,'专业阶段',1102,9,'#','F','0','teach:teachMajorStage:list','#','1105',NULL,'',NULL,''),(1225,'考核子表',1107,9,'#','F','0','teach:teachInspectionItems:list','#','admin',NULL,'',NULL,''),(1226,'教师阶段',1105,9,'#','F','0','teach:teachClassesTeacher:list','#','admin',NULL,'',NULL,''),(1228,'学生导入模板',1063,9,'#','F','0','system:user:view','#','1105',NULL,'',NULL,''),(1229,'投诉建议',1163,3,'/teach/teachSatisfaction','C','1','','#','admin',NULL,'',NULL,''),(1230,'考核详情',1107,9,'#','F','0','teach:teachAssessmentCriterion:detail','#','1105',NULL,'',NULL,''),(1231,'就业详情',1209,9,'#','F','0','teach:teachStudentEmployment:detail','#','1105',NULL,'',NULL,''),(1232,'非在读学员查询',1133,9,'#','F','0','teach:student:classOtherStudents','#','1105',NULL,'',NULL,''),(1233,'非在读学员查询',1209,9,'#','F','0','teach:student:classOtherStudents','#','1105',NULL,'',NULL,''),(1234,'在读学员查询',1133,99,'#','F','0','teach:student:classStudents','#','admin',NULL,'',NULL,''),(1235,'考勤详情',1133,99,'#','F','0','teach:teachAttendance:detail','#','admin',NULL,'',NULL,''),(1236,'考试详情',1153,99,'#','F','0','teach:teachExam:detail','#','admin',NULL,'',NULL,''),(1237,'作业详情',1148,99,'#','F','0','teach:teachJob:detail','#','admin',NULL,'',NULL,''),(1238,'项目详情',1180,99,'#','F','0','teach:teachSubject:detail','#','admin',NULL,'',NULL,''),(1239,'详情状态记录查询',1063,9,'#','F','0','teach:teachStatusRecord:list','#','1105',NULL,'',NULL,''),(1240,'学生信息导入模版说明',1063,9,'#','F','0','teach:student:examine','#','admin',NULL,'',NULL,''),(1241,'班级结课',1105,10,'#','F','0','teach:teachClasses:change','#','admin',NULL,'',NULL,''),(1242,'班级结课',1104,10,'#','F','0','teach:teachClasses:change','#','admin',NULL,'',NULL,''),(1243,'老师列表',1209,9,'#','F','0','system:user:list','#','1105',NULL,'',NULL,''),(1244,'知识管理',0,4,'#','M','0','','fa fa-key','1105',NULL,'',NULL,''),(1245,'菜单管理',1244,1,'/knowledge/knowledgeMenu','C','0','knowledge:knowledgeMenu:view','#','1105',NULL,'',NULL,''),(1246,'文件管理',1244,2,'/knowledge/knowledgeOss','C','0','knowledge:knowledgeOss:view','#','1105',NULL,'',NULL,''),(1247,'菜单管理列表',1245,1,'#','F','0','knowledge:knowledgeMenu:list','#','1105',NULL,'',NULL,''),(1248,'菜单新增',1245,2,'#','F','0','knowledge:knowledgeMenu:add','#','1105',NULL,'',NULL,''),(1249,'菜单修改',1245,3,'#','F','0','knowledge:knowledgeMenu:edit','#','1105',NULL,'',NULL,''),(1250,'菜单删除',1245,4,'#','F','0','knowledge:knowledgeMenu:remove','#','1105',NULL,'',NULL,''),(1251,'文件列表',1246,1,'#','F','0','knowledge:knowledgeOss:list','#','1105',NULL,'',NULL,''),(1252,'文件上传',1246,2,'#','F','0','knowledge:knowledgeOss:add','#','1105',NULL,'',NULL,''),(1253,'文件编辑',1246,3,'#','F','0','knowledge:knowledgeOss:edit','#','1105',NULL,'',NULL,''),(1254,'文件删除',1246,3,'#','F','0','knowledge:knowledgeOss:remove','#','1105',NULL,'',NULL,''),(1255,'云存储',1246,5,'#','F','0','knowledge:knowledgeOss:config','#','1105',NULL,'',NULL,''),(1256,'结合editor',1246,6,'#','F','0','knowledge:knowledgeOss:add','#','1105',NULL,'',NULL,''),(1257,'档案收集',1058,2,'/teach/teachFileCollection','M','0','teach:teachFileCollection:view','#','admin',NULL,'',NULL,'');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_notice` (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '公告标题',
  `notice_type` char(1) COLLATE utf8_bin NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` varchar(2000) COLLATE utf8_bin DEFAULT NULL COMMENT '公告内容',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oper_log`
--

DROP TABLE IF EXISTS `sys_oper_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_oper_log` (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '方法名称',
  `operator_type` int(1) DEFAULT '0' COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) COLLATE utf8_bin DEFAULT '' COMMENT '请求参数',
  `status` int(1) DEFAULT '0' COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) COLLATE utf8_bin DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='操作日志记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oper_log`
--

LOCK TABLES `sys_oper_log` WRITE;
/*!40000 ALTER TABLE `sys_oper_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_oper_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_oss`
--

DROP TABLE IF EXISTS `sys_oss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_oss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(64) NOT NULL DEFAULT '' COMMENT '文件名',
  `file_suffix` varchar(10) NOT NULL DEFAULT '' COMMENT '文件后缀名',
  `url` varchar(200) NOT NULL COMMENT 'URL地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) NOT NULL DEFAULT '' COMMENT '上传人',
  `service` tinyint(2) NOT NULL DEFAULT '1' COMMENT '服务商',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='文件上传';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_oss`
--

LOCK TABLES `sys_oss` WRITE;
/*!40000 ALTER TABLE `sys_oss` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_oss` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_post`
--

DROP TABLE IF EXISTS `sys_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_post` (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) COLLATE utf8_bin NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='岗位信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_post`
--

LOCK TABLES `sys_post` WRITE;
/*!40000 ALTER TABLE `sys_post` DISABLE KEYS */;
INSERT INTO `sys_post` VALUES (1,'0','管理员',0,'0','admin','2023-12-17 15:19:45','',NULL,NULL),(4,'10001','测试',0,'0','admin','2023-12-19 09:06:39','',NULL,NULL);
/*!40000 ALTER TABLE `sys_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) COLLATE utf8_bin DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限）',
  `status` char(1) COLLATE utf8_bin NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='角色信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','admin',0,'1','0','0','admin','2018-03-16 11:33:00','admin','2023-12-19 04:07:28','管理员'),(5,'教师','teacher',3,'1','0','0','admin','2023-12-19 04:07:13','admin','2023-12-19 04:08:40',NULL),(6,'班主任','classleader',1,'1','0','0','admin','2023-12-18 12:49:03','admin','2023-12-19 04:07:20',NULL),(7,'助教','assisteacher',2,'1','0','0','admin','2023-12-19 04:08:26','admin','2023-12-19 04:08:36',NULL),(8,'教务 (部门)','teacherLeader',5,'1','0','0','admin','2023-12-19 06:36:11','admin','2023-12-19 09:07:59',NULL),(10,'测试','test',100,'1','0','2','admin','2023-12-19 06:56:27','',NULL,NULL),(11,'主管 (部门)','director',6,'1','0','0','admin','2023-12-19 06:38:07','admin','2023-12-19 06:38:11',NULL),(12,'测试1','test1',101,'1','0','0','admin','2023-12-19 06:56:43','',NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_dept`
--

DROP TABLE IF EXISTS `sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_dept` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`,`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='角色和部门关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_dept`
--

LOCK TABLES `sys_role_dept` WRITE;
/*!40000 ALTER TABLE `sys_role_dept` DISABLE KEYS */;
INSERT INTO `sys_role_dept` VALUES (4,100),(4,101),(4,104),(4,113),(4,114);
/*!40000 ALTER TABLE `sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_menu`
--

DROP TABLE IF EXISTS `sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_menu` (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='角色和菜单关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_menu`
--

LOCK TABLES `sys_role_menu` WRITE;
/*!40000 ALTER TABLE `sys_role_menu` DISABLE KEYS */;
INSERT INTO `sys_role_menu` VALUES (1,1),(1,2),(1,3),(1,100),(1,101),(1,102),(1,103),(1,104),(1,105),(1,106),(1,107),(1,108),(1,109),(1,110),(1,111),(1,112),(1,113),(1,114),(1,115),(1,500),(1,501),(1,1000),(1,1001),(1,1002),(1,1003),(1,1004),(1,1005),(1,1006),(1,1007),(1,1008),(1,1009),(1,1010),(1,1011),(1,1012),(1,1013),(1,1014),(1,1015),(1,1016),(1,1017),(1,1018),(1,1019),(1,1020),(1,1021),(1,1022),(1,1023),(1,1024),(1,1025),(1,1026),(1,1027),(1,1028),(1,1029),(1,1030),(1,1031),(1,1032),(1,1033),(1,1034),(1,1035),(1,1036),(1,1037),(1,1038),(1,1039),(1,1040),(1,1041),(1,1042),(1,1043),(1,1044),(1,1045),(1,1046),(1,1047),(1,1048),(1,1049),(1,1050),(1,1051),(1,1052),(1,1053),(1,1054),(1,1055),(1,1056),(1,1057),(1,1058),(1,1062),(1,1063),(1,1064),(1,1065),(1,1066),(1,1067),(1,1068),(1,1069),(1,1070),(1,1071),(1,1072),(1,1073),(1,1074),(1,1075),(1,1076),(1,1077),(1,1078),(1,1079),(1,1101),(1,1102),(1,1104),(1,1105),(1,1106),(1,1107),(1,1113),(1,1114),(1,1115),(1,1116),(1,1121),(1,1122),(1,1123),(1,1124),(1,1125),(1,1126),(1,1127),(1,1128),(1,1129),(1,1130),(1,1131),(1,1132),(1,1133),(1,1134),(1,1135),(1,1136),(1,1137),(1,1148),(1,1149),(1,1150),(1,1151),(1,1152),(1,1153),(1,1154),(1,1155),(1,1156),(1,1157),(1,1163),(1,1164),(1,1165),(1,1166),(1,1167),(1,1168),(1,1174),(1,1175),(1,1176),(1,1177),(1,1178),(1,1179),(1,1180),(1,1181),(1,1182),(1,1183),(1,1184),(1,1185),(1,1186),(1,1187),(1,1188),(1,1189),(1,1190),(1,1191),(1,1192),(1,1193),(1,1194),(1,1195),(1,1196),(1,1197),(1,1198),(1,1199),(1,1200),(1,1201),(1,1202),(1,1203),(1,1209),(1,1210),(1,1211),(1,1212),(1,1213),(1,1214),(1,1215),(1,1216),(1,1218),(1,1219),(1,1220),(1,1221),(1,1222),(1,1223),(1,1224),(1,1225),(1,1226),(1,1228),(1,1229),(1,1230),(1,1231),(1,1232),(1,1233),(1,1234),(1,1235),(1,1236),(1,1237),(1,1238),(1,1239),(1,1240),(1,1241),(1,1242),(1,1243),(1,1244),(1,1245),(1,1246),(1,1247),(1,1248),(1,1249),(1,1250),(1,1251),(1,1252),(1,1253),(1,1254),(1,1255),(1,1256),(1,1257),(2,1),(2,2),(2,3),(2,100),(2,101),(2,102),(2,103),(2,104),(2,105),(2,106),(2,107),(2,108),(2,109),(2,110),(2,111),(2,112),(2,113),(2,114),(2,115),(2,500),(2,501),(2,1000),(2,1001),(2,1002),(2,1003),(2,1004),(2,1005),(2,1006),(2,1007),(2,1008),(2,1009),(2,1010),(2,1011),(2,1012),(2,1013),(2,1014),(2,1015),(2,1016),(2,1017),(2,1018),(2,1019),(2,1020),(2,1021),(2,1022),(2,1023),(2,1024),(2,1025),(2,1026),(2,1027),(2,1028),(2,1029),(2,1030),(2,1031),(2,1032),(2,1033),(2,1034),(2,1035),(2,1036),(2,1037),(2,1038),(2,1039),(2,1040),(2,1041),(2,1042),(2,1043),(2,1044),(2,1045),(2,1046),(2,1047),(2,1048),(2,1049),(2,1050),(2,1051),(2,1052),(2,1053),(2,1054),(2,1055),(2,1056),(2,1057),(2,1070),(2,1071),(2,1072),(2,1073),(2,1074),(2,1075),(2,1076),(2,1077),(2,1078),(2,1079),(2,1090),(2,1091),(2,1092),(2,1093),(3,1),(3,2),(3,3),(3,100),(3,101),(3,102),(3,103),(3,104),(3,105),(3,106),(3,107),(3,108),(3,109),(3,110),(3,111),(3,112),(3,113),(3,114),(3,115),(3,500),(3,501),(3,1000),(3,1001),(3,1002),(3,1003),(3,1004),(3,1005),(3,1006),(3,1007),(3,1008),(3,1009),(3,1010),(3,1011),(3,1012),(3,1013),(3,1014),(3,1015),(3,1016),(3,1017),(3,1018),(3,1019),(3,1020),(3,1021),(3,1022),(3,1023),(3,1024),(3,1025),(3,1026),(3,1027),(3,1028),(3,1029),(3,1030),(3,1031),(3,1032),(3,1033),(3,1034),(3,1035),(3,1036),(3,1037),(3,1038),(3,1039),(3,1040),(3,1041),(3,1042),(3,1043),(3,1044),(3,1045),(3,1046),(3,1047),(3,1048),(3,1049),(3,1050),(3,1051),(3,1052),(3,1053),(3,1054),(3,1055),(3,1056),(3,1057),(3,1058),(3,1062),(3,1063),(3,1064),(3,1065),(3,1066),(3,1067),(3,1068),(3,1069),(3,1070),(3,1071),(3,1072),(3,1073),(3,1074),(3,1075),(3,1076),(3,1077),(3,1078),(3,1079),(3,1101),(3,1102),(3,1104),(3,1105),(3,1106),(3,1107),(3,1113),(3,1114),(3,1115),(3,1116),(3,1121),(3,1122),(3,1123),(3,1124),(3,1125),(3,1126),(3,1127),(3,1128),(3,1129),(3,1130),(3,1131),(3,1132),(3,1133),(3,1134),(3,1135),(3,1136),(3,1137),(3,1148),(3,1149),(3,1150),(3,1151),(3,1152),(3,1153),(3,1154),(3,1155),(3,1156),(3,1157),(3,1163),(3,1164),(3,1165),(3,1166),(3,1167),(3,1168),(3,1174),(3,1175),(3,1176),(3,1180),(3,1181),(3,1182),(3,1183),(3,1184),(3,1185),(3,1186),(3,1187),(3,1188),(3,1189),(3,1190),(3,1191),(3,1192),(3,1209),(3,1210),(3,1211),(3,1212),(3,1213),(3,1214),(3,1215),(3,1216),(3,1218),(3,1219),(3,1220),(3,1221),(3,1222),(3,1223),(3,1224),(3,1225),(3,1226),(3,1228),(3,1229),(3,1230),(3,1231),(3,1232),(3,1233),(3,1234),(3,1235),(3,1236),(3,1237),(3,1238),(3,1239),(3,1240),(3,1241),(3,1242),(3,1243),(3,1244),(3,1245),(3,1246),(3,1247),(3,1248),(3,1249),(3,1250),(3,1251),(3,1252),(3,1253),(3,1254),(3,1255),(3,1256),(3,1257),(4,1058),(4,1063),(4,1064),(4,1065),(4,1066),(4,1067),(4,1068),(4,1069),(4,1101),(4,1102),(4,1104),(4,1105),(4,1106),(4,1107),(4,1113),(4,1114),(4,1115),(4,1116),(4,1121),(4,1122),(4,1123),(4,1124),(4,1125),(4,1126),(4,1127),(4,1128),(4,1129),(4,1130),(4,1131),(4,1132),(4,1133),(4,1134),(4,1135),(4,1136),(4,1137),(4,1148),(4,1149),(4,1150),(4,1151),(4,1152),(4,1153),(4,1154),(4,1155),(4,1156),(4,1157),(4,1163),(4,1164),(4,1165),(4,1166),(4,1167),(4,1168),(4,1180),(4,1181),(4,1182),(4,1183),(4,1184),(4,1209),(4,1210),(4,1211),(4,1212),(4,1213),(5,1),(5,2),(5,3),(5,103),(5,109),(5,110),(5,111),(5,112),(5,113),(5,114),(5,115),(5,1016),(5,1046),(5,1047),(5,1048),(5,1049),(5,1050),(5,1051),(5,1052),(5,1053),(5,1054),(5,1055),(5,1056),(5,1057),(5,1058),(5,1062),(5,1063),(5,1064),(5,1065),(5,1066),(5,1068),(5,1069),(5,1070),(5,1071),(5,1072),(5,1073),(5,1074),(5,1076),(5,1077),(5,1078),(5,1079),(5,1101),(5,1102),(5,1104),(5,1105),(5,1106),(5,1107),(5,1113),(5,1121),(5,1125),(5,1129),(5,1133),(5,1134),(5,1135),(5,1136),(5,1137),(5,1148),(5,1149),(5,1153),(5,1154),(5,1155),(5,1156),(5,1157),(5,1163),(5,1164),(5,1165),(5,1166),(5,1167),(5,1168),(5,1174),(5,1175),(5,1176),(5,1177),(5,1178),(5,1179),(5,1180),(5,1181),(5,1185),(5,1186),(5,1187),(5,1188),(5,1189),(5,1190),(5,1191),(5,1192),(5,1193),(5,1197),(5,1201),(5,1209),(5,1210),(5,1211),(5,1212),(5,1213),(5,1215),(5,1216),(5,1218),(5,1219),(5,1220),(5,1222),(5,1223),(5,1228),(5,1229),(5,1231),(5,1232),(5,1233),(5,1234),(5,1235),(5,1236),(5,1237),(5,1238),(5,1239),(5,1240),(5,1243),(5,1244),(5,1245),(5,1246),(5,1247),(5,1248),(5,1249),(5,1250),(5,1251),(5,1252),(5,1253),(5,1254),(5,1255),(5,1256),(6,1),(6,103),(6,107),(6,1016),(6,1035),(6,1058),(6,1062),(6,1063),(6,1064),(6,1069),(6,1101),(6,1102),(6,1104),(6,1105),(6,1106),(6,1107),(6,1113),(6,1121),(6,1125),(6,1129),(6,1133),(6,1134),(6,1135),(6,1136),(6,1137),(6,1148),(6,1149),(6,1150),(6,1151),(6,1152),(6,1153),(6,1154),(6,1155),(6,1156),(6,1157),(6,1177),(6,1178),(6,1179),(6,1180),(6,1181),(6,1182),(6,1183),(6,1184),(6,1193),(6,1197),(6,1201),(6,1209),(6,1210),(6,1215),(6,1216),(6,1218),(6,1219),(6,1220),(6,1221),(6,1222),(6,1223),(6,1226),(6,1231),(6,1232),(6,1233),(6,1234),(6,1235),(6,1236),(6,1237),(6,1238),(6,1239),(7,1058),(7,1062),(7,1063),(7,1064),(7,1069),(7,1101),(7,1102),(7,1104),(7,1105),(7,1106),(7,1107),(7,1113),(7,1121),(7,1125),(7,1129),(7,1133),(7,1134),(7,1135),(7,1136),(7,1137),(7,1148),(7,1149),(7,1150),(7,1151),(7,1152),(7,1153),(7,1154),(7,1155),(7,1156),(7,1157),(7,1177),(7,1178),(7,1179),(7,1180),(7,1181),(7,1182),(7,1183),(7,1184),(7,1193),(7,1197),(7,1201),(7,1209),(7,1210),(7,1215),(7,1216),(7,1218),(7,1219),(7,1220),(7,1222),(7,1223),(7,1226),(7,1231),(7,1232),(7,1233),(7,1234),(7,1235),(7,1236),(7,1237),(7,1238),(7,1239),(8,1),(8,2),(8,100),(8,103),(8,108),(8,111),(8,112),(8,500),(8,501),(8,1000),(8,1001),(8,1002),(8,1006),(8,1016),(8,1039),(8,1041),(8,1042),(8,1043),(8,1045),(8,1058),(8,1062),(8,1063),(8,1064),(8,1065),(8,1066),(8,1067),(8,1068),(8,1069),(8,1101),(8,1102),(8,1104),(8,1105),(8,1106),(8,1107),(8,1113),(8,1114),(8,1115),(8,1116),(8,1121),(8,1122),(8,1123),(8,1124),(8,1125),(8,1129),(8,1130),(8,1131),(8,1132),(8,1133),(8,1134),(8,1135),(8,1136),(8,1137),(8,1148),(8,1149),(8,1150),(8,1151),(8,1152),(8,1153),(8,1154),(8,1155),(8,1156),(8,1157),(8,1174),(8,1175),(8,1176),(8,1177),(8,1178),(8,1179),(8,1180),(8,1181),(8,1182),(8,1183),(8,1184),(8,1185),(8,1189),(8,1193),(8,1197),(8,1201),(8,1209),(8,1210),(8,1211),(8,1212),(8,1213),(8,1214),(8,1215),(8,1216),(8,1218),(8,1219),(8,1220),(8,1221),(8,1222),(8,1223),(8,1225),(8,1226),(8,1228),(8,1230),(8,1231),(8,1232),(8,1233),(8,1234),(8,1235),(8,1236),(8,1237),(8,1238),(8,1239),(8,1240),(8,1241),(8,1242),(9,1),(9,2),(9,100),(9,101),(9,102),(9,103),(9,104),(9,105),(9,106),(9,107),(9,108),(9,109),(9,110),(9,111),(9,112),(9,500),(9,501),(9,1000),(9,1001),(9,1002),(9,1003),(9,1004),(9,1005),(9,1007),(9,1008),(9,1009),(9,1010),(9,1011),(9,1012),(9,1013),(9,1014),(9,1015),(9,1016),(9,1017),(9,1018),(9,1019),(9,1020),(9,1021),(9,1022),(9,1023),(9,1024),(9,1025),(9,1026),(9,1027),(9,1028),(9,1029),(9,1030),(9,1035),(9,1036),(9,1037),(9,1038),(9,1039),(9,1041),(9,1042),(9,1043),(9,1045),(9,1046),(9,1047),(9,1048),(9,1049),(9,1050),(9,1051),(9,1052),(9,1053),(9,1054),(9,1055),(9,1058),(9,1062),(9,1063),(9,1064),(9,1068),(9,1069),(9,1075),(9,1101),(9,1102),(9,1104),(9,1105),(9,1106),(9,1107),(9,1113),(9,1121),(9,1122),(9,1123),(9,1124),(9,1125),(9,1129),(9,1130),(9,1131),(9,1132),(9,1133),(9,1134),(9,1135),(9,1136),(9,1137),(9,1148),(9,1149),(9,1150),(9,1151),(9,1152),(9,1153),(9,1154),(9,1155),(9,1156),(9,1157),(9,1163),(9,1164),(9,1165),(9,1166),(9,1167),(9,1168),(9,1174),(9,1175),(9,1176),(9,1177),(9,1178),(9,1179),(9,1180),(9,1181),(9,1182),(9,1183),(9,1184),(9,1185),(9,1186),(9,1187),(9,1188),(9,1189),(9,1190),(9,1191),(9,1192),(9,1193),(9,1194),(9,1195),(9,1196),(9,1197),(9,1198),(9,1199),(9,1200),(9,1201),(9,1202),(9,1203),(9,1209),(9,1210),(9,1215),(9,1221),(9,1222),(9,1223),(9,1226),(9,1228),(9,1229),(9,1231),(9,1232),(9,1233),(9,1234),(9,1235),(9,1236),(9,1237),(9,1238),(9,1239),(9,1240),(9,1241),(10,1),(10,2),(10,3),(10,100),(10,101),(10,102),(10,103),(10,104),(10,105),(10,106),(10,107),(10,108),(10,109),(10,110),(10,111),(10,112),(10,113),(10,114),(10,115),(10,500),(10,501),(10,1000),(10,1001),(10,1002),(10,1003),(10,1004),(10,1005),(10,1006),(10,1007),(10,1008),(10,1009),(10,1010),(10,1011),(10,1012),(10,1013),(10,1014),(10,1015),(10,1016),(10,1017),(10,1018),(10,1019),(10,1020),(10,1021),(10,1022),(10,1023),(10,1024),(10,1025),(10,1026),(10,1027),(10,1028),(10,1029),(10,1030),(10,1031),(10,1032),(10,1033),(10,1034),(10,1035),(10,1036),(10,1037),(10,1038),(10,1039),(10,1040),(10,1041),(10,1042),(10,1043),(10,1044),(10,1045),(10,1046),(10,1047),(10,1048),(10,1049),(10,1050),(10,1051),(10,1052),(10,1053),(10,1054),(10,1055),(10,1056),(10,1057),(10,1058),(10,1062),(10,1063),(10,1064),(10,1065),(10,1066),(10,1067),(10,1068),(10,1069),(10,1070),(10,1071),(10,1072),(10,1073),(10,1074),(10,1075),(10,1076),(10,1077),(10,1078),(10,1079),(10,1101),(10,1102),(10,1104),(10,1105),(10,1106),(10,1107),(10,1113),(10,1114),(10,1115),(10,1116),(10,1121),(10,1122),(10,1123),(10,1124),(10,1125),(10,1126),(10,1127),(10,1128),(10,1129),(10,1130),(10,1131),(10,1132),(10,1133),(10,1134),(10,1135),(10,1136),(10,1137),(10,1148),(10,1149),(10,1150),(10,1151),(10,1152),(10,1153),(10,1154),(10,1155),(10,1156),(10,1157),(10,1163),(10,1164),(10,1165),(10,1166),(10,1167),(10,1168),(10,1174),(10,1175),(10,1176),(10,1177),(10,1178),(10,1179),(10,1180),(10,1181),(10,1182),(10,1183),(10,1184),(10,1185),(10,1186),(10,1187),(10,1188),(10,1189),(10,1190),(10,1191),(10,1192),(10,1193),(10,1194),(10,1195),(10,1196),(10,1197),(10,1198),(10,1199),(10,1200),(10,1201),(10,1202),(10,1203),(10,1209),(10,1210),(10,1211),(10,1212),(10,1213),(10,1214),(10,1215),(10,1216),(10,1218),(10,1219),(10,1220),(10,1221),(10,1222),(10,1223),(10,1224),(10,1225),(10,1226),(10,1228),(10,1229),(10,1230),(10,1231),(10,1232),(10,1233),(10,1234),(10,1235),(10,1236),(10,1237),(10,1238),(10,1239),(10,1240),(10,1241),(10,1242),(11,1058),(11,1062),(11,1063),(11,1064),(11,1065),(11,1066),(11,1067),(11,1068),(11,1069),(11,1101),(11,1102),(11,1104),(11,1105),(11,1106),(11,1107),(11,1113),(11,1121),(11,1125),(11,1129),(11,1130),(11,1131),(11,1132),(11,1133),(11,1134),(11,1135),(11,1136),(11,1137),(11,1148),(11,1149),(11,1150),(11,1151),(11,1152),(11,1153),(11,1154),(11,1155),(11,1156),(11,1157),(11,1163),(11,1164),(11,1165),(11,1166),(11,1167),(11,1168),(11,1174),(11,1175),(11,1176),(11,1177),(11,1178),(11,1179),(11,1180),(11,1181),(11,1182),(11,1183),(11,1184),(11,1185),(11,1189),(11,1193),(11,1197),(11,1201),(11,1209),(11,1210),(11,1211),(11,1212),(11,1213),(11,1214),(11,1215),(11,1216),(11,1218),(11,1219),(11,1220),(11,1221),(11,1222),(11,1223),(11,1224),(11,1226),(11,1228),(11,1229),(11,1231),(11,1232),(11,1233),(11,1234),(11,1235),(11,1236),(11,1237),(11,1238),(11,1239),(11,1240),(11,1241),(11,1242),(11,1243),(12,1058),(12,1062),(12,1063),(12,1064),(12,1065),(12,1066),(12,1067),(12,1068),(12,1069),(12,1090),(12,1091),(12,1092),(12,1093),(12,1101),(12,1102),(12,1104),(12,1105),(12,1106),(12,1107),(12,1113),(12,1114),(12,1115),(12,1116),(12,1121),(12,1122),(12,1123),(12,1124),(12,1125),(12,1126),(12,1127),(12,1128),(12,1129),(12,1130),(12,1131),(12,1132),(12,1133),(12,1134),(12,1135),(12,1136),(12,1137),(12,1148),(12,1149),(12,1150),(12,1151),(12,1152),(12,1153),(12,1154),(12,1155),(12,1156),(12,1157),(12,1163),(12,1164),(12,1165),(12,1166),(12,1167),(12,1168),(12,1177),(12,1178),(12,1179),(12,1180),(12,1181),(12,1182),(12,1183),(12,1184),(12,1193),(12,1194),(12,1195),(12,1196),(12,1197),(12,1198),(12,1199),(12,1200),(12,1201),(12,1202),(12,1203),(12,1209),(12,1210),(12,1211),(12,1212),(12,1213),(12,1214),(12,1215),(12,1216),(12,1218),(12,1219),(12,1220),(12,1221),(12,1222),(12,1223),(12,1224),(12,1225),(12,1226),(12,1228),(12,1229),(12,1230),(12,1231),(12,1232),(12,1233),(12,1234),(12,1235),(12,1236),(12,1237),(12,1238),(12,1239),(12,1240),(12,1241),(12,1242),(12,1243),(12,1244),(12,1245),(12,1246),(12,1247),(12,1248),(12,1249),(12,1250),(12,1251),(12,1252),(12,1253),(12,1254),(12,1255),(12,1256),(12,1257);
/*!40000 ALTER TABLE `sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '登录账号',
  `user_name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) COLLATE utf8_bin DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) COLLATE utf8_bin DEFAULT '' COMMENT '手机号码',
  `sex` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) COLLATE utf8_bin DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '密码',
  `salt` varchar(20) COLLATE utf8_bin DEFAULT '' COMMENT '盐加密',
  `status` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) COLLATE utf8_bin DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `create_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) COLLATE utf8_bin DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) COLLATE utf8_bin DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user` VALUES (1,100,'admin','超级管理员','00','admin@fosu.edu.cn','15888888888','0','','6d608f44b8f8eee8edda770a55dcd6fb','d48c8c','0','0','127.0.0.1','2023-12-20 02:15:05','admin','2023-12-17 10:20:33','ry','2023-12-19 18:15:05','管理员'),(226,146,'zouxiujie','邹修洁','00','zouxiujie@qq.com','13800138000','0','','21aeb17d9d8c16b5cbaf69837cb7dfd8','a70981','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(227,149,'denglicheng','邓立诚','00','denglicheng@qq.com','13800138001','0','','bb5dd5c55f356488bd060dcebe221d4b','cff053','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(228,149,'zhangli','张丽','00','zhangli@fosu.edu','13800138002','1','','4c80cf26c9a32848d0d59bef448a8af7','61c87a','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(229,147,'zhangqinghua','张清华','00','zqh@qq.com','13822183333','0','','71207060d9591ef3fbc2762296dcf9c0','72ce8e','0','0','',NULL,'admin','2023-12-17 10:20:33','admin',NULL,''),(230,147,'liuqian','柳浅','00','liuqian@qq.com','18818818888','1','','b14d65988b958830441bdabbf3326c17','24232c','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(231,154,'test1','测试1','00','test@qq.com','13800138010','0','','7f341ea754cc6f719bdc22c4bd5d63bd','1aca0e','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(232,154,'test2','测试2','00','test2@qq.com','13800138011','0','','b9a3742ee49930d1f226a6d310bd7a71','760bac','0','0','',NULL,'admin','2023-12-17 10:20:33','admin',NULL,''),(233,154,'test3','测试3','00','test3@qq.com','13800138012','0','','a334ac975f469b130ebaaa88de8fc37c','e88402','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(234,154,'test4','测试4','00','test4@qq.com','13800138013','0','','509d29de53401f711dc9f91a3b242d88','363128','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,''),(235,154,'test5','测试5','00','test5@qq.com','13800138014','0','','71003e0ee00b8bec93a324dd80d6f30c','04ad80','0','0','',NULL,'admin','2023-12-17 10:20:33','',NULL,'');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_online`
--

DROP TABLE IF EXISTS `sys_user_online`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_online` (
  `sessionId` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户会话id',
  `login_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '登录账号',
  `dept_name` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '部门名称',
  `ipaddr` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) COLLATE utf8_bin DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) COLLATE utf8_bin DEFAULT '' COMMENT '操作系统',
  `status` varchar(10) COLLATE utf8_bin DEFAULT '' COMMENT '在线状态on_line在线off_line离线',
  `start_timestamp` datetime DEFAULT NULL COMMENT 'session创建时间',
  `last_access_time` datetime DEFAULT NULL COMMENT 'session最后访问时间',
  `expire_time` int(5) DEFAULT '0' COMMENT '超时时间，单位为分钟',
  PRIMARY KEY (`sessionId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='在线用户记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_online`
--

LOCK TABLES `sys_user_online` WRITE;
/*!40000 ALTER TABLE `sys_user_online` DISABLE KEYS */;
INSERT INTO `sys_user_online` VALUES ('05e7ebce-def6-4df7-a19d-5d718c1664fc','admin','智软科技教育有限公司 (总部)','127.0.0.1','内网IP','Firefox 11','Windows 10','on_line','2023-12-20 02:14:59','2023-12-20 02:30:39',1800000);
/*!40000 ALTER TABLE `sys_user_online` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_post`
--

DROP TABLE IF EXISTS `sys_user_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_post` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`,`post_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='用户与岗位关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_post`
--

LOCK TABLES `sys_user_post` WRITE;
/*!40000 ALTER TABLE `sys_user_post` DISABLE KEYS */;
INSERT INTO `sys_user_post` VALUES (1,1);
/*!40000 ALTER TABLE `sys_user_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='用户和角色关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (1,1),(226,5),(227,5),(228,6),(229,8),(229,11),(230,7);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_assess_month`
--

DROP TABLE IF EXISTS `teach_assess_month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_assess_month` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '月度考核标准ID',
  `assess_month` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考核月份',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `attendance_one` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤大于等于',
  `attendance_one_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `attendance_two` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤大于等于-考勤小于（两个值，中间用-隔开）',
  `attendance_two_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `attendance_three` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤小于',
  `attendance_three_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `exam_one` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考试大于等于',
  `exam_one_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `exam_two` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '考试大于等于-考试小于（两个值，中间用-隔开）',
  `exam_two_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `exam_three` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考试小于',
  `exam_three_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `task_one` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '作业大于等于',
  `task_one_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `task_two` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '作业大于等于-作业小于（两个值，中间用-隔开）',
  `task_two_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `task_three` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '作业小于',
  `task_three_standard` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `subject_one` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '项目大于等于',
  `subject_one_standard` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `subject_two` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '项目大于等于-项目小于（两个值，中间用-隔开）',
  `subject_two_standard` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  `subject_three` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '项目小于',
  `subject_three_standard` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '计算标准',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='月度考核标准';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_assess_month`
--

LOCK TABLES `teach_assess_month` WRITE;
/*!40000 ALTER TABLE `teach_assess_month` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_assess_month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_assessment_criterion`
--

DROP TABLE IF EXISTS `teach_assessment_criterion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_assessment_criterion` (
  `assess_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考核标准ID',
  `school_id` int(11) DEFAULT NULL COMMENT '校区编号',
  `character_no` int(11) DEFAULT NULL COMMENT '角色编号',
  `assess_proportion` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考核占分比',
  PRIMARY KEY (`assess_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='考核标准表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_assessment_criterion`
--

LOCK TABLES `teach_assessment_criterion` WRITE;
/*!40000 ALTER TABLE `teach_assessment_criterion` DISABLE KEYS */;
INSERT INTO `teach_assessment_criterion` VALUES (1,149,6,'50');
/*!40000 ALTER TABLE `teach_assessment_criterion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_attendance`
--

DROP TABLE IF EXISTS `teach_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_attendance` (
  `attendance_id` int(11) NOT NULL COMMENT '考勤ID',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `teacher_id` int(11) DEFAULT NULL COMMENT '上课老师编号',
  `attendance_datetime` date DEFAULT NULL COMMENT '考勤日期',
  `attendance_period` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤时段',
  `classroom` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '教室',
  `lesson` int(11) DEFAULT NULL COMMENT '课程编号',
  `attendancenum` int(3) DEFAULT NULL COMMENT '正常出勤人数',
  `leavenum` int(3) DEFAULT NULL COMMENT '请假人数',
  `truancynum` int(3) DEFAULT NULL COMMENT '旷课人数',
  `latenum` int(3) DEFAULT NULL COMMENT '迟到人数',
  `leaveearlynum` int(3) DEFAULT NULL COMMENT '早退人数',
  `studentnum` int(3) DEFAULT NULL COMMENT '班级总人数',
  `class_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班级正常出勤率',
  PRIMARY KEY (`attendance_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级考勤表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_attendance`
--

LOCK TABLES `teach_attendance` WRITE;
/*!40000 ALTER TABLE `teach_attendance` DISABLE KEYS */;
INSERT INTO `teach_attendance` VALUES (0,1,229,'2023-12-05','00:00:00 - 00:00:00',NULL,1,4,0,0,0,0,4,'100%'),(1,1,229,'2023-12-05','00:00:00 - 00:00:00',NULL,1,3,0,1,0,0,4,'75%'),(2,1,229,'2023-12-19','00:00:00 - 00:00:00',NULL,1,2,0,2,0,0,4,'50%');
/*!40000 ALTER TABLE `teach_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_class_attendance`
--

DROP TABLE IF EXISTS `teach_class_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_class_attendance` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '班级ID',
  `teacher_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '老师ID',
  `attendance_datetime` datetime DEFAULT NULL COMMENT '考勤时间',
  `classroom` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤教室',
  `lesson` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '考勤专业',
  `attendancenum` int(5) DEFAULT NULL COMMENT '正常出勤人数',
  `leavenum` int(3) DEFAULT NULL COMMENT '请假人数',
  `truancynum` int(3) DEFAULT NULL COMMENT '旷课人数',
  `latenum` int(3) DEFAULT NULL COMMENT '迟到人数',
  `leaveearlynum` int(3) DEFAULT NULL COMMENT '早退人数',
  `studentnum` int(5) DEFAULT NULL COMMENT '班级总人数',
  `class_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班级正常出勤率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级出勤率统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_class_attendance`
--

LOCK TABLES `teach_class_attendance` WRITE;
/*!40000 ALTER TABLE `teach_class_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_class_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_class_homework`
--

DROP TABLE IF EXISTS `teach_class_homework`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_class_homework` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '班级ID',
  `homework_datetime` datetime DEFAULT NULL COMMENT '作业时间',
  `job_content` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '作业内容',
  `lesson` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '专业',
  `workbestnum` int(5) DEFAULT NULL COMMENT '作业优人数',
  `workgoodnum` int(3) DEFAULT NULL COMMENT '作业良人数',
  `workpoornum` int(3) DEFAULT NULL COMMENT '作业差人数',
  `worknosubmitnum` int(3) DEFAULT NULL COMMENT '未交人数',
  `studentnum` int(5) DEFAULT NULL COMMENT '班级学生人数',
  `class_homework_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班级作业合格率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级作业统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_class_homework`
--

LOCK TABLES `teach_class_homework` WRITE;
/*!40000 ALTER TABLE `teach_class_homework` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_class_homework` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_class_statistics`
--

DROP TABLE IF EXISTS `teach_class_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_class_statistics` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `createtime` date DEFAULT NULL COMMENT '创建时间',
  `month` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '统计月',
  `attendence` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '出勤率',
  `subject_percentage_complete` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '项目完成率',
  `job_percentage_complete` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '作业完成率',
  `exam_acceptability` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考试合格率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='数据汇总（班级）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_class_statistics`
--

LOCK TABLES `teach_class_statistics` WRITE;
/*!40000 ALTER TABLE `teach_class_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_class_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_classes`
--

DROP TABLE IF EXISTS `teach_classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_classes` (
  `class_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `class_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班级名称',
  `school_id` int(11) DEFAULT NULL COMMENT '所属校区ID',
  `major_id` int(11) DEFAULT NULL COMMENT '所属专业ID',
  `stage_new` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '当前阶段',
  `stage_starttime` date DEFAULT NULL COMMENT '阶段开始时间',
  `stage_endtime` date DEFAULT NULL COMMENT '阶段结束时间',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `link_status` int(11) DEFAULT NULL COMMENT '连接状态（1：关闭，0：开启）',
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_classes`
--

LOCK TABLES `teach_classes` WRITE;
/*!40000 ALTER TABLE `teach_classes` DISABLE KEYS */;
INSERT INTO `teach_classes` VALUES (1,'2023年秋季乐高机器人编程',147,1,NULL,NULL,NULL,'2023-12-19 15:50:11',1),(2,'2023年秋季计算机入门',146,9,NULL,NULL,NULL,'2023-12-19 00:00:00',0);
/*!40000 ALTER TABLE `teach_classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_classes_teacher`
--

DROP TABLE IF EXISTS `teach_classes_teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_classes_teacher` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `post` int(1) DEFAULT NULL COMMENT '职务（3，班主任；1，教员；2，助教）',
  `stage_id` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '阶段ID',
  `teacher_id` int(11) DEFAULT NULL COMMENT '班主任ID',
  `instructor_id` int(11) DEFAULT NULL COMMENT '教员id',
  `assistant_id` int(11) DEFAULT NULL COMMENT '助教id',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `stage_starttime` date DEFAULT NULL COMMENT '阶段开始时间',
  `stage_endtime` date DEFAULT NULL COMMENT '阶段结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级表教师（班级子表）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_classes_teacher`
--

LOCK TABLES `teach_classes_teacher` WRITE;
/*!40000 ALTER TABLE `teach_classes_teacher` DISABLE KEYS */;
INSERT INTO `teach_classes_teacher` VALUES ('14a9945f-37c0-4ce2-a444-dcd664d58fb7',NULL,'79a3fe97-d5cc-4c5b-96bd-882a4d40422b',226,226,NULL,1,'2023-11-16','2023-11-20'),('2e476093-17a7-4a49-b5f1-033452facedc',NULL,'79a3fe97-d5cc-4c5b-96bd-882a4d40422b',226,227,NULL,1,'2023-11-22','2023-11-30'),('36c07989-276e-44fe-ac92-dc4aad778011',NULL,'01450ac0-8436-4b00-b9ac-40495c2044d1',226,228,NULL,2,'2023-11-04','2023-11-04'),('37a8dbaf-5b86-439b-b183-d94a088a6b46',NULL,'0eef14b0-aa1e-4344-9fa4-d5f8cf8a68b0',226,227,NULL,1,'2023-11-05','2023-11-08'),('433dc4c0-1b28-49d2-858f-4a7c6186e2b7',NULL,'7d880a5e-9068-4c77-ac69-eae27cf711c2',226,228,NULL,1,'2023-11-10','2023-11-15'),('77fa38e9-2c0f-4571-a972-f2a81c5cb96b',NULL,'55c4219d-808b-4352-a7aa-7003b0bd8823',226,227,NULL,2,'2023-11-05','2023-11-05'),('88194f52-bde5-478f-b47c-2d1c901b5d45',NULL,'13ed9959-b3dd-4a16-9587-407d664a85bb',226,228,NULL,1,'2023-12-01','2023-12-10'),('8ccef52b-cac4-4cf9-a557-3eba5b8615c4',NULL,'2ba6dac0-20e7-46a7-9578-e737994540f9',226,228,NULL,2,'2023-11-01','2023-11-01'),('e307d4b4-79f3-48ae-ad49-37468f1deea4',NULL,'7b510ee5-7e07-49e5-a559-93471ca17d04',226,227,NULL,2,'2023-11-02','2023-11-02'),('e5bcc2a2-382e-4388-a131-a73e8a6b5e35',NULL,'36bac3d9-ac8d-4dff-9f1d-cf601ea10bb6',226,228,NULL,2,'2023-11-03','2023-11-03');
/*!40000 ALTER TABLE `teach_classes_teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_exam`
--

DROP TABLE IF EXISTS `teach_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_exam` (
  `exam_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考试id',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `datetime` date DEFAULT NULL COMMENT '考试时间',
  `cut_offscores` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '及格线',
  `invigilator` int(11) DEFAULT NULL COMMENT '监考老师',
  `address` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '考试地点',
  `stage_id` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '考试阶段',
  `pass` int(3) DEFAULT NULL COMMENT '考试通过人数',
  `fail` int(3) DEFAULT NULL COMMENT '考试未通过人数',
  `student_num` int(3) DEFAULT NULL COMMENT '班级人数',
  `acceptability` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '合格率',
  PRIMARY KEY (`exam_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级考试表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_exam`
--

LOCK TABLES `teach_exam` WRITE;
/*!40000 ALTER TABLE `teach_exam` DISABLE KEYS */;
INSERT INTO `teach_exam` VALUES (1,1,'2023-12-19','60',229,'教室','13ed9959-b3dd-4a16-9587-407d664a85bb',3,1,4,'75%');
/*!40000 ALTER TABLE `teach_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_exam_statistics`
--

DROP TABLE IF EXISTS `teach_exam_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_exam_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `exam_time` date DEFAULT NULL COMMENT '考试时间',
  `stage_id` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '考试阶段',
  `pass` int(3) DEFAULT NULL COMMENT '考试通过人数',
  `fail` int(3) DEFAULT NULL COMMENT '考试未通过人数',
  `student_num` int(3) DEFAULT NULL COMMENT '班级人数',
  `acceptability` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '合格率',
  `invigilator` int(11) DEFAULT NULL COMMENT '监考老师',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '考试地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='考试统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_exam_statistics`
--

LOCK TABLES `teach_exam_statistics` WRITE;
/*!40000 ALTER TABLE `teach_exam_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_exam_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_file_collection`
--

DROP TABLE IF EXISTS `teach_file_collection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_file_collection` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `kgc_no` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场账号',
  `kgc_uid` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场uid',
  `kgc_nickname` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场昵称',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `start_time` varchar(40) CHARACTER SET utf32 DEFAULT NULL COMMENT '进班时间(报档时间)',
  `postname` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '学生项目的地址',
  `student_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `student_sex` int(1) DEFAULT NULL COMMENT '学生性别',
  `native_place` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `id_card_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `education` int(2) DEFAULT NULL COMMENT '学历',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `mail` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭地址',
  `class_no` int(11) DEFAULT NULL COMMENT '班级编号',
  `extend1` int(1) DEFAULT NULL COMMENT '学生来源',
  `extend2` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `extend3` datetime DEFAULT NULL COMMENT '创建时间',
  `graduate_institutions` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '毕业院校',
  `work_experience` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '学前工作经历',
  `base` int(1) DEFAULT NULL COMMENT '是否有基础（0，无；1，有）',
  `english_level` int(11) DEFAULT NULL COMMENT '英语水平(编号)',
  `degree_in_nature` int(1) DEFAULT NULL COMMENT '学历性质',
  `graduate_date` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '毕业时间',
  `major` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '专业',
  `up_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '时间',
  `emergency_contact` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '与紧急联络人的关系',
  `emergency_contact_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人电话',
  `job_city` int(11) DEFAULT NULL COMMENT '就业意向城市（编号）',
  `textbook_no` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '教材编号',
  `traffic_permit` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '通行证',
  `postal_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `student_name_pinyin` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名拼音',
  `extend4` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '班级名称',
  `extend5` int(11) DEFAULT NULL COMMENT '是否通过（0：未审批，1：已通过）',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `modify_user` int(11) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生档案收集表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_file_collection`
--

LOCK TABLES `teach_file_collection` WRITE;
/*!40000 ALTER TABLE `teach_file_collection` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_file_collection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_inspection_items`
--

DROP TABLE IF EXISTS `teach_inspection_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_inspection_items` (
  `inspection_items_id` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '考核项id',
  `assess_id` int(11) DEFAULT NULL COMMENT '考核标准（父表）编号',
  `inspection_items_no` int(11) DEFAULT NULL COMMENT '考核项编号',
  `inspection_items_weight` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '考核项权重',
  PRIMARY KEY (`inspection_items_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='考核项表（考核标准子表）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_inspection_items`
--

LOCK TABLES `teach_inspection_items` WRITE;
/*!40000 ALTER TABLE `teach_inspection_items` DISABLE KEYS */;
INSERT INTO `teach_inspection_items` VALUES ('3b361c13-fb89-4996-a1fc-b836ebcc0651',1,100,'专业课出勤率'),('6045f882-a48a-450c-81e4-1be882a894f8',1,100,'考试合格率'),('a24ec2a8-8a73-42e6-b2ae-6d0520c4d9c3',1,100,'满意度'),('b0f9b3a0-d0dc-46b2-9924-1276546bfa7c',1,100,'项目合格率'),('da9c7eba-b356-4c7f-8274-7d1f4dfe27fb',1,100,'作业完成率'),('e34ebc09-02dc-48e6-bb31-e608d5d5f73e',1,20,'实训课出勤率');
/*!40000 ALTER TABLE `teach_inspection_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_job`
--

DROP TABLE IF EXISTS `teach_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_job` (
  `job_id` int(11) NOT NULL COMMENT '作业编号',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `datetime` date DEFAULT NULL COMMENT '作业时间',
  `job_content` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作业内容',
  `job_stage` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '作业阶段章节',
  `workbestnum` int(3) DEFAULT NULL COMMENT '作业优人数',
  `workgoodnum` int(3) DEFAULT NULL COMMENT '作业良人数',
  `workpoornum` int(3) DEFAULT NULL COMMENT '作业差人数',
  `worknosubmitnum` int(3) DEFAULT NULL COMMENT '未交人数',
  `studentnum` int(3) DEFAULT NULL COMMENT '班级学生人数',
  `class_homework_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '班级作业合格率',
  PRIMARY KEY (`job_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级作业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_job`
--

LOCK TABLES `teach_job` WRITE;
/*!40000 ALTER TABLE `teach_job` DISABLE KEYS */;
INSERT INTO `teach_job` VALUES (1,1,'2023-12-05','学习基本的机器人指令，并且写一个简单的小程序控制机器人','机器人指令学习',1,2,1,0,4,'75%'),(2,1,'2023-12-12','使用基本的机器人指令，让机器人绕圈行驶','机器人指令学习',1,2,1,0,4,'75%');
/*!40000 ALTER TABLE `teach_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_major`
--

DROP TABLE IF EXISTS `teach_major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_major` (
  `major_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `major_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '专业名称',
  `major_type` int(11) DEFAULT NULL COMMENT '专业类别（编号）',
  PRIMARY KEY (`major_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='专业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_major`
--

LOCK TABLES `teach_major` WRITE;
/*!40000 ALTER TABLE `teach_major` DISABLE KEYS */;
INSERT INTO `teach_major` VALUES (1,'乐高机器人（5-7岁）',0),(2,'软件编程（6-8岁）',0),(3,'奥赛入门组',1),(4,'奥赛实战组',1),(5,'小学托管',2),(6,'幼儿园托管',2),(7,'人工智能（图像）入门',3),(8,'Go的实践与提高',4),(9,'Your Missing Semester',4),(10,'Redis的核心与实战',4),(11,'了解操作系统（寒暑假/青少年托管）',2),(12,'测试',1);
/*!40000 ALTER TABLE `teach_major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_major_stage`
--

DROP TABLE IF EXISTS `teach_major_stage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_major_stage` (
  `id` varchar(64) COLLATE utf8_bin NOT NULL,
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `stage_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '阶段名称',
  `sort` int(2) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='专业阶段表（专业表子表）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_major_stage`
--

LOCK TABLES `teach_major_stage` WRITE;
/*!40000 ALTER TABLE `teach_major_stage` DISABLE KEYS */;
INSERT INTO `teach_major_stage` VALUES ('00835f39-b2fa-4f29-b41b-b8c8ff9dfbd2',2,'互动探索',1),('01450ac0-8436-4b00-b9ac-40495c2044d1',9,'Git 提高',3),('0320ead0-1b74-4e77-9a7e-eab20f7ceac2',4,'刷题',4),('063b44e2-8054-46d3-85eb-99cf5398ee99',10,'内存快照/日志',2),('069117a2-9c7b-44e1-8aff-b169f6e4eb5b',4,'图论入门',0),('0eef14b0-aa1e-4344-9fa4-d5f8cf8a68b0',1,'技巧启蒙',0),('13ed9959-b3dd-4a16-9587-407d664a85bb',1,'任务挑战',3),('1c10b11c-30c4-4bec-bafe-7e8aa078cf01',3,'算法基础',1),('23117145-2bdd-4897-b2ca-f2cf433ccd45',8,'团队协作项目',4),('2ba6dac0-20e7-46a7-9578-e737994540f9',9,'Shell 和 Linux',0),('2cfc5ef4-d438-43e4-8a69-529e08dd6e4f',11,'进程入门',4),('2e9eaf38-0dc0-44bf-9600-882b79edd9f8',3,'数据结构初步',2),('340111f9-1cfc-4121-90bb-539c6e2ab0e2',7,'AI基础',0),('36bac3d9-ac8d-4dff-9f1d-cf601ea10bb6',9,'cli 高效处理数据',2),('3819821c-8ce4-45a1-a425-56eb67dd516c',10,'项目实践',7),('3ae2d95c-a271-43fa-b603-5f13a62fb708',4,'DP入门',2),('3f8b083c-216c-4714-b072-912454ca4b44',5,'考勤任务',0),('423b8a91-b433-41d7-a342-ce5985a2cb24',7,'实践项目',3),('4666decf-d2c3-4050-b0f2-f824115ed76f',10,'同步与事务',6),('4a08d815-b064-43ec-a1d8-9315acefb219',8,'并发模型设计',0),('4a2d81a6-c2bb-494a-a45b-03e69fddb024',7,'机器学习原理',2),('521bc326-857f-4563-8fb8-f00540e984bc',11,'实践课',7),('55c4219d-808b-4352-a7aa-7003b0bd8823',9,'Debug 和 Profile',4),('55fe92f4-861d-4a1c-aa29-cb847f7cbaad',10,'基本架构',0),('5d79f59d-67d9-4563-a426-7ba93bab33ec',11,'内核入门',3),('6699018a-1395-4127-8a12-82637b0f1e0d',11,'修复/安装操作系统',2),('6bd8c441-6b74-423b-b71a-83a3bdd016a1',9,'Container、WM 和 NixOS',6),('6f84f007-0982-400a-9003-ada8e9677158',2,'基本概念',0),('782fe6a9-97d5-45af-940c-99b47c863224',12,'测试',0),('7954791e-c004-4d50-b19b-f831fbe62e02',2,'逻辑构建',2),('79a3fe97-d5cc-4c5b-96bd-882a4d40422b',1,'创意编程',2),('7b510ee5-7e07-49e5-a559-93471ca17d04',9,'编辑器',1),('7d880a5e-9068-4c77-ac69-eae27cf711c2',1,'简单机械原理',1),('7d942567-8e95-439c-8f5f-1fd8de15eb83',11,'计算机是如何启动的',0),('853f5a3f-05fa-4ad0-afa3-793927981395',10,'缓存异常',5),('91cd630e-51b9-4329-8a52-be0292ad69dd',10,'集群策略',3),('99b0d65c-77fb-4ccb-b839-10b8907b748a',10,'响应优化',4),('9e00b412-02ca-4471-b4ce-ad8186860b2c',3,'C++入门',0),('a0d128ba-8e72-47cd-bffb-8313f28955cc',7,'编程技能',1),('a0f89da8-024d-4c19-ba5a-02744b1833e4',11,'网络入门',6),('a6979693-0de3-42eb-a8b6-c2cfcc05f7b4',11,'设备IO入门',5),('ac50f0d5-b432-4e76-97bb-013a7f3ff606',2,'创意项目',3),('acbee3cc-d487-476f-9e08-2a215654735e',4,'数论入门',1),('b4cb301e-f394-4073-805e-03689b23b190',4,'优化技巧',3),('b9330030-2b36-4aed-894e-c1d69da0fff0',8,'高效编码',3),('c29ccfc2-0864-4bed-b0fe-b4518f628a61',9,'Latex 和 知识库',5),('d74dbbe6-e872-4b5f-af1d-3fc5f188b508',11,'我们的数据安全吗',1),('da7ac1b7-5920-4cac-9a20-8c7ed81dd74e',8,'微服务架构',1),('de1ffaac-16a3-4767-b0c1-ae8fd4b8745a',8,'中间件设计',2),('e1a75306-f4c2-493d-a453-ef203bf85662',10,'高性能IO模型',1),('e4d32c19-480c-44f8-9fc5-06090ca0dfba',6,'考勤任务',0),('ffc19aef-1f3c-4fe1-95ea-c04a55a53f90',3,'算法进阶',3);
/*!40000 ALTER TABLE `teach_major_stage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_major_statistics`
--

DROP TABLE IF EXISTS `teach_major_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_major_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `major_id` int(11) DEFAULT NULL COMMENT '专业编号',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `month` date DEFAULT NULL COMMENT '统计月',
  `attendence` double DEFAULT NULL COMMENT 'attendence',
  `subject_percentage_complete` double DEFAULT NULL COMMENT '项目完成率',
  `job_percentage_complete` double DEFAULT NULL COMMENT '作业完成率',
  `exam_acceptability` double DEFAULT NULL COMMENT '考试合格率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='数据汇总（专业）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_major_statistics`
--

LOCK TABLES `teach_major_statistics` WRITE;
/*!40000 ALTER TABLE `teach_major_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_major_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_satisfaction`
--

DROP TABLE IF EXISTS `teach_satisfaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_satisfaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '评级时间',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `satisfaction` double DEFAULT NULL COMMENT '满意度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='满意度表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_satisfaction`
--

LOCK TABLES `teach_satisfaction` WRITE;
/*!40000 ALTER TABLE `teach_satisfaction` DISABLE KEYS */;
INSERT INTO `teach_satisfaction` VALUES (10,1,'2023-12-20 02:16:40',226,100),(11,1,'2023-12-20 02:16:58',226,100);
/*!40000 ALTER TABLE `teach_satisfaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_school`
--

DROP TABLE IF EXISTS `teach_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '校区id',
  `school_name` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '校区名称',
  `headmaster` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '校长',
  `president` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '副校长',
  `datetime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`school_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='校区表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_school`
--

LOCK TABLES `teach_school` WRITE;
/*!40000 ALTER TABLE `teach_school` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_status_record`
--

DROP TABLE IF EXISTS `teach_status_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_status_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态记录编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `change_type` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '更改类型',
  `change_content` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '更改内容',
  `change_time` datetime DEFAULT NULL COMMENT '更改时间',
  `up_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=605 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生状态更改记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_status_record`
--

LOCK TABLES `teach_status_record` WRITE;
/*!40000 ALTER TABLE `teach_status_record` DISABLE KEYS */;
INSERT INTO `teach_status_record` VALUES (603,2480,1,'状态变动','更改状态为“休学”','2023-12-18 00:40:57','2023-12-19'),(604,2480,1,'状态变动','“复学”','2023-12-18 00:42:04','2023-12-19');
/*!40000 ALTER TABLE `teach_status_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student`
--

DROP TABLE IF EXISTS `teach_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生ID',
  `kgc_no` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场账号',
  `kgc_uid` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场uid',
  `kgc_nickname` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '课工场昵称',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  `start_time` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '进班时间(报档时间)',
  `postname` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '学生项目的地址',
  `student_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名',
  `student_sex` int(1) DEFAULT NULL COMMENT '学生性别',
  `ethnic` int(2) DEFAULT NULL COMMENT '民族',
  `native_place` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '籍贯',
  `id_card_no` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月',
  `education` int(2) DEFAULT NULL COMMENT '学历',
  `politics_status` int(2) DEFAULT NULL COMMENT '政治面貌',
  `phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
  `mail` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `qq` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT 'qq号码',
  `city` int(3) DEFAULT NULL COMMENT '生源市',
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '家庭地址',
  `class_no` int(11) DEFAULT NULL COMMENT '班级编号',
  `dormitory` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '寝室编号',
  `student_father_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '学生父亲姓名',
  `student_father_phone` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '学生父亲电话',
  `student_father_unit` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '学生父亲工作单位',
  `student_mother_name` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '学生母亲姓名',
  `student_mother_phone` varchar(15) COLLATE utf8_bin DEFAULT NULL COMMENT '学生母亲电话',
  `student_mother_unit` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '学生母亲工作单位',
  `student_another_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '学生家庭其他成员',
  `single_parent` int(1) DEFAULT NULL COMMENT '是否单亲家庭（0，否；1，是）',
  `extend1` int(1) DEFAULT NULL COMMENT '学生来源',
  `extend2` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `extend3` datetime DEFAULT NULL COMMENT '创建时间',
  `graduate_institutions` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '毕业院校',
  `work_experience` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '学前工作经历',
  `base` int(1) DEFAULT NULL COMMENT '是否有基础（0，无；1，有）',
  `english_level` int(11) DEFAULT NULL COMMENT '英语水平(编号)',
  `degree_in_nature` int(1) DEFAULT NULL COMMENT '学历性质',
  `graduate_date` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '毕业时间',
  `major` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '专业',
  `up_time` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '时间',
  `emergency_contact` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '与紧急联络人的关系',
  `emergency_contact_phone` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '紧急联系人电话',
  `job_city` int(11) DEFAULT NULL COMMENT '就业意向城市（编号）',
  `textbook_no` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '教材编号',
  `traffic_permit` varchar(40) COLLATE utf8_bin DEFAULT NULL COMMENT '通行证',
  `postal_code` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '邮政编码',
  `student_name_pinyin` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '学生姓名拼音',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2491 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生档案表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student`
--

LOCK TABLES `teach_student` WRITE;
/*!40000 ALTER TABLE `teach_student` DISABLE KEYS */;
INSERT INTO `teach_student` VALUES (2478,NULL,NULL,NULL,1,'2023-12-18','','张圆圆',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'广州市白云区',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-12-17 23:48:57','白云小学',NULL,NULL,1,1,'2023-12-23','二年级',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(2479,NULL,NULL,NULL,1,'2023-12-18','','李笑笑',0,NULL,'广东','440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'佛山南海',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,'2023-12-17 23:48:57','白云小学',NULL,1,1,1,'2023-12-23','二年级',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(2480,NULL,NULL,NULL,1,'2023-12-18','','秦天',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'佛山南海',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'身体好起来了','2023-12-17 23:48:57','白云小学',NULL,NULL,1,1,'2023-12-23','二年级','2023-12-19',NULL,NULL,0,NULL,NULL,NULL,NULL),(2481,NULL,NULL,NULL,1,'2023-12-18','','刻晴',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'提瓦特大陆',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2023-12-17 23:48:57','白云小学',NULL,NULL,1,1,'2023-12-23','二年级',NULL,NULL,NULL,0,NULL,NULL,NULL,NULL),(2482,NULL,NULL,NULL,1,'2023-12-18','','甘雨',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'提瓦特大陆',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2483,NULL,NULL,NULL,1,'2023-12-18','','雪霏岚岚',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'广州市',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2484,NULL,NULL,NULL,1,'2023-12-18','','师欣',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'广州市',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2485,NULL,NULL,NULL,1,'2023-12-18','','迪奥娜',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'提瓦特大陆',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2486,NULL,NULL,NULL,1,'2023-12-18','','纳西妲',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'提瓦特大陆',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2487,NULL,NULL,NULL,1,'2023-12-18','','可莉',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'提瓦特大陆',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2488,NULL,NULL,NULL,1,'2023-12-18','','冰糖',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'润本',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2489,NULL,NULL,NULL,1,'2023-12-18','','真白花音',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'立本',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2490,NULL,NULL,NULL,1,'2023-12-18','','嘉然',0,NULL,NULL,'440111201505020013',NULL,1,NULL,'18202000000','510000',NULL,NULL,'上海市',2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `teach_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student_attendance`
--

DROP TABLE IF EXISTS `teach_student_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student_attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_id` int(11) DEFAULT NULL COMMENT '考勤表id',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `attendance` int(11) DEFAULT NULL COMMENT '考勤编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生考勤表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student_attendance`
--

LOCK TABLES `teach_student_attendance` WRITE;
/*!40000 ALTER TABLE `teach_student_attendance` DISABLE KEYS */;
INSERT INTO `teach_student_attendance` VALUES (1,0,2478,1),(2,0,2479,1),(3,0,2480,1),(4,0,2481,1),(5,1,2478,1),(6,1,2479,1),(7,1,2480,3),(8,1,2481,1),(9,2,2478,1),(10,2,2479,3),(11,2,2480,3),(12,2,2481,1);
/*!40000 ALTER TABLE `teach_student_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student_employment`
--

DROP TABLE IF EXISTS `teach_student_employment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student_employment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '就业编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `edittime` datetime DEFAULT NULL COMMENT '更新时间',
  `employment_way` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '就业方式',
  `hiredate` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '入职时间',
  `urban_employment` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '就业城市',
  `einheit` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '单位',
  `industry` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '所属行业',
  `probation_salary` double(10,0) DEFAULT NULL COMMENT '试用薪资',
  `obtainment_salary` double(10,0) DEFAULT NULL COMMENT '转正薪资',
  `obligate` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `teacher_employment` int(11) DEFAULT NULL COMMENT '就业老师',
  `employment_note` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '就业备注',
  `employment_isTrue` int(3) DEFAULT '1' COMMENT '就业是否属实',
  `visit_teacher` int(11) DEFAULT NULL COMMENT '回访老师',
  `visit_time` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '回访时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=446 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生就业信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student_employment`
--

LOCK TABLES `teach_student_employment` WRITE;
/*!40000 ALTER TABLE `teach_student_employment` DISABLE KEYS */;
INSERT INTO `teach_student_employment` VALUES (442,2478,'2023-12-17 23:48:57','毕业后就业','2023-12-12','广州','智软科技','教育',1000,2000,NULL,226,NULL,0,226,'2023-12-19'),(443,2479,'2023-12-17 23:48:57',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(444,2480,'2023-12-17 23:48:57',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL),(445,2481,'2023-12-17 23:48:57',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `teach_student_employment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student_exam`
--

DROP TABLE IF EXISTS `teach_student_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `exam_id` int(11) DEFAULT NULL COMMENT '考试编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `score` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '成绩',
  `remark` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=480 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生考试子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student_exam`
--

LOCK TABLES `teach_student_exam` WRITE;
/*!40000 ALTER TABLE `teach_student_exam` DISABLE KEYS */;
INSERT INTO `teach_student_exam` VALUES (476,1,2478,'70',NULL),(477,1,2479,'50',NULL),(478,1,2480,'88',NULL),(479,1,2481,'100',NULL);
/*!40000 ALTER TABLE `teach_student_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student_job`
--

DROP TABLE IF EXISTS `teach_student_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student_job` (
  `id` varchar(40) COLLATE utf8_bin NOT NULL,
  `job_id` int(11) DEFAULT NULL COMMENT '作业表编号',
  `student_id` int(11) DEFAULT NULL COMMENT '学生编号',
  `job_result` int(11) DEFAULT NULL COMMENT '作业评价编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生作业表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student_job`
--

LOCK TABLES `teach_student_job` WRITE;
/*!40000 ALTER TABLE `teach_student_job` DISABLE KEYS */;
INSERT INTO `teach_student_job` VALUES ('95052bde-21dd-4b8a-b6d7-506a437a9c48',1,2479,1),('b2f00e1a-14ee-4fb0-93cc-dead11d66f42',1,2481,2),('c0e9be3e-0d81-4719-846a-9d3d988e41fa',2,2479,2),('cc375834-9447-4ff8-a0c6-d940a2546847',2,2481,3),('d1c08b88-48c5-4061-be61-777ec289bfff',2,2478,2),('e000903c-456d-49d0-9b65-c083939c1466',1,2478,2),('ea99f245-7dfd-491c-84f6-421d27124e2d',1,2480,3),('f5f2d618-4ed5-45e4-9448-8514137961a0',2,2480,1);
/*!40000 ALTER TABLE `teach_student_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_student_subject`
--

DROP TABLE IF EXISTS `teach_student_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_student_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` int(11) DEFAULT NULL COMMENT '项目id',
  `student_id` int(11) DEFAULT NULL,
  `submit` varchar(2) COLLATE utf8_bin DEFAULT NULL,
  `subject_url` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `evaluate` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=342 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='学生项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_student_subject`
--

LOCK TABLES `teach_student_subject` WRITE;
/*!40000 ALTER TABLE `teach_student_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_student_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_subject`
--

DROP TABLE IF EXISTS `teach_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_subject` (
  `subject_id` int(11) NOT NULL COMMENT '项目id',
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `subject_name` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名称',
  `starttime` date DEFAULT NULL COMMENT '项目开始时间',
  `endtime` date DEFAULT NULL COMMENT '结束时间',
  `bestnum` int(3) DEFAULT NULL COMMENT '项目优人数',
  `goodnum` int(3) DEFAULT NULL COMMENT '项目良人数',
  `poornum` int(3) DEFAULT NULL COMMENT '项目差人数',
  `unfinishednum` int(3) DEFAULT NULL COMMENT '项目未提交人数',
  `studentnum` int(3) DEFAULT NULL COMMENT '班级总人数',
  `best_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '通过率',
  PRIMARY KEY (`subject_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='班级项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_subject`
--

LOCK TABLES `teach_subject` WRITE;
/*!40000 ALTER TABLE `teach_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_subject_attendance`
--

DROP TABLE IF EXISTS `teach_subject_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_subject_attendance` (
  `id` int(9) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '班级ID',
  `subject_id` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '项目ID',
  `attendance_starttime` date DEFAULT NULL COMMENT '项目开始时间',
  `attendance_endtime` date DEFAULT NULL COMMENT '项目结束时间',
  `subjectname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '项目名称',
  `bestnum` int(3) DEFAULT NULL COMMENT '作业优人数',
  `goodnum` int(3) DEFAULT NULL COMMENT '作业良人数',
  `poornum` int(3) DEFAULT NULL COMMENT '作业差人数',
  `unfinishednum` int(3) DEFAULT NULL COMMENT '作业未完成人数',
  `studentnum` int(5) DEFAULT NULL COMMENT '班级总人数',
  `best_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '作业优占比',
  `good_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '作业良占比',
  `poor_attendance` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '作业差占比',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='作业统计表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_subject_attendance`
--

LOCK TABLES `teach_subject_attendance` WRITE;
/*!40000 ALTER TABLE `teach_subject_attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_subject_attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_supervision_exam`
--

DROP TABLE IF EXISTS `teach_supervision_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_supervision_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `createtime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `exam_id` int(11) DEFAULT NULL COMMENT '考试编号',
  `school_acceptability` double DEFAULT NULL COMMENT '校区合格率',
  `headquarters_acceptability` double DEFAULT NULL COMMENT '总部合格率',
  `random_number` int(2) DEFAULT NULL COMMENT '抽查个数',
  `random_acceptability` double DEFAULT NULL COMMENT '抽查合格率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='总部督查考试表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_supervision_exam`
--

LOCK TABLES `teach_supervision_exam` WRITE;
/*!40000 ALTER TABLE `teach_supervision_exam` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_supervision_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_supervision_subject`
--

DROP TABLE IF EXISTS `teach_supervision_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_supervision_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) DEFAULT NULL COMMENT '班级编号',
  `createtime` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '创建时间',
  `subject_id` int(11) DEFAULT NULL COMMENT '项目编号',
  `school_acceptability` double DEFAULT NULL COMMENT '校区合格率',
  `headquarters_acceptability` double DEFAULT NULL COMMENT '总部合格率',
  `random_number` int(2) DEFAULT NULL COMMENT '抽查个数',
  `random_acceptability` double DEFAULT NULL COMMENT '抽查合格率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='总部督查项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_supervision_subject`
--

LOCK TABLES `teach_supervision_subject` WRITE;
/*!40000 ALTER TABLE `teach_supervision_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_supervision_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_teacher_statistics`
--

DROP TABLE IF EXISTS `teach_teacher_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_teacher_statistics` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师编号',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `month` date DEFAULT NULL COMMENT '统计月',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='数据汇总（教师）';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_teacher_statistics`
--

LOCK TABLES `teach_teacher_statistics` WRITE;
/*!40000 ALTER TABLE `teach_teacher_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_teacher_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teach_teacher_statistics_children`
--

DROP TABLE IF EXISTS `teach_teacher_statistics_children`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teach_teacher_statistics_children` (
  `id` int(11) NOT NULL,
  `teacher_statistics_id` int(11) DEFAULT NULL COMMENT '月度统计表id',
  `inspection_items_no` int(11) DEFAULT NULL COMMENT '考核项编号',
  `percentage_complete` double DEFAULT NULL COMMENT '考核项完成率',
  `grade` double DEFAULT NULL COMMENT '考核项得分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='数据统计（教师）子表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teach_teacher_statistics_children`
--

LOCK TABLES `teach_teacher_statistics_children` WRITE;
/*!40000 ALTER TABLE `teach_teacher_statistics_children` DISABLE KEYS */;
/*!40000 ALTER TABLE `teach_teacher_statistics_children` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `act_id_group`
--

/*!50001 DROP VIEW IF EXISTS `act_id_group`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `act_id_group` AS select `t`.`role_id` AS `id_`,1 AS `rev_`,`t`.`role_name` AS `name_`,`t`.`role_key` AS `type_` from `sys_role` `t` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `act_id_membership`
--

/*!50001 DROP VIEW IF EXISTS `act_id_membership`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `act_id_membership` AS select `sys_user_role`.`user_id` AS `user_id_`,`sys_user_role`.`role_id` AS `group_id_` from `sys_user_role` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `act_id_user`
--

/*!50001 DROP VIEW IF EXISTS `act_id_user`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `act_id_user` AS select `sys_user`.`user_id` AS `id_`,1 AS `rev_`,`sys_user`.`login_name` AS `first_`,`sys_user`.`user_name` AS `last_`,`sys_user`.`email` AS `email_`,`sys_user`.`password` AS `pwd_`,NULL AS `picture_id_` from `sys_user` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19 18:45:59
