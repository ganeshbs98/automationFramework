package com.ui.PojoClasses;

import org.openqa.selenium.Dimension;
import org.testng.ITestContext;

import java.io.File;

public class TestEnv {

    //instance varibale of api
    private String testType;
    private String apiURI;
    private String apiEnvType;
    private String apiAppSycURI;
    private String apiAppSycAuth;
    private String apiVersion;
    private String appType;
    private String apiPartnerURI;


    private String apiLocale;
    private String apiRegion;
    private String apiStore;
    private String apiHost;
    private String apiToken;
    private String apiAccessToken;
    private String apiCountry;
    private String apiCurrency;
    private String apiTimeZone;
    private String apiPhoneNumber;
    private String apiEmailID;


    private String webSystemOS;
    private String webSystemOSVersion;
    private String webBrowser;

    private String hubIP;
    private String webHeadless;
    private String webBrowserVersion;
    private String webUrl;
    private String webBuildNumber;
    private Boolean webNetworkLogs;

    private String app_reset;
    private String random_device;
    private String androidAppPackage;
    private String androidAppActivity;
    private String androidDevice;
    private String androidOSVersion;
    private String androidBSAppPath;
    private String androidBuildNumber;

    private String iosBundleId;
    private String iosUDID;
    private String iosDevice;
    private String iosOSVersion;
    private String iosBSAppPath;
    private String iosBuildNumber;

    // Data belongs to remote-env.json
    private String execution_type;

    private String grid_execution_local;
    private String jenkins_execution;
    private String pipeline_execution;
    private String test_region;

    private String email_recipients;
    private String error_email_recipients;
    private String failure_email_recipients;

    // common variables

    private String excelFilePath;
    private String jsonFilePath;
    private String jsonDirectory;
    private String elementLocator;
    private String appiumURL;

//    private File pagesJsonFile;
    private String currentTestMethodName;
    private ITestContext context;
    private String currentTestClassName;
    private String currentTestName;
//    private File screenshotPath;
    private String browserstack_execution_local;
    private String browserstack_midSessionInstallApps;
    private String isJWT;
    private String endpointPrefix;
    private String productName;
    private String gps_location;
    private String authorization;
    private String initialSelfHeal;


    private String franchiseId;
    private String dbType;
    private String serviceType;
    private String moduleNames;
    private String networkProfile;
    private String customNetwork;
    private String healingMatchScore;
    private String healingToggle;
    private String unblockToken;
    private String device_location;
    private Dimension device_dimension;
    private String midSessionBuildNo;
    private String mailUserName;
    private String mailPassword;

    private String geoLocation;
    private String sessionLaunchLevel;

    private String QA_TOUCH_testRunid;
    private String QA_TOUCH_projectKey;
    private boolean isQATouch_Enable;

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getApiURI() {
        return apiURI;
    }

    public void setApiURI(String apiURI) {
        this.apiURI = apiURI;
    }

    public String getApiEnvType() {
        return apiEnvType;
    }

    public void setApiEnvType(String apiEnvType) {
        this.apiEnvType = apiEnvType;
    }

    public String getApiAppSycURI() {
        return apiAppSycURI;
    }

    public void setApiAppSycURI(String apiAppSycURI) {
        this.apiAppSycURI = apiAppSycURI;
    }

    public String getApiAppSycAuth() {
        return apiAppSycAuth;
    }

