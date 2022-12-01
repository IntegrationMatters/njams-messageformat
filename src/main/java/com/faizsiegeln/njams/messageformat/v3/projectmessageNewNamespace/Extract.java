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
package com.faizsiegeln.njams.messageformat.v3.projectmessageNewNamespace;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.faizsiegeln.njams.messageformat.v3.projectmessage.IExtract;
import com.faizsiegeln.njams.messageformat.v3.projectmessage.IExtractionrules;

/**
 * <p>
 * Java class for anonymous complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="extractionrules"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="extractrule" type="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}extractruleType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="domain" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="deployment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="engine" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="process" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="activity" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "extractionrules" })
@XmlRootElement(name = "extract")
@Deprecated
public class Extract implements IExtract<Extract.Extractionrules> {

    @XmlElement(required = true)
    protected Extract.Extractionrules extractionrules;
    @XmlAttribute(name = "domain")
    protected String domain;
    @XmlAttribute(name = "deployment")
    protected String deployment;
    @XmlAttribute(name = "engine")
    protected String engine;
    @XmlAttribute(name = "process")
    protected String process;
    @XmlAttribute(name = "activity")
    protected String activity;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the extractionrules property.
     *
     * @return possible object is {@link Extract.Extractionrules }
     *
     */
    @Override
    public Extract.Extractionrules getExtractionrules() {
        return extractionrules;
    }

    /**
     * Sets the value of the extractionrules property.
     *
     * @param value
     *            allowed object is {@link Extract.Extractionrules }
     *
     */
    @Override
    public void setExtractionrules(Extract.Extractionrules value) {
        extractionrules = value;
    }

    /**
     * Gets the value of the domain property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setDomain(String value) {
        domain = value;
    }

    /**
     * Gets the value of the deployment property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getDeployment() {
        return deployment;
    }

    /**
     * Sets the value of the deployment property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setDeployment(String value) {
        deployment = value;
    }

    /**
     * Gets the value of the engine property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setEngine(String value) {
        engine = value;
    }

    /**
     * Gets the value of the process property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getProcess() {
        return process;
    }

    /**
     * Sets the value of the process property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setProcess(String value) {
        process = value;
    }

    /**
     * Gets the value of the activity property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getActivity() {
        return activity;
    }

    /**
     * Sets the value of the activity property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setActivity(String value) {
        activity = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public Extract.Extractionrules createExtractionrules() {
        extractionrules = new Extractionrules();
        return extractionrules;
    }

    /**
     * <p>
     * Java class for anonymous complex type.
     *
     * <p>
     * The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="extractrule" type="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}extractruleType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "extractrule" })
    @Deprecated
    public static class Extractionrules implements IExtractionrules<ExtractruleType> {

        @XmlElement(required = true)
        protected List<ExtractruleType> extractrule;

        /**
         * Gets the value of the extractrule property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for the
         * extractrule property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         *
         * <pre>
         * getExtractrule().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ExtractruleType }
         *
         *
         */
        @Override
        public List<ExtractruleType> getExtractrule() {
            if (extractrule == null) {
                extractrule = new ArrayList<>();
            }
            return extractrule;
        }

        @Override
        public ExtractruleType createExtractruleType() {
            return new ExtractruleType();
        }
    }
}
