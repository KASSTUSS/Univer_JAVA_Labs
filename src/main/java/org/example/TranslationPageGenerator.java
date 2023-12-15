package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class TranslationPageGenerator {

    public static void main(String[] args) {
        String html = generateTranslationPage();
        saveTranslationPage(html, "translation.html");
    }

    private static String generateTranslationPage() {
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head>\n");
        sb.append("<title>Translation Page</title>\n");
        sb.append("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
        sb.append("<script>\n");
        sb.append("$(document).ready(function() {\n");
        sb.append("$('#translate-form').submit(function(event) {\n");
        sb.append("event.preventDefault();\n");
        sb.append("var word = $('#word-input').val();\n");
        sb.append("translateWord(word);\n");
        sb.append("});\n");
        sb.append("function translateWord(word) {\n");
        sb.append("$.ajax({\n");
        sb.append("type: 'POST',\n");
        sb.append("url: 'translation',\n");
        sb.append("data: { word: word },\n");
        sb.append("success: function(response) {\n");
        sb.append("$('#translation-result').text(response);\n");
        sb.append("},\n");
        sb.append("error: function() {\n");
        sb.append("$('#translation-result').text('Error occurred during translation.');\n");
        sb.append("}\n");
        sb.append("});\n");
        sb.append("}\n");
        sb.append("});\n");
        sb.append("</script>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<h1>Translation Page</h1>\n");
        sb.append("<form id=\"translate-form\">\n");
        sb.append("<label for=\"word-input\">Enter a word:</label>\n");
        sb.append("<input type=\"text\" id=\"word-input\" name=\"word\" required>\n");
        sb.append("<button type=\"submit\">Translate</button>\n");
        sb.append("</form>\n");
        sb.append("<div id=\"translation-result\"></div>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");

        return sb.toString();
    }

    private static void saveTranslationPage(String html, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(html);
            System.out.println("Translation page saved to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the translation page.");
            e.printStackTrace();
        }
    }
}