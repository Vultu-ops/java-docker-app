Simple java calculator app for docker containerization.

# Java Docker Web App - Commands Cheat Sheet

## 1. Navigate to Project

```bash
cd java-docker-app
```

---

# Docker Commands

## Build Docker Image

```bash
docker build -t java-web-app .
```

## List Docker Images

```bash
docker images
```

## Run Docker Container

```bash
docker run -d -p 8080:80 --name java-web java-web-app
```

## View Running Containers

```bash
docker ps
```

## View All Containers

```bash
docker ps -a
```

## Stop Container

```bash
docker stop java-web
```

## Start Existing Container

```bash
docker start java-web
```

## Restart Container

```bash
docker restart java-web
```

## Remove Container

```bash
docker rm java-web
```

## Remove Docker Image

```bash
docker rmi java-web-app
```

## View Container Logs

```bash
docker logs java-web
```

## Execute Shell Inside Container

```bash
docker exec -it java-web sh
```

---

# Git Commands

## Initialize Repository

```bash
git init
```

## Check Status

```bash
git status
```

## Add Files

```bash
git add .
```

## Commit Changes

```bash
git commit -m "Initial commit"
```

## Rename Branch

```bash
git branch -M main
```

## Add Remote Repository

```bash
git remote add origin https://github.com/YOUR_USERNAME/java-web-app.git
```

## Verify Remote

```bash
git remote -v
```

## Push to GitHub

```bash
git push -u origin main
```

## Pull Latest Changes

```bash
git pull origin main
```

## View Commit History

```bash
git log --oneline
```

---

# Useful Docker Commands

## Remove All Stopped Containers

```bash
docker container prune
```

## Remove Unused Images

```bash
docker image prune
```

## Remove Everything Unused

```bash
docker system prune
```

---

# Browser

Open:

```
http://localhost:8080
```

---

# Complete Workflow

```bash
# Build Image
docker build -t java-web-app .

# Verify Image
docker images

# Run Container
docker run -d -p 8080:80 --name java-web java-web-app

# Verify Running Container
docker ps

# View Logs
docker logs java-web

# Stop Container
docker stop java-web

# Remove Container
docker rm java-web

# Push Code to GitHub
git add .
git commit -m "Updated Java Web App"
git push
```