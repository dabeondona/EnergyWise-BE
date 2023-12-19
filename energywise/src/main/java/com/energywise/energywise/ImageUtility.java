package com.energywise.energywise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.util.ResourceUtils;

public class ImageUtility {
    public static byte[] getDefaultImage() {
        try {
            File file = ResourceUtils.getFile("classpath:static/default-icon.png");
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to load default image", e);
        }
    }
}
