# AI Chatbot - Spring Boot Application  

## 🚀 Overview  
This is a Java-based AI Chatbot built using **Spring Boot**. It provides an API for handling AI-driven conversations and includes a simple frontend interface.

## 📌 Features  
- REST API for AI-driven chat responses  
- Exception handling for smooth user experience  
- Structured DTOs for handling AI requests and responses  
- Web-based UI with HTML, CSS, and JavaScript  

## 🏗 Project Structure  
```
/src/main/java/com/ai/demo
│── AiDemoApplication.java         # Main Spring Boot application
│── controller/HomeController.java # Handles chatbot API endpoints
│── service/AiService.java         # Core logic for AI responses
│── dto/                           # Data Transfer Objects for structured requests
│── exceptionhandler/              # Custom exception handling
│── resources/static/              # Frontend assets (CSS, JS)
│── resources/templates/index.html # Chatbot UI
```

## 🛠️ Setup & Installation  

### Prerequisites  
- Java 17+  
- Maven  
- Spring Boot  

### Steps to Run  
1. Clone the repository:  
   ```sh
   git clone https://github.com/your-repo/chatbot.git
   cd chatbot
   ```
2. Build and run the project:  
   ```sh
   mvn spring-boot:run
   ```
3. Open in the browser:  
   ```
   http://localhost:8080
   ```

## 📡 API Endpoints  
| Method | Endpoint       | Description               |
|--------|--------------|---------------------------|
| POST   | `/chat`      | Process chatbot request  |

## 🎨 UI Preview  
![Chatbot UI](screenshot.png)

## 🤝 Contributing  
Feel free to submit pull requests to improve the chatbot!
