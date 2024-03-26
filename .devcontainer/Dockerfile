FROM mcr.microsoft.com/vscode/devcontainers/base:0-focal

# Install sdkman and Java
RUN apt-get update && export DEBIAN_FRONTEND=noninteractive && \
    apt-get -y install curl zip unzip && \
    curl -s "https://get.sdkman.io" | bash && \
    bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 17.0.2-tem"
