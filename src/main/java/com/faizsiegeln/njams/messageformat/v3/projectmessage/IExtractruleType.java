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
package com.faizsiegeln.njams.messageformat.v3.projectmessage;

/**
 *
 * @author stkniep
 */
public interface IExtractruleType {

    /**
     * Gets the value of the attribute property.
     *
     * @return possible object is {@link String }
     *
     */
    String getAttribute();

    /**
     * Gets the value of the attributeType property.
     *
     * @return possible object is {@link AttributeType }
     *
     */
    AttributeType getAttributeType();

    /**
     * Gets the value of the inout property.
     *
     * @return possible object is {@link String }
     *
     */
    String getInout();

    /**
     * Gets the value of the rule property.
     *
     * @return possible object is {@link String }
     *
     */
    String getRule();

    /**
     * Gets the value of the ruleType property.
     *
     * @return possible object is {@link RuleType }
     *
     */
    RuleType getRuleType();

    /**
     * Sets the value of the attribute property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setAttribute(String value);

    /**
     * Sets the value of the attributeType property.
     *
     * @param value
     *            allowed object is {@link AttributeType }
     *
     */
    void setAttributeType(AttributeType value);

    /**
     * Sets the value of the inout property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setInout(String value);

    /**
     * Sets the value of the rule property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setRule(String value);

    /**
     * Sets the value of the ruleType property.
     *
     * @param value
     *            allowed object is {@link RuleType }
     *
     */
    void setRuleType(RuleType value);

}
