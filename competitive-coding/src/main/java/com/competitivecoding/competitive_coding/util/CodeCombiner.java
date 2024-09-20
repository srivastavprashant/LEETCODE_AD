package com.competitivecoding.competitive_coding.util;

import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class CodeCombiner {

    public static void combine(String sourceFile, String outputFile) throws IOException {
        Path path = Paths.get(sourceFile);
        String content = new String(Files.readAllBytes(path));

        // Remove package declaration
        content = content.replaceFirst("package.*?;", "");

        // Replace imports with actual code
        Pattern pattern = Pattern.compile("import\\s+([\\w.]+)\\s*;");
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            String importedClass = matcher.group(1);
            if (!importedClass.startsWith("com.competitivecoding.competitive_coding")) {
                // Remove Spring-related imports
                matcher.appendReplacement(sb, "");
            } else {
                // Replace other imports with actual code
                String importedContent = getImportedContent(importedClass);
                matcher.appendReplacement(sb, importedContent);
            }
        }
        matcher.appendTail(sb);
        String addImports = addImports();
        String fastIOContent = getFastIOContent("com.competitivecoding.competitive_coding.util.FastIO");
        content = addImports;
        content = addImports + sb.toString();
        content = content + fastIOContent;
        content = content.replaceAll("\\bpublic\\s+class\\b", "class");
        content = content.replaceAll("\\bpublic\\s+abstract\\b", "abstract");


        // Remove Spring annotations
        content = content.replaceAll("@Component\\s*", "");
        // Add more annotation removals if needed, e.g.:
        content = content.replaceAll("@Autowired\\s*", "");

        // Only 1 public class in output file
        String outputFileName = Paths.get(outputFile).getFileName().toString().replace(".java", "");
        content = content.replaceAll("class\\s+" + outputFileName, "public class " + outputFileName);
        // Write combined content to output file
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(content);
        }

    }

    private static String addImports() {
        return """
                import java.util.*;
                import java.io.*;
                import java.math.*;
                import java.lang.*;
                """;
    }

    private static String getImportedContent(String className) throws IOException {
        String path = "src/main/java/" + className.replace('.', '/') + ".java";
        String content = new String(Files.readAllBytes(Paths.get(path)));

        // Remove package declaration and imports from imported content
        content = content.replaceFirst("package.*?;", "");
        content = content.replaceAll("import.*?;", "");

        return content;
    }

    private static String getFastIOContent(String className) throws IOException {
        String path = "src/main/java/" + className.replace('.', '/') + ".java";
        String content = new String(Files.readAllBytes(Paths.get(path)));
        content = content.replaceFirst("package.*?;", "");
        content = content.replaceAll("import.*?;", "");
        return content;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java CodeCombiner <sourceFile> <outputFile>");
            return;
        }
        combine(args[0], args[1]);
    }
}
