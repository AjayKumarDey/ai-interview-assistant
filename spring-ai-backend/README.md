# AI Interview Backend — Java + Spring Boot + Spring AI

A backend-only AI project for a Java developer portfolio. It exposes REST APIs for general AI chat and interview-question generation using Spring AI and OpenAI.

## Stack
- Java 21
- Spring Boot 4.0.8
- Spring AI 2.0.1
- Spring MVC REST
- OpenAI Chat Model
- Bean Validation
- Actuator
- Docker

## Project structure
```
src/main/java/com/ajay/aibackend/
├── controller/AiController.java
├── service/AiService.java
├── dto/ChatRequest.java
├── dto/InterviewRequest.java
├── dto/AiResponse.java
├── config/WebConfig.java
└── SpringAiBackendApplication.java
```

## Configure OpenAI
Spring AI reads the key from `OPENAI_API_KEY`.

Windows PowerShell:
```
$env:OPENAI_API_KEY="your-key"
```

Linux/macOS:
```
export OPENAI_API_KEY=your-key
```

Or copy `.env.example` to `.env` for Docker Compose.

## Run locally
```
mvn spring-boot:run
```

Health: `GET http://localhost:8080/actuator/health`

## API 1 — AI Chat
```
POST /api/ai/chat
Content-Type: application/json

{"message":"Explain Spring Boot dependency injection with a simple example."}
```

## API 2 — Generate Interview Questions
```
POST /api/ai/interview
Content-Type: application/json

{
  "topic":"Java Collections",
  "experienceLevel":"2 years",
  "questionCount":5
}
```

## Docker
```
docker compose up --build
```

## Interview explanation
“I built an AI-powered backend using Java 21, Spring Boot and Spring AI. I exposed REST APIs for conversational Q&A and dynamic interview-question generation. The service uses Spring AI's ChatClient abstraction to call an OpenAI chat model, externalizes the API key through environment variables, validates requests, adds CORS for a React client, exposes health through Actuator, and can be containerized with Docker.”
