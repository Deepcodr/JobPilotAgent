JobPilot Agent– Intelligent Job Search & Apply Assistant
AI-powered Job Search, Filtering & Smart Apply Helper built with Java + Agents + Jooble API

📌 Overview
JobPilot is an intelligent job-search built using Java, Google Gemini AI (ADK Agent Framework), and the Jooble Job Search API.

It helps users:

🔎 Search for jobs across platforms using natural language

🧠 Use AI to summarize, filter job matches

🎯 Key Features

🔍 1. Job Search Agent (with External Tool Call)

Uses Jooble API to fetch real job listings

Supports filters: skill, experience, location, salary

Automatically enriches results using Google Search (optional)

🤝 2. Multi-Agent Architecture

Search Agent → Fetches & ranks jobs


🧠 3. AI-Powered Enhance

Summarizes job descriptions

Filters Job


Displays:

Job list

Job summary

Filtered Job List


🧩 System Architecture
+------------------+       +--------------------+        +--------------------+
| User             | <---> | Search Agent       | <----> | Jooble API         |
| (Currently CLI)  |       | (Gemini ADK Agent) |        | (External Tool)    |
+------------------+       +--------------------+        +--------------------+
  

🔌 Integration: Jooble Job Search API
API Endpoint
POST https://jooble.org/api/<YOUR_API_KEY>

Sample Request
{
  "keywords": "Java Developer",
  "location": "India",
  "page": 1
}


🛠️ Tech Stack
Component	Technology
Agent Framework	Google Gemini ADK
Backend	Java 17+

Job Data Provider	Jooble API

Build Tool	Maven or Gradle


🚀 How It Works
🔸 Step 1 — User enters query

Example:

“Find me Java backend developer jobs in New York"

🔸 Step 2 — Search Agent

Converts query → API payload

Calls Jooble API

Enhances results using Gemini AI

Sends list to CLI

📦 Project Structure
jobpilot/
 ├── src/main/java/com/deepcodr/JobPilot
 │   ├── dto/
 │   │     ├── Job.java
 │   │     └── JoobleRequestBody.java
 │   └── AgentCliRunner.java
 │   └── JobPilotAgent.java
 ├── resources/
 ├── test/
 ├── .env
 ├── README.md
 └── pom.xml

🔧 Setup Instructions
1️⃣ Clone the repo
git clone https://github.com/deepcodr/jobpilot.git

2️⃣ Create a .env file at project root and add following vars. Make sure you setup env in your shell.
GOOGLE_API_KEY=<YOUR_GOOGLE_AI_STUDIO_API_KEY>
JOOBLE_API_KEY=<YOUR_JOOBLE_API_KEY>

3️⃣ Install dependencies
mvn clean install

4️⃣ Run the app
mvn compile exec:java -Dexec.mainClass="com.deepcodr.JobPilotAgent.AgentCliRunner"

🔥 Future Enhancements

Apply functionality by just specifying the job ID.

Auto email job notifications

❤️ Contributing

Pull requests are welcome!
