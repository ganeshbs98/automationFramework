#!/bin/bash

echo "Starting Appium Server..."
echo "Make sure you have Node.js and Appium installed"

# Check if Appium is installed
if ! command -v appium &> /dev/null; then
    echo "Appium is not installed. Installing Appium..."
    npm install -g appium
fi

# Start Appium server
echo "Starting Appium server on http://127.0.0.1:4723"
appium --base-path /wd/hub

echo "Appium server started successfully!"
echo "You can now run your Android tests" 