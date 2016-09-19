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

The project has a set of unit tests. To get the maximum points all those tests must pass. Existing tests cannot be altered.

Requirements
----------

# Support both relative and absolute paths.
# Support directories recursively.
# Create missing parent directories automatically.
# Only pack files (no support for empty directories).
# Use DataInputSteam and DataOutputStream.
# Support big files that don’t fit into memory at once.
# Buffer data for better performance.
# Close all resources properly.

File Format of the Archive
----------

# Whole Archive = Archive Type + File Chunk(1) + File Chunk(2) + … + File Chunk(n)
# Archive Type = 42 (1 fixed byte)
# File Chunk = File Path + File Length + File Contents
# File Path – bytes of a String of a relative path in the archive separated by / characters (use readUTF()/writeUTF() methods)
# File Length – 8 bytes showing how many bytes does the File Contents take (big endian long)
# File Contents – actual file in the archive
