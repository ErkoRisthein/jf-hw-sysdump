package ee.ut.jf2016.sysdump;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemDumpImpl implements SystemDump {

  private static final Logger log = LoggerFactory.getLogger(SystemDumpImpl.class);

  @Override
  public Info newInfo() throws Exception {
    // TODO
    throw new UnsupportedOperationException();
  }

  @Override
  public void writeXml(Info src, Path dest) throws Exception {
    // TODO
    throw new UnsupportedOperationException();
  }

  @Override
  public void writeJson(Info src, Path dest) throws Exception {
    // TODO
    throw new UnsupportedOperationException();
  }

}
