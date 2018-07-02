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
package com.faizsiegeln.njams.messageformat.command;

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
 * Java class for Instruction element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="Instruction"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element name="Request"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://www.faizsiegeln.com/njams/client/plugin/instruction}Parametergroup" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="Command" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="Plugin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;element name="Response" minOccurs="0"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{http://www.faizsiegeln.com/njams/client/plugin/instruction}Parametergroup" maxOccurs="unbounded"/&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attribute name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="ResultMessage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                   &lt;attribute name="Result"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="Success"/&gt;
 *                         &lt;enumeration value="Error"/&gt;
 *                         &lt;enumeration value="Warning"/&gt;
 *                         &lt;enumeration value="Info"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "request", "response" })
@XmlRootElement(name = "Instruction")
public class Instruction {

    @XmlElement(name = "Request", required = true)
    protected Instruction.Request request;
    @XmlElement(name = "Response")
    protected Instruction.Response response;

    /**
     * Gets the value of the request property.
     * 
     * @return possible object is {@link Instruction.Request }
     * 
     */
    public Instruction.Request getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     * 
     * @param value
     *            allowed object is {@link Instruction.Request }
     * 
     */
    public void setRequest(Instruction.Request value) {
        this.request = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return possible object is {@link Instruction.Response }
     * 
     */
    public Instruction.Response getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *            allowed object is {@link Instruction.Response }
     * 
     */
    public void setResponse(Instruction.Response value) {
        this.response = value;
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
     *         &lt;element ref="{http://www.faizsiegeln.com/njams/client/plugin/instruction}Parametergroup" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Command" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="Plugin" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "parametergroup" })
    public static class Request {

        @XmlElement(name = "Parametergroup", required = true)
        protected List<Parametergroup> parametergroup;
        @XmlAttribute(name = "Command")
        protected String command;
        @XmlAttribute(name = "Plugin")
        protected String plugin;
        @XmlAttribute(name = "Timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the parametergroup property.
         * 
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you
         * make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
         * method for the parametergroup property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * 
         * <pre>
         * getParametergroup().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Parametergroup }
         * 
         * @return the parametergroup
         */
        public List<Parametergroup> getParametergroup() {
            if (parametergroup == null) {
                parametergroup = new ArrayList<Parametergroup>();
            }
            return this.parametergroup;
        }

        /**
         * Gets the value of the command property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getCommand() {
            return command;
        }

        /**
         * Sets the value of the command property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setCommand(String value) {
            this.command = value;
        }

        /**
         * Gets the value of the plugin property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getPlugin() {
            return plugin;
        }

        /**
         * Sets the value of the plugin property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setPlugin(String value) {
            this.plugin = value;
        }

        /**
         * Gets the value of the timestamp property.
         * 
         * @return possible object is {@link Long }
         * 
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         * 
         * @param value
         *            allowed object is {@link Long }
         * 
         */
        public void setTimestamp(Long value) {
            this.timestamp = value;
        }

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
     *         &lt;element ref="{http://www.faizsiegeln.com/njams/client/plugin/instruction}Parametergroup" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ResultCode" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="ResultMessage" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *       &lt;attribute name="Result"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="Success"/&gt;
     *             &lt;enumeration value="Error"/&gt;
     *             &lt;enumeration value="Warning"/&gt;
     *             &lt;enumeration value="Info"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}long" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "parametergroup" })
    public static class Response {

        @XmlElement(name = "Parametergroup", required = true)
        protected List<Parametergroup> parametergroup;
        @XmlAttribute(name = "ResultCode")
        protected String resultCode;
        @XmlAttribute(name = "ResultMessage")
        protected String resultMessage;
        @XmlAttribute(name = "Result")
        protected String result;
        @XmlAttribute(name = "Timestamp")
        protected Long timestamp;

        /**
         * Gets the value of the parametergroup property.
         * 
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you
         * make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
         * method for the parametergroup property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * 
         * <pre>
         * getParametergroup().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Parametergroup }
         * 
         * @return the parametergroup
         */
        public List<Parametergroup> getParametergroup() {
            if (parametergroup == null) {
                parametergroup = new ArrayList<Parametergroup>();
            }
            return this.parametergroup;
        }

        /**
         * Gets the value of the resultCode property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getResultCode() {
            return resultCode;
        }

        /**
         * Sets the value of the resultCode property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setResultCode(String value) {
            this.resultCode = value;
        }

        /**
         * Gets the value of the resultMessage property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getResultMessage() {
            return resultMessage;
        }

        /**
         * Sets the value of the resultMessage property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setResultMessage(String value) {
            this.resultMessage = value;
        }

        /**
         * Gets the value of the result property.
         * 
         * @return possible object is {@link String }
         * 
         */
        public String getResult() {
            return result;
        }

        /**
         * Sets the value of the result property.
         * 
         * @param value
         *            allowed object is {@link String }
         * 
         */
        public void setResult(String value) {
            this.result = value;
        }

        /**
         * Gets the value of the timestamp property.
         * 
         * @return possible object is {@link Long }
         * 
         */
        public Long getTimestamp() {
            return timestamp;
        }

        /**
         * Sets the value of the timestamp property.
         * 
         * @param value
         *            allowed object is {@link Long }
         * 
         */
        public void setTimestamp(Long value) {
            this.timestamp = value;
        }

    }

}
