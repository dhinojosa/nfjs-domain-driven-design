# Use the Universal image as the base image
FROM mcr.microsoft.com/vscode/devcontainers/universal:1-focal

# Avoid warnings by switching to noninteractive
ENV DEBIAN_FRONTEND=noninteractive

# Install SDKMAN. I think it is installed already
# RUN curl -s "https://get.sdkman.io" | bash

# Install Java using SDKMAN. Ensure the shell launched is a login shell (bash -l)
RUN /bin/bash -l -c "sdk install java 17.0.2-tem"

# Switch back to dialog for any ad-hoc use of apt-get
ENV DEBIAN_FRONTEND=dialog
