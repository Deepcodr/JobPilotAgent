# JobPilot Agent– Intelligent Job Search & Apply Assistant
**AI-powered Job Search, Filtering & Smart Apply Helper built with Java + Agents + Jooble API**

## 📌 Overview

**JobPilot is an intelligent job-search built using Java, Google Gemini AI (ADK Agent Framework), and the Jooble Job Search API.**

## It helps users:

🔎 **Search for jobs across platforms using prompt**

🧠 **Use AI to summarize, filter job matches**

## 🎯 **Key Features**

🔍 **1. Job Search Agent (with External Tool Call)**

- Uses Jooble API to fetch real job listings

- Supports filters: company, location, experience, salary

- Automatically enriches results using Google Search (optional)

🤝 **2. Multi-Agent Architecture**

- Search Agent → Fetches & lists jobs

🧠 **3. AI-Powered Enhance**

- Summarizes job descriptions

- Filters Job

**Displays:**

- Job list

- Job summary

- Filtered Job List

# 🧩 Architecture
 
![Architecture of Agent](https://github.com/Deepcodr/JobPilotAgent/tree/main/src/main/java/com/deepcodr/JobPilot/resources/architecture.png)

## 🔌 **Integration: Jooble Job Search API**

**API Endpoint**
>POST https://jooble.org/api/<YOUR_API_KEY>

**Sample Request**
```
{
  "keywords": "Java Developer",
  "location": "India",
  "page": 1
}
```

## 🛠️ Tech Stack
- Component Technology

- Agent Framework	Google Gemini ADK

- Java 21

- Job Data Provider : Jooble API

- Build Tool	Maven or Gradle


## 🚀 How It Works

>Example:
“Find me Java backend developer jobs in New York"

>Converts query → API payload

>Calls Jooble API

>Enhances results using Gemini AI

>Sends list to CLI

## 📦 Project Structure

![Project Structure](https://github.com/Deepcodr/JobPilotAgent/tree/main/src/main/java/com/deepcodr/JobPilot/resources/project_structure.png)

## 🔧 Setup Instructions
1️⃣ Clone the repo

```
git clone https://github.com/deepcodr/jobpilot.git
```

2️⃣ Create a .env file at project root and add following vars. Make sure you setup env in your shell.

```
GOOGLE_API_KEY=<YOUR_GOOGLE_AI_STUDIO_API_KEY>
JOOBLE_API_KEY=<YOUR_JOOBLE_API_KEY>
```

3️⃣ Install dependencies
```
mvn clean install
```

4️⃣ Run the app

```
mvn compile exec:java -Dexec.mainClass="com.deepcodr.JobPilotAgent.AgentCliRunner"
```

## 🔥 Future Enhancements

**Apply functionality by just specifying the job ID.**

**Auto email job notifications**

## ❤️ Contributing

###  _**Pull requests are welcome!**_
