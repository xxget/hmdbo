/*
 Navicat Premium Data Transfer

 Source Server         : 10.106.10.117
 Source Server Type    : SQL Server
 Source Server Version : 10501600
 Source Host           : 10.106.10.117:1433
 Source Catalog        : pdmqnew
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 10501600
 File Encoding         : 65001

 Date: 03/03/2021 15:10:02
*/


-- ----------------------------
-- Table structure for tb_fthfldtl_info
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[tb_fthfldtl_info]') AND type IN ('U'))
	DROP TABLE [dbo].[tb_fthfldtl_info]
GO

CREATE TABLE [dbo].[tb_fthfldtl_info] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [colltime] datetime  NOT NULL,
  [porttype] varchar(20) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [portid] varchar(30) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [devaddr] int  NOT NULL,
  [density] float(53)  NOT NULL,
  [tempretu] float(53)  NOT NULL,
  [pressure] float(53)  NOT NULL,
  [diffpres] float(53)  NOT NULL,
  [flow] float(53)  NOT NULL,
  [sumflow] float(53)  NOT NULL,
  [userid] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [status] char(30) COLLATE Chinese_PRC_CI_AS  NULL,
  [retrycnt] int  NULL,
  [PREST] float(53)  NULL,
  [DIFFPT] float(53)  NULL,
  [resetinfo] smallint  NULL,
  [warninfo] smallint  NULL,
  [t_stact] int  NOT NULL
)
GO

ALTER TABLE [dbo].[tb_fthfldtl_info] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'抄表时间',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'colltime'
GO

EXEC sp_addextendedproperty
'MS_Description', N'表网络类型',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'porttype'
GO

EXEC sp_addextendedproperty
'MS_Description', N'gps卡号码',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'portid'
GO

EXEC sp_addextendedproperty
'MS_Description', N'设备逻辑地址（设备号）',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'devaddr'
GO

EXEC sp_addextendedproperty
'MS_Description', N'密度',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'density'
GO

EXEC sp_addextendedproperty
'MS_Description', N'温度',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'tempretu'
GO

EXEC sp_addextendedproperty
'MS_Description', N'计量压力',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'pressure'
GO

EXEC sp_addextendedproperty
'MS_Description', N'计量差压',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'diffpres'
GO

EXEC sp_addextendedproperty
'MS_Description', N'瞬时流量',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'flow'
GO

EXEC sp_addextendedproperty
'MS_Description', N'累计流量',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'sumflow'
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户id',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'userid'
GO

EXEC sp_addextendedproperty
'MS_Description', N'状态',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'status'
GO

EXEC sp_addextendedproperty
'MS_Description', N'描述',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'retrycnt'
GO

EXEC sp_addextendedproperty
'MS_Description', N'诊断信息编码',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'resetinfo'
GO

EXEC sp_addextendedproperty
'MS_Description', N'市电报警',
'SCHEMA', N'dbo',
'TABLE', N'tb_fthfldtl_info',
'COLUMN', N'warninfo'
GO


-- ----------------------------
-- Auto increment value for tb_fthfldtl_info
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[tb_fthfldtl_info]', RESEED, 979)
GO


-- ----------------------------
-- Triggers structure for table tb_fthfldtl_info
-- ----------------------------
CREATE TRIGGER [dbo].[test1]
ON [dbo].[tb_fthfldtl_info]
WITH EXECUTE AS CALLER
FOR INSERT
AS
INSERT tb_fthfldtl_t_info (
	colltime,
	porttype,
	portid,
	devname,
	devaddr,
	density,
	tempretu,
	pressure,
	diffpres,
	flow,
	sumflow,
	userid,
	status,
	retrycnt,
	PREST,
	DIFFPT,
	resetinfo,
	warninfo,
	t_stact 
) SELECT
i.colltime,
i.porttype,
i.portid,
f.devname,
i.devaddr,
i.density,
i.tempretu,
i.pressure,
i.diffpres,
i.flow,
i.sumflow,
i.userid,
i.status,
i.retrycnt,
i.PREST,
i.DIFFPT,
i.resetinfo,
i.warninfo,
0 
FROM
	inserted i LEFT JOIN pd.fthfldev f ON i.portid=f.portid
GO

CREATE TRIGGER [dbo].[test2]
ON [dbo].[tb_fthfldtl_info]
WITH EXECUTE AS CALLER
FOR INSERT
AS
insert tb_fthfldtl_t_info (colltime,porttype,portid,devaddr,density,tempretu,pressure,diffpres,flow,sumflow,userid,status,retrycnt,PREST,DIFFPT,resetinfo,warninfo,t_stact) 
select i.colltime,i.porttype,i.portid,i.devaddr,i.density,i.tempretu,i.pressure,i.diffpres,i.flow,i.sumflow,i.userid,i.status,i.retrycnt,i.PREST,i.DIFFPT,i.resetinfo,i.warninfo, 0 from inserted i
GO

DISABLE TRIGGER [dbo].[test2] ON [dbo].[tb_fthfldtl_info]
GO


-- ----------------------------
-- Primary Key structure for table tb_fthfldtl_info
-- ----------------------------
ALTER TABLE [dbo].[tb_fthfldtl_info] ADD CONSTRAINT [PK__tb_fthfl__3213E83F245D67DE] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

