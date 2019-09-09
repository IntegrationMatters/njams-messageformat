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
package com.faizsiegeln.njams.messageformat.v4.command;

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

    @Test
    public void serializeAndParseLogLevelNull() throws NjamsFormatException {
        serializeAndParseLogLevel(null);
    }

    @Test
    public void serializeAndParseLogLevelInfo() throws NjamsFormatException {
        serializeAndParseLogLevel(LogLevel.INFO);
    }

    @Test
    public void serializeAndParseLogLevelSuccess() throws NjamsFormatException {
        serializeAndParseLogLevel(LogLevel.SUCCESS);
    }

    @Test
    public void serializeAndParseLogLevelWarning() throws NjamsFormatException {
        serializeAndParseLogLevel(LogLevel.WARNING);
    }

    @Test
    public void serializeAndParseLogLevelError() throws NjamsFormatException {
        serializeAndParseLogLevel(LogLevel.ERROR);
    }

    private void serializeAndParseLogLevel(LogLevel logLevelToCheck) throws NjamsFormatException {
        String serializedLogLevel = InstructionMapper.InstructionSerializer.serializeLogLevel(logLevelToCheck);
        LOG.debug(serializedLogLevel);
        LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(serializedLogLevel);
        assertEquals(logLevelToCheck, parsedLogLevel);
    }

    @Test
    public void serializeAndParseLogModeNull() throws NjamsFormatException {
        serializeAndParseLogMode(null);
    }

    @Test
    public void serializeAndParseLogModeNone() throws NjamsFormatException {
        serializeAndParseLogMode(LogMode.NONE);
    }

    @Test
    public void serializeAndParseLogModeExclusive() throws NjamsFormatException {
        serializeAndParseLogMode(LogMode.EXCLUSIVE);
    }

    @Test
    public void serializeAndParseLogModeComplete() throws NjamsFormatException {
        serializeAndParseLogMode(LogMode.COMPLETE);
    }

    private void serializeAndParseLogMode(LogMode logModeToCheck) throws NjamsFormatException {
        String serializedLogMode = InstructionMapper.InstructionSerializer.serializeLogMode(logModeToCheck);
        LOG.debug(serializedLogMode);
        LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(serializedLogMode);
        assertEquals(logModeToCheck, parsedLogMode);
    }

    @Test
    public void serializeAndParseLocalDateTimeNull() throws NjamsFormatException {
        serializeAndParseLocalDateTime(null);
    }

    @Test
    public void serializeAndParseLocalDateTimeNormal() throws NjamsFormatException {
        serializeAndParseLocalDateTime(LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    private void serializeAndParseLocalDateTime(LocalDateTime localDateTimeToCheck) throws NjamsFormatException {
        String serializedLocalDateTime = InstructionMapper.InstructionSerializer
                .serializeLocalDateTime(localDateTimeToCheck);
        LOG.debug(serializedLocalDateTime);
        LocalDateTime parsedLocalDateTime = InstructionMapper.InstructionParser
                .parseLocalDateTime(serializedLocalDateTime);
        assertEquals(localDateTimeToCheck, parsedLocalDateTime);
    }

    @Test
    public void serializeAndParseBooleanTrue() {
        serializeAndParseBoolean(true);
    }

    @Test
    public void serializeAndParseBooleanFalse() {
        serializeAndParseBoolean(false);
    }

    private void serializeAndParseBoolean(boolean booleanToCheck) {
        String serializedBoolean = InstructionMapper.InstructionSerializer.serializeBoolean(booleanToCheck);
        LOG.debug(serializedBoolean);
        boolean parsedBoolean = InstructionMapper.InstructionParser.parseBoolean(serializedBoolean);
        assertEquals(booleanToCheck, parsedBoolean);
    }

    @Test
    public void serializeAndParseInteger() throws NjamsFormatException {
        serializeAndParseInteger(1);
    }

    private void serializeAndParseInteger(int integerToCheck) throws NjamsFormatException {
        String serializeInteger = InstructionMapper.InstructionSerializer.serializeInteger(integerToCheck);
        LOG.debug(serializeInteger);
        int parsedInteger = InstructionMapper.InstructionParser.parseInteger(serializeInteger);
        assertEquals(integerToCheck, parsedInteger);
    }

//LogLevel parsing

    @Test(expected = NjamsFormatException.class)
    public void parseNullLogLevel() throws NjamsFormatException {
        parseLogLevelString(null, LogLevel.INFO);
    }

    private void parseLogLevelString(String logLevelAsString, LogLevel expected) throws NjamsFormatException {
        LOG.debug(logLevelAsString);
        LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(logLevelAsString);
        assertEquals(expected, parsedLogLevel);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseEmptyLogLevel() throws NjamsFormatException {
        parseLogLevelString("", LogLevel.INFO);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseNullAsStringLogLevel() throws NjamsFormatException {
        parseLogLevelString("null", LogLevel.INFO);
    }

    @Test
    public void parseInFoLogLevel() throws NjamsFormatException {
        parseLogLevelString("InFo", LogLevel.INFO);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseInvalidLogLevel() throws NjamsFormatException {
        parseLogLevelString("invalid", LogLevel.INFO);
    }

//LogMode parsing

    @Test(expected = NjamsFormatException.class)
    public void parseNullLogMode() throws NjamsFormatException {
        parseLogModeString(null, LogMode.NONE);
    }

    private void parseLogModeString(String logModeAsString, LogMode expected) throws NjamsFormatException {
        LOG.debug(logModeAsString);
        LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(logModeAsString);
        assertEquals(expected, parsedLogMode);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseEmptyLogMode() throws NjamsFormatException {
        parseLogModeString("", LogMode.NONE);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseNullAsStringLogMode() throws NjamsFormatException {
        parseLogModeString("null", LogMode.NONE);
    }

    @Test
    public void parseNoNeLogMode() throws NjamsFormatException {
        parseLogModeString("NoNe", LogMode.NONE);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseInvalidLogMode() throws NjamsFormatException {
        parseLogModeString("invalid", LogMode.NONE);
    }

//LocalDateTime parsing

    @Test
    public void parseNullLocalDateTime() throws NjamsFormatException {
        parseLocalDateTimeString(null, null);
    }

    private void parseLocalDateTimeString(String localDateTimeAsString, LocalDateTime expected)
            throws NjamsFormatException {
        LOG.debug(localDateTimeAsString);
        LocalDateTime parseLocalDateTime = InstructionMapper.InstructionParser
                .parseLocalDateTime(localDateTimeAsString);
        assertEquals(expected, parseLocalDateTime);
    }

    @Test
    public void parseEmptyLocalDateTime() throws NjamsFormatException {
        parseLocalDateTimeString("", null);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseNullAsStringLocalDateTime() throws NjamsFormatException {
        parseLocalDateTimeString("null", null);
    }

    @Test
    public void parseWhiteSpaceStringLocalDateTime() throws NjamsFormatException {
        parseLocalDateTimeString("   ", null);
    }

    @Test
    public void parseLocalDateTimeNormal() throws NjamsFormatException {
        parseLocalDateTimeString("2019-09-10T07:32:48.559", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    @Test
    public void parseLocalDateTimeWithAZAppended() throws NjamsFormatException {
        parseLocalDateTimeString("2019-09-10T07:32:48.559Z", LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000));
    }

    @Test(expected = NjamsFormatException.class)
    public void parseInvalidLocalDateTime() throws NjamsFormatException {
        parseLocalDateTimeString("invalid", null);
    }

//Boolean parsing

    @Test
    public void parseNullBoolean() throws NjamsFormatException {
        parseBooleanString(null, false);
    }

    private void parseBooleanString(String booleanAsString, boolean expected) throws NjamsFormatException {
        LOG.debug(booleanAsString);
        boolean parseBoolean = InstructionMapper.InstructionParser.parseBoolean(booleanAsString);
        assertEquals(expected, parseBoolean);
    }

    @Test
    public void parseEmptyBoolean() throws NjamsFormatException {
        parseBooleanString("", false);
    }

    @Test
    public void parseNullAsStringBoolean() throws NjamsFormatException {
        parseBooleanString("null", false);
    }

    @Test
    public void parseTrueBoolean() throws NjamsFormatException {
        parseBooleanString("true", true);
    }

    @Test
    public void parseFalseBoolean() throws NjamsFormatException {
        parseBooleanString("false", false);
    }

    @Test
    public void parseTrUeBoolean() throws NjamsFormatException {
        parseBooleanString("TrUe", true);
    }

    @Test
    public void parseFaLsEBoolean() throws NjamsFormatException {
        parseBooleanString("FaLsE", false);
    }

    @Test
    public void parseInvalidBoolean() throws NjamsFormatException {
        parseBooleanString("invalid", false);
    }

//Integer parsing

    @Test(expected = NjamsFormatException.class)
    public void parseNullInteger() throws NjamsFormatException {
        parseIntegerString(null, -1);
    }

    private void parseIntegerString(String IntegerAsString, int expected) throws NjamsFormatException {
        LOG.debug(IntegerAsString);
        int parseInteger = InstructionMapper.InstructionParser.parseInteger(IntegerAsString);
        assertEquals(expected, parseInteger);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseEmptyInteger() throws NjamsFormatException {
        parseIntegerString("", -1);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseNullAsStringInteger() throws NjamsFormatException {
        parseIntegerString("null", -1);
    }

    @Test
    public void parseNormalInteger() throws NjamsFormatException {
        parseIntegerString("1", 1);
    }

    @Test
    public void parseMinInteger() throws NjamsFormatException {
        parseIntegerString("-2147483648", Integer.MIN_VALUE);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseMinAsHexInteger() throws NjamsFormatException {
        parseIntegerString("0x80000000", Integer.MIN_VALUE);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseIntegerThatIsLowerThanMinValue() throws NjamsFormatException {
        parseIntegerString("-3000000000", -1);
    }

    @Test(expected = NjamsFormatException.class)
    public void parseInvalidInteger() throws NjamsFormatException {
        parseIntegerString("invalid", -1);
    }
}