package com.example.jsonwar.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;

import com.example.jsonwar.model.Firma;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class FirmaService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Firma parseJson(String json) throws IOException {
    JsonNode jsonNode = objectMapper.readTree(json);

    // Check for "Firma" node directly under root
    JsonNode firmaNode = jsonNode.has("Firma") ? jsonNode.get("Firma") : jsonNode;

    // Extract and print each field from the JSON
    String nombre = firmaNode.has("Nombre") ? firmaNode.get("Nombre").asText() : null;
    String apellido = firmaNode.has("Apellido") ? firmaNode.get("Apellido").asText() : null;
    String cargo = firmaNode.has("Cargo") ? firmaNode.get("Cargo").asText() : null;
    String empresa = firmaNode.has("Empresa") ? firmaNode.get("Empresa").asText() : null;
    String fecha = firmaNode.has("Fecha") ? firmaNode.get("Fecha").asText() : null;
    String telefono = firmaNode.has("Telefono") ? firmaNode.get("Telefono").asText() : null;
    String correo = firmaNode.has("Correo") ? firmaNode.get("Correo").asText() : null;
    String observaciones = firmaNode.has("Observaciones") ? firmaNode.get("Observaciones").asText() : null;
    String imagen = firmaNode.has("Imagen") ? firmaNode.get("Imagen").asText() : null;

    // Print values to the console
    System.out.println("Nombre: " + nombre);
    System.out.println("Apellido: " + apellido);
    System.out.println("Cargo: " + cargo);
    System.out.println("Empresa: " + empresa);
    System.out.println("Fecha: " + fecha);
    System.out.println("Telefono: " + telefono);
    System.out.println("Correo: " + correo);
    System.out.println("Observaciones: " + observaciones);

    // If there's an image, decode and save it
    if (imagen != null) {
        // Output directory and file name
        String outputDirectory = "C:/SVRIMAGENT24QA";
        String outputFileName = outputDirectory + "/" + nombre + "_" + apellido + "_" + fecha + ".jpg";

        // Decode and save the image
        saveImage(imagen, outputFileName);
    }

    // Convert the JSON to Firma object
    return objectMapper.treeToValue(firmaNode, Firma.class);
}

    private void saveImage(String base64Image, String outputFilePath) throws IOException {
        // Remove the Base64 prefix if present
        if (base64Image.startsWith("data:image/jpeg;base64,")) {
            base64Image = base64Image.substring("data:image/jpeg;base64,".length());
        } else if (base64Image.startsWith("data:image/png;base64,")) {
            base64Image = base64Image.substring("data:image/png;base64,".length());
        }

        byte[] imageBytes = Base64.getDecoder().decode(base64Image);

        File outputFile = new File(outputFilePath);
        File parentDir = outputFile.getParentFile(); // Get the parent directory
        if (!parentDir.exists()) {
            // Create the parent directory
            parentDir.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            fos.write(imageBytes);
        }

        System.out.println("Image saved successfully to: " + outputFilePath);
    }
}
