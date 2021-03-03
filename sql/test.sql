-- ----------------------------
-- 触发器
-- ----------------------------
CREATE TRIGGER test1 ON dbo.tb_fthfldtl_info FOR INSERT AS INSERT tb_fthfldtl_t_info (
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
