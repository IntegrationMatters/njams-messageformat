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
package com.faizsiegeln.njams.messageformat.v4.common;

import java.io.Serializable;

/**
 * Representation of a call to a subprocess.
 * <p>
 * If the subprocess is inline, name and path are mandatory.
 * <p>
 * If the subprocess is spawned, the logId is mandatory.
 */
public class SubProcess implements Serializable {

    private static final long serialVersionUID = 6365591352276117846L;
    /**
     * Name of the subprocess if it is an inline subprocess
     */
    private String name;

    /**
     * Path of the subprocess if it is an inline subprocess. This attribute is deprecated. Please use new property subProcessPath.
     */
    @Deprecated
    private String path;

    /**
     * Path of the subprocess if it is an inline subprocess
     */
    private String subProcessPath;

    /**
     * LogID of the subprocess if the subprocess is a spawned subprocess
     */
    private String logId;

    /**
     * Needed for JSON serialization
     */
    public SubProcess() {
    }

    /**
     * Constructor of a subprocess call.
     *
     * @param name
     *            mandatory if process is inline
     * @param subProcessPath
     *            mandatory if process is inline
     * @param logId
     *            mandatory if is spawned
     */
    public SubProcess(String name, String subProcessPath, String logId) {
        this.name = name;
        this.subProcessPath = subProcessPath;
        this.logId = logId;
    }


    /**
     * Get the name of the called subprocess
     * 
     * @return the name as string
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the called subprocess
     * 
     * @param name
     *            the name as string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the path of the called subprocess
     * 
     * @return the path as string
     */
    @Deprecated
    public String getPath() {
        return path;
    }

    /**
     * Set the path of the called subprocess
     * 
     * @param path
     *            the path as string
     */
    @Deprecated
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the path of the called subprocess
     *
     * @return the path as string
     */
    public String getSubProcessPath() {
        return subProcessPath;
    }

    /**
     * Set the path of the called subprocess
     *
     * @param subProcessPath
     *            the path as string
     */
    public void setSubProcessPath(String subProcessPath) {
        this.subProcessPath = subProcessPath;
    }

    /**
     * If subprocess is spawned gets the logId of the subprocess
     * 
     * @return the logId as string
     */
    public String getLogId() {
        return logId;
    }

    /**
     * If subprocess is spawned set the logId of the subprocess
     * 
     * @param logId
     *            of the spawned subprocess
     */
    public void setLogId(String logId) {
        this.logId = logId;
    }

}
