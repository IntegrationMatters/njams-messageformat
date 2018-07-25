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
package com.faizsiegeln.njams.messageformat.v4.projectmessage;

/**
 * A Transition connects two {@link Activity} in a {@link ProcessModel}
 */
public class Transition {
    private String id;
    private String name;
    private String config;
    private String from;
    private String to;

    /**
     * Get the unique ID of the transition in scope of a {@link ProcessModel}.
     * 
     * @return the ID as String
     */
    public String getId() {
        return id;
    }

    /**
     * Set the unique ID of the transition in scope of a {@link ProcessModel}.
     * 
     * @param id
     *            to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get name of the Transition.
     * 
     * @return name as String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name of the Transition. Does not have to be unique.
     * 
     * @param name
     *            as String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get optional configuration of transition in monitored system
     * <p>
     * This might be a condition like: x=42
     * 
     * @return the config as String
     */
    public String getConfig() {
        return config;
    }

    /**
     * Set optional configuration of transition in monitored system
     * <p>
     * This might be a condition like: x=42
     * 
     * @param config
     *            as String
     */
    public void setConfig(String config) {
        this.config = config;
    }

    /**
     * Get the {@link Activity} ID of transition start.
     * 
     * @return the activityId as String
     */
    public String getFrom() {
        return from;
    }

    /**
     * Set the {@link Activity} ID of transition start.
     * 
     * @param from
     *            activityId as String
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Get the {@link Activity} ID of transition end.
     * 
     * @return the activityId as String
     */
    public String getTo() {
        return to;
    }

    /**
     * Set the {@link Activity} ID of transition start.
     * 
     * @param to
     *            activityId as String
     */
    public void setTo(String to) {
        this.to = to;
    }
}
