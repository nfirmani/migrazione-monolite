package it.esempio.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

// Creando questa classe forniamo a Kafka l'esatto costruttore vuoto che andava cercando!
public class CittadinoDeserializer extends ObjectMapperDeserializer<CittadinoDTO> {
    public CittadinoDeserializer() {
        // Passiamo alla classe padre il tipo esatto da convertire
        super(CittadinoDTO.class);
    }
}