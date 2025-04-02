FROM mcr.microsoft.com/vscode/devcontainers/base:ubuntu

# Install dependencies and AWS CLI
RUN apt-get update && apt-get install -y curl unzip \
    && curl -fsSL https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip \
    && unzip awscliv2.zip \
    && ./aws/install