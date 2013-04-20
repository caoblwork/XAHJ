package com.hangu.emes.dao;

import org.springframework.stereotype.Repository;

import com.hangu.emes.entity.PsBaseInfo;
import com.hangu.framework.dao.mybatis.BaseMyBatisDAOImpl;


@Repository(value = "psBaseInfoDAO")
public class PsBaseInfoDAOImpl extends BaseMyBatisDAOImpl<PsBaseInfo,String> implements PsBaseInfoDAO {

//    Logger logger = LoggerFactory.getLogger(PsBaseInfoDAOImpl.class);
//
//    public PsBaseInfo entitySave(PsBaseInfo entity) {
//
//        String id = StringUtil.generateStringIdentity();
//        if(null == entity.getCommunicateAddr()) {
//            entity.setCommunicateAddr("");
//         }
//         if(null == entity.getTotalArea()) {
//            entity.setTotalArea(0.0);
//         }
//         if(null == entity.getRemark()) {
//             entity.setRemark("");
//          }
//        final String sql = "insert into psbaseinfo(PSCode,PSName,RegionCode,RunDate,OfficePhone,CommunicateAddr,Linkman,Status,TotalArea,iType,CorporationName,psclassCode) values('"
//                + id
//                + "','"
//                + entity.getPsname()
//                + "','"
//                + entity.getRegionCode()
//                + "','"
//                + DateUtil.convertDate2String(entity.getRunDate(), DateUtil.getDatePattern())
//                + "','"
//                + entity.getOfficePhone()
//                + "','"
//                + entity.getCommunicateAddr()
//                + "','"
//                + entity.getLinkman()
//                + "','0','"
//                + entity.getTotalArea()
//                + "','"
//                + entity.getiType()
//                + "','"
//                + entity.getCorporationName() + "','" + entity.getPsclassCode() + "','"+entity.getRemark()+"')";
//
//        logger.debug(sql);
//
//        try {
//            HibernateTemplate template = new HibernateTemplate(getSessionFactory());
//            template.execute(new HibernateCallback<Object>() {
//                public Object doInHibernate(Session session) throws HibernateException, SQLException {
//                    Query query = session.createSQLQuery(sql);
//                    return query.executeUpdate();
//                }
//            });
//            entity.setId(id);
//        } catch (Exception e) {
//            logger.debug("execute sql insert error !\nthe trance catched information is :" + e.getMessage());
//            return new PsBaseInfo();
//        }
//        return entity;
//    }
//    public PsBaseInfo entityUpdate(PsBaseInfo entity) {
//        if(null == entity.getCommunicateAddr()) {
//            entity.setCommunicateAddr("");
//         }
//         if(null == entity.getTotalArea()) {
//            entity.setTotalArea(0.0);
//         }
//         if(null == entity.getRemark()) {
//             entity.setRemark("");
//          }
//        final String sql = "UPDATE psbaseinfo SET PSName='" + entity.getPsname() + "', RegionCode='" + entity.getRegionCode() + "',RunDate='"
//                + DateUtil.convertDate2String(entity.getRunDate(), DateUtil.getDatePattern()) + "',OfficePhone='" + entity.getOfficePhone()
//                + "',CommunicateAddr='" + entity.getCommunicateAddr() + "',Linkman='" + entity.getLinkman() + "',TotalArea='" + entity.getTotalArea()
//                + "',iType='" + entity.getiType() + "',CorporationName='" + entity.getCorporationName() + "',remark='"+entity.getRemark()+"',psclassCode='"+entity.getPsclassCode()+"' where PSCode = '" + entity.getId() + "'";
//        logger.debug(sql);
//        try {
//            HibernateTemplate template = new HibernateTemplate(getSessionFactory());
//            template.execute(new HibernateCallback<Object>() {
//                public Object doInHibernate(Session session) throws HibernateException, SQLException {
//                    Query query = session.createSQLQuery(sql);
//                    return query.executeUpdate();
//                }
//            });
//
//        } catch (Exception e) {
//            logger.debug("execute sql upate error !\nthe trance catched information is :" + e.getMessage());
//            return entity;
//        }
//        return entity;
//    }
//
//    @Override
//    public PsBaseInfo save(PsBaseInfo entity) {
//        if (StringUtil.isValidString(entity.getId())) {
//            return entityUpdate(entity);
//        } else {
//            return entitySave(entity);
//        }
//    }
}
