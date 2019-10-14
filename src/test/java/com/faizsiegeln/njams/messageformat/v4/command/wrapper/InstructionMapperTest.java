/*
 * Copyright (c) 2019 Faiz & Siegeln Software GmbH
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * The Software shall be used for Good, not Evil.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 *  FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 */
package com.faizsiegeln.njams.messageformat.v4.command.wrapper;

import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogLevel;
import com.faizsiegeln.njams.messageformat.v4.projectmessage.LogMode;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class InstructionMapperTest {

    private static final Logger LOG = LoggerFactory.getLogger(InstructionMapperTest.class);

//x = parse(serialize(x))

    @Test(expected = NjamsMessageFormatException.class)
    public void serializeLogLevelNull() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(null);
    }

    @Test
    public void serializeAndParseLogLevelInfo() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.INFO);
    }

    @Test
    public void serializeAndParseLogLevelSuccess() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.SUCCESS);
    }

    @Test
    public void serializeAndParseLogLevelWarning() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.WARNING);
    }

    @Test
    public void serializeAndParseLogLevelError() throws NjamsMessageFormatException {
        serializeAndParseLogLevel(LogLevel.ERROR);
    }

    private void serializeAndParseLogLevel(LogLevel logLevelToCheck) throws NjamsMessageFormatException {
        String serializedLogLevel = InstructionMapper.InstructionSerializer.serializeLogLevel(logLevelToCheck);
        LOG.debug(serializedLogLevel);
        LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(serializedLogLevel);
        assertEquals(logLevelToCheck, parsedLogLevel);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void serializeLogModeNull() throws NjamsMessageFormatException {
        serializeAndParseLogMode(null);
    }

    @Test
    public void serializeAndParseLogModeNone() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.NONE);
    }

    @Test
    public void serializeAndParseLogModeExclusive() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.EXCLUSIVE);
    }

    @Test
    public void serializeAndParseLogModeComplete() throws NjamsMessageFormatException {
        serializeAndParseLogMode(LogMode.COMPLETE);
    }

    private void serializeAndParseLogMode(LogMode logModeToCheck) throws NjamsMessageFormatException {
        String serializedLogMode = InstructionMapper.InstructionSerializer.serializeLogMode(logModeToCheck);
        LOG.debug(serializedLogMode);
        LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(serializedLogMode);
        assertEquals(logModeToCheck, parsedLogMode);
    }

    @Test(expected = NjamsMessageFormatException.class)
    public void serializeLocalDateTimeNull() throws NjamsMessageFormatException {
        serializeAndParseLocalDateTime(null);
    }

    @Test
    public void serializeAndParseLocalDateTimeNormal() throws NjamsMessageFormatException {
        serializeAndParseLocalDateTime(LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    private void serializeAndParseLocalDateTime(LocalDateTime localDateTimeToCheck) throws NjamsMessageFormatException {
        String serializedLocalDateTime = InstructionMapper.InstructionSerializer
                .serializeLocalDateTime(localDateTimeToCheck);
        LOG.debug(serializedLocalDateTime);
        LocalDateTime parsedLocalDateTime = InstructionMapper.InstructionParser
                .parseLocalDateTime(serializedLocalDateTime);
        assertEquals(localDateTimeToCheck, parsedLocalDateTime);
    }

    @Test
    public void serializeAndParseBooleanTrue() throws NjamsMessageFormatException {
        serializeAndParseBoolean(true);
    }

    @Test
    public void serializeAndParseBooleanFalse() throws NjamsMessageFormatException {
        serializeAndParseBoolean(false);
    }

    private void serializeAndParseBoolean(boolean booleanToCheck) throws NjamsMessageFormatException {
        String serializedBoolean = InstructionMapper.InstructionSerializer.serializeBoolean(booleanToCheck);
        LOG.debug(serializedBoolean);
        boolean parsedBoolean = InstructionMapper.InstructionParser.parseBoolean(serializedBoolean);
        assertEquals(booleanToCheck, parsedBoolean);
    }

    @Test
    public void serializeAndParseInteger() throws NjamsMessageFormatException {
        serializeAndParseInteger(1);
    }

    private void serializeAndParseInteger(int integerToCheck) throws NjamsMessageFormatException {
        String serializeInteger = InstructionMapper.InstructionSerializer.serializeInteger(integerToCheck);
        LOG.debug(serializeInteger);
        int parsedInteger = InstructionMapper.InstructionParser.parseInteger(serializeInteger);
        assertEquals(integerToCheck, parsedInteger);
    }

//LogLevel parsing

    @Test
    public void parseNullLogLevel() {
        parseLogLevelString(null, null, NjamsMessageFormatException.class);
    }

    private void parseLogLevelString(String logLevelAsString, LogLevel expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logLevelAsString);
        try {
            LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(logLevelAsString);
            assertEquals(expected, parsedLogLevel);
        } catch (NjamsMessageFormatException e) {
            assertEquals(e.getClass(), exceptionThatIsThrown);
        }
    }

    @Test
    public void parseEmptyLogLevel() {
        parseLogLevelString("", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNullAsStringLogLevel() {
        parseLogLevelString("null", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseInFoLogLevel() {
        parseLogLevelString("InFo", LogLevel.INFO, null);
    }

    @Test
    public void parseInvalidLogLevel() {
        parseLogLevelString("invalid", null, NjamsMessageFormatException.class);
    }

//LogMode parsing

    @Test
    public void parseNullLogMode() {
        parseLogModeString(null, null, NjamsMessageFormatException.class);
    }

    private void parseLogModeString(String logModeAsString, LogMode expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logModeAsString);
        try {
            LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(logModeAsString);
            assertEquals(expected, parsedLogMode);
        } catch (NjamsMessageFormatException e) {
            assertEquals(e.getClass(), exceptionThatIsThrown);
        }
    }

    @Test
    public void parseEmptyLogMode() {
        parseLogModeString("", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNullAsStringLogMode() {
        parseLogModeString("null", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNoNeLogMode() {
        parseLogModeString("NoNe", LogMode.NONE, null);
    }

    @Test
    public void parseInvalidLogMode() {
        parseLogModeString("invalid", null, NjamsMessageFormatException.class);
    }

//LocalDateTime parsing

    @Test
    public void parseNullLocalDateTime() {
        parseLocalDateTimeString(null, null, NjamsMessageFormatException.class);
    }

    private void parseLocalDateTimeString(String localDateTimeAsString, LocalDateTime expected, Class<?
            extends Exception> exceptionThatIsThrown) {
        LOG.debug(localDateTimeAsString);
        try {
            LocalDateTime parseLocalDateTime = InstructionMapper.InstructionParser
                    .parseLocalDateTime(localDateTimeAsString);
            assertEquals(expected, parseLocalDateTime);
        } catch (NjamsMessageFormatException e) {
            assertEquals(e.getClass(), exceptionThatIsThrown);
        }
    }

    @Test
    public void parseEmptyLocalDateTime() {
        parseLocalDateTimeString("", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNullAsStringLocalDateTime() {
        parseLocalDateTimeString("null", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseWhiteSpaceStringLocalDateTime() {
        parseLocalDateTimeString("   ", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseLocalDateTimeNormal() {
        parseLocalDateTimeString("2019-09-10T07:32:48.559", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000), null);
    }

    @Test
    public void parseLocalDateTimeWithAZAppended() {
        parseLocalDateTimeString("2019-09-10T07:32:48.559Z", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000), null);
    }

    @Test
    public void parseInvalidLocalDateTime() {
        parseLocalDateTimeString("invalid", null, NjamsMessageFormatException.class);
    }

//Boolean parsing

    @Test
    public void parseNullBoolean() {
        parseBooleanString(null, null, NjamsMessageFormatException.class);
    }

    private void parseBooleanString(String booleanAsString, Boolean expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(booleanAsString);
        try {
            boolean parseBoolean = InstructionMapper.InstructionParser.parseBoolean(booleanAsString);
            assertEquals(expected, parseBoolean);
        } catch (NjamsMessageFormatException e) {
            assertEquals(e.getClass(), exceptionThatIsThrown);
        }
    }

    @Test
    public void parseEmptyBoolean() {
        parseBooleanString("", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNullAsStringBoolean() {
        parseBooleanString("null", null, NjamsMessageFormatException.class);
    }

    @Test
    public void parseTrueBoolean() {
        parseBooleanString("true", true, null);
    }

    @Test
    public void parseFalseBoolean() {
        parseBooleanString("false", false, null);
    }

    @Test
    public void parseTrUeBoolean() {
        parseBooleanString("TrUe", true, null);
    }

    @Test
    public void parseFaLsEBoolean() {
        parseBooleanString("FaLsE", false, null);
    }

    @Test
    public void parseInvalidBoolean() {
        parseBooleanString("invalid", null, NjamsMessageFormatException.class);
    }

//Integer parsing

    @Test
    public void parseNullInteger() {
        parseIntegerString(null, -1, NjamsMessageFormatException.class);
    }

    private void parseIntegerString(String IntegerAsString, int expected, Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(IntegerAsString);
        try {
            int parseInteger = InstructionMapper.InstructionParser.parseInteger(IntegerAsString);
            assertEquals(expected, parseInteger);
        } catch (NjamsMessageFormatException e) {
            assertEquals(e.getClass(), exceptionThatIsThrown);
        }
    }

    @Test
    public void parseEmptyInteger() {
        parseIntegerString("", -1, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNullAsStringInteger() {
        parseIntegerString("null", -1, NjamsMessageFormatException.class);
    }

    @Test
    public void parseNormalInteger() {
        parseIntegerString("1", 1, null);
    }

    @Test
    public void parseMinInteger() {
        parseIntegerString("-2147483648", Integer.MIN_VALUE, null);
    }

    @Test
    public void parseMinAsHexInteger() {
        parseIntegerString("0x80000000", -1, NjamsMessageFormatException.class);
    }

    @Test
    public void parseIntegerThatIsLowerThanMinValue() {
        parseIntegerString("-3000000000", -1, NjamsMessageFormatException.class);
    }

    @Test
    public void parseInvalidInteger() {
        parseIntegerString("invalid", -1, NjamsMessageFormatException.class);
    }
}