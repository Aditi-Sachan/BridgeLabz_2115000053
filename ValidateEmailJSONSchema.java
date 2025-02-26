import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.util.JsonLoader;
import com.fasterxml.jackson.databind.JsonNode;

class ValidateEmailJSONSchema {
    public static void main(String[] args) {
        try {
            String schemaContent = "{\"type\": \"object\", \"properties\": {\"email\": {\"type\": \"string\", \"format\": \"email\"}}, \"required\": [\"email\"]}";
            String jsonData = "{\"email\": \"test@example.com\"}";
            
            JsonNode schemaNode = JsonLoader.fromString(schemaContent);
            JsonNode jsonNode = JsonLoader.fromString(jsonData);
            
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);
            ProcessingReport report = schema.validate(jsonNode);
            
            System.out.println(report.isSuccess() ? "Valid Email" : "Invalid Email");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
