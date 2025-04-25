package eu.gaiax.dashboard.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Log4j2
@Component
public class ProxyCall {

    public static <T> ResponseEntity<T> doProxyCall(WebClient srv, HttpServletRequest request, String url) {
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        request.getParameterMap().forEach((s, strings) -> queryParams.addAll(s, List.of(strings)));

        final WebClient.RequestHeadersSpec<?> callBuilder = srv
                .get()
                .uri(builder ->
                        builder.path(url)
                                .queryParams(queryParams).build());

        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String hn = headerNames.nextElement();
            callBuilder.header(hn, request.getHeader(hn));
        }

        final String body = RequestMethods.extractRequestBody(request);
        if (!body.isEmpty()) {
            log.error("In GET request body is supplied: {}", body);
        }

        return callBuilder.retrieve()
                .toEntity(new ParameterizedTypeReference<T>() {
                    //
                }).block();
    }

    public static <T> ResponseEntity<T> doGet(final WebClient srv, final HttpServletRequest request) {
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        request.getParameterMap().forEach((s, strings) -> queryParams.addAll(s, List.of(strings)));

        final WebClient.RequestHeadersSpec<?> callBuilder = srv
                .get()
                .uri(builder ->
                        builder.path(request.getRequestURI())
                                .queryParams(queryParams).build());

        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String hn = headerNames.nextElement();
            callBuilder.header(hn, request.getHeader(hn));
        }

        return callBuilder.retrieve()
                .toEntity(new ParameterizedTypeReference<T>() {
                    //
                }).block();
    }

    public static <T, R> ResponseEntity<T> doPost(WebClient srv, HttpServletRequest request, R rqBody) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        request.getParameterMap().forEach((s, strings) -> queryParams.addAll(s, List.of(strings)));

        WebClient.RequestBodySpec prep = srv
                .post()
                .uri(builder ->
                        builder.path(request.getRequestURI())
                                .queryParams(queryParams).build());

        WebClient.RequestHeadersSpec<?> callBuilder = prep;
        if (rqBody != null) {
            callBuilder = prep.bodyValue(rqBody);
        }

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hn = headerNames.nextElement();
            String header = request.getHeader(hn);
            callBuilder.header(hn, header);
        }
        return callBuilder
                .retrieve()
                .toEntity(new ParameterizedTypeReference<T>() {
                })
                .block();
    }
}
