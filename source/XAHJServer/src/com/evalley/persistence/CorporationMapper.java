/*
 * Created on 12-9-14
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright @2012 the original author or authors.
 */
package com.evalley.persistence;

import com.evalley.domain.Corporation;

/**
 * Description of this file.
 * User: Xiong Neng
 * Date: 12-9-14
 * Time: 上午11:49
 */
public interface CorporationMapper {
	Corporation selectCorporation(long blogId);
    void insertBlog(Corporation corporation);
}
