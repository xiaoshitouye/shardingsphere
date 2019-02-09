/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.encrypt.encryptor.imp;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.spi.algorithm.encrypt.ShardingEncryptor;

import java.util.Properties;

/**
 * DES sharding encryptor.
 *
 * @author panjuan
 */
@Getter
@Setter
public final class DESShardingEncryptor implements ShardingEncryptor {
    
    private Properties properties = new Properties();
    
    @Override
    public String getType() {
        return "DES";
    }
    
    @Override
    public Object encode(final Object plaintext) {
        return new String(DigestUtils.md5(String.valueOf(plaintext)));
    }
    
    @Override
    public Object decode(final Object ciphertext) {
        return ciphertext;
    }
}
