package StudentManagementSystem;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 * 文本文件读写工具：统一使用 UTF-8 写入；读取时先按 UTF-8 解码，
 * 失败（例如旧版本用系统默认编码写出的文件）则退回系统默认编码。
 */
public class FileUtil {

    // 读取所有非空行；文件不存在时返回空列表（第一次运行）
    public static List<String> readLines(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            return lines;
        }
        byte[] bytes = Files.readAllBytes(path);
        String text;
        try {
            text = StandardCharsets.UTF_8.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPORT)
                    .onUnmappableCharacter(CodingErrorAction.REPORT)
                    .decode(ByteBuffer.wrap(bytes)).toString();
        } catch (CharacterCodingException e) {
            text = new String(bytes, Charset.defaultCharset());
        }
        if (text.startsWith("\uFEFF")) {
            text = text.substring(1);
        }
        for (String line : text.split("\\r?\\n")) {
            if (!line.trim().isEmpty()) {
                lines.add(line);
            }
        }
        return lines;
    }

    // 先写临时文件再替换，避免写到一半出错把原文件弄坏
    public static void writeLines(String filename, List<String> lines) throws IOException {
        Path target = Paths.get(filename).toAbsolutePath();
        Path tmp = target.resolveSibling(target.getFileName() + ".tmp");
        Files.write(tmp, lines, StandardCharsets.UTF_8);
        Files.move(tmp, target, StandardCopyOption.REPLACE_EXISTING);
    }

    // 文件用逗号分隔、一行一条记录，所以字段里不能有逗号和换行
    public static boolean isSafeField(String s) {
        return s != null && s.indexOf(',') < 0 && s.indexOf('\n') < 0 && s.indexOf('\r') < 0;
    }
}