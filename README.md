# Ollama – Local LLM Setup Using Docker

This setup allows running LLMs locally using Ollama and integrating them with a Spring Boot application via Spring AI.
🔗 Reference: https://hub.docker.com/r/ollama/ollama

1️⃣ Add Ollama Dependency (Spring AI)

<dependency>
    <groupId>org.springframework.ai</groupId>
    <artifactId>spring-ai-starter-model-ollama</artifactId>
</dependency>


2️⃣ Create docker-compose.yml
<pre> 
version: '3.8'
services:
  ollama:
    image: ollama/ollama
    container_name: ollama
    hostname: ollama
    ports:
      - "11434:11434"    #HOST_PORT : CONTAINER_PORT
</pre>
3️⃣ Start Ollama Server using command: docker compose -f docker-compose.yml up

It Reads docker-compose.yml, 
Pulls the image ollama/ollama (if not already present),
Creates a container named ollama,
Starts the Ollama service,
Exposes API on port 11434.

4️⃣ Run an AI Model Inside the Container: docker exec -it ollama ollama run llama3.2:1b

This command downloads the model if it is not already present,
Loads the model into memory,
Makes it available for inference via Ollama’s API,
llama3.2:1b is the model name and can be replaced with other supported models.
