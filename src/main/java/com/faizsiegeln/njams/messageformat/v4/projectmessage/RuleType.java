/* 
 * Copyright (c) 2018 Faiz & Siegeln Software GmbH
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * 
 * The Software shall be used for Good, not Evil.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.projectmessage;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlJavaTypeAdapter(RuleTypeAdapter.class)
public enum RuleType {
    EVENT("eventType"),
    REGEXP("regexp"),
    VALUE("value"),
    XPATH("xpath"),
    JMESPATH("jmespath"),
    DISABLED("");
    
    private final String value;

    private RuleType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
    
    public static RuleType fromValue(String value) {
        switch(value) {
            case "eventType" :
                return RuleType.EVENT;
            case "regexp":
                return RuleType.REGEXP;
            case "value" :
                return RuleType.VALUE;
            case "xpath":
                return RuleType.XPATH;
            case "jmespath":
                return RuleType.JMESPATH;
            default:
                return RuleType.DISABLED;
        }
    }
}
