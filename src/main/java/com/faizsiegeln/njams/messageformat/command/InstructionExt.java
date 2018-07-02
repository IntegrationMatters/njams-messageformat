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

import com.faizsiegeln.njams.messageformat.command.Parametergroup.Parameter;
import com.faizsiegeln.njams.messageformat.common.BasicCommand;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Instruction")
public class InstructionExt extends Instruction implements BasicCommand {

    private static final Logger LOG = LoggerFactory.getLogger(InstructionExt.class);

    public InstructionExt() {
        this.request = new Request();
        this.response = new Response();
    }

    public static InstructionExt createInstructionExt(String in) {
        if (!in.startsWith("<?xml")) {
            return null;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(InstructionExt.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // JAXB changed its constant FACTORY in one of the releases. Let's
            // make sure we cover that!
            try {
                unmarshaller.setProperty("com.sun.xml.internal.bind.ObjectFactory",
                        new ObjectFactory());
            } catch (PropertyException e) {
                unmarshaller.setProperty("com.sun.xml.bind.ObjectFactory",
                        new ObjectFactory());
            }
            return (InstructionExt) unmarshaller.unmarshal(new StringReader(in));
        } catch (Exception e) {
            LOG.error("error creating instruction", e);
        }
        return null;
    }

    public String toXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(Instruction.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter sw = new StringWriter();
            marshaller.marshal(this, sw);
            return sw.toString();
        } catch (Exception e) {
            LOG.error("error serializing instruction", e);
        }
        return "";
    }

    @Override
    public String toString() {
        return toXml();
    }

    // returns the first parameter that matches the name
    @Override
    public String getRequestParameterByName(String name) {
        if (!this.getRequest().getParametergroup().isEmpty()) {
            List<Parametergroup> pgg = this.getRequest().getParametergroup();
            for (Parametergroup pg : pgg) {
                List<Parameter> pp = pg.getParameter();
                for (Parameter p : pp) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        return p.getValue();
                    }
                }
            }
        }
        return null;
    }

    // returns the first parameter that matches the name
    @Override
    public String getResponseParameterByName(String name) {
        if (!this.getResponse().getParametergroup().isEmpty()) {
            List<Parametergroup> pgg = this.getResponse().getParametergroup();
            for (Parametergroup pg : pgg) {
                List<Parameter> pp = pg.getParameter();
                for (Parameter p : pp) {
                    if (p.getName().equalsIgnoreCase(name)) {
                        return p.getValue();
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void setRequestParameter(String name, String value) {
        // this also updates existing parameters of same name!
        if (getRequestParameterByName(name) == null) {
            if (this.getRequest() == null) {
                this.setRequest(new Request());
            }
            Parameter p = new Parameter();
            p.setName(name);
            p.setValue(value == null ? "" : value);
            if (this.getRequest().getParametergroup().isEmpty()) {
                this.getRequest().getParametergroup().add(new Parametergroup());
            }
            this.getRequest().getParametergroup().get(0).getParameter().add(p);
        } else {
            setRequestParameter(name, value);
        }
    }

    @Override
    public void setResponseParameter(String name, String value) {
        // this also updates existing parameters of same name!
        if (getResponseParameterByName(name) == null) {
            if (this.getResponse() == null) {
                this.setResponse(new Response());
            }
            Parameter p = new Parameter();
            p.setName(name);
            p.setValue(value == null ? "" : value);
            if (this.getResponse().getParametergroup().isEmpty()) {
                this.getResponse().getParametergroup().add(new Parametergroup());
            }
            this.getResponse().getParametergroup().get(0).getParameter().add(p);
        } else {
            setRequestParameter(name, value);
        }
    }

    public static Parameter createParameter(String name, String value) {
        Parameter p = new Parameter();
        p.setName(name);
        p.setValue(value);
        return p;
    }

    @Override
    public String getCommand() {
        if (request != null) {
            return request.getCommand();
        }
        return null;
    }
}
