import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class Ex05 {
    public static void main(String[] args) {
        if (args.length < 1 || args.length > 2) {
            System.out.println("ERROR: Invalid number of arguments!");
            System.exit(0);
        }

        final boolean recursive = args.length == 2;

        String directory = recursive ? args[1] : args[0];
        Path path = Paths.get(directory);
        AtomicLong size = new AtomicLong(0);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {

                    if (recursive) {
                        if (Files.isDirectory(file)) {

                            System.out.printf("Directory -> %s: %d bytes\n", file, attr.size());
                        } else {

                            System.out.printf("File -> %s: %d bytes\n", file, attr.size());
                        }

                        size.addAndGet(attr.size());
                        return FileVisitResult.CONTINUE;

                    } else {

                        if (Files.isRegularFile(file)) {

                            System.out.printf("File -> %s: %d bytes\n", file, attr.size());
                            size.addAndGet(attr.size());
                            return FileVisitResult.CONTINUE;

                        }
                    }

                    System.out.println("Total: " + size + " bytes");
                    return FileVisitResult.SKIP_SUBTREE;
                }
            });

        } catch (Exception e) {
            System.out.println("ERROR: Couldn't parse the tree");
            System.exit(0);
        }
    }
}