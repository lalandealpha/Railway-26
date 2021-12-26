package com.vti.backend.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {

	public static void main(String[] args) throws IOException {
        if (2 != args.length) {
            System.out.println("USAGE: java -jar so-downloader.jar https://github.com/JanStureNielsen/so-downloader/archive/main.zip so-downloader-source.zip");
            System.exit(1);
        }

        String sourceUrl = args[0];
        String targetFilename = args[1];

        long bytesDownloaded = download(sourceUrl, targetFilename);

        System.out.println(String.format("Downloaded %d bytes from %s to %s.", bytesDownloaded, sourceUrl, targetFilename));
    }

    static long download(String url, String fileName) throws IOException {
        try (InputStream in = URI.create(url).toURL().openStream()) {
            return Files.copy(in, Paths.get(fileName));
        }
    }

}


