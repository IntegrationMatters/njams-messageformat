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

/**
 *
 * @author pnientiedt
 */
public class ExtractRule {

    protected String attribute;
    protected AttributeType attributeType;
    protected RuleType ruleType;
    protected String rule;
    protected String inout;

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String value) {
        this.attribute = value;
    }

    public AttributeType getAttributeType() {
        if (attributeType == null) {
            return AttributeType.UNKNOWN;
        } else {
            return attributeType;
        }
    }

    public void setAttributeType(AttributeType value) {
        this.attributeType = value;
    }

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType value) {
        this.ruleType = value;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String value) {
        this.rule = value;
    }

    public String getInout() {
        if (inout == null) {
            return "out";
        } else {
            return inout;
        }
    }

    public void setInout(String value) {
        this.inout = value;
    }

}
