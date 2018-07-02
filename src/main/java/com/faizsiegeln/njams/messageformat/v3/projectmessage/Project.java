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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/gv/2013-05-04/}globalVariables" minOccurs="0"/&gt;
 *         &lt;element name="resource" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                     &lt;element name="binary" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/aspect/2011-04-21/}aspects" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/advice/2011-04-21/}advices" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}extracts" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.faizsiegeln.com/schema/njams/extracts/2012-10-22/}tracing" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="startDateTime" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *       &lt;attribute name="engine" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="domain" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="deployment" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="event" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="features" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" default="bw" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "globalVariables", "resource", "aspects", "advices", "extracts", "tracing" })
@XmlRootElement(name = "project", namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/")
public class Project {

    @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/gv/2013-05-04/")
    protected GlobalVariables globalVariables;
    @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/")
    protected List<Project.Resource> resource;
    @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/aspect/2011-04-21/")
    protected Aspects aspects;
    @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/advice/2011-04-21/")
    protected Advices advices;
    protected Extracts extracts;
    protected Tracing tracing;
    @XmlAttribute(name = "startDateTime")
    protected Long startDateTime;
    @XmlAttribute(name = "engine")
    protected String engine;
    @XmlAttribute(name = "domain")
    protected String domain;
    @XmlAttribute(name = "deployment")
    protected String deployment;
    @XmlAttribute(name = "event")
    protected String event;
    @XmlAttribute(name = "features")
    protected String features;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "clientVersion")
    private String clientVersion;
    @XmlAttribute(name = "sdkVersion")
    private String sdkVersion;
    @XmlAttribute(name = "category")
    protected String category;

    /**
     * @return the clientVersion
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * @param clientVersion the clientVersion to set
     */
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    /**
     * Gets the value of the globalVariables property.
     * 
     * @return possible object is {@link GlobalVariables }
     * 
     */
    public GlobalVariables getGlobalVariables() {
        return globalVariables;
    }

    /**
     * Sets the value of the globalVariables property.
     * 
     * @param value
     *            allowed object is {@link GlobalVariables }
     * 
     */
    public void setGlobalVariables(GlobalVariables value) {
        this.globalVariables = value;
    }

    /**
     * Gets the value of the resource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to
     * the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE> method for
     * the resource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Project.Resource }
     * 
     * 
     */
    public List<Project.Resource> getResource() {
        if (resource == null) {
            resource = new ArrayList<Project.Resource>();
        }
        return this.resource;
    }

    /**
     * Gets the value of the aspects property.
     * 
     * @return possible object is {@link Aspects }
     * 
     */
    public Aspects getAspects() {
        return aspects;
    }

    /**
     * Sets the value of the aspects property.
     * 
     * @param value
     *            allowed object is {@link Aspects }
     * 
     */
    public void setAspects(Aspects value) {
        this.aspects = value;
    }

    /**
     * Gets the value of the advices property.
     * 
     * @return possible object is {@link Advices }
     * 
     */
    public Advices getAdvices() {
        return advices;
    }

    /**
     * Sets the value of the advices property.
     * 
     * @param value
     *            allowed object is {@link Advices }
     * 
     */
    public void setAdvices(Advices value) {
        this.advices = value;
    }

    /**
     * Gets the value of the extracts property.
     * 
     * @return possible object is {@link Extracts }
     * 
     */
    public Extracts getExtracts() {
        return extracts;
    }

    /**
     * Sets the value of the extracts property.
     * 
     * @param value
     *            allowed object is {@link Extracts }
     * 
     */
    public void setExtracts(Extracts value) {
        this.extracts = value;
    }

    /**
     * @return the sdkVersion
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * @param sdkVersion the sdkVersion to set
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * Gets the value of the tracing property.
     * 
     * @return possible object is {@link Tracing }
     * 
     */
    public Tracing getTracing() {
        return tracing;
    }

    /**
     * Sets the value of the tracing property.
     * 
     * @param value
     *            allowed object is {@link Tracing }
     * 
     */
    public void setTracing(Tracing value) {
        this.tracing = value;
    }

    /**
     * Gets the value of the startDateTime property.
     * 
     * @return possible object is {@link Long }
     * 
     */
    public Long getStartDateTime() {
        return startDateTime;
    }

    /**
     * Sets the value of the startDateTime property.
     * 
     * @param value
     *            allowed object is {@link Long }
     * 
     */
    public void setStartDateTime(Long value) {
        this.startDateTime = value;
    }

    /**
     * Gets the value of the engine property.
     * 
     * @return possible object is {@link String }
     * 
     */
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
    public void setEngine(String value) {
        this.engine = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return possible object is {@link String }
     * 
     */
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
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the deployment property.
     * 
     * @return possible object is {@link String }
     * 
     */
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
    public void setDeployment(String value) {
        this.deployment = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the features property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getFeatures() {
        return features;
    }

    /**
     * Sets the value of the features property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setFeatures(String value) {
        this.features = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getCategory() {
        if (category == null) {
            return "bw";
        } else {
            return category;
        }
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setCategory(String value) {
        this.category = value;
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
     *         &lt;element name="uri" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;choice&gt;
     *           &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *           &lt;element name="binary" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *         &lt;/choice&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "uri", "type", "source", "binary" })
    public static class Resource {

        @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/", required = true)
        protected String uri;
        @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/", required = true)
        protected String type;
        @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/")
        protected String source;
        @XmlElement(namespace = "http://www.faizsiegeln.com/schema/njams/project/2011-04-21/")
        protected byte[] binary;

        /**
         * Gets the value of the uri property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getUri() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setUri(String value) {
            this.uri = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the source property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getSource() {
            return source;
        }

        /**
         * Sets the value of the source property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setSource(String value) {
            this.source = value;
        }

        /**
         * Gets the value of the binary property.
         * 
         * @return possible object is byte[]
         */
        public byte[] getBinary() {
            return binary;
        }

        /**
         * Sets the value of the binary property.
         * 
         * @param value
         *            allowed object is byte[]
         */
        public void setBinary(byte[] value) {
            this.binary = (value);
        }

    }

}
