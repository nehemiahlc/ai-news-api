
# AI News Web Scraper API

Welcome to the AIBrief, an AI News Web Scraper API! This API provides a curated list of AI-related news articles from various trusted sources. Whether you're building an AI-focused app, creating a content aggregator, or just looking to stay up to date with the latest AI news, this API is designed to help you access the freshest AI articles quickly and efficiently.

## Table of Contents

1. [Base URL](#base-url)
2. [Endpoints](#endpoints)
   - [GET /news](#get-news)
   - [GET /news/{newspaperId}](#get-newsnewspaperid)
3. [Valid Parameters](#valid-parameters)
4. [Example Requests](#example-requests)
5. [Error Handling](#error-handling)
6. [Technologies Used](#technologies-used)
7. [Contact](#contact)

---

## Base URL

```
https://ai-newsapi-e6bc67c3e98b.herokuapp.com/
```

---

## Endpoints

### GET /news

Fetches a list of all AI-related news articles from multiple sources.

#### Response

Returns a JSON array of articles, each containing the article title, URL, and source.

##### Example Response:

```json
[
  {
    "title": "AI breakthrough in ML algorithms",
    "url": "https://techcrunch.com/ai-ml-breakthrough",
    "source": "techcrunch"
  },
  {
    "title": "Latest trends in artificial intelligence",
    "url": "https://theverge.com/ai-trends",
    "source": "theverge"
  },
  {
    "title": "AI in healthcare: Revolutionizing the industry",
    "url": "https://venturebeat.com/ai-healthcare",
    "source": "venturebeat"
  }
]
```

---

### GET /news/{newspaperId}

Fetches AI-related articles from a specific source based on the provided **newspaperId**.

#### Path Parameters

- **newspaperId** (required, string): The ID of the newspaper/website from which you want to fetch articles. The valid values are:
  - `techcrunch` – Fetches articles from TechCrunch’s AI section.
  - `theverge` – Fetches articles from The Verge’s AI section.
  - `venturebeat` – Fetches articles from VentureBeat’s AI section.
  - `zdnet` – Fetches articles from ZDNet’s AI section.
  - `sciencedaily` – Fetches articles from ScienceDaily’s AI section.
  - `unite` – Fetches articles from Unite.AI.

#### Response

Returns a JSON array of articles, each containing the article title, URL, and source.

##### Example Response:

```json
[
  {
    "title": "AI breakthrough in ML algorithms",
    "url": "https://techcrunch.com/ai-ml-breakthrough",
    "source": "techcrunch"
  },
  {
    "title": "Latest trends in artificial intelligence",
    "url": "https://theverge.com/ai-trends",
    "source": "theverge"
  }
]
```

#### Example Request:

```bash
GET https://your-api-url.com/news/techcrunch
```

---

## Valid Parameters

### Path Parameters

- **newspaperId**: A string representing the source from which you want to retrieve articles. The valid values are:
  - `techcrunch`
  - `theverge`
  - `venturebeat`
  - `zdnet`
  - `sciencedaily`
  - `unite`

These values represent the news sources you can filter articles from.

### Query Parameters

Currently, the API does not accept any query parameters.

---

## Example Requests

### 1. Get all AI news articles from all sources:

```bash
GET https://ai-newsapi-e6bc67c3e98b.herokuapp.com/news
```

### 2. Get AI news articles from TechCrunch:

```bash
GET https://ai-newsapi-e6bc67c3e98b.herokuapp.com/news/techcrunch
```

### 3. Get AI news articles from The Verge:

```bash
GET https://ai-newsapi-e6bc67c3e98b.herokuapp.com/news/theverge
```

---

## Error Handling

The API returns standard HTTP status codes:

- **200 OK**: The request was successful, and the response contains the data.
- **400 Bad Request**: The **newspaperId** parameter provided is invalid or not supported.
- **500 Internal Server Error**: Something went wrong on the server side.

For example, if you provide an invalid `newspaperId`, the API will return:

```json
{
  "error": "Invalid newspaperId provided"
}
```

---

## Technologies Used

- **Java**: Used for the backend logic and web scraping.
- **Spring Boot**: Framework for building the API with robust support for creating RESTful web services.
- **PostgreSQL**: Used for persisting data, although currently, the API scrapes data dynamically.
- **JSoup**: Used for scraping and parsing HTML content from the target websites.

---

## Contact

If you have any questions or suggestions, feel free to contact me!

Email: nehemiahl.chandler@gmail.com
LinkedIn: https://www.linkedin.com/in/nehemiah-chandler-6b607a245/

---

Feel free to use and contribute to this project. I'm always open to suggestions and collaborations to improve the API and add new features!

