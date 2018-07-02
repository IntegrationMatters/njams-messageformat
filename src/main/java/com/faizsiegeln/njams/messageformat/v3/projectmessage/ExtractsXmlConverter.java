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

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.slf4j.LoggerFactory;

/*
 *
 * NOte: This class is shared between njams server and clientLib
 *
 */
/**
 * Class copied from old server
 *
 * @author pnientiedt
 */
public class ExtractsXmlConverter {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(ExtractsXmlConverter.class);
    private static JAXBContext contextExtracts = null;
    private static JAXBContext contextExtract = null;
    private static JAXBContext contextExtract2 = null;

    static {
        try {
            contextExtracts = JAXBContext.newInstance(Extracts.class);
            contextExtract = JAXBContext.newInstance(Extract.class);
            contextExtract2
                    = JAXBContext.newInstance(com.faizsiegeln.njams.messageformat.v3.projectmessageNewNamespace.Extract.class);
        } catch (JAXBException e) {
            LOG.error("error while initializing JAXB", e);
        }
    }

    private ExtractsXmlConverter() {
        // Utility class
    }

    public static String createXml(final Extracts extracts) throws JAXBException {
        Marshaller marshaller = contextExtracts.createMarshaller();
        StringWriter stringWriter = null;
        try {
            stringWriter = new StringWriter();
            marshaller.marshal(extracts, stringWriter);
            return stringWriter.toString();
        } finally {
            if (stringWriter != null) {
                try {
                    stringWriter.close();
                } catch (IOException e) {
                    LOG.trace("Unable to close StrintWriter", e);
                }
            }
        }
    }

    public static void createToFile(Extracts extracts, File extractsFile) {
        Marshaller marshaller;
        FileWriter fileWriter = null;
        try {
            marshaller = contextExtracts.createMarshaller();
            fileWriter = new FileWriter(extractsFile);

            marshaller.marshal(extracts, fileWriter);
        } catch (Exception e) {
            LOG.error("Error creating file from extracts", e);
            throw new RuntimeException("Error creating file from extracts", e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    LOG.error("Error closing file writer", e);
                }
            }
        }
    }

    public static Extracts getFromXmlExtracts(final String str) throws JAXBException {
        try (final StringReader strReader = new StringReader(str)) {
            return (Extracts) contextExtracts.createUnmarshaller().unmarshal(strReader);
        }
    }

    public static Extracts getFromFileExtracts(File extractsFile) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(extractsFile);
            return (Extracts) contextExtracts.createUnmarshaller().unmarshal(fileReader);
        } catch (Exception e) {
            LOG.error("Error getting extracts from file", e);
            throw new RuntimeException("Error getting extracts from file", e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    LOG.error("error closing file reader", e);
                }
            }
        }
    }

    public static String createXml(final IExtract extract, final String clientVersion, final String sdkVersion) throws JAXBException {
        final Marshaller marshaller;
        if (sdkVersion != null) {
            LOG.debug("Create extract marshaller with new namespace because sdkVersion is {}", sdkVersion);
            marshaller = contextExtract2.createMarshaller();
        } else if (clientVersion != null && clientVersion.compareTo("3.1.0") >= 0) {
            LOG.debug("Create extract marshaller with new namespace because clientVersion is {} and sdkVersion is {}", clientVersion, sdkVersion);
            marshaller = contextExtract2.createMarshaller();
        } else {
            LOG.debug("Create extract marshaller with old namespace because clientVersion is {} and sdkVersion is {}", clientVersion, sdkVersion);
            marshaller = contextExtract.createMarshaller();
        }
        StringWriter stringWriter = new StringWriter();

        marshaller.marshal(extract, stringWriter);
        return stringWriter.toString();
    }

    public static Extract getFromXmlExtract(String str) throws JAXBException {
        return (Extract) contextExtract.createUnmarshaller().unmarshal(new StringReader(str));
    }

    public static void removeExtract(Extracts extracts, String process, String activity) {
        Iterator<Extract> iter = extracts.getExtract().iterator();

        while (iter.hasNext()) {
            Extract cur = iter.next();
            if (cur.getProcess().equals(process) && cur.getActivity().equals(activity)) {
                iter.remove();
                break;
            }
        }
    }

    public static Extract findExtract(Extracts extracts, String process, String activity) {
        Iterator<Extract> iter = extracts.getExtract().iterator();

        while (iter.hasNext()) {
            Extract cur = iter.next();
            if (cur.getProcess().equals(process) && cur.getActivity().equals(activity)) {
                return cur;
            }
        }
        return null;
    }

    public static void replaceOrAddExtract(Extracts extracts, Extract extract) {
        Iterator<Extract> iter = extracts.getExtract().iterator();
        int index = -1;
        boolean extractSet = false;
        while (iter.hasNext()) {
            index++;
            Extract cur = iter.next();
            if (cur.getProcess().equals(extract.getProcess()) && cur.getActivity().equals(extract.getActivity())) {
                extracts.getExtract().set(index, extract);
                extractSet = true;
            }
        }
        if (!extractSet) {
            extracts.getExtract().add(extract);
        }
    }

}
