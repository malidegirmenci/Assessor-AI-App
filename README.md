# Assessor-AI-App

Assessor AI App is a web application developed using the Java Spring Boot framework, strategically incorporating advanced artificial intelligence technologies. The application leverages OpenAI's GPT-4 and Whisper models to automate the summarization and evaluation of video interviews based on predefined criteria.

## Features
- Automatic summarization of video interviews.
- Evaluation of video interviews according to specified criteria.
- Integration of OpenAI's GPT-4 and Whisper models for advanced AI capabilities.
- Containerized using Docker for easy deployment and portability.

## Prerequisites
Make sure you have the following prerequisites installed:

- Java 17
- Maven
- FFMPEG
- Docker

## Configuration
Modify the application.properties file to customize the application settings.

### OpenAI API Configuration

Before running the application, make sure to update the OpenAI API key in the `application.properties` file.

```properties
openai.api.v1.completions.model=gpt-4
openai.api.v1.completions.url=https://api.openai.com/v1/chat/completions
openai.api.v1.whisper.url=https://api.openai.com/v1/audio/transcriptions
openai.api.v1.key=your-api-key
```
### Server Configuration

The application runs on port 9090 with the context path /api/v1.
```
server.port=9090
server.servlet.context-path=/api/v1
```
### Multipart Limit

```
spring.servlet.multipart.max-file-size=200MB
spring.servlet.multipart.max-request-size=200MB
```

## Getting Started
1. Clone the repository:
```
git clone https://github.com/your-username/assessorai.git
```
2. Update the OpenAI API key in application.properties.
3. Build and run the application:
```
cd assessorai
mvn clean install
docker build -t assessorai-app .
docker run -p 9090:9090 assessorai-app
```
## Usage
1. The application will be accessible at http://localhost:9090/api/v1.
2. Check endpoints on http://localhost:9090/api/v1/swagger-ui/index.html
3. Upload video interviews for automatic summarization and evaluation.
4. Customize evaluation criteria as needed.