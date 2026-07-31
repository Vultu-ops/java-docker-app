import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

        server.createContext("/", (HttpExchange exchange) -> {
            String response = """
                    <html>
                    <head><title>Java Docker App</title></head>
                    <body>
                        <h1>Hello from Java Docker!</h1>
                        <h2>Calculator</h2>
                        <p>Addition: 10 + 5 = 15</p>
                        <p>Subtraction: 10 - 5 = 5</p>
                        <p>Multiplication: 10 * 5 = 50</p>
                        <p>Division: 10 / 5 = 2</p>
                    </body>
                    </html>
                    """;

            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Server started on port 80...");
    }
}