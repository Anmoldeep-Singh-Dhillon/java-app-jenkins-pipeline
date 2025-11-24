package demo.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

public String greeting(String name) {
if (name == null || name.isBlank()) return "Hello, Stranger";
return "Hello, " + name.trim();
}
}