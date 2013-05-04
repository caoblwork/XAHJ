/*
 * Copyright 2005-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hangu.emes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hangu.emes.dao.WryjbxxDAOImpl;
import com.hangu.emes.entity.Wryjbxx;
import com.hangu.emes.vo.WryjbxxVo;
import com.hangu.framework.dao.BaseDAO;
import com.hangu.framework.service.EntityServiceImpl;
/**
 * Wryjbxx service实现类
 * 
 * @author 修改成自己的名字
 * @version 1.0
 * 
 */
@Service(value = "wryjbxxService")
public class WryjbxxServiceImpl extends EntityServiceImpl<WryjbxxVo, Wryjbxx> implements WryjbxxService {
    /**
     * Wryjbxx DAO
     */
    private WryjbxxDAOImpl wryjbxxDao;
    
    @Autowired
    public void setWryjbxxDao(BaseDAO<Wryjbxx, Serializable> wryjbxx) {
        super.dao = wryjbxx;
    }
}
