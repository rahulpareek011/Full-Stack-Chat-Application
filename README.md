# 💬 Real-Time Full Stack Chat Application

## Project Overview
This is a real-time chat application built using Spring Boot on the backend for handling WebSocket connections and serving the web interface, and SockJS/STOMP on the frontend for low-latency, real-time communication.

---

## ✨ Features

- **Real-Time Messaging:** Instantaneous message delivery using WebSockets (via STOMP protocol).
- **Fallback Support:** Utilizes SockJS to provide HTTP fallback options (like polling) for clients that do not natively support WebSockets.
- **Full-Stack Implementation:** Monolithic architecture with the backend serving the frontend HTML/JS.
- **Secure Deployment:** Configured for production deployment on Render, including proper CORS handling.

---

## 🛠️ Technology Stack

| Component            | Technology             | Description                                              |
|----------------------|------------------------|----------------------------------------------------------|
| Backend Framework    | Java 17 (OpenJDK) / Spring Boot | Core application framework & WebSocket controller        |
| Build Tool           | Maven                  | Dependency management and project building               |
| Messaging Protocol   | STOMP                  | Simple Text Oriented Messaging Protocol over WebSockets  |
| WebSockets Fallback  | SockJS                 | JS library for client-side WebSocket emulation/fallback  |
| Frontend             | HTML, JavaScript, CSS  | UI for sending and receiving messages                    |
| Deployment           | Render (Docker)        | Containerized environment for production                 |

**Language Composition:**  
- Java: 55.9%  
- HTML: 38.7%  
- Dockerfile: 5.4%

visit here: [http://full-stack-chat-application-21a3.onrender.com/chat](https://full-stack-chat-application-21a3.onrender.com/chat)

---

## 🚀 Deployment & Running

### Prerequisites

- **Java Development Kit (JDK) 17 or newer**
- **Apache Maven 3.6 or newer**
- **Docker** (Optional, only for local container testing)

### Local Development

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/rahulpareek011/Full-Stack-Chat-Application
    cd Full-Stack-Chat-Application
    ```

2. **Build the Project:**
    ```bash
    mvn clean install
    ```

3. **Run the Application:**
    ```bash
    java -jar target/*.jar
    ```

4. **Access the Application:**
    Open your browser and navigate to:  
    [http://localhost:8080/chat](http://localhost:8080/chat)

---

### Production Deployment (Render)

- **Platform:** Render
- **Language:** Docker

#### Core Configuration

- The application is containerized using a **multi-stage Dockerfile**.
- The final stage uses the lightweight `eclipse-temurin:17-jdk-alpine` image.
- **Port Configuration:** The `PORT` environment variable is set to `8080` in the Render dashboard (ensures Spring Boot and Render health checks are aligned).

#### Key Configuration Details

- **Dockerfile:** Uses multi-stage build (`maven:3.8.5-openjdk-17` to `eclipse-temurin:17-jdk-alpine`).
- **Port Handling:**  
  Set `server.port=${PORT:8080}` in `application.properties` or set `PORT=8080` Environment Variable in Render dashboard (resolves 502/503 errors).
- **CORS Configuration:**  
  `WebSocketConfig.java` updated to allow deployed Render URL as an origin:  
  `.setAllowedOrigins("https://full-stack-chat-application-21a3.onrender.com")`

---

## 🤝 Contributing

Feel free to open issues or submit pull requests for enhancements!

---

## 👤 Author

*Rahul Pareek*
