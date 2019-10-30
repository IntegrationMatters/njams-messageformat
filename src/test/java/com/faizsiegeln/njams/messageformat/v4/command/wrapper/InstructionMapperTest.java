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

import javax.validation.constraints.Null;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class InstructionMapperTest {

    private static final Logger LOG = LoggerFactory.getLogger(InstructionMapperTest.class);

//LogLevel serializing

    @Test
    public void serializeLogLevelNull() {
        serializeLogLevel(null, null, NullPointerException.class);
    }

    @Test
    public void serializeLogLevelInfo() {
        serializeLogLevel(LogLevel.INFO, "INFO", null);
    }

    @Test
    public void serializeLogLevelSuccess() {
        serializeLogLevel(LogLevel.SUCCESS, "SUCCESS", null);
    }

    @Test
    public void serializeLogLevelWarning() {
        serializeLogLevel(LogLevel.WARNING, "WARNING", null);
    }

    @Test
    public void serializeLogLevelError() {
        serializeLogLevel(LogLevel.ERROR, "ERROR", null);
    }

    private void serializeLogLevel(LogLevel logLevelToCheck, String logLevelSerialized,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logLevelSerialized);
        try {
            String serializedLogLevel = InstructionMapper.InstructionSerializer.serializeLogLevel(logLevelToCheck);
            assertEquals(logLevelSerialized, serializedLogLevel);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//LogMode serializing

    @Test
    public void serializeLogModeNull() {
        serializeLogMode(null, null, NullPointerException.class);
    }

    @Test
    public void serializeLogModeNone() {
        serializeLogMode(LogMode.NONE, "NONE", null);
    }

    @Test
    public void serializeLogModeExclusive() {
        serializeLogMode(LogMode.EXCLUSIVE, "EXCLUSIVE", null);
    }

    @Test
    public void serializLogModeComplete() {
        serializeLogMode(LogMode.COMPLETE, "COMPLETE", null);
    }

    private void serializeLogMode(LogMode logModeToCheck, String logModeSerialized,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logModeSerialized);
        try {
            String serializedLogMode = InstructionMapper.InstructionSerializer.serializeLogMode(logModeToCheck);
            assertEquals(logModeSerialized, serializedLogMode);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//LocalDateTime serializing

    @Test
    public void serializeLocalDateTimeNull() {
        serializeLocalDateTime(null, null, NullPointerException.class);
    }

    @Test
    public void serializeLocalDateTimeNormal() {
        serializeLocalDateTime(LocalDateTime.of(2019, 9, 10, 7, 32, 48, 559000000), "2019-09-10T07:32:48.559", null);
    }

    private void serializeLocalDateTime(LocalDateTime localDateTimeToCheck, String localDateTimeSerizalized, Class<?
            extends Exception> exceptionThatIsThrown) {
        LOG.debug(localDateTimeSerizalized);
        try {
            String serializedLocalDateTime = InstructionMapper.InstructionSerializer
                    .serializeLocalDateTime(localDateTimeToCheck);
            assertEquals(localDateTimeSerizalized, serializedLocalDateTime);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//Boolean serializing

    @Test
    public void serializeBooleanTrue() {
        serializeBoolean(true, "true");
    }

    @Test
    public void serializeBooleanFalse() {
        serializeBoolean(false, "false");
    }

    private void serializeBoolean(boolean booleanToCheck, String booleanSerialized) {
        LOG.debug(booleanSerialized);
        String serializedBoolean = InstructionMapper.InstructionSerializer.serializeBoolean(booleanToCheck);
        assertEquals(booleanSerialized, serializedBoolean);
    }

//Integer serializing

    @Test
    public void serializeInteger() {
        serializeInteger(1, "1");
    }

    private void serializeInteger(int integerToCheck, String integerSerialized) {
        LOG.debug(integerSerialized);
        String serializeInteger = InstructionMapper.InstructionSerializer.serializeInteger(integerToCheck);
        assertEquals(integerSerialized, serializeInteger);
    }

//LogLevel parsing

    @Test
    public void parseNullLogLevel() {
        parseLogLevelString(null, null, NullPointerException.class);
    }

    @Test
    public void parseEmptyLogLevel() {
        parseLogLevelString("", null, InstructionParsingException.class);
    }

    @Test
    public void parseNullAsStringLogLevel() {
        parseLogLevelString("null", null, InstructionParsingException.class);
    }

    @Test
    public void parseInfoAsStringLogLevel() {
        parseLogLevelString("INFO", LogLevel.INFO, null);
    }

    @Test
    public void parseSuccessAsStringLogLevel() {
        parseLogLevelString("SUCCESS", LogLevel.SUCCESS, null);
    }

    @Test
    public void parseWarningAsStringLogLevel() {
        parseLogLevelString("WARNING", LogLevel.WARNING, null);
    }

    @Test
    public void parseErrorAsStringLogLevel() {
        parseLogLevelString("ERROR", LogLevel.ERROR, null);
    }

    @Test
    public void parseInFoLogLevel() {
        parseLogLevelString("InFo", LogLevel.INFO, null);
    }

    @Test
    public void parseInvalidLogLevel() {
        parseLogLevelString("invalid", null, InstructionParsingException.class);
    }

    private void parseLogLevelString(String logLevelAsString, LogLevel expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logLevelAsString);
        try {
            LogLevel parsedLogLevel = InstructionMapper.InstructionParser.parseLogLevel(logLevelAsString);
            assertEquals(expected, parsedLogLevel);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//LogMode parsing

    @Test
    public void parseNullLogMode() {
        parseLogModeString(null, null, NullPointerException.class);
    }

    @Test
    public void parseEmptyLogMode() {
        parseLogModeString("", null, InstructionParsingException.class);
    }

    @Test
    public void parseNullAsStringLogMode() {
        parseLogModeString("null", null, InstructionParsingException.class);
    }

    @Test
    public void parseNoneAsStringLogMode() {
        parseLogModeString("NONE", LogMode.NONE, null);
    }

    @Test
    public void parseExclusiveAsStringLogMode() {
        parseLogModeString("EXCLUSIVE", LogMode.EXCLUSIVE, null);
    }

    @Test
    public void parseCompleteAsStringLogMode() {
        parseLogModeString("COMPLETE", LogMode.COMPLETE, null);
    }

    @Test
    public void parseNoNeLogMode() {
        parseLogModeString("NoNe", LogMode.NONE, null);
    }

    @Test
    public void parseInvalidLogMode() {
        parseLogModeString("invalid", null, InstructionParsingException.class);
    }

    private void parseLogModeString(String logModeAsString, LogMode expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(logModeAsString);
        try {
            LogMode parsedLogMode = InstructionMapper.InstructionParser.parseLogMode(logModeAsString);
            assertEquals(expected, parsedLogMode);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//LocalDateTime parsing

    @Test
    public void parseNullLocalDateTime() {
        parseLocalDateTimeString(null, null, NullPointerException.class);
    }

    @Test
    public void parseEmptyLocalDateTime() {
        parseLocalDateTimeString("", null, InstructionParsingException.class);
    }

    @Test
    public void parseNullAsStringLocalDateTime() {
        parseLocalDateTimeString("null", null, InstructionParsingException.class);
    }

    @Test
    public void parseWhiteSpaceStringLocalDateTime() {
        parseLocalDateTimeString("   ", null, InstructionParsingException.class);
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
        parseLocalDateTimeString("invalid", null, InstructionParsingException.class);
    }

    private void parseLocalDateTimeString(String localDateTimeAsString, LocalDateTime expected, Class<?
            extends Exception> exceptionThatIsThrown) {
        LOG.debug(localDateTimeAsString);
        try {
            LocalDateTime parseLocalDateTime = InstructionMapper.InstructionParser
                    .parseLocalDateTime(localDateTimeAsString);
            assertEquals(expected, parseLocalDateTime);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//Boolean parsing

    @Test
    public void parseNullBoolean() {
        parseBooleanString(null, null, NullPointerException.class);
    }

    @Test
    public void parseEmptyBoolean() {
        parseBooleanString("", null, InstructionParsingException.class);
    }

    @Test
    public void parseNullAsStringBoolean() {
        parseBooleanString("null", null, InstructionParsingException.class);
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
        parseBooleanString("invalid", null, InstructionParsingException.class);
    }

    private void parseBooleanString(String booleanAsString, Boolean expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(booleanAsString);
        try {
            boolean parseBoolean = InstructionMapper.InstructionParser.parseBoolean(booleanAsString);
            assertEquals(expected, parseBoolean);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }

//Integer parsing

    @Test
    public void parseNullInteger() {
        parseIntegerString(null, -1, NullPointerException.class);
    }

    @Test
    public void parseEmptyInteger() {
        parseIntegerString("", -1, InstructionParsingException.class);
    }

    @Test
    public void parseNullAsStringInteger() {
        parseIntegerString("null", -1, InstructionParsingException.class);
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
        parseIntegerString("0x80000000", -1, InstructionParsingException.class);
    }

    @Test
    public void parseIntegerThatIsLowerThanMinValue() {
        parseIntegerString("-3000000000", -1, InstructionParsingException.class);
    }

    @Test
    public void parseInvalidInteger() {
        parseIntegerString("invalid", -1, InstructionParsingException.class);
    }

    private void parseIntegerString(String IntegerAsString, int expected,
            Class<? extends Exception> exceptionThatIsThrown) {
        LOG.debug(IntegerAsString);
        try {
            int parseInteger = InstructionMapper.InstructionParser.parseInteger(IntegerAsString);
            assertEquals(expected, parseInteger);
        } catch (Exception e) {
            assertEquals(exceptionThatIsThrown, e.getClass());
        }
    }
}