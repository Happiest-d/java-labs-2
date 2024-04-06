package org.donstu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpServer;
import org.donstu.domain.Company;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class SimpleRestService {
    private static final int PORT = 8080;
    private static final int OK = 200;
    private static final int NOT_ALLOWED = 405;


    private static List<Company> companies = new ArrayList<>();
    static {
        companies.add(new Company("Google", "Best Search Engine", "Mountain View, CA 94043", "+1 650-253-0000"));
        companies.add(new Company("Apple", "Apple Inc.", "Cupertino, CA 95014", "+1 408-996-1010"));
        companies.add(new Company("Microsoft", "Microsoft Corporation", "Redmond, WA 98052", "+1 425-882-8080"));
        companies.add(new Company("Samsung", "Samsung Electronics", "Seoul, Korea", "+82 2 1234 5678"));
        companies.add(new Company("Nokia", "Nokia Corporation", "Helsinki, Finland", "+358 9 123 4567"));
        companies.add(new Company("Sony", "Sony Corporation", "Tokyo, Japan", "+81 3 1234 5678"));
        companies.add(new Company("Yandex", "Yandex LLC", "Moscow, Russia", "+7 499 123 45 67"));
    }

    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(PORT), 0);
            httpServer.createContext("/company/list", httpExchange -> {
                if ("GET".equals(httpExchange.getRequestMethod())) {
                    httpExchange.getResponseHeaders().set("Content-Type", "application/json");
                    httpExchange.sendResponseHeaders(OK, 0);
                    ObjectMapper mapper = new ObjectMapper();
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    mapper.writeValue(baos, companies);
                    byte[] body = baos.toByteArray();
                    OutputStream os = httpExchange.getResponseBody();
                    os.write(body);
                    os.close();
                } else {
                    httpExchange.sendResponseHeaders(NOT_ALLOWED, -1);
                }
            });
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
