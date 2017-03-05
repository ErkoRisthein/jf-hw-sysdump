package org.zeroturnaround.jf.sysdump;

import java.util.Map;

public final class InfoImpl implements Info {

  private final Map<String, String> systemEnvironment;
  private final Map<String, String> systemProperties;
  private final String systemVersion;

  public InfoImpl(Map<String, String> systemEnvironment, Map<String, String> systemProperties, String systemVersion) {
    this.systemEnvironment = systemEnvironment;
    this.systemProperties = systemProperties;
    this.systemVersion = systemVersion;
  }

  @Override
  public Map<String, String> getSystemEnvironment() {
    return systemEnvironment;
  }

  @Override
  public Map<String, String> getSystemProperties() {
    return systemProperties;
  }

  @Override
  public String getSystemVersion() {
    return systemVersion;
  }
}
