package ee.ut.jf2016.packer;

import java.io.IOException;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PackerImpl implements Packer {

  private static final Logger log = LoggerFactory.getLogger(PackerImpl.class);

  @Override
  public void pack(Path inputDir, Path outputArchive) throws IOException {
    log.info("Packing {} into {}", inputDir, outputArchive);
    // TODO
  }

  @Override
  public void unpack(Path inputArchive, Path outputDir) throws IOException {
    log.info("Unpacking {} into {}", inputArchive, outputDir);
    // TODO
  }

}
