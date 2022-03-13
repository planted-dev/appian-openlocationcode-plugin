package dev.planted.appian.suite.plugin.openlocationcode;

import com.google.openlocationcode.OpenLocationCode.CodeArea;

import java.util.HashMap;
import java.util.Map;

import com.appiancorp.suiteapi.common.exceptions.AppianException;
import com.appiancorp.suiteapi.common.exceptions.ErrorCode;
import com.appiancorp.suiteapi.expression.annotations.AppianScriptingFunctionsCategory;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.type.AppianType;
import com.appiancorp.suiteapi.type.TypedValue;

/**
 * Functions for Open Location Code
 */
@AppianScriptingFunctionsCategory
public class OpenLocationCode {
  @Function
  public Boolean isValidPlusCode(@Parameter(required = true) String code) throws Exception {
    try {
      return com.google.openlocationcode.OpenLocationCode.isValidCode(code);
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }

  @Function
  Boolean isShortPlusCode(@Parameter(required = true) String code) throws Exception {
    try {
      return com.google.openlocationcode.OpenLocationCode.isShort(code);
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }

  @Function
  Boolean isFullPlusCode(@Parameter(required = true) String code) throws Exception {
    try {
      return com.google.openlocationcode.OpenLocationCode.isFull(code);
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }

  @Function Boolean isPaddedPlusCode(@Parameter(required = true) String code) throws Exception {
    try {
      return com.google.openlocationcode.OpenLocationCode.isPadded(code);
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }

  @Function String toPlusCode(@Parameter(required = true) double latitude,
    @Parameter(required = true) double longitude,
    @Parameter(required = false) Integer codeLength) throws Exception {
    try {
      if(codeLength == null) {
        return com.google.openlocationcode.OpenLocationCode.encode(latitude, longitude);
      } else {
        return com.google.openlocationcode.OpenLocationCode.encode(latitude, longitude, codeLength);
      }
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }

  @Function TypedValue fromPlusCode(@Parameter(required = true) String code) throws Exception {
    try {
      CodeArea ca = com.google.openlocationcode.OpenLocationCode.decode(code);
			Map<String, TypedValue> m = new HashMap<String, TypedValue>();

      m.put("latitude", new TypedValue((long) AppianType.DOUBLE, ca.getCenterLatitude()));
			m.put("longitude", new TypedValue((long) AppianType.DOUBLE, ca.getCenterLatitude()));

      TypedValue tv = new TypedValue((long) AppianType.MAP, m);

      return tv;
    } catch (Exception e) {
      throw new AppianException(ErrorCode.GENERIC_RUNTIME_ERROR, e.getMessage());
    }
  }
}
