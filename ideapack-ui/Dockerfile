FROM node:alpine as builder

RUN mkdir -p /app
WORKDIR /app
COPY package.json ./
RUN npm install
RUN npm audit fix
COPY . /app
RUN npm run build --prod --output-path=dist

FROM nginx:1.14.1-alpine
RUN rm -rf /usr/share/nginx/html/*
COPY nginx-default.conf /etc/nginx/conf.d/
COPY --from=builder /app/dist/ideapack-ui /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
