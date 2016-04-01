/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2016 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.authentication.mapper.api;

import java.util.Map;

/**
 * @author bryan
 */
public interface AuthenticationMappingService<InputType, OutputType> {
  String getId();

  Class<? extends InputType> getInputType();

  Class<? extends OutputType> getOutputType();

  default <I extends InputType> boolean accepts( I input ) {
    return getInputType().isInstance( input );
  }

  OutputType getMapping( InputType input, Map<String, ?> config ) throws MappingException;
}
