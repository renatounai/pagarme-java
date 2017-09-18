package codegeneration;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.function.Consumer;

public class Wrapper {

    public void forEachSchema(Consumer<String> function) throws IOException {

        Arrays.asList("address","balance","billing","cardhashkey","document",
                "payable","recipient","splitrule","transfer","anticipationlimit",
                "balanceinternal","bulkanticipation","customer","gatewayoperation",
                "plan","refund","subscription","anticipationlimits","bankaccount",
                "card","delivery","item","postback","shipping","transactions","phone").forEach((resource) -> {
            ClassLoader classLoader = getClass().getClassLoader();
            Enumeration<URL> responseSchemaUrls = null;
            try {
                responseSchemaUrls = classLoader.getResources("schema/response/" + resource);

                do {
                    URL responseUrl = responseSchemaUrls.nextElement();
                    String schemaFileString = IOUtils.toString(responseUrl);
                    function.accept(schemaFileString);
                } while (responseSchemaUrls.hasMoreElements());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}