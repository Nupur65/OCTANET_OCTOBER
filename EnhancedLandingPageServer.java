import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class EnhancedLandingPageServer {

    public static void main(String[] args) throws IOException {
        // Create a basic HTTP server that listens on port 8000
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new LandingPageHandler());
        server.setExecutor(null); // creates a default executor
        System.out.println("Server is running on http://localhost:8000");
        server.start();
    }

    // Handler for the landing page
    static class LandingPageHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<!DOCTYPE html>" +
                    "<html lang='en'>" +
                    "<head>" +
                    "<meta charset='UTF-8'>" +
                    "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                    "<title>Enhanced Landing Page</title>" +
                    "<style>" +
                    "body { font-family: Arial, sans-serif; line-height: 1.6; margin: 0; padding: 0; background-color: #f4f4f4; color: #333; }" +
                    "header { background-color: #333; color: white; padding: 10px 0; text-align: center; }" +
                    "header h1 { margin: 0; font-size: 2.5em; }" +
                    ".nav { margin-top: 20px; }" +
                    ".nav a { margin: 0 15px; text-decoration: none; color: #ff6600; font-weight: bold; }" +
                    ".container { width: 80%; margin: 0 auto; padding: 20px; text-align: center; }" +
                    ".section { padding: 50px 0; }" +
                    ".section h2 { font-size: 2em; margin-bottom: 20px; }" +
                    ".cta button { padding: 10px 20px; font-size: 1.2em; color: white; background-color: #ff6600; border: none; cursor: pointer; margin-top: 20px; }" +
                    ".cta button:hover { background-color: #e65c00; }" +
                    ".footer { background-color: #333; color: white; padding: 10px 0; margin-top: 30px; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<header>" +
                    "<h1>Welcome to Our Product</h1>" +
                    "<nav class='nav'>" +
                    "<a href='#about'>About Us</a>" +
                    "<a href='#features'>Features</a>" +
                    "<a href='#pricing'>Pricing</a>" +
                    "<a href='#contact'>Contact</a>" +
                    "</nav>" +
                    "</header>" +
                    "<div class='container'>" +
                    "<section class='section' id='about'>" +
                    "<h2>About Us</h2>" +
                    "<p>We are committed to providing the best solution for your business needs. Our product is designed to make your workflow seamless and efficient.</p>" +
                    "</section>" +
                    "<section class='section' id='features'>" +
                    "<h2>Features</h2>" +
                    "<p>Our product offers a variety of features to help your business succeed:</p>" +
                    "<ul>" +
                    "<li>Feature 1: Intuitive and easy to use interface</li>" +
                    "<li>Feature 2: Fast and reliable performance</li>" +
                    "<li>Feature 3: 24/7 customer support</li>" +
                    "<li>Feature 4: Customizable solutions to fit your needs</li>" +
                    "</ul>" +
                    "</section>" +
                    "<section class='section' id='pricing'>" +
                    "<h2>Pricing</h2>" +
                    "<p>We offer flexible pricing plans to fit businesses of all sizes:</p>" +
                    "<ul>" +
                    "<li>Basic Plan: $19/month</li>" +
                    "<li>Pro Plan: $49/month</li>" +
                    "<li>Enterprise Plan: Contact us for pricing</li>" +
                    "</ul>" +
                    "</section>" +
                    "<section class='section' id='contact'>" +
                    "<h2>Contact Us</h2>" +
                    "<p>If you have any questions, feel free to <strong>reach out to us</strong>.</p>" +
                    "<div class='cta'><button>Contact Support</button></div>" +
                    "</section>" +
                    "</div>" +
                    "<footer class='footer'>" +
                    "<p>&copy; 2024 Your Company. All Rights Reserved.</p>" +
                    "</footer>" +
                    "</body>" +
                    "</html>";

            // Send response headers
            exchange.sendResponseHeaders(200, response.getBytes().length);
            // Send the HTML response
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
