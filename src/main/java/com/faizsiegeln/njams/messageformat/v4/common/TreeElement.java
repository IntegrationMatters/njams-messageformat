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
 * Defines an Element in nJAMS Object Tree.
 * 
 * Used in {@link com.faizsiegeln.njams.messageformat.v4.projectmessage.ProjectMessage}
 */
public class TreeElement implements Serializable {

    private static final long serialVersionUID = 8332639142404796183L;

    private String path;

    private String name;

    private String type;

    private TreeElementType treeElementType;

    private Boolean starter;

    public TreeElement() {
        // default Constructor
    }

    /**
     * Create a TreeElement
     * 
     * @param path
     *            the path in the tree including the name
     * @param name
     *            the name of the tree element
     * @param type
     *            the type is needed for icons
     * @param treeElementType
     *            set if element is a special type as CLIENT or PROCESS
     */
    public TreeElement(String path, String name, String type, TreeElementType treeElementType) {
        this.path = path;
        this.name = name;
        this.type = type;
        this.treeElementType = treeElementType;
    }

    /**
     * Get the path of the tree element including the name
     * 
     * @return the path as string
     */
    public String getPath() {
        return path;
    }

    /**
     * Get the path of the tree element including the name
     * 
     * @param path
     *            the path as string
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get the name of the tree element (last path element)
     * 
     * @return the name as string
     */
    public String getName() {
        return name;
    }

    /**
     * Get the name of the tree element (last path element)
     * 
     * @param name
     *            the name as string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the type of the element. Used to find an icon for it.
     * 
     * @return the type as string
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of the element. Used to find an icon for it.
     * 
     * @param type
     *            the type as string
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the {@link TreeElementType} of the element.
     * 
     * @return it as {@link TreeElementType}
     */
    public TreeElementType getTreeElementType() {
        return treeElementType;
    }

    /**
     * Set the {@link TreeElementType} of the element.
     * 
     * @param treeElementType
     *            {@link TreeElementType}
     */
    public void setTreeElementType(TreeElementType treeElementType) {
        this.treeElementType = treeElementType;
    }

    /**
     * Gets info if tree element is a process starter.
     * 
     * @return the info as a Boolean
     */
    public Boolean getStarter() {
        return starter;
    }

    /**
     * Sets info if tree element is a process starter.
     * 
     * @param starter
     *            the info as a Boolean
     */
    public void setStarter(Boolean starter) {
        this.starter = starter;
    }
}
