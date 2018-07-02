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
 * @param <S>
 */
public interface IExtract<S extends IExtractionrules> {

    /**
     * Gets the value of the activity property.
     *
     * @return possible object is {@link String }
     *
     */
    String getActivity();

    /**
     * Gets the value of the deployment property.
     *
     * @return possible object is {@link String }
     *
     */
    String getDeployment();

    /**
     * Gets the value of the domain property.
     *
     * @return possible object is {@link String }
     *
     */
    String getDomain();

    /**
     * Gets the value of the engine property.
     *
     * @return possible object is {@link String }
     *
     */
    String getEngine();

    /**
     * Gets the value of the extractionrules property.
     *
     * @return possible object is {@link Extract.Extractionrules }
     *
     */
    S getExtractionrules();

    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    String getName();

    /**
     * Gets the value of the process property.
     *
     * @return possible object is {@link String }
     *
     */
    String getProcess();

    /**
     * Sets the value of the activity property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setActivity(String value);

    /**
     * Sets the value of the deployment property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setDeployment(String value);

    /**
     * Sets the value of the domain property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setDomain(String value);

    /**
     * Sets the value of the engine property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setEngine(String value);

    /**
     * Sets the value of the extractionrules property.
     *
     * @param value
     *            allowed object is {@link Extract.Extractionrules }
     *
     */
    void setExtractionrules(S value);

    /**
     * Sets the value of the name property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setName(String value);

    /**
     * Sets the value of the process property.
     *
     * @param value
     *            allowed object is {@link String }
     *
     */
    void setProcess(String value);

    public S createExtractionrules();
}