    public void setApiAppSycAuth(String apiAppSycAuth) {
        this.apiAppSycAuth = apiAppSycAuth;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public String getApiPartnerURI() {
        return apiPartnerURI;
    }

    public void setApiPartnerURI(String apiPartnerURI) {
        this.apiPartnerURI = apiPartnerURI;
    }

    public String getApiLocale() {
        return apiLocale;
    }

    public void setApiLocale(String apiLocale) {
        this.apiLocale = apiLocale;
    }

    public String getApiRegion() {
        return apiRegion;
    }

    public void setApiRegion(String apiRegion) {
        this.apiRegion = apiRegion;
    }

    public String getApiStore() {
        return apiStore;
    }

    public void setApiStore(String apiStore) {
        this.apiStore = apiStore;
    }

    public String getApiHost() {
        return apiHost;
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiAccessToken() {
        return apiAccessToken;
    }

    public void setApiAccessToken(String apiAccessToken) {
        this.apiAccessToken = apiAccessToken;
    }

    public String getApiCountry() {
        return apiCountry;
    }

    public void setApiCountry(String apiCountry) {
        this.apiCountry = apiCountry;
    }

    public String getApiCurrency() {
        return apiCurrency;
    }

    public void setApiCurrency(String apiCurrency) {
        this.apiCurrency = apiCurrency;
    }

    public String getApiTimeZone() {
        return apiTimeZone;
    }

    public void setApiTimeZone(String apiTimeZone) {
        this.apiTimeZone = apiTimeZone;
    }

    public String getApiPhoneNumber() {
        return apiPhoneNumber;
    }

    public void setApiPhoneNumber(String apiPhoneNumber) {
        this.apiPhoneNumber = apiPhoneNumber;
    }

    public String getApiEmailID() {
        return apiEmailID;
    }

    public void setApiEmailID(String apiEmailID) {
        this.apiEmailID = apiEmailID;
    }

    public String getWebSystemOS() {
        return webSystemOS;
    }

    public void setWebSystemOS(String webSystemOS) {
        this.webSystemOS = webSystemOS;
    }

    public String getWebSystemOSVersion() {
        return webSystemOSVersion;
    }

    public void setWebSystemOSVersion(String webSystemOSVersion) {
        this.webSystemOSVersion = webSystemOSVersion;
    }

    public String getWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(String webBrowser) {
        this.webBrowser = webBrowser;
    }

    public String getHubIP() {
        return hubIP;
    }

    public void setHubIP(String hubIP) {
        this.hubIP = hubIP;
    }

    public String getWebHeadless() {
        return webHeadless;
    }

    public void setWebHeadless(String webHeadless) {
        this.webHeadless = webHeadless;
    }

    public String getWebBrowserVersion() {
        return webBrowserVersion;
    }

    public void setWebBrowserVersion(String webBrowserVersion) {
        this.webBrowserVersion = webBrowserVersion;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebBuildNumber() {
        return webBuildNumber;
    }

    public void setWebBuildNumber(String webBuildNumber) {
        this.webBuildNumber = webBuildNumber;
    }

    public Boolean getWebNetworkLogs() {
        return webNetworkLogs;
    }

    public void setWebNetworkLogs(Boolean webNetworkLogs) {
        this.webNetworkLogs = webNetworkLogs;
    }

    public String getApp_reset() {
        return app_reset;
    }

    public void setApp_reset(String app_reset) {
        this.app_reset = app_reset;
    }

    public String getRandom_device() {
        return random_device;
    }

    public void setRandom_device(String random_device) {
        this.random_device = random_device;
    }

    public String getAndroidAppPackage() {
        return androidAppPackage;
    }

    public void setAndroidAppPackage(String androidAppPackage) {
        this.androidAppPackage = androidAppPackage;
    }

    public String getAndroidAppActivity() {
        return androidAppActivity;
    }

    public void setAndroidAppActivity(String androidAppActivity) {
        this.androidAppActivity = androidAppActivity;
    }

    public String getAndroidDevice() {
        return androidDevice;
    }

    public void setAndroidDevice(String androidDevice) {
        this.androidDevice = androidDevice;
    }

    public String getAndroidOSVersion() {
        return androidOSVersion;
    }

    public void setAndroidOSVersion(String androidOSVersion) {
        this.androidOSVersion = androidOSVersion;
    }

    public String getAndroidBSAppPath() {
        return androidBSAppPath;
    }

    public void setAndroidBSAppPath(String androidBSAppPath) {
        this.androidBSAppPath = androidBSAppPath;
    }

    public String getAndroidBuildNumber() {
        return androidBuildNumber;
    }

    public void setAndroidBuildNumber(String androidBuildNumber) {
        this.androidBuildNumber = androidBuildNumber;
    }

    public String getIosBundleId() {
        return iosBundleId;
    }

    public void setIosBundleId(String iosBundleId) {
        this.iosBundleId = iosBundleId;
    }

    public String getIosUDID() {
        return iosUDID;
    }

    public void setIosUDID(String iosUDID) {
        this.iosUDID = iosUDID;
    }

    public String getIosDevice() {
        return iosDevice;
    }

    public void setIosDevice(String iosDevice) {
        this.iosDevice = iosDevice;
    }

    public String getIosOSVersion() {
        return iosOSVersion;
    }

    public void setIosOSVersion(String iosOSVersion) {
        this.iosOSVersion = iosOSVersion;
    }

    public String getIosBSAppPath() {
        return iosBSAppPath;
    }

    public void setIosBSAppPath(String iosBSAppPath) {
        this.iosBSAppPath = iosBSAppPath;
    }

    public String getIosBuildNumber() {
        return iosBuildNumber;
    }

    public void setIosBuildNumber(String iosBuildNumber) {
        this.iosBuildNumber = iosBuildNumber;
    }

    public String getExecution_type() {
        return execution_type;
    }

    public void setExecution_type(String execution_type) {
        this.execution_type = execution_type;
    }

    public String getGrid_execution_local() {
        return grid_execution_local;
    }

    public void setGrid_execution_local(String grid_execution_local) {
        this.grid_execution_local = grid_execution_local;
    }

    public String getJenkins_execution() {
        return jenkins_execution;
    }

    public void setJenkins_execution(String jenkins_execution) {
        this.jenkins_execution = jenkins_execution;
    }

    public String getPipeline_execution() {
        return pipeline_execution;
    }

    public void setPipeline_execution(String pipeline_execution) {
        this.pipeline_execution = pipeline_execution;
    }

    public String getTest_region() {
        return test_region;
    }

    public void setTest_region(String test_region) {
        this.test_region = test_region;
    }

    public String getEmail_recipients() {
        return email_recipients;
    }

    public void setEmail_recipients(String email_recipients) {
        this.email_recipients = email_recipients;
    }

    public String getError_email_recipients() {
        return error_email_recipients;
    }

    public void setError_email_recipients(String error_email_recipients) {
        this.error_email_recipients = error_email_recipients;
    }

    public String getFailure_email_recipients() {
        return failure_email_recipients;
    }

    public void setFailure_email_recipients(String failure_email_recipients) {
        this.failure_email_recipients = failure_email_recipients;
    }



    public String getExcelFilePath() {
        return excelFilePath;
    }

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath = excelFilePath;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public String getJsonDirectory() {
        return jsonDirectory;
    }

    public void setJsonDirectory(String jsonDirectory) {
        this.jsonDirectory = jsonDirectory;
    }

    public String getElementLocator() {
        return elementLocator;
    }

    public void setElementLocator(String elementLocator) {
        this.elementLocator = elementLocator;
    }

    public String getAppiumURL() {
        return appiumURL;
    }

    public void setAppiumURL(String appiumURL) {
        this.appiumURL = appiumURL;
    }



    public String getCurrentTestMethodName() {
        return currentTestMethodName;
    }

    public void setCurrentTestMethodName(String currentTestMethodName) {
        this.currentTestMethodName = currentTestMethodName;
    }

    public ITestContext getContext() {
        return context;
    }

    public void setContext(ITestContext context) {
        this.context = context;
    }

    public String getCurrentTestClassName() {
        return currentTestClassName;
    }

    public void setCurrentTestClassName(String currentTestClassName) {
        this.currentTestClassName = currentTestClassName;
    }

    public String getCurrentTestName() {
        return currentTestName;
    }

    public void setCurrentTestName(String currentTestName) {
        this.currentTestName = currentTestName;
    }



    public String getBrowserstack_execution_local() {
        return browserstack_execution_local;
    }

    public void setBrowserstack_execution_local(String browserstack_execution_local) {
        this.browserstack_execution_local = browserstack_execution_local;
    }

    public String getBrowserstack_midSessionInstallApps() {
        return browserstack_midSessionInstallApps;
    }

    public void setBrowserstack_midSessionInstallApps(String browserstack_midSessionInstallApps) {
        this.browserstack_midSessionInstallApps = browserstack_midSessionInstallApps;
    }

    public String getIsJWT() {
        return isJWT;
    }

    public void setIsJWT(String isJWT) {
        this.isJWT = isJWT;
    }

    public String getEndpointPrefix() {
        return endpointPrefix;
    }

    public void setEndpointPrefix(String endpointPrefix) {
        this.endpointPrefix = endpointPrefix;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGps_location() {
        return gps_location;
    }

    public void setGps_location(String gps_location) {
        this.gps_location = gps_location;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getInitialSelfHeal() {
        return initialSelfHeal;
    }

    public void setInitialSelfHeal(String initialSelfHeal) {
        this.initialSelfHeal = initialSelfHeal;
    }

    public String getFranchiseId() {
        return franchiseId;
    }

    public void setFranchiseId(String franchiseId) {
        this.franchiseId = franchiseId;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getModuleNames() {
        return moduleNames;
    }

    public void setModuleNames(String moduleNames) {
        this.moduleNames = moduleNames;
    }

    public String getNetworkProfile() {
        return networkProfile;
    }

    public void setNetworkProfile(String networkProfile) {
        this.networkProfile = networkProfile;
    }

    public String getCustomNetwork() {
        return customNetwork;
    }

    public void setCustomNetwork(String customNetwork) {
        this.customNetwork = customNetwork;
    }

    public String getHealingMatchScore() {
        return healingMatchScore;
    }

    public void setHealingMatchScore(String healingMatchScore) {
        this.healingMatchScore = healingMatchScore;
    }

    public String getHealingToggle() {
        return healingToggle;
    }

    public void setHealingToggle(String healingToggle) {
        this.healingToggle = healingToggle;
    }

    public String getUnblockToken() {
        return unblockToken;
    }

    public void setUnblockToken(String unblockToken) {
        this.unblockToken = unblockToken;
    }

    public String getDevice_location() {
        return device_location;
    }

    public void setDevice_location(String device_location) {
        this.device_location = device_location;
    }

    public Dimension getDevice_dimension() {
        return device_dimension;
    }

    public void setDevice_dimension(Dimension device_dimension) {
        this.device_dimension = device_dimension;
    }

    public String getMidSessionBuildNo() {
        return midSessionBuildNo;
    }

    public void setMidSessionBuildNo(String midSessionBuildNo) {
        this.midSessionBuildNo = midSessionBuildNo;
    }

    public String getMailUserName() {
        return mailUserName;
    }

    public void setMailUserName(String mailUserName) {
        this.mailUserName = mailUserName;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public String getSessionLaunchLevel() {
        return sessionLaunchLevel;
    }

    public void setSessionLaunchLevel(String sessionLaunchLevel) {
        this.sessionLaunchLevel = sessionLaunchLevel;
    }

}
