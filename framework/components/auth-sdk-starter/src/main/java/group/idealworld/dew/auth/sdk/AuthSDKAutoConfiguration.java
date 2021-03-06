/*
 * Copyright 2020. the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package group.idealworld.dew.auth.sdk;

import group.idealworld.dew.Dew;
import group.idealworld.dew.core.DewContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Auth sdk auto configuration.
 *
 * @author gudaoxuri
 */
@Configuration
@AutoConfigureAfter(Dew.class)
public class AuthSDKAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(AuthSDKAutoConfiguration.class);

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        logger.info("Load Auto Configuration : {}", this.getClass().getName());
        logger.info("Enabled Dew Auth SDK");
        Dew.auth = new AuthSDKAdapter();
        DewContext.setOptInfoClazz(TokenInfo.class);
    }

}
