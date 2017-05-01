/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package server

import scala.language.experimental.macros
import scala.reflect.macros.whitebox.Context
import org.slf4j.LoggerFactory

object s {

  val log = LoggerFactory.getLogger(getClass)

  def execute(f: () => Unit): Unit = macro _execute

  def _execute(c: Context)(f: c.Tree): c.Tree = {
    import c.universe._
    f match {
      case q"(..$args) => $body" => {
        log.info(s"args: $args body: $body") 
      }
      case unknown@_ => log.info(s"unknown: $unknown")
    }
    f
  }
}
