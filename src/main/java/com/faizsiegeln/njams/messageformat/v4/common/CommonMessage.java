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

import com.faizsiegeln.njams.messageformat.v4.logmessage.LogMessage;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.ProjectMessage;

/**
 * Base Message for nJAMS containing common fields of {@link LogMessage} and {@link ProjectMessage}
 */
public abstract class CommonMessage {

    /**
     * The version of the client; required
     */
    private String clientVersion;

    /**
     * The version of the SDK used by the client
     */
    private String sdkVersion;

    /**
     * The version of the runtime environment in which the client is deployed; example = Mule Server Runtime 4.2.2 EE
     */
    private String runtimeVersion;

    /**
     * Technology identifier, used to find technology icons: required
     */
    private String category;

    /**
     * Full path of the process (starting and ending with a greater-as sign); required
     */
    private String path;

    /**
     * Get the version of the client.
     * 
     * @return it as string
     */
    public String getClientVersion() {
        return clientVersion;
    }

    /**
     * Set the version of the client.
     * 
     * @param clientVersion
     *            as string
     */
    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    /**
     * Get the version of the SDK used by the client.
     * 
     * @return it as string
     */
    public String getSdkVersion() {
        return sdkVersion;
    }

    /**
     * Set the version of the SDK used by the client.
     * 
     * @param sdkVersion
     *            as string
     */
    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    /**
     * Get Technology identifier, used to find technology icons.
     * 
     * @return it as string
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set Technology identifier, used to find technology icons.
     * 
     * @param category
     *            as string
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the full path of the process (starting and ending with a greater-as sign)
     * 
     * @return the path as string
     */
    public String getPath() {
        return path;
    }

    /**
     * Set the full path of the process (starting and ending with a greater-as sign)
     * 
     * @param path
     *            as string
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the version of the runtime environment/engine from where the message has been produced
     *
     * @return the runtimeVersion as string
     */
    public String getRuntimeVersion() {
        return runtimeVersion;
    }

    /**
     * Set the ersion of the runtime environment/engine from where the message has been produced
     *
     * @param runtimeVersion as string
     */
    public void setRuntimeVersion(String runtimeVersion) {
        this.runtimeVersion = runtimeVersion;
    }
}
