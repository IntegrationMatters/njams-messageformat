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

import java.util.List;

/**
 *
 * @author stkniep
 *
 * @deprecated Message format V3 has been removed in nJAMS server 5.2.0
 *
 */
@Deprecated
public interface IExtractionrules<T extends IExtractruleType> {

    /**
     * Gets the value of the extractrule property.
     *
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you
     * make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
     * method for the extractrule property.
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
    List<T> getExtractrule();

    public T createExtractruleType();
}
