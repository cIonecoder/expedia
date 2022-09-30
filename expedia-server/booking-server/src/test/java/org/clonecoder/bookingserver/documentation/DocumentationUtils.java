package org.clonecoder.bookingserver.documentation;

import io.restassured.RestAssured;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public class DocumentationUtils {
    public static OperationRequestPreprocessor getDocumentRequest() {
        // 문서의 url 기본 값 설정 (http://localhost:port)
        return preprocessRequest(
                modifyUris()
                        .scheme("http")
                        .host("localhost")
                        .port(RestAssured.port),
                prettyPrint()
        );
    }

    public static OperationResponsePreprocessor getDocumentResponse() {
        return preprocessResponse(prettyPrint());
    }
}
