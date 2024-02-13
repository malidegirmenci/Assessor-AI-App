package com.madtech.assessorai.service;

import com.madtech.assessorai.utils.FileUtils;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.StatusLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TranscribeService {
    @Value("${openai.api.v1.whisper.url}")
    private String URL;
    public final static int MAX_ALLOWED_SIZE = 25 * 1024 * 1024;
    @Value("${openai.api.v1.key}")
    private String KEY;
    private final static String MODEL = "whisper-1";
    public static final String WORD_LIST = String.join(", ",
            List.of("GPT-3", "GPT-4", "DALL-E",
                    "AssertJ", "Mockito", "JUnit", "Java", "Kotlin", "Groovy",
                    "Spring Boot", "Spring Framework", "Spring Data", "Spring Security"
            ));

    private String transcribeChunk(String prompt, File chunkFile) {
        System.out.printf("Transcribing %s%n", chunkFile.getName());

        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);
            httpPost.setHeader("Authorization", "Bearer %s".formatted(KEY));

            HttpEntity entity = MultipartEntityBuilder.create()
                    .setContentType(ContentType.MULTIPART_FORM_DATA)
                    .addPart("file", new FileBody(chunkFile, ContentType.DEFAULT_BINARY))
                    .addPart("model", new StringBody(MODEL, ContentType.DEFAULT_TEXT))
                    .addPart("response_format", new StringBody("text", ContentType.DEFAULT_TEXT))
                    .addPart("prompt", new StringBody(prompt, ContentType.DEFAULT_TEXT))
                    .build();
            httpPost.setEntity(entity);

            return client.execute(httpPost, response -> {
                System.out.println("Status: " + new StatusLine(response));
                return EntityUtils.toString(response.getEntity());
            });
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String transcribe(String filePath) {
        System.out.println("Transcribing file from " + filePath);
        File file = new File(filePath);
        List<String> transcriptions = new ArrayList<>();
        String prompt = WORD_LIST;
        System.out.println("Size:" + file.length());
        if (file.length() <= MAX_ALLOWED_SIZE) {
            String transcription = transcribeChunk(prompt, file);
            transcriptions = List.of(transcription);
        } else {

            List<File> chunks = FileUtils.splitMp3File(file, 15);
            for (File chunk : chunks) {

                String transcription = transcribeChunk(prompt, chunk);
                transcriptions.add(transcription);
                prompt = transcription;

                if (!chunk.delete()) {
                    System.out.println("Failed to delete " + chunk.getName());
                }
            }
        }


        String transcription = String.join(" ", transcriptions);
        String fileNameWithoutPath = filePath.substring(
                filePath.lastIndexOf("/") + 1);
        FileUtils.writeTextToFile(transcription,
                fileNameWithoutPath.replace(".mp3", ".txt"));
        return transcription;
    }
}
