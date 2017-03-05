package org.zeroturnaround.jf.sysdump;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@XmlRootElement(name="systemDump")
class XmlInfo {

  private Info info;

  XmlInfo(Info info) {
    this.info = info;
  }

  XmlInfo() {
  }

  @XmlElementWrapper
  @XmlElement(name="entry")
  public List<Entry> getSystemEnvironment() {
    return toEntryList(info.getSystemEnvironment());
  }

  @XmlElementWrapper
  @XmlElement(name="entry")
  public List<Entry> getSystemProperties() {
    return toEntryList(info.getSystemProperties());
  }

  @XmlElement
  public String getSystemVersion() {
    return info.getSystemVersion();
  }

  private List<Entry> toEntryList(Map<String, String> systemEnvironment) {
    return systemEnvironment.entrySet()
      .stream()
      .map(e -> new Entry(e.getKey(), e.getValue()))
      .collect(toList());
  }

  final static class Entry {
    @XmlAttribute
    final String key;
    @XmlValue
    final String value;

    Entry(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }

}
