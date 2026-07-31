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
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Java Docker App</title>
                    <style>
                        body{
                            margin:0;
                            font-family:Arial, Helvetica, sans-serif;
                            background:#f4f6f9;
                        }

                        .container{
                            width:70%;
                            margin:50px auto;
                            background:white;
                            padding:30px;
                            border-radius:10px;
                            box-shadow:0 0 15px rgba(0,0,0,0.2);
                            text-align:center;
                        }

                        h1{
                            color:#0d6efd;
                        }

                        h2{
                            color:#444;
                        }

                        table{
                            width:100%;
                            border-collapse:collapse;
                            margin-top:20px;
                        }

                        th,td{
                            border:1px solid #ddd;
                            padding:12px;
                        }

                        th{
                            background:#0d6efd;
                            color:white;
                        }

                        tr:nth-child(even){
                            background:#f2f2f2;
                        }

                        footer{
                            margin-top:30px;
                            color:gray;
                            font-size:14px;
                        }
                    </style>
                </head>

                <body>

                <div class="container">

                    <h1>Java Docker Web Application</h1>

                    <h2>Simple Calculator Results</h2>

                    <table>

                        <tr>
                            <th>Operation</th>
                            <th>Result</th>
                        </tr>

                        <tr>
                            <td>Addition (10 + 5)</td>
                            <td>15</td>
                        </tr>

                        <tr>
                            <td>Subtraction (10 - 5)</td>
                            <td>5</td>
                        </tr>

                        <tr>
                            <td>Multiplication (10 × 5)</td>
                            <td>50</td>
                        </tr>

                        <tr>
                            <td>Division (10 ÷ 5)</td>
                            <td>2</td>
                        </tr>

                    </table>

                    <footer>
                        Running inside Docker • Java 17 • HTTP Server
                    </footer>

                </div>

                </body>
                </html>
                """;

            exchange.getResponseHeaders().add("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();

        });

        server.start();

        System.out.println("Server started on http://localhost");
    }
}