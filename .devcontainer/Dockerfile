FROM mcr.microsoft.com/vscode/devcontainers/base:ubuntu

# Install base dependencies and AWS CLI
RUN apt-get update && apt-get install -y curl unzip \
    && curl -fsSL https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip -o awscliv2.zip \
    && unzip awscliv2.zip \
    && ./aws/install

# Install Java and Maven
RUN apt-get install -y openjdk-17-jdk maven && \
    echo "export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64" >> /etc/profile.d/java.sh

# Install Go
RUN curl -LO https://go.dev/dl/go1.21.4.linux-amd64.tar.gz && \
    tar -C /usr/local -xzf go1.21.4.linux-amd64.tar.gz && \
    rm go1.21.4.linux-amd64.tar.gz && \
    echo "export PATH=\$PATH:/usr/local/go/bin" >> /etc/profile.d/go.sh && \
    echo "export GOPATH=\$HOME/go" >> /etc/profile.d/go.sh && \
    echo "export GOROOT=/usr/local/go" >> /etc/profile.d/go.sh

# Environment variables
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64 \
    PATH=$PATH:/usr/local/go/bin \
    GOPATH=$HOME/go \
    GOROOT=/usr/local/go