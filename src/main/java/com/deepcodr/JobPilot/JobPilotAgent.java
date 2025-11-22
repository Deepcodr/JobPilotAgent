package com.deepcodr.JobPilot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.Annotations;
import com.google.adk.tools.FunctionTool;
import com.google.adk.tools.GoogleSearchTool;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class JobPilotAgent {
    public static BaseAgent ROOT_AGENT = initAgent();

    public static Map<Integer, Object> jobData = new HashMap<>();

    public static String joobleApiKey = System.getenv("JOOBLE_API_KEY");

    private static BaseAgent initAgent() {
        GoogleSearchTool googleSearchTool = new GoogleSearchTool();

        return LlmAgent.builder()
                .name("JobPilotAgent")
                .description("Agent for searching jobs and applying to jobs")
                .instruction("""
                        You are a helpful agent which fetches current jobs available.
                        You need to capture location from the prompt which will be the location for job search. 
                        Then capture keywords from prompt like role of job. To fetch the jobs use 'fetchJobs' tool, response politely that there is failure.
                        Display Job Number starting from 1, Job title, Company and link to apply for Job from data received from fetchJobs. 
                        """)
                .model("gemini-2.5-flash")
                .tools(FunctionTool.create(JobPilotAgent.class, "fetchJobs")).build();
    }

    @Annotations.Schema(description = "Fetches available Jobs in the location provided")
    public static Map<String, Object> fetchJobs(@Annotations.Schema(description = "The role for the job", name = "keywords") String keywords, @Annotations.Schema(description = "The location of the jobs", name = "location") String location) {
        try {
            String requestBody = String.format("""
                    {
                        "keywords": "%s",
                        "location": "%s"
                    }
                    """, keywords, location);

            HttpClient client = HttpClient.newHttpClient();

            String joobleApiURL = "https://jooble.org/api/" + joobleApiKey;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(joobleApiURL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

//            Give Data Analyst jobs in Mumbai India

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());

            JsonNode jobs = root.get("jobs");

            return Map.of("totalCount", root.get("totalCount"), "jobs", jobs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
