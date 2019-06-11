/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.model;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.apache.camel.Endpoint;
import org.apache.camel.NoSuchEndpointException;
import org.apache.camel.spi.RouteContext;

@XmlTransient
public class AbstractEndpointBuilder<T extends AbstractEndpointBuilder> {

    protected final String scheme;
    protected final String path;
    protected final Map<String, Object> properties = new HashMap<>();

    public AbstractEndpointBuilder(String scheme, String path) {
        this.scheme = scheme;
        this.path = path;
    }

    public Endpoint resolve(RouteContext context) throws NoSuchEndpointException {
        return context.resolveEndpoint(scheme + ":" + path, properties);
    }

}
