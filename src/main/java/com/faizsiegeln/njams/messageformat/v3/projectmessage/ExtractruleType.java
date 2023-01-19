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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for extractruleType complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="extractruleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="attributeType" type="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}attributeType" default="unknown" /&gt;
 *       &lt;attribute name="ruleType" type="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}ruleType" /&gt;
 *       &lt;attribute name="rule" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="inout" type="{http://www.w3.org/2001/XMLSchema}string" default="out" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extractruleType")
@Deprecated
public class ExtractruleType implements IExtractruleType {

    @XmlAttribute(name = "attribute")
    protected String attribute;
    @XmlAttribute(name = "attributeType")
    protected AttributeType attributeType;
    @XmlAttribute(name = "ruleType")
    protected RuleType ruleType;
    @XmlAttribute(name = "rule")
    protected String rule;
    @XmlAttribute(name = "inout")
    protected String inout;

    /**
     * Gets the value of the attribute property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setAttribute(String value) {
        attribute = value;
    }

    /**
     * Gets the value of the attributeType property.
     *
     * @return possible object is {@link AttributeType }
     *
     */
    @Override
    public AttributeType getAttributeType() {
        if (attributeType == null) {
            return AttributeType.UNKNOWN;
        } else {
            return attributeType;
        }
    }

    /**
     * Sets the value of the attributeType property.
     *
     * @param value
     *            allowed object is {@link AttributeType }
     *
     */
    @Override
    public void setAttributeType(AttributeType value) {
        attributeType = value;
    }

    /**
     * Gets the value of the ruleType property.
     *
     * @return possible object is {@link RuleType }
     *
     */
    @Override
    public RuleType getRuleType() {
        return ruleType;
    }

    /**
     * Sets the value of the ruleType property.
     *
     * @param value
     *            allowed object is {@link RuleType }
     *
     */
    @Override
    public void setRuleType(RuleType value) {
        ruleType = value;
    }

    /**
     * Gets the value of the rule property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setRule(String value) {
        rule = value;
    }

    /**
     * Gets the value of the inout property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getInout() {
        if (inout == null) {
            return "out";
        } else {
            return inout;
        }
    }

    /**
     * Sets the value of the inout property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setInout(String value) {
        inout = value;
    }

}
