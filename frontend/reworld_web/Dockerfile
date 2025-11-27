FROM node:22-alpine

WORKDIR /reworld_web
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run dev