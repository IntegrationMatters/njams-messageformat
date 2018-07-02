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
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
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

/**
 * This class extends {@link InstructionExt} by functionality for storing string arrays (lists respectively) as
 * parameter values.<br>
 * This extension provides methods for setting and getting according arrays or lists, and for removing them from the
 * underlying instruction.<br>
 * All methods exits for both message parts, request and response.
 *
 * @author cwinkler
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Instruction")
public class InstructionArrayExt extends InstructionExt {

    private static final Logger LOG = LoggerFactory.getLogger(InstructionArrayExt.class);

    // Used to mark array parameter keys so that the common parameter accessors
    // will not accidently return array values.
    private static final String ARRAY_MARKER = "$[ARRAY]$.";

    public InstructionArrayExt() {
        super();
    }

    public static InstructionArrayExt createInstructionExt(String in) {
        if (!in.startsWith("<?xml")) {
            return null;
        }
        try {
            JAXBContext context = JAXBContext.newInstance(InstructionExt.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            // JAXB changed its constant FACTORY in one of the releases. Let's
            // make sure we cover that!
            try {
                unmarshaller.setProperty("com.sun.xml.internal.bind.ObjectFactory", new ObjectFactory());
            } catch (PropertyException e) {
                unmarshaller.setProperty("com.sun.xml.bind.ObjectFactory", new ObjectFactory());
            }
            return (InstructionArrayExt) unmarshaller.unmarshal(new StringReader(in));
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

    /**
     * @deprecated Use {@link #toXml()} instead. Superclasses implement {@link #toString()} for serializing
     *             {@link Instruction}s to XML.<br>
     *             TODO: This should be reverted to 'normal' behavior.
     */
    @Override
    @Deprecated
    public String toString() {
        return toXml();
    }

    public void setRequestParameterArray(String key, String[] values) {
        if (values == null) {
            removeResponseParameterArray(key);
            return;
        }

        setParameterArray(true, key, values);
    }

    public void setResponseParameterArray(String key, String[] values) {
        if (values == null) {
            removeResponseParameterArray(key);
            return;
        }

        setParameterArray(false, key, values);
    }

    public void setRequestParameterList(String key, Collection<String> values) {
        if (values == null) {
            removeResponseParameterArray(key);
            return;
        }
        setParameterArray(true, key, values.toArray(new String[values.size()]));
    }

    public void setResponseParameterList(String key, Collection<String> values) {
        if (values == null) {
            removeResponseParameterArray(key);
            return;
        }
        setParameterArray(false, key, values.toArray(new String[values.size()]));
    }

    public List<String> getRequestParameterList(String key) {
        return getParameterListValues(true, key);
    }

    public String[] getRequestParameterArray(String key) {
        List<String> l = getParameterListValues(true, key);
        if (l == null) {
            return null;
        }
        return l.toArray(new String[0]);
    }

    public List<String> getResponseParameterList(String key) {
        return getParameterListValues(false, key);
    }

    public String[] getResponseParameterArray(String key) {
        List<String> l = getParameterListValues(false, key);
        if (l == null) {
            return null;
        }
        return l.toArray(new String[0]);
    }

    private List<String> getParameterListValues(boolean request, String key) {
        if (key == null) {
            return null;
        }

        List<Parametergroup> groups;
        if (request) {
            Request r = getRequest();
            if (r == null) {
                return null;
            }
            groups = r.getParametergroup();
        } else {
            Response r = getResponse();
            if (r == null) {
                return null;
            }
            groups = r.getParametergroup();
        }

        key = ARRAY_MARKER + key;
        ArrayList<String> list = new ArrayList<String>();
        for (Parametergroup g : groups) {
            List<Parameter> params = g.getParameter();
            if (params == null) {
                continue;
            }
            for (Parameter p : params) {
                if (p.getName().equals(key)) {
                    list.add(p.getValue());
                }
            }
        }
        return list.isEmpty() ? null : list;
    }

    private void setParameterArray(boolean request, String key, String[] values) {
        if (key == null) {
            throw new NullPointerException();
        }
        List<Parameter> params;
        if (request) {
            removeRequestParameterArray(key);
            params = createRequestParameters();
        } else {
            removeResponseParameterArray(key);
            params = createResponseParameters();
        }
        if (values == null) {
            return;
        }

        key = ARRAY_MARKER + key;
        for (String s : values) {
            Parameter p = new Parameter();
            p.setName(key);
            p.setValue(s);
            params.add(p);
        }
    }

    private List<Parameter> createRequestParameters() {
        Request r = getRequest();
        if (r == null) {
            r = new Request();
            setRequest(r);
        }
        Parametergroup g;
        if (r.getParametergroup().isEmpty()) {
            g = new Parametergroup();
            r.getParametergroup().add(g);
        } else {
            g = r.getParametergroup().get(0);
        }
        return g.getParameter();
    }

    private List<Parameter> createResponseParameters() {
        Response r = getResponse();
        if (r == null) {
            r = new Response();
            setResponse(r);
        }
        Parametergroup g;
        if (r.getParametergroup().isEmpty()) {
            g = new Parametergroup();
            r.getParametergroup().add(g);
        } else {
            g = r.getParametergroup().get(0);
        }
        return g.getParameter();
    }

    public void removeRequestParameterArray(String key) {
        removeParameterArray(true, key);
    }

    public void removeResponseParameterArray(String key) {
        removeParameterArray(false, key);
    }

    private void removeParameterArray(boolean request, String key) {
        List<Parameter> params = request ? createRequestParameters() : createResponseParameters();

        key = ARRAY_MARKER + key;
        List<Parameter> toRemove = new ArrayList<Parameter>();
        for (Parameter p : params) {
            if (p.getName().equals(key)) {
                toRemove.add(p);
            }
        }
        params.removeAll(toRemove);
    }
}