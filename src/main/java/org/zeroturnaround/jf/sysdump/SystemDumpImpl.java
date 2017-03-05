package org.zeroturnaround.jf.sysdump;

import com.google.gson.Gson;
import org.apache.commons.lang3.SystemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.stream.slf4j.Slf4jStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeoutException;

import static java.nio.file.Files.newBufferedWriter;
import static java.util.stream.Collectors.toMap;

public class SystemDumpImpl implements SystemDump {

  private static final Logger log = LoggerFactory.getLogger(SystemDumpImpl.class);

  @Override
  public Info newInfo() throws Exception {
    return new InfoImpl(environment(), properties(), version());
  }

  private Map<String, String> environment() {
    return new TreeMap<>(System.getenv());
  }

  private Map<String, String> properties() {
    return new TreeMap<>(
      System.getProperties()
        .entrySet()
        .stream()
        .collect(toMap(this::stringKey, this::stringValue))
    );
  }

  private String stringValue(Entry<Object, Object> entry) {
    return (String) entry.getValue();
  }

  private String stringKey(Entry<Object, Object> entry) {
    return (String) entry.getKey();
  }

  private String version() throws IOException, InterruptedException, TimeoutException {
    ProcessExecutor processExecutor = new ProcessExecutor();

    if (SystemUtils.IS_OS_WINDOWS) {
      processExecutor = processExecutor.command("cmd", "/c", "ver");
    } else {
      processExecutor = processExecutor.command("uname", "-a");
    }

    return processExecutor
      .redirectOutput(Slf4jStream.of(getClass()).asInfo())
      .readOutput(true)
      .execute()
      .outputUTF8()
      .trim();
  }

  @Override
  public void writeXml(Info src, Path dest) throws Exception {
    marshaller().marshal(new XmlInfo(src), dest.toFile());
  }

  private Marshaller marshaller() throws JAXBException {
    Marshaller marshaller = JAXBContext.newInstance(XmlInfo.class).createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    return marshaller;
  }

  @Override
  public void writeJson(Info src, Path dest) throws Exception {
    try (Writer writer = newBufferedWriter(dest)) {
      new Gson().toJson(src, writer);
    }
  }
}
