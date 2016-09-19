Java Fundamentals - I/O Homework
===========

Description
----------

Your task is to write a Java program which packs and unpacks files without compression. Implement the following interface

```
public interface Packer {
  void pack(Path inputDir, Path outputArchive) throws IOException;
  void unpack(Path inputArchive, Path outputDir) throws IOException;
}
```

and also the factory class for obtaining an instance of it:

```
public class PackerFactory {
  public static Packer newPacker() {
    ...
  }
}
```
