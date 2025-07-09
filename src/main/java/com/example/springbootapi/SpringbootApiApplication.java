package com.example.springbootapi;

import com.example.springbootapi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApiApplication implements CommandLineRunner {

    private final UserService userService;
    private static boolean isCliMode = false;

    public SpringbootApiApplication(UserService greetingService) {
        this.userService = greetingService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootApiApplication.class);

        // Detect CLI mode from arguments (comma-separated by Maven)
        if (args.length > 0 && args[0].contains(",")) {
            String[] parsedArgs = args[0].split(",");
            if (parsedArgs[0].equalsIgnoreCase("greet") || parsedArgs[0].equalsIgnoreCase("goodbye")) {
                isCliMode = true;
                app.setWebApplicationType(WebApplicationType.NONE); // 🧨 This avoids web server startup
            }
        }

        app.run(args);
    }

    @Override
    public void run(String... args) {
        if (!isCliMode) return;

        // Parse comma-separated args
        String[] inputs = args.length == 1 && args[0].contains(",")
                ? args[0].split(",")
                : args;

        String command = inputs[0];
        String userId = inputs.length > 1 ? inputs[1] : "World";

        switch (command.toLowerCase()) {
            case "search":
                System.out.println("CLI Output: " + userService.searchUser(userId));
                break;
            case "delete":
                System.out.println("CLI Output: " + userService.deleteUser(userId));
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
