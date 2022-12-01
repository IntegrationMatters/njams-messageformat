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

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.faizsiegeln.njams.jaxb.IMAF.project package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@XmlRegistry
@Deprecated
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
     * com.faizsiegeln.njams.jaxb.IMAF.project
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Project }
     *
     */
    public Project createProject() {
        return new Project();
    }

    /**
     * Create an instance of {@link Extract }
     *
     */
    public Extract createExtract() {
        return new Extract();
    }

    /**
     * Create an instance of {@link GlobalVariables }
     *
     */
    public GlobalVariables createGlobalVariables() {
        return new GlobalVariables();
    }

    /**
     * Create an instance of {@link GlobalVariable }
     *
     */
    public GlobalVariable createGlobalVariable() {
        return new GlobalVariable();
    }

    /**
     * Create an instance of {@link Project.Resource }
     *
     */
    public Project.Resource createProjectResource() {
        return new Project.Resource();
    }

    /**
     * Create an instance of {@link Aspects }
     *
     */
    public Aspects createAspects() {
        return new Aspects();
    }

    /**
     * Create an instance of {@link Aspect }
     *
     */
    public Aspect createAspect() {
        return new Aspect();
    }

    /**
     * Create an instance of {@link Advices }
     *
     */
    public Advices createAdvices() {
        return new Advices();
    }

    /**
     * Create an instance of {@link Advice }
     *
     */
    public Advice createAdvice() {
        return new Advice();
    }

    /**
     * Create an instance of {@link Extracts }
     *
     */
    public Extracts createExtracts() {
        return new Extracts();
    }

    /**
     * Create an instance of {@link Extract.Extractionrules }
     *
     */
    public Extract.Extractionrules createExtractExtractionrules() {
        return new Extract.Extractionrules();
    }

    /**
     * Create an instance of {@link Tracing }
     *
     */
    public Tracing createTracing() {
        return new Tracing();
    }

    /**
     * Create an instance of {@link Tracepoint }
     *
     */
    public Tracepoint createTracepoint() {
        return new Tracepoint();
    }

    /**
     * Create an instance of {@link Loglevel }
     *
     */
    public Loglevel createLoglevel() {
        return new Loglevel();
    }

    /**
     * Create an instance of {@link Config }
     *
     */
    public Config createConfig() {
        return new Config();
    }

    /**
     * Create an instance of {@link Logging }
     *
     */
    public Logging createLogging() {
        return new Logging();
    }

    /**
     * Create an instance of {@link Exclude }
     *
     */
    public Exclude createExclude() {
        return new Exclude();
    }

    /**
     * Create an instance of {@link Include }
     *
     */
    public Include createInclude() {
        return new Include();
    }

    /**
     * Create an instance of {@link ExtractruleType }
     *
     */
    public ExtractruleType createExtractruleType() {
        return new ExtractruleType();
    }

}
