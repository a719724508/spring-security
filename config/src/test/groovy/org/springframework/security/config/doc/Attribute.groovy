/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.springframework.security.config.doc

/**
 * Represents a Spring Security XSD Attribute. It is created when parsing the current xsd to compare to the documented appendix.
 *
 * @author Rob Winch
 * @see SpringSecurityXsdParser
 * @see XsdDocumentedSpec
 */
class Attribute {
    def prefix = ""
    def name
    def desc
    def elmt

    def indent() {
        prefix += "    "
    }

    def toDocbook(prefix) {
        def indent = "    "+prefix
        """
${prefix}<section xml:id="${id}">
${indent}<title><literal>${name}</literal></title>
${indent}<para>${desc}</para>
${prefix}</section>"""
    }
    def getId() {
        return "${elmt.id}-${name}".toString()
    }
    public String toString() {
        prefix + '@' + name + " - " + desc
    }
}
