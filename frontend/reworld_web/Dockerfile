FROM node:22-alpine

WORKDIR /reworld_web

# Copy package.json and install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the source code
COPY . .

# Expose the dev server port
EXPOSE 10010

# Start the dev server when the container runs
CMD ["npm", "run", "dev"]
