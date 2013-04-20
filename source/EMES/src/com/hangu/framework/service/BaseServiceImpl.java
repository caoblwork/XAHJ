package com.hangu.framework.service;


public class BaseServiceImpl implements BaseService {

//    /**
//     * 操作日志服务
//     */
//    protected OperationLogService logService = null;
//
//    @Autowired
//    public void setOperationLogService(OperationLogService logService) {
//        this.logService = logService;
//    }
//
//    protected void writeOperateLog(OperationLogVo operationLog) {
//        // 构建日志值对象
//        UserDetailInfo userInfo = SpringSecurityUtils.getCurrentUser();
//        operationLog.setOperatorId(userInfo.getUsername());
//        operationLog.setOperatorName(userInfo.getRealName());
//        operationLog.setIpAddress(userInfo.getIpAddress());
//        operationLog.setOperationTime(DateUtil.getDateNow());
//        // 存储日志
//        logService.save(operationLog);
//    }
}
