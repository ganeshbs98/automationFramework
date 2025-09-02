#!/bin/bash

echo "=== Android Test Setup Verification ==="
echo ""

# Check if Java is installed
echo "1. Checking Java installation..."
if command -v java &> /dev/null; then
    java_version=$(java -version 2>&1 | head -n 1)
    echo "✓ Java is installed: $java_version"
else
    echo "✗ Java is not installed"
fi

# Check if Maven is installed
echo ""
echo "2. Checking Maven installation..."
if command -v mvn &> /dev/null; then
    mvn_version=$(mvn -version 2>&1 | head -n 1)
    echo "✓ Maven is installed: $mvn_version"
else
    echo "✗ Maven is not installed"
fi

# Check if Node.js is installed
echo ""
echo "3. Checking Node.js installation..."
if command -v node &> /dev/null; then
    node_version=$(node --version)
    echo "✓ Node.js is installed: $node_version"
else
    echo "✗ Node.js is not installed"
fi

# Check if Appium is installed
echo ""
echo "4. Checking Appium installation..."
if command -v appium &> /dev/null; then
    appium_version=$(appium --version)
    echo "✓ Appium is installed: $appium_version"
else
    echo "✗ Appium is not installed"
    echo "  Install with: npm install -g appium"
fi

# Check if Android SDK tools are available
echo ""
echo "5. Checking Android SDK tools..."
if command -v adb &> /dev/null; then
    echo "✓ ADB is available"
    echo "  Connected devices:"
    adb devices
else
    echo "✗ ADB is not available"
    echo "  Make sure Android SDK is installed and PATH is set"
fi

# Check if Appium server is running
echo ""
echo "6. Checking if Appium server is running..."
if curl -s http://127.0.0.1:4723/status > /dev/null; then
    echo "✓ Appium server is running on http://127.0.0.1:4723"
else
    echo "✗ Appium server is not running"
    echo "  Start with: appium --base-path /wd/hub"
fi

echo ""
echo "=== Setup verification completed ===" 