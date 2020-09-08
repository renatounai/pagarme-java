package me.pagarme.factory;

import java.util.ArrayList;
import java.util.Collection;

import me.pagar.model.Document;

public class DocumentFactory {
    public static final Document.Type DEFAULT_TYPE = Document.Type.CPF;
    public static final String DEFAULT_NUMBER = "11111111111";

    public Collection<Document> create() {
        Collection<Document> documents = new ArrayList<Document>();
        Document document = new Document(DEFAULT_TYPE, DEFAULT_NUMBER);

        documents.add(document);
        return documents;
    }
}
